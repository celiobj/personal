/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Persistencia.RepositorioConta;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author celio
 */
public class ConsultarLucro extends JFrame{

    JButton ok,limpar,saldo, sair;
    JComboBox destino;
    String contas[]={"","Todos","Bradesco", "Dinheiro","Locasul","Marquinho", "Priscila","Santander"};
    JLabel mar, santa, din,locasul,pris,brad,emprestado,recebido,lucro,tEmpMar,tEmpSanta,tEmpDin,tEmpLocasul,tEmpPris,tEmpBrad, tRecMar, tRecSanta, tRecDin,tRecLocasul,tRecPris,tRecBrad, tLucroMar, tLucroSanta, tLucroDin,tLucroLocasul, tLucroPris, tLucroBrad, data_ini, data_fim,total ,tTotalLucro, tTotalEmp, tTotalRec, saldoMar, saldoSanta, saldoDin,saldoLocasul, saldoPris, saldoBrad, saldoContas;
    JFormattedTextField tData_ini,tData_fim;
    MaskFormatter mascaraData_ini,mascaraData_fim;
    RepositorioConta rc;
    


        public ConsultarLucro(){

            super("..:: |Lucro| Controle Financeiro - CRAPS Vs. 3.0 ::..");
            final Container tela = getContentPane();
            tela.setLayout(null);

           
            ok = new JButton("OK");
            sair = new JButton("Sair");
            limpar = new JButton("Limpar");
            emprestado = new JLabel("|Emprestado|");
            recebido = new JLabel("|Recebido|");
            lucro = new JLabel("|Lucro|");
            mar = new JLabel("|Marquinho|");
            santa = new JLabel("|Santander|");
            locasul = new JLabel("|Locasul|");
            pris = new JLabel("|Priscila|");
            brad = new JLabel("|Bradesco|");
            din = new JLabel("|Dinheiro|");
            total = new JLabel("|Total|");
            tEmpMar = new JLabel("");
            tEmpSanta = new JLabel("");
            tEmpLocasul = new JLabel("");
            tEmpPris = new JLabel("");
            tEmpBrad = new JLabel("");
            tEmpDin = new JLabel("");
            tRecMar = new JLabel("");
            tRecSanta = new JLabel("");
            tRecLocasul = new JLabel("");
            tRecPris = new JLabel("");
            tRecBrad = new JLabel("");
            tRecDin = new JLabel("");
            tLucroMar = new JLabel("");
            tLucroSanta = new JLabel("");
            tLucroLocasul = new JLabel("");
            tLucroPris = new JLabel("");
            tLucroBrad = new JLabel("");
            tLucroDin = new JLabel("");
            tTotalEmp = new JLabel("");
            tTotalRec = new JLabel("");
            tTotalLucro = new JLabel("");
            //destino = new JComboBox(contas);
            data_ini = new JLabel("de:");
            data_fim = new JLabel("à");

               try{
        	   	mascaraData_ini = new MaskFormatter("##/##/####");
                mascaraData_fim = new MaskFormatter("##/##/####");
            	}catch (Exception exp){};
                    tData_ini = new JFormattedTextField(mascaraData_ini);
                    tData_fim = new JFormattedTextField(mascaraData_fim);


            ok.setBounds(650,50,100,20);
            sair.setBounds(850,50,100,20);
            emprestado.setBounds(190,150,100,20);
            recebido.setBounds(190,180,100,20);
            lucro.setBounds(190,210,100,20);
            mar.setBounds(290,130,100,20);
            tEmpMar.setBounds(300,150,100,20);
            tRecMar.setBounds(300,180,100,20);
            tLucroMar.setBounds(300,210,100,20);
            santa.setBounds(390,130,100,20);
            tEmpSanta.setBounds(400,150,100,20);
            tRecSanta.setBounds(400,180,100,20);
            tLucroSanta.setBounds(400,210,100,20);
            din.setBounds(500,130,100,20);
            tEmpDin.setBounds(500,150,100,20);
            tRecDin.setBounds(500,180,100,20);
            tLucroDin.setBounds(500,210,100,20);
            locasul.setBounds(600,130,100,20);
            tEmpLocasul.setBounds(600,150,100,20);
            tRecLocasul.setBounds(600,180,100,20);
            tLucroLocasul.setBounds(600,210,100,20);
            pris.setBounds(700,130,100,20);
            tEmpPris.setBounds(700,150,100,20);
            tRecPris.setBounds(700,180,100,20);
            tLucroPris.setBounds(700,210,100,20);
            brad.setBounds(800,130,100,20);
            tEmpBrad.setBounds(800,150,100,20);
            tRecBrad.setBounds(800,180,100,20);
            tLucroBrad.setBounds(800,210,100,20);
            total.setBounds(900,130,100,20);
            tTotalEmp.setBounds(900,150,100,20);
            tTotalRec.setBounds(900,180,100,20);
            tTotalLucro.setBounds(900,210,100,20);
            
            data_ini.setBounds(190,100,100,20);
            tData_ini.setBounds(220,100,80,20);
            data_fim.setBounds(310,100,100,20);
            tData_fim.setBounds(330,100,80,20);
          //  destino.setBounds(430,100,130,20);
            limpar.setBounds(750,50,100,20);
            
            

            tData_ini.setFont(new Font("Times New Roman", Font.BOLD, 14));
            tData_fim.setFont(new Font("Times New Roman", Font.BOLD, 14));

            tela.add(ok);
            tela.add(sair);
            tela.add(limpar);
            //  tela.add(destino);
            tela.add(data_fim);
            tela.add(data_ini);
            tela.add(tData_fim);
            tela.add(tData_ini);
            tela.add(recebido);
            tela.add(emprestado);
            tela.add(lucro);
            tela.add(mar);
            tela.add(santa);
            tela.add(din);
            tela.add(locasul);
            tela.add(pris);
            tela.add(brad);
            tela.add(tEmpMar);
            tela.add(tRecMar);
            tela.add(tLucroMar);
            tela.add(tEmpSanta);
            tela.add(tRecSanta);
            tela.add(tLucroSanta);
            tela.add(tEmpDin);
            tela.add(tRecDin);
            tela.add(tLucroDin);
            tela.add(tEmpLocasul);
            tela.add(tRecLocasul);
            tela.add(tLucroLocasul);
            tela.add(tEmpPris);
            tela.add(tRecPris);
            tela.add(tLucroPris);
            tela.add(tEmpBrad);
            tela.add(tRecBrad);
            tela.add(tLucroBrad);
            tela.add(total);
            tela.add(tTotalEmp);
            tela.add(tTotalRec);
            tela.add(tTotalLucro);
           
            

            limpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

               /* ControlaBcoBrasil cbb = new ControlaBcoBrasil();
                cbb.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                setVisible(false);*/
                
                        tData_fim.setText("");
                        tData_ini.setText("");
                        tEmpMar.setText("");
                        tEmpSanta.setText("");
                        tEmpDin.setText("");
                        tEmpBrad.setText("");
                        tEmpLocasul.setText("");
                        tEmpPris.setText("");
                        tRecMar.setText("");
                        tRecSanta.setText("");
                        tRecDin.setText("");
                        tRecBrad.setText("");
                        tRecLocasul.setText("");
                        tRecPris.setText("");
                        tLucroMar.setText("");
                        tLucroSanta.setText("");
                        tLucroDin.setText("");
                        tLucroBrad.setText("");
                        tLucroLocasul.setText("");
                        tLucroPris.setText("");
                        tTotalEmp.setText("");
                        tTotalRec.setText("");
                        tTotalLucro.setText("");
                       

            }
             });

             

             ok.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if(tData_ini.getText().equals("  /  /    ")||tData_fim.getText().equals("  /  /    ")){
                    JOptionPane.showMessageDialog(null,"Escolha um período!!!");
                }else{
                        rc = new RepositorioConta();

                        double emprestadoBrasilDoub = rc.consultarEmprestado("BcoBrasil", tData_ini.getText(), tData_fim.getText());
                        BigDecimal emprestadoBrasil = BigDecimal.valueOf(emprestadoBrasilDoub);
                        double recebidoBrasilDoub = rc.consultarRecebido("BcoBrasil", tData_ini.getText(), tData_fim.getText());
                        BigDecimal recebidoBrasil = BigDecimal.valueOf(recebidoBrasilDoub);
                        double emprestadoRealDoub = rc.consultarEmprestado("BcoReal", tData_ini.getText(), tData_fim.getText());
                        BigDecimal emprestadoReal = BigDecimal.valueOf(emprestadoRealDoub);
                        double recebidoRealDoub = rc.consultarRecebido("BcoReal", tData_ini.getText(), tData_fim.getText());
                        BigDecimal recebidoReal = BigDecimal.valueOf(recebidoRealDoub);
                        double emprestadoDinDoub = rc.consultarEmprestado("Dinheiro", tData_ini.getText(), tData_fim.getText());
                        BigDecimal emprestadoDin = BigDecimal.valueOf(emprestadoDinDoub);
                        double recebidoDinDoub = rc.consultarRecebido("Dinheiro", tData_ini.getText(), tData_fim.getText());
                        BigDecimal recebidoDin = BigDecimal.valueOf(recebidoDinDoub);
                        double emprestadoBradDoub = rc.consultarEmprestado("BcoBrad", tData_ini.getText(), tData_fim.getText());
                        BigDecimal emprestadoBrad = BigDecimal.valueOf(emprestadoBradDoub);
                        double recebidoBradDoub = rc.consultarRecebido("BcoBrad", tData_ini.getText(), tData_fim.getText());
                        BigDecimal recebidoBrad = BigDecimal.valueOf(recebidoBradDoub);
                        double emprestadoLocSulDoub = rc.consultarEmprestado("Locasul", tData_ini.getText(), tData_fim.getText());
                        BigDecimal emprestadoLocSul = BigDecimal.valueOf(emprestadoLocSulDoub);
                        double recebidoLocSulDoub = rc.consultarRecebido("Locasul", tData_ini.getText(), tData_fim.getText());
                        BigDecimal recebidoLocSul = BigDecimal.valueOf(recebidoLocSulDoub);
                        double emprestadoPrisDoub = rc.consultarEmprestado("Pris", tData_ini.getText(), tData_fim.getText());
                        BigDecimal emprestadoPris = BigDecimal.valueOf(emprestadoPrisDoub);
                        double recebidoPrisDoub = rc.consultarRecebido("Pris", tData_ini.getText(), tData_fim.getText());
                        BigDecimal recebidoPris = BigDecimal.valueOf(recebidoPrisDoub);
                        
                     

                        double lucroBraDoub = recebidoBrasilDoub - emprestadoBrasilDoub;
                        BigDecimal lucroBra = BigDecimal.valueOf(lucroBraDoub);
                        double lucroReDoub = recebidoRealDoub - emprestadoRealDoub;
                        BigDecimal lucroRe = BigDecimal.valueOf(lucroReDoub);
                        double lucroDinDoub = recebidoDinDoub - emprestadoDinDoub;
                        BigDecimal lucroDin = BigDecimal.valueOf(lucroDinDoub);
                        double lucroBradDoub = recebidoBradDoub - emprestadoBradDoub;
                        BigDecimal lucroBrad = BigDecimal.valueOf(lucroBradDoub);
                        double lucroPrisDoub = recebidoPrisDoub - emprestadoPrisDoub;
                        BigDecimal lucroPris = BigDecimal.valueOf(lucroPrisDoub);
                        double lucroLocSulDoub = recebidoLocSulDoub - emprestadoLocSulDoub;
                        BigDecimal lucrolocSul = BigDecimal.valueOf(lucroLocSulDoub);

                        double emprestadoTotalDoub = emprestadoBrasilDoub + emprestadoRealDoub + emprestadoDinDoub + emprestadoBradDoub + emprestadoLocSulDoub + emprestadoPrisDoub;
                        BigDecimal emprestadoTotal = BigDecimal.valueOf(emprestadoTotalDoub);
                        double recebidoTotalDoub = recebidoBrasilDoub + recebidoRealDoub + recebidoDinDoub + recebidoBradDoub + recebidoLocSulDoub + recebidoPrisDoub;
                        BigDecimal recebidoTotal = BigDecimal.valueOf(recebidoTotalDoub);
                        //double lucroTotalDoub =  emprestadoTotalDoub - recebidoTotalDoub;
                        double lucroTotalDoub =  lucroBraDoub+lucroBradDoub+lucroDinDoub+lucroLocSulDoub+lucroPrisDoub+lucroPrisDoub+lucroReDoub;
                        BigDecimal lucroTotal = BigDecimal.valueOf(lucroTotalDoub);
                                          
                        tEmpMar.setText("R$: "+VerificarUsuario.paraFormatoDinheiro(emprestadoBrasil));
                        tEmpSanta.setText("R$: "+VerificarUsuario.paraFormatoDinheiro(emprestadoReal));
                        tEmpDin.setText("R$: "+VerificarUsuario.paraFormatoDinheiro(emprestadoDin));
                        tEmpBrad.setText("R$: "+VerificarUsuario.paraFormatoDinheiro(emprestadoBrad));
                        tEmpLocasul.setText("R$: "+VerificarUsuario.paraFormatoDinheiro(emprestadoLocSul));
                        tEmpPris.setText("R$: "+VerificarUsuario.paraFormatoDinheiro(emprestadoPris));
                        tRecMar.setText("R$: "+VerificarUsuario.paraFormatoDinheiro(recebidoBrasil));
                        tRecSanta.setText("R$: "+VerificarUsuario.paraFormatoDinheiro(recebidoReal));
                        tRecDin.setText("R$: "+VerificarUsuario.paraFormatoDinheiro(recebidoDin));
                        tRecBrad.setText("R$: "+VerificarUsuario.paraFormatoDinheiro(recebidoBrad));
                        tRecLocasul.setText("R$: "+VerificarUsuario.paraFormatoDinheiro(recebidoLocSul));
                        tRecPris.setText("R$: "+VerificarUsuario.paraFormatoDinheiro(recebidoPris));
                        tLucroMar.setText("R$: "+VerificarUsuario.paraFormatoDinheiro(lucroBra));
                        tLucroSanta.setText("R$: "+VerificarUsuario.paraFormatoDinheiro(lucroRe));
                        tLucroDin.setText("R$: "+VerificarUsuario.paraFormatoDinheiro(lucroDin));
                        tLucroBrad.setText("R$: "+VerificarUsuario.paraFormatoDinheiro(lucroBrad));
                        tLucroLocasul.setText("R$: "+VerificarUsuario.paraFormatoDinheiro(lucrolocSul));
                        tLucroPris.setText("R$: "+VerificarUsuario.paraFormatoDinheiro(lucroPris));
                        tTotalEmp.setText("R$: "+VerificarUsuario.paraFormatoDinheiro(emprestadoTotal));
                        tTotalRec.setText("R$: "+VerificarUsuario.paraFormatoDinheiro(recebidoTotal));
                        tTotalLucro.setText("R$: "+VerificarUsuario.paraFormatoDinheiro(lucroTotal));
                        

                }


                }
            });

            sair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                        tData_fim.setText("");
                        tData_ini.setText("");
                        tEmpMar.setText("");
                        tEmpSanta.setText("");
                        tEmpDin.setText("");
                        tEmpBrad.setText("");
                        tEmpLocasul.setText("");
                        tEmpPris.setText("");
                        tRecMar.setText("");
                        tRecSanta.setText("");
                        tRecDin.setText("");
                        tRecBrad.setText("");
                        tRecLocasul.setText("");
                        tRecPris.setText("");
                        tLucroMar.setText("");
                        tLucroSanta.setText("");
                        tLucroDin.setText("");
                        tLucroBrad.setText("");
                        tLucroLocasul.setText("");
                        tLucroPris.setText("");
                        tTotalEmp.setText("");
                        tTotalRec.setText("");
                        tTotalLucro.setText("");
                       
                       

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

       
}
