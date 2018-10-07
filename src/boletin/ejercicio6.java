package boletin;

import utilidades.fileUtils;

import java.io.*;

class ejercicio6 {

    public static void main(String[] args) {
        /*6 Realiza un programa que dado un fichero de texto, se copie en tres ficheros diferentes de tal
        manera que copie en el primer fichero los primeros 5 caracteres, en el segundo, los 5 siguientes y
        en el tercero los 5 siguientes, y así sucesivamente hasta copiar todo el fichero.
        Utilizar lectura sin desplazamiento y escrituras con desplazamiento.
        Después, hacer justamente lo contrario. Dados los
        3 ficheros, construir el fichero original. Utilizar ahora lecturas con desplazamiento y escritura sin
        desplazamiento. Comprobar por código que ambos son iguales.*/

        File fOriginal, fFinal;
        File fDivided[] = new File[3];
        char[] buffer = new char[15];
        String ogFilePath, dividedFilePath, finalFilePath;
        FileReader readerf1, readerf2, readerf3, readerOriginal;
        FileWriter writerf1, writerf2, writerf3, writerFinal;
        int i,k,l;
        boolean allRead = false;

        // File paths.
        ogFilePath = "D:\\ProyectosIntellIj\\BoletinACDAT6-\\src\\ficheros\\fOriginal.txt";
        dividedFilePath = "D:\\ProyectosIntellIj\\BoletinACDAT6-\\src\\ficheros\\file%d%s";
        finalFilePath = "D:\\ProyectosIntellIj\\BoletinACDAT6-\\src\\ficheros\\fFinal.txt";

        //Initialization and creation of FileReader,FileWriter and files.

        fOriginal = new File(ogFilePath);

        for (int j = 0; j < fDivided.length; j++) {
            fDivided[j] = new File(String.format(dividedFilePath,j,".txt"));
            fileUtils.createFile(fDivided[j]);
        }

        fFinal = new File(finalFilePath);
        fileUtils.createFile(fFinal);

        //Creation of FileReaders and FileWriters
        readerOriginal = fileUtils.createFileReader(fOriginal);
        readerf1 = fileUtils.createFileReader(fDivided[0]);
        readerf2 = fileUtils.createFileReader(fDivided[1]);
        readerf3 = fileUtils.createFileReader(fDivided[2]);

        writerFinal = fileUtils.createFileWriter(fFinal);
        writerf1 = fileUtils.createFileWriter(fDivided[0]);
        writerf2 = fileUtils.createFileWriter(fDivided[1]);
        writerf3 = fileUtils.createFileWriter(fDivided[2]);

        //Reading of the original file,splitting it into 3 segments and writing the text read on 3 different files
        try {
            while ((i = readerOriginal.read(buffer)) != -1) {
                if (i <= 5) {
                    writerf1.write(buffer, 0, i);
                } else if (i > 5 && i <= 10) {
                    writerf1.write(buffer, 0, 5);
                    writerf2.write(buffer, 5, i - 5);
                } else {
                    writerf1.write(buffer, 0, 5);
                    writerf2.write(buffer, 5, 5);
                    writerf3.write(buffer, 10, i - 10);
                }
            }

            writerf1.close();
            writerf2.close();
            writerf3.close();
            readerOriginal.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Writing into the final file what is being read from the 3 files
        try {

            while(!allRead){
                i = readerf1.read(buffer,0,5);
                k = readerf2.read(buffer,(i < 0)?0:i,5);
                l = readerf3.read(buffer,(k < 0)?0:i + k,5);

                if(i <= 0 && k <= 0 && l <= 0){
                    allRead = true;
                }else{
                    writerFinal.write(buffer,0,((i < 0)?0:i)+((l < 0)?0:l)+((k < 0)?0:k));
                }

            }

            /*while((i = readerf1.read(buffer,0,5)) != -1 && (k = readerf2.read(buffer,i,5)) != -1 && (l = readerf3.read(buffer,k,5)) != -1){
                writerFinal.write(buffer,0,i+k+l);
            }*/

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading the text in the 3
        //Closing readers and writers
        try {
            readerf1.close();
            readerf2.close();
            readerf3.close();
            writerFinal.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println((fileComparator(fOriginal,fFinal)?"The files are identical":"The content is not the same"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cleanBuffer(char[] buffer){
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = '-';
        }
    }

    public static boolean fileComparator(File file1, File file2) throws IOException {
        FileReader lector1,lector2;
        int i,j;

        lector1 = fileUtils.createFileReader(file1);
        lector2 = fileUtils.createFileReader(file2);


        while ((i = lector1.read()) != -1 && (j = lector2.read()) != -1 ){
            if (i != j){
                return false;
            }
        }

        return true;
    }
}
