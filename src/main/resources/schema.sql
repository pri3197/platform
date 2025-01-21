-- Create Domain table
CREATE TABLE  domains (
    id INTEGER PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    location VARCHAR(50)
);

-- Insert sample data
INSERT INTO domain (id, name, description, location) VALUES 
    (2221, 'Transportation', 'Domain for transportation data', 'NYC'),
    (2222, 'Environment', 'Domain for environmental data', 'NYC'),
    (2223, 'Healthcare', 'Domain for healthcare data', 'LON');

-- Sample queries you can use:
-- SELECT * FROM domain;
-- SELECT * FROM domain WHERE location = 'NYC';
-- SELECT name, description FROM domain WHERE id = 2221; 