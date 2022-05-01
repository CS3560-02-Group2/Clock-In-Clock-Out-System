# Clock-In-Clock-Out-System
Created by:
  Kennedy Janto,
  Taylor Vandenberg,
  Duc Nguyen,
  Alex Gomez,
  Janista Gitbumrungsin
![image](https://user-images.githubusercontent.com/90990157/166167289-4d0724dd-06ec-4802-9d25-f1aafb640c76.png)

This is a semester long project for the class CS3560 - Object-Oriented Design and Programming, Spring 2022 taught by Professor Tannaz Rezaei Damavandi at Cal Poly Pomona

The project uses knowledge of mySQL databases, GUI, java progamming, OOP.

System Capabilities:
  1. Clock in / Clock out
  2. Take breaks / end breaks
  3. Add Employee
  4. Edit Employee
  5. Delete Employee
  6. Add Shift
  7. Edit Shift
  8. DeleteShift

Requirements to run program:
  1. Clone or fork latest version from Github
  2. Have mySQL and java installed
  3. Create local database and run the two SQL scripts (make_database.sql populate_tables.sql)
  4. Set up connection from program to local database
  5. Run program from the TimeClockMain.java file
  6. Make sure getFromDatabase.java file has correct url, username, password to your local database 

Runthrough of system:

When the system starts, there will be a graphical window that pops up allowing an employee to log in. Enter employeeID to log in.
![image](https://user-images.githubusercontent.com/90990157/166167158-247403f5-d19e-4a9b-a104-3b4bae959916.png)
                                 
Once logged in, there will be 4 buttons to click shown below each functioning as stated.
![image](https://user-images.githubusercontent.com/90990157/166167250-7d6b1567-26e9-4712-9026-0099bdd515f7.png)

If a manager logged in, they can click on the drop down menu from ManagerTools to access ManagerWindow
![image](https://user-images.githubusercontent.com/90990157/166167352-7162307d-4016-4062-ae87-69c31293afe2.png)

Here, you can add, edit, or delete employees and shifts. If nothing is loaded in the tables, click refresh to load them in.
![image](https://user-images.githubusercontent.com/90990157/166167390-e966c47a-2afe-4c90-b65c-9602c485d45a.png)

Click logout to log out of account or click the top right X button to exit whole program.



