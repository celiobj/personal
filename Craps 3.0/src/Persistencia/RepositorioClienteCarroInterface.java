/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Classes.ClienteCarro;
import javax.swing.JTable;

/**
 *
 * @author celio
 */
public interface RepositorioClienteCarroInterface {

    public void adcionar(ClienteCarro cli);
    public ClienteCarro verificarExistente(String nome);
    public void alterar(String cod, ClienteCarro cli);
    public ClienteCarro procurar(String cod);
    public ClienteCarro procurarNome(String nome);
    public JTable listarClientes(String ref);
    public JTable listarTodos();

}
