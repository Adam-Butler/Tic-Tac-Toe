cd acceptance
javac -cp .;..\build\classes\main TicTacToeKeywords.java
java -cp .;..\build\classes\main;C:\RobotFramework\swinglibrary-1.9.5.jar;C:\RobotFramework\robotframework-3.0.jar org.robotframework.RobotFramework TicTacToeGUITests.txt
cd ..