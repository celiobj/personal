/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Persistencia.RepositorioUsuario;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author celio
 */
public class VerificarUsuario extends JFrame{

    JButton ok,cancelar;
    JLabel usuario,senha;
    JTextField tUsuario;
    JPasswordField tSenha;
    RepositorioUsuario ru;
    static Principal pri;
    static RealizarEmprestimo re;
    static Controle co;
    static ResgatarEmprestimo rse;
    static ListarNome ln;
    static ListarTodos lt;
    static ControlaBcoBrasil cbb;
    static ControlaBcoReal cbr;
    static ControlaDinheiro cd;
    static ControlaBcoBrad cbra;
    static ControlaLocSul cls;
    static ControlaPris cp;
    static CadastroCliente cc;
    static ConsultarLucro cl;
    static AlterarEmprestimo ae;
    static CadastroCarro ca;
    static AlugarCarro ac;
    static RenovarAluguel ra;
    static Controle_carros cca;
    static RelatorioCarro relc;
    static String valor_recebido, valor_saida;
    static reservarCarro rc;

        public VerificarUsuario(){
            super("Verificar Usuário");
            Container tela =  getContentPane();
            tela.setLayout(null);

            ok = new JButton("Ok");
            cancelar = new JButton("Cancelar");
            usuario = new JLabel("Usuario: ");
            senha = new JLabel("Senha: ");
            tUsuario = new JTextField(10);
            tSenha =  new JPasswordField(10);

            usuario.setBounds(20,20,50,20);
            tUsuario.setBounds(100,20,100,20);
            senha.setBounds(20,50,50,20);
            tSenha.setBounds(100,50,100,20);
            ok.setBounds(40,80,50,30);
            cancelar.setBounds(100,80,100,30);

            tela.add(ok);
            tela.add(cancelar);
            tela.add(usuario);
            tela.add(senha);
            tela.add(tUsuario);
            tela.add(tSenha);

            tUsuario.setFont(new Font("Times New Roman", Font.BOLD, 14));

            ok.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                   // pri = new Principal();
         
                 //  if(tUsuario.getText().equals("")||tSenha.getText().equals("")){
                 //      JOptionPane.showMessageDialog(null,"Preencha Usuário e Senha!!!");
                 //  }else{
                    ru = new RepositorioUsuario();
                   // if(ru.procurar(tUsuario.getText(), tSenha.getText()).equals("aceito")){
                    pri = new Principal();
                    pri.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    re = new RealizarEmprestimo();
                    re.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    re.setVisible(false);
                    co = new Controle();
                    co.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    co.setVisible(false);
                    rse = new ResgatarEmprestimo();
                    rse.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    rse.setVisible(false);
                    ln = new ListarNome();
                    ln.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    ln.setVisible(false);
                    lt = new ListarTodos();
                    lt.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    lt.setVisible(false);
                    cbb = new ControlaBcoBrasil();
                    cbb.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    cbb.setVisible(false);
                    cbr = new ControlaBcoReal();
                    cbr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    cbr.setVisible(false);
                    cd = new ControlaDinheiro();
                    cd.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    cd.setVisible(false);
                    cbra = new ControlaBcoBrad();
                    cbra.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    cbra.setVisible(false);
                    cls = new ControlaLocSul();
                    cls.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    cls.setVisible(false);
                    cp = new ControlaPris();
                    cp.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    cp.setVisible(false);
                    cc = new CadastroCliente();
                    cc.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    cc.setVisible(false);
                    setVisible(false);
                    rc = new reservarCarro();
                    rc.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    rc.setVisible(false);
                    setVisible(false);
                    
                 //   }
                //    else{
                //        JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos");
                //    }
                //     }
                }
            });

            cancelar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                   System.exit(0);}});

            setSize(250,150);
            setLocationRelativeTo(null);
            setVisible(true);
        }

        
public static String paraFormatoDinheiro(BigDecimal valor){
            
            valor_recebido = String.valueOf(valor);
          //  JOptionPane.showMessageDialog(null, valor);
            
            int tamanho = valor_recebido.length();
              if(valor_recebido.substring(0, 1).equals("-")){
                  
                  if(valor_recebido.charAt(tamanho-2)=='.'){
                      
                         
                      if(valor_recebido.length()<=6){
                            
                                
                                for(int i=0;i<valor_recebido.length();i++){

                                              if(valor_recebido.charAt(i)=='.'){
                                                valor_saida = valor_recebido.substring(0,i)+","+valor_recebido.substring(i+1,i+2)+"0";
                                               //valor_saida = "teste";
                                            }

                                        }
                            
                                }else
                                    if(valor_recebido.length()==7){
                                       //JOptionPane.showMessageDialog(null, "Ok");
                                        for(int i=0;i<valor_recebido.length();i++){

                                              if(valor_recebido.charAt(i)=='.'){
                                                valor_saida = valor_recebido.substring(0,2)+"."+valor_recebido.substring(2,i)+","+valor_recebido.substring(i+1,i+2)+"0";
                                               //valor_saida = "teste";
                                            }

                                        }

                                    }else
                                        if(valor_recebido.length()==8){
                                        
                                             for(int i=0;i<valor_recebido.length();i++){

                                              if(valor_recebido.charAt(i)=='.'){
                                                valor_saida = valor_recebido.substring(0,3)+"."+valor_recebido.substring(2,i)+","+valor_recebido.substring(i+1,i+2)+"0";
                                               //valor_saida = "teste";
                                            }

                                        }
                                        
                                        }else
                                            if(valor_recebido.length()==9){
                                            
                                                 for(int i=0;i<valor_recebido.length();i++){

                                              if(valor_recebido.charAt(i)=='.'){
                                                valor_saida = valor_recebido.substring(0,4)+"."+valor_recebido.substring(4,i)+","+valor_recebido.substring(i+1,i+2)+"0";
                                               //valor_saida = "teste";
                                            }

                                        }
                                            
                                            }else
                                                if(valor_recebido.length()==10){
                                                    
                                                     for(int i=0;i<valor_recebido.length();i++){

                                              if(valor_recebido.charAt(i)=='.'){
                                                valor_saida = valor_recebido.substring(0,2)+"."+valor_recebido.substring(2,i-3)+"."+valor_recebido.substring(5,i)+","+valor_recebido.substring(i+1,i+2)+"0";
                                               //valor_saida = "teste";
                                            }

                                        }     
                                                }else
                                                    if(valor_recebido.length()==11){
                                                         for(int i=0;i<valor_recebido.length();i++){

                                                              if(valor_recebido.charAt(i)=='.'){
                                                                valor_saida = valor_recebido.substring(0,3)+"."+valor_recebido.substring(3,i-3)+"."+valor_recebido.substring(6,i)+","+valor_recebido.substring(i+1,i+2)+"0";
                                                               //valor_saida = "teste";
                                                            }

                                                        }
                                                                                                    
                                                    }else
                                                        if(valor_recebido.length()==12){ for(int i=0;i<valor_recebido.length();i++){

                                                                  if(valor_recebido.charAt(i)=='.'){
                                                                    valor_saida = valor_recebido.substring(0,4)+"."+valor_recebido.substring(4,i-3)+"."+valor_recebido.substring(7,i)+","+valor_recebido.substring(i+1,i+2)+"0";
                                                                   //valor_saida = "teste";
                                                                }

                                                            }
                                                        }
                      //System.out.println(valor_saida);
                      
                                
                      
                  }else
                      if(valor_recebido.charAt(tamanho-3)=='.'){
                          
                          
                          if(valor_recebido.length()<=7){
                            
                                
                                for(int i=0;i<valor_recebido.length();i++){

                                              if(valor_recebido.charAt(i)=='.'){
                                                valor_saida = valor_recebido.substring(0,i)+","+valor_recebido.substring(i+1,i+3);
                                               //valor_saida = "teste";
                                            }

                                        }
                            
                                
                            
                                }else
                                    if(valor_recebido.length()==8){
                                       //JOptionPane.showMessageDialog(null, "Ok");
                                        for(int i=0;i<valor_recebido.length();i++){

                                              if(valor_recebido.charAt(i)=='.'){
                                                valor_saida = valor_recebido.substring(0,2)+"."+valor_recebido.substring(2,i)+","+valor_recebido.substring(i+1,i+3);
                                               //valor_saida = "teste";
                                            }

                                        }

                                    }else
                                        if(valor_recebido.length()==9){
                                        
                                             for(int i=0;i<valor_recebido.length();i++){

                                              if(valor_recebido.charAt(i)=='.'){
                                                valor_saida = valor_recebido.substring(0,3)+"."+valor_recebido.substring(3,i)+","+valor_recebido.substring(i+1,i+3);
                                               //valor_saida = "teste";
                                            }

                                        }
                                        
                                        }else
                                            if(valor_recebido.length()==10){
                                            
                                                 for(int i=0;i<valor_recebido.length();i++){

                                              if(valor_recebido.charAt(i)=='.'){
                                                valor_saida = valor_recebido.substring(0,4)+"."+valor_recebido.substring(4,i)+","+valor_recebido.substring(i+1,i+3);
                                               //valor_saida = "teste";
                                            }

                                        }
                                            
                                            }else
                                                if(valor_recebido.length()==11){
                                                    
                                                     for(int i=0;i<valor_recebido.length();i++){

                                              if(valor_recebido.charAt(i)=='.'){
                                                valor_saida = valor_recebido.substring(0,2)+"."+valor_recebido.substring(2,i-3)+"."+valor_recebido.substring(5,i)+","+valor_recebido.substring(i+1,i+3);
                                               //valor_saida = "teste";
                                            }

                                        }     
                                                }else
                                                    if(valor_recebido.length()==12){
                                                         for(int i=0;i<valor_recebido.length();i++){

                                                              if(valor_recebido.charAt(i)=='.'){
                                                                valor_saida = valor_recebido.substring(0,3)+"."+valor_recebido.substring(3,i-3)+"."+valor_recebido.substring(6,i)+","+valor_recebido.substring(i+1,i+3);
                                                               //valor_saida = "teste";
                                                            }

                                                        }
                                                                                                    
                                                    }else
                                                        if(valor_recebido.length()==13){ for(int i=0;i<valor_recebido.length();i++){

                                                                  if(valor_recebido.charAt(i)=='.'){
                                                                    valor_saida = valor_recebido.substring(0,4)+"."+valor_recebido.substring(4,i-3)+"."+valor_recebido.substring(7,i)+","+valor_recebido.substring(i+1,i+3);
                                                                   //valor_saida = "teste";
                                                                }

                                                            }
                                                        }
                     // System.out.println(valor_saida);
                          
                          
                      }

                }else
                  
                  if(valor_recebido.charAt(tamanho-2)=='.'){
                      
                      if(valor_recebido.length()<=5){
                            
                                
                                for(int i=0;i<valor_recebido.length();i++){

                                              if(valor_recebido.charAt(i)=='.'){
                                                valor_saida = valor_recebido.substring(0,i)+","+valor_recebido.substring(i+1,i+2)+"0";
                                               //valor_saida = "teste";
                                            }

                                        }
                            
                                }else
                                    if(valor_recebido.length()==6){
                                       //JOptionPane.showMessageDialog(null, "Ok");
                                        for(int i=0;i<valor_recebido.length();i++){

                                              if(valor_recebido.charAt(i)=='.'){
                                                valor_saida = valor_recebido.substring(0,1)+"."+valor_recebido.substring(1,i)+","+valor_recebido.substring(i+1,i+2)+"0";
                                               //valor_saida = "teste";
                                            }

                                        }

                                    }else
                                        if(valor_recebido.length()==7){
                                        
                                             for(int i=0;i<valor_recebido.length();i++){

                                              if(valor_recebido.charAt(i)=='.'){
                                                valor_saida = valor_recebido.substring(0,2)+"."+valor_recebido.substring(2,i)+","+valor_recebido.substring(i+1,i+2)+"0";
                                               //valor_saida = "teste";
                                            }

                                        }
                                        
                                        }else
                                            if(valor_recebido.length()==8){
                                            
                                                 for(int i=0;i<valor_recebido.length();i++){

                                              if(valor_recebido.charAt(i)=='.'){
                                                valor_saida = valor_recebido.substring(0,3)+"."+valor_recebido.substring(3,i)+","+valor_recebido.substring(i+1,i+2)+"0";
                                               //valor_saida = "teste";
                                            }

                                        }
                                            
                                            }else
                                                if(valor_recebido.length()==9){
                                                    
                                                     for(int i=0;i<valor_recebido.length();i++){

                                              if(valor_recebido.charAt(i)=='.'){
                                                valor_saida = valor_recebido.substring(0,1)+"."+valor_recebido.substring(1,i-3)+"."+valor_recebido.substring(4,i)+","+valor_recebido.substring(i+1,i+2)+"0";
                                               //valor_saida = "teste";
                                            }

                                        }     
                                                }else
                                                    if(valor_recebido.length()==10){
                                                         for(int i=0;i<valor_recebido.length();i++){

                                                              if(valor_recebido.charAt(i)=='.'){
                                                                valor_saida = valor_recebido.substring(0,2)+"."+valor_recebido.substring(2,i-3)+"."+valor_recebido.substring(5,i)+","+valor_recebido.substring(i+1,i+2)+"0";
                                                               //valor_saida = "teste";
                                                            }

                                                        }
                                                                                                    
                                                    }else
                                                        if(valor_recebido.length()==11){ for(int i=0;i<valor_recebido.length();i++){

                                                                  if(valor_recebido.charAt(i)=='.'){
                                                                    valor_saida = valor_recebido.substring(0,3)+"."+valor_recebido.substring(3,i-3)+"."+valor_recebido.substring(6,i)+","+valor_recebido.substring(i+1,i+2)+"0";
                                                                   //valor_saida = "teste";
                                                                }

                                                            }
                                                        }
                     // System.out.println(valor_saida);
                      
                      
                      
                      
                  }else
                      if(valor_recebido.charAt(tamanho-3)=='.'){
                            
                            if(valor_recebido.length()<=6){
                            
                                
                                for(int i=0;i<valor_recebido.length();i++){

                                              if(valor_recebido.charAt(i)=='.'){
                                                valor_saida = valor_recebido.substring(0,i)+","+valor_recebido.substring(i+1,i+3);
                                               //valor_saida = "teste";
                                            }

                                        }
                            
                                
                            
                                }else
                                    if(valor_recebido.length()==7){
                                       //JOptionPane.showMessageDialog(null, "Ok");
                                        for(int i=0;i<valor_recebido.length();i++){

                                              if(valor_recebido.charAt(i)=='.'){
                                                valor_saida = valor_recebido.substring(0,1)+"."+valor_recebido.substring(1,i)+","+valor_recebido.substring(i+1,i+3);
                                               //valor_saida = "teste";
                                            }

                                        }

                                    }else
                                        if(valor_recebido.length()==8){
                                        
                                             for(int i=0;i<valor_recebido.length();i++){

                                              if(valor_recebido.charAt(i)=='.'){
                                                valor_saida = valor_recebido.substring(0,2)+"."+valor_recebido.substring(2,i)+","+valor_recebido.substring(i+1,i+3);
                                               //valor_saida = "teste";
                                            }

                                        }
                                        
                                        }else
                                            if(valor_recebido.length()==9){
                                            
                                                 for(int i=0;i<valor_recebido.length();i++){

                                              if(valor_recebido.charAt(i)=='.'){
                                                valor_saida = valor_recebido.substring(0,3)+"."+valor_recebido.substring(3,i)+","+valor_recebido.substring(i+1,i+3);
                                               //valor_saida = "teste";
                                            }

                                        }
                                            
                                            }else
                                                if(valor_recebido.length()==10){
                                                    
                                                     for(int i=0;i<valor_recebido.length();i++){

                                              if(valor_recebido.charAt(i)=='.'){
                                                valor_saida = valor_recebido.substring(0,1)+"."+valor_recebido.substring(1,i-3)+"."+valor_recebido.substring(4,i)+","+valor_recebido.substring(i+1,i+3);
                                               //valor_saida = "teste";
                                            }

                                        }     
                                                }else
                                                    if(valor_recebido.length()==11){
                                                         for(int i=0;i<valor_recebido.length();i++){

                                                              if(valor_recebido.charAt(i)=='.'){
                                                                valor_saida = valor_recebido.substring(0,2)+"."+valor_recebido.substring(2,i-3)+"."+valor_recebido.substring(5,i)+","+valor_recebido.substring(i+1,i+3);
                                                               //valor_saida = "teste";
                                                            }

                                                        }
                                                                                                    
                                                    }else
                                                        if(valor_recebido.length()==12){ for(int i=0;i<valor_recebido.length();i++){

                                                                  if(valor_recebido.charAt(i)=='.'){
                                                                    valor_saida = valor_recebido.substring(0,3)+"."+valor_recebido.substring(3,i-3)+"."+valor_recebido.substring(6,i)+","+valor_recebido.substring(i+1,i+3);
                                                                   //valor_saida = "teste";
                                                                }

                                                            }
                                                        }
                     // System.out.println(valor_saida);
                              }
            return valor_saida;
        }
 public static String formatoParaInserir(String valor_recebido){
           

            if(valor_recebido.substring(0, 1).equals("-")){
           
                   
        }else
             if(valor_recebido.length()==1||valor_recebido.length()==2){
                valor_saida = valor_recebido;
            }else
            
            if(valor_recebido.length()==4||valor_recebido.length()==3){
                
             
            if(valor_recebido.charAt(valor_recebido.length()-2)==',' || valor_recebido.charAt(valor_recebido.length()-3)==','){
                for(int i = 0; i < valor_recebido.length();i++){
                   
                    if(valor_recebido.charAt(i)==','){
                     
                        valor_saida = valor_recebido.substring(0,i) +"."+ valor_recebido.substring((i+1),valor_recebido.length());
                       //valor_saida = "teste"; 
                        }
                    
                    }   
                                        
             } else
            {
                valor_saida = valor_recebido;
            }
            }else
                if(valor_recebido.length()==5){
                    
                    if(valor_recebido.charAt(valor_recebido.length()-2)==',' || valor_recebido.charAt(valor_recebido.length()-3)==','){
               
                        for(int i = 0; i < valor_recebido.length();i++){
                   
                            if(valor_recebido.charAt(i)==','){
                      
                                valor_saida = valor_recebido.substring(0,i) +"."+ valor_recebido.substring((i+1),valor_recebido.length());
                       //valor_saida = "teste"; 
                        }
                    
                    }   
                                        
             }else
                        if(valor_recebido.charAt(valor_recebido.length()-4)=='.'){
               
                        for(int i = 0; i < valor_recebido.length();i++){
                   
                            if(valor_recebido.charAt(i)=='.'){
                      
                                valor_saida = valor_recebido.substring(0,i)+ valor_recebido.substring((i+1),valor_recebido.length());
                       //valor_saida = "teste"; 
                        }
                    
                    }   
                                        
             }
                }else
                    if(valor_recebido.length()==6){
                    
                        if(valor_recebido.charAt(valor_recebido.length()-2)==',' || valor_recebido.charAt(valor_recebido.length()-3)==','){
               
                        for(int i = 0; i < valor_recebido.length();i++){
                   
                            if(valor_recebido.charAt(i)==','){
                      
                                valor_saida = valor_recebido.substring(0,i) +"."+ valor_recebido.substring((i+1),valor_recebido.length());
                       //valor_saida = "teste"; 
                        }
                    
                    }   
                                        
             }else
                        if(valor_recebido.charAt(valor_recebido.length()-4)=='.'){
               
                        for(int i = 0; i < valor_recebido.length();i++){
                   
                            if(valor_recebido.charAt(i)=='.'){
                      
                                valor_saida = valor_recebido.substring(0,i)+ valor_recebido.substring((i+1),valor_recebido.length());
                       //valor_saida = "teste"; 
                        }
                    
                    }   
                                        
             }
                        
                    }else
                        if(valor_recebido.length()==7){
                        
                            
                            if(valor_recebido.charAt(valor_recebido.length()-3)==','){
               
                        for(int i = 0; i < valor_recebido.length();i++){
                   
                            if(valor_recebido.charAt(i)==','){
                      
                                valor_saida = valor_recebido.substring(0,i) +"."+ valor_recebido.substring((i+1),valor_recebido.length());
                       //valor_saida = "teste"; 
                        }
                    
                    }   
                                        
             }else
                        if(valor_recebido.charAt(valor_recebido.length()-6)=='.'){
                            
                           String valor_saidaAux = valor_recebido.substring(0,1)+valor_recebido.substring(2,7);
                                     
                                for(int i = 0; i < valor_saidaAux.length();i++){
                                                     
                               if(valor_saidaAux.charAt(i)==','){
                      
                                valor_saida = valor_saidaAux.substring(0,i) +"."+ valor_saidaAux.substring((i+1),valor_saidaAux.length());
                       //valor_saida = "teste"; 
                        }
                    
                    }   
                                        
             }
                            
                        
                        }else
                            if(valor_recebido.length()==8){
                            
                                
                                if(valor_recebido.charAt(valor_recebido.length()-2)==','){
               
                        String valor_saidaAux = valor_recebido.substring(0,2)+valor_recebido.substring(3,8);
                                    
                        for(int i = 0; i < valor_saidaAux.length();i++){
                   
                            if(valor_saidaAux.charAt(i)==','){
                      
                                valor_saida = valor_saidaAux.substring(0,i) +"."+ valor_saidaAux.substring((i+1),valor_saidaAux.length());
                       //valor_saida = "teste"; 
                        }
                    
                    }   
                                        
             }else
                        if(valor_recebido.charAt(valor_recebido.length()-7)=='.'){
                            
                           String valor_saidaAux = valor_recebido.substring(0,1)+valor_recebido.substring(2,8);
                                     
                                for(int i = 0; i < valor_saidaAux.length();i++){
                                                     
                               if(valor_saidaAux.charAt(i)==','){
                      
                                valor_saida = valor_saidaAux.substring(0,i) +"."+ valor_saidaAux.substring((i+1),valor_saidaAux.length());
                       //valor_saida = "teste"; 
                        }
                    
                    }   
                                        
             }
                           }else
                                if(valor_recebido.length()==9){
                                
                                    if(valor_recebido.charAt(valor_recebido.length()-2)==','){
               
                                    String valor_saidaAux = valor_recebido.substring(0,3)+valor_recebido.substring(4,9);

                                    for(int i = 0; i < valor_saidaAux.length();i++){

                                        if(valor_saidaAux.charAt(i)==','){

                                            valor_saida = valor_saidaAux.substring(0,i) +"."+ valor_saidaAux.substring((i+1),valor_saidaAux.length());
                       //valor_saida = "teste"; 
                        }
                    
                    }   
                                        
             }else
                        if(valor_recebido.charAt(valor_recebido.length()-7)=='.'){
                            
                           String valor_saidaAux = valor_recebido.substring(0,2)+valor_recebido.substring(3,9);
                                     
                                for(int i = 0; i < valor_saidaAux.length();i++){
                                                     
                               if(valor_saidaAux.charAt(i)==','){
                      
                                valor_saida = valor_saidaAux.substring(0,i) +"."+ valor_saidaAux.substring((i+1),valor_saidaAux.length());
                       //valor_saida = "teste"; 
                        }
                    
                    }   
                                        
             }       
                                }else
                                    if(valor_recebido.length()==10){
                                    
                                        if(valor_recebido.charAt(valor_recebido.length()-2)==','){
               
                                    String valor_saidaAux = valor_recebido.substring(0,1)+valor_recebido.substring(2,6)+valor_recebido.substring(7,10);

                                    for(int i = 0; i < valor_saidaAux.length();i++){

                                        if(valor_saidaAux.charAt(i)==','){

                                            valor_saida = valor_saidaAux.substring(0,i) +"."+ valor_saidaAux.substring((i+1),valor_saidaAux.length());
                       //valor_saida = "teste"; 
                        }
                    
                    }   
                                        
             }else
                        if(valor_recebido.charAt(valor_recebido.length()-7)=='.'){
                            
                           String valor_saidaAux = valor_recebido.substring(0,3)+valor_recebido.substring(4,10);
                                     
                                for(int i = 0; i < valor_saidaAux.length();i++){
                                                     
                               if(valor_saidaAux.charAt(i)==','){
                      
                                valor_saida = valor_saidaAux.substring(0,i) +"."+ valor_saidaAux.substring((i+1),valor_saidaAux.length());
                       //valor_saida = "teste"; 
                        }
                    
                    }   
                                        
             }      
                                        
                                    }else
                                        if(valor_recebido.length()==11){
                                            if(valor_recebido.charAt(valor_recebido.length()-10)=='.' && valor_recebido.charAt(valor_recebido.length()-6)=='.' && valor_recebido.charAt(valor_recebido.length()-2)==','){
                                                //JOptionPane.showMessageDialog(null,"Ok");
                                                valor_saida = valor_recebido.substring(0,1)+valor_recebido.substring(2,5)+valor_recebido.substring(6,11);;
                                            }if(valor_recebido.charAt(valor_recebido.length()-8)=='.' && valor_recebido.charAt(valor_recebido.length()-4)=='.' ){
                                                //JOptionPane.showMessageDialog(null,"Ok");
                                                valor_saida = valor_recebido.substring(0,2)+valor_recebido.substring(3,6)+valor_recebido.substring(7,11);;
                                            }

                                        }else
                                        if(valor_recebido.length()==12){
                                            if(valor_recebido.charAt(valor_recebido.length()-11)=='.' && valor_recebido.charAt(valor_recebido.length()-7)=='.' && valor_recebido.charAt(valor_recebido.length()-3)==','){
                                                //JOptionPane.showMessageDialog(null,"Ok");
                                                valor_saida = valor_recebido.substring(0,1)+valor_recebido.substring(2,5)+valor_recebido.substring(6,12);;
                                            }if(valor_recebido.charAt(valor_recebido.length()-10)=='.' && valor_recebido.charAt(valor_recebido.length()-6)=='.' && valor_recebido.charAt(valor_recebido.length()-2)==','){
                                                //JOptionPane.showMessageDialog(null,"Ok");
                                                valor_saida = valor_recebido.substring(0,2)+valor_recebido.substring(3,6)+valor_recebido.substring(7,12);;
                                            }

                                    }
             return valor_saida;

        }
        public static void main(String args[]){

            VerificarUsuario vu = new VerificarUsuario();
            vu.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }

}
