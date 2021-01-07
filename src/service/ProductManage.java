package service;

import model.Product;
import storage.FileProcess;
import userManipulation.Menu;

import java.util.ArrayList;
import java.util.List;

public class ProductManage {
    private List<Product> productList;
    public ProductManage(List<Product> productList) {
        this.productList = productList;
    }
    public void addNewProduct(Product product){
        productList.add(product);
        FileProcess.writeFile(Menu.FILE_NAME,productList);
    }
    public void showAll(){
        for (Product product:productList
             ) {
            System.out.println(product);
        }
    }
    public Product searchById(int searchingId){
        Product productResult=null;
        for (Product product:productList
             ) {
            if (product.getId()==searchingId){
                productResult=product;
            }
        }
        return productResult;
    }
}
