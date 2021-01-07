package userManipulation;

import model.Product;
import service.ProductManage;
import storage.FileProcess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File saveFile=new File(Menu.FILE_NAME);
        if (!saveFile.exists()){
            try {
                saveFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Scanner scanner=new Scanner(System.in);

        Object object=FileProcess.readFile(Menu.FILE_NAME);
        List<Product> productList;
        if (object==null)productList=new ArrayList<>();
        else productList=(ArrayList<Product>) object;
        ProductManage manage=new ProductManage(productList);
        int choice;
        do {
            System.out.println("1. Add new product");
            System.out.println("2. Show all");
            System.out.println("3. Searching product by id");
            System.out.println("0. Exit");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    Product newProduct=Menu.getProductToAdd();
                    manage.addNewProduct(newProduct);
                    break;
                case 2:
                    manage.showAll();
                    break;
                case 3:
                    System.out.println("Input searching id");
                    int searchingId=scanner.nextInt();
                    Product searchingProduct=manage.searchById(searchingId);
                    if (searchingProduct==null) System.out.println("NOT FOUND");
                    else System.out.println(searchingProduct);
                    break;
                case 0:
                    System.exit(0);
            }
        }while (choice!=0);
    }
}
