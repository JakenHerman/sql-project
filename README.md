 
 Used with MySQL database in Netbeans. Named the data base "nsa" and there are 3 tables, all the table's primary keys are the id column. 1st table name - "agent" - columns are - "id"-integer "Name"-varchar "AssignedSuspect"-int -- 2nd table name - "suspect" - columns are - "ID"-int "SuspectName"-varchar "Threat"-int "AssignedAgent"-int "LastSeen"-varchar(state or country) -- 3rd table name - "user" - columns are - "id"-int "username"-varchar "password"-varchar "Admin"-char (use 't' or 'f' representing true or false)
 
 
 Only thing to change should be this line 25 in class DBConnection
 DBConnection = DriverManager.getConnection(url, "root","piper93");
 
 Change this to whatever your login info is for your database in mysql.
