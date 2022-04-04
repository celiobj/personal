/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Classes.Funcionario;
import java.util.Vector;
import javax.swing.JTable;

/**
 *
 * @author celio
 */
public interface RepositorioFuncionarioInterface {
    
    public void adicionar(Funcionario fu);
    public JTable consultatodos();
    public Vector listarFuncionarios();
    public int consultarUltimo();
    public void excluir(String cod);
    public void alterar (String cod, Funcionario fun);
    
}
