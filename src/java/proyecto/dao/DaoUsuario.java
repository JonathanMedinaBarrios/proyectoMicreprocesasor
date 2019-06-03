/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import proyecto.modelo.Usuario;
import proyecto.util.JPAutil;

/**
 *
 * @author JONATHAN MEDINA
 */

public class DaoUsuario {
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public DaoUsuario() {
        this.emf = JPAutil.getEntityManagerFactory();
    }
    
    public List<Usuario> listado() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            List<Usuario> usuarios = em.createQuery("SELECT u FROM Usuario u order by  u.id asc").getResultList();
            return usuarios;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    
}
