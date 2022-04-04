/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

/**
 *
 * @author celio
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.*;
import javax.swing.text.MaskFormatter;



/**
 *
 * @author celio
 */
public class Principal extends JFrame {


        JToolBar menu;
        JScrollPane scroller;
        JTable tabela;
        Vector<Vector> preencher;
        MaskFormatter mascaraHora;
        MaskFormatter mascaraDia;
        MaskFormatter mascaraCpf;
        Movimento mov;
        Relatorio rel;
 
        
        int qtdDia ;
        Calendar data;
        
    
    
        
             
        //Botão Movimentação diária
        JButton movimentacaoDiaria;
        ImageIcon imageFuncionario = new ImageIcon("Icones\\movimentacao.png");
        
        
        
        //Botão Relatório
        JButton relatorio;
        ImageIcon imageRelatorio = new ImageIcon("Icones\\relatorio.png");

        
        //Botão Sair  
        JButton  sair;
        ImageIcon imageSair = new ImageIcon("Icones\\botao_sair.png"); 

  
       

       public Principal() {

            super("..:: Ultracaixa - Vs. 1.0 ::..");
            final Container tela = getContentPane();
            tela.setLayout(null);
            setResizable(false);
            setSize(800,600);
            setLocationRelativeTo(null);
            setVisible(true);
            criaMenu();
            
            
             try{
        	 mascaraHora = new MaskFormatter("##:##:##");
             }catch (Exception exp){};
             
              try{
        	 mascaraCpf = new MaskFormatter("###.###.###-##");
             }catch (Exception exp){};
             
             try{
        	 mascaraDia = new MaskFormatter("##/##/####");
             }catch (Exception exp){};
             
                        
          
            menu.setBounds(1,1,tela.getWidth(),80); 
            tela.add(menu);
            
           
             movimentacaoDiaria.addActionListener(new ActionListener(){
                
            	public void actionPerformed(ActionEvent e){
                     
                    try{  
                      
                    tela.remove(mov);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(rel);
                    }catch(NullPointerException npe){};
                    
                    mov =  new Movimento();
                    JToolBar ferramentas = new JToolBar("Ferramentas");
                    ferramentas.setBounds(2, 584, 1095, 64);
                    mov.setBounds(50, 100, 700, 400);
                    mov.add(ferramentas);
                   
                    movimentacaoDiaria.setEnabled(false);
                    relatorio.setEnabled(true);
                    
                    tela.add(mov);
                    tela.revalidate();
                    tela.repaint();
          
                 }
             });
             
             relatorio.addActionListener(new ActionListener(){
                
            	public void actionPerformed(ActionEvent e){
                     
                    try{  
                      
                    tela.remove(mov);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(rel);
                    }catch(NullPointerException npe){};
                    
                    
                    rel =  new Relatorio();
                    JToolBar ferramentas = new JToolBar("Ferramentas");
                    ferramentas.setBounds(2, 584, 1095, 64);
                    rel.setBounds(50, 100, 700, 400);
                    rel.add(ferramentas);
                   
                    movimentacaoDiaria.setEnabled(true);
                    relatorio.setEnabled(false);
                    
                    tela.add(rel);
                    tela.revalidate();
                    tela.repaint();
          
                 }
             });
             
             
            
             
             sair.addActionListener(new ActionListener(){
                   @Override
            	public void actionPerformed(ActionEvent e){

                    int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?");
                    if(resposta==0){
                     
                        System.exit(0);   
                    }                    
            	}
            });
               
               
            
            
        }
    
                public static void main(String args[]){

                        Principal pri = new Principal();
                        pri.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    }

       private void criaMenu(){
           
            menu = new JToolBar("Barra de Ferramentas");
            menu.setBackground(Color.white);
            
            movimentacaoDiaria = new JButton();
            movimentacaoDiaria.setIcon(imageFuncionario);
            movimentacaoDiaria.setToolTipText("Movimentação"); 
            movimentacaoDiaria.setBounds(10, 10, 100, 100);
            menu.add(movimentacaoDiaria);
                      
            relatorio = new JButton();
            relatorio.setIcon(imageRelatorio);
            relatorio.setToolTipText("Relatórios"); 
            relatorio.setBounds(10, 10, 100, 100);
            menu.add(relatorio);
            
            sair = new JButton();
            sair.setIcon(imageSair);
            sair.setToolTipText("Sair"); 
            sair.setBounds(10, 10, 100, 100);
            menu.add(sair);
       }
        public static String paraFormatoDinheiro(Double valor){

           NumberFormat formato2 = NumberFormat.getInstance();
           return formato2.format(valor);
           
        }
 
        public static String formatoParaInserir(String valor) throws ParseException{
            
         NumberFormat formato2 = NumberFormat.getInstance();
         return formato2.parse(valor).toString();
            
        }
 
        public static String paraInserirData(String data){
            
            String retorno,dia,mes,ano;
            dia = data.substring(0,2);
            mes = data.substring(3,5);
            ano = data.substring(6,10);
            retorno = ano+mes+dia;
            return retorno;
            
        }
        public static String paraRecuperarData(String data){
            
            String retorno,dia,mes,ano;
            dia = data.substring(8,10);
            mes = data.substring(5,7);
            ano = data.substring(0,4);
            retorno = dia+"/"+mes+"/"+ano;
            return retorno;
            
        }
        
        public String dataInicioMes(String mes)    {  
    
         
            
            String dataInicioMes;  
            dataInicioMes = null;
  
            switch (mes)  
            {  

            case "Janeiro":  
            {  
              dataInicioMes = "01/01";  
              break;  
            }  
            case "Fevereiro":  
            {  
              dataInicioMes = "01/02";  
              break;  
            }  
            case "Março":  
            {  
              dataInicioMes = "01/03";  
              break;  
            }  
            case "Abril":  
            {  
              dataInicioMes = "01/04";  
              break;  
            } 
            case "Maio":  
            {  
              dataInicioMes = "01/05";  
              break;  
            } 
            case "Junho":  
            {  
              dataInicioMes = "01/06";  
              break;  
            }
            case "Julho":  
            {  
              dataInicioMes = "01/07";  
              break;  
            }
            case "Agosto":  
            {  
              dataInicioMes = "01/08";  
              break;  
            }
            case "Setembro":  
            {  
              dataInicioMes = "01/09";  
              break;  
            }
            case "Outubro":  
            {  
              dataInicioMes = "01/10";  
              break;  
            }    
            case "Novembro":  
            {  
              dataInicioMes = "01/11";  
              break;  
            }
            case "Dezembro":  
            {  
              dataInicioMes = "01/12";  
              break;  
            } 
            } 
            
            return dataInicioMes;

  } public String dataFimMes(String mes)    {  
    
         
            
            String dataFimMes;  
            dataFimMes = null;
  
            switch (mes)  
            {  

            case "Janeiro":  
            {  
              dataFimMes = "31/01";  
              break;  
            }  
            case "Fevereiro":  
            {  
              dataFimMes = "28/02";  
              break;  
            }  
            case "Março":  
            {  
              dataFimMes = "31/03";  
              break;  
            }  
            case "Abril":  
            {  
              dataFimMes = "30/04";  
              break;  
            } 
            case "Maio":  
            {  
              dataFimMes = "31/05";  
              break;  
            } 
            case "Junho":  
            {  
              dataFimMes = "30/06";  
              break;  
            }
            case "Julho":  
            {  
              dataFimMes = "31/07";  
              break;  
            }
            case "Agosto":  
            {  
              dataFimMes = "31/08";  
              break;  
            }
            case "Setembro":  
            {  
              dataFimMes = "30/09";  
              break;  
            }
            case "Outubro":  
            {  
              dataFimMes = "31/10";  
              break;  
            }    
            case "Novembro":  
            {  
              dataFimMes = "30/11";  
              break;  
            }
            case "Dezembro":  
            {  
              dataFimMes = "31/12";  
              break;  
            } 
            } 
            
            return dataFimMes;  

  } 
         
  

           public String pesquisarDiaSemana(int _diaSemana)    {  
    
         
            
            String diaSemana = null;  
  
            switch (_diaSemana)  
            {  

            case 1:  
            {  
              diaSemana = "Domingo";  
              break;  
            }  
            case 2:  
            {  
              diaSemana = "Segunda";  
              break;  
            }  
            case 3:  
            {  
              diaSemana = "Terça";  
              break;  
            }  
            case 4:  
            {  
              diaSemana = "Quarta";  
              break;  
            }  
            case 5:  
            {  
              diaSemana = "Quinta";  
              break;  
            }  
            case 6:  
            {  
              diaSemana = "Sexta";  
              break;  
            }  
            case 7:  
            {  
              diaSemana = "Sábado";  
              break;  
            }  

            }  
            return diaSemana;  

  }  

       

       }
