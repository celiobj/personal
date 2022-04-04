/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Classes.Dia;
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
public class RepositorioDia implements RepositorioDiaInterface {

    @Override
    public JTable consultarDia(String data) {
        
        try{
            Vector cabecalho = new Vector();
            Vector linhas = new Vector();
            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT dia_mes,dia_semana,cod_funcionario,entrada1,saida1,entrada2,saida2,saldo,obs FROM bd_ultrapoint.dia WHERE dia_mes = '"+data+"'");
            rs.next();
            ResultSetMetaData rsmd = rs.getMetaData();
                 
                 cabecalho.addElement("Dia ");
                 cabecalho.addElement("Dia da semana");
                 cabecalho.addElement("Cód Funcionário");
                 cabecalho.addElement("1a Entrada");
                 cabecalho.addElement("1a Saída");
                 cabecalho.addElement("2a Entrada");
                 cabecalho.addElement("2a Saída");
                 cabecalho.addElement("Saldo");
                 cabecalho.addElement("Obs");
                
                do {
                    linhas.addElement(proximaLinha(rs, rsmd));
                } while (rs.next());
                JTable tabela = new JTable(linhas, cabecalho);
                con.close();
                tabela.getColumnModel().getColumn(0).setPreferredWidth(70);
                tabela.getColumnModel().getColumn(1).setPreferredWidth(70);
                tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
                tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
                tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
                tabela.getColumnModel().getColumn(5).setPreferredWidth(100);
                tabela.getColumnModel().getColumn(6).setPreferredWidth(100);
                tabela.getColumnModel().getColumn(7).setPreferredWidth(100);
                tabela.getColumnModel().getColumn(8).setPreferredWidth(100);
                
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
    public Vector<Vector> consultarMes(String funcionario, String data_ini, String data_fim) {
        
             Vector <Vector> retorno = new Vector<Vector>();
             Vector cod_dia = new Vector();
             Vector entrada1 = new Vector();
             Vector saida1 = new Vector();
             Vector entrada2 = new Vector();
             Vector saida2 = new Vector();
             Vector dia = new Vector();
             Vector dia_semana = new Vector();
             
             retorno.addElement(null);
          try{

              
                AccessDatabase a = new AccessDatabase();
                Connection con = a.conectar();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM bd_ultrapoint.dia WHERE cod_funcionario ='"+funcionario+"' AND  dia_mes BETWEEN '"+data_ini+"' and '"+data_fim+"'" );
                
                while(rs.next()){
                  
                    cod_dia.addElement(rs.getString("iddia"));
                    dia.addElement(rs.getString("dia_mes"));
                    entrada1.addElement(rs.getString("entrada1"));
                    saida1.addElement(rs.getString("saida1"));
                    entrada2.addElement(rs.getString("entrada2"));
                    saida2.addElement(rs.getString("saida2"));
                    dia_semana.add(rs.getString("dia_semana"));
                    
                    
                    
                   
                };
                
                    
                    retorno.addElement(dia);
                    retorno.addElement(entrada1);
                    retorno.addElement(saida1);
                    retorno.addElement(entrada2);
                    retorno.addElement(saida2);
                    retorno.addElement(cod_dia);
                
                con.close();               
                
                con.close();
                return retorno;

            }catch(Exception t){
                System.out.println(t.getMessage());
                return null;
        
    }
        
    }

    @Override
    public void alterarMes( Vector<Dia> dias) {
       
        try{
             	AccessDatabase a = new AccessDatabase();
        	Connection con = a.conectar();
                Statement st = con.createStatement();
                for(int i=0;i<dias.size();i++){
                    
                    
                    st.executeUpdate("UPDATE `bd_ultrapoint`.`dia` SET `entrada1`='"+dias.elementAt(i).getEntrada1() +"',`saida1`='"+dias.elementAt(i).getSaida1() +"',`entrada2`='"+dias.elementAt(i).getEntrada2() +"',`saida2`='"+dias.elementAt(i).getSaida2() +"' WHERE `iddia`='"+dias.elementAt(i).getCod_dia()+"';");

                    
                }
               
                        
                   JOptionPane.showMessageDialog(null, "Registros alterados com sucesso!!!");
                        
                        
                        
                        
                        
                        
                        
                con.close();
                        
                 
                        
                 //JOptionPane.showMessageDialog(null,"Registros Alterados com sucesso!!!");        
                       
                  
                }catch(Exception t){
                    
                
                    JOptionPane.showMessageDialog(null,"Registro não inserido!!! Inconsistência nos valores inseridos - "+t.getMessage());
                    System.out.println(t.getMessage());
                  }
        
        
    }

    @Override
    public void preencherMesZerado(Vector<Dia> vector, String query) {
        
        try{
             	AccessDatabase a = new AccessDatabase();
        	Connection con = a.conectar();
                Statement st = con.createStatement();
        	st.execute(query);
                con.close();
                        
                        
                        
                       
                  
                }catch(Exception t){
                    
                
                    JOptionPane.showMessageDialog(null,"Registro não inserido!!! Inconsistência nos valores inseridos - "+t.getMessage());
                   
                  }
        
    }

    
    
    
}
