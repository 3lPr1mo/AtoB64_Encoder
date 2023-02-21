package Modelo;

import javax.swing.*;
import java.util.Arrays;

public class Codificador {
    private String txtAscii;
    private String[] binaries;
    private JtableData jt;

    public Codificador(String txtAscii, String[] binaries) {
        this.txtAscii = txtAscii;
        this.binaries = binaries;
    }
    public Codificador() {
        this.txtAscii = "";
        this.binaries = null;
        this.jt = null;
    }


    //Esto es para que mas o menos se guie a la hora de conectar esto con el frame
    public void base64(String x){

        int [] eq_ascii = EquivalenciaDecimal(x, x.toCharArray()); //Se convierte a decimal
        String [] binary = EquivalenciaBinaria(eq_ascii); // se convierte a binario
        String [] Base64 = SepararEn6(Texto(binary)).split(","); //separa en 6 bits
        String aux = Iguales(Base64[Base64.length-1]); // obtiene los iguales que toca poner al final de la codificacion
        System.out.println("Cantidad de iguales: "+aux);
        Base64[Base64.length-1] = CompletarCeros(Base64[Base64.length-1]); //se completan los ceros.
        System.out.println("Nuevo Array con ceros completados: "+Arrays.toString(Base64));
        System.out.println(Arrays.toString(toDecimal(Base64)));
        String base64=toBase64(toDecimal(Base64),aux);
        System.out.println("Base64: "+base64);
    }
    public int [] EquivalenciaDecimal(String x, char[] caracteres){
        int [] ascii = new int [x.length()];
        for (int i = 0; i < x.length(); i++) {
            ascii[i] = caracteres[i];
        }
        System.out.println(Arrays.toString(ascii));
        return ascii;
    }
    public String[] EquivalenciaBinaria(int [] ascii){
        String [] binary = new String [ascii.length];
        for (int i = 0; i < ascii.length; i++) {
            binary[i] = Integer.toBinaryString(ascii[i]);
        }
        System.out.println("Equivalencia ascii: " +Arrays.toString(binary));
        System.out.println("Binario: "+Texto(binary));
        return binary;
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
