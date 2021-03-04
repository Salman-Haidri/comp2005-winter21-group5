import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.*;

import javax.swing.border.*;


public class Theme extends JFrame implements ActionListener {
    JPanel panel,topPanel, bottomPanel;
    JLabel user_label, text, message;
    JTextField userName_text;
    JButton btn, back;

    public Theme() {
        // TODO Auto-generated method stub
        this.setSize(800, 800);

    panel = new JPanel(new GridLayout(3, 0));
      topPanel = new JPanel(new FlowLayout());
      bottomPanel = new JPanel(new GridLayout(3, 0));

      

      

      JLabel title = new JLabel("<html><h1><strong>Select a theme</strong></h1><hr></html>");
    title.setAlignmentX(Component.CENTER_ALIGNMENT);


    topPanel.add(title);
    



    String[] choices = { "R,G,B,Y", "X, O ,Y , □", "❤︎ , ♦ , ♠ , ♣", };

    final JComboBox<String> cb = new JComboBox<String>(choices);

    cb.setMaximumSize(cb.getPreferredSize());
    cb.setAlignmentX(Component.CENTER_ALIGNMENT);
    

     btn = new JButton("OK");
    btn.setAlignmentX(Component.CENTER_ALIGNMENT); 

     back = new JButton("BACK");
     back.setAlignmentX(Component.CENTER_ALIGNMENT); 

    Border b2 = new EmptyBorder(100, 100, 100, 100);
    bottomPanel.add(btn, b2);
    bottomPanel.add(back, b2);
  
    back.addActionListener(this);
    btn.addActionListener(this);
    
     panel.add(topPanel);
     panel.add(cb,b2);
     panel.add(bottomPanel);
     add(panel);
     
     
      setTitle("Enter your username Here !");
      setVisible(true);
    }

    public void actionPerformed(ActionEvent aevt)
	{
		// get the object that was selected in the GUI
		Object selected = aevt.getSource();
				
		// if the 'New Game' button is clicked then these actions are performed
		if ( selected.equals(btn) )
		{
			this.dispose();
			//Go to difficulty
		}
		if ( selected.equals(back) )
		{
			this.dispose();
			Username username = new Username();
		}
		
		
	}
    
}
