package org.example;
import java.util.Scanner;
public class HomeMain {
    public static void main(String[] args) { // main menu screen
        Scanner scanner = new Scanner(System.in); // make a scanner

        System.out.println("Main Menu:");
        System.out.println("[1] Show Available Books");
        System.out.println("[2] Show Checked Out Books");
        System.out.println("[X] Exit");

        String input = scanner.nextLine();

        if (input.equals("1")){ // go to available books screen
            available();
        }
        else if (input.equals("2")){ // go to checked out screen
            checkedOut();
        }
        else{
            System.exit(0); // exit program
        }
    }

    public static void available() {
        Scanner scanner = new Scanner(System.in); // create scanner
        Book[] books = Inventory.Inventory; // import array of book objects (inventory) and name it "books"

        System.out.println("Available Books To Checkout:");
        // print out necessary info about books
        for (int i = 0; i < books.length; i++){
            if (!books[i].isCheckedOut()){ // if current book in loop has its isCheckedOut() property set to false,
                System.out.println( // then print out its info
                        "[" + i + "] " + //index for easier book selection/inventory access
                                books[i].getTitle() + ", " + "ID: " +
                                books[i].getId() + ", ISBN: " +
                                books[i].getIsbn());
            }
        }
        System.out.println(
                "[X] " + "Exit To Main Menu"
        );

        String input = scanner.nextLine(); // clear scanner buffer from previous use
        String choice = input; // save the user book index input bc input will be changed soon

        if (input.equals("X")){
            main(null); // null as the parameter bc we don't have anything to pass in
        }
        else{ // else if user inputs book index (not "X"), then use their input to get the book we need
            System.out.println("Please provide your name to check out " + books[Integer.parseInt(choice)].getTitle());
            input = scanner.nextLine();
            books[Integer.parseInt(choice)].checkOut(input); // convert user input to integer to use as index in inventory
            // then call checkout method with user's name as parameter: books[i].checkOut(name)
        }

        System.out.println(books[Integer.parseInt(choice)].getTitle() + " was successfully Checked Out!");

        available(); // run available books screen again to check out more books until user exits
    }

    public static void checkedOut() {
        Scanner scanner = new Scanner(System.in); // make new scanner
        Book[] books = Inventory.Inventory; // import array of book objects (inventory) and name it "books"

        System.out.println("Your Checked-Out Books:");
        // same loop as available books, but if .isCheckedOut() == true
        for (int i = 0; i < books.length; i++){
            if (books[i].isCheckedOut() == true){
                System.out.println(
                        "[" + i + "] " +
                                books[i].getTitle() + ", " + "ID: " +
                                books[i].getId() + ", ISBN: " +
                                books[i].getIsbn() + ", checked out by " +
                                books[i].getCheckedOutTo());
            }
        }
        System.out.println("[C] Check In a book");
        System.out.println("[X] Exit To Main Menu");

        String input = scanner.nextLine();

        if (input.equals("C")){
            checkIn(); // go to check in screen
        }
        else{
            main(null);
        }
    }

    public static void checkIn() {
        Scanner scanner = new Scanner(System.in);
        Book[] books = Inventory.Inventory;

        System.out.println("Enter ID of book you are checking in:");
        int input = scanner.nextInt();

        // if inputted ID matches the ID of any book in inventory, check it in
        for (Book book : books){
            if (input == book.getId()){
                book.checkIn(); // call checkIn method from the "Book" class on the current book in the loop
                System.out.println(book.getTitle() + " was successfully Checked In!");
            }
        }
        main(null); // go back to main menu after check-in is done
    }
}