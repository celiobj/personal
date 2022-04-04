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

import Classes.Dia;
import Classes.Funcao;
import Classes.Funcionario;
import Classes.Horario;
import Classes.Setor;
import DAO.AccessDatabase;
import Persistencia.RepositorioDia;
import Persistencia.RepositorioFuncao;
import Persistencia.RepositorioFuncionario;
import Persistencia.RepositorioHorario;
import Persistencia.RepositorioSetor;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author celio
 */
public class Principal extends JFrame {


        JToolBar menu;
        JScrollPane scroller;
        JTable tabela;
        Vector<Vector> preencher;
        Vector <Dia> vector = new Vector<Dia>();
        
        int qtdDia ;
        Calendar data;
        
    
    
        
        JButton sair_interno;
        ImageIcon image_sair_interno = new ImageIcon("Icones\\sair.png");
        
        JButton salvar_interno_funcionario;
        ImageIcon image_salvar_interno_funcionario = new ImageIcon("Icones\\botao_salvar.png");
        JButton limpar_interno_funcionario;
        ImageIcon image_limpar_interno_funcionario = new ImageIcon("Icones\\botao_limpar.png");
        JButton listar_interno_funcionario;
        ImageIcon image_listar_interno_funcionario = new ImageIcon("Icones\\botao_listar.png");
        JButton alterar_interno_funcionario;
        ImageIcon image_alterar_interno_funcionario = new ImageIcon("Icones\\botao_alterar.jpg");
        JButton excluir_interno_funcionario;
        ImageIcon image_excluir_interno_funcionario = new ImageIcon("Icones\\botao_excluir.jpg");
        
        JButton salvar_interno_funcao;
        ImageIcon image_salvar_interno_funcao = new ImageIcon("Icones\\botao_salvar.png");
        JButton limpar_interno_funcao;
        ImageIcon image_limpar_interno_funcao = new ImageIcon("Icones\\botao_limpar.png");
        JButton listar_interno_funcao;
        ImageIcon image_listar_interno_funcao = new ImageIcon("Icones\\botao_listar.png");
        JButton excluir_interno_funcao;
        ImageIcon image_excluir_interno_funcao = new ImageIcon("Icones\\botao_excluir.jpg");
        
        
        JButton salvar_interno_setor;
        ImageIcon image_salvar_interno_setor = new ImageIcon("Icones\\botao_salvar.png");
        JButton limpar_interno_setor;
        ImageIcon image_limpar_interno_setor = new ImageIcon("Icones\\botao_limpar.png");
        JButton listar_interno_setor;
        ImageIcon image_listar_interno_setor = new ImageIcon("Icones\\botao_listar.png");
        JButton excluir_interno_setor;
        ImageIcon image_excluir_interno_setor = new ImageIcon("Icones\\botao_excluir.jpg");
        
        JButton salvar_interno_operacao;
        ImageIcon image_salvar_interno_operacao = new ImageIcon("Icones\\botao_salvar.png");
        JButton limpar_interno_operacao;
        ImageIcon image_limpar_interno_operacao = new ImageIcon("Icones\\botao_limpar.png");
        JButton listar_interno_operacao;
        ImageIcon image_listar_interno_operacao = new ImageIcon("Icones\\botao_listar.png");
        
        JButton salvar_interno_horario;
        ImageIcon image_salvar_interno_horario = new ImageIcon("Icones\\botao_salvar.png");
        JButton limpar_interno_horario;
        ImageIcon image_limpar_interno_horario = new ImageIcon("Icones\\botao_limpar.png");
        JButton listar_interno_horario;
        ImageIcon image_listar_interno_horario = new ImageIcon("Icones\\botao_listar.png");
        
        
        JButton salvar_interno_controle;
        ImageIcon image_salvar_interno_controle = new ImageIcon("Icones\\botao_salvar.png");
        JButton limpar_interno_controle;
        ImageIcon image_limpar_interno_controle = new ImageIcon("Icones\\botao_limpar.png");
        JButton listar_interno_controle;
        ImageIcon image_listar_interno_controle = new ImageIcon("Icones\\botao_listar.png");
        
        
        //Botão Cadastrar Funcionário
        JButton cadastrarFuncionario;
        JPanel painel_funcionario;
        JLabel nome_funcionario, cpf_funcionario,matricula_funcionario,funcao_funcionario,setor_funcionario;
        JTextField tNome_funcionario,tCpf, tMatricula;
        MaskFormatter mascaraCpf;
        JComboBox tFuncao, tSetor;
        ImageIcon imageFuncionario = new ImageIcon("Icones\\funcionario.png");
        
         //Botão Cadastrar Funcao
        JButton cadastrarFuncao;
        JPanel painel_funcao;
        JLabel nome_funcao;
        JTextField tNome_funcao;
        ImageIcon imageFuncao = new ImageIcon("Icones\\funcao.png");
        
        //Botão Cadastrar Setor
        JButton cadastrarSetor;
        JPanel painel_setor;
        JLabel nome_setor;
        JTextField tNome_setor;
        ImageIcon imageSetor = new ImageIcon("Icones\\setor.png");
        
        //Botão Consultar operação
        JButton consultarOperacao;
        JPanel painel_operacao;
        JLabel dia;
        JTextField tDia;
        MaskFormatter mascaraDia; 
        ImageIcon imageOperacao = new ImageIcon("Icones\\operacao.png");
        
        //Botão Cadastrar Horário
        JButton cadastrarHorario;
        JPanel painel_Horario;
        JLabel nome_funcaoH,nome_setorH,entrada1H,saida1H,entrada2H,saida2H;
        JTextField tentrada1H,tsaida1H,tentrada2H,tsaida2H;
        JComboBox tFuncaoH, tSetorH;
        ImageIcon imageHorario = new ImageIcon("Icones\\horario.png");
       
        //Botão Controle
        JButton controle;
        JPanel painel_controle;  
        JLabel nome_controle,mes_controle,ano_controle,entrada1,saida1,entrada2,saida2,entrada12,saida12,entrada22,saida22,entradaExtra,saidaExtra,extra1,extra2;
        JLabel dia1,dia2,dia3,dia4,dia5,dia6,dia7,dia8,dia9,dia10,dia11,dia12,dia13,dia14,dia15,dia16,dia17,dia18,dia19,dia20,dia21,dia22,dia23,dia24,dia25,dia26,dia27,dia28,dia29,dia30,dia31;
        JTextField tDia1_entrada1,tDia1_saida1,tDia1_entrada2,tDia1_saida2,tDia2_entrada1,tDia2_saida1,tDia2_entrada2,tDia2_saida2,tDia3_entrada1,tDia3_saida1,tDia3_entrada2,tDia3_saida2,tDia4_entrada1,tDia4_saida1,tDia4_entrada2,tDia4_saida2,tDia5_entrada1,tDia5_saida1,tDia5_entrada2,tDia5_saida2,tDia6_entrada1,tDia6_saida1,tDia6_entrada2,tDia6_saida2,tDia7_entrada1,tDia7_saida1,tDia7_entrada2,tDia7_saida2,tDia8_entrada1,tDia8_saida1,tDia8_entrada2,tDia8_saida2,tDia9_entrada1,tDia9_saida1,tDia9_entrada2,tDia9_saida2,tDia10_entrada1,tDia10_saida1,tDia10_entrada2,tDia10_saida2,tDia11_entrada1,tDia11_saida1,tDia11_entrada2,tDia11_saida2,tDia12_entrada1,tDia12_saida1,tDia12_entrada2,tDia12_saida2,tDia13_entrada1,tDia13_saida1,tDia13_entrada2,tDia13_saida2,tDia14_entrada1,tDia14_saida1,tDia14_entrada2,tDia14_saida2,tDia15_entrada1,tDia15_saida1,tDia15_entrada2,tDia15_saida2,tDia16_entrada1,tDia16_saida1,tDia16_entrada2,tDia16_saida2,tDia17_entrada1,tDia17_saida1,tDia17_entrada2,tDia17_saida2,tDia18_entrada1,tDia18_saida1,tDia18_entrada2,tDia18_saida2,tDia19_entrada1,tDia19_saida1,tDia19_entrada2,tDia19_saida2,tDia20_entrada1,tDia20_saida1,tDia20_entrada2,tDia20_saida2,tDia21_entrada1,tDia21_saida1,tDia21_entrada2,tDia21_saida2,tDia22_entrada1,tDia22_saida1,tDia22_entrada2,tDia22_saida2,tDia23_entrada1,tDia23_saida1,tDia23_entrada2,tDia23_saida2,tDia24_entrada1,tDia24_saida1,tDia24_entrada2,tDia24_saida2,tDia25_entrada1,tDia25_saida1,tDia25_entrada2,tDia25_saida2,tDia26_entrada1,tDia26_saida1,tDia26_entrada2,tDia26_saida2,tDia27_entrada1,tDia27_saida1,tDia27_entrada2,tDia27_saida2,tDia28_entrada1,tDia28_saida1,tDia28_entrada2,tDia28_saida2,tDia29_entrada1,tDia29_saida1,tDia29_entrada2,tDia29_saida2,tDia30_entrada1,tDia30_saida1,tDia30_entrada2,tDia30_saida2,tDia31_entrada1,tDia31_saida1,tDia31_entrada2,tDia31_saida2;
        MaskFormatter mascaraHora;
        JComboBox tNome_controle,tMes_controle, tAno_controle;
        ImageIcon imageControle = new ImageIcon("Icones\\controle.png"); 
        
        //Botão Relatório
        JButton relatorio;
        JPanel painel_relatorio;
        JButton okGeral,okGeralMes,okGeralFuncionario, okFuncionarioMes;
        JComboBox tFuncionarioGeral_relatorio,tFuncionario_relatorio,tMes_relatorio, tMesFuncionario_relatorio,tAno_relatorio,tAnoFuncionario_relatorio;
        ImageIcon imageRelatorio = new ImageIcon("Icones\\relatorio.png");

        
        //Botão Sair  
        JButton  sair;
        ImageIcon imageSair = new ImageIcon("Icones\\botao_sair.png"); 

        //Repositorios
        RepositorioDia rd;
        RepositorioFuncao rf;
        RepositorioFuncionario rfun;
        RepositorioHorario rh;
        RepositorioSetor rs;

    @SuppressWarnings("empty-statement")
       public Principal() {

            super("..:: UltraPoint - Vs. 1.0 ::..");
            final Container tela = getContentPane();
            tela.setLayout(null);
            setResizable(false);
            setSize(1280,800);
            setLocationRelativeTo(null);
            setVisible(true);
            criaMenu();
            
            
             try{
        	 mascaraHora = new MaskFormatter("##:##:##");
             }catch (Exception exp){};
             
              try{
        	 mascaraCpf = new MaskFormatter("###.###.###-##");
             }catch (Exception exp){};
             
             try{
        	 mascaraDia = new MaskFormatter("##/##/####");
             }catch (Exception exp){};
             
            sair_interno = new JButton();
            sair_interno.setIcon(image_sair_interno);
            sair_interno.setBounds(1048, 2, 50, 50);
            sair_interno.setToolTipText("Voltar");
            
            salvar_interno_funcionario = new JButton();
            salvar_interno_funcionario.setIcon(image_salvar_interno_funcionario);
            salvar_interno_funcionario.setBounds(50, 500, 50, 50);
            salvar_interno_funcionario.setToolTipText("Salvar");
            
            limpar_interno_funcionario = new JButton();
            limpar_interno_funcionario.setIcon(image_limpar_interno_funcionario);
            limpar_interno_funcionario.setBounds(120, 500, 50, 50);
            limpar_interno_funcionario.setToolTipText("Limpar");
            
            listar_interno_funcionario = new JButton();
            listar_interno_funcionario.setIcon(image_listar_interno_funcionario);
            listar_interno_funcionario.setBounds(948, 2, 50, 50);
            listar_interno_funcionario.setToolTipText("Listar");
            
            alterar_interno_funcionario = new JButton();
            alterar_interno_funcionario.setIcon(image_alterar_interno_funcionario);
            alterar_interno_funcionario.setBounds(300, 10, 60, 25);
            alterar_interno_funcionario.setToolTipText("Alterar");
            alterar_interno_funcionario.setVisible(false);
            
            excluir_interno_funcionario = new JButton();
            excluir_interno_funcionario.setIcon(image_excluir_interno_funcionario);
            excluir_interno_funcionario.setBounds(948, 2, 50, 50);
            excluir_interno_funcionario.setToolTipText("Excluir");
            
            
            salvar_interno_funcao = new JButton();
            salvar_interno_funcao.setIcon(image_salvar_interno_funcao);
            salvar_interno_funcao.setBounds(50, 500, 50, 50);
            salvar_interno_funcao.setToolTipText("Salvar");
            
            limpar_interno_funcao = new JButton();
            limpar_interno_funcao.setIcon(image_limpar_interno_funcao);
            limpar_interno_funcao.setBounds(120, 500, 50, 50);
            limpar_interno_funcao.setToolTipText("Limpar");
            
            listar_interno_funcao = new JButton();
            listar_interno_funcao.setIcon(image_listar_interno_funcao);
            listar_interno_funcao.setBounds(948, 2, 50, 50);
            listar_interno_funcao.setToolTipText("Listar");
            
            excluir_interno_funcao = new JButton();
            excluir_interno_funcao.setIcon(image_excluir_interno_funcao);
            excluir_interno_funcao.setBounds(948, 2, 50, 50);
            excluir_interno_funcao.setToolTipText("Excluir");
            
            
            salvar_interno_setor = new JButton();
            salvar_interno_setor.setIcon(image_salvar_interno_setor);
            salvar_interno_setor.setBounds(50, 500, 50, 50);
            salvar_interno_setor.setToolTipText("Salvar");
            
            limpar_interno_setor = new JButton();
            limpar_interno_setor.setIcon(image_limpar_interno_setor);
            limpar_interno_setor.setBounds(120, 500, 50, 50);
            limpar_interno_setor.setToolTipText("Limpar");
            
            listar_interno_setor = new JButton();
            listar_interno_setor.setIcon(image_listar_interno_setor);
            listar_interno_setor.setBounds(948, 2, 50, 50);
            listar_interno_setor.setToolTipText("Listar");
            
            excluir_interno_setor = new JButton();
            excluir_interno_setor.setIcon(image_excluir_interno_setor);
            excluir_interno_setor.setBounds(948, 2, 50, 50);
            excluir_interno_setor.setToolTipText("Excluir");
            
            listar_interno_operacao = new JButton();
            listar_interno_operacao.setIcon(image_salvar_interno_operacao);
            listar_interno_operacao.setBounds(50, 500, 50, 50);
            listar_interno_operacao.setToolTipText("Listar");
            
            limpar_interno_operacao = new JButton();
            limpar_interno_operacao.setIcon(image_limpar_interno_operacao);
            limpar_interno_operacao.setBounds(120, 500, 50, 50);
            limpar_interno_operacao.setToolTipText("Limpar");
                        
            salvar_interno_horario = new JButton();
            salvar_interno_horario.setIcon(image_salvar_interno_horario);
            salvar_interno_horario.setBounds(50, 500, 50, 50);
            salvar_interno_horario.setToolTipText("Salvar");
            
            limpar_interno_horario = new JButton();
            limpar_interno_horario.setIcon(image_limpar_interno_horario);
            limpar_interno_horario.setBounds(120, 500, 50, 50);
            limpar_interno_horario.setToolTipText("Limpar");
            
            listar_interno_horario = new JButton();
            listar_interno_horario.setIcon(image_listar_interno_horario);
            listar_interno_horario.setBounds(948, 2, 50, 50);
            listar_interno_horario.setToolTipText("Listar");
            
            
            salvar_interno_controle = new JButton();
            salvar_interno_controle.setIcon(image_salvar_interno_controle);
            salvar_interno_controle.setBounds(50, 500, 50, 50);
            salvar_interno_controle.setToolTipText("Salvar");
            
            limpar_interno_controle = new JButton();
            limpar_interno_controle.setIcon(image_limpar_interno_controle);
            limpar_interno_controle.setBounds(120, 500, 50, 50);
            limpar_interno_controle.setToolTipText("Limpar");
            
            listar_interno_controle = new JButton();
            listar_interno_controle.setIcon(image_listar_interno_controle);
            listar_interno_controle.setBounds(120, 500, 50, 50);
            listar_interno_controle.setToolTipText("Listar");
            
            okGeral = new JButton("Geral");
            okGeralMes = new JButton("Relatório geral p/ mês");
            okGeralFuncionario = new JButton("Relatório geral por funcionário");
            okFuncionarioMes = new JButton("Funcionário x mês");
                    
            
            
             
            menu.setBounds(1,1,tela.getWidth(),80); 
            tela.add(menu);
            
           
           




            
            
             cadastrarFuncionario.addActionListener(new ActionListener(){
                 @SuppressWarnings("empty-statement")
                 @Override
            	public void actionPerformed(ActionEvent e){
                     
                     try{  
                      
                    tela.remove(painel_funcao);
                    }catch(NullPointerException npe){};
                  
                     try{  
                      
                    tela.remove(painel_setor);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(painel_operacao);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(painel_Horario);
                    }catch(NullPointerException npe){};
                    
                    
                    
                    try{  
                      
                    tela.remove(painel_controle);
                    }catch(NullPointerException npe){};
                    
                     try{  
                      
                    tela.remove(painel_relatorio);
                    }catch(NullPointerException npe){};
                    
                    
                    
                    painel_funcionario = new JPanel();
                    painel_funcionario.setLayout(null);
                    painel_funcionario.setBackground(Color.LIGHT_GRAY);
                    painel_funcionario.setBorder(BorderFactory.createBevelBorder(1, Color.DARK_GRAY, Color.DARK_GRAY));
                    JToolBar ferramentas = new JToolBar("Ferramentas");
                    painel_funcionario.add(sair_interno);
                    ferramentas.add(salvar_interno_funcionario);
                    ferramentas.add(listar_interno_funcionario);
                    ferramentas.add(excluir_interno_funcionario);
                    ferramentas.add(limpar_interno_funcionario);
                    ferramentas.setBounds(2, 584, 1095, 64);
                    painel_funcionario.add(ferramentas);
                    painel_funcionario.add(alterar_interno_funcionario);
                    nome_funcionario = new JLabel("Nome: ");
                    tNome_funcionario = new JTextField(40);
                    nome_funcionario.setBounds(10, 10, 100, 20);
                    tNome_funcionario.setBounds(80, 10, 200, 20);
                    cpf_funcionario = new JLabel("CPF: ");
                    tCpf = new JFormattedTextField(mascaraCpf);
                    cpf_funcionario.setBounds(10, 40, 100, 20);
                    tCpf.setBounds(80, 40, 100, 20);
                    matricula_funcionario = new JLabel("Matrícula: ");
                    tMatricula = new JTextField(40);
                    matricula_funcionario.setBounds(10, 70, 80, 20);
                    tMatricula.setBounds(80, 70, 100, 20);
                    rf = new RepositorioFuncao();
                    funcao_funcionario = new JLabel("Função");
                    tFuncao = new JComboBox(rf.listarFuncao());
                    funcao_funcionario.setBounds(10, 100, 80, 20);
                    tFuncao.setBounds(80, 100, 200, 20);
                    rs = new RepositorioSetor();
                    setor_funcionario = new JLabel("Setor");
                    tSetor = new JComboBox(rs.listarSetor());
                    setor_funcionario.setBounds(10, 130, 80, 20);
                    tSetor.setBounds(80, 130, 200, 20);
                    
                    
                    
                    painel_funcionario.add(nome_funcionario);
                    painel_funcionario.add(tNome_funcionario);
                    painel_funcionario.add(cpf_funcionario);
                    painel_funcionario.add(tCpf);
                    painel_funcionario.add(matricula_funcionario);
                    painel_funcionario.add(tMatricula);
                    painel_funcionario.add(funcao_funcionario);
                    painel_funcionario.add(tFuncao);
                    painel_funcionario.add(setor_funcionario);
                    painel_funcionario.add(tSetor);
                    painel_funcionario.setBounds(50, 80, 1100, 650);
                    cadastrarFuncionario.setEnabled(false);
                    cadastrarFuncao.setEnabled(true);
                    cadastrarSetor.setEnabled(true);
                    consultarOperacao.setEnabled(true);
                    cadastrarHorario.setEnabled(true);
                    controle.setEnabled(true);
                    relatorio.setEnabled(true);
                    tela.add(painel_funcionario);
                    tela.revalidate();
                    tela.repaint();
          
                 }
             });
             
             cadastrarFuncao.addActionListener(new ActionListener(){
                 @SuppressWarnings("empty-statement")
                 @Override
            	public void actionPerformed(ActionEvent e){
                  
                      try{  
                      
                    tela.remove(painel_funcionario);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(painel_setor);
                    }catch(NullPointerException npe){};
                    
                     try{  
                      
                    tela.remove(painel_operacao);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(painel_Horario);
                    }catch(NullPointerException npe){};
                    
                    
                    
                     try{  
                      
                    tela.remove(painel_controle);
                    }catch(NullPointerException npe){};
                     try{  
                      
                    tela.remove(painel_relatorio);
                    }catch(NullPointerException npe){};
                    
                    painel_funcao = new JPanel();
                    painel_funcao.setLayout(null);
                    painel_funcao.setBackground(Color.LIGHT_GRAY);
                    painel_funcao.setBorder(BorderFactory.createBevelBorder(1, Color.DARK_GRAY, Color.DARK_GRAY));
                    JToolBar ferramentas = new JToolBar("Ferramentas");
                    painel_funcao.add(sair_interno);
                    ferramentas.add(salvar_interno_funcao);
                    ferramentas.add(listar_interno_funcao);
                    ferramentas.add(excluir_interno_funcao);
                    ferramentas.add(limpar_interno_funcao);
                    ferramentas.setBounds(2, 584, 1095, 64);
                    painel_funcao.add(ferramentas);
                    nome_funcao = new JLabel("Função: ");
                    tNome_funcao = new JTextField(40);
                    nome_funcao.setBounds(10, 10, 100, 20);
                    tNome_funcao.setBounds(80, 10, 200, 20);
                    painel_funcao.add(nome_funcao);
                    painel_funcao.add(tNome_funcao);
                    painel_funcao.setBounds(50, 80, 1100, 650);
                    cadastrarFuncionario.setEnabled(true);
                    cadastrarFuncao.setEnabled(false);
                    cadastrarSetor.setEnabled(true);
                    consultarOperacao.setEnabled(true);
                    cadastrarHorario.setEnabled(true);
                    controle.setEnabled(true);
                    relatorio.setEnabled(true);
                    tela.add(painel_funcao);
                    tela.revalidate();
                    tela.repaint();
          
                 }
             });
             
             cadastrarSetor.addActionListener(new ActionListener(){
                 @SuppressWarnings("empty-statement")
                 @Override
            	public void actionPerformed(ActionEvent e){
                     
                      try{  
                      
                    tela.remove(painel_funcionario);
                    }catch(NullPointerException npe){};
                     
                     try{  
                      
                    tela.remove(painel_funcao);
                    }catch(NullPointerException npe){};
                    
                     try{  
                      
                    tela.remove(painel_operacao);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(painel_Horario);
                    }catch(NullPointerException npe){};
                  
                     try{  
                      
                    tela.remove(painel_controle);
                    }catch(NullPointerException npe){};
                     try{  
                      
                    tela.remove(painel_relatorio);
                    }catch(NullPointerException npe){};
                    
                    
                    
                    painel_setor = new JPanel();
                    painel_setor.setLayout(null);
                    painel_setor.setBackground(Color.LIGHT_GRAY);
                    painel_setor.setBorder(BorderFactory.createBevelBorder(1, Color.DARK_GRAY, Color.DARK_GRAY));
                    JToolBar ferramentas = new JToolBar("Ferramentas");
                    painel_setor.add(sair_interno);
                    ferramentas.add(salvar_interno_setor);
                    ferramentas.add(listar_interno_setor);
                    ferramentas.add(excluir_interno_setor);
                    ferramentas.add(limpar_interno_setor);
                    ferramentas.setBounds(2, 584, 1095, 64);
                    painel_setor.add(ferramentas);
                    nome_setor = new JLabel("Setor: ");
                    tNome_setor = new JTextField(40);
                    nome_setor.setBounds(10, 10, 100, 20);
                    tNome_setor.setBounds(80, 10, 200, 20);
                    painel_setor.add(nome_setor);
                    painel_setor.add(tNome_setor);
                    painel_setor.setBounds(50, 80, 1100, 650);
                    cadastrarFuncionario.setEnabled(true);
                    cadastrarFuncao.setEnabled(true);
                    cadastrarSetor.setEnabled(false);
                    consultarOperacao.setEnabled(true);
                    cadastrarHorario.setEnabled(true);
                    controle.setEnabled(true);
                    relatorio.setEnabled(true);
                    tela.add(painel_setor);
                    tela.revalidate();
                    tela.repaint();
          
                 }
             });
             
             consultarOperacao.addActionListener(new ActionListener(){
                 @SuppressWarnings("empty-statement")
                 @Override
            	public void actionPerformed(ActionEvent e){
                    
                    
                     try{  
                      
                    tela.remove(painel_funcionario);
                    }catch(NullPointerException npe){};
                     
                     try{  
                      
                    tela.remove(painel_funcao);
                    }catch(NullPointerException npe){};
                    
                       try{  
                      
                    tela.remove(painel_setor);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(painel_Horario);
                    }catch(NullPointerException npe){};
                  
                     try{  
                      
                    tela.remove(painel_controle);
                    }catch(NullPointerException npe){};
                     try{  
                      
                    tela.remove(painel_relatorio);
                    }catch(NullPointerException npe){};
                    
                    
                    
                    painel_operacao = new JPanel();
                    painel_operacao.setLayout(null);
                    painel_operacao.setBackground(Color.LIGHT_GRAY);
                    painel_operacao.setBorder(BorderFactory.createBevelBorder(1, Color.DARK_GRAY, Color.DARK_GRAY));
                    JToolBar ferramentas = new JToolBar("Ferramentas");
                    painel_operacao.add(sair_interno);
                    ferramentas.add(listar_interno_operacao);
                    ferramentas.add(limpar_interno_operacao);
                    ferramentas.setBounds(2, 584, 1095, 64);
                    painel_operacao.add(ferramentas);
                    dia = new JLabel("Dia: ");
                    tDia = new JFormattedTextField(mascaraDia);
                    dia.setBounds(10, 10, 100, 20);
                    tDia.setBounds(80, 10, 100, 20);
                    painel_operacao.add(dia);
                    painel_operacao.add(tDia);
                    painel_operacao.setBounds(50, 80, 1100, 650);
                    cadastrarFuncionario.setEnabled(true);
                    cadastrarFuncao.setEnabled(true);
                    cadastrarSetor.setEnabled(true);
                    consultarOperacao.setEnabled(false);
                    cadastrarHorario.setEnabled(true);
                    controle.setEnabled(true);
                    relatorio.setEnabled(true);
                    tela.add(painel_operacao);
                    tela.revalidate();
                    tela.repaint();
          
                 }
             });
             
             
             
             cadastrarHorario.addActionListener(new ActionListener(){
                 @SuppressWarnings("empty-statement")
                 @Override
            	public void actionPerformed(ActionEvent e){
                     
                    
                    try{  
                      
                    tela.remove(painel_funcionario);
                    }catch(NullPointerException npe){};
                     
                    try{  
                      
                    tela.remove(painel_funcao);
                    }catch(NullPointerException npe){};
                  
                     try{  
                      
                    tela.remove(painel_setor);
                    }catch(NullPointerException npe){};
                    
                     try{  
                      
                    tela.remove(painel_operacao);
                    }catch(NullPointerException npe){};
                    
                     try{  
                      
                    tela.remove(painel_controle);
                    }catch(NullPointerException npe){};
                     try{  
                      
                    tela.remove(painel_relatorio);
                    }catch(NullPointerException npe){};
                    
                    
                    
                    painel_Horario= new JPanel();
                    painel_Horario.setLayout(null);
                    painel_Horario.setBackground(Color.LIGHT_GRAY);
                    painel_Horario.setBorder(BorderFactory.createBevelBorder(1, Color.DARK_GRAY, Color.DARK_GRAY));
                    JToolBar ferramentas = new JToolBar("Ferramentas");
                    painel_Horario.add(sair_interno);
                    ferramentas.add(salvar_interno_horario);
                    ferramentas.add(listar_interno_horario);
                    ferramentas.add(limpar_interno_horario);
                    ferramentas.setBounds(2, 584, 1095, 64);
                    painel_Horario.add(ferramentas);
                    rf = new RepositorioFuncao();
                    nome_funcaoH = new JLabel("Função: ");
                    tFuncaoH = new JComboBox(rf.listarFuncao());
                    nome_funcaoH.setBounds(10, 10, 100, 20);
                    tFuncaoH.setBounds(80, 10, 200, 20);
                    rs = new RepositorioSetor();
                    nome_setorH = new JLabel("Setor: ");
                    tSetorH = new JComboBox(rs.listarSetor());
                    nome_setorH.setBounds(10, 40, 100, 20);
                    tSetorH.setBounds(80, 40, 100, 20);
                    
                    entrada1H = new JLabel("1a Entrada: ");
                    tentrada1H = new JFormattedTextField(mascaraHora);
                    entrada1H.setBounds(10, 70, 100, 20);
                    tentrada1H.setBounds(80, 70, 50, 20);
                    
                    saida1H = new JLabel("1a Saída: ");
                    tsaida1H = new JFormattedTextField(mascaraHora);
                    saida1H.setBounds(10, 100, 100, 20);
                    tsaida1H.setBounds(80, 100, 50, 20);
                    
                    entrada2H = new JLabel("2a Entrada: ");
                    tentrada2H = new JFormattedTextField(mascaraHora);
                    entrada2H.setBounds(10, 130, 100, 20);
                    tentrada2H.setBounds(80, 130, 50, 20);
                   
                    saida2H = new JLabel("2a Saída: ");
                    tsaida2H = new JFormattedTextField(mascaraHora);
                    saida2H.setBounds(10, 160, 100, 20);
                    tsaida2H.setBounds(80, 160, 50, 20);
                                        
                    painel_Horario.add(nome_funcaoH);
                    painel_Horario.add(tFuncaoH);
                    painel_Horario.add(nome_setorH);
                    painel_Horario.add(tSetorH);
                    painel_Horario.add(entrada1H);
                    painel_Horario.add(tentrada1H);
                    painel_Horario.add(saida1H);
                    painel_Horario.add(tsaida1H);
                    painel_Horario.add(entrada2H);
                    painel_Horario.add(tentrada2H);
                    painel_Horario.add(saida2H);
                    painel_Horario.add(tsaida2H);
                    
                    painel_Horario.setBounds(50, 80, 1100, 650);
                    cadastrarFuncionario.setEnabled(true);
                    cadastrarFuncao.setEnabled(true);
                    cadastrarSetor.setEnabled(true);
                    consultarOperacao.setEnabled(true);
                    cadastrarHorario.setEnabled(false);
                    controle.setEnabled(true);
                    relatorio.setEnabled(true);
                    tela.add(painel_Horario);
                    tela.revalidate();
                    tela.repaint();
          
                 }
             });
             
              controle.addActionListener(new ActionListener(){
                  @SuppressWarnings("empty-statement")
                  @Override
            	public void actionPerformed(ActionEvent e){
 
                    
                    try{
                      
                        tela.remove(painel_funcionario);
                         
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(painel_setor);
                    }catch(NullPointerException npe){};
                    
                     try{  
                      
                    tela.remove(painel_operacao);
                    }catch(NullPointerException npe){};
                    
                    
                     try{  
                      
                    tela.remove(painel_funcao);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(painel_Horario);
                    }catch(NullPointerException npe){};
                    
                    try{
                        
                        tela.remove(painel_relatorio);
                                               
                    }catch(NullPointerException npe){};
                    
                    
                        String meses[]={"","Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
                        String anos[]={"","2019"};
                        
                        painel_controle = new JPanel();
                        painel_controle.setLayout(null);
                        painel_controle.setBorder(BorderFactory.createBevelBorder(1, Color.DARK_GRAY, Color.DARK_GRAY));
                        painel_controle.setBackground(Color.LIGHT_GRAY);
                        JToolBar ferramentas = new JToolBar("Ferramentas");
                        ferramentas.add(salvar_interno_controle);
                        ferramentas.add(listar_interno_controle);
                        ferramentas.add(limpar_interno_controle);
                        ferramentas.setBounds(2, 584, 1095, 64);
                        painel_controle.add(ferramentas);
                        nome_controle = new JLabel("Nome: ");
                        rfun = new RepositorioFuncionario();
                        tNome_controle = new JComboBox(rfun.listarFuncionarios());
                        mes_controle = new JLabel("Mês: ");
                        tMes_controle = new JComboBox(meses);
                        ano_controle = new JLabel("Ano: ");
                        tAno_controle = new JComboBox(anos);
                        entrada1 = new JLabel("1a Entrada");
                        saida1 = new JLabel("1a Saída");
                        entrada2 = new JLabel("2a Entrada");
                        saida2 = new JLabel("2a Saída");
                        entrada12 = new JLabel("1a Entrada");
                        saida12 = new JLabel("1a Saída");
                        entrada22 = new JLabel("2a Entrada");
                        saida22 = new JLabel("2a Saída");
                        
                        entrada1.setBounds(70,60, 100, 20);
                        saida1.setBounds(150,60,100,20);
                        entrada2.setBounds(210,60, 100, 20);
                        saida2.setBounds(290,60,100,20);
                        entrada12.setBounds(825,60, 100, 20);
                        saida12.setBounds(895,60,100,20);
                        entrada22.setBounds(965,60, 100, 20);
                        saida22.setBounds(1035,60,100,20);
                        nome_controle.setBounds(10, 10, 50, 20);
                        tNome_controle.setBounds(50, 10, 200, 20);
                        mes_controle.setBounds(270, 10, 50, 20);
                        tMes_controle.setBounds(300, 10, 100, 20);
                        ano_controle.setBounds(450, 10, 100, 20);
                        tAno_controle.setBounds(480, 10, 100, 20);
                        
                        painel_controle.add(nome_controle);
                        painel_controle.add(tNome_controle);
                        painel_controle.add(mes_controle);
                        painel_controle.add(tMes_controle);
                        painel_controle.add(ano_controle);
                        painel_controle.add(tAno_controle);
                        painel_controle.add(entrada1);
                        painel_controle.add(saida1);
                        painel_controle.add(entrada2);
                        painel_controle.add(saida2);
                        painel_controle.add(entrada12);
                        painel_controle.add(saida12);
                        painel_controle.add(entrada22);
                        painel_controle.add(saida22);
                        painel_controle.add(sair_interno);
                        
                        
                        dia1 = new JLabel("Dia 01: ");
                        tDia1_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia1_saida1 = new JFormattedTextField(mascaraHora);
                        tDia1_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia1_saida2 = new JFormattedTextField(mascaraHora);
                        dia1.setBounds(10,90, 100, 20);
                        tDia1_entrada1.setBounds(75, 90, 60, 20);
                        tDia1_saida1.setBounds(145, 90, 60, 20);
                        tDia1_entrada2.setBounds(215, 90, 60, 20);
                        tDia1_saida2.setBounds(285, 90, 60, 20);
                        painel_controle.add(dia1);
                        painel_controle.add(tDia1_entrada1);
                        painel_controle.add(tDia1_saida1);
                        painel_controle.add(tDia1_entrada2);
                        painel_controle.add(tDia1_saida2);
                      
                         
                        dia2 = new JLabel("Dia 02: ");
                        tDia2_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia2_saida1 = new JFormattedTextField(mascaraHora);
                        tDia2_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia2_saida2 = new JFormattedTextField(mascaraHora);
                        dia2.setBounds(10,120, 100, 20);
                        tDia2_entrada1.setBounds(75, 120, 60, 20);
                        tDia2_saida1.setBounds(145, 120, 60, 20);
                        tDia2_entrada2.setBounds(215, 120, 60, 20);
                        tDia2_saida2.setBounds(285, 120, 60, 20);
                        painel_controle.add(dia2);
                        painel_controle.add(tDia2_entrada1);
                        painel_controle.add(tDia2_saida1);
                        painel_controle.add(tDia2_entrada2);
                        painel_controle.add(tDia2_saida2);
                        
                        
                        dia3 = new JLabel("Dia 03: ");
                        tDia3_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia3_saida1 = new JFormattedTextField(mascaraHora);
                        tDia3_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia3_saida2 = new JFormattedTextField(mascaraHora);
                        dia3.setBounds(10,150, 100, 20);
                        tDia3_entrada1.setBounds(75, 150, 60, 20);
                        tDia3_saida1.setBounds(145, 150, 60, 20);
                        tDia3_entrada2.setBounds(215, 150, 60, 20);
                        tDia3_saida2.setBounds(285, 150, 60, 20);
                        painel_controle.add(dia3);
                        painel_controle.add(tDia3_entrada1);
                        painel_controle.add(tDia3_saida1);
                        painel_controle.add(tDia3_entrada2);
                        painel_controle.add(tDia3_saida2);
                        
                         
                        dia4 = new JLabel("Dia 04: ");
                        tDia4_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia4_saida1 = new JFormattedTextField(mascaraHora);
                        tDia4_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia4_saida2 = new JFormattedTextField(mascaraHora);
                        dia4.setBounds(10,180, 100, 20);
                        tDia4_entrada1.setBounds(75, 180, 60, 20);
                        tDia4_saida1.setBounds(145, 180, 60, 20);
                        tDia4_entrada2.setBounds(215, 180, 60, 20);
                        tDia4_saida2.setBounds(285, 180, 60, 20);
                        painel_controle.add(dia4);
                        painel_controle.add(tDia4_entrada1);
                        painel_controle.add(tDia4_saida1);
                        painel_controle.add(tDia4_entrada2);
                        painel_controle.add(tDia4_saida2);
                        
                         
                        dia5 = new JLabel("Dia 05: ");
                        tDia5_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia5_saida1 = new JFormattedTextField(mascaraHora);
                        tDia5_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia5_saida2 = new JFormattedTextField(mascaraHora);
                        dia5.setBounds(10,210, 100, 20);
                        tDia5_entrada1.setBounds(75, 210, 60, 20);
                        tDia5_saida1.setBounds(145, 210, 60, 20);
                        tDia5_entrada2.setBounds(215, 210, 60, 20);
                        tDia5_saida2.setBounds(285, 210, 60, 20);
                        painel_controle.add(dia5);
                        painel_controle.add(tDia5_entrada1);
                        painel_controle.add(tDia5_saida1);
                        painel_controle.add(tDia5_entrada2);
                        painel_controle.add(tDia5_saida2);
                         
                        dia6 = new JLabel("Dia 06: ");
                        tDia6_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia6_saida1 = new JFormattedTextField(mascaraHora);
                        tDia6_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia6_saida2 = new JFormattedTextField(mascaraHora);
                        dia6.setBounds(10,240, 100, 20);
                        tDia6_entrada1.setBounds(75, 240, 60, 20);
                        tDia6_saida1.setBounds(145, 240, 60, 20);
                        tDia6_entrada2.setBounds(215, 240, 60, 20);
                        tDia6_saida2.setBounds(285, 240, 60, 20);
                        painel_controle.add(dia6);
                        painel_controle.add(tDia6_entrada1);
                        painel_controle.add(tDia6_saida1);
                        painel_controle.add(tDia6_entrada2);
                        painel_controle.add(tDia6_saida2);
                        
                         
                        dia7 = new JLabel("Dia 07: ");
                        tDia7_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia7_saida1 = new JFormattedTextField(mascaraHora);
                        tDia7_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia7_saida2 = new JFormattedTextField(mascaraHora);
                        dia7.setBounds(10,270, 100, 20);
                        tDia7_entrada1.setBounds(75, 270, 60, 20);
                        tDia7_saida1.setBounds(145, 270, 60, 20);
                        tDia7_entrada2.setBounds(215, 270, 60, 20);
                        tDia7_saida2.setBounds(285, 270, 60, 20);
                        painel_controle.add(dia7);
                        painel_controle.add(tDia7_entrada1);
                        painel_controle.add(tDia7_saida1);
                        painel_controle.add(tDia7_entrada2);
                        painel_controle.add(tDia7_saida2);
                        
                         
                        dia8 = new JLabel("Dia 08: ");
                        tDia8_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia8_saida1 = new JFormattedTextField(mascaraHora);
                        tDia8_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia8_saida2 = new JFormattedTextField(mascaraHora);
                        dia8.setBounds(10,300, 100, 20);
                        tDia8_entrada1.setBounds(75, 300, 60, 20);
                        tDia8_saida1.setBounds(145, 300, 60, 20);
                        tDia8_entrada2.setBounds(215, 300, 60, 20);
                        tDia8_saida2.setBounds(285, 300, 60, 20);
                        painel_controle.add(dia8);
                        painel_controle.add(tDia8_entrada1);
                        painel_controle.add(tDia8_saida1);
                        painel_controle.add(tDia8_entrada2);
                        painel_controle.add(tDia8_saida2);
                        
                         
                        dia9 = new JLabel("Dia 09: ");
                        tDia9_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia9_saida1 = new JFormattedTextField(mascaraHora);
                        tDia9_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia9_saida2 = new JFormattedTextField(mascaraHora);
                        dia9.setBounds(10,330, 100, 20);
                        tDia9_entrada1.setBounds(75, 330, 60, 20);
                        tDia9_saida1.setBounds(145, 330, 60, 20);
                        tDia9_entrada2.setBounds(215, 330, 60, 20);
                        tDia9_saida2.setBounds(285, 330, 60, 20);
                        painel_controle.add(dia9);
                        painel_controle.add(tDia9_entrada1);
                        painel_controle.add(tDia9_saida1);
                        painel_controle.add(tDia9_entrada2);
                        painel_controle.add(tDia9_saida2);
                        
                        dia10 = new JLabel("Dia 10: ");
                        tDia10_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia10_saida1 = new JFormattedTextField(mascaraHora);
                        tDia10_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia10_saida2 = new JFormattedTextField(mascaraHora);
                        dia10.setBounds(10,360, 100, 20);
                        tDia10_entrada1.setBounds(75, 360, 60, 20);
                        tDia10_saida1.setBounds(145, 360, 60, 20);
                        tDia10_entrada2.setBounds(215, 360, 60, 20);
                        tDia10_saida2.setBounds(285, 360, 60, 20);
                        painel_controle.add(dia10);
                        painel_controle.add(tDia10_entrada1);
                        painel_controle.add(tDia10_saida1);
                        painel_controle.add(tDia10_entrada2);
                        painel_controle.add(tDia10_saida2);
                        
                                      
                        dia11 = new JLabel("Dia 11: ");
                        tDia11_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia11_saida1 = new JFormattedTextField(mascaraHora);
                        tDia11_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia11_saida2 = new JFormattedTextField(mascaraHora);
                        dia11.setBounds(10,390, 100, 20);
                        tDia11_entrada1.setBounds(75, 390, 60, 20);
                        tDia11_saida1.setBounds(145, 390, 60, 20);
                        tDia11_entrada2.setBounds(215, 390, 60, 20);
                        tDia11_saida2.setBounds(285, 390, 60, 20);
                        painel_controle.add(dia11);
                        painel_controle.add(tDia11_entrada1);
                        painel_controle.add(tDia11_saida1);
                        painel_controle.add(tDia11_entrada2);
                        painel_controle.add(tDia11_saida2);
                        
                         
                        dia12 = new JLabel("Dia 12: ");
                        tDia12_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia12_saida1 = new JFormattedTextField(mascaraHora);
                        tDia12_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia12_saida2 = new JFormattedTextField(mascaraHora);
                        dia12.setBounds(10,420, 100, 20);
                        tDia12_entrada1.setBounds(75, 420, 60, 20);
                        tDia12_saida1.setBounds(145, 420, 60, 20);
                        tDia12_entrada2.setBounds(215, 420, 60, 20);
                        tDia12_saida2.setBounds(285, 420, 60, 20);
                        painel_controle.add(dia12);
                        painel_controle.add(tDia12_entrada1);
                        painel_controle.add(tDia12_saida1);
                        painel_controle.add(tDia12_entrada2);
                        painel_controle.add(tDia12_saida2);
                        
                         
                        dia13 = new JLabel("Dia 13: ");
                        tDia13_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia13_saida1 = new JFormattedTextField(mascaraHora);
                        tDia13_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia13_saida2 = new JFormattedTextField(mascaraHora);
                        dia13.setBounds(10,450, 100, 20);
                        tDia13_entrada1.setBounds(75, 450, 60, 20);
                        tDia13_saida1.setBounds(145, 450, 60, 20);
                        tDia13_entrada2.setBounds(215, 450, 60, 20);
                        tDia13_saida2.setBounds(285, 450, 60, 20);
                        painel_controle.add(dia13);
                        painel_controle.add(tDia13_entrada1);
                        painel_controle.add(tDia13_saida1);
                        painel_controle.add(tDia13_entrada2);
                        painel_controle.add(tDia13_saida2);
                        
                        
                         
                        dia14 = new JLabel("Dia 14: ");
                        tDia14_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia14_saida1 = new JFormattedTextField(mascaraHora);
                        tDia14_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia14_saida2 = new JFormattedTextField(mascaraHora);
                        dia14.setBounds(10,480, 100, 20);
                        tDia14_entrada1.setBounds(75,480, 60, 20);
                        tDia14_saida1.setBounds(145, 480, 60, 20);
                        tDia14_entrada2.setBounds(215, 480, 60, 20);
                        tDia14_saida2.setBounds(285, 480, 60, 20);
                        painel_controle.add(dia14);
                        painel_controle.add(tDia14_entrada1);
                        painel_controle.add(tDia14_saida1);
                        painel_controle.add(tDia14_entrada2);
                        painel_controle.add(tDia14_saida2);
                        
                         
                        dia15 = new JLabel("Dia 15: ");
                        tDia15_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia15_saida1 = new JFormattedTextField(mascaraHora);
                        tDia15_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia15_saida2 = new JFormattedTextField(mascaraHora);
                        dia15.setBounds(10,510, 100, 20);
                        tDia15_entrada1.setBounds(75, 510, 60, 20);
                        tDia15_saida1.setBounds(145, 510, 60, 20);
                        tDia15_entrada2.setBounds(215, 510, 60, 20);
                        tDia15_saida2.setBounds(285, 510, 60, 20);
                        painel_controle.add(dia15);
                        painel_controle.add(tDia15_entrada1);
                        painel_controle.add(tDia15_saida1);
                        painel_controle.add(tDia15_entrada2);
                        painel_controle.add(tDia15_saida2);
                         
                        dia16 = new JLabel("Dia 16: ");
                        tDia16_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia16_saida1 = new JFormattedTextField(mascaraHora);
                        tDia16_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia16_saida2 = new JFormattedTextField(mascaraHora);                        
                        dia16.setBounds(755,90, 100, 20);
                        tDia16_entrada1.setBounds(820, 90, 60, 20);
                        tDia16_saida1.setBounds(890, 90, 60, 20);
                        tDia16_entrada2.setBounds(960, 90, 60, 20);
                        tDia16_saida2.setBounds(1030, 90, 60, 20);
                        painel_controle.add(dia16);
                        painel_controle.add(tDia16_entrada1);
                        painel_controle.add(tDia16_saida1);
                        painel_controle.add(tDia16_entrada2);
                        painel_controle.add(tDia16_saida2);
                        
                         
                        dia17 = new JLabel("Dia 17: ");
                        tDia17_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia17_saida1 = new JFormattedTextField(mascaraHora);
                        tDia17_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia17_saida2 = new JFormattedTextField(mascaraHora);
                        dia17.setBounds(755,120, 100, 20);
                        tDia17_entrada1.setBounds(820,120, 60, 20);
                        tDia17_saida1.setBounds(890, 120, 60, 20);
                        tDia17_entrada2.setBounds(960, 120, 60, 20);
                        tDia17_saida2.setBounds(1030, 120, 60, 20);
                        painel_controle.add(dia17);
                        painel_controle.add(tDia17_entrada1);
                        painel_controle.add(tDia17_saida1);
                        painel_controle.add(tDia17_entrada2);
                        painel_controle.add(tDia17_saida2);
                        
                         
                        dia18 = new JLabel("Dia 18: ");
                        tDia18_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia18_saida1 = new JFormattedTextField(mascaraHora);
                        tDia18_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia18_saida2 = new JFormattedTextField(mascaraHora);
                        dia18.setBounds(755,150, 100, 20);
                        tDia18_entrada1.setBounds(820, 150, 60, 20);
                        tDia18_saida1.setBounds(890, 150, 60, 20);
                        tDia18_entrada2.setBounds(960, 150, 60, 20);
                        tDia18_saida2.setBounds(1030, 150, 60, 20);
                        painel_controle.add(dia18);
                        painel_controle.add(tDia18_entrada1);
                        painel_controle.add(tDia18_saida1);
                        painel_controle.add(tDia18_entrada2);
                        painel_controle.add(tDia18_saida2);
                        
                         
                        dia19 = new JLabel("Dia 19: ");
                        tDia19_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia19_saida1 = new JFormattedTextField(mascaraHora);
                        tDia19_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia19_saida2 = new JFormattedTextField(mascaraHora);
                        dia19.setBounds(755,180, 100, 20);
                        tDia19_entrada1.setBounds(820, 180, 60, 20);
                        tDia19_saida1.setBounds(890, 180, 60, 20);
                        tDia19_entrada2.setBounds(960, 180, 60, 20);
                        tDia19_saida2.setBounds(1030, 180, 60, 20);
                        painel_controle.add(dia19);
                        painel_controle.add(tDia19_entrada1);
                        painel_controle.add(tDia19_saida1);
                        painel_controle.add(tDia19_entrada2);
                        painel_controle.add(tDia19_saida2);
                        
                         
                        dia20 = new JLabel("Dia 20: ");
                        tDia20_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia20_saida1 = new JFormattedTextField(mascaraHora);
                        tDia20_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia20_saida2 = new JFormattedTextField(mascaraHora);
                        dia20.setBounds(755,210, 100, 20);
                        tDia20_entrada1.setBounds(820, 210, 60, 20);
                        tDia20_saida1.setBounds(890, 210, 60, 20);
                        tDia20_entrada2.setBounds(960, 210, 60, 20);
                        tDia20_saida2.setBounds(1030, 210, 60, 20);
                        painel_controle.add(dia20);
                        painel_controle.add(tDia20_entrada1);
                        painel_controle.add(tDia20_saida1);
                        painel_controle.add(tDia20_entrada2);
                        painel_controle.add(tDia20_saida2);
                        
                         
                        dia21 = new JLabel("Dia 21: ");
                        tDia21_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia21_saida1 = new JFormattedTextField(mascaraHora);
                        tDia21_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia21_saida2 = new JFormattedTextField(mascaraHora);
                        dia21.setBounds(755,240, 100, 20);
                        tDia21_entrada1.setBounds(820, 240, 60, 20);
                        tDia21_saida1.setBounds(890, 240, 60, 20);
                        tDia21_entrada2.setBounds(960, 240, 60, 20);
                        tDia21_saida2.setBounds(1030, 240, 60, 20);
                        painel_controle.add(dia21);
                        painel_controle.add(tDia21_entrada1);
                        painel_controle.add(tDia21_saida1);
                        painel_controle.add(tDia21_entrada2);
                        painel_controle.add(tDia21_saida2);
                        
                         
                        dia22 = new JLabel("Dia 22: ");
                        tDia22_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia22_saida1 = new JFormattedTextField(mascaraHora);
                        tDia22_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia22_saida2 = new JFormattedTextField(mascaraHora);
                        dia22.setBounds(755,270, 100, 20);
                        tDia22_entrada1.setBounds(820, 270, 60, 20);
                        tDia22_saida1.setBounds(890, 270, 60, 20);
                        tDia22_entrada2.setBounds(960, 270, 60, 20);
                        tDia22_saida2.setBounds(1030, 270, 60, 20);
                        painel_controle.add(dia22);
                        painel_controle.add(tDia22_entrada1);
                        painel_controle.add(tDia22_saida1);
                        painel_controle.add(tDia22_entrada2);
                        painel_controle.add(tDia22_saida2);
                        
                         
                        dia23 = new JLabel("Dia 23: ");
                        tDia23_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia23_saida1 = new JFormattedTextField(mascaraHora);
                        tDia23_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia23_saida2 = new JFormattedTextField(mascaraHora);
                        dia23.setBounds(755,300, 100, 20);
                        tDia23_entrada1.setBounds(820, 300, 60, 20);
                        tDia23_saida1.setBounds(890, 300, 60, 20);
                        tDia23_entrada2.setBounds(960, 300, 60, 20);
                        tDia23_saida2.setBounds(1030, 300, 60, 20);
                        painel_controle.add(dia23);
                        painel_controle.add(tDia23_entrada1);
                        painel_controle.add(tDia23_saida1);
                        painel_controle.add(tDia23_entrada2);
                        painel_controle.add(tDia23_saida2);
                        
                         
                        dia24 = new JLabel("Dia 24: ");
                        tDia24_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia24_saida1 = new JFormattedTextField(mascaraHora);
                        tDia24_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia24_saida2 = new JFormattedTextField(mascaraHora);
                        dia24.setBounds(755,330, 100, 20);
                        tDia24_entrada1.setBounds(820, 330, 60, 20);
                        tDia24_saida1.setBounds(890, 330, 60, 20);
                        tDia24_entrada2.setBounds(960, 330, 60, 20);
                        tDia24_saida2.setBounds(1030, 330, 60, 20);
                        painel_controle.add(dia24);
                        painel_controle.add(tDia24_entrada1);
                        painel_controle.add(tDia24_saida1);
                        painel_controle.add(tDia24_entrada2);
                        painel_controle.add(tDia24_saida2);
                        
                         
                        dia25 = new JLabel("Dia 25: ");
                        tDia25_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia25_saida1 = new JFormattedTextField(mascaraHora);
                        tDia25_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia25_saida2 = new JFormattedTextField(mascaraHora);
                        dia25.setBounds(755,360, 100, 20);
                        tDia25_entrada1.setBounds(820, 360, 60, 20);
                        tDia25_saida1.setBounds(890, 360, 60, 20);
                        tDia25_entrada2.setBounds(960, 360, 60, 20);
                        tDia25_saida2.setBounds(1030, 360, 60, 20);
                        painel_controle.add(dia25);
                        painel_controle.add(tDia25_entrada1);
                        painel_controle.add(tDia25_saida1);
                        painel_controle.add(tDia25_entrada2);
                        painel_controle.add(tDia25_saida2);
                         
                        dia26 = new JLabel("Dia 26: ");
                        tDia26_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia26_saida1 = new JFormattedTextField(mascaraHora);
                        tDia26_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia26_saida2 = new JFormattedTextField(mascaraHora);
                        dia26.setBounds(755,390, 100, 20);
                        tDia26_entrada1.setBounds(820, 390, 60, 20);
                        tDia26_saida1.setBounds(890, 390, 60, 20);
                        tDia26_entrada2.setBounds(960, 390, 60, 20);
                        tDia26_saida2.setBounds(1030, 390, 60, 20);
                        painel_controle.add(dia26);
                        painel_controle.add(tDia26_entrada1);
                        painel_controle.add(tDia26_saida1);
                        painel_controle.add(tDia26_entrada2);
                        painel_controle.add(tDia26_saida2);
                        
                         
                        dia27 = new JLabel("Dia 27: ");
                        tDia27_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia27_saida1 = new JFormattedTextField(mascaraHora);
                        tDia27_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia27_saida2 = new JFormattedTextField(mascaraHora);
                        dia27.setBounds(755,420, 100, 20);
                        tDia27_entrada1.setBounds(820, 420, 60, 20);
                        tDia27_saida1.setBounds(890, 420, 60, 20);
                        tDia27_entrada2.setBounds(960, 420, 60, 20);
                        tDia27_saida2.setBounds(1030, 420, 60, 20);
                        painel_controle.add(dia27);
                        painel_controle.add(tDia27_entrada1);
                        painel_controle.add(tDia27_saida1);
                        painel_controle.add(tDia27_entrada2);
                        painel_controle.add(tDia27_saida2);
                        
                         
                        dia28 = new JLabel("Dia 28: ");
                        tDia28_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia28_saida1 = new JFormattedTextField(mascaraHora);
                        tDia28_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia28_saida2 = new JFormattedTextField(mascaraHora);
                        dia28.setBounds(755,450, 100, 20);
                        tDia28_entrada1.setBounds(820, 450, 60, 20);
                        tDia28_saida1.setBounds(890, 450, 60, 20);
                        tDia28_entrada2.setBounds(960, 450, 60, 20);
                        tDia28_saida2.setBounds(1030, 450, 60, 20);
                        painel_controle.add(dia28);
                        painel_controle.add(tDia28_entrada1);
                        painel_controle.add(tDia28_saida1);
                        painel_controle.add(tDia28_entrada2);
                        painel_controle.add(tDia28_saida2);
                         
                        
                        dia29 = new JLabel("Dia 29: ");
                        tDia29_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia29_saida1 = new JFormattedTextField(mascaraHora);
                        tDia29_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia29_saida2 = new JFormattedTextField(mascaraHora);
                        dia29.setBounds(755,480, 100, 20);
                        tDia29_entrada1.setBounds(820, 480, 60, 20);
                        tDia29_saida1.setBounds(890, 480, 60, 20);
                        tDia29_entrada2.setBounds(960, 480, 60, 20);
                        tDia29_saida2.setBounds(1030, 480, 60, 20);
                        painel_controle.add(dia29);
                        painel_controle.add(tDia29_entrada1);
                        painel_controle.add(tDia29_saida1);
                        painel_controle.add(tDia29_entrada2);
                        painel_controle.add(tDia29_saida2);
                        
                         
                        dia30 = new JLabel("Dia 30: ");
                        tDia30_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia30_saida1 = new JFormattedTextField(mascaraHora);
                        tDia30_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia30_saida2 = new JFormattedTextField(mascaraHora);
                        dia30.setBounds(755,510, 100, 20);
                        tDia30_entrada1.setBounds(820, 510, 60, 20);
                        tDia30_saida1.setBounds(890, 510, 60, 20);
                        tDia30_entrada2.setBounds(960, 510, 60, 20);
                        tDia30_saida2.setBounds(1030, 510, 60, 20);
                        painel_controle.add(dia30);
                        painel_controle.add(tDia30_entrada1);
                        painel_controle.add(tDia30_saida1);
                        painel_controle.add(tDia30_entrada2);
                        painel_controle.add(tDia30_saida2);
                        
                        dia31 = new JLabel("Dia 31: ");
                        tDia31_entrada1 = new JFormattedTextField(mascaraHora);
                        tDia31_saida1 = new JFormattedTextField(mascaraHora);
                        tDia31_entrada2 = new JFormattedTextField(mascaraHora);
                        tDia31_saida2 = new JFormattedTextField(mascaraHora);
                        dia31.setBounds(755,540, 100, 20);
                        tDia31_entrada1.setBounds(820, 540, 60, 20);
                        tDia31_saida1.setBounds(890, 540, 60, 20);
                        tDia31_entrada2.setBounds(960, 540, 60, 20);
                        tDia31_saida2.setBounds(1030, 540, 60, 20);
                        painel_controle.add(dia31);
                        painel_controle.add(tDia31_entrada1);
                        painel_controle.add(tDia31_saida1);
                        painel_controle.add(tDia31_entrada2);
                        painel_controle.add(tDia31_saida2);
                        
                        
                                       
                        painel_controle.setBounds(50, 80, 1100, 650);
                        cadastrarFuncionario.setEnabled(true);
                        cadastrarFuncao.setEnabled(true);
                        cadastrarSetor.setEnabled(true);
                        consultarOperacao.setEnabled(true);
                        cadastrarHorario.setEnabled(true);
                        controle.setEnabled(false);
                        relatorio.setEnabled(true);
                        tela.add(painel_controle);
                        tela.revalidate();
                        tela.repaint();
                                            
            	}
            });
              
              relatorio.addActionListener(new ActionListener(){
                 @SuppressWarnings("empty-statement")
                  @Override
            	public void actionPerformed(ActionEvent e){
                     
                    try{  
                      
                    tela.remove(painel_funcao);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(painel_setor);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(painel_Horario);
                    }catch(NullPointerException npe){};
                    
                    
                    try{  
                      
                    tela.remove(painel_controle);
                    }catch(NullPointerException npe){};
                    
                     try{  
                      
                    tela.remove(painel_operacao);
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(painel_funcionario);
                    }catch(NullPointerException npe){};
                    
                    rfun = new RepositorioFuncionario();
                    String meses[]={"","Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
                    String anos[]={"","2012"};
                    
                    menu = new JToolBar("Barra de Ferramentas");
                    painel_relatorio = new JPanel();
                    painel_relatorio.setLayout(null);
                    painel_relatorio.setBackground(Color.LIGHT_GRAY);
                    painel_relatorio.setBorder(BorderFactory.createBevelBorder(1, Color.DARK_GRAY, Color.DARK_GRAY));
                  
                      
                    tMes_relatorio = new JComboBox(meses);
                    tMesFuncionario_relatorio = new JComboBox(meses);
                    tFuncionarioGeral_relatorio = new JComboBox(rfun.listarFuncionarios());
                    tFuncionario_relatorio = new JComboBox(rfun.listarFuncionarios());
                    tAno_relatorio = new JComboBox(anos);
                    tAnoFuncionario_relatorio = new JComboBox(anos);
                    
                    okGeral.setBounds(100, 100, 250, 20);
                    okGeralMes.setBounds(100, 130, 250, 20);
                    tMes_relatorio.setBounds(400, 130, 100, 20);
                    tAno_relatorio.setBounds(500, 130, 100, 20);
                    okGeralFuncionario.setBounds(100, 160, 250, 20);
                    tFuncionarioGeral_relatorio.setBounds(400, 160, 250, 20);
                    okFuncionarioMes.setBounds(100, 190, 250, 20);
                    tFuncionario_relatorio.setBounds(400, 190, 250, 20);
                    tMesFuncionario_relatorio.setBounds(700, 190, 100, 20);
                    tAnoFuncionario_relatorio.setBounds(800, 190, 100, 20);
                    
                    painel_relatorio.add(okGeral);
                    painel_relatorio.add(okGeralMes);
                    painel_relatorio.add(tMes_relatorio);
                    painel_relatorio.add(tAno_relatorio);
                    painel_relatorio.add(okGeralFuncionario);
                    painel_relatorio.add(tFuncionarioGeral_relatorio);
                    painel_relatorio.add(okFuncionarioMes);
                    painel_relatorio.add(tFuncionario_relatorio);
                    painel_relatorio.add(tMesFuncionario_relatorio);
                    painel_relatorio.add(tAnoFuncionario_relatorio);
                    painel_relatorio.add(sair_interno);
                    
                    
                    painel_relatorio.setBounds(50, 80, 1100, 650);
                    cadastrarFuncionario.setEnabled(true);
                    cadastrarFuncao.setEnabled(true);
                    cadastrarSetor.setEnabled(true);
                    consultarOperacao.setEnabled(true);
                    cadastrarHorario.setEnabled(true);
                    controle.setEnabled(true);
                    relatorio.setEnabled(false);
                    tela.add(painel_relatorio);
                    tela.revalidate();
                    tela.repaint();
          
                 }
             });

               sair.addActionListener(new ActionListener(){
                   @Override
            	public void actionPerformed(ActionEvent e){

                    int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?");
                    if(resposta==0){
                     
                        System.exit(0);   
                    }                    
            	}
            });
               
                         
               
                salvar_interno_funcionario.addActionListener(new ActionListener(){
                    @Override
            	public void actionPerformed(ActionEvent e){
                        
                        if(tNome_funcionario.getText().equals("")||tCpf.getText().equals("")|tFuncao.getSelectedItem().toString().equals("")|tSetor.getSelectedItem().toString().equals("")){
                           
                            JOptionPane.showMessageDialog(null,"Campos obrigatórios não preenchidos!!!");
                        }else{

                    int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente inserir esse funcionário?");
                    if(resposta==0){
                     
                        vector.removeAllElements();
                        String query = "";
                        String queryComeco = "INSERT INTO `bd_ultrapoint`.`dia` (`dia_mes`,`dia_semana`,`cod_funcionario`,`entrada1`,`saida1`,`entrada2`,`saida2`,`saldo`,`obs`,`status`) VALUES ";
                        String queryFim = "";
                        rfun = new RepositorioFuncionario();
                        Funcionario fu = new Funcionario();
                        fu.setNome(tNome_funcionario.getText());
                        fu.setCpf(tCpf.getText());
                        fu.setMatricula(tMatricula.getText());
                        fu.setFuncao(tFuncao.getSelectedItem().toString());
                        fu.setSetor(tSetor.getSelectedItem().toString());
                        rfun.adicionar(fu);
                        rd = new RepositorioDia();
                        data = Calendar.getInstance();
                        qtdDia = data.getActualMaximum(Calendar.DAY_OF_MONTH); 
                        Dia diaInicial = new Dia();
                        int dia,mes,ano;
                        
                        String data_hoje;
                        data = Calendar.getInstance();
                        dia = data.get(Calendar.DAY_OF_MONTH);
                        mes = data.get(Calendar.MONTH);
                        ano = data.get(Calendar.YEAR);
                        String cod_func = Integer.toString(rfun.consultarUltimo()); 
                        //JOptionPane.showMessageDialog(null, cod_func);
                        
                        for(int a = 1;a <= qtdDia; a++){
                             if( a<10 && mes<10){
                        
                            data_hoje = "0"+a+"/0"+(mes+1)+"/"+ano;
                        
                        }else
                            if(a<10 && mes >=10 ){
                                data_hoje = "0"+a+"/"+(mes+1)+"/"+ano;
                            }else
                                if(a>=10 && mes <10){
                                    data_hoje = a+"/0"+(mes+1)+"/"+ano;
                                }else{
                                    data_hoje = a+"/"+(mes+1)+"/"+ano;
                                }
                             
                           
                        diaInicial.setCod_func(cod_func);
                        //JOptionPane.showMessageDialog(null,data_hoje);
                        diaInicial.setDia_mes(paraInserirData(data_hoje));
                        diaInicial.setDia_semana(" ");
                        diaInicial.setEntrada1("00:00:00");
                        diaInicial.setSaida1("00:00:00");
                        diaInicial.setEntrada2("00:00:00");
                        diaInicial.setSaida2("00:00:00");
                        diaInicial.setSaldo("00:00:00");
                        diaInicial.setStatus("0");
                        diaInicial.setObs("Não Registrado");

                        vector.add(diaInicial);
                        //JOptionPane.showMessageDialog(null, vector.size());

                        queryFim = queryFim+"('"+vector.get(a-1).getDia_mes()+"','"+vector.get(a-1).getDia_semana()+"','"+vector.get(a-1).getCod_func()+"','"+vector.get(a-1).getEntrada1()+"','"+vector.get(a-1).getSaida1()+"','"+vector.get(a-1).getEntrada2()+"','"+vector.get(a-1).getSaida2()+"','"+vector.get(a-1).getSaldo()+"','"+vector.get(a-1).getObs()+"','"+vector.get(a-1).getStatus()+"'),";
                        //JOptionPane.showMessageDialog(null, queryFim);    
                        }
                        
                        query = queryComeco+queryFim;   
                        //System.out.println( query.substring(0,query.length()-2)+");");
                        rd.preencherMesZerado(vector,query.substring(0,query.length()-2)+");");
                        
                        tNome_funcionario.setText("");
                        tCpf.setText("");
                        tMatricula.setText("");
                        tFuncao.setSelectedIndex(0);
                        tSetor.setSelectedIndex(0);
                        painel_funcionario.remove(scroller);
                        alterar_interno_funcionario.setVisible(false);
                        salvar_interno_funcionario.setEnabled(true);
                        repaint();
                        
                                              
                    }         
                    }
            	}
            });
                
                limpar_interno_funcionario.addActionListener(new ActionListener(){
                    @Override
            	public void actionPerformed(ActionEvent e){

                   
                        tNome_funcionario.setText("");
                        tCpf.setText("");
                        tMatricula.setText("");
                        tFuncao.setSelectedIndex(0);
                        tSetor.setSelectedIndex(0);
                        painel_funcionario.remove(scroller);
                        alterar_interno_funcionario.setVisible(false);
                        salvar_interno_funcionario.setEnabled(true);
                        repaint();
                                   
                        }
                    
                 
            });
                excluir_interno_funcionario.addActionListener(new ActionListener(){
                    @Override
            	public void actionPerformed(ActionEvent e){
                   
                   try{
                        rfun = new RepositorioFuncionario();
                        int l = tabela.getSelectedRow();
                        DefaultTableModel dtm = (DefaultTableModel)tabela.getModel();
                        String cod = String.valueOf( dtm.getValueAt(l,0) ); 
                        
                    int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esse funcionário?");
                        if(resposta==0){
                            
                            
                            
                               
                            dtm.removeRow(l);
                         
                            rfun.excluir(cod);
                            repaint();
                                   
                        }
                     }catch(ArrayIndexOutOfBoundsException ae){
                         JOptionPane.showMessageDialog(null, "Selecione um registro!!");
                          
                      }
                    }
            });
                
                alterar_interno_funcionario.addActionListener(new ActionListener(){
                   @Override
            	public void actionPerformed(ActionEvent e){

                    int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente alterar esse funcionário?");
                    if(resposta==0){
                     
                        rfun = new RepositorioFuncionario();
                        Funcionario fu = new Funcionario();
                        fu.setNome(tNome_funcionario.getText());
                        fu.setCpf(tCpf.getText());
                        fu.setMatricula(tMatricula.getText());
                        fu.setFuncao(tFuncao.getSelectedItem().toString());
                        fu.setSetor(tSetor.getSelectedItem().toString());
                        rfun.alterar(tabela.getValueAt(tabela.getSelectedRow(), 0).toString(),fu);
                        
                        tNome_funcionario.setText("");
                        tCpf.setText("");
                        tMatricula.setText("");
                        tFuncao.setSelectedIndex(0);
                        tSetor.setSelectedIndex(0);
                        painel_funcionario.remove(scroller);
                        alterar_interno_funcionario.setVisible(false);
                        salvar_interno_funcionario.setEnabled(true);
                        repaint();
                    }                    
            	}
            });
               
               
                listar_interno_funcionario.addActionListener(new ActionListener(){
                    @Override
            	public void actionPerformed(ActionEvent e){

                    rfun = new RepositorioFuncionario();
                    tabela = rfun.consultatodos();                    
                       
                    scroller = new JScrollPane(tabela, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    painel_funcionario.add(scroller);
                    scroller.setBounds(20, 200, 1000, 300);
                    
                   
                     tabela.addMouseListener(new MouseAdapter() {  
                
                        public void mousePressed(MouseEvent e) {  

                           
                            tNome_funcionario.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());  
                            tMatricula.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
                            tCpf.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
                            tFuncao.setSelectedItem(tabela.getValueAt(tabela.getSelectedRow(), 4).toString());
                            tSetor.setSelectedItem(tabela.getValueAt(tabela.getSelectedRow(), 5).toString());
                            alterar_interno_funcionario.setVisible(true);
                            salvar_interno_funcionario.setEnabled(false);
                        }  
                        }); 
                    
                                   
                        }
                    
                 
            });
                
               salvar_interno_funcao.addActionListener(new ActionListener(){
                   @Override
            	public void actionPerformed(ActionEvent e){

                    int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente inserir essa função?");
                    if(resposta==0){
                     
                        rf = new RepositorioFuncao();
                        Funcao fu = new Funcao();
                        fu.setDescricao(tNome_funcao.getText());
                        rf.adicionar(fu);
                        tNome_funcao.setText("");
                    }                    
            	}
            });
               
               listar_interno_funcao.addActionListener(new ActionListener(){
                   @Override
            	public void actionPerformed(ActionEvent e){

                    rf = new RepositorioFuncao();
                    tabela = rf.consultatodos();                    
                       
                    scroller = new JScrollPane(tabela, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    painel_funcao.add(scroller);
                    scroller.setBounds(20, 200, 1000, 300);
                                   
                        }
                    
                 
            });
               
               excluir_interno_funcao.addActionListener(new ActionListener(){
                    @Override
            	public void actionPerformed(ActionEvent e){
                   
                   try{
                        rf = new RepositorioFuncao();
                        int l = tabela.getSelectedRow();
                        DefaultTableModel dtm = (DefaultTableModel)tabela.getModel();
                        String cod = String.valueOf( dtm.getValueAt(l,0) ); 
                        
                    int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir essa função?");
                        if(resposta==0){
                            
                            
                            
                               
                            dtm.removeRow(l);
                         
                            rf.excluir(cod);
                                   
                        }
                     }catch(ArrayIndexOutOfBoundsException ae){
                         JOptionPane.showMessageDialog(null, "Selecione um registro!!");
                          
                      }
                    }
            });
               
                limpar_interno_funcao.addActionListener(new ActionListener(){
                    @Override
            	public void actionPerformed(ActionEvent e){

                   tNome_funcao.setText("");
                                   
                        }
                    
                 
            });
               
               salvar_interno_setor.addActionListener(new ActionListener(){
                   @Override
            	public void actionPerformed(ActionEvent e){

                    int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente inserir esse setor?");
                    if(resposta==0){
                     
                        rs = new RepositorioSetor();
                        Setor se = new Setor();
                        se.setDescricao(tNome_setor.getText());
                        rs.adicionar(se);
                        tNome_setor.setText("");
                    }                    
            	}
            });
               
               listar_interno_setor.addActionListener(new ActionListener(){
                   @Override
            	public void actionPerformed(ActionEvent e){

                    rs = new RepositorioSetor();
                    tabela = rs.consultatodos();                    
                       
                    scroller = new JScrollPane(tabela, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    painel_setor.add(scroller);
                    scroller.setBounds(20, 200, 1000, 300);
                                   
                        }
                    
                 
            });
               
               limpar_interno_setor.addActionListener(new ActionListener(){
                   @Override
            	public void actionPerformed(ActionEvent e){

                  tNome_setor.setText("");
                                   
                        }
                    
                 
            });
               
               listar_interno_operacao.addActionListener(new ActionListener(){
                   @Override
            	public void actionPerformed(ActionEvent e){

                    rd = new RepositorioDia();
                    tabela = rd.consultarDia(paraInserirData(tDia.getText()));                  
                    scroller = new JScrollPane(tabela, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    painel_operacao.add(scroller);
                    scroller.setBounds(20, 200, 1000, 300);
                                   
                        }
                    
                 
            });
               
               excluir_interno_setor.addActionListener(new ActionListener(){
                    @Override
            	public void actionPerformed(ActionEvent e){
                   
                   try{
                        rs = new RepositorioSetor();
                        int l = tabela.getSelectedRow();
                        DefaultTableModel dtm = (DefaultTableModel)tabela.getModel();
                        String cod = String.valueOf( dtm.getValueAt(l,0) ); 
                        
                    int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esse setor?");
                        if(resposta==0){
                            
                            
                            
                               
                            dtm.removeRow(l);
                         
                            rs.excluir(cod);
                                   
                        }
                     }catch(ArrayIndexOutOfBoundsException ae){
                         JOptionPane.showMessageDialog(null, "Selecione um registro!!");
                          
                      }
                    }
            });
               
                limpar_interno_operacao.addActionListener(new ActionListener(){
                    @Override
            	public void actionPerformed(ActionEvent e){

                  tDia.setText("");
                                   
                        }
                    
                 
            });
               
               salvar_interno_horario.addActionListener(new ActionListener(){
                   @Override
            	public void actionPerformed(ActionEvent e){
                       
                int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente inserir esse horário?");
                       if(resposta==0){
                     
                        rh = new RepositorioHorario();
                        Horario hor = new Horario();
                        hor.setFuncao(tFuncaoH.getSelectedItem().toString());
                        hor.setSetor(tSetorH.getSelectedItem().toString());
                        hor.setEntrada1(tentrada1H.getText());
                        hor.setSaida1(tsaida1H.getText());
                        hor.setEntrada2(tentrada2H.getText());
                        hor.setSaida2(tsaida2H.getText());
                        
                        rh.adicionar(hor);
                        
                        tFuncaoH.setSelectedIndex(0);
                        tSetorH.setSelectedIndex(0);
                        tentrada1H.setText("");
                        tsaida1H.setText("");
                        tentrada2H.setText("");
                        tsaida2H.setText("");
                        
                       
                    }                    
            	}
            });
               
               limpar_interno_horario.addActionListener(new ActionListener(){
                   @Override
            	public void actionPerformed(ActionEvent e){

                   
                    tentrada1H.setText("");
                    tsaida1H.setText("");
                    tentrada2H.setText("");
                    tsaida2H.setText("");
                    tFuncaoH.setSelectedIndex(0);
                    tSetorH.setSelectedIndex(0);
                                   
                        }
                    
                 
            });
               
               listar_interno_horario.addActionListener(new ActionListener(){
                   @Override
            	public void actionPerformed(ActionEvent e){

                    rh = new RepositorioHorario();
                    tabela = rh.consultatodos();                    
                       
                    scroller = new JScrollPane(tabela, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    painel_Horario.add(scroller);
                    scroller.setBounds(20, 200, 1000, 300);
                                   
                        }
                    
                 
            });
                salvar_interno_controle.addActionListener(new ActionListener(){
                   @Override
            	public void actionPerformed(ActionEvent e){
                       
                      

                   int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente alterar esses horários?");
                    if(resposta==0){
                        Vector <Dia> vector = new Vector<Dia>();
                        rd = new RepositorioDia();
                        
                       
                        try{
                            Dia dia1 = new Dia();
                               dia1.setEntrada1(tDia1_entrada1.getText());
                               dia1.setSaida1(tDia1_saida1.getText());
                               dia1.setEntrada2(tDia1_entrada2.getText());
                               dia1.setSaida2(tDia1_saida2.getText());
                               dia1.setCod_dia(preencher.get(6).elementAt(0).toString());
                               vector.add(dia1);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia2 = new Dia();
                               dia2.setEntrada1(tDia2_entrada1.getText());
                               dia2.setSaida1(tDia2_saida1.getText());
                               dia2.setEntrada2(tDia2_entrada2.getText());
                               dia2.setSaida2(tDia2_saida2.getText());
                               dia2.setCod_dia(preencher.get(6).elementAt(1).toString());
                               vector.add(dia2);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia3 = new Dia();
                               dia3.setEntrada1(tDia3_entrada1.getText());
                               dia3.setSaida1(tDia3_saida1.getText());
                               dia3.setEntrada2(tDia3_entrada2.getText());
                               dia3.setSaida2(tDia3_saida2.getText());
                               dia3.setCod_dia(preencher.get(6).elementAt(2).toString());
                               vector.add(dia3);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia4 = new Dia();
                               dia4.setEntrada1(tDia4_entrada1.getText());
                               dia4.setSaida1(tDia4_saida1.getText());
                               dia4.setEntrada2(tDia4_entrada2.getText());
                               dia4.setSaida2(tDia4_saida2.getText());
                               dia4.setCod_dia(preencher.get(6).elementAt(3).toString());
                               vector.add(dia4);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia5 = new Dia();
                               dia5.setEntrada1(tDia5_entrada1.getText());
                               dia5.setSaida1(tDia5_saida1.getText());
                               dia5.setEntrada2(tDia5_entrada2.getText());
                               dia5.setSaida2(tDia5_saida2.getText());
                               dia5.setCod_dia(preencher.get(6).elementAt(4).toString());
                               vector.add(dia5);

                        }catch(StringIndexOutOfBoundsException siobe){};
                         try{
                            Dia dia6 = new Dia();
                               dia6.setEntrada1(tDia6_entrada1.getText());
                               dia6.setSaida1(tDia6_saida1.getText());
                               dia6.setEntrada2(tDia6_entrada2.getText());
                               dia6.setSaida2(tDia6_saida2.getText());
                               dia6.setCod_dia(preencher.get(6).elementAt(5).toString());
                               vector.add(dia6);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        
                        try{
                            Dia dia7 = new Dia();
                               dia7.setEntrada1(tDia7_entrada1.getText());
                               dia7.setSaida1(tDia7_saida1.getText());
                               dia7.setEntrada2(tDia7_entrada2.getText());
                               dia7.setSaida2(tDia7_saida2.getText());
                               dia7.setCod_dia(preencher.get(6).elementAt(6).toString());
                               vector.add(dia7);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia8 = new Dia();
                               dia8.setEntrada1(tDia8_entrada1.getText());
                               dia8.setSaida1(tDia8_saida1.getText());
                               dia8.setEntrada2(tDia8_entrada2.getText());
                               dia8.setSaida2(tDia8_saida2.getText());
                               dia8.setCod_dia(preencher.get(6).elementAt(7).toString());
                               vector.add(dia8);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia9 = new Dia();
                               dia9.setEntrada1(tDia9_entrada1.getText());
                               dia9.setSaida1(tDia9_saida1.getText());
                               dia9.setEntrada2(tDia9_entrada2.getText());
                               dia9.setSaida2(tDia9_saida2.getText());
                               dia9.setCod_dia(preencher.get(6).elementAt(8).toString());
                               vector.add(dia9);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia10 = new Dia();
                               dia10.setEntrada1(tDia10_entrada1.getText());
                               dia10.setSaida1(tDia10_saida1.getText());
                               dia10.setEntrada2(tDia10_entrada2.getText());
                               dia10.setSaida2(tDia10_saida2.getText());
                               dia10.setCod_dia(preencher.get(6).elementAt(9).toString());
                               vector.add(dia10);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia11 = new Dia();
                               dia11.setEntrada1(tDia11_entrada1.getText());
                               dia11.setSaida1(tDia11_saida1.getText());
                               dia11.setEntrada2(tDia11_entrada2.getText());
                               dia11.setSaida2(tDia11_saida2.getText());
                               dia11.setCod_dia(preencher.get(6).elementAt(10).toString());
                               vector.add(dia11);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia12 = new Dia();
                               dia12.setEntrada1(tDia12_entrada1.getText());
                               dia12.setSaida1(tDia12_saida1.getText());
                               dia12.setEntrada2(tDia12_entrada2.getText());
                               dia12.setSaida2(tDia12_saida2.getText());
                               dia12.setCod_dia(preencher.get(6).elementAt(11).toString());
                               vector.add(dia12);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia13 = new Dia();
                               dia13.setEntrada1(tDia13_entrada1.getText());
                               dia13.setSaida1(tDia13_saida1.getText());
                               dia13.setEntrada2(tDia13_entrada2.getText());
                               dia13.setSaida2(tDia13_saida2.getText());
                               dia13.setCod_dia(preencher.get(6).elementAt(12).toString());
                               vector.add(dia13);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia14 = new Dia();
                               dia14.setEntrada1(tDia14_entrada1.getText());
                               dia14.setSaida1(tDia14_saida1.getText());
                               dia14.setEntrada2(tDia14_entrada2.getText());
                               dia14.setSaida2(tDia14_saida2.getText());
                               dia14.setCod_dia(preencher.get(6).elementAt(13).toString());
                               vector.add(dia14);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia15 = new Dia();
                               dia15.setEntrada1(tDia15_entrada1.getText());
                               dia15.setSaida1(tDia15_saida1.getText());
                               dia15.setEntrada2(tDia15_entrada2.getText());
                               dia15.setSaida2(tDia15_saida2.getText());
                               dia15.setCod_dia(preencher.get(6).elementAt(14).toString());
                               vector.add(dia15);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia16 = new Dia();
                               dia16.setEntrada1(tDia16_entrada1.getText());
                               dia16.setSaida1(tDia16_saida1.getText());
                               dia16.setEntrada2(tDia16_entrada2.getText());
                               dia16.setSaida2(tDia16_saida2.getText());
                               dia16.setCod_dia(preencher.get(6).elementAt(15).toString());
                               vector.add(dia16);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia17 = new Dia();
                               dia17.setEntrada1(tDia17_entrada1.getText());
                               dia17.setSaida1(tDia17_saida1.getText());
                               dia17.setEntrada2(tDia17_entrada2.getText());
                               dia17.setSaida2(tDia17_saida2.getText());
                               dia17.setCod_dia(preencher.get(6).elementAt(16).toString());
                               vector.add(dia17);

                        }catch(StringIndexOutOfBoundsException siobe){};
                         try{
                            Dia dia18 = new Dia();
                               dia18.setEntrada1(tDia18_entrada1.getText());
                               dia18.setSaida1(tDia18_saida1.getText());
                               dia18.setEntrada2(tDia18_entrada2.getText());
                               dia18.setSaida2(tDia18_saida2.getText());
                               dia18.setCod_dia(preencher.get(6).elementAt(17).toString());
                               vector.add(dia18);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia19 = new Dia();
                               dia19.setEntrada1(tDia19_entrada1.getText());
                               dia19.setSaida1(tDia19_saida1.getText());
                               dia19.setEntrada2(tDia19_entrada2.getText());
                               dia19.setSaida2(tDia19_saida2.getText());
                               dia19.setCod_dia(preencher.get(6).elementAt(18).toString());
                               vector.add(dia19);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia20 = new Dia();
                               dia20.setEntrada1(tDia20_entrada1.getText());
                               dia20.setSaida1(tDia20_saida1.getText());
                               dia20.setEntrada2(tDia20_entrada2.getText());
                               dia20.setSaida2(tDia20_saida2.getText());
                               dia20.setCod_dia(preencher.get(6).elementAt(19).toString());
                               vector.add(dia20);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia21 = new Dia();
                               dia21.setEntrada1(tDia21_entrada1.getText());
                               dia21.setSaida1(tDia21_saida1.getText());
                               dia21.setEntrada2(tDia21_entrada2.getText());
                               dia21.setSaida2(tDia21_saida2.getText());
                               dia21.setCod_dia(preencher.get(6).elementAt(20).toString());
                               vector.add(dia21);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia22 = new Dia();
                               dia22.setEntrada1(tDia22_entrada1.getText());
                               dia22.setSaida1(tDia22_saida1.getText());
                               dia22.setEntrada2(tDia22_entrada2.getText());
                               dia22.setSaida2(tDia22_saida2.getText());
                               dia22.setCod_dia(preencher.get(6).elementAt(21).toString());
                               vector.add(dia22);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia23 = new Dia();
                               dia23.setEntrada1(tDia23_entrada1.getText());
                               dia23.setSaida1(tDia23_saida1.getText());
                               dia23.setEntrada2(tDia23_entrada2.getText());
                               dia23.setSaida2(tDia23_saida2.getText());
                               dia23.setCod_dia(preencher.get(6).elementAt(22).toString());
                               vector.add(dia23);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia24 = new Dia();
                               dia24.setEntrada1(tDia24_entrada1.getText());
                               dia24.setSaida1(tDia24_saida1.getText());
                               dia24.setEntrada2(tDia24_entrada2.getText());
                               dia24.setSaida2(tDia24_saida2.getText());
                               dia24.setCod_dia(preencher.get(6).elementAt(23).toString());
                               vector.add(dia24);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia25 = new Dia();
                               dia25.setEntrada1(tDia25_entrada1.getText());
                               dia25.setSaida1(tDia25_saida1.getText());
                               dia25.setEntrada2(tDia25_entrada2.getText());
                               dia25.setSaida2(tDia25_saida2.getText());
                               dia25.setCod_dia(preencher.get(6).elementAt(24).toString());
                               vector.add(dia25);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia26 = new Dia();
                               dia26.setEntrada1(tDia26_entrada1.getText());
                               dia26.setSaida1(tDia26_saida1.getText());
                               dia26.setEntrada2(tDia26_entrada2.getText());
                               dia26.setSaida2(tDia26_saida2.getText());
                               dia26.setCod_dia(preencher.get(6).elementAt(25).toString());
                               vector.add(dia26);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia27 = new Dia();
                               dia27.setEntrada1(tDia27_entrada1.getText());
                               dia27.setSaida1(tDia27_saida1.getText());
                               dia27.setEntrada2(tDia27_entrada2.getText());
                               dia27.setSaida2(tDia27_saida2.getText());
                               dia27.setCod_dia(preencher.get(6).elementAt(26).toString());
                               vector.add(dia27);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia28 = new Dia();
                               dia28.setEntrada1(tDia28_entrada1.getText());
                               dia28.setSaida1(tDia28_saida1.getText());
                               dia28.setEntrada2(tDia28_entrada2.getText());
                               dia28.setSaida2(tDia28_saida2.getText());
                               dia28.setCod_dia(preencher.get(6).elementAt(27).toString());
                               vector.add(dia28);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia29 = new Dia();
                               dia29.setEntrada1(tDia29_entrada1.getText());
                               dia29.setSaida1(tDia29_saida1.getText());
                               dia29.setEntrada2(tDia29_entrada2.getText());
                               dia29.setSaida2(tDia29_saida2.getText());
                               dia29.setCod_dia(preencher.get(6).elementAt(28).toString());
                               vector.add(dia29);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia30 = new Dia();
                               dia30.setEntrada1(tDia30_entrada1.getText());
                               dia30.setSaida1(tDia30_saida1.getText());
                               dia30.setEntrada2(tDia30_entrada2.getText());
                               dia30.setSaida2(tDia30_saida2.getText());
                               dia30.setCod_dia(preencher.get(6).elementAt(29).toString());
                               vector.add(dia30);

                        }catch(StringIndexOutOfBoundsException siobe){};
                        try{
                            Dia dia31 = new Dia();
                               dia31.setEntrada1(tDia31_entrada1.getText());
                               dia31.setSaida1(tDia31_saida1.getText());
                               dia31.setEntrada2(tDia31_entrada2.getText());
                               dia31.setSaida2(tDia31_saida2.getText());
                               dia31.setCod_dia(preencher.get(6).elementAt(30).toString());
                               vector.add(dia31);

                        }catch(Exception eu){};
                        
                       rd.alterarMes(vector);
                  
                    }  
                       

                    
                                   
                        }
                    
                 
            });
                 limpar_interno_controle.addActionListener(new ActionListener(){
                   @Override
            	public void actionPerformed(ActionEvent e){

                  
                                   
                        }
                    
                 
            });
                  listar_interno_controle.addActionListener(new ActionListener(){
                   @Override
            	public void actionPerformed(ActionEvent e){
                       
                       limparTudoControle();
                       rd = new RepositorioDia();
                       String data_ini;
                       String data_fim;
                       String data_iniForm;
                       String data_fimForm;
                       data_ini = dataInicioMes(tMes_controle.getSelectedItem().toString());
                       data_fim = dataFimMes(tMes_controle.getSelectedItem().toString());
                       
                       data_iniForm = data_ini+"/"+tAno_controle.getSelectedItem().toString();
                       data_fimForm = data_fim+"/"+tAno_controle.getSelectedItem().toString();
                       
                       
                       preencher = rd.consultarMes(tNome_controle.getSelectedItem().toString(), paraInserirData(data_iniForm), paraInserirData(data_fimForm));
                       
                       try{
                       dia1.setText(paraRecuperarData(preencher.get(1).elementAt(0).toString()));
                       tDia1_entrada1.setText(preencher.get(2).elementAt(0).toString());
                       tDia1_saida1.setText(preencher.get(3).elementAt(0).toString());
                       tDia1_entrada2.setText(preencher.get(4).elementAt(0).toString());
                       tDia1_saida2.setText(preencher.get(5).elementAt(0).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                              
                       try{
                       dia2.setText(paraRecuperarData(preencher.get(1).elementAt(1).toString()));
                       tDia2_entrada1.setText(preencher.get(2).elementAt(1).toString());
                       tDia2_saida1.setText(preencher.get(3).elementAt(1).toString());
                       tDia2_entrada2.setText(preencher.get(4).elementAt(1).toString());
                       tDia2_saida2.setText(preencher.get(5).elementAt(1).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia3.setText(paraRecuperarData(preencher.get(1).elementAt(2).toString()));
                       tDia3_entrada1.setText(preencher.get(2).elementAt(2).toString());
                       tDia3_saida1.setText(preencher.get(3).elementAt(2).toString());
                       tDia3_entrada2.setText(preencher.get(4).elementAt(2).toString());
                       tDia3_saida2.setText(preencher.get(5).elementAt(2).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia4.setText(paraRecuperarData(preencher.get(1).elementAt(3).toString()));
                       tDia4_entrada1.setText(preencher.get(2).elementAt(3).toString());
                       tDia4_saida1.setText(preencher.get(3).elementAt(3).toString());
                       tDia4_entrada2.setText(preencher.get(4).elementAt(3).toString());
                       tDia4_saida2.setText(preencher.get(5).elementAt(3).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia5.setText(paraRecuperarData(preencher.get(1).elementAt(4).toString()));
                       tDia5_entrada1.setText(preencher.get(2).elementAt(4).toString());
                       tDia5_saida1.setText(preencher.get(3).elementAt(4).toString());
                       tDia5_entrada2.setText(preencher.get(4).elementAt(4).toString());
                       tDia5_saida2.setText(preencher.get(5).elementAt(4).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia6.setText(paraRecuperarData(preencher.get(1).elementAt(5).toString()));
                       tDia6_entrada1.setText(preencher.get(2).elementAt(5).toString());
                       tDia6_saida1.setText(preencher.get(3).elementAt(5).toString());
                       tDia6_entrada2.setText(preencher.get(4).elementAt(5).toString());
                       tDia6_saida2.setText(preencher.get(5).elementAt(5).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia7.setText(paraRecuperarData(preencher.get(1).elementAt(6).toString()));
                       tDia7_entrada1.setText(preencher.get(2).elementAt(6).toString());
                       tDia7_saida1.setText(preencher.get(3).elementAt(6).toString());
                       tDia7_entrada2.setText(preencher.get(4).elementAt(6).toString());
                       tDia7_saida2.setText(preencher.get(5).elementAt(6).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia8.setText(paraRecuperarData(preencher.get(1).elementAt(7).toString()));
                       tDia8_entrada1.setText(preencher.get(2).elementAt(7).toString());
                       tDia8_saida1.setText(preencher.get(3).elementAt(7).toString());
                       tDia8_entrada2.setText(preencher.get(4).elementAt(7).toString());
                       tDia8_saida2.setText(preencher.get(5).elementAt(7).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia9.setText(paraRecuperarData(preencher.get(1).elementAt(8).toString()));
                       tDia9_entrada1.setText(preencher.get(2).elementAt(8).toString());
                       tDia9_saida1.setText(preencher.get(3).elementAt(8).toString());
                       tDia9_entrada2.setText(preencher.get(4).elementAt(8).toString());
                       tDia9_saida2.setText(preencher.get(5).elementAt(8).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia10.setText(paraRecuperarData(preencher.get(1).elementAt(9).toString()));
                       tDia10_entrada1.setText(preencher.get(2).elementAt(9).toString());
                       tDia10_saida1.setText(preencher.get(3).elementAt(9).toString());
                       tDia10_entrada2.setText(preencher.get(4).elementAt(9).toString());
                       tDia10_saida2.setText(preencher.get(5).elementAt(9).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia11.setText(paraRecuperarData(preencher.get(1).elementAt(10).toString()));
                       tDia11_entrada1.setText(preencher.get(2).elementAt(10).toString());
                       tDia11_saida1.setText(preencher.get(3).elementAt(10).toString());
                       tDia11_entrada2.setText(preencher.get(4).elementAt(10).toString());
                       tDia11_saida2.setText(preencher.get(5).elementAt(10).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia12.setText(paraRecuperarData(preencher.get(1).elementAt(11).toString()));
                       tDia12_entrada1.setText(preencher.get(2).elementAt(11).toString());
                       tDia12_saida1.setText(preencher.get(3).elementAt(11).toString());
                       tDia12_entrada2.setText(preencher.get(4).elementAt(11).toString());
                       tDia12_saida2.setText(preencher.get(5).elementAt(11).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia13.setText(paraRecuperarData(preencher.get(1).elementAt(12).toString()));
                       tDia13_entrada1.setText(preencher.get(2).elementAt(12).toString());
                       tDia13_saida1.setText(preencher.get(3).elementAt(12).toString());
                       tDia13_entrada2.setText(preencher.get(4).elementAt(12).toString());
                       tDia13_saida2.setText(preencher.get(5).elementAt(12).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia14.setText(paraRecuperarData(preencher.get(1).elementAt(13).toString()));
                       tDia14_entrada1.setText(preencher.get(2).elementAt(13).toString());
                       tDia14_saida1.setText(preencher.get(3).elementAt(13).toString());
                       tDia14_entrada2.setText(preencher.get(4).elementAt(13).toString());
                       tDia14_saida2.setText(preencher.get(5).elementAt(13).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia15.setText(paraRecuperarData(preencher.get(1).elementAt(14).toString()));
                       tDia15_entrada1.setText(preencher.get(2).elementAt(14).toString());
                       tDia15_saida1.setText(preencher.get(3).elementAt(14).toString());
                       tDia15_entrada2.setText(preencher.get(4).elementAt(14).toString());
                       tDia15_saida2.setText(preencher.get(5).elementAt(14).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia16.setText(paraRecuperarData(preencher.get(1).elementAt(15).toString()));
                       tDia16_entrada1.setText(preencher.get(2).elementAt(15).toString());
                       tDia16_saida1.setText(preencher.get(3).elementAt(15).toString());
                       tDia16_entrada2.setText(preencher.get(4).elementAt(15).toString());
                       tDia16_saida2.setText(preencher.get(5).elementAt(15).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia17.setText(paraRecuperarData(preencher.get(1).elementAt(16).toString()));
                       tDia17_entrada1.setText(preencher.get(2).elementAt(16).toString());
                       tDia17_saida1.setText(preencher.get(3).elementAt(16).toString());
                       tDia17_entrada2.setText(preencher.get(4).elementAt(16).toString());
                       tDia17_saida2.setText(preencher.get(5).elementAt(16).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia18.setText(paraRecuperarData(preencher.get(1).elementAt(17).toString()));
                       tDia18_entrada1.setText(preencher.get(2).elementAt(17).toString());
                       tDia18_saida1.setText(preencher.get(3).elementAt(17).toString());
                       tDia18_entrada2.setText(preencher.get(4).elementAt(17).toString());
                       tDia18_saida2.setText(preencher.get(5).elementAt(17).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia19.setText(paraRecuperarData(preencher.get(1).elementAt(18).toString()));
                       tDia19_entrada1.setText(preencher.get(2).elementAt(18).toString());
                       tDia19_saida1.setText(preencher.get(3).elementAt(18).toString());
                       tDia19_entrada2.setText(preencher.get(4).elementAt(18).toString());
                       tDia19_saida2.setText(preencher.get(5).elementAt(18).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia20.setText(paraRecuperarData(preencher.get(1).elementAt(19).toString()));
                       tDia20_entrada1.setText(preencher.get(2).elementAt(19).toString());
                       tDia20_saida1.setText(preencher.get(3).elementAt(19).toString());
                       tDia20_entrada2.setText(preencher.get(4).elementAt(19).toString());
                       tDia20_saida2.setText(preencher.get(5).elementAt(19).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia21.setText(paraRecuperarData(preencher.get(1).elementAt(20).toString()));
                       tDia21_entrada1.setText(preencher.get(2).elementAt(20).toString());
                       tDia21_saida1.setText(preencher.get(3).elementAt(20).toString());
                       tDia21_entrada2.setText(preencher.get(4).elementAt(20).toString());
                       tDia21_saida2.setText(preencher.get(5).elementAt(20).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia22.setText(paraRecuperarData(preencher.get(1).elementAt(21).toString()));
                       tDia22_entrada1.setText(preencher.get(2).elementAt(21).toString());
                       tDia22_saida1.setText(preencher.get(3).elementAt(21).toString());
                       tDia22_entrada2.setText(preencher.get(4).elementAt(21).toString());
                       tDia22_saida2.setText(preencher.get(5).elementAt(21).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia23.setText(paraRecuperarData(preencher.get(1).elementAt(22).toString()));
                       tDia23_entrada1.setText(preencher.get(2).elementAt(22).toString());
                       tDia23_saida1.setText(preencher.get(3).elementAt(22).toString());
                       tDia23_entrada2.setText(preencher.get(4).elementAt(22).toString());
                       tDia23_saida2.setText(preencher.get(5).elementAt(22).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia24.setText(paraRecuperarData(preencher.get(1).elementAt(23).toString()));
                       tDia24_entrada1.setText(preencher.get(2).elementAt(23).toString());
                       tDia24_saida1.setText(preencher.get(3).elementAt(23).toString());
                       tDia24_entrada2.setText(preencher.get(4).elementAt(23).toString());
                       tDia24_saida2.setText(preencher.get(5).elementAt(23).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia25.setText(paraRecuperarData(preencher.get(1).elementAt(24).toString()));
                       tDia25_entrada1.setText(preencher.get(2).elementAt(24).toString());
                       tDia25_saida1.setText(preencher.get(3).elementAt(24).toString());
                       tDia25_entrada2.setText(preencher.get(4).elementAt(24).toString());
                       tDia25_saida2.setText(preencher.get(5).elementAt(24).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia26.setText(paraRecuperarData(preencher.get(1).elementAt(25).toString()));
                       tDia26_entrada1.setText(preencher.get(2).elementAt(25).toString());
                       tDia26_saida1.setText(preencher.get(3).elementAt(25).toString());
                       tDia26_entrada2.setText(preencher.get(4).elementAt(25).toString());
                       tDia26_saida2.setText(preencher.get(5).elementAt(25).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia27.setText(paraRecuperarData(preencher.get(1).elementAt(26).toString()));
                       tDia27_entrada1.setText(preencher.get(2).elementAt(26).toString());
                       tDia27_saida1.setText(preencher.get(3).elementAt(26).toString());
                       tDia27_entrada2.setText(preencher.get(4).elementAt(26).toString());
                       tDia27_saida2.setText(preencher.get(5).elementAt(26).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia28.setText(paraRecuperarData(preencher.get(1).elementAt(27).toString()));
                       tDia28_entrada1.setText(preencher.get(2).elementAt(27).toString());
                       tDia28_saida1.setText(preencher.get(3).elementAt(27).toString());
                       tDia28_entrada2.setText(preencher.get(4).elementAt(27).toString());
                       tDia28_saida2.setText(preencher.get(5).elementAt(27).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia29.setText(paraRecuperarData(preencher.get(1).elementAt(28).toString()));
                       tDia29_entrada1.setText(preencher.get(2).elementAt(28).toString());
                       tDia29_saida1.setText(preencher.get(3).elementAt(28).toString());
                       tDia29_entrada2.setText(preencher.get(4).elementAt(28).toString());
                       tDia29_saida2.setText(preencher.get(5).elementAt(28).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia30.setText(paraRecuperarData(preencher.get(1).elementAt(29).toString()));
                       tDia30_entrada1.setText(preencher.get(2).elementAt(29).toString());
                       tDia30_saida1.setText(preencher.get(3).elementAt(29).toString());
                       tDia30_entrada2.setText(preencher.get(4).elementAt(29).toString());
                       tDia30_saida2.setText(preencher.get(5).elementAt(29).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia31.setText(paraRecuperarData(preencher.get(1).elementAt(30).toString()));
                       tDia31_entrada1.setText(preencher.get(2).elementAt(30).toString());
                       tDia31_saida1.setText(preencher.get(3).elementAt(30).toString());
                       tDia31_entrada2.setText(preencher.get(4).elementAt(30).toString());
                       tDia31_saida2.setText(preencher.get(5).elementAt(30).toString());
                       }catch(IndexOutOfBoundsException iobe){};
                                   
                        }
                    
                 
            });
               
                  okGeral.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){

                           JasperPrint rel = null;
                           
                     try{

                       AccessDatabase a = new AccessDatabase();
                       Connection con = a.conectar();
                       HashMap map = new HashMap();
                       Statement st = con.createStatement();
                       String query = "Select * from `bd_ultrapoint`.`dia`";
                       ResultSet rs = st.executeQuery( query );
                       JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
                       String arquivoJasper = "Relatorios//Geral.jasper";
                       rel = JasperFillManager.fillReport(arquivoJasper, map, jrRS);
                       
                       JasperViewer.viewReport(rel, false);
                       con.close();

                                       }catch(Exception t){
                                               System.out.println(t.getMessage());
                               }
                     
                    tMes_relatorio.setSelectedIndex(0);
                    tMesFuncionario_relatorio.setSelectedIndex(0);
                    tFuncionarioGeral_relatorio.setSelectedIndex(0);
                    tFuncionario_relatorio.setSelectedIndex(0);
                    tAno_relatorio.setSelectedIndex(0);
                    tAnoFuncionario_relatorio.setSelectedIndex(0);

                  }});
                  
                  okGeralMes.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){

                           JasperPrint rel = null;
                           
                           String data_ini;
                           String data_fim;
                           String data_iniForm;
                           String data_fimForm;
                           data_ini = dataInicioMes(tMes_relatorio.getSelectedItem().toString());
                           data_fim = dataFimMes(tMes_relatorio.getSelectedItem().toString());

                           data_iniForm = data_ini+"/"+tAno_relatorio.getSelectedItem().toString();
                           data_fimForm = data_fim+"/"+tAno_relatorio.getSelectedItem().toString();
                     try{

                       AccessDatabase a = new AccessDatabase();
                       Connection con = a.conectar();
                       HashMap map = new HashMap();
                       Statement st = con.createStatement();
                       String query = "Select * from `bd_ultrapoint`.`dia` where `dia_mes` between '"+paraInserirData(data_iniForm)+"' and '"+paraInserirData(data_fimForm)+"'";
                       ResultSet rs = st.executeQuery( query );
                       JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
                       String arquivoJasper = "Relatorios//GeralMes.jasper";
                       rel = JasperFillManager.fillReport(arquivoJasper, map, jrRS);
                       
                       JasperViewer.viewReport(rel, false);
                       con.close();

                                       }catch(Exception t){
                                               System.out.println(t.getMessage());
                               }
                     
                    tMes_relatorio.setSelectedIndex(0);
                    tMesFuncionario_relatorio.setSelectedIndex(0);
                    tFuncionarioGeral_relatorio.setSelectedIndex(0);
                    tFuncionario_relatorio.setSelectedIndex(0);
                    tAno_relatorio.setSelectedIndex(0);
                    tAnoFuncionario_relatorio.setSelectedIndex(0);

                  }});
                  
                  okGeralFuncionario.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){

                           JasperPrint rel = null;
                     try{

                       AccessDatabase a = new AccessDatabase();
                       Connection con = a.conectar();
                       HashMap map = new HashMap();
                       Statement st = con.createStatement();
                       String query = "Select * from `bd_ultrapoint`.`dia` where `cod_funcionario`='"+tFuncionarioGeral_relatorio.getSelectedItem().toString()+"'";
                       ResultSet rs = st.executeQuery( query );
                       JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
                       String arquivoJasper = "Relatorios//GeralFuncionario.jasper";
                       rel = JasperFillManager.fillReport(arquivoJasper, map, jrRS);
                       
                       JasperViewer.viewReport(rel, false);
                       con.close();

                                       }catch(Exception t){
                                               System.out.println(t.getMessage());
                               }

                    tMes_relatorio.setSelectedIndex(0);
                    tMesFuncionario_relatorio.setSelectedIndex(0);
                    tFuncionarioGeral_relatorio.setSelectedIndex(0);
                    tFuncionario_relatorio.setSelectedIndex(0);
                    tAno_relatorio.setSelectedIndex(0);
                    tAnoFuncionario_relatorio.setSelectedIndex(0);
                     
                  }});
                  
                  okFuncionarioMes.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){

                           JasperPrint rel = null;
                           String data_ini;
                           String data_fim;
                           String data_iniForm;
                           String data_fimForm;
                           data_ini = dataInicioMes(tMesFuncionario_relatorio.getSelectedItem().toString());
                           data_fim = dataFimMes(tMesFuncionario_relatorio.getSelectedItem().toString());

                           data_iniForm = data_ini+"/"+tAnoFuncionario_relatorio.getSelectedItem().toString();
                           data_fimForm = data_fim+"/"+tAnoFuncionario_relatorio.getSelectedItem().toString();
                     try{

                       AccessDatabase a = new AccessDatabase();
                       Connection con = a.conectar();
                       HashMap map = new HashMap();
                       Statement st = con.createStatement();
                       String query = "Select * from `bd_ultrapoint`.`dia` where `cod_funcionario`='"+tFuncionario_relatorio.getSelectedItem().toString()+"' and `dia_mes` between '"+paraInserirData(data_iniForm)+"' and '"+paraInserirData(data_fimForm)+"'";
                       ResultSet rs = st.executeQuery( query );
                       JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
                       String arquivoJasper = "Relatorios//GeralFuncionarioMes.jasper";
                       rel = JasperFillManager.fillReport(arquivoJasper, map, jrRS);
                       
                       JasperViewer.viewReport(rel, false);
                       con.close();

                                       }catch(Exception t){
                                               System.out.println(t.getMessage());
                               }
                     
                    tMes_relatorio.setSelectedIndex(0);
                    tMesFuncionario_relatorio.setSelectedIndex(0);
                    tFuncionarioGeral_relatorio.setSelectedIndex(0);
                    tFuncionario_relatorio.setSelectedIndex(0);
                    tAno_relatorio.setSelectedIndex(0);
                    tAnoFuncionario_relatorio.setSelectedIndex(0);

                  }});
                  
               sair_interno.addActionListener(new ActionListener(){
                   @Override
                public void actionPerformed(ActionEvent e){

                    
                     
                    try{
                      
                        tela.remove(painel_funcionario);
                         
                    }catch(NullPointerException npe){};
                    
                     try{
                        
                        tela.remove(painel_funcao);
                                               
                    }catch(NullPointerException npe){};
                    
                      try{
                      
                        tela.remove(painel_setor);
                         
                    }catch(NullPointerException npe){};
                    
                    try{
                      
                        tela.remove(painel_operacao);
                         
                    }catch(NullPointerException npe){};
                    
                    try{  
                      
                    tela.remove(painel_Horario);
                    }catch(NullPointerException npe){};
                    
                    try{
                        
                        tela.remove(painel_controle);
                                               
                    }catch(NullPointerException npe){};
                    
                    try{
                        
                        tela.remove(painel_relatorio);
                                               
                    }catch(NullPointerException npe){};
                    
                    cadastrarFuncionario.setEnabled(true);
                    cadastrarFuncao.setEnabled(true);
                    cadastrarSetor.setEnabled(true);
                    consultarOperacao.setEnabled(true);
                    cadastrarHorario.setEnabled(true);
                    controle.setEnabled(true);
                    relatorio.setEnabled(true);
                    tela.revalidate();
                    tela.repaint();
                    
                    
                        
                    }                    
            	
            });

            
          
            
        }

       private void criaMenu(){
           
            menu = new JToolBar("Barra de Ferramentas");
            menu.setBackground(Color.white);
            
            cadastrarFuncionario = new JButton();
            cadastrarFuncionario.setIcon(imageFuncionario);
            cadastrarFuncionario.setToolTipText("Cadastrar Funcionário"); 
            cadastrarFuncionario.setBounds(10, 10, 100, 100);
            menu.add(cadastrarFuncionario);
            
            cadastrarFuncao = new JButton();
            cadastrarFuncao.setIcon(imageFuncao);
            cadastrarFuncao.setToolTipText("Cadastrar Função"); 
            cadastrarFuncao.setBounds(10, 10, 100, 100);
            menu.add(cadastrarFuncao);
            
            cadastrarSetor = new JButton();
            cadastrarSetor.setIcon(imageSetor);
            cadastrarSetor.setToolTipText("Cadastrar Setor"); 
            cadastrarSetor.setBounds(10, 10, 100, 100);
            menu.add(cadastrarSetor);
            
            consultarOperacao = new JButton();
            consultarOperacao.setIcon(imageOperacao);
            consultarOperacao.setToolTipText("Consultar dia"); 
            consultarOperacao.setBounds(10, 10, 100, 100);
            menu.add(consultarOperacao);
            
            cadastrarHorario = new JButton();
            cadastrarHorario.setIcon(imageHorario);
            cadastrarHorario.setToolTipText("Cadastrar Horário"); 
            cadastrarHorario.setBounds(10, 10, 100, 100);
            menu.add(cadastrarHorario);
            
            
            controle = new JButton();
            controle.setIcon(imageControle);
            controle.setToolTipText("Controle"); 
            controle.setBounds(10, 10, 100, 100);
            menu.add(controle);
            
            relatorio = new JButton();
            relatorio.setIcon(imageRelatorio);
            relatorio.setToolTipText("Relatórios"); 
            relatorio.setBounds(10, 10, 100, 100);
            menu.add(relatorio);
            
            sair = new JButton();
            sair.setIcon(imageSair);
            sair.setToolTipText("Sair"); 
            sair.setBounds(10, 10, 100, 100);
            menu.add(sair);
       }
 public static String paraFormatoDinheiro(BigDecimal valor){

            String aux = String.valueOf(valor);
            if(aux.length()>9){
                for(int i=0;i<aux.length();i++){
                    if(aux.charAt(i)=='.'){
                        String retorna = aux.substring(0,i)+","+aux.substring(i+1,i+3);
                        return retorna;
                    }
                }
            }
            if(aux.length()== 7 && aux.charAt(0)=='-'&& aux.charAt(aux.length()-3)=='.'){
                String retorna = ""+aux.substring(0,4)+","+aux.substring(5,7)+"";
                return retorna;
            }

            if(aux.charAt(aux.length()-2)=='.'){
                if(aux.length()<6){

                    for(int i=0;i<aux.length();i++){
                        if(aux.charAt(i)=='.'){
                            String retorna = ""+aux.substring(0,i)+","+aux.substring(i+1,aux.length())+"0";
                            return retorna;
                        }
                    }

                }
                if(aux.length()==6){
                    String retorna = ""+aux.substring(0,1)+"."+aux.substring(1,4)+","+aux.substring(5,6)+"0";
                    return retorna;
                }
                if(aux.length()==7){
                    String retorna = ""+aux.substring(0,2)+"."+aux.substring(2,5)+","+aux.substring(6,7)+"0";
                    return retorna;
                }
                if(aux.length()==8){
                    String retorna = ""+aux.substring(0,3)+"."+aux.substring(3,6)+","+aux.substring(7,8)+"0";
                    return retorna;
                }

            }
            if(aux.charAt(aux.length()-3)=='.'){

                if(aux.length()<7){
                    for(int i=0;i<aux.length();i++){
                        if(aux.charAt(i)=='.'){
                            String retorna = ""+aux.substring(0,i)+","+aux.substring(i+1,aux.length())+"";
                            return retorna;
                        }
                    }

                }
                if(aux.length()==7){
                    String retorna = ""+aux.substring(0,1)+"."+aux.substring(1,4)+","+aux.substring(5,7)+"";
                    return retorna;
                }
                if(aux.length()==8){
                    String retorna = ""+aux.substring(0,2)+"."+aux.substring(2,5)+","+aux.substring(6,8)+"";
                    return retorna;
                }
                if(aux.length()==9){
                    String retorna = ""+aux.substring(0,3)+"."+aux.substring(3,6)+","+aux.substring(7,9)+"";
                    return retorna;
                }

            }
            return null;
        }
 
 public static String formatoParaInserir(String valor){
            String aux = null;

            if(valor.length()<=3){
                return valor;
            }
            if(valor.charAt(valor.length()-3)!=',' && valor.charAt(valor.length()-2)!=','){
                for(int i = 0; i < valor.length();i++){
                    if(valor.charAt(i)=='.'){
                        aux = valor.substring(0,i) + valor.substring((i+1),valor.length());
                        return aux;
                    }
                }
            }
             if(valor.charAt(valor.length()-3)==','){
            
                        if(valor.length()<7){

                            if(valor.charAt(valor.length()-3)==','||valor.charAt(1)=='.'){
                            aux = valor.substring(0,valor.length()-3) + "." +valor.substring(valor.length()-2,valor.length());
                            return aux;
                            }
                          }

                        if(valor.length()==8){

                            if(valor.charAt(1)=='.' && valor.charAt(5)==','){
                                aux = valor.substring(0,1) + valor.substring(2,5) +"."+ valor.substring(6,8);
                                return aux;
                            }

                        }
                        if(valor.length()==9){
                            if(valor.charAt(2)=='.' && valor.charAt(6)==','){
                                aux = valor.substring(0,2) + valor.substring(3,6) +"."+valor.substring(7,9);
                                return aux;
                            }
                            }
            }
            if(valor.charAt(valor.length()-2)==','){

                     if(valor.length()<6){

                            if(valor.charAt(valor.length()-2)==','){
                            aux = valor.substring(0,valor.length()-2) + "." +valor.substring(valor.length()-1,valor.length());
                            return aux;
                            }
                          }

                        if(valor.length()==7){

                            if(valor.charAt(1)=='.' && valor.charAt(5)==','){
                                aux = valor.substring(0,1) + valor.substring(3,6) +"."+ valor.substring(6,7);
                                return aux;
                            }

                        }
                        if(valor.length()==9){
                            if(valor.charAt(2)=='.' && valor.charAt(6)==','){
                                aux = valor.substring(0,2) + valor.substring(4,7) +"."+valor.substring(7,9);
                                return aux;
                            }
                            }

            }
          
             return valor;
            
        }
 
        public static String paraInserirData(String data){
            
            String retorno,dia,mes,ano;
            dia = data.substring(0,2);
            mes = data.substring(3,5);
            ano = data.substring(6,10);
            retorno = ano+mes+dia;
            return retorno;
            
        }
        public static String paraRecuperarData(String data){
            
            String retorno,dia,mes,ano;
            dia = data.substring(8,10);
            mes = data.substring(5,7);
            ano = data.substring(0,4);
            retorno = dia+"/"+mes+"/"+ano;
            return retorno;
            
        }
        
        public String dataInicioMes(String mes)    {  
    
         
            
            String dataInicioMes;  
            dataInicioMes = null;
  
            switch (mes)  
            {  

            case "Janeiro":  
            {  
              dataInicioMes = "01/01";  
              break;  
            }  
            case "Fevereiro":  
            {  
              dataInicioMes = "01/02";  
              break;  
            }  
            case "Março":  
            {  
              dataInicioMes = "01/03";  
              break;  
            }  
            case "Abril":  
            {  
              dataInicioMes = "01/04";  
              break;  
            } 
            case "Maio":  
            {  
              dataInicioMes = "01/05";  
              break;  
            } 
            case "Junho":  
            {  
              dataInicioMes = "01/06";  
              break;  
            }
            case "Julho":  
            {  
              dataInicioMes = "01/07";  
              break;  
            }
            case "Agosto":  
            {  
              dataInicioMes = "01/08";  
              break;  
            }
            case "Setembro":  
            {  
              dataInicioMes = "01/09";  
              break;  
            }
            case "Outubro":  
            {  
              dataInicioMes = "01/10";  
              break;  
            }    
            case "Novembro":  
            {  
              dataInicioMes = "01/11";  
              break;  
            }
            case "Dezembro":  
            {  
              dataInicioMes = "01/12";  
              break;  
            } 
            } 
            
            return dataInicioMes;

  } public String dataFimMes(String mes)    {  
    
         
            
            String dataFimMes;  
            dataFimMes = null;
  
            switch (mes)  
            {  

            case "Janeiro":  
            {  
              dataFimMes = "31/01";  
              break;  
            }  
            case "Fevereiro":  
            {  
              dataFimMes = "28/02";  
              break;  
            }  
            case "Março":  
            {  
              dataFimMes = "31/03";  
              break;  
            }  
            case "Abril":  
            {  
              dataFimMes = "30/04";  
              break;  
            } 
            case "Maio":  
            {  
              dataFimMes = "31/05";  
              break;  
            } 
            case "Junho":  
            {  
              dataFimMes = "30/06";  
              break;  
            }
            case "Julho":  
            {  
              dataFimMes = "31/07";  
              break;  
            }
            case "Agosto":  
            {  
              dataFimMes = "31/08";  
              break;  
            }
            case "Setembro":  
            {  
              dataFimMes = "30/09";  
              break;  
            }
            case "Outubro":  
            {  
              dataFimMes = "31/10";  
              break;  
            }    
            case "Novembro":  
            {  
              dataFimMes = "30/11";  
              break;  
            }
            case "Dezembro":  
            {  
              dataFimMes = "31/12";  
              break;  
            } 
            } 
            
            return dataFimMes;  

  } 
          public void limparTudoControle(){
              
              try{
                       dia1.setText("");
                       tDia1_entrada1.setText("");
                       tDia1_saida1.setText("");
                       tDia1_entrada2.setText("");
                       tDia1_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                              
                       try{
                       dia2.setText("");
                       tDia2_entrada1.setText("");
                       tDia2_saida1.setText("");
                       tDia2_entrada2.setText("");
                       tDia2_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia3.setText("");
                       tDia3_entrada1.setText("");
                       tDia3_saida1.setText("");
                       tDia3_entrada2.setText("");
                       tDia3_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia4.setText("");
                       tDia4_entrada1.setText("");
                       tDia4_saida1.setText("");
                       tDia4_entrada2.setText("");
                       tDia4_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia5.setText("");
                       tDia5_entrada1.setText("");
                       tDia5_saida1.setText("");
                       tDia5_entrada2.setText("");
                       tDia5_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia6.setText("");
                       tDia6_entrada1.setText("");
                       tDia6_saida1.setText("");
                       tDia6_entrada2.setText("");
                       tDia6_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia7.setText("");
                       tDia7_entrada1.setText("");
                       tDia7_saida1.setText("");
                       tDia7_entrada2.setText("");
                       tDia7_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia8.setText("");
                       tDia8_entrada1.setText("");
                       tDia8_saida1.setText("");
                       tDia8_entrada2.setText("");
                       tDia8_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia9.setText("");
                       tDia9_entrada1.setText("");
                       tDia9_saida1.setText("");
                       tDia9_entrada2.setText("");
                       tDia9_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia10.setText("");
                       tDia10_entrada1.setText("");
                       tDia10_saida1.setText("");
                       tDia10_entrada2.setText("");
                       tDia10_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia11.setText("");
                       tDia11_entrada1.setText("");
                       tDia11_saida1.setText("");
                       tDia11_entrada2.setText("");
                       tDia11_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia12.setText("");
                       tDia12_entrada1.setText("");
                       tDia12_saida1.setText("");
                       tDia12_entrada2.setText("");
                       tDia12_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia13.setText("");
                       tDia13_entrada1.setText("");
                       tDia13_saida1.setText("");
                       tDia13_entrada2.setText("");
                       tDia13_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia14.setText("");
                       tDia14_entrada1.setText("");
                       tDia14_saida1.setText("");
                       tDia14_entrada2.setText("");
                       tDia14_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia15.setText("");
                       tDia15_entrada1.setText("");
                       tDia15_saida1.setText("");
                       tDia15_entrada2.setText("");
                       tDia15_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia16.setText("");
                       tDia16_entrada1.setText("");
                       tDia16_saida1.setText("");
                       tDia16_entrada2.setText("");
                       tDia16_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia17.setText("");
                       tDia17_entrada1.setText("");
                       tDia17_saida1.setText("");
                       tDia17_entrada2.setText("");
                       tDia17_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia18.setText("");
                       tDia18_entrada1.setText("");
                       tDia18_saida1.setText("");
                       tDia18_entrada2.setText("");
                       tDia18_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia19.setText("");
                       tDia19_entrada1.setText("");
                       tDia19_saida1.setText("");
                       tDia19_entrada2.setText("");
                       tDia19_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia20.setText("");
                       tDia20_entrada1.setText("");
                       tDia20_saida1.setText("");
                       tDia20_entrada2.setText("");
                       tDia20_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia21.setText("");
                       tDia21_entrada1.setText("");
                       tDia21_saida1.setText("");
                       tDia21_entrada2.setText("");
                       tDia21_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia22.setText("");
                       tDia22_entrada1.setText("");
                       tDia22_saida1.setText("");
                       tDia22_entrada2.setText("");
                       tDia22_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia23.setText("");
                       tDia23_entrada1.setText("");
                       tDia23_saida1.setText("");
                       tDia23_entrada2.setText("");
                       tDia23_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia24.setText("");
                       tDia24_entrada1.setText("");
                       tDia24_saida1.setText("");
                       tDia24_entrada2.setText("");
                       tDia24_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia25.setText("");
                       tDia25_entrada1.setText("");
                       tDia25_saida1.setText("");
                       tDia25_entrada2.setText("");
                       tDia25_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia26.setText("");
                       tDia26_entrada1.setText("");
                       tDia26_saida1.setText("");
                       tDia26_entrada2.setText("");
                       tDia26_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia27.setText("");
                       tDia27_entrada1.setText("");
                       tDia27_saida1.setText("");
                       tDia27_entrada2.setText("");
                       tDia27_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia28.setText("");
                       tDia28_entrada1.setText("");
                       tDia28_saida1.setText("");
                       tDia28_entrada2.setText("");
                       tDia28_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia29.setText("");
                       tDia29_entrada1.setText("");
                       tDia29_saida1.setText("");
                       tDia29_entrada2.setText("");
                       tDia29_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia30.setText("");
                       tDia30_entrada1.setText("");
                       tDia30_saida1.setText("");
                       tDia30_entrada2.setText("");
                       tDia30_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                       
                       try{
                       dia31.setText("");
                       tDia31_entrada1.setText("");
                       tDia31_saida1.setText("");
                       tDia31_entrada2.setText("");
                       tDia31_saida2.setText("");
                       }catch(IndexOutOfBoundsException iobe){};
                                   
              
          }

           public String pesquisarDiaSemana(int _diaSemana)    {  
    
         
            
            String diaSemana = null;  
  
            switch (_diaSemana)  
            {  

            case 1:  
            {  
              diaSemana = "Domingo";  
              break;  
            }  
            case 2:  
            {  
              diaSemana = "Segunda";  
              break;  
            }  
            case 3:  
            {  
              diaSemana = "Terça";  
              break;  
            }  
            case 4:  
            {  
              diaSemana = "Quarta";  
              break;  
            }  
            case 5:  
            {  
              diaSemana = "Quinta";  
              break;  
            }  
            case 6:  
            {  
              diaSemana = "Sexta";  
              break;  
            }  
            case 7:  
            {  
              diaSemana = "Sábado";  
              break;  
            }  

            }  
            return diaSemana;  

  }  

       

       }
