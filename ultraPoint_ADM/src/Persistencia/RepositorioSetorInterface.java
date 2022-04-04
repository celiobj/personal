/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Classes.Setor;
import java.util.Vector;
import javax.swing.JTable;

/**
 *
 * @author celio
 */
public interface RepositorioSetorInterface {
    
    public void adicionar(Setor se);
    public Vector listarSetor();
    public JTable consultatodos();
    public void excluir(String cod);
    
}
