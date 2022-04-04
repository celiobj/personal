/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Classes.Horario;
import javax.swing.JTable;

/**
 *
 * @author celio
 */
public interface RepositorioHorarioInterface {
    
    public void adicionar(Horario hor);
    public JTable consultatodos();
    
}
