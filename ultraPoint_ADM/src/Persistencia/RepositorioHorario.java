/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Classes.Horario;
import Classes.Setor;
import DAO.AccessDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author celio
 */
public class RepositorioHorario implements RepositorioHorarioInterface{
    
     public JTable consultatodos() {

         try{
            Vector cabecalho = new Vector();
            Vector linhas = new Vector();
            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM horario ORDER BY idhorario");
            rs.next();
            ResultSetMetaData rsmd = rs.getMetaData();
                 cabecalho.addElement("Código ");
                 cabecalho.addElement("Setor");
                 cabecalho.addElement("Função");
                 cabecalho.addElement("1a Entrada");
                 cabecalho.addElement("1a Saída");                 
                 cabecalho.addElement("2a Entrada");
                 cabecalho.addElement("2a Saída");
                do {
                    linhas.addElement(proximaLinha(rs, rsmd));
                } while (rs.next());
                JTable tabela = new JTable(linhas, cabecalho);
                con.close();
                tabela.getColumnModel().getColumn(0).setPreferredWidth(70);
                tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
                tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
                tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
                tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
                tabela.getColumnModel().getColumn(5).setPreferredWidth(100);
                tabela.getColumnModel().getColumn(6).setPreferredWidth(100);

                return tabela;

   			}catch(Exception t){
        				System.out.println(t.getMessage());
                        return null;

        			}
    
    }
    private Vector proximaLinha(ResultSet rs, ResultSetMetaData rsmd) throws SQLException{
	      	   Vector LinhaAtual = new Vector();

	      	   try{
	      		   for (int i = 1; i <= rsmd.getColumnCount(); ++i){
                       switch(rsmd.getColumnType(i)){
                                   
                                    case Types.NVARCHAR: LinhaAtual.addElement(rs.getString(i));
                                    break;
                                    case Types.DATE: LinhaAtual.addElement(rs.getDate(i).toLocaleString().substring(0, 10));
                                    break;
                                    case Types.INTEGER: LinhaAtual.addElement(rs.getInt(i));
                                    break;
                                    case Types.NUMERIC: LinhaAtual.addElement((rs.getBigDecimal(i)));
                                    break;
                                    case Types.TIME: LinhaAtual.addElement((rs.getString(i)));
                                    break;
                                    case Types.VARCHAR: LinhaAtual.addElement(rs.getString(i));
                                    break;
                                   

                                }
	      			   }
	      	   }
	      	   catch(SQLException e){
	      	   }
	      	   return LinhaAtual;
         }

    @Override
    public void adicionar(Horario hor) {
        
          try{
             	AccessDatabase a = new AccessDatabase();
        	Connection con = a.conectar();
                Statement st = con.createStatement();
        	st.execute("INSERT INTO `bd_ultrapoint`.`horario` (`setor`,`funcao`,`entrada1`,`saida1`,`entrada2`,`saida2`) VALUES ('"+hor.getSetor()+"','"+hor.getFuncao()+"','"+hor.getEntrada1()+"','"+hor.getSaida1()+"','"+hor.getEntrada2()+"','"+hor.getSaida2()+"');");
                con.close();
                        
                 JOptionPane.showMessageDialog(null,"Horário Cadastrado com sucesso!!!");
                        
                        
                  
                }catch(Exception t){
                    
                
                    JOptionPane.showMessageDialog(null,"Registro não inserido!!! Inconsistência nos valores inseridos - "+t.getMessage());
                    
                  
                  }
        
        
    }
   
    
}
