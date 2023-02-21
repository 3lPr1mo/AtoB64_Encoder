package Modelo;

import javax.swing.*;

public class Codificador {
    private String txtAscii;
    private String[] binaries;
    private JtableData jt;

    public String[] binary(){
        char[] chars = txtAscii.toCharArray(); //la cadena se pasa a un array de chars
        binaries = new String[chars.length]; //se crea un arreglo con la longitud de los chars
        for(int i = 0; i < chars.length; i++){
            int caracter = chars[i]; //se pasa el acaracter a entero
            String binary = Integer.toBinaryString(caracter); // de entero a binario
            binaries[i] = binary; //se agregar el binario al array
        }
        return binaries;
    }

    public void base64(){
        String acum;
    }
    public String XD(){
        return "HOla";
    }
    }
