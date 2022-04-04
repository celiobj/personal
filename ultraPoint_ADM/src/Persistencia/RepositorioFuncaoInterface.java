/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Classes.Funcao;
import java.util.Vector;
import javax.swing.JTable;

/**
 *
 * @author celio
 */
public interface RepositorioFuncaoInterface {
    
    public void adicionar(Funcao fu);
    public Vector listarFuncao();
    public JTable consultatodos();
    public void excluir(String cod);
    
}
