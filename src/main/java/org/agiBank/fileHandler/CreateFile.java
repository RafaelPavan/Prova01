package org.agiBank.fileHandler;

import org.agiBank.writing.WritingFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;

public class CreateFile {

    public static void main(String[] args) throws IOException {
        Path pathToFile = Paths.get("C:\\JAVA\\ProvaAgibank\\src\\main\\java\\org\\agiBank\\data" +
                "\\in\\text.txt");
        Files.createDirectories(pathToFile.getParent());
        Files.createFile(pathToFile);
    }
}
