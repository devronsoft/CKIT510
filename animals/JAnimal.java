import java.awt.GridLayout;
import javax.swing.*;

class JAnimal {
    
        

public static void input() {
    String[] items = {"Mammal"};
    JComboBox combo = new JComboBox(items);
    
    String[] items2 = {"Canine", "Feline"};
        JLabel type1 = new JLabel("Enter the type of mammal");
    JComboBox combo2 = new JComboBox(items2);
    
    String[] items3 = {"Cat", "Dog", "Lion", "Wolf"};
            JLabel type2 = new JLabel("Enter the type of animal");
    JComboBox combo3 = new JComboBox(items3);
    
    
    
    JPanel panel = new JPanel(new GridLayout(0, 1));
    panel.add(combo);
    panel.add(type1);
    panel.add(combo2);
    panel.add(combo3);
    

   int result = JOptionPane.showConfirmDialog(null, panel, "Describe your new animal!",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
   
   
    if (result == JOptionPane.OK_OPTION) {
        
        
                
        System.out.println(combo3.getSelectedItem());
        
        String chosen2 = (String)combo2.getSelectedItem();
        String chosen3 = (String)combo3.getSelectedItem();
            
        
        validate(chosen2, chosen3);
                
           
        
        
    } else {
        System.out.println("Cancelled");
    }
}



public static void validate(String type, String animal)
        
{
    
    String displayType = type;
    String displayAnimal = animal;
    
    if(displayType == "Canine"){
        if(displayAnimal == "Cat"){
        JOptionPane.showMessageDialog(null, "Invalid combination", "Error", JOptionPane.ERROR_MESSAGE);
           JAnimal.input();
        }}
           
        if(displayAnimal == "Lion"){
         JOptionPane.showMessageDialog(null, "Invalid combination", "Error", JOptionPane.ERROR_MESSAGE);
           JAnimal.input();
        }
    
        if(displayType == "Feline"){
        if(displayAnimal == "Dog")
        JOptionPane.showMessageDialog(null, "Invalid combination", "Error", JOptionPane.ERROR_MESSAGE);
          JAnimal.input();
        if(displayAnimal == "Wolf")
         JOptionPane.showMessageDialog(null, "Invalid combination", "Error", JOptionPane.ERROR_MESSAGE);
          JAnimal.input();
    
    }
    
    else
        
        display(displayType, displayAnimal);


        
}



public static void display(String type, String animal) {
    
    
    String displayType = type;
    String displayAnimal = animal;
    
    JLabel Jtype = new JLabel(displayType);
    JLabel Janimal = new JLabel(displayAnimal);

    
    JPanel panel = new JPanel(new GridLayout(0, 1));
    panel.add(Jtype);
    panel.add(Janimal);



   int result = JOptionPane.showConfirmDialog(null, panel, "About the animal",
     
           JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
   
   
    if (result == JOptionPane.OK_OPTION) {
        
        Main.fetchproperties(displayAnimal);
        
        
    } else {
        System.out.println("Cancelled");
       
    }
}
   
  
                
   
}



