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
import Classes.Funcionario;
import Persistencia.RepositorioDia;
import Persistencia.RepositorioFuncionario;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.*;  





/**
 *
 * @author celio
 */
public class Principal extends JFrame implements ActionListener{

    JLabel cod, dataMostrar,confirma,retorna;
    JTextField tCod, tFuncionario;
    Calendar data;
    int dia, dia_semana, mes, ano;
    public static String data_hoje;
    private javax.swing.Timer timer;  
    private JLabel label;  
    JComboBox operacao;
    String tOperacao[]={"","1a Entrada", "1a Saída", "2a Entrada","2a Saída"};
    RepositorioDia rd;
    RepositorioFuncionario rf;
    int qtdDia ;
    int status ;
    Dia diaInicial = new Dia();
    Vector <Dia> vector = new Vector<Dia>();
    Dia diaClasse;
    JButton limpar;



    

       public Principal() {

            super("..:: UltraPoint - Vs. 1.0 ::..");
            final Container tela = getContentPane();
            tela.setLayout(null);
            
                    data = Calendar.getInstance();
                    dia = data.get(Calendar.DAY_OF_MONTH);
                    dia_semana = data.get(Calendar.DAY_OF_WEEK);
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
                          }else{
                              data_hoje = dia+"/"+(mes+1)+"/"+ano;
                          }
            qtdDia = data.getActualMaximum(Calendar.DAY_OF_MONTH); 
            cod = new JLabel("Código: "); 
            tCod = new JTextField(8);
            tFuncionario = new JTextField(40);
            confirma = new JLabel("");
            limpar = new JButton("Limpar");
            limpar.setVisible(false);
            operacao = new JComboBox(tOperacao);
            dataMostrar = new JLabel(data_hoje);
            label = new JLabel();  
            label.setFont(new Font("Arial", Font.BOLD, 30));  
            JPanel panel = new JPanel();  
            panel.add(label);  
         
            label.setBounds(30, 10, 150, 80);  
            label.show();  
            disparaRelogio();
           
           cod.setBounds(30, 80, 50, 20);
           tCod.setBounds(100, 80, 50, 20);
           tFuncionario.setBounds(160, 80, 200, 20);
           operacao.setBounds(160, 110, 200, 20);
           confirma.setBounds(160, 200, 200, 20);
           limpar.setBounds(160, 230, 200, 20);
           dataMostrar.setBounds(30, 200, 100, 20);
           
           tFuncionario.setEditable(false);
           operacao.setEnabled(false);
           
           tela.add(dataMostrar);   
           tela.add(label);
           tela.add(cod);
           tela.add(tCod);
           tela.add(tFuncionario);
           tela.add(operacao);
           tela.add(confirma);
           tela.add(limpar);
           
           
           
           
         
                    
             tCod.addActionListener(new ActionListener(){
            	public void actionPerformed(ActionEvent e){
                   vector.removeAllElements();
                    String queryComeco = "INSERT INTO `bd_ultrapoint`.`dia` (`dia_mes`,`dia_semana`,`cod_funcionario`,`entrada1`,`saida1`,`entrada2`,`saida2`,`saldo`,`obs`,`status`) VALUES ";
                    String queryFim = "";
                    String query = "";
               if(confirma.getText().equals("")){
                 rd = new RepositorioDia();
                 rf = new RepositorioFuncionario();
                 diaClasse = rd.conferir(paraInserirData(data_hoje), tCod.getText());
                 JOptionPane.showMessageDialog(null, diaClasse);         
           
          if(dia==1&&diaClasse==null){  
           rd = new RepositorioDia();
           
               
            for(int a = 1;a <= qtdDia; a++){
                String data_hoje = null;
                
                   if( a<10){
                      data_hoje = "0"+a+"/"+(mes+1)+"/"+ano;
                  }else
                      if(a>=10 ){
                          data_hoje =  a+"/"+(mes+1)+"/"+ano;
                      
                 }
                 //   JOptionPane.showMessageDialog(null, data_hoje);
            
            diaInicial.setCod_func(tCod.getText());
            diaInicial.setDia_mes(paraInserirData(data_hoje));
            diaInicial.setDia_semana("");
            diaInicial.setEntrada1("00:00:00");
            diaInicial.setSaida1("00:00:00");
            diaInicial.setEntrada2("00:00:00");
            diaInicial.setSaida2("00:00:00");
            diaInicial.setSaldo("00:00:00");
            diaInicial.setStatus("0");
            diaInicial.setObs("Não Registrado");
             
            vector.add(diaInicial);
            //JOptionPane.showMessageDialog(null, vector.size());

            queryFim = queryFim+"('"+vector.get(dia-1).getDia_mes()+"','"+vector.get(dia-1).getDia_semana()+"','"+vector.get(dia-1).getCod_func()+"','"+vector.get(dia-1).getEntrada1()+"','"+vector.get(dia-1).getSaida1()+"','"+vector.get(dia-1).getEntrada2()+"','"+vector.get(dia-1).getSaida2()+"','"+vector.get(dia-1).getSaldo()+"','"+vector.get(dia-1).getObs()+"','"+vector.get(dia-1).getStatus()+"'),";
                }
            query = queryComeco+queryFim;   
            System.out.println( query.substring(0,query.length()-2)+");");
            rd.preencherMesZerado(vector,query.substring(0,query.length()-2)+");");
          }
                    
                    
                    
                    Funcionario fu = rf.consultar(tCod.getText());
                    tFuncionario.setText(fu.getNome());
                        diaClasse = rd.conferir(paraInserirData(data_hoje), tCod.getText()); 
                        
                        int st = Integer.parseInt(diaClasse.getStatus());
                        if(st==4){
                            
                            JOptionPane.showMessageDialog(null, "Funcionário já encerrou seu expediente!!!");
                            tCod.setText("");
                            tFuncionario.setText("");
                            operacao.setSelectedIndex(0);
                            
                        }else{
                    status = Integer.parseInt(diaClasse.getStatus());
                    fu = rf.consultar(tCod.getText());
                                   
                    diaClasse.setDia_mes(paraInserirData(data_hoje));
                    diaClasse.setDia_semana(pesquisarDiaSemana(dia_semana));
                    diaClasse.setCod_func(tCod.getText());
                    diaClasse.setEntrada1(label.getText());
                    diaClasse.setSaldo("00:00:00");
                    diaClasse.setObs("Nenhuma");
                    String statusTexto = ""+(status+1);
                    diaClasse.setStatus(statusTexto);
                    diaClasse.setObs("");
                    tFuncionario.setText(fu.getNome());
                    selecionarOperacao(status+1); 
                    confirma.setText("Confirma o registro?");
                    limpar.setVisible(true);
                    tCod.setEditable(false);
                        }
                        
                    }else{
                   
                   /*int resposta = JOptionPane.showConfirmDialog(null, "Confirma o registro?");
                        if(resposta==0){
                        }*/
                    
                    rd.alterar(diaClasse,ondeAlterar(status),label.getText());
                    tFuncionario.setFocusable(true);
                    tCod.setText("");
                    tFuncionario.setText("");
                    confirma.setText("");
                    tCod.setEditable(true);
                    limpar.setVisible(false);
                    operacao.setSelectedIndex(0);
                    
                   
               }           
            	}
            });
             limpar.addActionListener(new ActionListener(){
                    @Override
            	public void actionPerformed(ActionEvent e){

                   
                        tFuncionario.setFocusable(true);
                        tCod.setText("");
                        tFuncionario.setText("");
                        confirma.setText("");
                        tCod.setEditable(true);
                        limpar.setVisible(false);
                        operacao.setSelectedIndex(0);
                                   
                        }
                    
                 
            });
             


            setResizable(false);
            //setExtendedState(MAXIMIZED_BOTH);
            setSize(400,300);
            setLocationRelativeTo(null);
            setVisible(true);
            
       }
       
        
   
  
   public void disparaRelogio() {  
      if (timer == null) {  
         timer = new javax.swing.Timer(1000, this);  
         timer.setInitialDelay(0);  
         timer.start();  
      } else if (!timer.isRunning()) {  
         timer.restart();  
      }  
   }  
  
   public void actionPerformed(ActionEvent ae) {  
      GregorianCalendar calendario = new GregorianCalendar();  
      int h = calendario.get(GregorianCalendar.HOUR_OF_DAY);  
      int m = calendario.get(GregorianCalendar.MINUTE);  
      int s = calendario.get(GregorianCalendar.SECOND);  
  
      String hora =  
         ((h < 10) ? "0" : "")  
            + h  
            + ":"  
            + ((m < 10) ? "0" : "")  
            + m  
            + ":"  
            + ((s < 10) ? "0" : "")  
            + s;  
  
      label.setText(hora);  
   } 

   public static void main(String args[]){

            Principal pri = new Principal();
            pri.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
            retorno = dia+mes+ano;
            return retorno;
            
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

public void selecionarOperacao(int num)    {  
    
         
            
           
  
            switch (num)  
            {  
                
             case 0:  
            {  
              operacao.setSelectedIndex(0); 
              break;  
            } 

            case 1:  
            {  
              operacao.setSelectedIndex(1); 
              break;  
            }  
            case 2:  
            {  
              operacao.setSelectedIndex(2); 
              break;  
            }  
            case 3:  
            {  
              operacao.setSelectedIndex(3); 
              break;  
            }  
            case 4:  
            {  
              operacao.setSelectedIndex(4);
              break;  
            }  
            

            }  
         

          

}

public String ondeAlterar(int status)    {  
    
         
            
            String onde = null;  
  
            switch (status)  
            {  

            case 0:  
            {  
              onde = "entrada1";  
              break;  
            } 
                    
            case 1:  
            {  
              onde = "saida1";  
              break;  
            }  
            case 2:  
            {  
              onde = "entrada2";  
              break;  
            }  
            case 3:  
            {  
              onde = "saida2";  
              break;  
            }  
                       
            }  
            return onde;  

  }  
       

       }
