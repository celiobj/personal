/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Persistencia.RepositorioUsuario;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author celio
 */
public class VerificarUsuario extends JFrame{

    JButton ok,cancelar;
    JLabel usuario,senha;
    JTextField tUsuario;
    JPasswordField tSenha;
    RepositorioUsuario ru;
    
        public VerificarUsuario(){
            super("Verificar Usuário - Ultrapoint 1.0");
            Container tela =  getContentPane();
            tela.setLayout(null);

            ok = new JButton("Ok");
            cancelar = new JButton("Cancelar");
            usuario = new JLabel("Usuario: ");
            senha = new JLabel("Senha: ");
            tUsuario = new JTextField(10);
            tSenha =  new JPasswordField(10);

            usuario.setBounds(20,20,50,20);
            tUsuario.setBounds(100,20,100,20);
            senha.setBounds(20,50,50,20);
            tSenha.setBounds(100,50,100,20);
            ok.setBounds(40,80,50,30);
            cancelar.setBounds(100,80,100,30);

            tela.add(ok);
            tela.add(cancelar);
            tela.add(usuario);
            tela.add(senha);
            tela.add(tUsuario);
            tela.add(tSenha);

            tUsuario.setFont(new Font("Times New Roman", Font.BOLD, 14));

            ok.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                   if(tUsuario.getText().equals("")||tSenha.getText().equals("")){
                       JOptionPane.showMessageDialog(null,"Preencha Usuário e Senha!!!");
                   }else{
                    ru = new RepositorioUsuario();
                    if(ru.procurar(tUsuario.getText(), tSenha.getText()).equals("aceito")){
                   
                     setVisible(false);
                     Principal pri = new Principal();
                     pri.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    
                        
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos");
                    }
                     }
                }
            });

            cancelar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                   System.exit(0);}});

            setSize(250,150);
            setLocationRelativeTo(null);
            setVisible(true);
        }

        

     

}
