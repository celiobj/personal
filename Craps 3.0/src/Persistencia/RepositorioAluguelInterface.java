/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Classes.Aluguel;
import Classes.Carro;
import javax.swing.JTable;

/**
 *
 * @author celio
 */
public interface RepositorioAluguelInterface {


    public void adicionar(Aluguel alu);
     public void adicionarReservado(Aluguel alu);
    public void renovar(Aluguel alu);
    public Aluguel procurar(String cod);
    public void finalizar(Aluguel alu,String cod, Carro car);
    public void filtrarLivres(String onde);
    public void filtrarReservados(String onde);
    public void pagar(Aluguel alu,String cod, String valor, String data, String valor_pago, String onde, String valorTexto);
    public void abater(Aluguel alu,String cod, String valor, String data, String valor_pago, String onde, String valorTexto);
    public long gerarCodigo();
    public String pegarSaldo(String cod);
    public JTable procurarAlugados();
    public JTable filtroProcurar(String cod, String onde);
    
}
