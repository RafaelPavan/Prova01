package org.agiBank.Service;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.List;


public class Sales {
    public static void main(String[] args) throws IOException {
        biggestSale();
    }

    public static void biggestSale() throws IOException {
        Scanner scanner = new Scanner(new File("C:\\JAVA\\ProvaAgibank\\src\\main\\java\\org\\agiBank\\data" +
                "\\in\\text.txt"), StandardCharsets.UTF_8);
        FileWriter fileWriter = new FileWriter("C:\\JAVA\\ProvaAgibank\\src\\main\\java\\org\\agiBank\\data" +
                "\\out\\textOut.txt");
        FileWriter fileError = new FileWriter("C:\\JAVA\\ProvaAgibank\\src\\main\\java\\org" +
                        "\\agiBank\\messages\\messageText.txt");
        fileError.write("Serviço de valores das Vendas ");

        List<String> sales = new ArrayList<>();
        List<Integer> id = new ArrayList<>();
        List<String> names = new ArrayList<>();

        try {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split("ç", 4);
                String function = values[0];
                if (function.startsWith("003")) {
                    id.add(Integer.valueOf(values[1]));
                    sales.add(values[2]);
                    names.add(values[3]);
                }else {
                    fileError.write("\nId: " + line.substring(0, 3) + " não pertence a pesquisa " +
                            "de valores de vendas.");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        System.out.println(names);

        /*pega a venda mais cara e mais baixa sem o id*/
        List<BigDecimal> total = new ArrayList<>();
        for (String sale : sales) {
            List<String> newListSale = List.of(sale.replace("[", "").replace("]", "").split(","));
            List<BigDecimal> bigDecimalList = new ArrayList<>();
            for (String newList : newListSale) {
                List<String> separeted = List.of(newList.split("-"));
                List<BigDecimal> bigDecimals = separeted.stream()
                        .map(BigDecimal::new).toList();
                BigDecimal multiply = bigDecimals.get(1).multiply(bigDecimals.get(2));
                bigDecimalList.add(multiply);
            }
            BigDecimal result = bigDecimalList.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
            total.add(result);
        }
        BigDecimal maxSale = Collections.max(total.stream().map(BigDecimal::abs).toList());
        BigDecimal minSale = Collections.min(total.stream().map(BigDecimal::abs).toList());

        Map<Integer, BigDecimal> data = new HashMap<>();
        for (int i=0; i < id.size(); i++){
            data.put(id.get(i), total.get(i));
        }

        Map<Integer, String> nameSalesmen = new HashMap<>();
        for (int i=0; i< id.size(); i++){
            nameSalesmen.put(id.get(i), names.get(i));
        }

        Integer bestSaleKey = data.entrySet()
                .stream()
                .filter(e -> e.getValue().equals(maxSale))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);

        Integer worstSaleKey = data.entrySet()
                .stream()
                .filter(e -> e.getValue().equals(minSale))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);

        String worstSaleName = nameSalesmen.entrySet()
                .stream()
                .filter(e -> e.getKey().equals(worstSaleKey))
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse(null);

        fileWriter.write("Id da Maior Venda: " + bestSaleKey + ", valor da Venda: " + maxSale);
        fileWriter.write("\nO pior Vendedor foi: " + worstSaleName + ", valor da Venda: " + minSale);
        scanner.close();
        fileError.close();
        fileWriter.close();
    }
}
