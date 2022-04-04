/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Classes.Funcionario;
import java.util.Vector;

/**
 *
 * @author celio
 */
public interface RepositorioFuncionarioInterface {
    
    public void adicionar(Funcionario fu);
    public Funcionario consultar (String cod_func);
    public Vector<Vector> consultarTodos();
    
    
}
