/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wesle
 */
@Entity
@Table(name = "categoria_produto", catalog = "ControleDeVendas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaProduto.findAll", query = "SELECT c FROM CategoriaProduto c"),
    @NamedQuery(name = "CategoriaProduto.findById", query = "SELECT c FROM CategoriaProduto c WHERE c.id = :id"),
    @NamedQuery(name = "CategoriaProduto.findByDescricao", query = "SELECT c FROM CategoriaProduto c WHERE c.descricao = :descricao")})
public class CategoriaProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String descricao;

    public CategoriaProduto() {
    }

    public CategoriaProduto(Integer id) {
        this.id = id;
    }

    public CategoriaProduto(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaProduto)) {
            return false;
        }
        CategoriaProduto other = (CategoriaProduto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CategoriaProduto[ id=" + id + " ]";
    }
    
}
