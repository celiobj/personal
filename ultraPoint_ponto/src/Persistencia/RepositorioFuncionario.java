/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Classes.Funcionario;
import DAO.AccessDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author celio
 */
public class RepositorioFuncionario implements RepositorioFuncionarioInterface{

    @Override
    public void adicionar(Funcionario fu) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Funcionario consultar(String cod_func) {
        
           try{

              
                AccessDatabase a = new AccessDatabase();
                Connection con = a.conectar();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM `bd_ultrapoint`.`funcionario` where matricula = '"+cod_func+"'");
                rs.next();
                
                Funcionario fun = new Funcionario();
                fun.setNome(rs.getString("nome"));
                fun.setCod(rs.getString("idfuncionario"));
                                              
                con.close();
                return fun;

            }catch(Exception t){
                System.out.println(t.getMessage());
                return null;
        
    }
        
    }

    @Override
    public Vector<Vector> consultarTodos() {

        Vector<Vector> retorno = null;
        Vector cod = new Vector();
        Vector nome = new Vector();
        try{

              
                AccessDatabase a = new AccessDatabase();
                Connection con = a.conectar();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM `bd_ultrapoint`.`funcionario` ");
                rs.next();
                
                cod.add(rs.getString("idfuncionario"));
                nome.add(rs.getString("nome"));                            
                con.close();
                retorno.add(cod);
                retorno.add(nome);
                
                return retorno;

            }catch(Exception t){
                System.out.println(t.getMessage());
                return null;
        
    }
    }

 
       
        
        
    }
    

