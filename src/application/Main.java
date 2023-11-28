package application;

import model.entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner read = new Scanner(System.in);

        List<Product> listProd = new ArrayList<>();

        System.out.print("Digite o caminho do arquivo: ");
        String filePathToRead = read.nextLine();

        File file = new File(filePathToRead);
        String fileParentFolder = file.getParent();

        boolean folderToWrite = new File(fileParentFolder + "/out").mkdir();

        String fileToWrite = fileParentFolder + "/out/summary.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(filePathToRead))){
            while(br.ready()){
                String[] list = br.readLine().split(",");
                String name = list[0];
                double price = Double.parseDouble(list[1]);
                int quantity = Integer.parseInt(list[2]);

                listProd.add(new Product(name, price,quantity));
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite))){
                for(Product product : listProd){
                    bw.write(product.getName() + "," + String.format("%.2f", product.getTotal()));
                    bw.newLine();
                }
                System.out.println("Sucess");
            }
            catch (IOException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        catch (IOException e){
            System.out.println("Error:" + e.getMessage());
        }
    }
}