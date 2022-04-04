package GUI;

import Persistencia.RepositorioEmprestimo;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class ListarTodos  extends JFrame{
	
		JButton listar, limpar,imprimir, sair;
		JTextField tNome;
        JLabel nome;
        JTable tabela;
        JScrollPane scroller;
        RepositorioEmprestimo re;

	    	
	    	public ListarTodos(){
	    		
	    		 super("..:: |Listar Todos|Controle Financeiro - CRAPS Vs. 3.0 ::..");
	             final Container tela = getContentPane();
	             tela.setLayout(null);
	             
	             listar = new JButton("Listar");
                 imprimir = new JButton("Imprimir");
	             limpar = new JButton("Limpar");
	             sair = new JButton("Sair");
	          
                imprimir.setBounds(500,120,100,20); 
	            listar.setBounds(500,80,100,20);
	            limpar.setBounds(600,80,100,20);
	            sair.setBounds(700,80,100,20);
	            
	      
                tela.add(imprimir);
                tela.add(listar);
	            tela.add(limpar);
	            tela.add(sair);
	            
	            listar.addActionListener(new ActionListener(){
	            	public void actionPerformed(ActionEvent e){

                        try{
                       scroller.setVisible(false);
	                   tela.remove(scroller);
                      }catch(Exception ex){}
                      

                        re = new RepositorioEmprestimo();
                        tabela = re.listarTodos();
                        if(tabela.getValueAt(0,0)== null){
                            JOptionPane.showMessageDialog(null, "Registros não Encontrados");
                        }else{
	            		scroller = new JScrollPane(tabela, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	                    tela.add(scroller);
	                    scroller.setBounds(20, 200,1000, 400);
                        }
                        }
	            });
                    
                    imprimir.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                        
                                               
                        }
                        
                    });
	            
	            limpar.addActionListener(new ActionListener(){
	            	public void actionPerformed(ActionEvent e){

                      try{
                       scroller.setVisible(false);
	                   tela.remove(scroller);
                      }catch(Exception ex){}
                      }
	            });
	            
	            sair.addActionListener(new ActionListener() {

	                public void actionPerformed(ActionEvent e) {

                        try{
                          scroller.setVisible(false);
                          tela.remove(scroller);
                            }catch(Exception ex){}


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