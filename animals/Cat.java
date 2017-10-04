
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

 class Cat extends Feline {

    @Override
    public void callSound() {
        
           JLabel Jsound = new JLabel("Meow Meow");
    JPanel panel = new JPanel(new GridLayout(0, 1));
    panel.add(Jsound);

    JOptionPane.showConfirmDialog(null, panel, "Expected behaviour - Noise",
     
           JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        
    }

    public int move() {
        return 30;
    }

}