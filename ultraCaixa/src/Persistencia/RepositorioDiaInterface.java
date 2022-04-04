/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Classes.Dia;



/**
 *
 * @author celio
 */
public interface RepositorioDiaInterface {

    
    public void adicionar(Dia dia);
    public Dia pegarUltimo();
    public int diaAtualAberto(String data);
    public void fechar(String cod);
    public void reabrir(String cod);
    public String pegarCodDia(String data);
   
    

}
