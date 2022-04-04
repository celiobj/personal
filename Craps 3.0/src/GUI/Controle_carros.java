


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.Carro;
import Classes.Cliente;
import DAO.AccessDatabase;
import Persistencia.RepositorioCarro;
import Persistencia.RepositorioCliente;
import Persistencia.RepositorioConta;
import Persistencia.RepositorioEmprestimo;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author casa
 */
public class Controle_carros extends JFrame {

    public static Vector carros;
    JComboBox acao,fonte, carro;
    String tipo[]={"Ação","Crédito","Débito"};
    String contas[]={"Financeiro","Bradesco","LocaSul","Priscila","Marquinho", "Santander", "Dinheiro"};
    JButton saldo,consultar, ver_end,finalizar, renovar,filtrar, limpar, sair;
    JLabel valor, carroL,cod, nome,end_res,end_trab, juros, valor_pag,tel_res,tel_res2, tel_trab,tel_trab2,outros, data_pag,data_emp, pegou_mais, total, obs_emp;
    JTextField tSaldo,tSaldoFals, tCod, tNome,tEnd_res,tEnd_trab, tJuros, tValor_pag, tPegou_mais, tOutros, tObs_emp;
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
    Cliente cli;
    int dia, mes, ano;


    public Controle_carros() {

        super("..:: |Débitos e Créditos com os carros| Controle Financeiro - CRAPS Vs. 3.0 ::..");
        final Container tela = getContentPane();
        tela.setLayout(null);



        carros = new Vector();
        carros.add("");
        carro = new JComboBox(carros);
        consultar = new JButton("|Consultar|");
        acao = new JComboBox(tipo);
        fonte = new JComboBox(contas);
     
        saldo = new JButton("|Saldo|");
  
        sair = new JButton("|Sair|");
        renovar = new JButton("|Gravar|");
        obs_emp = new JLabel("Observação: ");
        tObs_emp = new JTextField(250);
        limpar = new JButton("|Limpar|");
        valor_pag = new JLabel("Valor: ");
        carroL = new JLabel("Carros: ");
        tValor_pag = new JTextField(5);
     

        consultar.setMnemonic(KeyEvent.VK_C);
        sair.setMnemonic(KeyEvent.VK_R);

      
        valor_pag.setBounds(350,170,100,20);
        tValor_pag.setBounds(410,170,100,20);
        obs_emp.setBounds(665,200,100,20);
        tObs_emp.setBounds(745,200,250,20);
        renovar.setBounds(750,300,100,20);
        limpar.setBounds(850,300,100,20);
        acao.setBounds(410,200,100,20);
        fonte.setBounds(520,200,130,20);
        consultar.setBounds(500, 80, 100, 20);
        sair.setBounds(950, 300, 100, 20);
        carroL.setBounds(20,200,100,20);
        carro.setBounds(100,200,300,20);

        tela.add(obs_emp);
        tela.add(tObs_emp);
        tela.add(tValor_pag);
        tela.add(valor_pag);
        tela.add(acao);
        tela.add(fonte);
        tela.add(renovar);
        tela.add(limpar);
        tela.add(sair);
       // tela.add(consultar);
        tela.add(carro);
        tela.add(carroL);


      
        tValor_pag.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tObs_emp.setFont(new Font("Times New Roman", Font.BOLD, 14));

    

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

                    acao.setSelectedIndex(0);
                    fonte.setSelectedIndex(0);
                    carros.removeAllElements();
                    carros.add("");
                    tValor_pag.setText("");
                    tObs_emp.setText("");
                    scroller.setVisible(false);
                    tela.remove(scroller);
              }catch(Exception ex){

                   acao.setSelectedIndex(0);
                   fonte.setSelectedIndex(0);
                   carros.removeAllElements();
                   carros.add(""); 
                   tValor_pag.setText("");
                   tObs_emp.setText("");
                

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

                    acao.setSelectedIndex(0);
                    fonte.setSelectedIndex(0);
                   // tValor_pag.setText("");
                    tObs_emp.setText("");
                    scroller.setVisible(false);
                    tela.remove(scroller);
              }catch(Exception ex){

                   acao.setSelectedIndex(0);
                   fonte.setSelectedIndex(0);
                 //  tValor_pag.setText("");
                   tObs_emp.setText("");
                }
                       
                       JasperPrint rel = null;
              try{

        	AccessDatabase a = new AccessDatabase();
        	Connection con = a.conectar();
                HashMap map = new HashMap();
                Statement st = con.createStatement();
                rc = new RepositorioCliente();
                String query = "SELECT * FROM Clientes WHERE cod_cliente = "+cli.getCod_cliente()+"";
		ResultSet rs = st.executeQuery( query );
                JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
                String arquivoJasper = "relatorio/clientes.jasper";
                rel = JasperFillManager.fillReport(arquivoJasper, map, jrRS);
                JasperViewer.viewReport(rel, false);
                con.close();

        			}catch(Exception t){
        				System.out.println(t.getMessage());
      			}
                      
              /*
               //gerando o jasper design
	
            
                       //JasperDesign desenho = JRXmlLoader.load( "cliente.jrxml" );
   
		//compila o relatório
		//JasperReport relatorio = JasperCompileManager.compileReport( desenho );
                  
		//estabelece conexão
		try{
                AccessDatabase a = new AccessDatabase();
        	Connection con = a.conectar();
                HashMap map = new HashMap();
                Statement st = con.createStatement();
		String query = "select * from Clientes";
		ResultSet rs = st.executeQuery( query );
                con.close();
               
		//implementação da interface JRDataSource para DataSource ResultSet
		JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
                
		//executa o relatório
                //JasperDesign desenho = JRXmlLoader.load( "clientes.jasper" );
                JasperDesign desenho = JRXmlLoader.load( "clientes.jrxml" );
                JasperReport relatorio = JasperCompileManager.compileReport( desenho );
		Map parametros = new HashMap();
		parametros.put("nome", new Double(10));
		JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros,    jrRS );
   
                 
		//exibe o resultado
		JasperViewer viewer = new JasperViewer( impressao , true );
		viewer.show();
                
                
                }catch( Exception e3){
                     JOptionPane.showMessageDialog(null,e3);
                 }  
                
                 
                       
                        
                       
                       
             
              JasperPrint rel = null;
              try{

        	AccessDatabase a = new AccessDatabase();
        	Connection con = a.conectar();
                HashMap map = new HashMap();
                Statement st = con.createStatement();
        	String arquivoJasper = "relatorio/clientes.jasper";
		rel = JasperFillManager.fillReport(arquivoJasper, map, con);
                JasperViewer.viewReport(rel, false);
                con.close();

        			}catch(Exception t){
        				System.out.println(t.getMessage());
      			}
                   
              /* 
                re = new RepositorioEmprestimo();
                tabela = re.procurarAbertos();

                   if(tabela.getValueAt(0, 0)==null){
                    JOptionPane.showMessageDialog(null, "Registros não encontrados!!!");
                }else{
                scroller = new JScrollPane(tabela, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	            tela.add(scroller);
	            scroller.setBounds(20, 400,1000, 300);
                double somaDoub = re.somarProcurarAbertos();
                BigDecimal soma = BigDecimal.valueOf(somaDoub);
                String valor = paraFormatoDinheiro(soma);
                total.setText("R$ "+valor);
                total.setVisible(false);

                tCod.setEditable(true);
              


                }*/
            }

        	}
        );
       

        renovar.addActionListener(new ActionListener(){

        	public void actionPerformed(ActionEvent e){

                 String dial = data_dia.substring(0,2);
                 String mesl = data_dia.substring(3,5);
                 String anol = data_dia.substring(6,10);
                 String dataForm = mesl+"/"+dial+"/"+anol;
                 String acaoTexto = acao.getSelectedItem().toString();
                 String financeiroTexto = fonte.getSelectedItem().toString();
                 String onde = null;
                 String placa = carro.getSelectedItem().toString().substring(1, carro.getSelectedItem().toString().length()-1);
         
                 if(tValor_pag.getText().equals("")){
                     JOptionPane.showMessageDialog(null, "Preencha os campos Valor !!!");
                 }else
                 {
                 if(acaoTexto.equals("Ação")||financeiroTexto.equals("Financeiro")){

                     JOptionPane.showMessageDialog(null, "Preencha Corretamente os Campos AÇÃO e FINANCEIRO!!!");
                 }else
                     if(financeiroTexto.equals("Marquinho")){
                      onde = "BcoBrasil";
                    }else
                        if(financeiroTexto.equals("Santander")){
                            onde = "BcoReal";
                        }else
                            if(financeiroTexto.equals("Bradesco")){
                                onde = "BcoBrad";
                            }else
                                if(financeiroTexto.equals("LocaSul")){
                                    onde = "Locasul";
                                }else
                                    if(financeiroTexto.equals("Priscila")){
                                        onde = "Pris";
                                    }
                        else
                            onde = "Dinheiro";
                     if(acaoTexto.equals("Crédito")){

                         rca = new RepositorioCarro();
                         rco = new RepositorioConta();
                         Carro car = new Carro();
                         String codigo = rca.pegarCodigo(placa);
                         car = rca.procurar(codigo);

                         rca.transacao(codigo, placa, car.getModelo(), "Credito", tObs_emp.getText()+" - "+car.getModelo()+" - "+car.getPlaca(), VerificarUsuario.formatoParaInserir(tValor_pag.getText()), data_dia);
                         rco.receber("Receber", VerificarUsuario.formatoParaInserir(tValor_pag.getText()), onde, tObs_emp.getText()+" - "+car.getModelo()+" - "+car.getPlaca(), dataForm);
                     }
                     else{
                       //JOptionPane.showMessageDialog(null,"Caiu aqui");
                         rca = new RepositorioCarro();
                         rco = new RepositorioConta();
                         Carro car = new Carro();
                         String codigo = rca.pegarCodigo(placa);
                         car = rca.procurar(codigo);
                         rca.transacao(codigo, placa, car.getModelo(), "Debito", tObs_emp.getText()+" - "+car.getModelo()+" - "+car.getPlaca(), VerificarUsuario.formatoParaInserir(tValor_pag.getText()), data_dia);
                         rco.emprestar("Gastou", VerificarUsuario.formatoParaInserir(tValor_pag.getText()), onde, tObs_emp.getText()+" - "+car.getModelo()+" - "+car.getPlaca(), data_dia);

                     }

                  try{
                    carro.setSelectedIndex(0);
                    acao.setSelectedIndex(0);
                    fonte.setSelectedIndex(0);
                    carros.removeAllElements();
                    carros.add("");
                    tValor_pag.setText("");
                    tObs_emp.setText("");
                    scroller.setVisible(false);
                    tela.remove(scroller);
              }catch(Exception ex){

                   carro.setSelectedIndex(0);
                   acao.setSelectedIndex(0);
                   fonte.setSelectedIndex(0);
                   carros.removeAllElements();
                   carros.add("");
                   tValor_pag.setText("");
                   tObs_emp.setText("");


              }
                }

                 
            }
        });

        limpar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){

            try{
                    carro.setSelectedIndex(0);
                    acao.setSelectedIndex(0);
                    fonte.setSelectedIndex(0);
                    carros.removeAllElements();
                    carros.add("");
                    tValor_pag.setText("");
                    tObs_emp.setText("");
                    scroller.setVisible(false);
                    tela.remove(scroller);
              }catch(Exception ex){

                   carro.setSelectedIndex(0);
                   acao.setSelectedIndex(0);
                   fonte.setSelectedIndex(0);
                   carros.removeAllElements();
                   carros.add("");
                   tValor_pag.setText("");
                   tObs_emp.setText("");


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
      rca.carregarCombo();


  }
     
};