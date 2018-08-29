/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;
import entities.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author wesle
 */
public class ClienteFacade {
    @PersistenceContext(unitName = "ControllerPU")

    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("ControllerPU");
    private final EntityManager em = factory.createEntityManager();

       public void InsertCliente(Cliente cliente ) {
           em.getTransaction().begin();
           em.persist(cliente);
           em.getTransaction().commit();
           em.close();
        
       }
        public List<Cliente> findClientes() {
            Query q = em.createQuery("SELECT c FROM Cliente c ");
            return q.getResultList();
        }
        
  }

