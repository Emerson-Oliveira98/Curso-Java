/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoPizzaria.entidade;

import ProjetoPizzaria.modelo.Usuarios;

/**
 *
 * @author Casa
 */
public interface IUsuarios {
    public void VerificarLoginFuncionario(Usuarios usuario,String login);
    public void VerificarLoginGerente(Usuarios usuario,String login);
}
