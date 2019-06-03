/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.api;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import proyecto.dao.DaoUsuario;
import proyecto.modelo.Puerto;
import proyecto.modelo.Usuario;
/**
 *
 * @author JONATHAN MEDINA
 */
@Path("usuarios")
public class Usuarios_Sevicios {
    
    
    List<Usuario> lista = new ArrayList<>(); 
    DaoUsuario dao = new DaoUsuario(); 
    Puerto puerto = new Puerto();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Usuario> usuarios(){  
       lista = dao.listado(); 
       return lista;
    }
    
    @Path("llamar")
    @GET
    public void escribirMensaje(@DefaultValue("") @QueryParam("mensaje") String mensaje){
        try {
            puerto.writeSerial(mensaje);
        } catch (Exception e) {
            
        }
    }
    
}
