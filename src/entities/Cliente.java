/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author wesle
 */
@Entity
@Table(catalog = "ControleDeVendas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findById", query = "SELECT c FROM Cliente c WHERE c.id = :id"),
    @NamedQuery(name = "Cliente.findByRazaoSocial", query = "SELECT c FROM Cliente c WHERE c.razaoSocial = :razaoSocial"),
    @NamedQuery(name = "Cliente.findByCpf", query = "SELECT c FROM Cliente c WHERE c.cpf = :cpf"),
    @NamedQuery(name = "Cliente.findByTelefone1", query = "SELECT c FROM Cliente c WHERE c.telefone1 = :telefone1"),
    @NamedQuery(name = "Cliente.findByTelefone2", query = "SELECT c FROM Cliente c WHERE c.telefone2 = :telefone2"),
    @NamedQuery(name = "Cliente.findByEndereco", query = "SELECT c FROM Cliente c WHERE c.endereco = :endereco"),
    @NamedQuery(name = "Cliente.findByCep", query = "SELECT c FROM Cliente c WHERE c.cep = :cep")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "razao_social", nullable = false, length = 50)
    private String razaoSocial;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String cpf;
    @Basic(optional = false)
    @Column(name = "telefone_1", nullable = false, length = 50)
    private String telefone1;
    @Column(name = "telefone_2", length = 50)
    private String telefone2;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String endereco;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String cep;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteId")
    private Collection<ProdutoHasCliente> produtoHasClienteCollection;

    public Cliente() {
    }

    public Cliente(Integer id) {
        this.id = id;
    }

    public Cliente(Integer id, String razaoSocial, String cpf, String telefone1, String endereco, String cep) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.cpf = cpf;
        this.telefone1 = telefone1;
        this.endereco = endereco;
        this.cep = cep;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @XmlTransient
    public Collection<ProdutoHasCliente> getProdutoHasClienteCollection() {
        return produtoHasClienteCollection;
    }

    public void setProdutoHasClienteCollection(Collection<ProdutoHasCliente> produtoHasClienteCollection) {
        this.produtoHasClienteCollection = produtoHasClienteCollection;
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return razaoSocial;
    }
    
}
