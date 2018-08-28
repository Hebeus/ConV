/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wesle
 */
@Entity
@Table(name = "produto_has_cliente", catalog = "ControleDeVendas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProdutoHasCliente.findAll", query = "SELECT p FROM ProdutoHasCliente p"),
    @NamedQuery(name = "ProdutoHasCliente.findById", query = "SELECT p FROM ProdutoHasCliente p WHERE p.id = :id"),
    @NamedQuery(name = "ProdutoHasCliente.findByQuantidade", query = "SELECT p FROM ProdutoHasCliente p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "ProdutoHasCliente.findByData", query = "SELECT p FROM ProdutoHasCliente p WHERE p.data = :data")})
public class ProdutoHasCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double quantidade;
    @Temporal(TemporalType.DATE)
    private Date data;
    @JoinColumn(name = "clienteId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Cliente clienteId;
    @JoinColumn(name = "produtoId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Produto produtoId;

    public ProdutoHasCliente() {
    }

    public ProdutoHasCliente(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    public Produto getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Produto produtoId) {
        this.produtoId = produtoId;
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
        if (!(object instanceof ProdutoHasCliente)) {
            return false;
        }
        ProdutoHasCliente other = (ProdutoHasCliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ProdutoHasCliente[ id=" + id + " ]";
    }
    
}
