/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Classes.Dia;
import java.util.Vector;
import javax.swing.JTable;

/**
 *
 * @author celio
 */
public interface RepositorioDiaInterface {
    
    public JTable consultarDia(String data);
    public Vector<Vector> consultarMes(String cod_funcionario, String data_ini, String data_fim);
    public void alterarMes(Vector<Dia> dias);
    public void preencherMesZerado(Vector<Dia> vector, String query);
    
}
