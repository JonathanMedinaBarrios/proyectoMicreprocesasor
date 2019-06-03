/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author JONATHAN MEDINA BARRIOS
 */
public class JPAutil {

    private static final EntityManagerFactory emf;

    static {
        try{
        emf = Persistence.createEntityManagerFactory("proyectoMatriz8x8PU"); 
        }catch(Throwable t){
            System.err.println("Error al iniciar Entity Manager Factory:" + t);
            throw new ExceptionInInitializerError(); 
        }
    }
    
    public static EntityManagerFactory getEntityManagerFactory(){
        return emf; 
    }
}
