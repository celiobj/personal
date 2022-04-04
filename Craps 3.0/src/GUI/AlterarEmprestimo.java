	/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Classes.Cliente;
import Classes.Emprestimo;
import Persistencia.RepositorioCliente;
import Persistencia.RepositorioConta;
import Persistencia.RepositorioEmprestimo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.*;
import javax.swing.text.*;


/**
 *
 * @author celio
 */
public class AlterarEmprestimo extends JFrame {

    JComboBox fonte;
	String contas[]={"","Bradesco", "Dinheiro","Locasul","Marquinho", "Priscila","Santander"};
    JButton gravar, limpar, sair, procurar;
    JLabel cod,nome, end_res,end_trab,valor, data_emp,data_dia, data_pag, juros, garantia,tel_res,tel_res2,tel_trab,tel_trab2, obs, resta;
    JTextField tCod,tResta,tNome, tValor,tEnd_res,tEnd_trab, tJuros, tGarantia, tObs;
    JFormattedTextField tData_pag,tData_emp,tTel_res,tTel_res2,tTel_trab,tTel_trab2;
    MaskFormatter mascaraData_emp,mascaraData_pag, mascaraTelefone,mascaraTelefone2,mascaraTelefone3,mascaraTelefone4;
    Calendar data;
    int dia, mes, ano;
    RepositorioEmprestimo re;
    RepositorioCliente rc;
    RepositorioConta rco;


        public AlterarEmprestimo() {
            super("..::|Alterar Empréstimo| Controle Financeiro - CRAPS Vs. 3.0 ::..");
            Container tela = getContentPane();
            tela.setLayout(null);


            gravar = new JButton("|Gravar|");
            limpar = new JButton("|Limpar|");
            sair = new JButton("|Sair|");
            procurar = new JButton("|Procurar|");
            cod = new JLabel("Cod: ");
            nome = new JLabel("Nome: ");
            end_res = new JLabel("End Res: ");
            tel_res = new JLabel("Tel: ");
            tel_res2 = new JLabel("Tel-2: ");
            end_trab = new JLabel("End Trab: ");
            tel_trab = new JLabel("Tel-3: ");
            tel_trab2 = new JLabel("Tel-4: ");
            valor = new JLabel("Valor: ");
            data_dia = new JLabel("");
            data_emp = new JLabel("Data : ");
            data_pag = new JLabel("Bom P/ : ");
            juros = new JLabel("Juros: ");
            garantia = new JLabel("Garantia: ");
            obs = new JLabel("Observações: ");
            resta = new JLabel("Resta: ");
            tCod = new JTextField(5);
            fonte = new JComboBox(contas);
            tResta = new JTextField(5);
            tObs = new JTextField(20);
            tNome = new JTextField(40);
            tEnd_res = new JTextField(200);
            tEnd_trab = new JTextField(200);
            tValor = new JTextField(5);
            tJuros = new JTextField(6);
            tGarantia = new JTextField(30);

            sair.setMnemonic(KeyEvent.VK_R);
            limpar.setMnemonic(KeyEvent.VK_L);
            gravar.setMnemonic(KeyEvent.VK_G);

            tResta.setFont(new Font("Times New Roman", Font.BOLD, 14));
            tCod.setFont(new Font("Times New Roman", Font.BOLD, 14));
            tNome.setFont(new Font("Times New Roman", Font.BOLD, 14));
            tEnd_res.setFont(new Font("Times New Roman", Font.BOLD, 14));
            tEnd_trab.setFont(new Font("Times New Roman", Font.BOLD, 14));
            tValor.setFont(new Font("Times New Roman", Font.BOLD, 14));
            tJuros.setFont(new Font("Times New Roman", Font.BOLD, 14));
            tGarantia.setFont(new Font("Times New Roman", Font.BOLD, 14));
            tObs.setFont(new Font("Times New Roman", Font.BOLD, 14));

           try{
        	   	mascaraData_pag = new MaskFormatter("##/##/####");
                mascaraData_emp = new MaskFormatter("##/##/####");
                mascaraTelefone = new MaskFormatter("####-####");
                mascaraTelefone2 = new MaskFormatter("####-####");
                mascaraTelefone3 = new MaskFormatter("####-####");
                mascaraTelefone4 = new MaskFormatter("####-####");

           }catch (Exception exp){};
                    tData_pag = new JFormattedTextField(mascaraData_pag);
                    tData_emp = new JFormattedTextField(mascaraData_emp);
                    tTel_res = new JFormattedTextField(mascaraTelefone);
                    tTel_res2 = new JFormattedTextField(mascaraTelefone2);
                    tTel_trab = new JFormattedTextField(mascaraTelefone3);
                    tTel_trab2 = new JFormattedTextField(mascaraTelefone4);

             tTel_res.setFont(new Font("Times New Roman", Font.BOLD, 14));
             tTel_res2.setFont(new Font("Times New Roman", Font.BOLD, 14));
             tTel_trab.setFont(new Font("Times New Roman", Font.BOLD, 14));
             tTel_trab2.setFont(new Font("Times New Roman", Font.BOLD, 14));
             tData_pag.setFont(new Font("Times New Roman", Font.BOLD, 14));
             tData_emp.setFont(new Font("Times New Roman", Font.BOLD, 14));
            

            data = Calendar.getInstance();
            dia = data.get(Calendar.DAY_OF_MONTH);
            mes = data.get(Calendar.MONTH);
            ano = data.get(Calendar.YEAR);
            data_dia.setText("Data:  "+dia+"/"+(mes+1)+"/"+ano);

            cod.setBounds(20,50,50,20);
            tCod.setBounds(50,50,50,20);
            procurar.setBounds(150,50,100,20);
            gravar.setBounds(20,340,100,20);
            limpar.setBounds(130,340,100,20);
            sair.setBounds(240,340,100,20);
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
            valor.setBounds(20,190,100,20);
            tValor.setBounds(60,190,100,20);
            resta.setBounds(190,190,100,20);
            tResta.setBounds(250,190,130,20);
            //fonte.setBounds(250,190,130,20);
           
            data_dia.setBounds(660,50,100,20);
            data_emp.setBounds(20,220,130,20);
            tData_emp.setBounds(100,220,100,20);
            data_pag.setBounds(20,250,100,20);
            tData_pag.setBounds(100,250,100,20);
            juros.setBounds(20,280,100,20);
            tJuros.setBounds(80,280,100,20);
            garantia.setBounds(20,310,100,20);
            tGarantia.setBounds(80,310,100,20);
            obs.setBounds(200,310,100,20);
            tObs.setBounds(300,310,200,20);

            gravar.setVisible(false);
            limpar.setVisible(false);

            tela.add(cod);
            tela.add(tCod);
            tela.add(procurar);
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
            tela.add(gravar);
            tela.add(limpar);
            tela.add(sair);
            tela.add(nome);
            tela.add(tNome);
            tela.add(valor);
            tela.add(tValor);
            tela.add(tResta);
            //tela.add(fonte);
            tela.add(resta);
            tela.add(data_dia);
            tela.add(data_emp);
            tela.add(tData_emp);
            tela.add(data_pag);
            tela.add(tData_pag);
            tela.add(juros);
            tela.add(tJuros);
            tela.add(garantia);
            tela.add(tGarantia);
            tela.add(obs);
            tela.add(tObs);
           

            procurar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if(tCod.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Preencha o campo Código !!!");
                }else{
                Emprestimo emp;
                Cliente cli;
                re = new RepositorioEmprestimo();
                rc = new RepositorioCliente();
                emp = re.paraAlterar(tCod.getText());
                if(emp==null){
                    JOptionPane.showMessageDialog(null,"Código não associado a nenhum empréstimo aberto");
                }else{
               
                tNome.setText(emp.getNome());
                tValor.setText(VerificarUsuario.paraFormatoDinheiro(BigDecimal.valueOf(Double.parseDouble(emp.getValor()))));
                tResta.setText(VerificarUsuario.paraFormatoDinheiro(BigDecimal.valueOf(Double.parseDouble(emp.getValor_rec()))));
                //tObsEmp.setText(emp.get)
                tData_emp.setText(emp.getData_emp());
                tData_pag.setText(emp.getData_pag());
                tJuros.setText(VerificarUsuario.paraFormatoDinheiro(BigDecimal.valueOf(Double.parseDouble(emp.getJuros()))));
                tGarantia.setText(emp.getGarantia());

                
                cli = rc.procurarNome(tNome.getText());
                tEnd_res.setText(cli.getEnd_res());
                tTel_res.setText(cli.getTel_res());
                tTel_res2.setText(cli.getTel_res2());
                tEnd_trab.setText(cli.getEnd_trab());
                tTel_trab.setText(cli.getTel_trab());
                tTel_trab2.setText(cli.getTel_trab2());
                tObs.setText(cli.getOutros());

                gravar.setVisible(true);
                limpar.setVisible(true);
                tCod.setEditable(false);
                tValor.setEditable(false);
                tResta.setEditable(false);
                tData_emp.setEditable(false);
                tData_pag.setEditable(false);
                tJuros.setEditable(false);
                        }
                    }
            }
                    });


            gravar.addActionListener(new ActionListener(){
                public void actionPerformed (ActionEvent e){
                    int resposta = JOptionPane.showConfirmDialog(null, "Deseja Alterar esse registro?");
                    if(resposta == 0){

                     
                    re = new RepositorioEmprestimo();
                    rc = new RepositorioCliente();

                    Emprestimo emp = new Emprestimo();
                    emp.setNome(tNome.getText());
                    emp.setGarantia(tGarantia.getText());


                    Cliente cli = rc.verificarExistente(tNome.getText());
                    String codIns = cli.getCod_cliente();
                    cli.setNome(tNome.getText());
                    cli.setEnd_res(tEnd_res.getText());
                    cli.setEnd_trab(tEnd_trab.getText());
                    cli.setTel_res(tTel_res.getText());
                    cli.setTel_res2(tTel_res2.getText());
                    cli.setTel_trab(tTel_trab.getText());
                    cli.setTel_trab2(tTel_trab2.getText());
                    cli.setOutros(tObs.getText());

                    re.Alterar(tCod.getText(), emp);
                    re.AlterarTudo(tCod.getText(), emp);
                    rc.alterar(codIns, cli);


                    tCod.setEditable(true);
                    gravar.setVisible(false);
                    limpar.setVisible(false);
                    tNome.setText("");
                    tEnd_res.setText("");
                    tEnd_trab.setText("");
                    tTel_res.setText("");
                    tTel_res2.setText("");
                    tTel_trab.setText("");
                    tTel_trab2.setText("");
                    tValor.setText("");
                    tData_emp.setText("");
                    tData_pag.setText("");
                    tJuros.setText("");
                    tGarantia.setText("");
                    tObs.setText("");
                    tCod.setText("");

                    }else{
                   
                  }
                }
                         

                    
                
            });

            limpar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){

                    tCod.setEditable(true);
                    gravar.setVisible(false);
                    limpar.setVisible(false);
                    tNome.setText("");
                    tEnd_res.setText("");
                    tEnd_trab.setText("");
                    tTel_res.setText("");
                    tTel_res2.setText("");
                    tTel_trab.setText("");
                    tTel_trab2.setText("");
                    tValor.setText("");
                    tData_emp.setText("");
                    tData_pag.setText("");
                    tJuros.setText("");
                    tGarantia.setText("");
                    tObs.setText("");
                    tCod.setText("");
                }
            });

            sair.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){

                    tCod.setEditable(true);
                    gravar.setVisible(false);
                    limpar.setVisible(false);
                    tNome.setText("");
                    tEnd_res.setText("");
                    tEnd_trab.setText("");
                    tTel_res.setText("");
                    tTel_res2.setText("");
                    tTel_trab.setText("");
                    tTel_trab2.setText("");
                    tValor.setText("");
                    tData_emp.setText("");
                    tData_pag.setText("");
                    tJuros.setText("");
                    tGarantia.setText("");
                    tObs.setText("");
                    tCod.setText("");


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
