/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Classes.Dia;
import DAO.AccessDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author celio
 */
public class RepositorioDia implements RepositorioDiaInterface{
    
    public void adicionar(Dia dia){
       
        
        
         try{
             	AccessDatabase a = new AccessDatabase();
        	Connection con = a.conectar();
                Statement st = con.createStatement();
        	st.execute("INSERT INTO `bd_ultrapoint`.`dia` (`dia_mes`,`dia_semana`,`cod_funcionario`,`entrada1`,`saida1`,`entrada2`,`saida2`,`saldo`,`obs`,`status`) VALUES ('"+dia.getDia_mes()+"','"+dia.getDia_semana()+"','"+dia.getCod_func()+"','"+dia.getEntrada1()+"','"+dia.getSaida1()+"','"+dia.getEntrada2()+"','"+dia.getSaida2()+"','"+dia.getSaldo()+"','"+dia.getObs()+"','"+dia.getStatus()+"');");
                con.close();
                        
                 JOptionPane.showMessageDialog(null,"Registro efetuado com sucesso!!!");
                        
                        
                       
                  
                }catch(Exception t){
                    
                
                    JOptionPane.showMessageDialog(null,"Registro não inserido!!! Inconsistência nos valores inseridos - "+t.getMessage());
                   
                  }
        
    }

    @Override
    public Dia conferir(String data, String cod_funcionario) {
       
           try{

              
                AccessDatabase a = new AccessDatabase();
                Connection con = a.conectar();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM `bd_ultrapoint`.`dia` where dia_mes = '"+data+"' && cod_funcionario = '"+cod_funcionario+"'");
                rs.next();
                
                Dia dia = new Dia();
                dia.setCod_dia(rs.getString("iddia"));
                dia.setDia_mes(rs.getString("dia_mes"));
                dia.setDia_semana(rs.getString("dia_semana"));
                dia.setCod_func(rs.getString("cod_funcionario"));
                dia.setEntrada1(rs.getString("entrada1"));
                dia.setSaida1(rs.getString("saida1"));
                dia.setEntrada2(rs.getString("entrada2"));
                dia.setSaida2(rs.getString("saida2"));
                dia.setSaldo(rs.getString("saldo"));
                dia.setObs(rs.getString("obs"));
                dia.setStatus(rs.getString("status"));
              
                                              
                con.close();
                return dia;

            }catch(Exception t){
                System.out.println(t.getMessage());
                return null;
        
    }
        
    }

    @Override
    public void alterar(Dia dia, String onde, String hora) {
    
        
         try{
             	AccessDatabase a = new AccessDatabase();
        	Connection con = a.conectar();
                Statement st = con.createStatement();
        	st.executeUpdate("UPDATE `bd_ultrapoint`.`dia` SET `"+onde+"`='"+hora+"', `status`='"+dia.getStatus()+"' , `obs` = '"+dia.getObs()+"'WHERE `iddia`='"+dia.getCod_dia()+"'");
                con.close();
                        
                 JOptionPane.showMessageDialog(null,"Registro efetuado com sucesso!!!");
                        
                        
                       
                  
                }catch(Exception t){
                    
                
                    JOptionPane.showMessageDialog(null,"Registro não inserido!!! Inconsistência nos valores inseridos - "+t.getMessage());
                   
                  }
        

    }

    @Override
    public void preencherMesZerado(Vector <Dia> vector, String query) {

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
