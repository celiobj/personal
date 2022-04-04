package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;



public class AccessDatabase  implements IDatabase{
	
	
	
	@Override
	public Connection conectar(){
		

        try{
            String url = "jdbc:odbc:Craps";
            String usuario = "";
            String senha = "";
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            return DriverManager.getConnection(url,usuario,senha);
            }
        catch ( Exception e){
			 JOptionPane.showMessageDialog(null,"Conexão não estabelecida: "+e.getMessage(),"Mensagem do Programa",
			 JOptionPane.ERROR_MESSAGE);
			 System.exit(0);

		}
		return null;
    }

		/*try{
			Class.forName("com.hxtt.sql.access.AccessDriver");
			String url = "jdbc:access:/c:/Craps/Bancos/bd_craps.mdb";
			return DriverManager.getConnection(url);
		}catch ( Exception e){
			 JOptionPane.showMessageDialog(null,"Conexão não  estabelecida: "+e.getMessage(),"Mensagem do Programa",
			 JOptionPane.ERROR_MESSAGE);
			 System.exit(0);
			 //System.out.println(e.getMessage());
		}
		return null;*/
	}
	/**
	 * Para teste
	 * @param args
	 */