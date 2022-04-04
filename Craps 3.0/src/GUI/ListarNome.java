package GUI;

import Persistencia.RepositorioCliente;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class ListarNome  extends JFrame{
	
		JButton listar, limpar, sair, resgatar;
		JTextField tNome, tValor,tGarantia, tCod ;
		JFormattedTextField tData_pag;
		MaskFormatter mascaraData_pag;
	    JLabel nome, data_pag, valor, garantia, cod;
	    JTable tabela;
	    JScrollPane scroller;
	    String  data_res;
	    Calendar data;
	    int dia, mes, ano;
        RepositorioCliente rc;
	    
	    	
	    	public ListarNome(){
	    		
	    		 super("..:: |Listar por Nome|Controle Financeiro - CRAPS Vs. 3.0 ::..");
	             final Container tela = getContentPane();
	             tela.setLayout(null);
	             
	             listar = new JButton("Listar");
	             limpar = new JButton("Limpar");
	             resgatar = new JButton("Resgatar");
	             sair = new JButton("Sair");
	             tNome = new JTextField(40);
	             nome = new JLabel("Nome: ");
	             cod = new JLabel("Cod: ");
	             valor = new JLabel("Valor: ");
	             data_pag = new JLabel("Bom /P: ");
	             garantia = new JLabel("Garantia: ");
	             tGarantia = new JTextField(30);
	             tValor = new JTextField(5);
	             tCod = new JTextField(3);
	            
	             
	                         
	             try{
	            	 
	         	   	mascaraData_pag = new MaskFormatter("##/##/####");
	                	                 
	            }catch (Exception exp){};
	            tData_pag = new JFormattedTextField(mascaraData_pag);
	            
	           
	             
	            
	            	   tValor.setFont(new Font("Times New Roman", Font.BOLD, 14)); 
	            	   tGarantia.setFont(new Font("Times New Roman", Font.BOLD, 14)); 
	            	   tData_pag.setFont(new Font("Times New Roman", Font.BOLD, 14)); 
	            	   tNome.setFont(new Font("Times New Roman", Font.BOLD, 14));
	            	   tCod.setFont(new Font("Times New Roman", Font.BOLD, 14)); 
	            	   
	            	   data = Calendar.getInstance();
	                   dia = data.get(Calendar.DAY_OF_MONTH);
	                   mes = data.get(Calendar.MONTH);
	                   ano = data.get(Calendar.YEAR);
	                   data_res = +dia+"/"+(mes+1)+"/"+ano;
	            	   
	            nome.setBounds(40,80,100,20);
	            cod.setBounds(40,120,50,20);
	            tCod.setBounds(85,120,50,20);
	            data_pag.setBounds(40,150,100,20);
	            tData_pag.setBounds(85,150,100,20);
	            valor.setBounds(200,150,80,20);
	            tValor.setBounds(235,150,80,20);
	            garantia.setBounds(320,150,80,20);
	            tGarantia.setBounds(375,150,200,20);
	            tNome.setBounds(80,80,340,20);
	            listar.setBounds(500,80,100,20);
	            limpar.setBounds(600,80,100,20);
	            resgatar.setBounds(700,150,100,20);
	            sair.setBounds(700,80,100,20);
	            
	            tela.add(nome);
	            tela.add(tNome);
	            tela.add(cod);
	            tela.add(tCod);
	            tela.add(valor);
	            tela.add(tValor);
	            tela.add(garantia);
	            tela.add(tGarantia);
	            tela.add(data_pag);
	            tela.add(tData_pag);
	            tela.add(listar);
	            tela.add(limpar);
	            tela.add(resgatar);
	            tela.add(sair);
	            
	            cod.setVisible(false);
	            tCod.setVisible(false);
	            valor.setVisible(false);
	            tValor.setVisible(false);
	            data_pag.setVisible(false);
	            tData_pag.setVisible(false);
	            garantia.setVisible(false);
	            tGarantia.setVisible(false);
	            resgatar.setVisible(false);
	            
	            tCod.setEditable(false);
	            
	            listar.addActionListener(new ActionListener(){

	            	public void actionPerformed(ActionEvent e){

                        try{
                        
                        scroller.setVisible(false);
                        tela.remove(scroller);
                        }catch(Exception ex){

                            
                        }

                        if(tNome.getText().equals("")){
                            JOptionPane.showMessageDialog(null,"Preencha o campo |NOME|");
                        }else{
                        rc = new RepositorioCliente();
                        tabela = rc.listarClientes(tNome.getText());
                        if(tabela.getValueAt(0,0)==null){
                            JOptionPane.showMessageDialog(null,"Registro não Encontrado");
                        }else{
                        scroller = new JScrollPane(tabela, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	                    tela.add(scroller);
	                    scroller.setBounds(20, 200,1000, 400);
                            }
                        }
	            	}
	            });
	            
	            limpar.addActionListener(new ActionListener(){
	            	public void actionPerformed(ActionEvent e){
	            		
	            		/*ListarNome ln = new ListarNome();
	            		ln.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	            		setVisible(false);*/
                        try{
                        tNome.setText("");
                        scroller.setVisible(false);
                        tela.remove(scroller);
                        }catch(Exception ex){

                            tNome.setText("");
                        }
	            	}
	            });
	            
	            resgatar.addActionListener(new ActionListener(){
	            	public void actionPerformed(ActionEvent e){
	            		
	            		 	
	            		
	            		}
	            });
	            
	            sair.addActionListener(new ActionListener() {

	                public void actionPerformed(ActionEvent e) {

                        try{
                        tNome.setText("");
                        scroller.setVisible(false);
                        tela.remove(scroller);
                        }catch(Exception ex){

                            tNome.setText("");
                        }

	                    try{
                              VerificarUsuario.pri.setVisible(true);
                              setVisible(false);
                         }catch(Exception ex){
                               VerificarUsuario.pri = new Principal();
                               VerificarUsuario.pri.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                               setVisible(false);
                              
               }
               }
	            });
	            
	            setExtendedState(MAXIMIZED_BOTH);
	            setSize(800, 600);
	            setVisible(true);
	            setLocationRelativeTo(null);
	    	}
	            
	           
	        };