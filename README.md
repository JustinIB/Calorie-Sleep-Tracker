# Calorie-Sleep-Tracker
Project Name: LifeGram

Team Name: Architechts

Team Members:
Justin Breaux
Vatsal Patel

Short Description:
This application is a calorie and sleep tracker with a GUI.
When running this program you will be welcomed to a home screen with the title "LifeGram" on the top and two buttons in the middle of the screen. The left button is the applications calorie tracker and the right is the sleep tracker.

Bug:
Having trouble implementing model class because it was bugging the controllers and data.

All required data has been provided within this repository.

Calorie Tracker Button
----------------------
When clicking on the calorie tracker button the user will be welcomed to a screen that has a list of food items on the top. When clicking the food item, the user specific item will be highlighted, click the green "Add" button that is directly
below the listView of food items. After the user has added an item that item will be transfered to the now populated list on the bottom of the screen. This list is what the user is tracking. Below the list is the total amount of calories
the user has inputted. If the user inputted the wrong food item the user has to click on the item in the users populated list and click the red "Remove" button on the bottom of the list. The item that is now removed should leave the 
users list and also subtract from the total amount of calories. On the buttom of the screen there is a white "reset" button. When clicked it removes all the entities inside the users list and returns a 0 for the total amount of calories.
On the bottom right of the interface the user can locate a "home" button which returns the user back to the main screen.

Sleep Tracker Button
----------------------
When clicking on the sleep tracker button the user will be welcomed to a simple GUI layout. On the top there is a textField that is used by typing the amount of hours the user spent sleeping. Clicking the green "Add" button will add the 
users input to the listView below the textField. Now the user can see a "Day 1: *userInput* hrs". As soon as the user inputs an amount of hours slept a label is updated to calculate the average sleep time within that week for the user.
Once the user exceeds seven days on the listView it removes all inputs from the listView and returns a Weekly average on the bttom of the screen. This way the user can easily keep track of the average amount of hours slept weekly. There
are two white "Reset" buttons on this screen. The top reset button clears the "Day" listView and the bottom reset button clears the "Weekly" listView. On the bottom right of the interface the user can locate a "home" button which returns
the user back to the main screen.

When the user closes the application the data is saved into a .txt file. The user can reopen the application and still input new food into the existing list and input the amount of sleep the user has had that day to an existing list of
hours slept each day.
 
Cloning a repository
----------------------
To clone this repository or any repository on GitHub.com you will need to go to the main page of the repository and locate the green "Code" button above the list of files. From there you can choose the multiple download options Github offers.
"You can clone a repository from GitHub.com to your local computer to make it easier to fix merge conflicts, add or remove files, and push larger commits. When you clone a repository, you copy the repository from GitHub.com to your 
local machine. Cloning a repository pulls down a full copy of all the repository data that GitHub.com has at that point in time, including all versions of every file and folder for the project. You can push your changes to the remote 
repository on GitHub.com, or pull other people's changes from GitHub.com. You can clone your existing repository or clone another person's existing repository to contribute to a project."


