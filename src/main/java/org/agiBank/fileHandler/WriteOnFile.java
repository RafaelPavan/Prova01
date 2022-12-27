package org.agiBank.fileHandler;

import org.agiBank.writing.WritingFile;

import java.io.FileWriter;
import java.io.IOException;

public class WriteOnFile {
    public static void main(String[] args) {
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
