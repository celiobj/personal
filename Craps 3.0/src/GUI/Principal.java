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
import Persistencia.RepositorioConta;
import Persistencia.RepositorioEmprestimo;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.Calendar;


/**
 *
 * @author celio
 */
public class Principal extends JFrame {


    JFormattedTextField tData_ini,tData_fim;
    JTextField tNome;
    MaskFormatter mascaraData_ini,mascaraData_fim;
    JLabel a, valorTotal, saldoBra, saldoRe, saldoDin,saldoBr, saldoPri, saldoLocasul, saldoContas;;
    JButton consultar, limpar,saldo;
    JMenuBar menu;
    JMenu acoes, cliente,listarTodos,carros,financeiro, sair;
    JMenuItem realizar,alterar,controle,resgatar,finalizar, sair2, porNome, todos,mar,bcoBrad,locaSul,Pris,bcoSanta,dinheiro, cadCli, lucro, alugar, cadastro,reservar,renov_alug, despesas, relatorio;
    JTable tabela;
    JScrollPane scroller;
    Calendar data;
    int dia, mes, ano;
    RepositorioEmprestimo re;
    RepositorioConta rc;
    String data_hoje;



    

       public Principal() {

            super("..:: Controle Financeiro - CRAPS Vs. 3.0 ::..");
            final Container tela = getContentPane();
            tela.setLayout(null);


            menu = new JMenuBar();
            setJMenuBar(menu);
            acoes = new JMenu("Ações");
            carros = new JMenu("Carros");
            saldo = new JButton("|Saldo Total das Contas|");
           // listarTodos = new JMenu("Listar Todos");
            financeiro = new JMenu("Financeiro");
           // cliente = new JMenu("Clientes");
            sair = new JMenu("Sair");
            realizar = new JMenuItem("|Realizar Empréstimo|");
            alterar = new JMenuItem("|Alterar Empréstimo|");
            finalizar = new JMenuItem("|Finalizar Empréstimo|");
            controle = new JMenuItem("|Controle|");
            resgatar = new JMenuItem("|Resgatar|");
            cadastro = new JMenuItem("|Cadastro|");
            alugar = new JMenuItem("|Alugar|");
            reservar = new JMenuItem("|Reservar|");
            renov_alug = new JMenuItem("|Renovar/Finalizar|");
            despesas = new JMenuItem("|Despesas|");
            relatorio = new JMenuItem("|Relatório|");

            //porNome = new JMenuItem("|Por Nome|");
           // todos = new JMenuItem("|Todos|");
           // cadCli = new JMenuItem("|Cadastro de Clientes|");
            mar = new JMenuItem("|Marquinho|");
            bcoBrad = new JMenuItem("|Bradesco|");
            locaSul = new JMenuItem("|LocaSul|");
            Pris = new JMenuItem("|Priscila|");
            bcoSanta = new JMenuItem("|Santander|");
            dinheiro = new JMenuItem("|Dinheiro|");
            lucro = new JMenuItem("|Lucro|");
            sair2 = new JMenuItem("|Sair|");
            tNome = new JTextField("");
            a = new JLabel("A");
            valorTotal = new JLabel("");
            saldoContas = new JLabel("");
            saldoBra = new JLabel("");
            saldoRe = new JLabel("");
            saldoBr = new JLabel("");
            saldoPri = new JLabel("");
            saldoLocasul = new JLabel("");
            saldoDin = new JLabel("");
            consultar = new JButton("|Consultar|");
            limpar = new JButton("|Limpar|");
         
           
          
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
                  

            try{
        	 mascaraData_ini = new MaskFormatter("##/##/####");
                mascaraData_fim = new MaskFormatter("##/##/####");
            	}catch (Exception exp){};
                    tData_ini = new JFormattedTextField(mascaraData_ini);
                    tData_fim = new JFormattedTextField(mascaraData_fim);



            tData_ini.setFont(new Font("Times New Roman", Font.BOLD, 14));
            tData_fim.setFont(new Font("Times New Roman", Font.BOLD, 14));
            a.setBounds(640, 110, 10,20);
            saldo.setBounds(760,20,180,20);
            valorTotal.setBounds(20,110,600,20);
            tData_ini.setBounds(550,110,80,20);
            saldoBra.setBounds(1000,20,300,20);
            saldoRe.setBounds(1000,40,300,20);
            saldoDin.setBounds(1000,60,300,20);
            saldoBr.setBounds(1000,80,300,20);
            saldoLocasul.setBounds(1000,120,300,20);
            saldoPri.setBounds(1000,100,300,20);
            saldoContas.setBounds(1000,140,300,20);

            tData_fim.setBounds(660,110,80,20);
            consultar.setBounds(780,110,110,20);
            limpar.setBounds(780,150,110,20);

            tela.add(valorTotal);
            tela.add(limpar);
            tela.add(consultar);
            tela.add(saldoBra);
            tela.add(saldoRe);
            tela.add(saldoDin);
            tela.add(saldoBr);
            tela.add(saldoPri);
            tela.add(saldoLocasul);
            tela.add(saldoContas);
            tela.add(saldo);
            tela.add(a);
            tela.add(tData_fim);
            tela.add(tData_ini);

            valorTotal.setVisible(false);
           
          

            menu.add(acoes);
            menu.add(carros);
            //menu.add(listarTodos);
            menu.add(financeiro);
            //menu.add(cliente);
            menu.add(sair);
            acoes.add(realizar);
            acoes.add(alterar);
            acoes.add(controle);
            acoes.add(resgatar);
            //listarTodos.add(porNome);
            //listarTodos.add(todos);
            carros.add(cadastro);
            carros.add(alugar);
            carros.add(reservar);
            carros.add(renov_alug);
            carros.add(despesas);
            carros.add(relatorio);
            financeiro.add(mar);
            financeiro.add(bcoSanta);
            financeiro.add(dinheiro);
            financeiro.add(bcoBrad);
            financeiro.add(Pris);
            financeiro.add(locaSul);
            financeiro.add(lucro);
            //cliente.add(cadCli);
            sair.add(sair2);



            acoes.setMnemonic(KeyEvent.VK_A);
            sair.setMnemonic(KeyEvent.VK_S);
            sair2.setMnemonic(KeyEvent.VK_R);
            realizar.setMnemonic(KeyEvent.VK_R);
            alterar.setMnemonic(KeyEvent.VK_T);
            controle.setMnemonic(KeyEvent.VK_C);
            resgatar.setMnemonic(KeyEvent.VK_G);
           // porNome.setMnemonic(KeyEvent.VK_P);
          //  todos.setMnemonic(KeyEvent.VK_T);
            finalizar.setMnemonic(KeyEvent.VK_F);

            sair2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                   int resposta;
                    resposta=JOptionPane.showConfirmDialog(null,"Deseja realmente sair?","Confirmação",JOptionPane.YES_NO_OPTION);
                    if (resposta==0)
                    System.exit(0);}});

             

           alterar.addActionListener(new ActionListener() {
                   public void actionPerformed(ActionEvent e) {
                       try{
                        saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                        scroller.setVisible(false);
                        tela.remove(scroller);

                 }catch(Exception ext){

                         saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                 };

              try{
                VerificarUsuario.ae.setVisible(true);
                setVisible(false);
                 }catch(Exception ex){
                    VerificarUsuario.ae = new AlterarEmprestimo();
                    VerificarUsuario.ae.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    setVisible(false);

                         }



                    }
                });
            finalizar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){


                }
            });


            lucro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try{
                        saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                        scroller.setVisible(false);
                        tela.remove(scroller);

                 }catch(Exception ext){
                        saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                 };

              try{
                VerificarUsuario.cl.setVisible(true);
                setVisible(false);
                 }catch(Exception ex){
                    VerificarUsuario.cl = new ConsultarLucro();
                    VerificarUsuario.cl.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    setVisible(false);

              }

                    }
                });

                saldo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                rc = new RepositorioConta();
                double bbDoub = rc.saldo("BcoBrasil");
                double brDoub = rc.saldo("BcoReal");
                double dDoub = rc.saldo("Dinheiro");
                double lDoub = rc.saldo("Locasul");
                double pDoub = rc.saldo("Pris");
                double bDoub = rc.saldo("BcoBrad");
                double totalDoub = bbDoub + brDoub + dDoub + lDoub + pDoub + bDoub ;

                               
                
                BigDecimal bb = BigDecimal.valueOf(bbDoub);
                 //JOptionPane.showMessageDialog(null, bbDoub);
                BigDecimal br = BigDecimal.valueOf(brDoub);
                 //JOptionPane.showMessageDialog(null, brDoub);
                BigDecimal d = BigDecimal.valueOf(dDoub);
                 //JOptionPane.showMessageDialog(null, dDoub);
                BigDecimal l = BigDecimal.valueOf(lDoub);
                 //JOptionPane.showMessageDialog(null, lDoub);
                BigDecimal p = BigDecimal.valueOf(pDoub);
                 //JOptionPane.showMessageDialog(null, pDoub);
                BigDecimal b = BigDecimal.valueOf(bDoub);
                 //JOptionPane.showMessageDialog(null, bDoub);
                BigDecimal total = BigDecimal.valueOf(totalDoub);
                //JOptionPane.showMessageDialog(null, total);

                saldoBra.setText("Saldo do Marquinho: R$ "+VerificarUsuario.paraFormatoDinheiro(bb));
                saldoRe.setText("Saldo do Santander: R$ "+VerificarUsuario.paraFormatoDinheiro(br));
                saldoDin.setText("Saldo em Dinheiro: R$ "+VerificarUsuario.paraFormatoDinheiro(d));
                saldoPri.setText("Saldo em Priscila: R$ "+VerificarUsuario.paraFormatoDinheiro(p));
                saldoLocasul.setText("Saldo em LocaSul: R$ "+VerificarUsuario.paraFormatoDinheiro(l));
                saldoBr.setText("Saldo em Bradesco: R$ "+VerificarUsuario.paraFormatoDinheiro(b));
                saldoContas.setText("Saldo Total: R$ "+VerificarUsuario.paraFormatoDinheiro(total));


                        }
                    });

            realizar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){

                    try{
                        saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                        scroller.setVisible(false);
                        tela.remove(scroller);

                 }catch(Exception ext){

                         saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                 };

              try{
                VerificarUsuario.re.setVisible(true);
                setVisible(false);
                 }catch(Exception ex){
                    VerificarUsuario.re = new RealizarEmprestimo();
                    VerificarUsuario.re.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    setVisible(false);
                   
              }

                }
            });

/*            cadCli.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                  try{
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                        scroller.setVisible(false);
                        tela.remove(scroller);

                 }catch(Exception ext){

                         tData_ini.setText("");
                         tData_fim.setText("");
                         valorTotal.setText("");
                 };

                try{
                VerificarUsuario.cc.setVisible(true);
                setVisible(false);
                }catch(Exception ex){
                    VerificarUsuario.cc = new CadastroCliente();
                    VerificarUsuario.cc.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    setVisible(false);
                }
                }
            });

            porNome.addActionListener(new ActionListener(){
            	public void actionPerformed(ActionEvent e){

                      try{
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                        scroller.setVisible(false);
                        tela.remove(scroller);

                 }catch(Exception ext){

                         tData_ini.setText("");
                         tData_fim.setText("");
                         valorTotal.setText("");
                 };

              try{
                VerificarUsuario.ln.setVisible(true);
                setVisible(false);
              }catch(Exception ex){
                  VerificarUsuario.ln = new ListarNome();
                  VerificarUsuario.ln.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                  setVisible(false);
              }
            	}
            });

            todos.addActionListener(new ActionListener(){
            	public void actionPerformed(ActionEvent e){

                     try{
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                        scroller.setVisible(false);
                        tela.remove(scroller);

                 }catch(Exception ext){

                         tData_ini.setText("");
                         tData_fim.setText("");
                         valorTotal.setText("");
                 };

                    try{
                    VerificarUsuario.lt.setVisible(true);
                    setVisible(false);
                    }catch(Exception ex){
                        VerificarUsuario.lt = new ListarTodos();
                        VerificarUsuario.lt.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                        setVisible(false);
                    }
            	}
            });*/
            controle.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){

                      try{
                        saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                        scroller.setVisible(false);
                        tela.remove(scroller);

                 }catch(Exception ext){

                         saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                 };

                    try{
                    VerificarUsuario.co.setVisible(true);
                    setVisible(false);
                    }catch(Exception ex){
                        VerificarUsuario.co = new Controle();
                        VerificarUsuario.co.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                        setVisible(false);
                    }
                }
            });

            consultar.addActionListener(new ActionListener(){
            	public void actionPerformed(ActionEvent e){

                     try{
                        valorTotal.setText("");
                        scroller.setVisible(false);
                        tela.remove(scroller);

                 }catch(Exception ext){

                        valorTotal.setText("");
                 };

            		if(tData_ini.getText().equals("  /  /    ") || tData_fim.getText().equals("  /  /    ")){
                        JOptionPane.showMessageDialog(null,"Preencha a data de inicio e a data final para a consulta" );
                    }else{
            		re = new RepositorioEmprestimo();
                    tabela = re.consultaPrincipal(tData_ini.getText(), tData_fim.getText());
                    
                        if(tabela.getValueAt(0, 0)== null){
                        JOptionPane.showMessageDialog(null,"Registros não Encontrados !!!");
                           
                    }else{
                    
                    scroller = new JScrollPane(tabela, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    tela.add(scroller);
            	    scroller.setBounds(20, 200, 1000, 300);
                    double somaDoub = re.somarConsultaPrincipal(tData_ini.getText(), tData_fim.getText());
                    BigDecimal soma = BigDecimal.valueOf(somaDoub);
                    String valor = VerificarUsuario.paraFormatoDinheiro(soma);
                    valorTotal.setText("À Receber R$ "+valor);
                    valorTotal.setVisible(true);

                         }
                    }
            	}
            });


            cadastro.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){

                      try{
                        saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                        scroller.setVisible(false);
                        tela.remove(scroller);

                 }catch(Exception ext){

                         saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                 };

                    try{
                    VerificarUsuario.ca.setVisible(true);
                    setVisible(false);
                    }catch(Exception ex){
                        VerificarUsuario.ca = new CadastroCarro();
                        VerificarUsuario.ca.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                        setVisible(false);
                    }
                }
            });

              renov_alug.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){

                      try{
                        saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                        scroller.setVisible(false);
                        tela.remove(scroller);

                 }catch(Exception ext){

                         saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                 };

                    try{
                    VerificarUsuario.ra.setVisible(true);
                    setVisible(false);
                    }catch(Exception ex){
                        VerificarUsuario.ra = new RenovarAluguel();
                        VerificarUsuario.ra.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                        setVisible(false);
                    }
                }
            });

            alugar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){

                      try{
                        saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                        scroller.setVisible(false);
                        tela.remove(scroller);

                 }catch(Exception ext){

                         saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                 };

                    try{
                   
                    VerificarUsuario.ac.carregarCarros("Livres");
                    VerificarUsuario.ac.setVisible(true);
                    setVisible(false);
                    }catch(Exception ex){
                  
                        VerificarUsuario.ac = new AlugarCarro();
                        VerificarUsuario.ac.carregarCarros("Livres");
                        VerificarUsuario.ac.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                        setVisible(false);
                    }
                }
            });

             reservar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){

                      try{
                        saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                        scroller.setVisible(false);
                        tela.remove(scroller);

                 }catch(Exception ext){

                         saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                 };

                    try{
                   
                    VerificarUsuario.rc.carregarCarros();
                    VerificarUsuario.rc.setVisible(true);
                    setVisible(false);
                    }catch(Exception ex){
                  
                        VerificarUsuario.rc = new reservarCarro();
                        VerificarUsuario.rc.carregarCarros();
                        VerificarUsuario.rc.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                        setVisible(false);
                    }
                }
            });

            despesas.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){

                      try{
                        saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                        scroller.setVisible(false);
                        tela.remove(scroller);

                 }catch(Exception ext){

                         saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                 };


                    try{

                    VerificarUsuario.cca.carregarCarros();
                    VerificarUsuario.cca.setVisible(true);
                    setVisible(false);
                    }catch(Exception ex){

                        VerificarUsuario.cca = new Controle_carros();
                        VerificarUsuario.cca.carregarCarros();
                        VerificarUsuario.cca.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                        setVisible(false);
                    }
                }
            });


            relatorio.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){

                      try{
                        saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                        scroller.setVisible(false);
                        tela.remove(scroller);

                 }catch(Exception ext){

                         saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                 };

                    try{
                    VerificarUsuario.relc.carregarCarros();
                    VerificarUsuario.relc.setVisible(true);
                    setVisible(false);
                    }catch(Exception ex){

                        VerificarUsuario.relc = new RelatorioCarro();
                          VerificarUsuario.relc.carregarCarros();
                        VerificarUsuario.relc.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                        setVisible(false);
                    }
                }
            });


            limpar.addActionListener(new ActionListener(){
            @SuppressWarnings("empty-statement")
            	public void actionPerformed(ActionEvent e){

                    	/*Principal pri = new Principal();
                        pri.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                        setVisible(false);*/

                 try{
                        saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                        scroller.setVisible(false);
                        tela.remove(scroller);
                    
                 }catch(Exception ext){

                        saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                 };

            	}
            });

            mar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                  try{
                        saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                        scroller.setVisible(false);
                        tela.remove(scroller);

                 }catch(Exception ext){
                         saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                 };

                try{
                        VerificarUsuario.cbb.setVisible(true);
                        setVisible(false);
                }catch(Exception ex){
                    VerificarUsuario.cbb = new ControlaBcoBrasil();
                    VerificarUsuario.cbb.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    setVisible(false);
                }
                }
            });

            bcoSanta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                  try{
                        saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                        scroller.setVisible(false);
                        tela.remove(scroller);

                 }catch(Exception ext){

                         saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                 };

                try{
                    VerificarUsuario.cbr.setVisible(true);
                    setVisible(false);
                }catch(Exception ex){
                    VerificarUsuario.cbr = new ControlaBcoReal();
                    VerificarUsuario.cbr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    setVisible(false);
                }
                }
            });

            dinheiro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                  try{
                        saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                        scroller.setVisible(false);
                        tela.remove(scroller);

                 }catch(Exception ext){

                        saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                 };

            try{
                    VerificarUsuario.cd.setVisible(true);
                    setVisible(false);
            }catch(Exception ex){
                    VerificarUsuario.cd = new ControlaDinheiro();
                    VerificarUsuario.cd.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    setVisible(false);
            }
                }
            });
            
            bcoBrad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                  try{
                        saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                        scroller.setVisible(false);
                        tela.remove(scroller);

                 }catch(Exception ext){

                         saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                 };

                try{
                    VerificarUsuario.cbra.setVisible(true);
                    setVisible(false);
                }catch(Exception ex){
                    VerificarUsuario.cbra = new ControlaBcoBrad();
                    VerificarUsuario.cbra.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    setVisible(false);
                }
                }
            });
            Pris.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                  try{
                        saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                        scroller.setVisible(false);
                        tela.remove(scroller);

                 }catch(Exception ext){

                         saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                 };

                try{
                    VerificarUsuario.cp.setVisible(true);
                    setVisible(false);
                }catch(Exception ex){
                    VerificarUsuario.cp = new ControlaPris();
                    VerificarUsuario.cp.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    setVisible(false);
                }
                }
            });
            
            locaSul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                  try{
                        saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                        scroller.setVisible(false);
                        tela.remove(scroller);

                 }catch(Exception ext){

                         saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                 };

                try{
                    VerificarUsuario.cls.setVisible(true);
                    setVisible(false);
                }catch(Exception ex){
                    VerificarUsuario.cls = new ControlaLocSul();
                    VerificarUsuario.cls.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    setVisible(false);
                }
                }
            });
            
            resgatar.addActionListener(new ActionListener(){
            	public void actionPerformed(ActionEvent e){

                      try{
                        saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                        scroller.setVisible(false);
                        tela.remove(scroller);

                 }catch(Exception ext){

                         saldoContas.setText("");
                        saldoBra.setText("");
                        saldoRe.setText("");
                        saldoDin.setText("");
                        saldoBr.setText("");
                        saldoLocasul.setText("");
                        saldoPri.setText("");
                        tData_ini.setText("");
                        tData_fim.setText("");
                        valorTotal.setText("");
                 };
                try{
            		VerificarUsuario.rse.setVisible(true);
                    setVisible(false);
                    }catch(Exception ex){
                        VerificarUsuario.rse = new ResgatarEmprestimo();
                        VerificarUsuario.rse.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                        setVisible(false);
                    }
                }
            });


            
            setExtendedState(MAXIMIZED_BOTH);
            setSize(800,600);
            setLocationRelativeTo(null);
            setVisible(true);
        }

 }
