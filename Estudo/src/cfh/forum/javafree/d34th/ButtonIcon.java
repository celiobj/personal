package cfh.forum.javafree.d34th;  
  
import java.io.File;  
  
import javax.swing.ImageIcon;  
import javax.swing.JButton;  
import javax.swing.JFileChooser;  
import javax.swing.JFrame;  
  
/** 
 * @version 1.0, 07.07.2011 
 */  
public class ButtonIcon {  
  
    public static void main(String[] args) {  
        JFileChooser chooser = new JFileChooser();  
        if (chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION)  
            return;  
          
        File file = chooser.getSelectedFile();  
        System.out.println(file.getAbsolutePath());  
        ImageIcon icon = new ImageIcon(file.getAbsolutePath());  
          
        JButton button = new JButton("Teste");  
        button.setIcon(icon);  
          
        JFrame frame = new JFrame();  
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        frame.add(button);  
        frame.pack();  
        frame.setVisible(true);  
    }  
}  


