package utilidades;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class fileUtils {

    //Sii la ruta especificada es un archivo que no existe,FileWriter lo crea

    public static void copyFile(File fileToCopy, File copiedFile){
        try {
            Files.copy(fileToCopy.toPath(),copiedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFile(File file){
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FileReader createFileReader(File fileToRead){
        try {
           return new FileReader(fileToRead);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static FileWriter createFileWriter(File fileToWrite){
        try {
            return new FileWriter(fileToWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
