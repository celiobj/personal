


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.Aluguel;
import Classes.ClienteCarro;
import Persistencia.RepositorioAluguel;
import Persistencia.RepositorioCarro;
import Persistencia.RepositorioClienteCarro;
import Persistencia.RepositorioConta;
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
public class AlugarCarro extends JFrame {

    public static Vector carros;
    JComboBox carro, financeiro;
    String contas[]={"Financeiro","Bradesco", "Dinheiro","Locasul","Marquinho", "Priscila","Santander"};
    JButton consultar,alugar,filtrar, limpar, sair;
    JLabel valor, cod, nome_cliente,end_res,end_trab, valor_pag,tel_res,tel_res2, tel_trab,tel_trab2,outros,data_alu,data_pag,data_ent,hora,carroL, diaria;
    JTextField tDiaria,tSaldo,tSaldoFals, tCod, tNome_cliente,tEnd_res,tEnd_trab, tValor_pag, tOutros, total;
    JFormattedTextField tData_alu,tData_pag,tData_ent,tHora,tTel_res,tTel_res2, tTel_trab, tTel_trab2;
    MaskFormatter mascaraData_alu,mascaraData_pag,mascaraData_ent,mascaraHora, mascaraTel, mascaraTel2, mascaraTel3, mascaraTel4;
    JCheckBox reservados;
    RepositorioAluguel ra;
    RepositorioClienteCarro rcc;
    RepositorioConta rco;
    RepositorioCarro rc;
    JTable tabela;
    JScrollPane scroller;
    String  data_dia;
    Calendar data;
    int dia, mes, ano;



    public AlugarCarro() {

        super("..:: |Aluguel de Carro| Controle Financeiro - CRAPS Vs. 3.0 ::..");
        final Container tela = getContentPane();
        tela.setLayout(null);

       
        consultar = new JButton("|Consultar|");
        carros = new Vector();
        carros.add("");
        carro = new JComboBox(carros);
        financeiro = new JComboBox(contas);
        sair = new JButton("|Sair|");
        alugar = new JButton("|Alugar|");
        limpar = new JButton("|Limpar|");
        outros = new JLabel("Outros:");
        valor = new JLabel("Valor: ");
        diaria = new JLabel("Diária: ");
        nome_cliente = new JLabel("Nome: ");
        end_res = new JLabel("End Resid: ");
        end_trab = new JLabel("End Trab: ");
        tel_res = new JLabel("Tel Res: ");
        tel_res2 =  new JLabel("Tel Res2: ");
        tel_trab = new JLabel("Tel Trab: ");
        tel_trab2 = new JLabel("Tel Trab2: ");
        carroL = new JLabel("Carros: ");
        valor_pag = new JLabel("Pagou: ");
        hora = new JLabel("Hora: ");
        data_ent = new JLabel("Entrega em: ");
        data_alu = new JLabel("Pegou em: ");
        data_pag = new JLabel("Pagamento p/: ");
        total = new JTextField(5);
        tDiaria = new JTextField(5);
        tValor_pag = new JTextField(5);
        tSaldo = new JTextField(5);
        tSaldoFals = new JTextField(15);
        tNome_cliente = new JTextField(40);
        tEnd_res = new JTextField(200);
        tEnd_trab = new JTextField(200);
        tOutros = new JTextField(200);
        reservados = new JCheckBox("Reservados");


        try{
                mascaraData_pag = new MaskFormatter("##/##/####");
     	   	mascaraData_alu = new MaskFormatter("##/##/####");
                mascaraData_ent = new MaskFormatter("##/##/####");
                mascaraHora = new MaskFormatter("##:##");
     	   	mascaraTel = new MaskFormatter("####-####");
     	  	mascaraTel2 = new MaskFormatter("####-####");
     	  	mascaraTel3 = new MaskFormatter("####-####");
     	  	mascaraTel4 = new MaskFormatter("####-####");

        	}catch (Exception exp){};

                 tData_pag = new JFormattedTextField(mascaraData_pag);
                 tData_alu = new JFormattedTextField(mascaraData_alu);
                 tData_ent = new JFormattedTextField(mascaraData_ent);
                 tHora = new JFormattedTextField(mascaraHora);
                 tTel_res = new JFormattedTextField(mascaraTel);
                 tTel_res2 = new JFormattedTextField(mascaraTel2);
                 tTel_trab = new JFormattedTextField(mascaraTel3);
                 tTel_trab2 = new JFormattedTextField(mascaraTel4);


          data = Calendar.getInstance();
          dia = data.get(Calendar.DAY_OF_MONTH);
          mes = data.get(Calendar.MONTH);
          ano = data.get(Calendar.YEAR);
          data_dia = dia+"/"+(mes+1)+"/"+ano;


        consultar.setMnemonic(KeyEvent.VK_C);
        sair.setMnemonic(KeyEvent.VK_R);

        alugar.setBounds(40,360,100,20);
        nome_cliente.setBounds(20,110,100,20);
        tNome_cliente.setBounds(60,110,340,20);
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
        data_alu.setBounds(20,240,100,20);
        tData_alu.setBounds(110,240,100,20);
        data_pag.setBounds(20,300,100,20);
        tData_pag.setBounds(110, 300, 100, 20);
        hora.setBounds(220, 240, 100, 20);
        tHora.setBounds(260, 240, 60, 20);
        data_ent.setBounds(20,270,100,20);
        tData_ent.setBounds(110,270,100,20);
        diaria.setBounds(20,300,100,20);
        tDiaria.setBounds(110, 300, 100, 20);
        valor.setBounds(20,330,100,20);
        total.setBounds(110, 330, 100, 20);
        valor_pag.setBounds(320,270,100,20);
        tValor_pag.setBounds(380,270,100,20);
        limpar.setBounds(150,360,100,20);
        carroL.setBounds(20,200,100,20);
        carro.setBounds(100,200,300,20);
        financeiro.setBounds(610,240,130,20);
        consultar.setBounds(500, 80, 100, 20);
        sair.setBounds(600, 80, 100, 20);
        reservados.setBounds(500,110,100,20);

        tela.add(alugar);
        tela.add(valor);
        tela.add(tSaldo);
        tela.add(tSaldoFals);
      
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
      
        //tela.add(tValor_pag);
        //tela.add(valor_pag);
        tela.add(data_alu);
        tela.add(data_ent);
        tela.add(tData_ent);
        tela.add(tData_alu);
        tela.add(data_pag);
        tela.add(tData_pag);
        tela.add(hora);
        tela.add(tHora);
        tela.add(valor);
        //tela.add(diaria);
        //tela.add(tDiaria);
        tela.add(carroL);
        tela.add(carro);
        //tela.add(financeiro);
        tela.add(limpar);
        tela.add(total);
        tela.add(sair);
       // tela.add(consultar);
        tela.add(outros);
        tela.add(tOutros);
        tela.add(reservados);


        total.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tEnd_res.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tEnd_trab.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tTel_res.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tTel_res2.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tTel_trab.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tTel_trab2.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tSaldoFals.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tNome_cliente.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tValor_pag.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tData_ent.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tData_alu.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tData_pag.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tHora.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tOutros.setFont(new Font("Times New Roman", Font.BOLD, 14));


         alugar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if(carro.getSelectedIndex()==0){
                    JOptionPane.showMessageDialog(null, "Escolha um Carro!!!");
                }else
                {
                    
                    String dataPeg = tData_alu.getText();
                    String dataPag = tData_pag.getText();
                    String dataEnt = tData_ent.getText();
                    String hora = tHora.getText();
                    String nome = tNome_cliente.getText();

                if(dataPeg.equals("  /  /    ")||dataEnt.equals("  /  /    ")||dataPag.equals("  /  /    ")||hora.equals("  :  ")||nome.equals("")){
                    JOptionPane.showMessageDialog(null, "Preencha corretamento os campos de NOME, DATA e HORA!!!");
                }else
                {

            int resposta;
             resposta=JOptionPane.showConfirmDialog(null,"Deseja realmente alugar esse veículo?","Confirmação",JOptionPane.YES_NO_OPTION);
             if(resposta==0){
                ra = new RepositorioAluguel();
                rc = new RepositorioCarro();
                rcc = new RepositorioClienteCarro();

                ClienteCarro cli = new ClienteCarro();
                Aluguel alu = new Aluguel();
                String placa = "";
                
                if(reservados.isSelected()==true){
                    
                
                  placa  = rc.pegarPlaca(carro.getSelectedItem().toString().substring(1, carro.getSelectedItem().toString().length()-11),"Reservados");
                    
                }else
                    if(reservados.isSelected()==false){
                        
                     
                      placa = rc.pegarPlaca(carro.getSelectedItem().toString().substring(1, carro.getSelectedItem().toString().length()-11),"Livres");
                        
                    }


               
                alu.setCod_aluguel(""+ra.gerarCodigo()+"");
                alu.setPlaca(placa);
                alu.setModelo(carro.getSelectedItem().toString().substring(1, carro.getSelectedItem().toString().length()-11));
                alu.setValor(VerificarUsuario.formatoParaInserir(total.getText()));
                alu.setNome(tNome_cliente.getText());
                alu.setHora(tHora.getText());
                alu.setData(data_dia);
                alu.setData_ent(tData_ent.getText());
                alu.setData_peg(tData_alu.getText());
                alu.setData_pag(tData_pag.getText());
                alu.setStatus("Alugado - Pagamento agendado para: "+tData_pag.getText()+" às "+tHora.getText()+".");
                               

                cli.setCod_cliente(alu.getCod_aluguel());
                cli.setNome(tNome_cliente.getText());
                cli.setEnd_res(tEnd_res.getText());
                cli.setEnd_trab(tEnd_trab.getText());
                cli.setTel_res(tTel_res.getText());
                cli.setTel_res2(tTel_res2.getText());
                cli.setTel_trab(tTel_trab.getText());
                cli.setTel_trab2(tTel_trab2.getText());
                cli.setOutros(tOutros.getText());
             
                if(reservados.isSelected()==true){
                    
                
                    ra.adicionarReservado(alu);
                    rcc.adcionar(cli);
                    
                    
                }else
                    if(reservados.isSelected()==false){
                        
                     
                        ra.adicionar(alu);
                        rcc.adcionar(cli);
                        
                    }
               

                tNome_cliente.setText("");
                tEnd_res.setText("");
                tEnd_trab.setText("");
                tTel_res.setText("");
                tTel_res2.setText("");
                tTel_trab.setText("");
                tTel_trab2.setText("");
                tOutros.setText("");
                tData_alu.setText("");
                tData_ent.setText("");
                tData_pag.setText("");
                tHora.setText("");
                total.setText("");
                carros.removeAllElements();
                carros.add("");
                carro.setSelectedIndex(0);
                reservados.setSelected(false);
                
                carregarCarros("Livres");
                
                }
                }
                }
                    }
            });



      sair.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                tNome_cliente.setText("");
                tEnd_res.setText("");
                tEnd_trab.setText("");
                tTel_res.setText("");
                tTel_res2.setText("");
                tTel_trab.setText("");
                tTel_trab2.setText("");
                tOutros.setText("");
                tData_alu.setText("");
                tData_ent.setText("");
                tData_pag.setText("");
                tHora.setText("");
                total.setText("");
                carros.removeAllElements();
                carros.add("");
                carro.setSelectedIndex(0);
                reservados.setSelected(false);

               

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

       reservados.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){

                    if(reservados.isSelected()==true){
                       
                       carros.removeAllElements();
                       carros.add("");
                       carregarCarros("Reservados");
                    }else
                        
                        if(reservados.isSelected()==false){
                            
                        carros.removeAllElements();
                        carros.add("");
                        carregarCarros("Livres");
                   
                        }
                      }

        	}
        );

       
      

        limpar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){

               tNome_cliente.setText("");
                tEnd_res.setText("");
                tEnd_trab.setText("");
                tTel_res.setText("");
                tTel_res2.setText("");
                tTel_trab.setText("");
                tTel_trab2.setText("");
                tOutros.setText("");
                tData_alu.setText("");
                tData_ent.setText("");
                tData_pag.setText("");
                tHora.setText("");
                total.setText("");
                carro.setSelectedIndex(0);
                reservados.setSelected(false);
                carros.removeAllElements();
                carros.add("");

        	}
        });

       

        setExtendedState(MAXIMIZED_BOTH);
        setSize(800, 600);
        setVisible(true);
        setLocationRelativeTo(null);
    }

  public final void carregarCarros(String onde){

      ra = new RepositorioAluguel();
      ra.filtrarLivres(onde);


  }
  
  
  

};