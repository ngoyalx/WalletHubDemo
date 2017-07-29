##Software required to execute the test cases.
      1. Install Java8 on your system and update path variable
      2. Install Eclipse/Intellij Idea 
      3. Install Maven on your system and update path variable
      4. Install TestNG plug-in in Eclipse or IntellijIdea
      5. Install Git SCM on your system for Git Command line
      
 ##Setup the project
 	1. Go the drive or folder in your system where you want to download the project
	2. Open the Git command line there
	3. Use command $git clone https://github.com/ngoyalx/WalletHubDemo.git
	4. This will download the project in your local system.

##How to execute test cases:
      1. Go to the project directory and locate the config.properties file.
      2. Enter your facebook username in front of facebookUserName
      3. Enter your facebook password in front of facebookPassword
      4. Save the file
      5. Open Terminal and CD to project root directory
      6. To execute all test cases as per current TestNG.xml file enter following command and click enter:
		  $ mvn clean test site
      7. Wait till the execution finishes and you see a message 'Build success' in the terminal
      
 ##How to check the reports
      1. Refresh the project directory
      2. Go to target/site/allure-maven-plugin floder
      3. Locate the index.html file
      4. Right click on the file and open in a browser
     
  ##Report details:
  	1. Overview tab will show the aggregate report
	2. Defects tab will show any test failures
	3. Xuni tab will show the indivisual test case report
	4. Clicking on the test case name will show the further details
	5. Clicking on the test step will further show the screenshot attached
	6. Clicking on the image will show the screenshot
	7. Graph will show the different statitics


