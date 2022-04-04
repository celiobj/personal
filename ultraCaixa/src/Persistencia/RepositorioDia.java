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
        	st.execute("INSERT INTO `bd_ultracaixa`.`dia` (`saldo_anterior`,`dia_mes`,`saldo_atual`,`situacao`) VALUES ('"+dia.getSaldo_anterior()+"','"+dia.getDia_mes()+"','"+dia.getSaldo_atual()+"','"+dia.getSituacao()+"');");
                con.close();
                        
                 //JOptionPane.showMessageDialog(null,"Caixa fechado com sucesso!!!");
                        
                        
                       
                  
                }catch(Exception t){
                    
                
                    JOptionPane.showMessageDialog(null,"Registro não inserido!!! Inconsistência nos valores inseridos - "+t.getMessage());
                    
                  
                  }
        
        
    }

    @Override
    public Dia pegarUltimo() {
    
        Dia dia = new Dia();
          try{

              
                AccessDatabase a = new AccessDatabase();
                Connection con = a.conectar();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("Select * from bd_ultracaixa.dia where iddia = (select MAX(iddia) from bd_ultracaixa.dia)");
                rs.next();              
             
                 dia.setCodDia(rs.getString("iddia"));
                 dia.setDia_mes(rs.getString("dia_mes"));
                 dia.setSaldo_anterior(rs.getString("saldo_anterior"));
                 dia.setSaldo_atual(rs.getString("saldo_atual"));
                 dia.setSituacao(rs.getString("situacao"));
                                              
                con.close();
                return dia;

            }catch(Exception t){
                System.out.println(t.getMessage());
                return null;
        
    }
      
        
    }

     @Override
    public int diaAtualAberto(String data) {
    
        Dia dia = new Dia();
          try{

              
                AccessDatabase a = new AccessDatabase();
                Connection con = a.conectar();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("Select * from bd_ultracaixa.dia where dia_mes = "+data);
                if(rs.next()){              
             
                 dia.setCodDia(rs.getString("iddia"));
                 dia.setDia_mes(rs.getString("dia_mes"));
                 dia.setSaldo_anterior(rs.getString("saldo_anterior"));
                 dia.setSaldo_atual(rs.getString("saldo_atual"));
                 dia.setSituacao(rs.getString("situacao"));
                 con.close();
                 if(dia.getSituacao().equalsIgnoreCase("Fechado")){
                     return 1;
                 }else{
                     return 2;
                 }                        
                
                }else{
                    return 0;
                }
                    
                

            }catch(Exception t){
                System.out.println(t.getMessage());
                return 4;
        
    }
      
        
    }

    @Override
    public void fechar(String cod) {
        
         try{
             	AccessDatabase a = new AccessDatabase();
        	Connection con = a.conectar();
                Statement st = con.createStatement();
        	st.execute("UPDATE dia SET situacao = 'Fechado' WHERE iddia ="+cod);
                con.close();
                        
                 JOptionPane.showMessageDialog(null,"Caixa fechado com sucesso!!!");
                        
                        
                       
                  
                }catch(Exception t){
                    
                
                    JOptionPane.showMessageDialog(null,"Registro não inserido!!! Inconsistência nos valores inseridos - "+t.getMessage());
                    
                  
                  }
        
        
    }
    
    @Override
    public void reabrir(String cod) {
        
         try{
             	AccessDatabase a = new AccessDatabase();
        	Connection con = a.conectar();
                Statement st = con.createStatement();
        	st.execute("UPDATE dia SET situacao = 'Aberto' WHERE iddia ="+cod);
                con.close();
                        
                 JOptionPane.showMessageDialog(null,"Caixa reaberto com sucesso!!!");
                        
                        
                       
                  
                }catch(Exception t){
                    
                
                    JOptionPane.showMessageDialog(null,"Registro não inserido!!! Inconsistência nos valores inseridos - "+t.getMessage());
                    
                  
                  }
         
         
        
        
    }
     @Override
    public String pegarCodDia(String data) {
    
        Dia dia = new Dia();
          try{

              
                AccessDatabase a = new AccessDatabase();
                Connection con = a.conectar();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("Select * from bd_ultracaixa.dia where dia_mes = "+data);
                if(rs.next()){              
             
                 dia.setCodDia(rs.getString("iddia"));
                 dia.setDia_mes(rs.getString("dia_mes"));
                 dia.setSaldo_anterior(rs.getString("saldo_anterior"));
                 dia.setSaldo_atual(rs.getString("saldo_atual"));
                 dia.setSituacao(rs.getString("situacao"));
                 con.close();
                 
                    return dia.getCodDia();
                }
                    
                

            }catch(Exception t){
                System.out.println(t.getMessage());
                
        
    }
      
        return null;
    }

    
    
    
}
