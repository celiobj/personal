/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Classes.Aluguel;
import Classes.Carro;
import DAO.AccessDatabase;
import GUI.AlugarCarro;
import GUI.VerificarUsuario;
import GUI.reservarCarro;
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
public class RepositorioAluguel implements RepositorioAluguelInterface {

    public void adicionar(Aluguel alu) {
        try {

            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            st.execute("INSERT INTO Aluguel (cod_aluguel,placa,modelo,valor,nome, hora, data, data_ent, data_peg,data_pag,Status) VALUES('" + alu.getCod_aluguel() + "','" + alu.getPlaca() + "','" + alu.getModelo() + "','" + alu.getValor() + "','" + alu.getNome() + "','" + alu.getHora() + "','" + alu.getData() + "','" + alu.getData_ent() + "','" + alu.getData_peg() + "','" + alu.getData_pag() + "','" + alu.getStatus() + "')");
            st.execute("INSERT INTO Alugados (cod_aluguel,placa,modelo,valor,nome, hora, data, data_ent, data_peg,data_pag,Status) VALUES('" + alu.getCod_aluguel() + "','" + alu.getPlaca() + "','" + alu.getModelo() + "'," + alu.getValor() + ",'" + alu.getNome() + "','" + alu.getHora() + "','" + alu.getData() + "','" + alu.getData_ent() + "','" + alu.getData_peg() + "','" + alu.getData_pag() + "','" + alu.getStatus() + "')");
            st.executeUpdate("UPDATE Carros SET Status= 'Alugado p/ " + alu.getNome() + "' WHERE placa=('" + alu.getPlaca() + "')");
            st.execute("DELETE FROM Livres WHERE (placa)=('" + alu.getPlaca() + "')");

            con.close();

        } catch (Exception t) {
            System.out.println(t.getMessage());

        }
    }

    public void adicionarReservado(Aluguel alu) {
        try {

            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            st.execute("INSERT INTO Aluguel (cod_aluguel,placa,modelo,valor,nome, hora, data, data_ent, data_peg,data_pag,Status) VALUES('" + alu.getCod_aluguel() + "','" + alu.getPlaca() + "','" + alu.getModelo() + "','" + alu.getValor() + "','" + alu.getNome() + "','" + alu.getHora() + "','" + alu.getData() + "','" + alu.getData_ent() + "','" + alu.getData_peg() + "','" + alu.getData_pag() + "','" + alu.getStatus() + "')");
            st.execute("INSERT INTO Alugados (cod_aluguel,placa,modelo,valor,nome, hora, data, data_ent, data_peg,data_pag,Status) VALUES('" + alu.getCod_aluguel() + "','" + alu.getPlaca() + "','" + alu.getModelo() + "'," + alu.getValor() + ",'" + alu.getNome() + "','" + alu.getHora() + "','" + alu.getData() + "','" + alu.getData_ent() + "','" + alu.getData_peg() + "','" + alu.getData_pag() + "','" + alu.getStatus() + "')");
            st.executeUpdate("UPDATE Carros SET Status= 'Alugado p/ " + alu.getNome() + "' WHERE placa=('" + alu.getPlaca() + "')");
            st.execute("DELETE FROM Reservados WHERE (placa)=('" + alu.getPlaca() + "')");

            con.close();

        } catch (Exception t) {
            System.out.println(t.getMessage());

        }
    }

    public void renovar(Aluguel alu) {
        try {

            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM Alugados WHERE cod_aluguel = " + alu.getCod_aluguel() + "");
            st.execute("INSERT INTO Aluguel (cod_aluguel,placa,modelo,valor,nome, hora, data, data_ent, data_peg,data_pag,Status) VALUES('" + alu.getCod_aluguel() + "','" + alu.getPlaca() + "','" + alu.getModelo() + "','" + alu.getValor() + "','" + alu.getNome() + "','" + alu.getHora() + "','" + alu.getData() + "','" + alu.getData_ent() + "','" + alu.getData_peg() + "','" + alu.getData_pag() + "','" + alu.getStatus() + "')");
            st.execute("INSERT INTO Alugados (cod_aluguel,placa,modelo,valor,nome, hora, data, data_ent, data_peg,data_pag,Status) VALUES('" + alu.getCod_aluguel() + "','" + alu.getPlaca() + "','" + alu.getModelo() + "'," + alu.getValor() + ",'" + alu.getNome() + "','" + alu.getHora() + "','" + alu.getData() + "','" + alu.getData_ent() + "','" + alu.getData_peg() + "','" + alu.getData_pag() + "','" + alu.getStatus() + "')");
            st.executeUpdate("UPDATE Carros SET Status= 'Alugado - Renovado p/ " + alu.getNome() + "' WHERE placa=('" + alu.getPlaca() + "')");

            con.close();

        } catch (Exception t) {
            System.out.println(t.getMessage());

        }
    }

    public void finalizar(Aluguel alu, String cod, Carro car) {

        try {

            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM Alugados WHERE cod_aluguel=(" + cod + ")");
            st.execute("INSERT INTO Livres (cod_carro,placa,modelo,obs) VALUES(" + car.getCod_carro() + ",'" + car.getPlaca() + "','" + car.getModelo() + "','" + car.getObs() + "')");
            st.executeUpdate("UPDATE Carros SET Status= 'Livre' WHERE placa=('" + car.getPlaca() + "')");

            con.close();

        } catch (Exception t) {
            System.out.println(t.getMessage());

        }

    }

    public long gerarCodigo() {
        try {
            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Aluguel WHERE (cod_aluguel) =(SELECT Max(cod_aluguel) FROM Aluguel)");
            rs.next();
            long cod_int = rs.getInt("cod_aluguel");
            long cod = (cod_int) + 1;
            con.close();

            return cod;

        } catch (Exception t) {
            System.out.println(t.getMessage());
            return 0;

        }
    }

    public void filtrarLivres(String onde) {

        try {

            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT modelo,placa FROM " + onde + "");
            rs.next();
            ResultSetMetaData rsmd = rs.getMetaData();

            do {
                AlugarCarro.carros.addElement(proximaLinha(rs, rsmd));
            } while (rs.next());

            con.close();

        } catch (Exception t) {
            System.out.println(t.getMessage());

        }

    }

    public void filtrarReservados(String onde) {

        try {

            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT modelo,placa FROM " + onde + "");
            rs.next();
            ResultSetMetaData rsmd = rs.getMetaData();

            do {
                reservarCarro.carros.addElement(proximaLinha(rs, rsmd));
            } while (rs.next());

            con.close();

        } catch (Exception t) {
            System.out.println(t.getMessage());

        }

    }

    private Vector proximaLinha(ResultSet rs, ResultSetMetaData rsmd) throws SQLException {
        Vector LinhaAtual = new Vector();

        try {
            for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
                switch (rsmd.getColumnType(i)) {
                    case Types.VARCHAR:
                        LinhaAtual.addElement(rs.getString(i));
                        break;
                    case Types.TIMESTAMP:
                        LinhaAtual.addElement(rs.getDate(i).toLocaleString().substring(0, 10));
                        break;
                    case Types.INTEGER:
                        LinhaAtual.addElement(rs.getInt(i));
                        break;
                    case Types.NUMERIC:
                        LinhaAtual.addElement(VerificarUsuario.paraFormatoDinheiro(rs.getBigDecimal(i)));
                        break;

                }
            }
        } catch (SQLException e) {
        }
        return LinhaAtual;
    }

    public JTable procurarAlugados() {
        try {
            Vector cabecalho = new Vector();
            Vector linhas = new Vector();
            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT cod_aluguel,placa,modelo,valor,nome,data_peg,hora,data_ent,Status  FROM Alugados ORDER BY data_pag,nome");
            rs.next();
            ResultSetMetaData rsmd = rs.getMetaData();
            cabecalho.addElement("Código");
            cabecalho.addElement("Placa");
            cabecalho.addElement("Modelo");
            cabecalho.addElement("Valor");
            cabecalho.addElement("Nome");
            cabecalho.addElement("Pegou em");
            cabecalho.addElement("Hora");
            cabecalho.addElement("Entrega P/");
            cabecalho.addElement("Situação");

            do {
                linhas.addElement(proximaLinha(rs, rsmd));
            } while (rs.next());
            JTable tabela = new JTable(linhas, cabecalho);
            con.close();
            tabela.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabela.getColumnModel().getColumn(1).setPreferredWidth(70);
            tabela.getColumnModel().getColumn(2).setPreferredWidth(150);
            tabela.getColumnModel().getColumn(3).setPreferredWidth(70);
            tabela.getColumnModel().getColumn(4).setPreferredWidth(200);
            tabela.getColumnModel().getColumn(5).setPreferredWidth(70);
            tabela.getColumnModel().getColumn(6).setPreferredWidth(70);
            tabela.getColumnModel().getColumn(7).setPreferredWidth(70);
            tabela.getColumnModel().getColumn(8).setPreferredWidth(400);

            return tabela;

        } catch (Exception t) {
            System.out.println(t.getMessage());
            return null;

        }
    }

    public Aluguel procurar(String cod) {
        try {
            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Alugados WHERE (cod_aluguel) =(" + cod + ")");
            rs.next();

            Aluguel alu = new Aluguel();
            alu.setCod_aluguel(rs.getString("cod_aluguel"));
            alu.setPlaca(rs.getString("placa"));
            alu.setModelo(rs.getString("modelo"));
            alu.setNome(rs.getString("nome"));
            alu.setValor(rs.getString("valor"));

            String datapegResult = rs.getString("data_peg");
            String diae = datapegResult.substring(8, 10);
            String mese = datapegResult.substring(5, 7);
            String anoe = datapegResult.substring(0, 4);
            String datapeg = diae + mese + anoe;
            alu.setData_peg(datapeg);

            String dataentResult = rs.getString("data_ent");
            String diae1 = dataentResult.substring(8, 10);
            String mese1 = dataentResult.substring(5, 7);
            String anoe1 = dataentResult.substring(0, 4);
            String dataent = diae1 + mese1 + anoe1;
            alu.setData_ent(dataent);

            String datapagResult = rs.getString("data_pag");
            String diae2 = datapagResult.substring(8, 10);
            String mese2 = datapagResult.substring(5, 7);
            String anoe2 = datapagResult.substring(0, 4);
            String datapag = diae2 + mese2 + anoe2;
            alu.setData_pag(datapag);

            alu.setHora(rs.getString("hora"));
            con.close();

            return alu;

        } catch (Exception t) {
            System.out.println(t.getMessage());
            return null;

        }
    }

    public String pegarSaldo(String cod) {

        try {

            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT (valor) FROM Alugados WHERE (cod_aluguel)= (" + cod + ")");
            rs.next();
            String saldo = rs.getString("valor");
            con.close();
            return saldo;

        } catch (Exception t) {
            System.out.println(t.getMessage());

        }
        return null;

    }

    public void pagar(Aluguel alu, String cod, String valor, String data, String valor_pago, String onde, String valorTexto) {
        try {

            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            st.execute("INSERT INTO Aluguel (cod_aluguel,placa,modelo,valor,valor_pago,pagou,nome, hora, data, data_ent, data_peg,data_pag,Status) VALUES(" + alu.getCod_aluguel() + ",'" + alu.getPlaca() + "','" + alu.getModelo() + "'," + valor + "," + valor_pago + ",'" + data + "','" + alu.getNome() + "','" + alu.getHora() + "','" + alu.getData() + "', '" + alu.getData_ent() + "','" + alu.getData_peg() + "','" + alu.getData_pag() + "', 'Alugado e Quitado - Pagou R$ " + valorTexto + " em " + data + " no Banco " + onde + "')");
            st.executeUpdate("UPDATE Alugados SET valor = " + valor + ",valor_pago= " + valor_pago + ",pagou = '" + data + "',Status = 'Alugado e Quitado - Pagou R$ " + valorTexto + " em " + data + "'  WHERE cod_aluguel=(" + cod + ")");

            con.close();

        } catch (Exception t) {
            System.out.println(t.getMessage());

        }
    }

    public void abater(Aluguel alu, String cod, String valor, String data, String valor_pago, String onde, String valorTexto) {
        try {

            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            st.execute("INSERT INTO Aluguel (cod_aluguel,placa,modelo,valor,valor_pago,pagou,nome, hora, data, data_ent, data_peg,data_pag,Status) VALUES(" + alu.getCod_aluguel() + ",'" + alu.getPlaca() + "','" + alu.getModelo() + "'," + valor + "," + valor_pago + ",'" + data + "','" + alu.getNome() + "','" + alu.getHora() + "','" + alu.getData() + "', '" + alu.getData_ent() + "','" + alu.getData_peg() + "','" + alu.getData_pag() + "', 'Alugado e não Quitado - Pagou R$ " + valorTexto + " em " + data + " no Banco " + onde + "')");
            st.executeUpdate("UPDATE Alugados SET valor = " + valor + ",valor_pago= " + valor_pago + ",pagou = '" + data + "',Status = 'Alugado e não Quitado - Pagou R$ " + valorTexto + " em " + data + "'  WHERE cod_aluguel=(" + cod + ")");

            con.close();

        } catch (Exception t) {
            System.out.println(t.getMessage());

        }
    }

    public JTable filtroProcurar(String cod, String onde) {
        try {
            Vector cabecalho = new Vector();
            Vector linhas = new Vector();
            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT cod_aluguel,placa,modelo,valor,nome,data_peg,hora,data_ent,Status  FROM " + onde + " WHERE cod_aluguel =" + cod + " ORDER BY op desc");
            rs.next();
            ResultSetMetaData rsmd = rs.getMetaData();
            cabecalho.addElement("Código");
            cabecalho.addElement("Placa");
            cabecalho.addElement("Modelo");
            cabecalho.addElement("Valor");
            cabecalho.addElement("Nome");
            cabecalho.addElement("Pegou em");
            cabecalho.addElement("Hora");
            cabecalho.addElement("Entrega P/");
            cabecalho.addElement("Situação");

            do {
                linhas.addElement(proximaLinha(rs, rsmd));
            } while (rs.next());
            JTable tabela = new JTable(linhas, cabecalho);
            con.close();
            tabela.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabela.getColumnModel().getColumn(1).setPreferredWidth(70);
            tabela.getColumnModel().getColumn(2).setPreferredWidth(150);
            tabela.getColumnModel().getColumn(3).setPreferredWidth(70);
            tabela.getColumnModel().getColumn(4).setPreferredWidth(200);
            tabela.getColumnModel().getColumn(5).setPreferredWidth(70);
            tabela.getColumnModel().getColumn(6).setPreferredWidth(70);
            tabela.getColumnModel().getColumn(7).setPreferredWidth(70);
            tabela.getColumnModel().getColumn(8).setPreferredWidth(400);

            return tabela;

        } catch (Exception t) {
            System.out.println(t.getMessage());
            return null;

        }
    }
}
