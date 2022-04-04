/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Classes.Funcionario;
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
public class RepositorioFuncionario implements RepositorioFuncionarioInterface{

    @Override
    public void adicionar(Funcionario fu) {
        
         try{
             	AccessDatabase a = new AccessDatabase();
        	Connection con = a.conectar();
                Statement st = con.createStatement();
        	st.execute("INSERT INTO `bd_ultrapoint`.`funcionario` (`nome`,`cpf`,`matricula`,`funcao`,`setor`) VALUES ('"+fu.getNome()+"','"+fu.getCpf()+"','"+fu.getMatricula()+"','"+fu.getFuncao()+"','"+fu.getSetor()+"');");
                con.close();
                        
                 JOptionPane.showMessageDialog(null,"Funcionário Cadastrado com sucesso!!!");
                        
                        
                       
                  
                }catch(Exception t){
                    
                
                    JOptionPane.showMessageDialog(null,"Registro não inserido!!! Inconsistência nos valores inseridos - "+t.getMessage());
                   
                  }
        
    }
    
     
    public void excluir(String cod) {
        
         try{
             	AccessDatabase a = new AccessDatabase();
        	Connection con = a.conectar();
                Statement st = con.createStatement();
        	st.execute("DELETE from  `bd_ultrapoint`.`funcionario` WHERE idfuncionario= '"+cod+"'");
                con.close();
                        
                 JOptionPane.showMessageDialog(null,"Funcionário excluído com sucesso!!!");
                        
                        
                       
                  
                }catch(Exception t){
                    
                
                    JOptionPane.showMessageDialog(null,"Registro não inserido!!! Inconsistência nos valores inseridos - "+t.getMessage());
                   
                  }
        
    }
    
    public void alterar(String cod, Funcionario fun) {
        
         try{
             	AccessDatabase a = new AccessDatabase();
        	Connection con = a.conectar();
                Statement st = con.createStatement();
        	st.execute("UPDATE `bd_ultrapoint`.`funcionario` SET `matricula`='"+fun.getMatricula()+"', `cpf`='"+fun.getCpf()+"', `nome`='"+fun.getNome()+"', `funcao`='"+fun.getFuncao()+"', `setor`='"+fun.getSetor()+"' WHERE `idfuncionario`='"+cod+"';");
                con.close();
                        
                 JOptionPane.showMessageDialog(null,"Funcionário alterado com sucesso!!!");
                        
                        
                       
                  
                }catch(Exception t){
                    
                
                    JOptionPane.showMessageDialog(null,"Registro não inserido!!! Inconsistência nos valores inseridos - "+t.getMessage());
                   
                  }
        
    }

    @Override
    public JTable consultatodos() {

         try{
            Vector cabecalho = new Vector();
            Vector linhas = new Vector();
            AccessDatabase a = new AccessDatabase();
            JTable tabela;
            try (Connection con = a.conectar()) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM bd_ultrapoint.funcionario ORDER BY idfuncionario");
                rs.next();
                ResultSetMetaData rsmd = rs.getMetaData();
                cabecalho.addElement("Código ");
                cabecalho.addElement("Matricula");
                cabecalho.addElement("CPF");
                cabecalho.addElement("Nome");
                cabecalho.addElement("Função");
                cabecalho.addElement("Setor");
                do {
                    linhas.addElement(proximaLinha(rs, rsmd));
                } while (rs.next());
                tabela = new JTable(linhas, cabecalho);
            }
                tabela.getColumnModel().getColumn(0).setPreferredWidth(70);
                tabela.getColumnModel().getColumn(1).setPreferredWidth(70);
                tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
                tabela.getColumnModel().getColumn(3).setPreferredWidth(150);
                tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
                tabela.getColumnModel().getColumn(5).setPreferredWidth(100);
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

    
    public Vector listarFuncionarios() {
        
        Vector retorno = new Vector();
        retorno.addElement(" ");
          try{

              
                AccessDatabase a = new AccessDatabase();
                Connection con = a.conectar();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM bd_ultrapoint.funcionario LIMIT 0, 1000");
                while(rs.next()){
                  
                    retorno.addElement(rs.getString("matricula"));
                };
                               
                con.close();
                return retorno;

            }catch(Exception t){
                System.out.println(t.getMessage());
                return null;
        
    }
        
    }

    @Override
    public int consultarUltimo() {
        int retorno;
          try{

              
                AccessDatabase a = new AccessDatabase();
                Connection con = a.conectar();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select matricula from bd_ultrapoint.funcionario where idfuncionario =(select MAX(idfuncionario) from bd_ultrapoint.funcionario)");
                rs.next();              
             
                 retorno = rs.getInt(1);
                                              
                con.close();
                return retorno;

            }catch(Exception t){
                System.out.println(t.getMessage());
                return 0;
        
    }
       
        
        
    }

 
       
       
    
}
