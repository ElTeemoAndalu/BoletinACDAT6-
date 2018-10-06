package boletin;

import java.io.File;

public class ejercicio6 {

    public static void main(String[] args) {
        /*6 Realiza un programa que dado un fichero de texto, se copie en tres ficheros diferentes de tal
        manera que copie en el primer fichero los primeros 5 caracteres, en el segundo, los 5 siguientes y
        en el tercero los 5 siguientes, y así sucesivamente hasta copiar todo el fichero.
        Utilizar lectura sin desplazamiento y escrituras con desplazamiento.
        Después, hacer justamente lo contrario. Dados los
        3 ficheros, construir el fichero original. Utilizar ahora lecturas con desplazamiento y escritura sin
        desplazamiento. Comprobar por código que ambos son iguales.*/

        File fOriginal,fFinal;
        File fDivided[] = new File[3];
        char[] buffer;

        fOriginal = new File("C:\\Users\\nicol\\IdeaProjects\\BoletinACDAT6-\\src\\Ficheros\\fOriginal.txt");

        for (int i = 0; i < fDivided.length; i++) {
            fDivided[i] = new File("C:\\Users\\nicol\\IdeaProjects\\BoletinACDAT6-\\src\\Ficheros\\fichero" + i);
        }

        fFinal = new File("C:\\Users\\nicol\\IdeaProjects\\BoletinACDAT6-\\src\\Ficheros\\fFinal.txt");



    }
}
