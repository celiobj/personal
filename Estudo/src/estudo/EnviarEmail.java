/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package estudo;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author celio
 */
public class EnviarEmail {
    
    
    
    public static void main(String[] args) {
     
        try{
       sendEmail();
        }catch(Exception e){}
    
    }
    
    public static void sendEmail() throws EmailException {
    
   SimpleEmail email = new SimpleEmail();
   //Utilize o hostname do seu provedor de email
   System.out.println("alterando hostname...");
   email.setHostName("smtp.gmail.com");
   //Quando a porta utilizada não é a padrão (gmail = 465)
   email.setSmtpPort(465);
   //Adicione os destinatários
   email.addTo("celiobj@gmail.com", "Célio");
   //Configure o seu email do qual enviará
   email.setFrom("cbjsolutions@gmail.com", "CBJ Solutions");
   //Adicione um assunto
   email.setSubject("Teste de email");
   //Adicione a mensagem do email
   email.setMsg("Testando o envio de email pelo Java!!");
   //Para autenticar no servidor é necessário chamar os dois métodos abaixo
   System.out.println("autenticando...");
   email.setSSL(true);
   email.setAuthentication("cbjsolutions", "slipclown");
   System.out.println("enviando...");
   email.send();
   System.out.println("Email enviado!");
}


}
