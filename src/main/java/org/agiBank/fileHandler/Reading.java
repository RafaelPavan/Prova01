package org.agiBank.fileHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;

public class Reading {
    public static void main(String[] args) throws IOException {
        Path pathToFile = Paths.get("C:\\JAVA\\ProvaAgibank\\src\\main\\java\\org\\agiBank\\data" +
                "\\out\\text.txt");
        Files.createDirectories(pathToFile.getParent());
        Files.createFile(pathToFile);

        Scanner scanner = new Scanner(new File("C:\\JAVA\\ProvaAgibank\\src\\main\\java\\org\\agiBank\\data" +
                "\\in\\text.txt"));
        PrintStream ps = new PrintStream(pathToFile.toFile());

        try{
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String [] values = line.split("ç");
                String function = values[0];
                String nome = values[2];
                HashSet<String> nomes = new HashSet<>();

                if(function.startsWith("001")){
                    ps.println(nome);
                }
                if (function.startsWith("002")){

                    ps.println(nomes.add(nome));
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        scanner.close();
        ps.close();
    }
}
