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
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;



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
        JMenuBar menuTopo;
        JMenu cadastro,estoque,relatorios;
        JMenuItem cad_carro, cad_apt, cad_produto;
        private javax.swing.Timer timer;  
        
        int qtdDia ;
        Calendar data;
        int dia, dia_semana, mes, ano;
        public static String data_hoje; 
        
    
    
        //Botão Aluguel Carro
        JButton aluguelCarro;
        ImageIcon imageAlugCarro = new ImageIcon("Icones\\carro.png");
        
        //Botão Aluguel apartamento
        JButton aluguelApt;
        ImageIcon imageAlugApt = new ImageIcon("Icones\\apt.png");
             
        //Botão Movimentação diária
        JButton movimentacaoDiaria;
        ImageIcon imageFuncionario = new ImageIcon("Icones\\movimentacao.png");
        
        
        //Botão Sair  
        JButton  sair;
        ImageIcon imageSair = new ImageIcon("Icones\\botao_sair.png"); 

  
       

       public Principal() throws EmailException, UnknownHostException {

            super("..:: EngeCom - Vs. 1.0 ::..");
            final Container tela = getContentPane();
            setLayout(null);
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            setSize(1280,720);
            setLocationRelativeTo(null);
            setVisible(true);
            revalidate();
            repaint();
            
                    data = Calendar.getInstance();
                    dia = data.get(Calendar.DAY_OF_MONTH);
                    dia_semana = data.get(Calendar.DAY_OF_WEEK);
                    mes = data.get(Calendar.MONTH);
                    ano = data.get(Calendar.YEAR);
                    data_hoje = +dia+"/"+(mes+1)+"/"+ano;
                    if(dia<10 && mes<10){
                      data_hoje = "0"+dia+"/0"+(mes+1)+"/"+ano;
                  }else
                      if(dia<10 && mes >=10 ){
                          data_hoje = "0"+dia+"/"+(mes+1)+"/"+ano;
                      }else
                          if(dia>=10 && mes <10){
                              data_hoje = dia+"/0"+(mes+1)+"/"+ano;
                          }else{
                              data_hoje = dia+"/"+(mes+1)+"/"+ano;
                          }
            
            criaMenu();
            
            
            menuTopo = new JMenuBar();
            cadastro = new JMenu("Cadastro");
            
            cad_carro = new JMenuItem("Carro");
            cad_apt = new JMenuItem("Apartamento");
            cad_produto = new JMenuItem("Produto");
            cadastro.add(cad_carro);
            cadastro.add(cad_apt);
            cadastro.add(cad_produto);
            
            estoque = new JMenu("Estoque");
            relatorios = new JMenu("Relatórios");
            menuTopo.add(cadastro);
            menuTopo.add(estoque);
            menuTopo.add(relatorios);
            setJMenuBar(menuTopo);
            
            
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
            
           
            /* movimentacaoDiaria.addActionListener(new ActionListener(){
                
            	public void actionPerformed(ActionEvent e){
                     
                    try{  
                      
                    tela.remove(mov);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(alugCar);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(alugApt);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(cadApt);
                    }catch(NullPointerException npe){};
                                    
                    try{  
                      
                    tela.remove(cadCarro);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(cadProduto);
                    }catch(NullPointerException npe){};
                    
                    mov =  new Movimento();
                    JToolBar ferramentas = new JToolBar("Ferramentas");
                    ferramentas.setBounds(2, 584, 1095, 64);
                    mov.setBounds(50, 100, 1100, 500);
                    mov.add(ferramentas);
                   
                    aluguelCarro.setEnabled(true);
                    aluguelApt.setEnabled(true);
                    movimentacaoDiaria.setEnabled(false);
                  
                    
                    tela.add(mov);
                    tela.revalidate();
                    tela.repaint();
          
                 }
             });
             
             aluguelCarro.addActionListener(new ActionListener(){
                
            	public void actionPerformed(ActionEvent e){
                     
                    try{  
                      
                    tela.remove(mov);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(alugCar);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(alugApt);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(cadApt);
                    }catch(NullPointerException npe){};
                                    
                    try{  
                      
                    tela.remove(cadCarro);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(cadProduto);
                    }catch(NullPointerException npe){};
                    
                    alugCar =  new AlugCarro();
                    JToolBar ferramentas = new JToolBar("Ferramentas");
                    ferramentas.setBounds(2, 584, 1095, 64);
                    alugCar.setBounds(50, 100, 1100, 500);
                    alugCar.add(ferramentas);
                   
                    aluguelCarro.setEnabled(false);
                    aluguelApt.setEnabled(true);
                    movimentacaoDiaria.setEnabled(true);
                  
                    
                    tela.add(alugCar);
                    tela.revalidate();
                    tela.repaint();
          
                 }
             });
             
             aluguelApt.addActionListener(new ActionListener(){
                
            	public void actionPerformed(ActionEvent e){
                     
                   try{  
                      
                    tela.remove(mov);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(alugCar);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(alugApt);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(cadApt);
                    }catch(NullPointerException npe){};
                                    
                    try{  
                      
                    tela.remove(cadCarro);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(cadProduto);
                    }catch(NullPointerException npe){};
                                        
                    alugApt =  new AlugApt();
                    JToolBar ferramentas = new JToolBar("Ferramentas");
                    ferramentas.setBounds(2, 584, 1095, 64);
                    alugApt.setBounds(50, 100, 1100, 500);
                    alugApt.add(ferramentas);
                   
                    aluguelCarro.setEnabled(true);
                    aluguelApt.setEnabled(false);
                    movimentacaoDiaria.setEnabled(true);
                  
                    
                    tela.add(alugApt);
                    tela.revalidate();
                    tela.repaint();
          
                 }
             });
             
             cad_carro.addActionListener(new ActionListener(){
                
            	public void actionPerformed(ActionEvent e){
                     
                    try{  
                      
                    tela.remove(mov);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(alugCar);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(alugApt);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(cadApt);
                    }catch(NullPointerException npe){};
                                    
                    try{  
                      
                    tela.remove(cadCarro);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(cadProduto);
                    }catch(NullPointerException npe){};
                    
                    cadCarro =  new CadCarro();
                    JToolBar ferramentas = new JToolBar("Ferramentas");
                    ferramentas.setBounds(2, 584, 1095, 64);
                    cadCarro.setBounds(50, 100, 1100, 500);
                    cadCarro.add(ferramentas);
                   
                    aluguelCarro.setEnabled(true);
                    aluguelApt.setEnabled(true);
                    movimentacaoDiaria.setEnabled(true);
                  
                    
                    tela.add(cadCarro);
                    tela.revalidate();
                    tela.repaint();
          
                 }
             });
             
             cad_apt.addActionListener(new ActionListener(){
                
            	public void actionPerformed(ActionEvent e){
                     
                    try{  
                      
                    tela.remove(mov);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(alugCar);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(alugApt);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(cadApt);
                    }catch(NullPointerException npe){};
                                    
                    try{  
                      
                    tela.remove(cadCarro);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(cadProduto);
                    }catch(NullPointerException npe){};
                    
                    cadApt =  new CadApt();
                    JToolBar ferramentas = new JToolBar("Ferramentas");
                    ferramentas.setBounds(2, 584, 1095, 64);
                    cadApt.setBounds(50, 100, 1100, 500);
                    cadApt.add(ferramentas);
                   
                    aluguelCarro.setEnabled(true);
                    aluguelApt.setEnabled(true);
                    movimentacaoDiaria.setEnabled(true);
                  
                    
                    tela.add(cadApt);
                    tela.revalidate();
                    tela.repaint();
          
                 }
             });
             
             cad_produto.addActionListener(new ActionListener(){
                
            	public void actionPerformed(ActionEvent e){
                     
                    try{  
                      
                    tela.remove(mov);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(alugCar);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(alugApt);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(cadApt);
                    }catch(NullPointerException npe){};
                                    
                    try{  
                      
                    tela.remove(cadCarro);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(cadProduto);
                    }catch(NullPointerException npe){};
                    
                    cadProduto =  new CadProduto();
                    JToolBar ferramentas = new JToolBar("Ferramentas");
                    ferramentas.setBounds(2, 584, 1095, 64);
                    cadProduto.setBounds(50, 100, 1100, 500);
                    cadProduto.add(ferramentas);
                   
                    aluguelCarro.setEnabled(true);
                    aluguelApt.setEnabled(true);
                    movimentacaoDiaria.setEnabled(true);
                  
                    
                    tela.add(cadProduto);
                    tela.revalidate();
                    tela.repaint();
          
                 }
             });*/
            
             
             sair.addActionListener(new ActionListener(){
                   @Override
            	public void actionPerformed(ActionEvent e){

                    int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?");
                    if(resposta==0){
                     
                        System.exit(0);   
                    }                    
            	}
            });
               
            
            revalidate();
            repaint();
            //sendEmail();
            
        }
       
    
                public static void main(String args[]) throws EmailException, UnknownHostException{

                        Principal pri = new Principal();
                        pri.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    }

       private void criaMenu(){
           
            menu = new JToolBar("Barra de Ferramentas");
            menu.setBackground(Color.white);
            
            aluguelCarro= new JButton();
            aluguelCarro.setIcon(imageAlugCarro);
            aluguelCarro.setToolTipText("Aluguel de Carros"); 
            aluguelCarro.setBounds(10, 10, 100, 100);
            menu.add(aluguelCarro);
            
            aluguelApt = new JButton();
            aluguelApt.setIcon(imageAlugApt);
            aluguelApt.setToolTipText("Aluguel de Apartamentos"); 
            aluguelApt.setBounds(10, 10, 100, 100);
            menu.add(aluguelApt);
            
            movimentacaoDiaria = new JButton();
            movimentacaoDiaria.setIcon(imageFuncionario);
            movimentacaoDiaria.setToolTipText("Movimentação"); 
            movimentacaoDiaria.setBounds(10, 10, 100, 100);
            menu.add(movimentacaoDiaria);
                      
          
            
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
           public static void sendEmail() throws EmailException, UnknownHostException {
    
                String nome =InetAddress.getLocalHost().getHostName();
                SimpleEmail email = new SimpleEmail();
                //Utilize o hostname do seu provedor de email
                //System.out.println("alterando hostname...");
                email.setHostName("smtp.gmail.com");
                //Quando a porta utilizada não é a padrão (gmail = 465)
                email.setSmtpPort(465);
                //Adicione os destinatários
                email.addTo("celiobj@gmail.com", "Célio");
                //Configure o seu email do qual enviará
                email.setFrom("cbjsolutions@gmail.com", "CBJ Solutions");
                //Adicione um assunto
                email.setSubject("Acesso ao Sistema pela máquina "+nome+".");
                //Adicione a mensagem do email
                email.setMsg("A máquina "+nome+" acessou o sistema 'Controle Fácil' licenciado para LOCASUL LOCADORA em "+ data_hoje+".");
                //Para autenticar no servidor é necessário chamar os dois métodos abaixo
                //System.out.println("autenticando...");
                email.setSSL(true);
                email.setAuthentication("cbjsolutions", "slipclown");
                //System.out.println("enviando...");
                email.send();
                //System.out.println("Email enviado!");
}

       

       }
