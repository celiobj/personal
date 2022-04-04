/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Classes.Funcao;
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
public class RepositorioFuncao implements RepositorioFuncaoInterface{

    @Override
    public void adicionar(Funcao fu) {
        
         try{
             	AccessDatabase a = new AccessDatabase();
        	Connection con = a.conectar();
                Statement st = con.createStatement();
        	st.execute("INSERT INTO `bd_ultrapoint`.`funcao` (`desc_funcao`) VALUES ('"+fu.getDescricao()+"');");
                con.close();
                        
                 JOptionPane.showMessageDialog(null,"Função Cadastrada com sucesso!!!");
                        
                        
                  
                }catch(Exception t){
                    
                
                    JOptionPane.showMessageDialog(null,"Registro não inserido!!! Inconsistência nos valores inseridos - "+t.getMessage());
                    
                  
                  }
        
        
    }
    
       public void excluir(String cod) {
        
         try{
             	AccessDatabase a = new AccessDatabase();
        	Connection con = a.conectar();
                Statement st = con.createStatement();
        	st.execute("DELETE from  `bd_ultrapoint`.`funcao` WHERE idfuncao= '"+cod+"'");
                con.close();
                        
                 JOptionPane.showMessageDialog(null,"Função excluída com sucesso!!!");
                        
                        
                       
                  
                }catch(Exception t){
                    
                
                    JOptionPane.showMessageDialog(null,"Registro não inserido!!! Inconsistência nos valores inseridos - "+t.getMessage());
                   
                  }
        
    }

    @Override
    public Vector listarFuncao() {
        
        Vector retorno = new Vector();
        retorno.addElement(" ");
          try{

              
                AccessDatabase a = new AccessDatabase();
                Connection con = a.conectar();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM bd_ultrapoint.funcao LIMIT 0, 1000");
                while(rs.next()){
                  
                    retorno.addElement(rs.getString("desc_funcao"));
                };
                               
                con.close();
                return retorno;

            }catch(Exception t){
                System.out.println(t.getMessage());
                return null;
        
    }
        
    }
    
    public JTable consultatodos() {

         try{
            Vector cabecalho = new Vector();
            Vector linhas = new Vector();
            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM funcao ORDER BY idfuncao");
            rs.next();
            ResultSetMetaData rsmd = rs.getMetaData();
                 cabecalho.addElement("Código ");
                 cabecalho.addElement("Função");
                 do {
                    linhas.addElement(proximaLinha(rs, rsmd));
                } while (rs.next());
                JTable tabela = new JTable(linhas, cabecalho);
                con.close();
                tabela.getColumnModel().getColumn(0).setPreferredWidth(100);
                tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
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
                                    case Types.VARCHAR: LinhaAtual.addElement(rs.getString(i));
                                    break;
                                   

                                }
	      			   }
	      	   }
	      	   catch(SQLException e){
	      	   }
	      	   return LinhaAtual;
         }
    
    
}
