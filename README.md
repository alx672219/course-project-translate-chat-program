# How to run this project (for Milestone 4)
This README file will contain instructions on how to run our project specifically for Milestone 4.
For Milestone 4, we were not able to integrate our UI in time. However, each use case's separate UI exists on its own. You will need to run 4 different files to see the 4 different UIs.

## AudioMessageAndTranslate.java
When this file is run, you will be able to see the present UI for the use case that concerns the recording of audio messages, and translating of messages.

- Run the file
- A window should open up, consisting of a text field, a button, and a label.
  - The button is the record button. You press it once to start recording. If you want to stop recording, press it again. Note that the audio will stop recording automatically once 15 seconds has elapsed. The audio will then be converted to text and displayed in the text field.
  - The label tells you the time in seconds you have been recording for. Due to the Google Cloud API we are using, you will have to keep your message 15 seconds long or shorter. 
  - The text field will contain the text version of what you recorded.
- Some more features:
  - If you click on the text field (right click or left click, both work) a new window will open up with the text translated to French

- What we'll need to change by Milestone 5
  - Incorporate this UI with the rest
  - Have the messages be translated to the language that the user has in their profile, not just French
  - Get rid of the label that tells you how much time has elapsed
  - Have AudioMessageAndTranslate extend JPanel instead of JFrame

## ChatScreen.java
- Run the file
- A window should open up with a label, a text field and a button. 
- Enter any name you want in the text field. Press the "Enter Chat Server" button
- A new window should open up with a text field and a button on the top and on the bottom of the window and a blank area in the middle
  - The text field at the bottom is where you type in messages
  - The button at the bottom is to send messages. When this is pressed the message is added to the database at a specific chatID (for now this ID is 3). A message is also added to the UI.
  - You can keep on sending more messages and more will be added to the UI and database.
  - Once a message is added to the text area in the middle, you can right click on that message and a popup menu will open up with two actions: "Edit" and "Delete"
  - If you click the edit action a new window will open up with a text field and a button. Type in the text wou want to change the message to and then click the Edit button. This change will be reflected in the database and the UI.
  - If you click the delete action, the message will be deleted from the database. But this will not be reflected in the UI (we will try to do this by Milestone 5)
  - Back to the main Chat screen, the text field and button at the top of the screen are for searching messages. If you type in the text you want to search and then click the button, a new window will open up displaying the results. To test this out, send a few messages through the UI and then search those messages. Note the search query must be more than 5 characters.

- What we'll need to change by Milestone 5:
  - Incorporate this UI with the rest
  - Get rid of the "Enter Chat Server" screen. The username should be the one that the user has in their profile
  - Make it so that these messages will be added to the database at the correct chatID, depending on which contact you're chatting with
  - Pre-populate the message area in the middle with the messages that exist in the database at that specific chatID
  - Get the UI working for the Delete Message use case
  - Have ChatScreen extend JPanel

## ContactScreen.java
- Run the file
- A window should open up with a table of user IDs. These are the IDs of the current contacts a user has. Right now, this is for the user with ID 1.
- At the bottom, there is a text field with "Add" and "Delete" buttons.
- If you type in a user ID (needs to be a number) and click "Add", a new contact will be added to this user in the Database, and this change will also be reflected in the UI. The next time you run this file, this new contact will still be there in the table.
- If you select a row and then click "Delete" that row of the table will be deleted (We will reflect this change in the database for Milestone 5)

- What we'll need to change by Milestone 5:
  - Incorporate this UI with the rest
  - Add some checks so a message dialog opens up when something goes wrong (eg. you click "Add" without typing anything in the field, you click "Delete" wihtout selecting a row, etc.)
  - Have it so this doesn't show the contacts of a specific user. Instead it should update the database for the user that is running the program.
  - Have the delete button also update the database.
  - Have ContactScreen extend JPanel instead of JFrame

## Main.java
- Run the file
- A window opens up with four text fields.
- Each text field is for information the program needs to register a user.
- There is also a dropdown menu to select a default language
- Once you've filled everything, you can click "Register" for this new user to be added to the database
- You can now click "Login" to switch to the Login screen
- You can fill in the username and password that you gave when you registered and then click Login. A message dialog will open up infomring you that either the user doesn't exist, the password is incorrect, or if the login was successful
- If you stop and run this file again, and then immediate switch to the login screen, you will note that the information you registered with in the first run was saved correctly and you can still successfully log in.

- What we'll need to change by Milestone 5
  - Incorporate this UI with the rest
  - Namely, have it so that when you click the "Login" button at the Login screen, you are taken to a "Home Screen", that has the other screens (eg. ChatScreen, ContactScreen, etc) incorporated into it

This concludes the instructions you need to run this program.

## Package Structure
- All our use cases are organized into their own packages. However:
  - The controllers and presenters of each use case are in the "views" package
  - The gateway implementations for each use case are in their own "gateways" package
  - There is also an "entities" package that contains all the entities
  - There is also a "shared" package that contains the Response superclass. All repsonse models for the use cases are subclasses of this.
