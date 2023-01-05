package org.agiBank;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.agiBank.Service.CustomersQuantity.customers;
import static org.agiBank.Service.Sales.biggestSale;
import static org.agiBank.Service.SalesmenQuantity.salesmen;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Path fileOut = Paths.get("C:\\JAVA\\ProvaAgibank\\src\\main\\java\\org\\agiBank\\data" +
                "\\out\\textOut.txt");
        Path invalidID = Paths.get("C:\\JAVA\\ProvaAgibank\\src\\main\\java\\org\\agiBank" +
                "\\messages\\messageText.txt");
        try{
            Files.createDirectories(fileOut.getParent());
            Files.createFile(fileOut);
            Files.createDirectories(invalidID.getParent());
            Files.createFile(invalidID);
        }catch (FileAlreadyExistsException e){
            System.out.println(e.getMessage());
        }

        while (true){
            biggestSale();
            salesmen();
            customers();
            Thread.yield();
            System.out.println("Inserindo dados...");
            Thread.sleep(10500);

        }
    }
}