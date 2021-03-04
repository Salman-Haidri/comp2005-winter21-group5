import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.*;

import javax.swing.border.*;


public class Username extends JFrame implements ActionListener {
    JPanel panel,topPanel, bottomPanel;
    JLabel user_label, text, message;
    JTextField userName_text;
    JButton submit, back;

    public Username() {
        // TODO Auto-generated method stub
        this.setSize(800, 800);
		user_label = new JLabel();
      user_label.setText("User Name :");
      
      userName_text = new JTextField(20);
      // Submit
      

      submit = new JButton("SUBMIT");
      panel = new JPanel(new GridLayout(3, 1));

      topPanel = new JPanel(new FlowLayout());
      bottomPanel = new JPanel(new GridLayout(3, 0));

      topPanel.add(user_label);
      topPanel.add(userName_text);

      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridwidth = GridBagConstraints.REMAINDER;

      message = new JLabel("<html><h1><strong>Enter username</strong></h1><hr></html>");
      message.setHorizontalAlignment(SwingConstants.CENTER);
      message.setVerticalAlignment(SwingConstants.CENTER);
      panel.add(message);
      
      topPanel.setSize(200,100);
      topPanel.setAlignmentY(SwingConstants.CENTER);

      Border b2 = new EmptyBorder(100, 100, 100, 100);
    
      back = new JButton("BACK");
     back.setAlignmentX(Component.CENTER_ALIGNMENT); 


      bottomPanel.add(submit, b2);
      bottomPanel.add(back, b2);
 

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Adding the listeners to components..
      submit.addActionListener(this);
      back.addActionListener(this);
        
      panel.add(topPanel);
      panel.add(bottomPanel);
      add(panel, BorderLayout.CENTER);
     
      setTitle("Enter your username Here !");
      setVisible(true);
    }

    public void actionPerformed(ActionEvent aevt)
	{
		// get the object that was selected in the GUI
		Object selected = aevt.getSource();
				
		// if the 'New Game' button is clicked then these actions are performed
		if ( selected.equals(submit) )
		{
			this.dispose();
			Theme op = new Theme();
		}
		if ( selected.equals(back) )
		{
			this.dispose();
			Opponent op = new Opponent();
		}
		
		
	}
    
}
