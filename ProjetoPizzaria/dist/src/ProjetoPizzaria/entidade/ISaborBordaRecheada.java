/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoPizzaria.entidade;

import ProjetoPizzaria.modelo.SaborBordaRecheada;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Casa
 */
public interface ISaborBordaRecheada {
    public void AdicionarSaborBorda(SaborBordaRecheada saboBordRech);
    public void PesquisarInicial(SaborBordaRecheada saboBordRech, JTable tblSaborBorda);
    public void DeletarSabor(SaborBordaRecheada saboBordRech, JTable tblSaborBorda);
    public void AlterarNomeSabor(SaborBordaRecheada saboBordRech, JTable tblSaborBorda, JTextField txtNome);
    public void AlterarValor(SaborBordaRecheada saboBordRech, JTable tblSaborBorda, JTextField txtValor);
    public void AlterarNomeValor(SaborBordaRecheada saboBordRech, JTable tblSaborBorda,JTextField txtNome, JTextField txtValor);
    public void PesquisarPorID(SaborBordaRecheada saboBordRech, JTable tblSaborBorda, JTextField txtID);
    public void PesquisarPorNome(SaborBordaRecheada saboBordRech, JTable tblSaborBorda, JTextField txtNomeSabor);
    public void PesquisarPorValorMAIOR(SaborBordaRecheada saboBordRech, JTable tblSaborBorda, JTextField txtValor);
    public void PesquisarPorValorMENOR(SaborBordaRecheada saboBordRech, JTable tblSaborBorda, JTextField txtValor);
    public void PesquisarPorValorIGUAL(SaborBordaRecheada saboBordRech, JTable tblSaborBorda, JTextField txtValor);
    public void PesquisarInicialCombo(SaborBordaRecheada saboBordRech, JComboBox cbBordas);
    public void PesquisarValorPorNomeCombo(SaborBordaRecheada saboBordRech,JComboBox cbBordas, JTextField txtPrecoBorda);
    
}
