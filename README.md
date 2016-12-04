# Skitter
A web application made on a micro service architecture. 

Current dependencies: Maven, Mysql, and Java. 

HTML for the java application is located at: "Skitter/src/main/resources".  These will be .jsp files.

To set the application up you need to first have mysql installed.  Then run the db.sql script found in resources.  Next alter the application.properties to reflect the account you created on mysql.  Finally run "mvn jetty:run".     

For each feature you plan on adding please create a seperate feature branch with "git branch {name}".  After you complete some work run "git add ." and "git commit -m "{your commit message here"}".  After this run "git push origin {branch name}" and create a pull request on Github.  Finally we can review the code and merge with master.
