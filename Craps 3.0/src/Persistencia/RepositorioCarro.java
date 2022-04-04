/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Classes.Carro;
import DAO.AccessDatabase;
import GUI.Controle_carros;
import GUI.RelatorioCarro;
import GUI.VerificarUsuario;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Vector;
import javax.swing.JTable;

/**
 *
 * @author celio
 */
public class RepositorioCarro implements RepositorioCarroInterface {

    public void adicionar(Carro car) {
       try{

        	AccessDatabase a = new AccessDatabase();
        	Connection con = a.conectar();
                Statement st = con.createStatement();
        	st.execute("INSERT INTO Carros (cod_carro,placa,modelo,obs,Status) VALUES('"+car.getCod_carro()+"','"+car.getPlaca()+"','"+car.getModelo()+"','"+car.getObs()+"','"+car.getStatus()+"')");
                st.execute("INSERT INTO Livres (cod_carro,placa,modelo,obs) VALUES('"+car.getCod_carro()+"','"+car.getPlaca()+"','"+car.getModelo()+"','"+car.getObs()+"')");
                        con.close();

        			}catch(Exception t){
        				System.out.println(t.getMessage());


        			}
    }
    
        public void reservar(Carro car) {
       try{

        	AccessDatabase a = new AccessDatabase();
        	Connection con = a.conectar();
                Statement st = con.createStatement();
        	st.execute("INSERT INTO Reservados (cod_carro,placa,modelo,obs) VALUES('"+car.getCod_carro()+"','"+car.getPlaca()+"','"+car.getModelo()+"','"+car.getObs()+"')");
                st.execute("DELETE FROM Livres WHERE (placa)=('"+car.getPlaca()+"')"); 
                con.close();

        			}catch(Exception t){
        				System.out.println(t.getMessage());


        			}
    }
    public void atualizarReservar(Carro car) {
       try{

        	AccessDatabase a = new AccessDatabase();
        	Connection con = a.conectar();
                Statement st = con.createStatement();
        	st.executeQuery("UPDATE Carros SET Status= '"+car.getStatus()+"' WHERE placa ='"+car.getPlaca()+"'");
                con.close();

        			}catch(Exception t){
        				System.out.println(t.getMessage());


        			}
    }

    public void remover(String placa) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public JTable obterTodos() {



         try{
            Vector cabecalho = new Vector();
            Vector linhas = new Vector();
            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT cod_carro,placa, modelo,obs, Status FROM Carros WHERE (cod_carro > 0)ORDER BY op");
            rs.next();
            ResultSetMetaData rsmd = rs.getMetaData();
                 cabecalho.addElement("Código");
                 cabecalho.addElement("Placa");
                 cabecalho.addElement("Modelo");
                 cabecalho.addElement("Observação");
                 cabecalho.addElement("Status");

                 
                do {
                    linhas.addElement(proximaLinha(rs, rsmd));
                } while (rs.next());
                JTable tabela = new JTable(linhas, cabecalho);
                con.close();
                tabela.getColumnModel().getColumn(0).setPreferredWidth(70);
                tabela.getColumnModel().getColumn(1).setPreferredWidth(150);
                tabela.getColumnModel().getColumn(2).setPreferredWidth(350);
                tabela.getColumnModel().getColumn(3).setPreferredWidth(350);
                tabela.getColumnModel().getColumn(4).setPreferredWidth(350);
               
           
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
                       case Types.VARCHAR: LinhaAtual.addElement(rs.getString(i));
	      			   break;
	      			   case Types.TIMESTAMP: LinhaAtual.addElement(rs.getDate(i).toLocaleString().substring(0, 10));
	      			   break;
	      			   case Types.INTEGER: LinhaAtual.addElement(rs.getInt(i));
	      			   break;
                                    case Types.NUMERIC: LinhaAtual.addElement(VerificarUsuario.paraFormatoDinheiro(rs.getBigDecimal(i)));
                       break;

                                }
	      			   }
	      	   }
	      	   catch(SQLException e){
	      	   }
	      	   return LinhaAtual;


	            }

 
    public long gerarCodigo() {
         try{
            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Carros WHERE (cod_carro) =(SELECT Max(cod_carro) FROM Carros)");
            rs.next();
            long cod_int = rs.getInt("cod_carro");
            long cod = (cod_int) + 1;
            con.close();

            return cod;

   			}catch(Exception t){
        				System.out.println(t.getMessage());
                        return 0;

        			}
    }

    public String pegarPlaca(String modelo, String onde) {

        try{
            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM "+onde+" WHERE (modelo) =('"+modelo+"')");
            rs.next();
            String placa = rs.getString("placa");

            con.close();

            return placa;

   			}catch(Exception t){
        				System.out.println(t.getMessage());
                        return null;

        			}

    }

    public void transacao(String cod, String placa, String modelo, String transacao, String obs, String valor, String data) {

         try{

        	AccessDatabase a = new AccessDatabase();
        	Connection con = a.conectar();
                Statement st = con.createStatement();
        	st.execute("INSERT INTO Transacoes (cod_carro,placa,modelo,transacao,obs,valor,data) VALUES('"+cod+"','"+placa+"','"+modelo+"','"+transacao+"','"+obs+"',"+valor+",'"+data+"')");
                con.close();

        			}catch(Exception t){
        				System.out.println(t.getMessage());


        			}

    }
    
    
     public void alterarCarros(String cod, Carro car) {
        try{

                AccessDatabase a = new AccessDatabase();
                Connection con = a.conectar();
                Statement st = con.createStatement();
                st.executeQuery("UPDATE Carros SET placa= '"+car.getPlaca()+"',modelo='"+car.getModelo()+"',obs='"+car.getObs()+"' WHERE cod_carro = "+cod+"");
                con.close();


            }catch(Exception t){
                System.out.println(t.getMessage());


            }}

      public void alterarLivres(String cod, Carro car) {
        try{

                AccessDatabase a = new AccessDatabase();
                Connection con = a.conectar();
                Statement st = con.createStatement();
                st.executeQuery("UPDATE Livres SET placa= '"+car.getPlaca()+"',modelo='"+car.getModelo()+"',obs='"+car.getObs()+"' WHERE cod_carro = "+cod+"");
                con.close();


            }catch(Exception t){
                System.out.println(t.getMessage());


            }}
     
     
    public String pegarCodigo(String placa) {
        try{
            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Carros WHERE (placa) =('"+placa+"')");
            rs.next();
            String cod = rs.getString("cod_carro");

            con.close();

            return cod;

   			}catch(Exception t){
        				System.out.println(t.getMessage());
                                       
                        return null;

        			}
    }

    public Carro procurar(String cod) {
      try{
            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Carros WHERE (cod_carro) =("+cod+")");
            rs.next();

            Carro car = new Carro();
            car.setModelo(rs.getString("modelo"));
            car.setPlaca(rs.getString("placa"));
            car.setObs(rs.getString("obs"));
            car.setStatus(rs.getString("Status"));
           

            con.close();

            return car;

   			}catch(Exception t){
        				System.out.println(t.getMessage());
                        return null;

        			}
    }

    public void carregarCombo() {
         try{

            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT (placa) FROM Carros WHERE (cod_carro)> 0 AND (Status) <> 'Excluido'");
            rs.next();
            ResultSetMetaData rsmd = rs.getMetaData();

            do {
                Controle_carros.carros.addElement(proximaLinha(rs, rsmd));
                } while (rs.next());

                con.close();



   			}catch(Exception t){
        				System.out.println(t.getMessage());


        			}
    }

    public void movTransacao(Carro car, String valor, String data, String transacao, String obs) {
         try{

        	AccessDatabase a = new AccessDatabase();
        	Connection con = a.conectar();
                Statement st = con.createStatement();
        	st.execute("INSERT INTO Transacoes (cod_carro,placa,modelo,transacao,obs,valor,data) VALUES('"+car.getCod_carro()+"','"+car.getPlaca()+"','"+car.getModelo()+"','"+transacao+"','"+obs+"','"+valor+"','"+data+"')");
                con.close();

        			}catch(Exception t){
        				System.out.println(t.getMessage());


        			}
    }

    public JTable filtrar(String cod) {
        try{
            Vector cabecalho = new Vector();
            Vector linhas = new Vector();
            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT cod_carro,placa, modelo, transacao,obs, valor,data FROM Transacoes WHERE (cod_carro ="+cod+")ORDER BY op");
            rs.next();
            ResultSetMetaData rsmd = rs.getMetaData();
                 cabecalho.addElement("Código");
                 cabecalho.addElement("Placa");
                 cabecalho.addElement("Modelo");
                 cabecalho.addElement("Transação");
                 cabecalho.addElement("Observação");
                 cabecalho.addElement("Valor");
                 cabecalho.addElement("Data");


                do {
                    linhas.addElement(proximaLinha(rs, rsmd));
                } while (rs.next());
                JTable tabela = new JTable(linhas, cabecalho);
                con.close();
                tabela.getColumnModel().getColumn(0).setPreferredWidth(70);
                tabela.getColumnModel().getColumn(1).setPreferredWidth(150);
                tabela.getColumnModel().getColumn(2).setPreferredWidth(350);
                tabela.getColumnModel().getColumn(3).setPreferredWidth(350);
                tabela.getColumnModel().getColumn(4).setPreferredWidth(350);


                return tabela;

   			}catch(Exception t){
        				System.out.println(t.getMessage());
                        return null;

        			}
    }

    public double somarCredito(String cod) {
        try{
            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(valor) FROM Transacoes WHERE transacao = 'Credito'");
            rs.next();
            double soma = rs.getDouble(1);
            con.close();
                return soma;

   			}catch(Exception t){
        				System.out.println(t.getMessage());
                        return 0;

        			}
    }

    public double somarDebito(String cod) {
        
         try{
            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(valor) FROM Transacoes WHERE transacao = 'Debito'");
            rs.next();
            double soma = rs.getDouble(1);
            con.close();
                return soma;

   			}catch(Exception t){
        				System.out.println(t.getMessage());
                        return 0;

        			}

    }

    public JTable obterTodasTransacoes() {

         try{
            Vector cabecalho = new Vector();
            Vector linhas = new Vector();
            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT cod_carro,placa, modelo, transacao,obs, valor,data FROM Transacoes WHERE (cod_carro > 0)ORDER BY op");
            rs.next();
            ResultSetMetaData rsmd = rs.getMetaData();
                 cabecalho.addElement("Código");
                 cabecalho.addElement("Placa");
                 cabecalho.addElement("Modelo");
                 cabecalho.addElement("Transação");
                 cabecalho.addElement("Observação");
                 cabecalho.addElement("Valor");
                 cabecalho.addElement("Data");


                do {
                    linhas.addElement(proximaLinha(rs, rsmd));
                } while (rs.next());
                JTable tabela = new JTable(linhas, cabecalho);
                con.close();
                tabela.getColumnModel().getColumn(0).setPreferredWidth(70);
                tabela.getColumnModel().getColumn(1).setPreferredWidth(150);
                tabela.getColumnModel().getColumn(2).setPreferredWidth(350);
                tabela.getColumnModel().getColumn(3).setPreferredWidth(350);
                tabela.getColumnModel().getColumn(4).setPreferredWidth(350);


                return tabela;

   			}catch(Exception t){
        				System.out.println(t.getMessage());
                        return null;

        			}

    }

    public void carregarComboTodos() {

        try{

            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT (modelo) FROM Carros WHERE (cod_carro)> 0 ");
            rs.next();
            ResultSetMetaData rsmd = rs.getMetaData();

            do {
                RelatorioCarro.carros.addElement(proximaLinha(rs, rsmd));
                } while (rs.next());

                con.close();



   			}catch(Exception t){
        				System.out.println(t.getMessage());


        			}


    }

    public double somarCreditoEsp(String cod) {

        try{
            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(valor) FROM Transacoes WHERE transacao = 'Credito' AND cod_carro = "+cod+"");
            rs.next();
            double soma = rs.getDouble(1);
            con.close();
                return soma;

   			}catch(Exception t){
        				System.out.println(t.getMessage());
                        return 0;

        			}

    }

    public double somarDebitoEsp(String cod) {
        
         try{
            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(valor) FROM Transacoes WHERE transacao = 'Debito' AND cod_carro = "+cod+"");
            rs.next();
            double soma = rs.getDouble(1);
            con.close();
                return soma;

   			}catch(Exception t){
        				System.out.println(t.getMessage());
                        return 0;

        			}

    }

    public void excluir(String cod) {

        
        try{           
        				AccessDatabase a = new AccessDatabase();
        				Connection con = a.conectar();
                                        Statement st = con.createStatement();
        				st.executeUpdate("DELETE FROM Livres WHERE cod_carro = "+cod+"");
                                        st.executeQuery("UPDATE Carros SET Status= 'Excluido' WHERE cod_carro = "+cod+"");
               
                                        con.close();


        			}catch(Exception t){
        				System.out.println(t.getMessage());


        			}
    }
    
}

  