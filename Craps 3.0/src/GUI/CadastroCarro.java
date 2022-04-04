	/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Classes.Carro;
import Persistencia.RepositorioCarro;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;


/**
 *
 * @author celio
 */
public class CadastroCarro extends JFrame {



    JButton cadastrar,alterar,excluir, limpar,filtrar,ok,todos, sair;
    JLabel placa, valor, modelo,cod ,obs;
    JTextField tValor,tModelo,tCod ,tObs;
    JFormattedTextField tPlaca;
    MaskFormatter mascaraPlaca;
    JTable tabela;
    JScrollPane scroller;
    RepositorioCarro rc;

    @SuppressWarnings("empty-statement")
        public CadastroCarro() {
            super("..::|Cadastro de Carros| Controle Financeiro - CRAPS Vs. 3.0 ::..");
            final Container tela = getContentPane();
            tela.setLayout(null);


            cadastrar = new JButton("|Cadastrar|");
            todos = new JButton("|Todos|");
            filtrar = new JButton("|Filtrar|");
            ok = new JButton("|OK|");
            alterar = new JButton("|Alterar|");
            excluir = new JButton("|Exluir|");
            limpar = new JButton("|Limpar|");
            sair = new JButton("|Sair|");
            placa = new JLabel("Placa: ");
            modelo = new JLabel("Modelo: ");
            cod = new JLabel("Cód: ");
            obs = new JLabel("Observações: ");
            tModelo = new JTextField(80);
            tCod = new JTextField(80);
            tObs = new JTextField(40);
            sair.setMnemonic(KeyEvent.VK_R);
            limpar.setMnemonic(KeyEvent.VK_L);
            cadastrar.setMnemonic(KeyEvent.VK_A);

           
            tObs.setFont(new Font("Times New Roman", Font.BOLD, 14));

           try{
        	
                mascaraPlaca = new MaskFormatter("UUU-####");
            

           }catch (Exception exp){};


           tPlaca = new JFormattedTextField(mascaraPlaca);

           tPlaca.setFont(new Font("Times New Roman", Font.BOLD, 14));
           tModelo.setFont(new Font("Times New Roman", Font.BOLD, 14));
           //tValor.setFont(new Font("Times New Roman", Font.BOLD, 14));
           tObs.setFont(new Font("Times New Roman", Font.BOLD, 14));
            

            
            todos.setBounds(400,50,100,20);
            alterar.setBounds(500,50,100,20);
            limpar.setBounds(700,50,100,20);
            excluir.setBounds(250,130,100,20);
            sair.setBounds(800,50,100,20);
            cadastrar.setBounds(20,320,100,20);
            cod.setBounds(20,70,100,20);
            tCod.setBounds(100,70,40,20);
            filtrar.setBounds(150,70,100,20);
            ok.setBounds(250,100,100,20);
            placa.setBounds(20, 100, 100, 20);
            tPlaca.setBounds(100, 100, 100, 20);
            modelo.setBounds(20, 130, 100, 20);
            tModelo.setBounds(100,130,100,20);
            //valor.setBounds(20,160,100,20);
            //tValor.setBounds(100,160,100,20);
            obs.setBounds(20,190,100,20);
            tObs.setBounds(100,190,200,20);

         
            tela.add(cadastrar);
            tela.add(todos);   
            tela.add(alterar);
            tela.add(filtrar);
            tela.add(ok);
            tela.add(excluir);
            tela.add(limpar);
            tela.add(sair);
            tela.add(placa);
            tela.add(tPlaca);
            tela.add(modelo);
            tela.add(tModelo);
            tela.add(cod);
            tela.add(tCod);
            tela.add(obs);
            tela.add(tObs);

          
            filtrar.setVisible(false);
            tCod.setVisible(false);
            cod.setVisible(false);
            ok.setVisible(false);
            excluir.setVisible(false);
            


            todos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                try{
                    
                    filtrar.setVisible(false);
                    tCod.setVisible(false);
                    cod.setVisible(false);
                    ok.setVisible(false);
                    excluir.setVisible(false);
                    tCod.setText("");
                    tPlaca.setText("");
                    tModelo.setText("");
                    tObs.setText("");
                    scroller.setVisible(false);
                    tela.remove(scroller);
                    cadastrar.setVisible(true);
                    
                }catch(Exception e1){

                    filtrar.setVisible(false);
                    tCod.setVisible(false);
                    cod.setVisible(false);
                    ok.setVisible(false);
                    excluir.setVisible(false);
                    tCod.setText("");
                    tPlaca.setText("");
                    tModelo.setText("");
                    tObs.setText("");
                    cadastrar.setVisible(true);

                }
                rc = new RepositorioCarro();
                tabela = rc.obterTodos();

                if(tabela.getValueAt(0, 0)==null){
                    JOptionPane.showMessageDialog(null, "Registros não encontrados!!!");
                }else{
                scroller = new JScrollPane(tabela, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	            tela.add(scroller);
	            scroller.setBounds(20, 400,1000, 300);
                }
              
              
                }
             });

           

            cadastrar.addActionListener(new ActionListener(){
                public void actionPerformed (ActionEvent e){

                
                    String placa = tPlaca.getText();
                    String modelo = tModelo.getText();
                    String obs = tObs.getText();
                    
                    if(placa.equals("")||modelo.equals("")){
                        
                        JOptionPane.showMessageDialog(null, "Preencha os campos PLACA e MODELO");
                    }else
                    {

                    int resposta;
                     resposta=JOptionPane.showConfirmDialog(null,"Deseja realmente cadastrar esse veículo?","Confirmação",JOptionPane.YES_NO_OPTION);
                     if(resposta==0){

                     RepositorioCarro rc = new RepositorioCarro();
                     long cod = rc.gerarCodigo();
                     String codigo = ""+cod+"";
                     System.out.println(codigo);
                     Carro car = new Carro();
                     car.setCod_carro(codigo);
                     car.setPlaca(tPlaca.getText());
                     car.setModelo(tModelo.getText());
                     car.setStatus("Livre");
                     car.setObs(tObs.getText());
                

                     rc.adicionar(car);

                    JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!!!");
                       try{
                    
                    filtrar.setVisible(false);
                    tCod.setVisible(false);
                    VerificarUsuario.ca.cod.setVisible(false);
                    ok.setVisible(false);
                    excluir.setVisible(false);
                    tCod.setText("");
                    tPlaca.setText("");
                    tModelo.setText("");
                    tObs.setText("");
                    scroller.setVisible(false);
                    tela.remove(scroller);
                    cadastrar.setVisible(true);
                    
                }catch(Exception e1){

                    filtrar.setVisible(false);
                    tCod.setVisible(false);
                    VerificarUsuario.ca.cod.setVisible(false);
                    ok.setVisible(false);
                    excluir.setVisible(false);
                    tCod.setText("");
                    tPlaca.setText("");
                    tModelo.setText("");
                    tObs.setText("");
                    cadastrar.setVisible(true);

                }               
              
                       }
                     }
                }
            });

            limpar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){


                try{
                    tCod.setEditable(true);
                    cadastrar.setVisible(true);
                    filtrar.setVisible(false);
                    tCod.setVisible(false);
                    cod.setVisible(false);
                    ok.setVisible(false);
                    excluir.setVisible(false);
                    tCod.setText("");
                    tPlaca.setText("");
                    tModelo.setText("");
                    tObs.setText("");
                    scroller.setVisible(false);
                    tela.remove(scroller);
                    
                }catch(Exception e1){

                    tCod.setEditable(true);
                    filtrar.setVisible(false);
                    tCod.setVisible(false);
                    cod.setVisible(false);
                    ok.setVisible(false);
                    excluir.setVisible(false);
                    tCod.setText("");
                    tPlaca.setText("");
                    tModelo.setText("");
                    tObs.setText("");
                    cadastrar.setVisible(true);

                }
                }
            });
            
            alterar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    
                    tCod.setVisible(true);
                    cod.setVisible(true);
                    ok.setVisible(true); 
                    excluir.setVisible(true);
                    filtrar.setVisible(true);
                    cadastrar.setVisible(false);
                }
            });
            
            filtrar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    
                    if(tCod.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Preencha o campo Código !!!");
                    }else
                    {
                        rc = new RepositorioCarro();
                        Carro car = rc.procurar(tCod.getText());
                        
                        tPlaca.setText(car.getPlaca());
                        tModelo.setText(car.getModelo());
                        tObs.setText(car.getObs());
                        tCod.setEditable(false);
                    }
                }
            });
            
            
            
            ok.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    
                    
                     rc = new RepositorioCarro();
                     Carro car = new Carro();
                     car.setModelo(tModelo.getText());
                     car.setPlaca(tPlaca.getText());
                     car.setObs(tObs.getText());
                    
                     rc.alterarLivres(tCod.getText(), car);
                     rc.alterarCarros(tCod.getText(), car);
                     JOptionPane.showMessageDialog(null, "Carro alterado com Sucesso !!!");
                    
                    


                try{
                    
                    tCod.setEditable(true);
                    filtrar.setVisible(false);
                    tCod.setVisible(false);
                    cod.setVisible(false);
                    ok.setVisible(false);
                    excluir.setVisible(false);
                    tCod.setText("");
                    tPlaca.setText("");
                    tModelo.setText("");
                    tObs.setText("");
                    scroller.setVisible(false);
                    tela.remove(scroller);
                    cadastrar.setVisible(true);
                    
                }catch(Exception e1){

                    tCod.setEditable(true);
                    filtrar.setVisible(false);
                    tCod.setVisible(false);
                    cod.setVisible(false);
                    ok.setVisible(false);
                    excluir.setVisible(false);
                    tCod.setText("");
                    tPlaca.setText("");
                    tModelo.setText("");
                    tObs.setText("");
                    cadastrar.setVisible(true);

                }
                }
            });
            
            excluir.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    
                    if(JOptionPane.showConfirmDialog(null, "Deseja realemente excluir esse carro???")==0){
                        rc = new RepositorioCarro();
                        rc.excluir(tCod.getText());
                        JOptionPane.showMessageDialog(null, "Carro excluído com Sucesso !!!");
                        
                    }
                     
               
                     
                    
                    


                try{
                    
                    tCod.setEditable(true);
                    filtrar.setVisible(false);
                    tCod.setVisible(false);
                    cod.setVisible(false);
                    ok.setVisible(false);
                    excluir.setVisible(false);
                    tCod.setText("");
                    tPlaca.setText("");
                    tModelo.setText("");
                    tObs.setText("");
                    scroller.setVisible(false);
                    tela.remove(scroller);
                    cadastrar.setVisible(true);
                    
                }catch(Exception e1){

                    tCod.setEditable(true);
                    filtrar.setVisible(false);
                    tCod.setVisible(false);
                    cod.setVisible(false);
                    ok.setVisible(false);
                    excluir.setVisible(false);
                    tCod.setText("");
                    tPlaca.setText("");
                    tModelo.setText("");
                    tObs.setText("");
                    cadastrar.setVisible(true);

                }
                }
            });

            sair.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){


                try{
                    
                    filtrar.setVisible(false);
                    tCod.setVisible(false);
                    cod.setVisible(false);
                    ok.setVisible(false);
                    excluir.setVisible(false);
                    tCod.setText("");
                    tPlaca.setText("");
                    tModelo.setText("");
                    tObs.setText("");
                    scroller.setVisible(false);
                    tela.remove(scroller);
                    cadastrar.setVisible(true);
                    
                }catch(Exception e1){

                    filtrar.setVisible(false);
                    tCod.setVisible(false);
                    cod.setVisible(false);
                    ok.setVisible(false);
                    excluir.setVisible(false);
                    tCod.setText("");
                    tPlaca.setText("");
                    tModelo.setText("");
                    tObs.setText("");
                    cadastrar.setVisible(true);

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