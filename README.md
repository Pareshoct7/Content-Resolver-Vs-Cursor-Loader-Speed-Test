# Contacts Import Library 

While developing my app [DCM](https://play.google.com/store/apps/details?id=jagerfield.dcm) I used both the ContentResolver and the CursorLoader to fetch contacts from the mobile. The ContentResolver is a class that provides applications access to the content model. The CursorLoader is a loader object that queries a ContentResolver for data. In my trials I noticed that the ContentResolver is much faster. 

This application compares the execution time of both methods in fetching contacts. It is extended from my ContactImportLib at:
https://github.com/Jagerfield/Android-get-phone-book-contact-library

Images of the results from the app:

<img src="https://github.com/Jagerfield/Content-Resolver-Vs-Cursor-Loader-Speed-Test/blob/master/msc/Content%20Resolver.png" width="240">


<img src="https://github.com/Jagerfield/Content-Resolver-Vs-Cursor-Loader-Speed-Test/blob/master/msc/Cursor%20Loader.png" width="240">

## Installation

In the app build.gradle add the following:

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
  new ImportContacts(getActivity(), new ImportContacts.ContentResolverCallback() 
  {
                @Override
                public void getMobileContacts(ArrayList<Contact> contacts) 
		{
                    contactsList = contacts;

                    if (contactsList != null) {
                        recyclerView.setAdapter(new ContactListViewAdapter(contactListFragment, contactsList));
                    }

                }
            });

/**
 * Fetch mobile contacts list
 */
   ArrayList<Contact> listItem = importContacts.getContacts();
```

## UML Diagram

This is a general diagram of the software architectural design, and it only includes the numbers elements for clarity. 

<img src="https://github.com/Jagerfield/Android-get-phone-book-contact-library/blob/master/ContactLib_UML.PNG" width="520">
