package org.agiBank.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SalesmenQuantity {
    public static void main(String[] args) throws IOException {
        salesmen();
    }

    public static void salesmen() throws IOException {
        Scanner scanner = new Scanner(new File("C:\\JAVA\\ProvaAgibank\\src\\main\\java\\org\\agiBank\\data" +
                "\\in\\textIn.txt"), StandardCharsets.UTF_8);
        FileWriter ps = new FileWriter("C:\\JAVA\\ProvaAgibank\\src\\main\\java\\org\\agiBank\\data" +
                "\\out\\textOut.txt", true);
        FileWriter fileError = new FileWriter("C:\\JAVA\\ProvaAgibank\\src\\main\\java\\org" +
                "\\agiBank\\messages\\messageText.txt", StandardCharsets.UTF_8,true);
        fileError.write("\n"+"\nServiço de quantidade de Vendedores ");

        List<String> generalSalesman = new ArrayList<>();
        List<String> salesmanQuantity = new ArrayList<>();

        try {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.startsWith("001")) {
                    generalSalesman.add(List.of(line).toString());
                }else{
                    fileError.write("\nId: " + line.substring(0, 3) + " não pertence a pesquisa " +
                            "de quantidade de vendedores.");
                }
            }

            String regex = "[A-Z].*[À-ú]*ç*(?=ç)";
            Pattern pattern = Pattern.compile(regex);
            for (int i = 0; i < generalSalesman.size(); i++) {
                Matcher matcher = pattern.matcher(generalSalesman.get(i));
                while (matcher.find()) {
                    ArrayList<String> regexList = new ArrayList<>(Collections.singleton(matcher.group()));
                    salesmanQuantity.addAll(regexList);
                }
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        ps.write("\nQuantidade de Vendedores: " + salesmanQuantity.size());

        scanner.close();
        ps.close();
        fileError.close();
    }

}
