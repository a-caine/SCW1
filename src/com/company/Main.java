package com.company;

import java.util.Scanner;

/**
 * This class contains the main method of the program and is therefore the entrypoint of the program.
 */
public class Main {

    /**
     * The main method is our entrypoint into the program.
     * It is used here to hold onto an instance of the scraper class that we then utilize to satisfy the objective of
     * this weeks challenge.
     *
     * @param args Contains a string array of the arguments passed through the command line
     */
    public static void main(String[] args) {
        // Create instances of our classes
        Scraper scraper = new Scraper();

        String email = getUserString("Please enter the email address: ");

        // split the email at the @ character and store the first part of that string in the 'username' variable
        String username = email.split("@")[0];

        String result = scraper.scrapeNameFromURL("https://www.ecs.soton.ac.uk/people/" + username);

        // If anything goes wrong, then the value of result is FAILED and we can tell the user that we didn't find
        // anything. Otherwise we can print the full name of the user from the scraper class' result
        if (result.equals("FAILED")) {
            System.out.println("That user does not appear in the people page of the ecs website.");
        } else {
            System.out.println("User found: " + result);
        }


    }

    /**
     * This method takes a message parameter, and creates a scanner object to take the users input.
     * It will print the message before taking the user's input, allowing the message to be customized to reduce the
     * chance of the user inputting incorrect information
     *
     * @param message the message that will be prompted with before their input is taken
     * @return returns the string that the user entered
     */

    public static String getUserString(String message) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(message);

        return scanner.next();
    }
}
