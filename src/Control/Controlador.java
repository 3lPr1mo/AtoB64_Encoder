package Control;

import Modelo.Codificador;
import Modelo.Decodificador;
import Vista.Principal;

public class Controlador {
    private Principal frmPrincipal;
    private Codificador objC;
    private Decodificador objD;

    public Controlador() {
    }

    public void iniciar(){
        Codificador objC = new Codificador();
        objC.setTxtAscii("hola que hace");
        objC.base64(objC.getTxtAscii());
    }
}
