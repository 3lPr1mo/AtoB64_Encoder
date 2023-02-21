package Modelo;

import javax.swing.*;

public class Codificador {
    private String txtAscii;
    private String[] binaries;
    private JtableData jt;

    public Codificador(String txtAscii, String[] binaries, JtableData jt) {
        this.txtAscii = txtAscii;
        this.binaries = binaries;
        this.jt = jt;
    }
    public Codificador() {
        this.txtAscii = "";
        this.binaries = null;
        this.jt = null;
    }

    public String binary(){
        String binary="";
        char[] chars = txtAscii.toCharArray(); //la cadena se pasa a un array de chars
        binaries = new String[chars.length]; //se crea un arreglo con la longitud de los chars
        for(int i = 0; i < chars.length; i++){
            int caracter = chars[i]; //se pasa el acaracter a entero
            binary += Integer.toBinaryString(caracter); // de entero a binario
            binaries[i] = Integer.toBinaryString(caracter);; //se agregar el binario al array
        }
        return binary;
    }

    public void base64(){
    }
    public String SepararEn6(String x) {
        int cont=0;
        String aux="";
        for (int i=0; i < x.length(); i++) {
            cont++;
            aux+=x.charAt(i);
            if (cont == 6) {
                aux +=",";
                cont = 0;
            }
        }
        return aux;
    }
    public String Texto(String [] x) {
        String aux = "";
        for (int i=0; i < x.length; i++) {
            if(x[i].length() < 8) {
                x[i] = "0"+x[i];
            }
            aux+=x[i];
        }
        return aux;
    }

    public String CompletarCeros(String x) {
        int ceros = 6-x.length() ;
        for (int i=0; i < ceros; i++) {
            x+="0";
        }
        return x;

    }
    public String Iguales(String x) {
        int ceros = 6-x.length();
        String iguales="";
        for(int i = 0; i <  ceros/2; i++) {
            iguales+="=";
        }
        return iguales;
    }
    public int[] toDecimal(String [] x) {
        int [] valor = new int[x.length];
        for(int i = 0; i < x.length; i++) {
            valor[i] = Integer.parseInt(x[i],2);
        }
        return valor;
    }
    public String toBase64(int [] x, String iguales) {
        String valores="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", aux="";
        for(int i=0; i < x.length; i++) {
            aux+=valores.charAt(x[i]);
        }
        return aux+iguales;
    }

    public String getTxtAscii() {
        return txtAscii;
    }

    public void setTxtAscii(String txtAscii) {
        this.txtAscii = txtAscii;
    }

    public String[] getBinaries() {
        return binaries;
    }

    public void setBinaries(String[] binaries) {
        this.binaries = binaries;
    }

    public JtableData getJt() {
        return jt;
    }

    public void setJt(JtableData jt) {
        this.jt = jt;
    }
}
