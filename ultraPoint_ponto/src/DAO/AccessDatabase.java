package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;



public class AccessDatabase  implements IDatabase{
	
	
	
	@Override
	public Connection conectar(){
		

        try{
            String driverName = "com.mysql.jdbc.Driver";                        
            Class.forName(driverName);
            String serverName = "localhost";    //caminho do servidor do BD
            String mydatabase ="bd_ultrapoint";        //nome do seu banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "root";        //nome de um usuário de seu BD      
            String password = "";      //sua senha de acesso
            return DriverManager.getConnection(url, username, password);
 
//            String url = "jdbc:odbc:bd_ultrapoint";
//            String usuario = "";
//            String senha = "";
//            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//             return DriverManager.getConnection(url,usuario,senha);
            }
        catch ( Exception e){
			 JOptionPane.showMessageDialog(null,"Conexão não  estabelecida: "+e.getMessage(),"Mensagem do Programa",
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