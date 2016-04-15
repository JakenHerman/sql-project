 
 Used with MySQL database in Netbeans. Named the data base "nsa" and there are 3 tables. 1st table - "agent" - colums - "id" "Name" "AssignedSuspect" -- 2nd table - "suspect" - columns - "ID" "SuspectName" "Threat" "AssignedAgent" "LastSeen" -- 3rd table - "user" - columns - "id" "username" "password" "Admin"
 
 
 Only thing to change should be this line 25 in class DBConnection
 DBConnection = DriverManager.getConnection(url, "root","piper93");
 
 Change this to whatever your login info is for your database in mysql.
