/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

/**
 *
 * @author celio
 */
public class Principal extends JFrame{
    
    final Container tela;
    JToolBar menuBotoes;
    JMenuBar menu;
    JMenu cadastro,vendas,estoque,relatorios, sair;
    
    public Principal(){
        
            super("..:: UltraCom - Vs. 1.0 ::..");
            tela = getContentPane();
            tela.setLayout(null);
            setResizable(false);
            setSize(1280,800);
            setLocationRelativeTo(null);
            setVisible(true);
            criaMenu();
            
            menu = new JMenuBar();
            cadastro = new JMenu("Cadastro");
            vendas = new JMenu("Vendas");
            estoque = new JMenu("Estoque");
            relatorios = new JMenu("Relatórios");
            sair = new JMenu("Sair");
            menu.add(cadastro);
            menu.add(vendas);
            menu.add(estoque);
            menu.add(relatorios);
            menu.add(sair);
            setJMenuBar(menu);
                    
            
            
            
    }
    private void criaMenu(){
           
            menuBotoes = new JToolBar("Barra de Ferramentas");
            menuBotoes.setBackground(Color.white);
            menuBotoes.setBounds(1,1,tela.getWidth(),80); 
            tela.add(menuBotoes);
            
            
       }
}
