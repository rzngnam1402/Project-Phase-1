import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BusinessLevelOperations {
    private final String folderPath = "/Users/legiangnam/Documents/Fast Retailing/Phase1_Project/exampleFolder";
    private  File folder = new File(folderPath);

    private List<String> fileList = new ArrayList<>();

    public void showAllFiles() {
        if (folder.isDirectory()) {
            File[] listOfFiles = folder.listFiles();
            System.out.println("\nList of file in current directories: ");

            assert listOfFiles != null;

            for(File file : listOfFiles) {
                if(file.isFile()) {
                    fileList.add(file.getName());
                }
            }
            Collections.sort(fileList);
            fileList.forEach(file -> System.out.println("\t" + file));
            System.out.println();
        }
    }

    public void getStats() {
        int fileCount = 0;
        int directoryCount = 0;

        if (folder.isDirectory()) {
            File[] contents = folder.listFiles();
            if (contents != null) {
                for (File file : contents) {
                    if (file.isFile()) {
                        fileCount++;
                    } else if (file.isDirectory()) {
                        directoryCount++;
                    }
                }
            }
        } else {
            System.out.println("Path is not a directory!");
        }

        System.out.println("\nNumber of files: " + fileCount);
        System.out.println("Number of directories: " + directoryCount);
        System.out.println();
    }

    public void addFile() {
        System.out.println("Enter the file which you want to add:");
        Scanner scan = new Scanner(System.in);
        String filename = scan.nextLine();
        File file = new File("exampleFolder/" + filename);
        try {
            if(file.createNewFile()) {
                System.out.println(filename + " file is added to the directory");
                Desktop.getDesktop().edit(file);
            }
            else {
                System.out.println("This file is already there");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFile() {
        System.out.println("Enter the file which you want to delete:");
        Scanner scan = new Scanner(System.in);
        String filename = scan.nextLine();

        File file = new File("exampleFolder/"+ filename);
        if(file.delete())
            System.out.println(filename + " is deleted");
        else
            System.out.println("File Not Found");
    }

    public void searchFile() {
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter the file name which you want to search:");
        String fileName=scan.nextLine();
        File[] listOfFiles = folder.listFiles();

        int flag=0;
        assert listOfFiles != null;
        for (File file : listOfFiles) {
            String name = file.getName();
                if (name.equals(fileName)) {
                    try {

                        Scanner output = new Scanner(file);
                        while (output.hasNextLine())
                        {
                            System.out.println(output.nextLine());
                        }
                        return;
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
        }
        System.out.println("File not found");
    }
}
