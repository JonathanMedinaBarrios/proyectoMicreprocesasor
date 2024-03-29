/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.prueba;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.List;
import proyecto.dao.DaoUsuario;
import proyecto.modelo.Usuario;

/**
 *
 * @author JONATHAN MEDINA
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*DaoUsuario daoUsuario = new DaoUsuario(); 
        List<Usuario> lista = daoUsuario.listado(); 
        for(Usuario u : lista){
            System.out.println("nombre " +u.getNombreApellido());
        }*/
        
        Enumeration puertos; //busca todos los puertos y los guarda en el objeto puertos
        OutputStream ops;

        puertos = CommPortIdentifier.getPortIdentifiers(); //ojo tiene que tener la -s- al ultimo porque hay otro metodo sin -s-

        CommPortIdentifier portId; // identifica los puertos com

        SerialPort serialport; // esta clase abre puertos

        while (puertos.hasMoreElements()) { //para recorrer el numero de los puertos, y especificar con cual quiero trabajar 
            //hasmorelements mientras tenga mas eleementos
            portId = (CommPortIdentifier) puertos.nextElement(); //next elemento recorre uno por uno
            System.out.println(portId.getName()); //puertos disponbibles
            if (portId.getName().equalsIgnoreCase("COM3")) {
                try {
                    serialport = (SerialPort) portId.open("EscrituraSerial1", 57600);//tiempo en ms
                    ops = serialport.getOutputStream();
                    ops.write("Prueba".getBytes()); //get bytes transforma el string a bytes
                    ops.close();
                    serialport.close();
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        }

    }

}
