/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

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
public class RepositorioSetor implements RepositorioSetorInterface{

    @Override
    public void adicionar(Setor se) {
        
          try{
             	AccessDatabase a = new AccessDatabase();
        	Connection con = a.conectar();
                Statement st = con.createStatement();
        	st.execute("INSERT INTO `bd_ultrapoint`.`setor` (`desc_setor`) VALUES ('"+se.getDescricao()+"');");
                con.close();
                        
                 JOptionPane.showMessageDialog(null,"Setor Cadastrado com sucesso!!!");
                        
                        
                  
                }catch(Exception t){
                    
                
                    JOptionPane.showMessageDialog(null,"Registro não inserido!!! Inconsistência nos valores inseridos - "+t.getMessage());
                    
                  
                  }
        
        
    }
    
     public void excluir(String cod) {
        
         try{
             	AccessDatabase a = new AccessDatabase();
        	Connection con = a.conectar();
                Statement st = con.createStatement();
        	st.execute("DELETE from  `bd_ultrapoint`.`setor` WHERE idsetor= '"+cod+"'");
                con.close();
                        
                 JOptionPane.showMessageDialog(null,"Setor excluído com sucesso!!!");
                        
                        
                       
                  
                }catch(Exception t){
                    
                
                    JOptionPane.showMessageDialog(null,"Registro não inserido!!! Inconsistência nos valores inseridos - "+t.getMessage());
                   
                  }
        
    }

    @Override
    public Vector listarSetor() {
        
        Vector retorno = new Vector();
        retorno.addElement(" ");
          try{

              
                AccessDatabase a = new AccessDatabase();
                Connection con = a.conectar();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM bd_ultrapoint.setor LIMIT 0, 1000");
                while(rs.next()){
                  
                    retorno.addElement(rs.getString("desc_setor"));
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
            ResultSet rs = st.executeQuery("SELECT * FROM setor ORDER BY idsetor");
            rs.next();
            ResultSetMetaData rsmd = rs.getMetaData();
                 cabecalho.addElement("Código ");
                 cabecalho.addElement("Setor");
                 cabecalho.addElement("Quantidade de funcionário");
                do {
                    linhas.addElement(proximaLinha(rs, rsmd));
                } while (rs.next());
                JTable tabela = new JTable(linhas, cabecalho);
                con.close();
                tabela.getColumnModel().getColumn(0).setPreferredWidth(70);
                tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
                tabela.getColumnModel().getColumn(2).setPreferredWidth(150);
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
