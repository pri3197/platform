-- Create Domain table
-- CREATE TABLE  domains (
--     id INTEGER PRIMARY KEY,
--     name VARCHAR(255) NOT NULL,
--     description TEXT,
--     location VARCHAR(50)
-- );

-- -- Insert sample data
-- INSERT INTO domain (id, name, description, location) VALUES 
--     (2221, 'Transportation', 'Domain for transportation data', 'NYC'),
--     (2222, 'Environment', 'Domain for environmental data', 'NYC'),
--     (2223, 'Healthcare', 'Domain for healthcare data', 'LON');

CREATE TABLE cities (
    city_id VARCHAR(255) PRIMARY KEY,
    city_name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE domains (
    domain_id VARCHAR(255) PRIMARY KEY,
    domain_name VARCHAR(255) NOT NULL,
    city_id VARCHAR(255) NOT NULL REFERENCES cities(city_id) ON DELETE CASCADE,
    standard_protocol_id UUID REFERENCES standard(standard_id),
    algorithm_id UUID REFERENCES data_release_algorithms(algorithm_id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE standard (
    standard_id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    standard_name VARCHAR(255) NOT NULL,
    description TEXT,
    version VARCHAR(50) NOT NULL,
    compliance_level VARCHAR(10) CHECK (compliance_level IN ('HIGH', 'MEDIUM', 'LOW'))   
);


CREATE TABLE data_release_algorithms (
    algorithm_id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    algorithm_name VARCHAR(255) NOT NULL,
    code_reference TEXT NOT NULL
);

INSERT INTO cities (city_id, city_name) VALUES 
    ('NYC', 'New York City'),
    ('LON', 'London'),
    ('BER', 'Berlin'),
    ('PAR', 'Paris');

INSERT INTO standard (standard_id, standard_name, description, version, compliance_level) VALUES 
    ('550e8400-e29b-41d4-a716-446655440001', 'GDPR', 'General Data Protection Regulation', '1.0', 'HIGH'),
    ('550e8400-e29b-41d4-a716-446655440002', 'ISO 27001', 'Information Security Standard', '2013', 'HIGH'),
    ('550e8400-e29b-41d4-a716-446655440003', 'Open Data Directive', 'EU Directive on Open Data', '2.0', 'MEDIUM'),
    ('550e8400-e29b-41d4-a716-446655440004', 'HIPAA', 'Health Insurance Portability and Accountability Act', '1.1', 'HIGH'),
    ('550e8400-e29b-41d4-a716-446655440005', 'COBIT', 'Control Objectives for Information Technology', '5', 'LOW');

INSERT INTO data_release_algorithms (algorithm_id, algorithm_name, code_reference) VALUES 
    ('660e8400-e29b-41d4-a716-446655440001', 'K-Anonymity', 'https://github.com/example/k-anonymity'),
    ('660e8400-e29b-41d4-a716-446655440002', 'Differential Privacy', 'https://github.com/example/differential-privacy'),
    ('660e8400-e29b-41d4-a716-446655440003', 'Data Masking', 'https://github.com/example/data-masking'),
    ('660e8400-e29b-41d4-a716-446655440004', 'Homomorphic Encryption', 'https://github.com/example/homomorphic-encryption'),
    ('660e8400-e29b-41d4-a716-446655440005', 'Synthetic Data Generation', 'https://github.com/example/synthetic-data');

INSERT INTO domains (domain_id, domain_name, city_id, standard_protocol_id, algorithm_id) VALUES 
    ('D001', 'Transportation', 'NYC', '550e8400-e29b-41d4-a716-446655440003', '660e8400-e29b-41d4-a716-446655440001'),
    ('D002', 'Healthcare', 'LON', '550e8400-e29b-41d4-a716-446655440004', '660e8400-e29b-41d4-a716-446655440002'),
    ('D003', 'Environment', 'BER', '550e8400-e29b-41d4-a716-446655440002', '660e8400-e29b-41d4-a716-446655440003'),
    ('D004', 'Public Safety', 'PAR', '550e8400-e29b-41d4-a716-446655440005', '660e8400-e29b-41d4-a716-446655440005'),
    ('D005', 'Energy', 'NYC', '550e8400-e29b-41d4-a716-446655440001', '660e8400-e29b-41d4-a716-446655440004');

CREATE TABLE users (
    user_id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    pass_word VARCHAR(255) NOT NULL,
    city_id VARCHAR(255) NOT NULL REFERENCES cities(city_id) ON DELETE CASCADE);

   ALTER TABLE USERS ADD COLUMN user_name  VARCHAR(255) NOT NULL UNIQUE;

   Select * from cities;
   ALTER TABLE USERS ADD COLUMN userStatus VARCHAR(255) NOT NULL;
    ALTER TABLE USERS ADD COLUMN userRole VARCHAR(255) NOT NULL; 

    
INSERT INTO users (user_id, pass_word, city_id, user_name, userStatus, userRole)
VALUES (gen_random_uuid(), 'secure123', 'NYC', 'John Doe', 'APPROVED', 'ROLE_ADMIN');

ALTER TABLE users
RENAME COLUMN userStatus TO user_status;

SELECT * FROM domains;