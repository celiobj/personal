


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.Aluguel;
import Classes.Carro;
import Classes.ClienteCarro;
import Persistencia.RepositorioAluguel;
import Persistencia.RepositorioCarro;
import Persistencia.RepositorioClienteCarro;
import Persistencia.RepositorioConta;
import Persistencia.RepositorioEmprestimo;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author casa
 */
public class RenovarAluguel extends JFrame {

    JComboBox carro, financeiro,acao;
    String tipo[]={"Ação","Abater" ,"Pagar","Renovar","Finalizar"};
    String contas[]={"Financeiro","Bradesco","LocaSul","Priscila","Marquinho", "Santander", "Dinheiro"};
    JButton consultar,gravar,ver_end,filtrar, limpar, sair;
    JLabel as,carro_alug,valor, cod, nome_cliente,end_res,end_trab, valor_pag,tel_res,tel_res2, tel_trab,tel_trab2,outros,data_alu,data_pag,data_ent, total;
    JTextField tSaldo,tSaldoFals, tCod, tNome_cliente,tEnd_res,tEnd_trab, tValor_pag, tOutros, tCarro_alug;
    JFormattedTextField tHora,tData_pag,tData_alu,tData_ent,tTel_res,tTel_res2, tTel_trab, tTel_trab2;
    MaskFormatter mascaraHora,mascaraData_pag,mascaraData_ent,mascaraData_alu, mascaraTel, mascaraTel2, mascaraTel3, mascaraTel4;
    RepositorioAluguel ra;
    RepositorioCarro rc;
    RepositorioClienteCarro rcc;
    RepositorioConta rco;
    RepositorioEmprestimo re;
    JTable tabela;
    JScrollPane scroller;
    String data_hoje;
    Calendar data;
    int dia, mes, ano;


    public RenovarAluguel() {

        super("..:: |Renovar/Finalizar Aluguel de Carro| Controle Financeiro - CRAPS Vs. 3.0 ::..");
        final Container tela = getContentPane();
        tela.setLayout(null);



        consultar = new JButton("|Consultar|");
        acao = new JComboBox(tipo);
        financeiro = new JComboBox(contas);
        filtrar = new JButton("|Filtrar|");
        gravar = new JButton("|Gravar|");
        sair = new JButton("|Sair|");
        ver_end = new JButton("|Detalhes|");
        limpar = new JButton("|Limpar|");
        outros = new JLabel("Outros:");
        valor = new JLabel("Valor: ");
        cod = new JLabel("Código: ");
        nome_cliente = new JLabel("Nome: ");
        end_res = new JLabel("End Resid: ");
        end_trab = new JLabel("End Trab: ");
        tel_res = new JLabel("Tel Res: ");
        tel_res2 =  new JLabel("Tel Res2: ");
        tel_trab = new JLabel("Tel Trab: ");
        tel_trab2 = new JLabel("Tel Trab2: ");
        valor_pag = new JLabel("Pagou: ");
        data_alu = new JLabel("Pegou em: ");
        data_ent = new JLabel("Entrega P/: ");
        data_pag = new JLabel("Pagamento P/: ");
        carro_alug = new JLabel("Carro: ");
        as = new JLabel("às");
        tCarro_alug = new JTextField(30);
        total = new JLabel();
        tValor_pag = new JTextField(5);
        tSaldo = new JTextField(5);
        tSaldoFals = new JTextField(15);
        tCod = new JTextField(5);
        tNome_cliente = new JTextField(40);
        tEnd_res = new JTextField(200);
        tEnd_trab = new JTextField(200);
        tOutros = new JTextField(200);


        try{
                mascaraData_alu = new MaskFormatter("##/##/####");
     	   	mascaraData_pag = new MaskFormatter("##/##/####");
                mascaraData_ent = new MaskFormatter("##/##/####");
     	   	mascaraTel = new MaskFormatter("####-####");
     	  	mascaraTel2 = new MaskFormatter("####-####");
     	  	mascaraTel3 = new MaskFormatter("####-####");
     	  	mascaraTel4 = new MaskFormatter("####-####");
                mascaraHora = new MaskFormatter("##:##");

        	}catch (Exception exp){};

                 tData_alu = new JFormattedTextField(mascaraData_alu);
                 tData_pag = new JFormattedTextField(mascaraData_pag);
                 tData_ent = new JFormattedTextField(mascaraData_ent);
                 tTel_res = new JFormattedTextField(mascaraTel);
                 tTel_res2 = new JFormattedTextField(mascaraTel2);
                 tTel_trab = new JFormattedTextField(mascaraTel3);
                 tTel_trab2 = new JFormattedTextField(mascaraTel4);
                 tHora = new JFormattedTextField(mascaraHora);



                  data = Calendar.getInstance();
                  dia = data.get(Calendar.DAY_OF_MONTH);
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
                          }else
                              data_hoje = dia+"/"+(mes+1)+"/"+ano;


        consultar.setMnemonic(KeyEvent.VK_C);
        sair.setMnemonic(KeyEvent.VK_R);

        cod.setBounds(20,80,50,20);
        tCod.setBounds(80,80,50,20);
        filtrar.setBounds(140,80,100,20);
        nome_cliente.setBounds(20,110,100,20);
        tNome_cliente.setBounds(60,110,340,20);
        ver_end.setBounds(400, 110, 100, 20);
        end_res.setBounds(20,140,100,20);
        tEnd_res.setBounds(100,140,300,20);
        end_trab.setBounds(20,170,100,20);
        tEnd_trab.setBounds(100,170,300,20);
        tel_res.setBounds(420,140,60,20);
        tTel_res.setBounds(480,140,80,20);
        tel_res2.setBounds(570,140,60,20);
        tTel_res2.setBounds(630,140,80,20);
        tel_trab.setBounds(420,170,60,20);
        tTel_trab.setBounds(480,170,80,20);
        tel_trab2.setBounds(570,170,60,20);
        tTel_trab2.setBounds(630,170,80,20);
        outros.setBounds(730,140,80,20);
        tOutros.setBounds(790,140,200,20);
        
       // tSaldoFals.setBounds(20,240,100,20);
        valor_pag.setBounds(220,320,100,20);
        tValor_pag.setBounds(270,320,100,20);
        total.setBounds(780,380,100,20);
        limpar.setBounds(850,300,100,20);
        acao.setBounds(500,240,100,20);
        gravar.setBounds(750, 300, 100, 20);
        carro_alug.setBounds(20, 200, 100, 20);
        tCarro_alug.setBounds(110, 200, 300, 20);
        valor.setBounds(20,230,100,20);
        tSaldo.setBounds(110,230,100,20);
        data_alu.setBounds(20,260,100,20);
        tData_alu.setBounds(110, 260, 100, 20);
        data_pag.setBounds(20,290,100,20);
        data_ent.setBounds(20,350,100,20);
        tData_pag.setBounds(110,290,100,20);
        as.setBounds(220, 350, 20, 20);
        tHora.setBounds(240, 350, 60, 20);
        tData_ent.setBounds(110,350,100,20);
        financeiro.setBounds(610,240,130,20);
        consultar.setBounds(500, 80, 100, 20);
        sair.setBounds(600, 80, 100, 20);

        tela.add(valor);
        tela.add(tSaldo);
        tela.add(gravar);
        //tela.add(ver_end);
        //tela.add(filtrar);
        tela.add(nome_cliente);
        tela.add(tNome_cliente);
        tela.add(end_res);
        tela.add(tEnd_res);
        tela.add(end_trab);
        tela.add(tEnd_trab);
        tela.add(tel_res);
        tela.add(tTel_res);
        tela.add(tel_res2);
        tela.add(tTel_res2);
        tela.add(tel_trab);
        tela.add(tTel_trab);
        tela.add(tel_trab2);
        tela.add(tTel_trab2);
        tela.add(cod);
        tela.add(tCod);
        tela.add(data_alu);
        tela.add(tData_alu);
        tela.add(tValor_pag);
        tela.add(valor_pag);
        tela.add(data_pag);
        tela.add(data_ent);
        tela.add(tData_ent);
        tela.add(tData_pag);
        tela.add(acao);
        tela.add(financeiro);
        tela.add(limpar);
        tela.add(total);
        tela.add(carro_alug);
        tela.add(tCarro_alug);
       // tela.add(scroller);
        tela.add(sair);
        tela.add(consultar);
        tela.add(outros);
        tela.add(tOutros);
        tela.add(as);
        tela.add(tHora);

        
        tCod.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tEnd_res.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tEnd_trab.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tTel_res.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tTel_res2.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tTel_trab.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tTel_trab2.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tSaldoFals.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tNome_cliente.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tValor_pag.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tData_alu.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tData_ent.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tData_pag.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tOutros.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tCarro_alug.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tSaldo.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tHora.setFont(new Font("Times New Roman", Font.BOLD, 14));
        
        tNome_cliente.setEditable(false);
        tEnd_res.setEditable(false);
        tEnd_trab.setEditable(false);
        tTel_res.setEditable(false);
        tTel_res2.setEditable(false);
        tTel_trab.setEditable(false);
        tTel_trab2.setEditable(false);
        tOutros.setEditable(false);
        tCarro_alug.setEditable(false);
        tCod.setEditable(false);
        tSaldo.setEditable(false);
        tData_alu.setEditable(false);
        tData_pag.setEditable(false);
        tData_ent.setEditable(false);
        tHora.setEditable(false);
     
      
        valor_pag.setVisible(false);
        tValor_pag.setVisible(false);
        financeiro.setVisible(false);
      
        
       tCod.addActionListener(new ActionListener() {
           private JTable tabelaAux;
            public void actionPerformed(ActionEvent e) {
                
                if(tCod.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Preencha o campo CÓDIGO!!!");
                }else{
                
                ra = new RepositorioAluguel();
                Aluguel alu = new Aluguel();
                alu = ra.procurar(tCod.getText());
                tabelaAux = ra.filtroProcurar(tCod.getText(), "Alugados");

                if(tabelaAux.getValueAt(0,0)==null){
                        JOptionPane.showMessageDialog(null,"Código não associado a nenhum aluguel aberto\n Procure nos finalizados");
                        tCod.setText("");
                    }else{
                                         
                try{
                tela.remove(scroller);
                }catch(Exception ex){};
                   
                    rcc = new RepositorioClienteCarro();
                    ra = new RepositorioAluguel();
                    Aluguel alu2 = new Aluguel();
                    alu2 = ra.procurar(tCod.getText());
                    
                    ClienteCarro cli = new ClienteCarro();
                    cli = rcc.procurarNome(alu2.getNome());
                    tEnd_res.setText(cli.getEnd_res());
                    tEnd_trab.setText(cli.getEnd_trab());
                    tTel_res.setText(cli.getTel_res());
                    tTel_res2.setText(cli.getTel_res2());
                    tTel_trab.setText(cli.getTel_trab());
                    tTel_trab2.setText(cli.getTel_trab2());
                    tOutros.setText(cli.getOutros());
                
                tabela = ra.filtroProcurar(tCod.getText(),"Aluguel");
	            scroller = new JScrollPane(tabela, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	            tela.add(scroller);
	            scroller.setBounds(20, 400,1400, 300);
                            
                tNome_cliente.setText(alu.getNome());
                tData_alu.setText(alu.getData_peg());
                tData_pag.setText(alu.getData_pag());
                tData_ent.setText(alu.getData_ent());
                tHora.setText(alu.getHora());
                tCarro_alug.setText(alu.getPlaca()+" - "+alu.getModelo());
                double saldo = Double.parseDouble(alu.getValor());
                tSaldo.setText(VerificarUsuario.paraFormatoDinheiro(BigDecimal.valueOf(saldo)));
                tCod.setEditable(false);
                        }
                }
                    }
            });
       
       acao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(acao.getSelectedItem().equals("Pagar")){

                        financeiro.setVisible(true);
                        tData_alu.setEditable(false);
                        tData_ent.setEditable(false);
                        tData_pag.setEditable(false);
                        tHora.setEditable(false);
                        tSaldo.setEditable(false);
                        tValor_pag.setVisible(false);
                               
                    
                       }else
                   if(acao.getSelectedItem().equals("Abater")){

                        
                        financeiro.setVisible(true);
                        tData_alu.setEditable(false);
                        tData_ent.setEditable(false);
                        tData_pag.setEditable(false);
                        tHora.setEditable(false);
                        tValor_pag.setVisible(true);
                               
                    
                       }else                   
                     if(acao.getSelectedItem().equals("Finalizar")){
                         
                          tData_alu.setEditable(false);
                          tData_ent.setEditable(false);
                          tData_pag.setEditable(false);
                          tHora.setEditable(false);
                          tSaldo.setEditable(false);
                          tValor_pag.setVisible(false);
                               
                        
                       financeiro.setVisible(false);
                          
                        }else
                            if(acao.getSelectedItem().equals("Ação")){

                              financeiro.setVisible(false);
                              tData_alu.setEditable(false);
                              tData_ent.setEditable(false);
                              tData_pag.setEditable(false);
                              tHora.setEditable(false);
                              tSaldo.setEditable(false);
                              tValor_pag.setVisible(false);
                               
                            }else
                            if(acao.getSelectedItem().equals("Renovar")){

                               financeiro.setVisible(false);
                               tData_alu.setEditable(true);
                               tData_ent.setEditable(true);
                               tData_pag.setEditable(true);
                               tHora.setEditable(true);
                               tSaldo.setEditable(true);
                               tValor_pag.setVisible(false);
                               
                            }
                                    

                    }
            });

        gravar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {



                String dial = data_hoje.substring(0,2);
                String mesl = data_hoje.substring(3,5);
                String anol = data_hoje.substring(6,10);
                String dataForm = mesl+"/"+dial+"/"+anol;
                String onde;
                String textoAcao = acao.getSelectedItem().toString();
                String textoFinanceiro = financeiro.getSelectedItem().toString();
                if(textoAcao.equals("Ação")){

                    JOptionPane.showMessageDialog(null,"Preencha corretamente o campo AÇÃO !!!");

                }else{

                   if(textoAcao.equals("Pagar")){

                       if(textoFinanceiro.equals("Financeiro")){

                    JOptionPane.showMessageDialog(null,"Preencha corretamente o campo FINANCEIRO!!!");

                }else{
                            if(textoFinanceiro.equals("Marquinho")){
                      onde = "BcoBrasil";
                    }else
                        if(textoFinanceiro.equals("Santander")){
                            onde = "BcoReal";
                        }else
                            if(textoFinanceiro.equals("Priscila")){
                                onde = "Pris";
                            }else
                                if(textoFinanceiro.equals("LocaSul")){
                                    onde = "Locasul";
                                }else
                                    if(textoFinanceiro.equals("Bradesco")){
                                        onde = "BcoBrad";
                                    }else
                                            onde = "Dinheiro";
                            
                        ra = new RepositorioAluguel();
                        rc = new RepositorioCarro();
                        rco = new RepositorioConta();

                        String placa = tCarro_alug.getText().substring(0,8);
                        String modelo = tCarro_alug.getText().substring(11,tCarro_alug.getText().length());
                        String cod_carro = rc.pegarCodigo(placa);

                        String saldoTexto = ra.pegarSaldo(tCod.getText());
                        //JOptionPane.showMessageDialog(null,tSaldo.getText());
                        String valorPagoTexto = VerificarUsuario.formatoParaInserir(tSaldo.getText());
                        //double saldo = Double.parseDouble(saldoTexto);
                        //double valorPago = Double.parseDouble(valorPagoTexto);
                        //double novoSaldo = saldo - valorPago;
                        //String novoSaldoTexto = ""+novoSaldo+"";
                        Aluguel alu = new Aluguel();
                        alu = ra.procurar(tCod.getText());
                        alu.setData(data_hoje);  
                        alu.setData_ent(tData_ent.getText());
                        alu.setData_pag(tData_pag.getText());
                        alu.setData_peg(tData_alu.getText());
                        String novoSaldoTexto = "0";
                        //JOptionPane.showMessageDialog(null,saldoTexto);
                        ra.pagar(alu, tCod.getText(), novoSaldoTexto, data_hoje,saldoTexto, textoFinanceiro, tSaldo.getText());
                        
                        rc.transacao(cod_carro, placa, modelo, "Credito", "Pagamento do Aluguel nº "+tCod.getText(),saldoTexto , data_hoje);
                        rco.receber("Receber",saldoTexto,onde, "Pagamento do aluguel do "+modelo+" - "+placa, dataForm);
                       }

                    }else
                        if(textoAcao.equals("Finalizar")){

                             ra = new RepositorioAluguel();
                             rc = new RepositorioCarro();
                             rco = new RepositorioConta();

                             String placa = tCarro_alug.getText().substring(0,8);
                             String modelo = tCarro_alug.getText().substring(11,tCarro_alug.getText().length());
                             String cod_carro = rc.pegarCodigo(placa);
                             Carro car = new Carro();
                             Aluguel alu = new Aluguel();
                             alu = ra.procurar(tCod.getText());
                            
                             alu.setData(data_hoje);  
                             alu.setData_ent(tData_ent.getText());
                             alu.setData_pag(tData_pag.getText());
                             alu.setData_peg(tData_alu.getText());
                            
                             
                             if(tSaldo.getText().equals("0,00")){
                                
                                 car = rc.procurar(cod_carro);
                                 ra.finalizar(alu,tCod.getText(), car);
                             }else{
                                 JOptionPane.showMessageDialog(null, "O Aluguel não pode ser finalizado se ainda existir valor a ser pago. \n Receba o pagamento antes de finalizá-lo !!!");
                             }
                        

                            // rc.transacao(cod_carro, placa, modelo, "Credito", "Pagamento do Aluguel nº "+tCod.getText(),tSaldo.getText() , data_hoje);

                           //  rco.receber("Receber",VerificarUsuario.formatoParaInserir(tSaldo.getText()),onde, "Pagamento do aluguel do "+modelo+" - "+placa, dataForm);


                      
                        }else
                            if(textoAcao.equals("Abater")){

                                       if(textoFinanceiro.equals("Financeiro")){

                                    JOptionPane.showMessageDialog(null,"Preencha corretamente o campo FINANCEIRO!!!");

                                }else{
                                            if(textoFinanceiro.equals("Marquinho")){
                                      onde = "BcoBrasil";
                                    }else
                                        if(textoFinanceiro.equals("Santander")){
                                            onde = "BcoReal";
                                        }else
                                            if(textoFinanceiro.equals("Priscila")){
                                                onde = "Pris";
                                            }else
                                                if(textoFinanceiro.equals("LocaSul")){
                                                    onde = "Locasul";
                                                }else
                                                    if(textoFinanceiro.equals("Bradesco")){
                                                        onde = "BcoBrad";
                                                    }else
                                                            onde = "Dinheiro";

                                        ra = new RepositorioAluguel();
                                        rc = new RepositorioCarro();
                                        rco = new RepositorioConta();

                                        String placa = tCarro_alug.getText().substring(0,8);
                                        String modelo = tCarro_alug.getText().substring(11,tCarro_alug.getText().length());
                                        String cod_carro = rc.pegarCodigo(placa);

                                        String saldoTexto = ra.pegarSaldo(tCod.getText());
                                        String valorPagoInserir = VerificarUsuario.formatoParaInserir(tValor_pag.getText());
                                        String valorPagoTexto = VerificarUsuario.formatoParaInserir(tValor_pag.getText());
                                        double saldo = Double.parseDouble(saldoTexto);
                                        double valorPago = Double.parseDouble(valorPagoTexto);
                                        double novoSaldo = saldo - valorPago;
                                        String novoSaldoTexto = ""+novoSaldo+"";
                                        Aluguel alu = new Aluguel();
                                        alu = ra.procurar(tCod.getText());
                                        alu.setData(data_hoje);  
                                        alu.setData_ent(tData_ent.getText());
                                        alu.setData_pag(tData_pag.getText());
                                        alu.setData_peg(tData_alu.getText());
                                        //String novoSaldoTexto = "0";
                                        //JOptionPane.showMessageDialog(null,saldoTexto);
                                        ra.abater(alu, tCod.getText(), novoSaldoTexto, data_hoje,saldoTexto, textoFinanceiro, tValor_pag.getText());

                                        rc.transacao(cod_carro, placa, modelo, "Credito", "Abatimento do Aluguel nº "+tCod.getText(),valorPagoTexto , data_hoje);
                                        rco.receber("Receber",valorPagoInserir,onde, "Abatimento do aluguel do "+modelo+" - "+placa, dataForm);
                                       }

                    }else
                        if(textoAcao.equals("Renovar")){
                             
                             
                                             
                             ra = new RepositorioAluguel();
                             rc = new RepositorioCarro();
                             rco = new RepositorioConta();

                             String placa = tCarro_alug.getText().substring(0,8);
                             String modelo = tCarro_alug.getText().substring(11,tCarro_alug.getText().length());
                             String cod_carro = rc.pegarCodigo(placa);
                             Carro car = new Carro();
                             car = rc.procurar(cod_carro);
                             Aluguel alu = new Aluguel();
                             alu = ra.procurar(tCod.getText());
                             alu.setValor(VerificarUsuario.formatoParaInserir(tSaldo.getText()));
                             alu.setHora(tHora.getText());
                             alu.setData(data_hoje);
                             alu.setData_ent(tData_ent.getText());
                             alu.setData_pag(tData_pag.getText());
                             alu.setData_peg(tData_alu.getText());
                             alu.setStatus("Alugado - Renovado");
                             //JOptionPane.showMessageDialog(null, alu.getData());
                             ra.renovar(alu);
                             
                            // rc.transacao(cod_carro, placa, modelo, "Credito", "Pagamento do Aluguel nº "+tCod.getText(),tSaldo.getText() , data_hoje);

                           //  rco.receber("Receber",VerificarUsuario.formatoParaInserir(tSaldo.getText()),onde, "Pagamento do aluguel do "+modelo+" - "+placa, dataForm);


                            
                            
                      
                        }
                      try{

                acao.setSelectedIndex(0);
                financeiro.setSelectedIndex(0);
                tCod.setText("");
                tEnd_res.setText("");
                tEnd_trab.setText("");
                tTel_res.setText("");
                tTel_res2.setText("");
                tTel_trab.setText("");
                tTel_trab2.setText("");
                tSaldoFals.setText("");
                tNome_cliente.setText("");
                tValor_pag.setText("");
                tData_alu.setText("");
                tData_ent.setText("");
                tData_pag.setText("");
                tOutros.setText("");
                tCarro_alug.setText("");
                tSaldo.setText("");
                tHora.setText("");
                scroller.setVisible(false);
                tela.remove(scroller);
              }catch(Exception ex){

                acao.setSelectedIndex(0);
                financeiro.setSelectedIndex(0);
                tCod.setText("");
                tEnd_res.setText("");
                tEnd_trab.setText("");
                tTel_res.setText("");
                tTel_res2.setText("");
                tTel_trab.setText("");
                tTel_trab2.setText("");
                tSaldoFals.setText("");
                tNome_cliente.setText("");
                tValor_pag.setText("");
                tData_alu.setText("");
                tData_ent.setText("");
                tData_pag.setText("");
                tOutros.setText("");
                tCarro_alug.setText("");
                tSaldo.setText("");
                tHora.setText("");


              }

                }
                


                    }
            });

     


        sair.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                 try{

                acao.setSelectedIndex(0);
                financeiro.setSelectedIndex(0);
                tCod.setText("");
                tEnd_res.setText("");
                tEnd_trab.setText("");
                tTel_res.setText("");
                tTel_res2.setText("");
                tTel_trab.setText("");
                tTel_trab2.setText("");
                tSaldoFals.setText("");
                tNome_cliente.setText("");
                tValor_pag.setText("");
                tData_alu.setText("");
                tData_ent.setText("");
                tData_pag.setText("");
                tOutros.setText("");
                tCarro_alug.setText("");
                tSaldo.setText("");
                tHora.setText("");
                scroller.setVisible(false);
                tela.remove(scroller);
              }catch(Exception ex){

                acao.setSelectedIndex(0);
                financeiro.setSelectedIndex(0);
                tCod.setText("");
                tEnd_res.setText("");
                tEnd_trab.setText("");
                tTel_res.setText("");
                tTel_res2.setText("");
                tTel_trab.setText("");
                tTel_trab2.setText("");
                tSaldoFals.setText("");
                tNome_cliente.setText("");
                tValor_pag.setText("");
                tData_alu.setText("");
                tData_ent.setText("");
                tData_pag.setText("");
                tOutros.setText("");
                tCarro_alug.setText("");
                tSaldo.setText("");
                tHora.setText("");


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
                    
                   
                    tCod.setText("");
                    tEnd_res.setText("");
                    tEnd_trab.setText("");
                    tTel_res.setText("");
                    tTel_res2.setText("");
                    tTel_trab.setText("");
                    tTel_trab2.setText("");
                    tSaldoFals.setText("");
                    tNome_cliente.setText("");
                    tValor_pag.setText("");
                    tData_alu.setText("");
                    tData_ent.setText("");
                    tData_pag.setText("");
                    tOutros.setText("");
                    tCarro_alug.setText("");
                    tSaldo.setText("");
                    tHora.setText("");
                    ra = new RepositorioAluguel();
                    tabela = ra.procurarAlugados();
                   if(tabela.getValueAt(0, 0)==null){
                    JOptionPane.showMessageDialog(null, "Registros não encontrados!!!");
                }else{
                    
                    tCod.setText("");
                    tEnd_res.setText("");
                    tEnd_trab.setText("");
                    tTel_res.setText("");
                    tTel_res2.setText("");
                    tTel_trab.setText("");
                    tTel_trab2.setText("");
                    tSaldoFals.setText("");
                    tNome_cliente.setText("");
                    tValor_pag.setText("");
                    tData_alu.setText("");
                    tData_ent.setText("");
                    tData_pag.setText("");
                    tOutros.setText("");
                    tCarro_alug.setText("");
                    tSaldo.setText("");
                    tHora.setText("");
                    scroller = new JScrollPane(tabela, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	            tela.add(scroller);
	            scroller.setBounds(20, 400,1400, 300);
                    tCod.setEditable(true);


                      }
                   }
        	}
        );




        limpar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){

               
              try{

                tCod.setEditable(false);
                acao.setSelectedIndex(0);
                financeiro.setSelectedIndex(0);
                tCod.setText("");
                tEnd_res.setText("");
                tEnd_trab.setText("");
                tTel_res.setText("");
                tTel_res2.setText("");
                tTel_trab.setText("");
                tTel_trab2.setText("");
                tSaldoFals.setText("");
                tNome_cliente.setText("");
                tValor_pag.setText("");
                tData_alu.setText("");
                tData_ent.setText("");
                tData_pag.setText("");
                tOutros.setText("");
                tCarro_alug.setText("");
                tSaldo.setText("");
                tHora.setText("");
                scroller.setVisible(false);
                tela.remove(scroller);
              }catch(Exception ex){

                tCod.setEditable(false);
                acao.setSelectedIndex(0);
                financeiro.setSelectedIndex(0);
                tCod.setText("");
                tEnd_res.setText("");
                tEnd_trab.setText("");
                tTel_res.setText("");
                tTel_res2.setText("");
                tTel_trab.setText("");
                tTel_trab2.setText("");
                tSaldoFals.setText("");
                tNome_cliente.setText("");
                tValor_pag.setText("");
                tData_alu.setText("");
                tData_ent.setText("");
                tData_pag.setText("");
                tOutros.setText("");
                tCarro_alug.setText("");
                tSaldo.setText("");
                tHora.setText("");


              }

        	}
        });


        setExtendedState(MAXIMIZED_BOTH);
        setSize(800, 600);
        setVisible(true);
        setLocationRelativeTo(null);
    }
 
};