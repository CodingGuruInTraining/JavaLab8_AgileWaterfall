package com.mark;

import java.util.Scanner;

/**
 * This program asks the user various questions regarding their
 * project to determine which method to use.
 */
public class AgileWaterfall {
    // Generates Scanner objects
    static Scanner stringScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Prompts user for answers to various questions
        System.out.println("How many programmers will be on the team?");
        int programmers = numberScanner.nextInt();
        System.out.println("Please answer the following questions with" +
                " either 'YES' or 'NO.'");
        System.out.println("Are firm deadlines and a fixed schedule " +
                "needed?");
        String deadlines = stringScanner.nextLine();
        System.out.println("Do your programmers have experience in " +
                "requirements, analysis and testing as well as coding?");
        String knowledge = stringScanner.nextLine();
        System.out.println("Are there not stringent quality control " +
                "requirements?");
        String requirements = stringScanner.nextLine();
        System.out.println("Is early integration desirable?");
        String integration = stringScanner.nextLine();
        System.out.println("Will the customer be requiring working " +
                "models early in the process?");
        String prototypes = stringScanner.nextLine();

        // Creates a string array of the string answers (all but the first)
        String[] answers = new String[] {deadlines, knowledge,
                requirements, integration, prototypes};
        // Sends answers to function to determine best choice
        String decision = agileOrWaterfall(programmers, answers);
        // Displays the result to user
        System.out.println(decision + " is the best choice in this situation.");
    }

    public static String agileOrWaterfall(int prog, String[] answers) {
        // Defines score keeping variables
        int agile = 0;
        int water = 0;
        // First checks the integer answer
        if (prog > 15) {
            water++;
        }
        else {
            agile++;
        }
        // Loops through string array and looks for a yes answer
        for (int i = 0; i < answers.length; i++) {
            if (answers[i].equalsIgnoreCase("YES")) {
                agile++;
            }
            else {
                water++;
            }
        }
        // Compares score keepers to determine the highest score.
        if (agile > water) {
            return "Agile";
        }
        else if (agile == water) {
            return "Either Agile or Waterfall";
        }
        else {
            return "Waterfall";
        }
    }
}
