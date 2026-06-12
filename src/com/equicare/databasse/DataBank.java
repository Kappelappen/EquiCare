package com.equicare.databasse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBank {

    private static final String DB_FOLDER = "database";
    private static final String DB_NAME = "equicare.db";

    private Connection connection;
    private final String databaseUrl;

    public DataBank() {

        try {
        	
            Path dbFolder = Path.of(DB_FOLDER);
            if (!Files.exists(dbFolder)) {
                Files.createDirectories(dbFolder);
            }

            Path dbFile = dbFolder.resolve(DB_NAME);

            this.databaseUrl = "jdbc:sqlite:" + dbFile.toAbsolutePath();

        } catch (IOException e) {
            throw new RuntimeException("Failed to create database directory", e);
        }
    }

    public void connect() {

        try {
            if (connection == null || connection.isClosed()) {

                connection = DriverManager.getConnection(databaseUrl);

                enableForeignKeys();
                createMigrationTable();

                System.out.println("[DataBank] Connected: " + databaseUrl);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to database", e);
        }
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connect();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public void close() {

        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("[DataBank] Connection closed");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to close connection", e);
        }
    }    

    private void enableForeignKeys() throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("PRAGMA foreign_keys = ON;");
        }
    }

    private void createMigrationTable() throws SQLException {

        String sql = """
            CREATE TABLE IF NOT EXISTS schema_migrations (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                filename TEXT NOT NULL UNIQUE,
                executed_at DATETIME DEFAULT CURRENT_TIMESTAMP
            );
        """;

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        }
    }

    public void runMigrationOnce(Path sqlFile) {

        String filename = sqlFile.getFileName().toString();
        System.out.println(filename);

        if (migrationAlreadyExecuted(filename)) {
            System.out.println("[DataBank] Skipped migration: " + filename);
            return;
        }

        try {

            String sql = Files.readString(sqlFile, StandardCharsets.UTF_8);

            executeSqlStatements(sql);
            markMigrationAsExecuted(filename);

        } catch (Exception e) {
            throw new RuntimeException("Migration failed: " + filename, e);
        }
    }

    private boolean migrationAlreadyExecuted(String filename) {

        String sql = """
            SELECT 1 FROM schema_migrations
            WHERE filename = ?
            LIMIT 1;
        """;

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setString(1, filename);

            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException("Migration check failed", e);
        }
    }

    private void markMigrationAsExecuted(String filename) {

        String sql = """
            INSERT INTO schema_migrations(filename)
            VALUES (?);
        """;

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setString(1, filename);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Failed to mark migration", e);
        }
    }
    
    private void executeSqlStatements(String sql) {

        try (Statement stmt = getConnection().createStatement()) {

            for (String s : sql.split(";")) {

                String trimmed = s.trim();

                if (trimmed.isEmpty()) continue;

                try {
                    stmt.execute(trimmed);
                } catch (SQLException ex) {
                    throw ex;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("SQL execution failed", e);
        }
    }

    private List<String> splitSql(String sql) {

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (char c : sql.toCharArray()) {

            if (c == ';') {
                result.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }

        if (!sb.isEmpty()) {
            result.add(sb.toString());
        }

        return result;
    }
}