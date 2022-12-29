package org.agiBank.fileHandler;

import org.apache.commons.lang3.ArrayUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;



public class MoreExpensiveSale {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("C:\\JAVA\\ProvaAgibank\\src\\main\\java\\org\\agiBank\\data" +
                "\\in\\text.txt"));
        PrintStream ps = new PrintStream("C:\\JAVA\\ProvaAgibank\\src\\main\\java\\org\\agiBank\\data" +
                "\\out\\text.txt");
        List<String> vendas = new ArrayList<>();

        try {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split("ç");
                String function = values[0];
                if (function.startsWith("003") && values[1].startsWith("10")) {
                    List<String> list = new ArrayList<>();
                    list.add(values[2].replace("[", "").replace("]", ""));
                    String[] valores = list.get(0).split(",");

                    vendas.addAll(Arrays.asList(valores));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        List<List<BigDecimal>> novaLista = new ArrayList<>();
        List<BigDecimal> math = new ArrayList<>();
        for (int i=0; i < vendas.size(); i++){
            List<String> lista = List.of(vendas.get(i).split("-"));
            List<BigDecimal> bigDecimals = new ArrayList<>();
            for(String novoValor : lista){
                bigDecimals.add(new BigDecimal(novoValor));
            }

            BigDecimal multi = bigDecimals.get(1).multiply(bigDecimals.get(2));
            math.add(multi);
        }


        BigDecimal result = math.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(result);
























//        System.out.println(Arrays.toString(vendas.get(1).split("-")));

        int index = 0;
        while (index < vendas.size()) {
            List<String> lista = List.of(vendas.get(index).split("-"));
//            System.out.println(lista);


            /*List<BigDecimal> bigDecimals = new ArrayList<>();
            for (String novoValor : lista) {
                bigDecimals.add(new BigDecimal(novoValor));

            }

            //Peguei lista dos resultados das três vendas
            BigDecimal novaLista = new BigDecimal(String.valueOf(bigDecimals.get(1).multiply(bigDecimals.get(2))));
            System.out.println(novaLista);*/




//            BigDecimal soma =
//                    bigDecimals.get(1).multiply(bigDecimals.get(2));
//            ps.println(soma);
            index++;
        }

    }
}
