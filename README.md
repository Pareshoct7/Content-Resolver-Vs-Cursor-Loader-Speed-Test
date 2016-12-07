## Application Purpose and Description

While developing my app [DCM](https://play.google.com/store/apps/details?id=jagerfield.dcm) I used both the ContentResolver and the CursorLoader to fetch contacts from the mobile. The ContentResolver is a class that provides applications access to the content model. The CursorLoader is a loader object that queries a ContentResolver for data. In my trials I noticed that the ContentResolver is much faster. 

This application compares the execution time of both methods in fetching contacts. The ContactsLib modle in this application is modified and extended from my ContactImportLib which solely used the ContentResolver to fetch contacts:

https://github.com/Jagerfield/Android-get-phone-book-contact-library

Images of the comparison results:

<img src="https://github.com/Jagerfield/Content-Resolver-Vs-Cursor-Loader-Speed-Test/blob/master/msc/Content%20Resolver.png" width="240">


<img src="https://github.com/Jagerfield/Content-Resolver-Vs-Cursor-Loader-Speed-Test/blob/master/msc/Cursor%20Loader.png" width="240">

## Installation

In the app build.gradle add the following:

  a. Add JitPack repository at the end of repositories 

  ```java
 
  ```
  b. Add the dependency
 
  ```java
   
  ```

## How to use?
You can use this library to fetch contacts using either one of the methods or both:

### Fetch contacts using ContentResolver

```java
  new ImportContacts(getActivity(), new ImportContacts.ContentResolverCallback() 
  {
      @Override
      public void getMobileContacts(ArrayList<Contact> contacts)
       {
           if (contacts != null)
             {
                recyclerView.setAdapter(new ContactListViewAdapter(contactListFragment, contacts));
             }
        }
  });
  
```

### Fetch contacts using CursorLoader

```java
  new ImportContacts(getActivity(), new ImportContacts.CursorLoaderCallback() 
  {
      @Override
      public void getMobileContacts(ArrayList<Contact> contacts) 
       {
           if (contacts != null)
             {
                recyclerView.setAdapter(new ContactListViewAdapter(contactListFragment, contacts));
             }
        }
  });

  
```
