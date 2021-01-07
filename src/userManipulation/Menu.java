package userManipulation;

import model.Product;

import java.util.Scanner;

public class Menu {
    public static final String FILE_NAME = "productList.dat";
    public static Scanner scanner=new Scanner(System.in);
    public static Product getProductToAdd(){
        try {
            System.out.println("Input id");
            int id=Integer.parseInt(scanner.nextLine());
            System.out.println("Input name");
            String name=scanner.nextLine();
            System.out.println("Input brand");
            String brand=scanner.nextLine();
            System.out.println("Input price");
            int price=Integer.parseInt(scanner.nextLine());
            Product product=new Product(id,name,brand,price);
            return product;
        }catch (Exception e){
            System.out.println("invalid fomat, please try again");
            return null;
        }
    }
}
