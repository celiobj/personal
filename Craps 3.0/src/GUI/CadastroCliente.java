	/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Classes.Cliente;
import Persistencia.RepositorioCliente;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;


/**
 *
 * @author celio
 */
public class CadastroCliente extends JFrame {

    
	
    JButton alterar, limpar,todos,filtrar, sair;
    JLabel cod,nome, end_res,end_trab,tel_res,tel_res2,tel_trab,tel_trab2, obs;
    JTextField tCod,tNome,tEnd_res,tEnd_trab, tObs;
    JFormattedTextField tTel_res,tTel_res2,tTel_trab,tTel_trab2;
    MaskFormatter mascaraTelefone,mascaraTelefone2,mascaraTelefone3,mascaraTelefone4;
    RepositorioCliente rc;
    JTable tabela;
    JScrollPane scroller;
    
        public CadastroCliente() {
            super("..::|Cadastro de Clientes| Controle Financeiro - CRAPS Vs. 3.0 ::..");
            final Container tela = getContentPane();
            tela.setLayout(null);


            alterar = new JButton("|Alterar|");
            todos = new JButton("|Todos|");
            filtrar = new JButton("|Filtrar|");
            limpar = new JButton("|Limpar|");
            sair = new JButton("|Sair|");
            nome = new JLabel("Nome: ");
            end_res = new JLabel("End Res: ");
            tel_res = new JLabel("Tel: ");
            tel_res2 = new JLabel("Tel-2: ");
            end_trab = new JLabel("End Trab: ");
            tel_trab = new JLabel("Tel-3: ");
            tel_trab2 = new JLabel("Tel-4: ");
            cod = new JLabel("Cod: ");
            tCod = new JTextField();
            obs = new JLabel("Observações: ");
            tObs = new JTextField(20);
            tNome = new JTextField(40);
            tEnd_res = new JTextField(200);
            tEnd_trab = new JTextField(200);
           
            sair.setMnemonic(KeyEvent.VK_R);
            limpar.setMnemonic(KeyEvent.VK_L);
            alterar.setMnemonic(KeyEvent.VK_A);

            tNome.setFont(new Font("Times New Roman", Font.BOLD, 14));
            tEnd_res.setFont(new Font("Times New Roman", Font.BOLD, 14));
            tEnd_trab.setFont(new Font("Times New Roman", Font.BOLD, 14));
            tObs.setFont(new Font("Times New Roman", Font.BOLD, 14));

           try{
        	    mascaraTelefone = new MaskFormatter("####-####");
                mascaraTelefone2 = new MaskFormatter("####-####");
                mascaraTelefone3 = new MaskFormatter("####-####");
                mascaraTelefone4 = new MaskFormatter("####-####");

           }catch (Exception exp){};
                   
                    tTel_res = new JFormattedTextField(mascaraTelefone);
                    tTel_res2 = new JFormattedTextField(mascaraTelefone2);
                    tTel_trab = new JFormattedTextField(mascaraTelefone3);
                    tTel_trab2 = new JFormattedTextField(mascaraTelefone4);

             tCod.setFont(new Font("Times New Roman", Font.BOLD, 14));
             tTel_res.setFont(new Font("Times New Roman", Font.BOLD, 14));
             tTel_res2.setFont(new Font("Times New Roman", Font.BOLD, 14));
             tTel_trab.setFont(new Font("Times New Roman", Font.BOLD, 14));
             tTel_trab2.setFont(new Font("Times New Roman", Font.BOLD, 14));
            

            todos.setBounds(400,50,100,20);
            filtrar.setBounds(100,50,100,20);
            limpar.setBounds(500,50,100,20);
            sair.setBounds(600,50,100,20);
            alterar.setBounds(20,220,100,20);
            cod.setBounds(20,50,50,20);
            tCod.setBounds(50,50,50,20);
            nome.setBounds(20,100,100,20);
            tNome.setBounds(60,100,340,20);
            end_res.setBounds(20,130,100,20);
            tEnd_res.setBounds(80,130,320,20);
            tel_res.setBounds(420,130,40,20);
            tTel_res.setBounds(460,130,80,20);
            tel_res2.setBounds(560,130,40,20);
            tTel_res2.setBounds(600,130,80,20);
            end_trab.setBounds(20,160,100,20);
            tEnd_trab.setBounds(80,160,320,20);
            tel_trab.setBounds(420,160,40,20);
            tTel_trab.setBounds(460,160,80,20);
            tel_trab2.setBounds(560,160,80,20);
            tTel_trab2.setBounds(600,160,80,20);
            obs.setBounds(20,190,100,20);
            tObs.setBounds(100,190,200,20);

            tela.add(filtrar);
            tela.add(cod);
            tela.add(tCod);
            tela.add(alterar);
            tela.add(todos);
            tela.add(end_res);
            tela.add(tEnd_res);
            tela.add(tel_res);
            tela.add(tTel_res);
            tela.add(tel_res2);
            tela.add(tTel_res2);
            tela.add(end_trab);
            tela.add(tEnd_trab);
            tela.add(tel_trab);
            tela.add(tTel_trab);
            tela.add(tel_trab2);
            tela.add(tTel_trab2);
            tela.add(limpar);
            tela.add(sair);
            tela.add(nome);
            tela.add(tNome);
            tela.add(obs);
            tela.add(tObs);

            filtrar.setVisible(false);
            cod.setVisible(false);
            tCod.setVisible(false);
            nome.setVisible(false);
            tNome.setVisible(false);
            end_res.setVisible(false);
            tEnd_res.setVisible(false);
            end_trab.setVisible(false);
            tEnd_trab.setVisible(false);
            tel_res.setVisible(false);
            tTel_res.setVisible(false);
            tel_trab.setVisible(false);
            tTel_trab.setVisible(false);
            tel_res2.setVisible(false);
            tTel_res2.setVisible(false);
            tel_trab2.setVisible(false);
            tTel_trab2.setVisible(false);
            obs.setVisible(false);
            tObs.setVisible(false);


            todos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                filtrar.setVisible(true);
                cod.setVisible(true);
                tCod.setVisible(true);
                tCod.setText("");
                tCod.setEditable(true);
                rc = new RepositorioCliente();
                tabela = rc.listarTodos();
                if(tabela.getValueAt(0, 0)==null){
                    JOptionPane.showMessageDialog(null,"Registros não Encontrados");
                }else{
	            scroller = new JScrollPane(tabela, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	            tela.add(scroller);
	            scroller.setBounds(20,300,1000,300);
                    }
                }
             });

             filtrar.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {


                    if(tCod.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Digite um código!!!");
                    }else{

                    tCod.setEditable(false);
                    rc = new RepositorioCliente();
                    Cliente cli = rc.procurar(tCod.getText());
                    if(cli==null){
                        JOptionPane.showMessageDialog(null, "Código não associado a nenhum cliente\n Confira o código e redigite!!");
                        tCod.setText("");
                        tCod.setEditable(true);
                    }else{

                    tNome.setText(cli.getNome());
                    tEnd_res.setText(cli.getEnd_res());
                    tEnd_trab.setText(cli.getEnd_trab());
                    tTel_res.setText(cli.getTel_res());
                    tTel_res2.setText(cli.getTel_res2());
                    tTel_trab.setText(cli.getTel_trab());
                    tTel_trab2.setText(cli.getTel_trab2());
                    tObs.setText(cli.getOutros());

                    
                    
                    nome.setVisible(true);
                    tNome.setVisible(true);
                    end_res.setVisible(true);
                    tEnd_res.setVisible(true);
                    end_trab.setVisible(true);
                    tEnd_trab.setVisible(true);
                    tel_res.setVisible(true);
                    tTel_res.setVisible(true);
                    tel_trab.setVisible(true);
                    tTel_trab.setVisible(true);
                    tel_res2.setVisible(true);
                    tTel_res2.setVisible(true);
                    tel_trab2.setVisible(true);
                    tTel_trab2.setVisible(true);
                    obs.setVisible(true);
                    tObs.setVisible(true);
                     }
                    }
                }
            });

            alterar.addActionListener(new ActionListener(){
                public void actionPerformed (ActionEvent e){


                    int resposta;
                     resposta=JOptionPane.showConfirmDialog(null,"Deseja realmente alterar esse registro?","Confirmação",JOptionPane.YES_NO_OPTION);
                     if(resposta==0){
                    RepositorioCliente rc = new RepositorioCliente();
                    Cliente cli = rc.procurar(tCod.getText());
                    Cliente novo = new Cliente();
                    novo.setNome(tNome.getText());
                    novo.setEnd_res(tEnd_res.getText());
                    novo.setTel_res(tTel_res.getText());
                    novo.setTel_res2(tTel_res2.getText());
                    novo.setEnd_trab(tEnd_trab.getText());
                    novo.setTel_trab(tTel_trab.getText());
                    novo.setTel_trab2(tTel_trab2.getText());
                    novo.setOutros(tObs.getText());
                    rc.alterar(cli.getCod_cliente(), novo);

                    JOptionPane.showMessageDialog(null, "Registro Alterado com Sucesso!!!");
                    /*CadastroCliente cc = new CadastroCliente();
                    cc.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    setVisible(false);*/
              try{
                    tNome.setText("");
                    tEnd_res.setText("");
                    tEnd_trab.setText("");
                    tTel_res.setText("");
                    tTel_res2.setText("");
                    tTel_trab.setText("");
                    tTel_trab2.setText("");
                    tObs.setText("");
                    filtrar.setVisible(false);
                    cod.setVisible(false);
                    tCod.setVisible(false);
                    nome.setVisible(false);
                    tNome.setVisible(false);
                    end_res.setVisible(false);
                    tEnd_res.setVisible(false);
                    end_trab.setVisible(false);
                    tEnd_trab.setVisible(false);
                    tel_res.setVisible(false);
                    tTel_res.setVisible(false);
                    tel_trab.setVisible(false);
                    tTel_trab.setVisible(false);
                    tel_res2.setVisible(false);
                    tTel_res2.setVisible(false);
                    tel_trab2.setVisible(false);
                    tTel_trab2.setVisible(false);
                    obs.setVisible(false);
                    tObs.setVisible(false);
                    scroller.setVisible(false);
                    tela.remove(scroller);
                   }catch(Exception ex){

                        tNome.setText("");
                        tEnd_res.setText("");
                        tEnd_trab.setText("");
                        tTel_res.setText("");
                        tTel_res2.setText("");
                        tTel_trab.setText("");
                        tTel_trab2.setText("");
                        tObs.setText("");
                        filtrar.setVisible(false);
                        cod.setVisible(false);
                        tCod.setVisible(false);
                        nome.setVisible(false);
                        tNome.setVisible(false);
                        end_res.setVisible(false);
                        tEnd_res.setVisible(false);
                        end_trab.setVisible(false);
                        tEnd_trab.setVisible(false);
                        tel_res.setVisible(false);
                        tTel_res.setVisible(false);
                        tel_trab.setVisible(false);
                        tTel_trab.setVisible(false);
                        tel_res2.setVisible(false);
                        tTel_res2.setVisible(false);
                        tel_trab2.setVisible(false);
                        tTel_trab2.setVisible(false);
                        obs.setVisible(false);
                        tObs.setVisible(false);
                   }
                 
                     }
                }
            });

            limpar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){

                    /*CadastroCliente cc = new CadastroCliente();
                    cc.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    setVisible(false);*/
                   try{
                    tNome.setText("");
                    tEnd_res.setText("");
                    tEnd_trab.setText("");
                    tTel_res.setText("");
                    tTel_res2.setText("");
                    tTel_trab.setText("");
                    tTel_trab2.setText("");
                    tObs.setText("");
                    filtrar.setVisible(false);
                    cod.setVisible(false);
                    tCod.setVisible(false);
                    nome.setVisible(false);
                    tNome.setVisible(false);
                    end_res.setVisible(false);
                    tEnd_res.setVisible(false);
                    end_trab.setVisible(false);
                    tEnd_trab.setVisible(false);
                    tel_res.setVisible(false);
                    tTel_res.setVisible(false);
                    tel_trab.setVisible(false);
                    tTel_trab.setVisible(false);
                    tel_res2.setVisible(false);
                    tTel_res2.setVisible(false);
                    tel_trab2.setVisible(false);
                    tTel_trab2.setVisible(false);
                    obs.setVisible(false);
                    tObs.setVisible(false);
                    scroller.setVisible(false);
                    tela.remove(scroller);
                   }catch(Exception ex){

                        tNome.setText("");
                        tEnd_res.setText("");
                        tEnd_trab.setText("");
                        tTel_res.setText("");
                        tTel_res2.setText("");
                        tTel_trab.setText("");
                        tTel_trab2.setText("");
                        tObs.setText("");
                        filtrar.setVisible(false);
                        cod.setVisible(false);
                        tCod.setVisible(false);
                        nome.setVisible(false);
                        tNome.setVisible(false);
                        end_res.setVisible(false);
                        tEnd_res.setVisible(false);
                        end_trab.setVisible(false);
                        tEnd_trab.setVisible(false);
                        tel_res.setVisible(false);
                        tTel_res.setVisible(false);
                        tel_trab.setVisible(false);
                        tTel_trab.setVisible(false);
                        tel_res2.setVisible(false);
                        tTel_res2.setVisible(false);
                        tel_trab2.setVisible(false);
                        tTel_trab2.setVisible(false);
                        obs.setVisible(false);
                        tObs.setVisible(false);
                   }

                }
            });

            sair.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){

                   try{
                    tNome.setText("");
                    tEnd_res.setText("");
                    tEnd_trab.setText("");
                    tTel_res.setText("");
                    tTel_res2.setText("");
                    tTel_trab.setText("");
                    tTel_trab2.setText("");
                    tObs.setText("");
                    filtrar.setVisible(false);
                    cod.setVisible(false);
                    tCod.setVisible(false);
                    nome.setVisible(false);
                    tNome.setVisible(false);
                    end_res.setVisible(false);
                    tEnd_res.setVisible(false);
                    end_trab.setVisible(false);
                    tEnd_trab.setVisible(false);
                    tel_res.setVisible(false);
                    tTel_res.setVisible(false);
                    tel_trab.setVisible(false);
                    tTel_trab.setVisible(false);
                    tel_res2.setVisible(false);
                    tTel_res2.setVisible(false);
                    tel_trab2.setVisible(false);
                    tTel_trab2.setVisible(false);
                    obs.setVisible(false);
                    tObs.setVisible(false);
                    scroller.setVisible(false);
                    tela.remove(scroller);
                   }catch(Exception ex){

                        tNome.setText("");
                        tEnd_res.setText("");
                        tEnd_trab.setText("");
                        tTel_res.setText("");
                        tTel_res2.setText("");
                        tTel_trab.setText("");
                        tTel_trab2.setText("");
                        tObs.setText("");
                        filtrar.setVisible(false);
                        cod.setVisible(false);
                        tCod.setVisible(false);
                        nome.setVisible(false);
                        tNome.setVisible(false);
                        end_res.setVisible(false);
                        tEnd_res.setVisible(false);
                        end_trab.setVisible(false);
                        tEnd_trab.setVisible(false);
                        tel_res.setVisible(false);
                        tTel_res.setVisible(false);
                        tel_trab.setVisible(false);
                        tTel_trab.setVisible(false);
                        tel_res2.setVisible(false);
                        tTel_res2.setVisible(false);
                        tel_trab2.setVisible(false);
                        tTel_trab2.setVisible(false);
                        obs.setVisible(false);
                        tObs.setVisible(false);
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
            setSize(800,600);
            setVisible(true);
            setLocationRelativeTo(null);


        }
}
