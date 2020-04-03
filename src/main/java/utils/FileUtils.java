package utils;

import service.impl.ProbabilityGeneratorImpl;

import java.io.*;

public class FileUtils {

    public static void createAndWriteToOutputFile(String fileName , String contents) throws IOException{
        File file = createFileIfNotExists(fileName);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(contents);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing into file : " + fileName);
            e.printStackTrace();
            throw e;
        }

    }

    private static File createFileIfNotExists(String fileName) throws IOException{
        File file = null;
        try {
            ClassLoader classLoader = new FileUtils().getClass().getClassLoader();
            file = new File(classLoader.getResource(fileName).getFile());
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating new file :: " + fileName);
            e.printStackTrace();
            throw e;
        } catch (Exception ex ){
            System.out.println("An error occurred.");
        }
        return file;
    }
}
