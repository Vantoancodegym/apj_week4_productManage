package storage;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

public class FileProcess {
    public static void writeFile(String fileName, Object object){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
            fileOutputStream.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static Object readFile(String fileName){
        try {
            FileInputStream fileInputStream=new FileInputStream(fileName);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            Object object=objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
            return object;
        }catch (Exception e){
           return null;
        }
    }
}
