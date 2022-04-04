
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Classes.Carro;
import javax.swing.JTable;

/**
 *
 * @author celio
 */
public interface RepositorioCarroInterface {


    public void adicionar(Carro car);
    public void reservar(Carro car);
    public void atualizarReservar(Carro car);
    public void alterarCarros(String cod, Carro car);
    public void alterarLivres(String cod, Carro car);
    public void excluir(String cod);
    public Carro procurar(String cod);
    public void transacao(String cod, String placa, String modelo, String transacao, String obs, String valor, String data);
    public String pegarCodigo(String placa);
    public String pegarPlaca(String modelo, String onde);
    public void remover (String placa);
    public JTable obterTodos();
    public JTable obterTodasTransacoes();
    public JTable filtrar(String cod);
    public double somarCreditoEsp(String cod);
    public double somarDebitoEsp(String cod);
    public double somarCredito(String cod);
    public double somarDebito(String cod);
    public long gerarCodigo();
    public void carregarCombo();
    public void carregarComboTodos();
    public void movTransacao(Carro car, String valor, String data, String transacao, String obs);
  
}
