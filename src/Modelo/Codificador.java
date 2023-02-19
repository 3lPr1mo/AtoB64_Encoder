package Modelo;

public class Codificador {
    private String txtAscii;

    public String[] binary(){
        char[] chars = txtAscii.toCharArray(); //la cadena se pasa a un array de chars
        String[] binaries = new String[chars.length]; //se crea un arreglo con la longitud de los chars
        for(int i = 0; i < chars.length; i++){
            int caracter = chars[i]; //se pasa el acaracter a entero
            String binary = Integer.toBinaryString(caracter); // de entero a binario
            binaries[i] = binary; //se agregar el binario al array
        }
        return binaries;
    }
}
