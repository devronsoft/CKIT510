import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;


///**
// * Provides the GUI and encapsulates the DrawPanel

// * Has two private inner classes 
// * One for handling button events
// * Another for handling both combo box events and checkbox events
// */
public class DrawFrame extends JFrame
{
    private static final int kControlX = 88;
      
    private JLabel stausLabel; //label display mouse coordinates
    private DrawPanel panel; //draw panel for the shapes
    
    private JButton undo; // button to undo last drawn shape
    private JButton redo; // button to redo an undo
    private JButton clear; // button to clear panel
    
    private JComboBox colors; //combobox with color options
    
    //array of strings containing color options for JComboBox colors
    private final String colorOptions[]=
    {"Select colour", "Black","Blue","Cyan","Dark Gray","Gray","Green","Light Gray",
        "Magenta","Orange","Pink","Red","White","Yellow"};
    
    //aray of Color objects contating Color constants
    //Note that the label - select colour is part of the array, so the 0 index is just set to black as a default
    private final Color colorArray[]=
    {Color.BLACK, Color.BLACK , Color.BLUE , Color.CYAN , Color.darkGray , Color.GRAY , 
        Color.GREEN, Color.lightGray , Color.MAGENTA , Color.ORANGE , 
    Color.PINK , Color.RED , Color.WHITE , Color.YELLOW};
    
    private final JComboBox shapes; //combobox with shape option
    private final JRadioButtonMenuItem shape1;
    
    
    //array of strings containing shape options for JComboBox shapes
    private final String shapeOptions[]=
    {"Select a shape", "Line","Rectangle","Oval"};
    //Note that the label - select a shape - is part of the array, so the switch statement in the method ignores 0 when assigning a shape method
    
    private JCheckBox filled; //checkbox to select whether shape is filled or not
        
    private JPanel widgetJPanel; //holds the widgets: buttons, comboboxes and checkbox
    private JPanel widgetPadder; //encapsulates widgetJPanel and adds padding around the edges 
    
    /**
     * This constructor sets the name of the JFrame.
     * It also creates a DrawPanel object that extends JPanel for drawing the shapes and contains
     * a statuslabel for mouse position.
     * Initializes widgets for buttons, comboboxes and checkbox
     * It also adds event handlers for the widgets
     */
    public DrawFrame()
    {
        super("Ryan and Ryan's basic drawing application"); //sets the name of DrawFrame
        
        addMenu();
        
        JLabel statusLabel = new JLabel( "" ); //create JLabel object to pass into DrawPanel
        
        panel = new DrawPanel(statusLabel); //create draw panel and pass in JLabel
        
        //create buttons
        undo = new JButton( "Undo" );
        redo = new JButton( "Redo" );
        clear = new JButton( "Clear" );
        
        undo.setVisible(false);
        redo.setVisible(false);
        clear.setVisible(false);
        
        //create comboboxes
        colors = new JComboBox( colorOptions );
        shapes = new JComboBox( shapeOptions );
        shape1 = new JRadioButtonMenuItem("Line");
        
        // 12MAY - hide buttons and checkbox to use menu functionality only
        colors.setVisible(false);
        shapes.setVisible(false);
        
        //create checkbox
        filled = new JCheckBox( "Filled" );
        
        filled.setVisible(false);
        
        //JPanel object, widgetJPanel, with grid layout for widgets
        widgetJPanel = new JPanel();
        widgetJPanel.setLayout( new GridLayout( 1, 6, 10, 10 ) ); //sets padding between widgets in gridlayout
        
        //JPanel object, widgetPadder, with flowlayout to encapsulate and pad the widgetJPanel
        widgetPadder = new JPanel();
        widgetPadder.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 5)); //sets padding around the edges
            
        // add widgets to widgetJPanel
        widgetJPanel.add( undo );
        widgetJPanel.add( redo );
        widgetJPanel.add( clear );
        widgetJPanel.add( colors );
        widgetJPanel.add( shapes );                 
        widgetJPanel.add( filled );
        // add widgetJPanel to widgetPadder
        widgetPadder.add( widgetJPanel );
        
        //add widgetPadder and panel to JFrame
       add( widgetPadder, BorderLayout.NORTH);
        add( panel, BorderLayout.CENTER);
        
        // create new ButtonHandler for button event handling
        ButtonHandler buttonHandler = new ButtonHandler();
        undo.addActionListener( buttonHandler );
        redo.addActionListener( buttonHandler );
        clear.addActionListener( buttonHandler );
        
        //create handlers for combobox and checkbox
        ItemListenerHandler handler = new ItemListenerHandler();
        colors.addItemListener( handler );
        shapes.addItemListener( handler );
        filled.addItemListener( handler );
        
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setSize( 800, 800 );
        setVisible( true );
        // Set to centre of screen on launch
        setLocationRelativeTo(null); 
        
    } // end DrawFrame constructor
    
    /**
     * private inner class for button event handling
     */
    private class ButtonHandler implements ActionListener
    {
        // handles button events
        @Override public void actionPerformed( ActionEvent event )
        {
            switch(event.getActionCommand())
            {
                case "Undo":panel.clearLastShape();break;
                case "Redo":panel.redoLastShape();break;
                case "Clear":panel.clearDrawing(); filled.setVisible(false); colors.setVisible(false); shapes.setVisible(false); break;
                default: break;
            }
                         
        } // end method actionPerformed
    } // end private inner class ButtonHandler
    
    /**
     * private inner class for checkbox and combobox event handling
     */
    private class ItemListenerHandler implements ItemListener
    {
        
        @Override public void itemStateChanged( ItemEvent event )
        {
            // process filled checkbox events
            if ( event.getSource() == filled)// || event.getSource() == fill)
            {
                //boolean checkFill1=fill.isSelected() ? true :false;
                boolean checkFill=filled.isSelected() ? true : false; //
                panel.setCurrentShapeFilled(checkFill);
                
                
                
            }
            
            // determine whether combo box selected
            if ( event.getStateChange() == ItemEvent.SELECTED )
            {
                //if event source is combo box colors pass in colorArray at index selected.
                if ( event.getSource() == colors)
                {
                    panel.setCurrentShapeColor
                        (colorArray[colors.getSelectedIndex()]);
                    
                            colors.setVisible(true);
       
                }
                
                //else if event source is combo box shapes pass in index selected
                else if ( event.getSource() == shapes)
                {
                    panel.setCurrentShapeType(shapes.getSelectedIndex());
                    
                     shapes.setVisible(true);
                }
                
                filled.setVisible(true);
            }
            
        } // end method itemStateChanged
    }
    
    
    
    private void addMenu()
    {
        JMenuBar menubar = new JMenuBar(); // create the menu bar
        
        // file menu
        JMenu file = new JMenu("File"); 
        JMenuItem exit = new JMenuItem("Exit"); // create submenu item
        file.add(exit);   // adds exit to file menu
        JMenuItem about = new JMenu("About"); 
        JMenuItem info = new JMenuItem("About this application"); 
        JMenuItem info2 = new JMenuItem("About the University of Liverpool"); 
        file.add(about);
        about.add(info);
        about.add(info2);
        
        // edit menu
        JMenu edit = new JMenu("Edit");
        JMenuItem undoMI = new JMenuItem("Undo"); // add undo
        JMenuItem redoMI = new JMenuItem("Redo"); // add redo
        JMenuItem clearMI = new JMenuItem("Clear"); // add clear
        edit.add(undoMI); // adds undo to edit menu
        edit.add(redoMI); // adds redo to edit menu
        edit.add(clearMI); // adds clear to edit menu
        
        // Options Menu
        JMenu options = new JMenu("Options");
        JMenu colour = new JMenu("Colours"); // adds the colour option
        JMenu shape = new JMenu("Shape"); // adds the colour option
        JCheckBoxMenuItem fill = new JCheckBoxMenuItem("Fill"); // adds option to fill 
        options.add(colour); // adds the colour option to the menu
        options.add(shape); // adds the shape option to the menu
        options.add(fill); // adds the fill option to the options menu
        
        //colorOptions
        JRadioButtonMenuItem c1 = new JRadioButtonMenuItem("Black");
        JRadioButtonMenuItem c2 = new JRadioButtonMenuItem("Blue");
        JRadioButtonMenuItem c3 = new JRadioButtonMenuItem("Cyan");
        JRadioButtonMenuItem c4 = new JRadioButtonMenuItem("Dark Gray");
        JRadioButtonMenuItem c5 = new JRadioButtonMenuItem("Gray");
        JRadioButtonMenuItem c6 = new JRadioButtonMenuItem("Green");
        JRadioButtonMenuItem c7 = new JRadioButtonMenuItem("Light Gray");
        JRadioButtonMenuItem c8 = new JRadioButtonMenuItem("Magenta");
        JRadioButtonMenuItem c9 = new JRadioButtonMenuItem("Orange");
        JRadioButtonMenuItem c10 = new JRadioButtonMenuItem("Pink");
        JRadioButtonMenuItem c11 = new JRadioButtonMenuItem("Red");
        JRadioButtonMenuItem c12 = new JRadioButtonMenuItem("White");
        JRadioButtonMenuItem c13 = new JRadioButtonMenuItem("Yellow");
        
        ButtonGroup group = new ButtonGroup();
        group.add(c1);
        group.add(c2);
        group.add(c3);
        group.add(c4);
        group.add(c5);
        group.add(c6);
        group.add(c7);
        group.add(c8);
        group.add(c9);
        group.add(c10);
        group.add(c11);
        group.add(c12);
        group.add(c13);
        
        colour.add(c1);
        colour.add(c2);
        colour.add(c3);
        colour.add(c4);
        colour.add(c5);
        colour.add(c6);
        colour.add(c7);
        colour.add(c8);
        colour.add(c9);
        colour.add(c10);
        colour.add(c11);
        colour.add(c12);
        colour.add(c13);
       
        // Shape option
        ButtonGroup group2 = new ButtonGroup();
        JRadioButtonMenuItem shape1 = new JRadioButtonMenuItem("Line");
        JRadioButtonMenuItem shape2 = new JRadioButtonMenuItem("Rectangle");
        JRadioButtonMenuItem shape3 = new JRadioButtonMenuItem("Oval");
        
        group2.add(shape1);
        group2.add(shape2);
        group2.add(shape3);
        
        shape.add(shape1);
        shape.add(shape2);
        shape.add(shape3);
        
   

  
        
        // Event handlers for the menu bar
        exit.addActionListener(new exitApp()); // exit event listener.
        
        info.addActionListener(new displayInfo1()); // exit event listener.
        info2.addActionListener(new displayInfo2()); // exit event listener.
        
        
        undoMI.addActionListener(new ButtonHandler()); // event that triggers the undo 
        redoMI.addActionListener(new ButtonHandler()); // event that triggers the redo
        clearMI.addActionListener(new ButtonHandler()); // event that triggers the clear
        shape1.addActionListener(new RadioHandler()); // event sets the shapes to line
        shape2.addActionListener(new RadioHandler()); // event sets the shapes to Rectangle
        shape3.addActionListener(new RadioHandler()); // event sets the shapes to Oval
        c1.addActionListener(new RadioHandler()); // sets combobox to black
        c2.addActionListener(new RadioHandler()); // sets combobox to blue
        c3.addActionListener(new RadioHandler()); // sets combobox to Cyan
        c4.addActionListener(new RadioHandler()); // sets combobox to Dark Gray
        c5.addActionListener(new RadioHandler()); // sets combobox to Gray
        c6.addActionListener(new RadioHandler()); // sets combobox to Green
        c7.addActionListener(new RadioHandler()); // sets combobox to Light Gray
        c8.addActionListener(new RadioHandler()); // sets combobox to Magenta
        c9.addActionListener(new RadioHandler()); // sets combobox to Orange
        c10.addActionListener(new RadioHandler()); // sets combobox to Pink
        c11.addActionListener(new RadioHandler()); // sets combobox to Red
        c12.addActionListener(new RadioHandler()); // sets combobox to White
        c13.addActionListener(new RadioHandler()); // sets combobox to Yellow
        //fill.addActionListener(new FillCheckHandler()); // sets the filled option
        
        fill.addItemListener(new ItemListener() {
      @Override public void itemStateChanged(ItemEvent e) 
      {
          if (fill.getState() == true)
          {
              filled.setSelected(true);
          }
          else
          {
              filled.setSelected(false);
          }   
      }
      });
                             
        // Completed the Menu Bar.
        menubar.add(file); // adds file to the menu bar
        menubar.add(edit); // adds edit to the menu bar
        menubar.add(options); // adds options to the menu bar
        this.setJMenuBar(menubar);
    }
    
        static class exitApp implements ActionListener
    {
        @Override public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
        
                static class displayInfo1 implements ActionListener
    {
        @Override public void actionPerformed(ActionEvent e)
        {
           JOptionPane.showMessageDialog(null, "This basic drawing application has been developed by Ryan Smith and Ryan Varcoe \n as the final group project for the Java Object Oriented Programming module.", "About this application", JOptionPane.INFORMATION_MESSAGE);
        }
    }
                
                static class displayInfo2 implements ActionListener
    {
        @Override public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(null, "The University of Liverpool is a public university based in the city of Liverpool, England. \nFounded as a college in 1881, it gained its royal charter in 1903 with the ability to award degrees and is also known to be one of the six original \"red brick\" civic universities. \nIt comprises three faculties organised into 35 departments and schools.", "About the University", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private class RadioHandler implements ActionListener
    {
        // handles button events
        @Override public void actionPerformed( ActionEvent event )
        {
            switch(event.getActionCommand())
            {
                case "Oval":shapes.setSelectedItem("Oval");break;
                case "Rectangle":shapes.setSelectedItem("Rectangle");break;
                case "Line":shapes.setSelectedItem("Line");break;
                
                case "Black":colors.setSelectedItem("Black");break;
                case "Blue":colors.setSelectedItem("Blue");break;
                case "Cyan":colors.setSelectedItem("Cyan");break;
                case "Dark Gray":colors.setSelectedItem("Dark Gray");break;
                case "Gray":colors.setSelectedItem("Gray");break;
                case "Green":colors.setSelectedItem("Green");break;
                case "Light Gray":colors.setSelectedItem("Light Gray");break;
                case "Magenta":colors.setSelectedItem("Magenta");break;
                case "Orange":colors.setSelectedItem("Orange");break;
                case "Pink":colors.setSelectedItem("Pink");break;
                case "Red":colors.setSelectedItem("Red");break;
                case "White":colors.setSelectedItem("White");break;
                case "Yellow":colors.setSelectedItem("Yellow");break;
                default: break;
            }
        } // end method actionPerformed
    } // end private inner class ButtonHandler
} // end class DrawFrame