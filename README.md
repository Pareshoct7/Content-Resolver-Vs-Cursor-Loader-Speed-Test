# Contacts Import Library 

While developing my app (https://play.google.com/store/apps/details?id=jagerfield.dcm) I used both the ContentResolver and the CursorLoader to fetch contacts from the mobile. The ContentResolver is a class that provides applications access to the content model. The CursorLoader is a loader object that queries a ContentResolver for data. In my trials I noticed that the ContentResolver is much faster. This application compares the execution time of both methods in fetching contacts. 

Images of the results from the app:

<img src="https://github.com/Jagerfield/Content-Resolver-Vs-Cursor-Loader-Speed-Test/blob/master/msc/Content%20Resolver.png" width="240">

<img src="https://github.com/Jagerfield/Content-Resolver-Vs-Cursor-Loader-Speed-Test/blob/master/msc/Cursor%20Loader.png" width="240">

## Installation

1. You can either download the code for this project and from it import the "ContactsImportLib" module into your project. 
2. Or, in the app build.gradle add the following:

  a. Add JitPack repository at the end of repositories 

  ```java
  repositories {
      maven { url 'https://jitpack.io' }
  }

  ```
  b. Add the dependency
 
  ```java
  dependencies {
	        compile 'com.github.Jagerfield:Android-get-phone-book-contact-library:v2.0'
	}
  
  ```

## How to use?

1. After instaling the library, declare and instantiate an object of type "ImportContacts" class with "context" as an argument.
2. Call the getContacts() method to get all the contacts.

```java
/**
 * Declare and instantiate an object of the "ImportContacts" class
 */
  ImportContacts importContacts = new ImportContacts(context);

/**
 * Fetch mobile contacts list
 */
   ArrayList<Contact> listItem = importContacts.getContacts();
```

## Available Contact elements:

```
1. Name: 
  a. Displaydname
  b. Firstname
  c. Lastname
2. Nickname: 
  a. Nickname
  b. Nicknametype
3. Number: 
  a. Number
  b. Normalizednumber
  c. Numbertype
4. Email: 
  a. Email
  b. Emaillabel
  c. Emailtype
5. Website:
  a. Website
6. Event:
  a. Eventstartdate
  b. Eventlabel
  c. Eventtype
7. Note:
  a. Note
8. Address:
  a. Address
  b. Addresstype
  
```

## UML Diagram

This is a general diagram of the software architectural design, and it only includes the numbers elements for clarity. 

<img src="https://github.com/Jagerfield/Android-get-phone-book-contact-library/blob/master/ContactLib_UML.PNG" width="520">
