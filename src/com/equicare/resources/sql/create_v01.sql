
CREATE TABLE horses (

    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    breed TEXT,
    gender TEXT,
    birth_date DATE,
    color TEXT,
    height TEXT,
    weight TEXT,
    status TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP

);

CREATE TABLE identification (

    id INTEGER PRIMARY KEY AUTOINCREMENT,
    horse_id INTEGER NOT NULL,
    chip_number TEXT,
    passport_number TEXT,
    registration_number TEXT,
    insurance_number TEXT,
    image_path TEXT,

    FOREIGN KEY (horse_id)
    REFERENCES horses(id)
    ON DELETE CASCADE

);

CREATE TABLE stable (

    id INTEGER PRIMARY KEY AUTOINCREMENT,
    horse_id INTEGER NOT NULL,
    stable_name TEXT,
    stable_box TEXT,
    arrival_date TEXT,
    owner TEXT,
    emergency_contact TEXT,
    
    FOREIGN KEY (horse_id)
    REFERENCES horses(id)
    ON DELETE CASCADE

);

CREATE TABLE health (

    id INTEGER PRIMARY KEY AUTOINCREMENT,
    horse_id INTEGER NOT NULL,
    veterinarian TEXT,
    allergies TEXT,
    medical_conditions TEXT,
    vaccination_status TEXT,
    last_checkup TEXT,

    FOREIGN KEY (horse_id)
    REFERENCES horses(id)
    ON DELETE CASCADE

);

CREATE TABLE feeding (

    id INTEGER PRIMARY KEY AUTOINCREMENT,
    horse_id INTEGER NOT NULL,
    feed_type TEXT,
    daily_amount TEXT,
    supplements TEXT,
    feeding_notes TEXT,

    FOREIGN KEY (horse_id)
    REFERENCES horses(id)
    ON DELETE CASCADE

);

CREATE TABLE training (

    id INTEGER PRIMARY KEY AUTOINCREMENT,
    horse_id INTEGER NOT NULL,
    location TEXT,
    discipline TEXT,
    activity_level TEXT,
    trainer TEXT,
    
    FOREIGN KEY (horse_id)
    REFERENCES horses(id)
    ON DELETE CASCADE

);

CREATE TABLE comments (

    id INTEGER PRIMARY KEY AUTOINCREMENT,
    horse_id INTEGER NOT NULL,
    content TEXT,
    
    FOREIGN KEY (horse_id)
    REFERENCES horses(id)
    ON DELETE CASCADE

);

CREATE TABLE categories (

    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
    
);


CREATE TABLE journal (
    
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    horse_id INTEGER NOT NULL,  
    date TEXT,
    category TEXT,
    headline TEXT,
    notes TEXT,

    FOREIGN KEY (horse_id)
    REFERENCES horses(id)

);