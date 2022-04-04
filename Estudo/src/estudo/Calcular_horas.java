/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package estudo;

import java.sql.Time;


/**
 *
 * @author celio
 */
public class Calcular_horas {
    
    Time horaIni = Time.valueOf("10:00:00");
    Time horaFim = Time.valueOf("10:30:00");
    

    public Calcular_horas(){
        
        
       System.out.println(((horaFim.getTime() - horaIni.getTime())/60000)/60+":"+((horaFim.getTime() - horaIni.getTime())/60000)%60);
       System.out.println((horaFim.getTime() + horaIni.getTime())/60000);

    
}

public static void main(String args[]){
    
    
                Calcular_horas es = new Calcular_horas();
           
        }
}