/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Classes.Usuario;
import DAO.AccessDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author celio
 */
public class RepositorioUsuario implements RepositorioUsuarioInterface{

    public void adcionar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void alterar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String procurar(String login,String senha) {

        try{

                AccessDatabase a = new AccessDatabase();
                Connection con = a.conectar();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM usuario WHERE login = '"+login+"'");
                rs.next();
                Usuario usu = new Usuario();
                usu.setLogin(rs.getString("login"));
                usu.setSenha(rs.getString("senha"));
                if(usu.getSenha().equals(senha)){
                    con.close();
                    return "aceito";
                }else
                con.close();
                return "rejeitado" ;

            }catch(Exception t){
                System.out.println(t.getMessage());
                return null;

            }}

    public void remover(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
