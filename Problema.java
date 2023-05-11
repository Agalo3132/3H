import java.io.*;
import java.util.ArrayList;

public class Problema {

    public static void main(String[] args) {

        BufferedReader br = null;
        BufferedWriter bw = null;
        char  [] letras = {'A','B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char [] texto = new char[12];
        char [] contraseña = new char [12];

        int numero= 0;
        StringBuilder cifrado = new StringBuilder();
         try {
            br = new BufferedReader(new FileReader("mensaje.txt"));
            bw = new BufferedWriter(new FileWriter("mensaje_cifrado.txt"));

            String linea = null;


            int valor=-1;
            char caracterEspecial= 'null';
            /* Lectura y validación  de clave */

            while ((linea = br.readLine()) != null) {
                StringBuilder sb = new StringBuilder(linea.length());
                if (linea.length()<=12){
                    for (int i= 0; i < texto.length; i++) {
                        if (Character.isLetter(linea.charAt(i))){
                            texto[i]= linea.charAt(i);
                        } else {
                            valor = i;
                            caracterEspecial = linea.charAt(i);
                        }


                    }
                }
                else{
                    System.out.println("La longitud del texto es demasiado larga");
                }


                /* Aquí vendría la lógica del programa */


                bw.write(sb.toString()); /* Escribe la cadena de caracteres en el fichero*/
                bw.newLine(); /* escribe nueva línea en el fichero */

                while ((linea = br.readLine()) != null){
                    if (linea.length()<= 12){
                        for (int i= 0; i < texto.length; i++) {
                            if (i == valor){
                                sb.append(caracterEspecial);
                            }
                            if (Character.isLetter(linea.charAt(i))){
                                texto[i]= linea.charAt(i);
                            }
                        }
                        for( int i =0; i < texto.length; i++) {
                            if (Character.isLetter(texto[i])){
                                for(int j = 0; j < letras.length; j++){
                                    if (letras[j] == texto[i]){
                                    numero +=j;
                                    }
                                    if (letras[j] == contraseña[i]){
                                        numero+=j;
                                    }
                            }
                                if (numero >25){
                                    numero= numero-25;
                                    cifrado.append(letras[numero]);
                                }
                                else{
                                    cifrado.append(letras[numero])
                                }
                                numero=-0;

                            }
                        }
                    }
                    else{
                        System.out.println("La longitud del texto es demasiado larga");
                    }

                }




            }
            System.out.println("El mensaje ha sido cifrado correctamente");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (bw != null)
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

}
