import java.util.regex.Pattern;

import javax.swing.JDialog;

import progresso.AcaoProgressiva;
import progresso.ControleProgresso;
import progresso.DialogoProgresso;

/**
 * 
 *
 * Finalidade da classe:
 * 
 * Classe de exemplo que demonstra como usar a barra de progresso em 
 * processamentos que possam demorar e que o usu�rio precise ser informado
 * do andamento.
 *  
 * Respons�vel pela classe:
 * @author Paulo Viallet Neto
 * �ltima modifica��o realizada: 11/11/2008
 *
 */
public class ExemploComponenteProgresso {

  private static final String TITULO_PAINEL = "Exemplo Componente Progresso";
  private static final String TITULO_JANELA = "Simula��o de Processamento demorado";
  private static final String MENSAGEM_AVISO = "O primeiro par�metro n�o " +
        "� v�lido, entre com um n�mero entre 1 e 9";
  private static final Pattern NUMERO_0_a_9 = Pattern.compile("[1-9]");

  public static void main(String args[])
  {
    //verifica se o par�metro de entrada � v�lido
    if (args.length != 1 || args[0] != null 
        && !NUMERO_0_a_9.matcher(args[0]).matches()) {
      System.out.println(MENSAGEM_AVISO); 
    }
    else
    {
      //Cria a a��o com o processamento, a janela e o controle do progresso. 
      SimulaProgresso acaoProcessamento = 
        new SimulaProgresso(Integer.valueOf(args[0]).intValue());
      DialogoProgresso janelaProgresso = 
        new DialogoProgresso(new JDialog(),TITULO_JANELA);
      janelaProgresso.setTituloAcao(TITULO_PAINEL);
      ControleProgresso controleProgresso = 
        new ControleProgresso(acaoProcessamento, janelaProgresso);
      controleProgresso.iniciar();
     // termina a execu��o da aplica��o.
      System.exit(0);
    }
  }
  
  
}

/**
 * 
 * Finalidade da classe:
 *  Simular um processamento (somar um contador at� 100) 
 *  que pode demorar mais ou menos tempo.
 * Respons�vel pela classe:
 * @author Paulo Viallet Neto
 * �ltima modifica��o realizada: 11/11/2008
 *
 */
class SimulaProgresso extends AcaoProgressiva{
  /**
   * Indica o atraso no processamento
   */
  long delay;
  int valorFinal = 100;
  int contador = 1;
  
  /**
   * Contrutor que define o atraso 
   * @param delay o valor de indica o atraso no processamento.
   */
  public SimulaProgresso(int delay){
    this.delay = delay;
  }
  
  /**
   * Faz a soma de um contador, simulando dentro do for um processamento
   * que pode demorar mais ou menos de acordo com o par�metro de entrada que 
   * foi passado. 
   *
   */
  public void executarProcessamento(){
    while (contador < valorFinal){
      for (int i=0;i<(delay * 1500000);i++){
        i=i++;
        i=i--;
      }
      contador++;
    }
  }
  
  /**
   * Chama o processamento que ser� iniciado pela thread.
   */
  public void run()
  {
    //vari�vel para medir o tempo de execu��o
    long inicio = System.currentTimeMillis()/1000;

    //executa um processamento que pode demorar
    executarProcessamento();
    
    System.out.println("\nDura��o processo: " + 
        (System.currentTimeMillis()/1000 - inicio)+ " segundos");
  }
  

  public int getProgresso()
  {
    return contador;
  }

  public void encerrar()
  {
    System.out.println("O usu�rio interrompeu o processamento!");
  }
  
}

