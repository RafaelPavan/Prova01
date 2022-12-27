package org.agiBank.fileHandler;

import org.agiBank.writing.WritingFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {

    public static void main(String[] args) throws IOException {
        createFile();
        writeOnFile();
    }

     public static void createFile() throws IOException {
         Path pathToFile = Paths.get("C:\\JAVA\\ProvaAgibank\\src\\main\\java\\org\\agiBank\\data" +
                 "\\in\\text.txt");
         Files.createDirectories(pathToFile.getParent());
         Files.createFile(pathToFile);
     }

     public static void writeOnFile(){
         try{
             FileWriter fileWriter = new FileWriter("C:\\JAVA\\ProvaAgibank\\src\\main\\java\\org\\agiBank\\data" +
                     "\\in\\text.txt");
             fileWriter.write(WritingFile.write());
             fileWriter.close();
         }catch (IOException e){
             System.out.println(e.getMessage());
         }
     }

}
