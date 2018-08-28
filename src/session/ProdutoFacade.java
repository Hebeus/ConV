/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;


import entities.Produto;
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
public class ProdutoFacade {

    @PersistenceContext(unitName = "ControllerPU")

    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("ControllerPU");
    private final EntityManager em = factory.createEntityManager();

    public List<Produto> findByDescricao(String descricao) {
        Query q = em.createQuery("SELECT p FROM Produto p WHERE P.descricao = :descricao");
        return q.setParameter("descricao", descricao).getResultList();
    }
        public List<Produto> findProdutoByCategoria(int categoriaId) {
        Query q = em.createQuery("SELECT p FROM Produto p WHERE p.categoriaId.id = :categoriaId");
        return q.setParameter("categoriaId", categoriaId).getResultList();
    }
}
