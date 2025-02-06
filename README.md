This is a data sharing platform for smart cities to share domain specific algorithms, protocols, etc. 
It has cities, standard, domains, data_release_algorithms and users table in postgres db.
The project uses Apache Tomcat as server and Maven to build the project.
It uses JJWT token for Spring security.
It uses Hibernate to connect with the db.
There are three kind of users ROLE_ADMIN, ROLE_USER, ROLE__MODERATOR. Admin approves the user, only then the registration of the new User is successful.
A city can have multiple users, a user is an owner of a standard or algorithm. The requester needs to request for the standard, the requester receives the request and then approves/ denies it.
