# How to run this project (for Milestone 5)
This README file will contain instructions on how to run our project specifically for Milestone 5. We will also include, near the end, how we applied the feedback we got from Milestone 4.

## Main.java
You will have to run this file to get the program running. Instructions are as follows:
- Run the file

**Register/Login Screen:**

- A window should open up prompting you to register. Fill in the details, click "Sign up" and you will have created a new account. This change will be reflected in the database as well. You'll be given a message dialog if:
  - Passwords don't match
  - Username is already in use
  - Any text field is blank
- Switch to the Login Screen by clicking "Login". Fill in the details of your account and click "Login" again to navigate to the Home Screen. You'll be shown a message dialog if:
  - Either of the two fields are blank
  - User with that username doesn't exist
  - Password is incorrect

**Home Screen:**

On the Home Screen, you can:
- Log out: By clicking the "Log out" button you will be navigated back to the Login Screen where you can fill in another account's details and log in again.
- Customize: By clicking the "Customize" button, a new window will open up allowing you to change your username, password, or default language. This change will be reflected in the database as well. You will be shown a message dialog if:
  - The field of the detail you want to update is blank
  - For username: if the usrname is already taken
  - For password: if the password is less than 7 characters
- Add [contact]: By clicking the Add button near the bottom of the screen, you will be able to add a new contact. You have to type in a number in the "User ID" text field and then click the button. You will be shown a message dialog if:
  - The User ID text field is blank
  - If the text in the field is not an integer
  - You wrote your own user ID (see label at top of the screen) in the field
  - You wrote a user ID which doesn't have a corresponding user
  - You wrote a user ID of a user who is already your contact
- If a contact is added successfully, you are also added as your contact's contact. This change will be reflected in the database as well.
- Delete [contact]: By clicking the Delete button near the bottom of the screen, you will be able to delete a contact. You have to select a row in the contact list above and then click the button to delete. You will be shown a message dialog if:
  - You haven't selected a row
 - Once a contact is deleted successfully, you are also deleted from the contacts list of that contact. This change will be reflected in the database as well.
 - Open Chat: By clicking this button, a new Chat Screen will open up showing you the chat you have with the contact you selected. You will be shown a message dialog if:
  - You haven't selected a row

**Chat Screen:**

On the Chat Screen, you can:
- At the bottom of the screen, you can type some text in the field and click "Send Message" to send a message in the chat.
- Alternatively, you can click "Record" and say something in the default language that you chose. This audio will be converted to text and this text will be inserted into the text field. This change will be reflected in the database as well.
- In the centre of the screen, there should be a list of messages that are in this chat. This part of the screen will be blank if this is a new chat and there are no messages in it.
- By left-clicking on a message, a new window will open up with a translation of your message to your default language.
- By right-clicking on a message a popup menu will open up that allows you to either edit or delete the message. Note that this is only possible for messages that you sent, and not for messages that your contact sent.
  - Edit: By clicking "Edit" in the popup menu, a new window will open up allowing you to edit the message. In this window, you write the text you want the message to be eidted to in the text field, and click "Edit" to edit the said mesage. This change will be reflected in the database as well.
  - Delete: By clicking "Delete" in the popup menu, you will have deleted this message and it will be removed from the Chat Screen. This change will be reflected in the database as well.
- At the top of the screen, you will be able to search for messages. Write the text you want to search for in the field and click "Search". A new window will open up showing you the results. A message dialog will open up if:
  - The search query is five characters or less
  - The search query is blank (empty or just whitespace)
  - No messages match the query

_Note: In order to get the most out of this program, we recommend making two accounts, having them be contacts of one another, and populating the chat those accounts have with messages so you can test all the functionality._

## How we applied Milestone 4 feedback:
- Functionality
  - We've integrated all of the UI together and made sure everything still works as intended
- Pull Requests:
  - Edited the PRs so that they are more detailed (eg. What the changes do?, What their roles are?, etc.)
- Code Organization:
  - Broke up the views package and now have all the controllers and all the presenters in their own packages. See PR #78.
- Testing:
  - Added more tests so code coverage is increased
  - Added documentation to tests
- Code Style and Documentation:
  - Removed a lot of warnings in the code (main and test)
  - Added more comments in harder-to-understand parts of the code
  - Added more Javadocs
- Use of Github features:
  - Added a PR template and used this template for newer PRs
- Design Patterns & Code Smells:
  - Added logic to some entities (addContact and removeContact in User, addMessage and removeMessage in Chat)
  - Added 2 more Design Patterns: Singleton and State. See PR #80.
  - Cleaned up a lot of dead code (when getting rid of warnings)
- Clean Architcture:
  - Added logic to the entities (See above)

