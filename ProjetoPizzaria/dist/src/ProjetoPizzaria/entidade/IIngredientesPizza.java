/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoPizzaria.entidade;

import ProjetoPizzaria.modelo.IngredientesPizza;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Casa
 */
public interface IIngredientesPizza {
    public void CadastrarIngredientes(IngredientesPizza ingPizza);
    public void PesquisarIngredientes (IngredientesPizza ingPizza, JTextField txtNomeIngrediente, JTable tblIngredientes);
    public void DeltarIngredientes (IngredientesPizza ingPizza, JTable tblIngredientes);
    public void PesquisarTudo(IngredientesPizza ingPizza, JTable tblIngredientes);
    public void AlterarNome_Tipo_Quantidade_QuantMax_QuantMin(IngredientesPizza ingPizza , JTable tblIngredientes,JTextField txtNome, JComboBox CbTipo, int quantidade, int quantMax,int quantMin);
    public void AlterarNome_Tipo_Quantidade_QuantMax(IngredientesPizza ingPizza, JTable tblIngredientes,JTextField txtNome,JComboBox CbTipo,int quantidade, int quantMax);
    public void AlterarNome_Tipo_Quantidade_QuantMin(IngredientesPizza ingPizza, JTable tblIngredientes,JTextField txtNome,JComboBox CbTipo,int quantidade, int quantMin);
    public void AlterarNome_Tipo_QuantMax_QuantMin(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome,JComboBox CbTipo, int quantMax, int quantMin);
    public void AlterarNome_Quantidade_QuantMax_QuantMin(IngredientesPizza ingPizza, JTable tblIngredientes,JTextField txtNome, int quantidade, int quantMax, int quantMin);
    public void AlterarTipo_Quantidade_QuantMax_QuantMin(IngredientesPizza ingPizza, JTable tblIngredientes, JComboBox CbTipo, int quantidade, int quantMax, int quantMin);
    public void AlterarNome_Tipo_QuantMax(IngredientesPizza ingPizza, JTable tblIngredientes,JTextField txtNome,JComboBox CbTipo, int quantMax);
    public void AlterarNome_Tipo_QuantMin(IngredientesPizza ingPizza, JTable tblIngredientes,JTextField txtNome,JComboBox CbTipo, int quantMin);
    public void AlterarNome_Quantidade_QuantMax(IngredientesPizza ingPizza, JTable tblIngredientes,JTextField txtNome, int quantidade, int quantMax);
    public void AlterarNome_Quantidade_QuantMin(IngredientesPizza ingPizza, JTable tblIngredientes,JTextField txtNome, int quantidade, int quantMin);
    public void AlterarNome_QuantMax_QuantMin(IngredientesPizza ingPizza, JTable tblIngredientes,JTextField txtNome, int quantMax, int quantMin);
    public void AlterarTipo_Quantidade_QuantMin(IngredientesPizza ingPizza,JTable tblIngredientes, JComboBox CbTipo, int quantidade, int quantMin);
    public void AlterarTipo_Quantidade_QuantMax(IngredientesPizza ingPizza,JTable tblIngredientes, JComboBox CbTipo, int quantidade, int quantMax);
    public void AlterarTipo_QuantMax_QuantMin(IngredientesPizza ingPizza, JTable tblIngredientes, JComboBox CbTipo, int quantMax, int quantMin);
    public void AlterarQuantidade_QuantMax_QuantMin(IngredientesPizza ingPizza,JTable tblIngredientes, int quantidade, int quantMax, int quantMin);
    public void AlterarNome_QuantMax(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, int quantMax);
    public void AlterarNome_QuantMin(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, int quantMin);
    public void AlterarTipo_QuantMax(IngredientesPizza ingPizza, JTable tblIngredientes, JComboBox CbTipo, int quantMax);
    public void AlterarTipo_QuantMin(IngredientesPizza ingPizza, JTable tblIngredientes, JComboBox CbTipo, int quantMin);
    public void AlterarQuantidade_QuantMax(IngredientesPizza ingPizza,JTable tblIngredientes, int quantidade, int quantMax);
    public void AlterarQuantidade_QuantMin(IngredientesPizza ingPizza,JTable tblIngredientes, int quantidade, int quantMin);
    public void AlterarQuantMax_QuantMin(IngredientesPizza ingPizza,JTable tblIngredientes, int quantMax, int quantMin);
    public void AlterarQuantMax(IngredientesPizza ingPizza, JTable tblIngredientes, int quantMax);   
    public void AlterarQuantMin(IngredientesPizza ingPizza , JTable tblIngredientes, int quantMin);
    public void AlterarTipoDeUnidade(IngredientesPizza ingPizza, JTable tblIngredientes, JComboBox CbTipo);
    public void AlterarNome_Quantidade(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtQuantidade, JTextField txtNome);
    public void AlterarNome_TIPO(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, JComboBox CbTipoMedida);
    public void AlterarQuantidade_TIPO(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtQuantidade, JComboBox CbTipo);
    public void AlterarNome_Quantidade_Tipo(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, JTextField txtQuantidade, JComboBox CbTipo);
    public void AlterarNomeIngrediente (IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNovoNomeIngrediente);
    public void AtualizarEstoqueIngrediente (IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtQuantidade);
    public void CorrigirEstoqueIngrediente (IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtQuantidade);
    public void PesquisarPorNome(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome);
    public void PesquisarPorQuantidadeIgual(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtQuantidade);
    public void PesquisarPorQuantidadeMaior(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtQuantidade);
    public void PesquisarPorQuantidadeMenor(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtQuantidade);
    public void PesquisarPorTipo(IngredientesPizza ingPizza, JTable tblIngredientes, JComboBox CbTipo);
    public void PesquisarPorID(IngredientesPizza ingPizza, JTable tblIngredientes,JTextField txtID);
    public void PesquisarPorNome_Quantidade_Tipo_IGUAL(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, JTextField txtQuantidade, JComboBox CbTipo);
    public void PesquisarPorNome_Quantidade_Tipo_MENOR(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, JTextField txtQuantidade, JComboBox CbTipo);
    public void PesquisarPorNome_Quantidade_Tipo_MAIOR(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, JTextField txtQuantidade, JComboBox CbTipo);
    public void PesquisarPorNome_Tipo(IngredientesPizza ingPizza, JTable tblIngredientes,JTextField txtNome, JComboBox CbTipo);
    public void PesquisarPorNome_Quantidade_IGUAL(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, JTextField txtQuantidade);
    public void PesquisarPorNome_Quantidade_MAIOR(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, JTextField txtQuantidade);
    public void PesquisarPorNome_Quantidade_MENOR(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, JTextField txtQuantidade);
    public void PesquisarPorTipo_Quantidade_IGUAL(IngredientesPizza ingPizza, JTable tblIngredientes, JComboBox CbTipo, JTextField txtQuantidade);
    public void PesquisarPorTipo_Quantidade_MAIOR(IngredientesPizza ingPizza, JTable tblIngredientes, JComboBox CbTipo, JTextField txtQuantidade);
    public void PesquisarPorTipo_Quantidade_MENOR(IngredientesPizza ingPizza, JTable tblIngredientes, JComboBox CbTipo, JTextField txtQuantidade);
    public void PesquisarId_Nome_Tipo_PorNome(IngredientesPizza ingPizza, JTable tblIngredientes,JTextField txtNome);
    public void PesquisarId_Nome_Tipo(IngredientesPizza ingPizza,JTable tblIngredientes);
}