package org.agiBank.fileHandler;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Reading {
    public static void main(String[] args) throws IOException {
        Path pathToFile = Paths.get("C:\\JAVA\\ProvaAgibank\\src\\main\\java\\org\\agiBank\\data" +
                "\\out\\text.txt");
        try {
            Files.createDirectories(pathToFile.getParent());
            Files.createFile(pathToFile);
        } catch (FileAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        salesmen();
        customers();
    }

    public static String salesmen() throws IOException {
        Scanner scanner = new Scanner(new File("C:\\JAVA\\ProvaAgibank\\src\\main\\java\\org\\agiBank\\data" +
                "\\in\\text.txt"));
        PrintStream ps = new PrintStream("C:\\JAVA\\ProvaAgibank\\src\\main\\java\\org\\agiBank\\data" +
                "\\out\\text.txt");
        HashSet<String> nomes = new HashSet<>();

        try {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split("ç");
                String function = values[0];
                List<String> salesmen = Collections.singletonList(values[2]);

                if (function.startsWith("001")) {
                    nomes.addAll(salesmen);
                }
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        ps.print("Quantidade de vendedores: ");
        ps.println(nomes.size());
        scanner.close();
        ps.close();

        return nomes.toString();
    }

    public static String customers() throws IOException {
        Scanner scanner = new Scanner(new File("C:\\JAVA\\ProvaAgibank\\src\\main\\java\\org\\agiBank\\data" +
                "\\in\\text.txt"));
        PrintStream ps = new PrintStream("C:\\JAVA\\ProvaAgibank\\src\\main\\java\\org\\agiBank\\data" +
                "\\out\\text.txt");
        HashSet<String> nomes = new HashSet<>();

        try {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split("ç");
                String function = values[0];
                List<String> customers = Collections.singletonList(values[2]);

                if (function.startsWith("002")) {
                    nomes.addAll(customers);
                }
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        ps.print("Quantidade de clientes: ");
        ps.println(nomes.size());
        scanner.close();
        ps.close();

        return nomes.toString();
    }
}
