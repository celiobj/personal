
 
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
 
public class Formatar_numeros {
 
     public static void main(String[] args) {
 
          try {
 
               
               Double valorDouble1 = 3215.99; //Valor double comum com decimais
               Double valorDouble2 = 0.8; //Valor double comum com decimais
               String valorStr1 = "R$ 21,555"; //Valor no formato da moeda brasileira
               String valorStr2 = "31,05"; //Valor no formato numérico brasileiro
 
               NumberFormat formato1 = NumberFormat.getCurrencyInstance(); //Formato de moeda atual do sistema
               NumberFormat formato2 = NumberFormat.getInstance(); //Formato atual do sistema
               NumberFormat formato3 = NumberFormat.getNumberInstance(); //Formato numérico atual do sistema
               NumberFormat formato4 = NumberFormat.getCurrencyInstance(new Locale("pt", "BR")); //Formato de moeda (Espanha)
               NumberFormat formato5 = NumberFormat.getIntegerInstance(); //Formato de inteiro atual do sistema
               NumberFormat formato6 = NumberFormat.getPercentInstance(); //Formato de porcentagem atual do sistema
 
               DecimalFormat formato7 = new DecimalFormat(".##"); //Formato com duas casas decimais depois do ponto (.)
 
               /**
                * A função 'format' formata um valor Double em String no formato
                * definido no NumberFormat ou DecimalFormat
                * 
                * @return String
                */
               System.out.println("Usando 'format' com 'getCurrencyInstace': " + formato1.format(valorDouble1));
               System.out.println("Usando 'format' com 'getInstace': " + formato2.format(valorDouble1));
               System.out.println("Usando 'format' com 'getNumberInstace': " + formato3.format(valorDouble1));
               System.out.println("Usando 'format' com 'getCurrencyInstace(Locale)': " + formato4.format(valorDouble1));
               System.out.println("Usando 'format' com 'getIntegerInstace': " + formato5.format(valorDouble2));
               System.out.println("Usando 'format' com 'getPercentInstace': " + formato6.format(valorDouble2));
               System.out.println("Usando 'format' com 'DecimalFormat(Mascara)': " + formato7.format(valorDouble1));
 
               /**
                * A função 'parse' converte uma String em formato de número, ou seja,
                * se a String estiver no formato brasileiro (com , e . trocados) será
                * convertido para o formato padrão para Number, Double, Float... 
                * 
                * @return Number
                */
               Number parse1 = formato1.parse(valorStr1);
               Number parse2 = formato2.parse(valorStr2);
               Number parse3 = formato3.parse(valorStr2);
               System.out.println(); //Apenas para 'pular' uma linha
               System.out.println("Usando 'parse' com 'getCurrencyInstace': " + parse1);
               System.out.println("Usando 'parse' com 'getInstace': " + parse2);
               System.out.println("Usando 'parse' com 'getNumberInstace': " + parse3);
 
          } catch (ParseException e) { //ParseException é necessário para usar a função 'parse' do NumberFormat
               e.printStackTrace();
          } catch (Exception e) {
               e.printStackTrace();
          }
     }
}
     