/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Classes.Dia;
import java.util.Vector;

/**
 *
 * @author celio
 */
public interface RepositorioDiaInterface {
    
    public void adicionar(Dia dia);
    public void alterar (Dia dia, String onde, String hora);
    public Dia conferir(String data, String cod_funcionario);
    public void preencherMesZerado(Vector<Dia> vector, String query);
    
}
