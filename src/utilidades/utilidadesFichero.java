package utilidades;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class utilidadesFichero {

    //Sii la ruta especificada es un archivo que no existe,FileWriter lo crea

    public static void copiarFichero(File ficheroQueSeCopia, File ficheroDestino){
        try {
            Files.copy(ficheroQueSeCopia.toPath(),ficheroDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void crearArchivo(File archivoAcrear){
        try {
            archivoAcrear.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
