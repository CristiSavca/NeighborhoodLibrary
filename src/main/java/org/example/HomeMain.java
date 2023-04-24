package org.example;
import java.util.Scanner;
public class HomeMain {
    // main menu
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

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

    public static void available() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Book[] books = Inventory.Inventory; // import inventory of books

        System.out.println("Available Books To Checkout:");
        // print out necessary info about books
        for (int i = 0; i < books.length; i++){
            if (books[i].isCheckedOut() == false){
                System.out.println(
                        "[" + i + "] " +
                                books[i].getTitle() + ", " + "ID: " +
                                books[i].getId() + ", ISBN: " +
                                books[i].getIsbn());
            }
        }
        System.out.println(
                "[X] " + "Exit To Main Menu"
        );

        String input = scanner.nextLine();
        String choice = input; // save the user input bc input will be changed soon

        if (input.equals("X")){
            main(null);
        }
        else{
            System.out.println("Please provide your name to check out " + books[Integer.parseInt(choice)].getTitle());
            input = scanner.nextLine();
            books[Integer.parseInt(choice)].checkOut(input); // convert user input to integer to use as index in inventory
            // then call checkout method with user's name as parameter
        }

        System.out.println(books[Integer.parseInt(choice)].getTitle() + " was successfully Checked Out!");
        Thread.sleep(2000); // pause for 2 seconds for user to read 'success' message
        available(); // run checked out screen again to check out more books until user exits
    }

    public static void checkedOut() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Book[] books = Inventory.Inventory;

        System.out.println("Your Checked-Out Books:");

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

    public static void checkIn() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Book[] books = Inventory.Inventory;

        System.out.println("Enter ID of book you are checking in:");

        int input = scanner.nextInt();
        // if inputted ID matches the ID of any book in inventory, check it in
        for (Book book : books){
            if (input == book.getId()){
                book.checkIn();
                System.out.println(book.getTitle() + " was successfully Checked In!");
                Thread.sleep(2000);
            }
        }

        main(null); // back to main menu
    }
}