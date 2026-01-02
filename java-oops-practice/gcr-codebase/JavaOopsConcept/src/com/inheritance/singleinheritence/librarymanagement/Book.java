
package com.inheritance.singleinheritence.librarymanagement;

//Superclass
class Book {

 String title;
 int publicationYear;

 // Constructor
 Book(String title, int publicationYear) {
     this.title = title;
     this.publicationYear = publicationYear;
 }

 // Method to display book details
 void displayInfo() {
     System.out.println("Book Title       : " + title);
     System.out.println("Publication Year : " + publicationYear);
 }
}
