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
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author celio
 */
public class Principal extends JFrame {

    JLabel numero1, numero2, numero3, numero4, numero5, numero6;
    int numero1v, numero2v, numero3v, numero4v, numero5v, numero6v;
    ArrayList numeros;
    JButton gerar, limpar;

    public Principal() {

        super("..:: Número da Mega ::..");
        final Container tela = getContentPane();
        tela.setLayout(null);

        gerar = new JButton("Gerar");
        limpar = new JButton("Limpar");

        numero1 = new JLabel("");
        numero2 = new JLabel("");
        numero3 = new JLabel("");
        numero4 = new JLabel("");
        numero5 = new JLabel("");
        numero6 = new JLabel("");

        /*
             JOptionPane.showMessageDialog(null, numero1v);
             JOptionPane.showMessageDialog(null, numero2v);
             JOptionPane.showMessageDialog(null, numero3v);
             JOptionPane.showMessageDialog(null, numero4v);
             JOptionPane.showMessageDialog(null, numero5v);
             JOptionPane.showMessageDialog(null, numero6v);
         */
        numero1.setBounds(65, 100, 80, 20);
        numero2.setBounds(90, 100, 80, 20);
        numero3.setBounds(140, 100, 80, 20);
        numero4.setBounds(190, 100, 80, 20);
        numero5.setBounds(240, 100, 80, 20);
        numero6.setBounds(290, 100, 80, 20);

        gerar.setBounds(200, 200, 80, 20);
        limpar.setBounds(290, 200, 80, 20);

        tela.add(numero1);
        tela.add(numero2);
        tela.add(numero3);
        tela.add(numero4);
        tela.add(numero5);
        tela.add(numero6);
        tela.add(gerar);
        tela.add(limpar);

        gerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GerarNumeros();

            }
        });

        setResizable(false);
        //setExtendedState(MAXIMIZED_BOTH);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String args[]) {

        Principal pri = new Principal();
        pri.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void GerarNumeros() {

        numeros = new ArrayList();
        numero1v = (int) (Math.random() * 60) + 1;
        numeros.add(numero1v);
      
        
        numero2v = (int) (Math.random() * 60) + 1;
        if (numeros.contains(numero2v)) {
            numero2v = (int) (Math.random() * 60) + 1;
            numeros.add(numero2v);
        } else {
            numeros.add(numero2v);
        }
        
        numero3v = (int) (Math.random() * 60) + 1;
        if (numeros.contains(numero3v)) {
            numero3v = (int) (Math.random() * 60) + 1;
            numeros.add(numero3v);
        } else {
            numeros.add(numero3v);
        }

        
        numero4v = (int) (Math.random() * 60) + 1;
        if (numeros.contains(numero4v)) {
            numero4v = (int) (Math.random() * 60) + 1;
            numeros.add(numero4v);
        } else {
            numeros.add(numero4v);
        }

        
        numero5v = (int) (Math.random() * 60) + 1;
        if (numeros.contains(numero5v)) {
            numero5v = (int) (Math.random() * 60) + 1;
            numeros.add(numero5v);
        } else {
            numeros.add(numero5v);
        }

        
        numero6v = (int) (Math.random() * 60) + 1;
        if (numeros.contains(numero6v)) {
            numero6v = (int) (Math.random() * 60) + 1;
            numeros.add(numero6v);
        } else {
            numeros.add(numero6v);
        }
        
        numeros.sort(null);
       
        numero1.setText("" + numeros.get(0));
        numero2.setText("    -    " + numeros.get(1));
        numero3.setText("    -    " + numeros.get(2));
        numero4.setText("    -    " + numeros.get(3));
        numero5.setText("    -    " + numeros.get(4));
        numero6.setText("    -    " + numeros.get(5));;;
        
    }
}
