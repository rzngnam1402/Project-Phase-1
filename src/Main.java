
import java.io.FileNotFoundException;
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

            option=sc.nextInt();
            switch (option) {
                case 1 -> Ops.showAllFiles();
                case 2 -> Ops.getStats();
                case 3 -> {
                    int ch;
                    do {
                        System.out.println("Enter your choice for Business level Operation");
                        System.out.println("\t1. Add a file and its content to a directory");
                        System.out.println("\t2. Delete a file from a directory");
                        System.out.println("\t3. Search a file and show its content");
                        System.out.println("\t4. Go back");
                        System.out.print("Your choice: ");

                        ch = sc.nextInt();
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
                case 4 -> System.out.println("Exiting from the application...");
                default -> System.out.println("Invalid choice");
            }
        } while (option != 4);
    }
}