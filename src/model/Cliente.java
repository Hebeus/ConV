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
public class Cliente implements Serializable{
    
    private String razaoSocial;
    private String cpf;
    private String rg;
    private String endereco;
    private ArrayList<RegistroDeVendas> registroDeVendasCliente;
    private ArrayList<RegistroDeVendas> registroDeVendasGeral;

    public Cliente(String razaoSocial, String cpf, String rg, String endereco, ArrayList<RegistroDeVendas> registroDeVendasGeral) {
        this.razaoSocial = razaoSocial;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.registroDeVendasGeral = registroDeVendasGeral;
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<RegistroDeVendas> getRegistroDeVendasCliente() {
        return registroDeVendasCliente;
    }

    public void setRegistroDeVendasCliente(ArrayList<RegistroDeVendas> registroDeVendasCliente) {
        this.registroDeVendasCliente = registroDeVendasCliente;
    }

    public ArrayList<RegistroDeVendas> getRegistroDeVendasGeral() {
        return registroDeVendasGeral;
    }

    public void setRegistroDeVendasGeral(ArrayList<RegistroDeVendas> registroDeVendasGeral) {
        this.registroDeVendasGeral = registroDeVendasGeral;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
