# Configuraions
![alt text](Readme%20Attachments/Capture1.PNG)
- Server port is set to: 9090
- Database: MySql, Name: email_db
- Java version: 13


# Features
### Add account
- url is /addAccount
- select form-data in Body
- add 2 key value pairs, account and image
- account is text and image is file
- input for account: name and password
{ 
"name": "Adib",
"password": "1234" 
}
-select an image file for image
- send as post request

![alt text](Readme%20Attachments/Capture2.PNG)

- Account created message will be shown

![alt text](Readme%20Attachments/Capture3.PNG)

- Images are stored using random strings

![alt text](Readme%20Attachments/Capture4.PNG)
![alt text](Readme%20Attachments/Capture5.PNG)

- Image id is mapped to Accounts

![alt text](Readme%20Attachments/Capture6.PNG)
![alt text](Readme%20Attachments/Capture7.PNG)

### Send Mail

- url is /sendMail?receiverId=5&senderId=7
- Existing receiver and sender account id must be given in parameter
- Mail must be given in body
![alt text](Readme%20Attachments/Capture8.PNG)

- Confirmation message shown
![alt text](Readme%20Attachments/Capture9.PNG)
- Error message will be shown if either receiver or sender account does not exist
![alt text](Readme%20Attachments/Capture10.PNG)

### View sent mails
- url is /sentMail?senderId=4
- Sender account id must be given in parameter
- All sent mail will be shown

![alt text](Readme%20Attachments/Capture11.PNG)

### View received mails
- url is gotMail?receiverId=4
- Receiver account id must be given in parameter
- All received mail will be shown

![alt text](Readme%20Attachments/Capture12.PNG)

- In case of no received mails, empty string will be shown

![alt text](Readme%20Attachments/Capture13.PNG)

- Mail is mapped to account  using @OneToMany annotation

![alt text](Readme%20Attachments/Capture14.PNG)