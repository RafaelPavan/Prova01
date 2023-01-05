package org.agiBank.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomersQuantity {
    public static void main(String[] args) throws IOException {
        customers();
    }

    public static void customers() throws IOException {
        Scanner scanner = new Scanner(new File("C:\\JAVA\\ProvaAgibank\\src\\main\\java\\org\\agiBank\\data" +
                "\\in\\textIn.txt"), StandardCharsets.UTF_8);
        FileWriter fileWriter = new FileWriter("C:\\JAVA\\ProvaAgibank\\src\\main\\java\\org\\agiBank\\data" +
                "\\out\\textOut.txt", true);
        FileWriter fileError = new FileWriter("C:\\JAVA\\ProvaAgibank\\src\\main\\java\\org" +
                "\\agiBank\\messages\\messageText.txt", true);
        fileError.write("\n"+"\nQuantidade de Clientes ");


        List<String> generalcustomer = new ArrayList<>();
        List<String> customerQuantity = new ArrayList<>();

        try {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("002")) {
                    generalcustomer.add(List.of(line).toString());
                }else{
                    fileError.write("\nId: " + line.substring(0, 3) + " não pertence a pesquisa " +
                            "de quantidade de clientes.");
                }
            }

            String regex = "[A-Z].*[À-ú]*ç*(?=ç)";
            Pattern pattern = Pattern.compile(regex);
            for (int i = 0; i < generalcustomer.size(); i++) {
                Matcher matcher = pattern.matcher(generalcustomer.get(i));
                while (matcher.find()) {
                    ArrayList<String> regexList = new ArrayList<>(Collections.singleton(matcher.group()));
                    customerQuantity.addAll(regexList);
                }
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }


        fileWriter.write("\nQuantidade de Clientes: " + customerQuantity.size());

        scanner.close();
        fileWriter.close();
        fileError.close();
    }
}
