/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author wesle
 */
public class Produto implements Serializable{
    
    private String descricao;
    private CategoriaProduto categoria;
    
//Lista que servirá somente para exibir as opções de categorias na hora
    // de cadastrar um produto. Ou seja, a instancia do produto estiver formada
    // ele só irá exibir a categoria selecionada e não esta lista.
    private ArrayList<CategoriaProduto> opcoesDeCategorias;

    public Produto(String descricao, CategoriaProduto categoria) {
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }
    
    
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
