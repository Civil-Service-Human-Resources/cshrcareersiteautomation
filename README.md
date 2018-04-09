This is a Serenity BDD test framework for Cshr Career site

Clone the repository

For Chrome, make sure to have the Chrome driver in system path(brew install chromedriver). 
Run using maven the command below - 
mvn verify -Dproperties=serenity.properties

For Firefox, make sure the Gecko driver is installed (brew install geckodriver). 
Run tests using maven the command below - 
mvn verify -Dproperties=serenity_ff.properties

