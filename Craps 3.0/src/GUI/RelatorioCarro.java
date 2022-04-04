


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Persistencia.RepositorioCarro;
import Persistencia.RepositorioCliente;
import Persistencia.RepositorioConta;
import Persistencia.RepositorioEmprestimo;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author casa
 */
public class RelatorioCarro extends JFrame {

    public static Vector carros;
    JComboBox acao,fonte, carro;
    String tipo[]={"Ação","Crédito","Débito"};
    String contas[]={"Financeiro","Banco do Brasil", "Banco Real", "Dinheiro"};
    JButton consultar, ver_end,finalizar, renovar,filtrar, limpar, sair;
    JLabel tSaldo, tDebito, tCredito,valor, carroL,cod, nome,end_res,end_trab, juros, valor_pag,tel_res,tel_res2, tel_trab,tel_trab2,outros, data_pag,data_emp, pegou_mais, total, obs_emp,debito,credito,saldo;
    JTextField tSaldoFals, tCod, tNome,tEnd_res,tEnd_trab, tJuros, tValor_pag, tPegou_mais, tOutros, tObs_emp;
    JFormattedTextField tData_pag,tData_emp,tTel_res,tTel_res2, tTel_trab, tTel_trab2;
    MaskFormatter mascaraData_pag,mascaraData_emp, mascaraTel, mascaraTel2, mascaraTel3, mascaraTel4;
    RepositorioEmprestimo re;
    RepositorioCliente rc;
    RepositorioConta rco;
    RepositorioCarro rca;
    JTable tabela;
    JScrollPane scroller;
    String  data_ren;
    String  data_dia;
    Calendar data;
    int dia, mes, ano;


    public RelatorioCarro() {

        super("..:: |Relatório de Aluguéis| Controle Financeiro - CRAPS Vs. 3.0 ::..");
        final Container tela = getContentPane();
        tela.setLayout(null);



        carros = new Vector();
        carros.add("");
        carro = new JComboBox(carros);
        consultar = new JButton("|Consultar|");
        sair = new JButton("|Sair|");
        filtrar = new JButton("|Filtrar|");
        limpar = new JButton("|Limpar|");
        carroL = new JLabel("Carros: ");
        credito = new JLabel("Total de Créditos: ");
        debito = new JLabel("Total de Débitos: ");
        saldo = new JLabel("Saldo: ");
        tSaldo = new JLabel();
        tDebito = new JLabel();
        tCredito = new JLabel();


        consultar.setMnemonic(KeyEvent.VK_C);
        sair.setMnemonic(KeyEvent.VK_R);


        limpar.setBounds(850,300,100,20);
        filtrar.setBounds(410,200,100,20);
        consultar.setBounds(500, 80, 100, 20);
        sair.setBounds(600, 80, 100, 20);
        carroL.setBounds(20,200,100,20);
        carro.setBounds(100,200,300,20);
        credito.setBounds(500, 250, 150, 20);
        debito.setBounds(500, 280, 150, 20);
        saldo.setBounds(500, 310, 100, 20);
        tCredito.setBounds(600, 250, 150, 20);
        tDebito.setBounds(600, 280, 150, 20);
        tSaldo.setBounds(600, 310, 150, 20);

 
        tela.add(limpar);
        tela.add(sair);
        tela.add(filtrar);
        tela.add(consultar);
        tela.add(carro);
        tela.add(carroL);
        tela.add(credito);
        tela.add(debito);
        tela.add(saldo);
        tela.add(tCredito);
        tela.add(tDebito);
        tela.add(tSaldo);


   



                data = Calendar.getInstance();
                  dia = data.get(Calendar.DAY_OF_MONTH);
                  mes = data.get(Calendar.MONTH);
                  ano = data.get(Calendar.YEAR);
                  data_dia = +dia+"/"+(mes+1)+"/"+ano;
                  if(dia<10 && mes<10){
                      data_dia = "0"+dia+"/0"+(mes+1)+"/"+ano;
                  }else
                      if(dia<10 && mes >=10 ){
                          data_dia = "0"+dia+"/"+(mes+1)+"/"+ano;
                      }else
                          if(dia>=10 && mes <10){
                              data_dia = dia+"/0"+(mes+1)+"/"+ano;
                          }else
                              data_dia = dia+"/"+(mes+1)+"/"+ano;




        sair.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try{

                tDebito.setText("");
                tCredito.setText("");
                tSaldo.setText("");
                carro.setSelectedIndex(0);
                scroller.setVisible(false);
                tela.remove(scroller);
                carros.removeAllElements();
                carros.add("");
                carro.setSelectedIndex(0);
              }catch(Exception ex){

                tDebito.setText("");
                tCredito.setText("");
                tSaldo.setText("");
                carro.setSelectedIndex(0);
                carros.removeAllElements();
                carros.add("");
                carro.setSelectedIndex(0);


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

       consultar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){

                    try{

                      
                        scroller.setVisible(false);
                        tela.remove(scroller);
                      }catch(Exception ex){
                     

                      }

                rca = new RepositorioCarro();
                tabela = rca.obterTodasTransacoes();

                   if(tabela.getValueAt(0, 0)==null){
                    JOptionPane.showMessageDialog(null, "Registros não encontrados!!!");
                }else{
                scroller = new JScrollPane(tabela, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	            tela.add(scroller);
	            scroller.setBounds(20, 400,1350, 300);
                double somaCred = rca.somarCredito("");
                BigDecimal credito = BigDecimal.valueOf(somaCred);
                String creditoTexto = VerificarUsuario.paraFormatoDinheiro(credito);
                double somaDeb = rca.somarDebito("");
                BigDecimal debito = BigDecimal.valueOf(somaDeb);
                String debitoTexto = VerificarUsuario.paraFormatoDinheiro(debito);
                double saldoDouble = somaCred - somaDeb;
                BigDecimal saldoBig = BigDecimal.valueOf(saldoDouble);
                String saldoTexto = VerificarUsuario.paraFormatoDinheiro(saldoBig);

                tCredito.setText("R$ "+creditoTexto);
                tDebito.setText("R$ "+debitoTexto);
                tSaldo.setText("R$ "+saldoTexto);

                   }
            }

        	}
        );

        filtrar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){



                try{

                tDebito.setText("");
                tCredito.setText("");
                tSaldo.setText("");
                scroller.setVisible(false);
                tela.remove(scroller);
              }catch(Exception ex){

                tDebito.setText("");
                tCredito.setText("");
                tSaldo.setText("");
      


              }

                rca = new RepositorioCarro();
                String modelo = carro.getSelectedItem().toString().substring(1, carro.getSelectedItem().toString().length()-1);
                String placa = rca.pegarPlaca(modelo,"Carros");
                String cod = rca.pegarCodigo(placa);
                
                tabela = rca.filtrar(cod);

                   if(tabela.getValueAt(0, 0)==null){
                    JOptionPane.showMessageDialog(null, "Registros não encontrados!!!");
                }else{
                scroller = new JScrollPane(tabela, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	            tela.add(scroller);
	            scroller.setBounds(20, 400,1350, 300);
                double somaCred = rca.somarCreditoEsp(cod);
                BigDecimal credito = BigDecimal.valueOf(somaCred);
                String creditoTexto = VerificarUsuario.paraFormatoDinheiro(credito);
                double somaDeb = rca.somarDebitoEsp(cod);
                BigDecimal debito = BigDecimal.valueOf(somaDeb);
                String debitoTexto = VerificarUsuario.paraFormatoDinheiro(debito);
                double saldoDouble = somaCred - somaDeb;
                BigDecimal saldoBig = BigDecimal.valueOf(saldoDouble);
                String saldoTexto = VerificarUsuario.paraFormatoDinheiro(saldoBig);

                tCredito.setText("R$ "+creditoTexto);
                tDebito.setText("R$ "+debitoTexto);
                tSaldo.setText("R$ "+saldoTexto);
                }
                   
            }

        	}
        );

        

        limpar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){


              try{

                tDebito.setText("");
                tCredito.setText("");
                tSaldo.setText("");
                carro.setSelectedIndex(0);
                scroller.setVisible(false);
                tela.remove(scroller);
              }catch(Exception ex){

                tDebito.setText("");
                tCredito.setText("");
                tSaldo.setText("");
                carro.setSelectedIndex(0);


              }

        	}
        });




        setExtendedState(MAXIMIZED_BOTH);
        setSize(800, 600);
        setVisible(true);
        setLocationRelativeTo(null);
    }

     public final void carregarCarros(){

      rca = new RepositorioCarro();
      rca.carregarComboTodos();


  }


};