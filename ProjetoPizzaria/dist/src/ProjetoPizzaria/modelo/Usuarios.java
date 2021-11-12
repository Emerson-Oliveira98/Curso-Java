/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoPizzaria.modelo;

/**
 *
 * @author Casa
 */
public class Usuarios {
    private int IdUsuario;
    private String NomeUsuario;
    private String SobrenomeUsuario;
    private String CPF;
    private String ruaEndereco;
    private int NumCasa;
    private String CEP;
    private String Complemento;
    private String Funcao;
    private Double Salario;
    private String LoginUsuario;
    private String Senha;
    private String ConfirmaSenha;

    
      public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }
    public String getNomeUsuario() {
        return NomeUsuario;
    }

    public void setNomeUsuario(String NomeUsuario) {
        this.NomeUsuario = NomeUsuario;
    }

    public String getSobrenomeUsuario() {
        return SobrenomeUsuario;
    }

    public void setSobrenomeUsuario(String SobrenomeUsuario) {
        this.SobrenomeUsuario = SobrenomeUsuario;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRuaEndereco() {
        return ruaEndereco;
    }

    public void setRuaEndereco(String ruaEndereco) {
        this.ruaEndereco = ruaEndereco;
    }

    public int getNumCasa() {
        return NumCasa;
    }

    public void setNumCasa(int NumCasa) {
        this.NumCasa = NumCasa;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String Complemento) {
        this.Complemento = Complemento;
    }

    public String getFuncao() {
        return Funcao;
    }

    public void setFuncao(String Funcao) {
        this.Funcao = Funcao;
    }

    public Double getSalario() {
        return Salario;
    }

    public void setSalario(Double Salario) {
        this.Salario = Salario;
    }

    public String getLoginUsuario() {
        return LoginUsuario;
    }

    public void setLoginUsuario(String LoginUsuario) {
        this.LoginUsuario = LoginUsuario;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getConfirmaSenha() {
        return ConfirmaSenha;
    }

    public void setConfirmaSenha(String ConfirmaSenha) {
        this.ConfirmaSenha = ConfirmaSenha;
    }
}
