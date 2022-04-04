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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author celio
 */
public class ControlaBcoBrad extends JFrame{

    JButton extrato,transferir,depositar, sacar,ok,oksacar,okdepositar,oktransferir,limpar, sair;
    JComboBox destino;
    String contas[]={"","Priscila","LocaSul","Marquinho","Santander","Dinheiro"};
    JLabel valor,saldoExtrato, acao, motivo;
    JTextField tValor, tMotivo;
    JScrollPane scroller;
    JTable tabela;
    RepositorioConta rc;


        public ControlaBcoBrad(){

            super("..:: |Gerenciamento da conta do Banco Bradesco| Controle Financeiro - CRAPS Vs. 3.0 ::..");
            final Container tela = getContentPane();
            tela.setLayout(null);

            extrato = new JButton("Extrato");
            transferir = new JButton("Transferir");
            sacar =  new JButton("Sacar");
            depositar = new JButton("Depositar");
            motivo = new JLabel("Motivo: ");
            tMotivo = new JTextField(100);
            ok = new JButton("OK");
            oksacar  = new JButton("OK");
            oktransferir  = new JButton("OK");
            okdepositar  = new JButton("OK");
            sair = new JButton("Sair");
            limpar = new JButton("Limpar");
            valor = new JLabel("Valor: ");
            tValor = new JTextField(10);
            saldoExtrato = new JLabel("");
            acao = new JLabel("");
            destino = new JComboBox(contas);

            extrato.setBounds(200,50,100,20);
            transferir.setBounds(350,50,100,20);
            sacar.setBounds(500,50,100,20);
            depositar.setBounds(650,50,100,20);
            sair.setBounds(800,50,100,20);
            acao.setBounds(200,100,100,20);
            valor.setBounds(200,150,100,20);
            tValor.setBounds(240,150,100,20);
            motivo.setBounds(200,180,100,20);
            tMotivo.setBounds(250,180,200,20);
            destino.setBounds(350,150,130,20);
            ok.setBounds(500,150,100,20);
            oktransferir.setBounds(500,150,100,20);
            okdepositar.setBounds(500,150,100,20);
            oksacar.setBounds(500,150,100,20);
            limpar.setBounds(650,150,100,20);
            saldoExtrato.setBounds(50,120,200,20);

            tValor.setFont(new Font("Times New Roman", Font.BOLD, 14));
            tMotivo.setFont(new Font("Times New Roman", Font.BOLD, 14));

            destino.setVisible(false);
            motivo.setVisible(false);
            tMotivo.setVisible(false);
            valor.setVisible(false);
            tValor.setVisible(false);
            ok.setVisible(false);
            oksacar.setVisible(false);
            okdepositar.setVisible(false);
            oktransferir.setVisible(false);
            limpar.setVisible(false);

            tela.add(ok);
            tela.add(acao);
            tela.add(oktransferir);
            tela.add(oksacar);
            tela.add(okdepositar);
            tela.add(sair);
            tela.add(extrato);
            tela.add(transferir);
            tela.add(sacar);
            tela.add(depositar);
            tela.add(limpar);
            tela.add(valor);
            tela.add(tValor);
            tela.add(saldoExtrato);
            tela.add(destino);
            tela.add(motivo);
            tela.add(tMotivo);



            extrato.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                rc = new RepositorioConta();
                BigDecimal saldo = BigDecimal.valueOf(rc.saldo("BcoBrad"));
                saldoExtrato.setText("Saldo Atual: R$ "+VerificarUsuario.paraFormatoDinheiro(saldo));
                tabela = rc.extrato("BcoBrad");
                scroller = new JScrollPane(tabela,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	            tela.add(scroller);
	            scroller.setBounds(20, 300,1000, 300);
                }
             });

            depositar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                destino.setVisible(false);
                valor.setVisible(true);
                tValor.setVisible(true);
                motivo.setVisible(true);
                tMotivo.setVisible(true);
                okdepositar.setVisible(true);
                limpar.setVisible(true);
                acao.setText("Depósito");

                 }
           });

            sacar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                destino.setVisible(false);
                valor.setVisible(true);
                tValor.setVisible(true);
                motivo.setVisible(true);
                tMotivo.setVisible(true);
                oksacar.setVisible(true);
                limpar.setVisible(true);
                acao.setText("Saque");

                 }
           });

            transferir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                destino.setVisible(true);
                valor.setVisible(true);
                tValor.setVisible(true);
                motivo.setVisible(true);
                tMotivo.setVisible(true);
                oktransferir.setVisible(true);
                limpar.setVisible(true);
                acao.setText("Transferência");

                 }
           });

            oksacar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                rc = new RepositorioConta();
                double saldoDoub = rc.sacar("Saque",VerificarUsuario.formatoParaInserir(tValor.getText()),"BcoBrad", tMotivo.getText());
                BigDecimal saldo = BigDecimal.valueOf(saldoDoub);
                String novoSaldo = VerificarUsuario.paraFormatoDinheiro(saldo);
                JOptionPane.showMessageDialog(null,"Novo saldo é: "+novoSaldo);
                /*ControlaBcoBrasil cbb = new ControlaBcoBrasil();
                cbb.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                setVisible(false);*/
                
                 try{
                destino.setVisible(false);
                valor.setVisible(false);
                tValor.setVisible(false);
                tValor.setText("");
                motivo.setVisible(false);
                tMotivo.setVisible(false);
                tMotivo.setText("");
                acao.setText("");
                saldoExtrato.setText("");
                ok.setVisible(false);
                oksacar.setVisible(false);
                okdepositar.setVisible(false);
                oktransferir.setVisible(false);
                limpar.setVisible(false);
                scroller.setVisible(false);
                tela.remove(scroller);
               }catch(Exception ex){
                    destino.setVisible(false);
                    valor.setVisible(false);
                    tValor.setVisible(false);
                    motivo.setVisible(false);
                    tMotivo.setVisible(false);
                    tMotivo.setText("");
                    tValor.setText("");
                    acao.setText("");
                    saldoExtrato.setText("");
                    ok.setVisible(false);
                    oksacar.setVisible(false);
                    okdepositar.setVisible(false);
                    oktransferir.setVisible(false);
                    limpar.setVisible(false);

               }
                 }
           });

           oktransferir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String banco = null;
                rc = new RepositorioConta();
                double saldoDeNum = rc.saldo("BcoBrad");
                String saldoDe = String.valueOf(saldoDeNum);
                if(destino.getSelectedItem().toString().equals("Santander")){
                    banco = "BcoReal";
                }else
                    if(destino.getSelectedItem().toString().equals("Dinheiro")){
                    banco = "Dinheiro";
                    }else
                        if(destino.getSelectedItem().toString().equals("Marquinho")){
                        banco = "BcoBrasil";
                        }else
                            if(destino.getSelectedItem().toString().equals("Priscila")){
                            banco = "Pris";
                            }else
                                if(destino.getSelectedItem().toString().equals("LocaSul")){
                                banco = "Locasul";
                                }
                double saldoParaNum =  rc.saldo(banco);
                String saldoPara = String.valueOf(saldoParaNum);
                double saldoDoub = rc.transferir("BcoBrad",saldoDe,banco,saldoPara,VerificarUsuario.formatoParaInserir(tValor.getText()) ,destino.getSelectedItem().toString()+" - "+tMotivo.getText()+"","Banco Bradesco - "+tMotivo.getText()+"");
                BigDecimal saldo = BigDecimal.valueOf(saldoDoub);
                String novoSaldo = VerificarUsuario.paraFormatoDinheiro(saldo);
                JOptionPane.showMessageDialog(null,"Novo saldo é: "+novoSaldo);
               /* ControlaBcoBrasil cbb = new ControlaBcoBrasil();
                cbb.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                setVisible(false);*/
               
                try{
                destino.setVisible(false);
                valor.setVisible(false);
                tValor.setVisible(false);
                tValor.setText("");
                motivo.setVisible(false);
                tMotivo.setVisible(false);
                tMotivo.setText("");
                acao.setText("");
                saldoExtrato.setText("");
                ok.setVisible(false);
                oksacar.setVisible(false);
                okdepositar.setVisible(false);
                oktransferir.setVisible(false);
                limpar.setVisible(false);
                scroller.setVisible(false);
                tela.remove(scroller);
               }catch(Exception ex){
                    destino.setVisible(false);
                    valor.setVisible(false);
                    tValor.setVisible(false);
                    tValor.setText("");
                    motivo.setVisible(false);
                    tMotivo.setVisible(false);
                    tMotivo.setText("");
                    acao.setText("");
                    saldoExtrato.setText("");
                    ok.setVisible(false);
                    oksacar.setVisible(false);
                    okdepositar.setVisible(false);
                    oktransferir.setVisible(false);
                    limpar.setVisible(false);

               }
                }
           });

           okdepositar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                rc = new RepositorioConta();
                double saldoDoub = rc.depositar("Depósito",VerificarUsuario.formatoParaInserir(tValor.getText()),"BcoBrad", tMotivo.getText());
                BigDecimal saldo = BigDecimal.valueOf(saldoDoub);
                String novoSaldo = VerificarUsuario.paraFormatoDinheiro(saldo);
                JOptionPane.showMessageDialog(null,"Novo saldo é: "+novoSaldo);
               /* ControlaBcoBrasil cbb = new ControlaBcoBrasil();
                cbb.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                setVisible(false);*/
                
                try{
                destino.setVisible(false);
                valor.setVisible(false);
                tValor.setVisible(false);
                tValor.setText("");
                motivo.setVisible(false);
                tMotivo.setVisible(false);
                tMotivo.setText("");
                acao.setText("");
                saldoExtrato.setText("");
                ok.setVisible(false);
                oksacar.setVisible(false);
                okdepositar.setVisible(false);
                oktransferir.setVisible(false);
                limpar.setVisible(false);
                scroller.setVisible(false);
                tela.remove(scroller);
               }catch(Exception ex){
                    destino.setVisible(false);
                    valor.setVisible(false);
                    tValor.setVisible(false);
                    tValor.setText("");
                    motivo.setVisible(false);
                    tMotivo.setVisible(false);
                    tMotivo.setText("");
                    acao.setText("");
                    saldoExtrato.setText("");
                    ok.setVisible(false);
                    oksacar.setVisible(false);
                    okdepositar.setVisible(false);
                    oktransferir.setVisible(false);
                    limpar.setVisible(false);

               }
                 }
           });

            limpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

               /* ControlaBcoBrasil cbb = new ControlaBcoBrasil();
                cbb.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                setVisible(false);*/
               try{
                destino.setVisible(false);
                valor.setVisible(false);
                tValor.setVisible(false);
                tValor.setText("");
                acao.setText("");
                motivo.setVisible(false);
                tMotivo.setVisible(false);
                tMotivo.setText("");
                saldoExtrato.setText("");
                ok.setVisible(false);
                oksacar.setVisible(false);
                okdepositar.setVisible(false);
                oktransferir.setVisible(false);
                limpar.setVisible(false);
                scroller.setVisible(false);
                tela.remove(scroller);
               }catch(Exception ex){
                    destino.setVisible(false);
                    valor.setVisible(false);
                    tValor.setVisible(false);
                    tValor.setText("");
                    acao.setText("");
                    saldoExtrato.setText("");
                    ok.setVisible(false);
                    oksacar.setVisible(false);
                    okdepositar.setVisible(false);
                    oktransferir.setVisible(false);
                    limpar.setVisible(false);

               }
                }
             });

            sair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                  try{
                destino.setVisible(false);
                valor.setVisible(false);
                tValor.setVisible(false);
                tValor.setText("");
                acao.setText("");
                motivo.setVisible(false);
                tMotivo.setVisible(false);
                tMotivo.setText("");
                saldoExtrato.setText("");
                ok.setVisible(false);
                oksacar.setVisible(false);
                okdepositar.setVisible(false);
                oktransferir.setVisible(false);
                limpar.setVisible(false);
                scroller.setVisible(false);
                tela.remove(scroller);
               }catch(Exception ex){
                    destino.setVisible(false);
                    valor.setVisible(false);
                    tValor.setVisible(false);
                    tValor.setText("");
                    motivo.setVisible(false);
                    tMotivo.setVisible(false);
                    tMotivo.setText("");
                    acao.setText("");
                    saldoExtrato.setText("");
                    ok.setVisible(false);
                    oksacar.setVisible(false);
                    okdepositar.setVisible(false);
                    oktransferir.setVisible(false);
                    limpar.setVisible(false);

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

      

}
