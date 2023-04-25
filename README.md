# NeighborhoodLibrary
Library emulator in java terminal!

Home Screen:

<img width="181" alt="Screenshot 2023-04-24 095751" src="https://user-images.githubusercontent.com/58373811/234041866-f81d343f-7ba2-48b7-b4be-b0a493a63f72.png">

Products Display Screen:

<img width="313" alt="Screenshot 2023-04-24 095825" src="https://user-images.githubusercontent.com/58373811/234041976-4c9508cd-a88b-4601-8443-89843db124ad.png">

Calculator Screen (Erroneous inputs):

<img width="554" alt="Screenshot 2023-04-24 095917" src="https://user-images.githubusercontent.com/58373811/234042101-f99d8762-5616-4acf-b2d1-804a66d46ec7.png">


The code snippet below is interesting because it converts a user-inputted string into an integer directly
inside the brackets of books[] to be used as an index, then accesses the .checkOut(name) method of said book
on the same line, passing a new user-inputted "name" as a parameter.

```
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
```
