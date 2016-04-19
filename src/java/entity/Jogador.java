/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import utilities.EnumPosicao;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Pgz
 */
public class Jogador {
    
    private Integer idJogador;
    private String nomeJogador;
    private Date dtNascimento;
    private String endereco;
    private Integer cpf;
    private Integer rg;
    private String eMail;
    private EnumPosicao posicao;
    private List<Integer> telefone;

    public Jogador() {
    }

    public Jogador(Integer idJogador, String nomeJogador, Date dtNascimento, String endereco, Integer cpf, Integer rg, List<Integer> telefone, String eMail, EnumPosicao posicao) {
        this.idJogador = idJogador;
        this.nomeJogador = nomeJogador;
        this.dtNascimento = dtNascimento;
        this.endereco = endereco;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.eMail = eMail;
        this.posicao = posicao;
    }

    public EnumPosicao getPosicao() {
        return posicao;
    }

    public void setPosicao(EnumPosicao posicao) {
        this.posicao = posicao;
    }

    public Integer getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(Integer idJogador) {
        this.idJogador = idJogador;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public List<Integer> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<Integer> telefone) {
        this.telefone = telefone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
        
    
}
