import java.util.*;

public class Main {

    public static void main(String[] args) {
        welcomeScreen();
        menu();
    }

    public static void welcomeScreen() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Application Name : LockedMe.com");
        System.out.println("Created by Le Giang Nam");
        System.out.println("----------------------------------------------------------------");
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        BusinessLevelOperations Ops = new BusinessLevelOperations();

        int option;
        do {
            System.out.println("Enter your choice which you want to select: \n");
            System.out.println("\t1. Retrieve current filenames in ascending order \n");
            System.out.println("\t2. Count files and directories \n");
            System.out.println("\t3. Business-level operation menu \n");
            System.out.println("\t4. Exit from the application \n");
            System.out.print("Your choice: ");

            while (true) {
                try {
                    option = sc.nextInt();
                    if (option >= 1 && option <= 4) {
                        break;  // Exit the loop if the number is within range
                    } else {
                        System.out.println("Invalid choice, please enter a number between 1 and 4.");
                        System.out.print("Your choice: ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a numeric value.");
                    System.out.print("Your choice: ");

                    sc.next();  // Discard the non-integer input
                }
            }

            switch (option) {
                case 1 -> Ops.showAllFiles();
                case 2 -> Ops.getStats();
                case 3 -> businessLevelOperations(sc, Ops);
                case 4 -> System.out.println("Exiting from the application...");
            }
        } while (option != 4);
        sc.close();
    }

    public static void businessLevelOperations(Scanner sc, BusinessLevelOperations Ops) {
        int ch;
        do {
            System.out.println("Enter your choice for Business level Operation\n");
            System.out.println("\t1. Add a file and its content to a directory\n");
            System.out.println("\t2. Delete a file from a directory\n");
            System.out.println("\t3. Search a file and show its content\n");
            System.out.println("\t4. Go back\n");
            System.out.print("Your choice: ");

            while (true) {
                try {
                    ch = sc.nextInt();
                    if (ch >= 1 && ch <= 4) {
                        break;  // Exit the loop if the number is within range
                    } else {
                        System.out.println("Invalid choice, please enter a number between 1 and 4.");
                        System.out.print("Your choice: ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a numeric value.");
                    System.out.print("Your choice: ");
                    sc.next();  // Discard the non-integer input
                }
            }

            switch (ch) {
                case 1 -> Ops.addFile();
                case 2 -> Ops.deleteFile();
                case 3 -> Ops.searchFile();
                case 4 -> {
                    System.out.println("Exiting...");
                    System.out.println("-------------------------------------------\n");
                }
                default -> System.out.println("Invalid Choice");
            }
        } while (ch != 4);
    }
}
