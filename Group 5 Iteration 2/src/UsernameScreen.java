import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsernameScreen extends JFrame implements ActionListener {
    private JPanel titlePanel, mainPanel;
    private JLabel usernameLabel, gameName;
    private JTextField usernameTextField;
    private JButton nextButton, backButton;

    public UsernameScreen(){
        GridBagConstraints gc = new GridBagConstraints();

        // Setting up the panels and other gui elements
        titlePanel = new JPanel();
        titlePanel.setLayout(new GridBagLayout());

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        // Setting up gui elements
        gameName = new JLabel("<html><h1><strong><i>MALEFIZ</i></strong></h1><hr></html>");

        usernameLabel = new JLabel("<html><h2>Username:</h2></html>");
        usernameLabel.setPreferredSize(new Dimension(300, 50));

        usernameTextField = new JTextField();
        usernameTextField.setPreferredSize(new Dimension(300, 50));

        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        nextButton.setPreferredSize(new Dimension(300, 50));

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(300, 50));
        backButton.addActionListener(this);

        // adding elements to the gui

        gc.anchor = GridBagConstraints.NORTH;
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 0;
        titlePanel.add(gameName, gc);

        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(usernameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.WEST;
        mainPanel.add(usernameTextField, gc);

        gc.gridwidth = GridBagConstraints.REMAINDER;
        gc.gridx = 0;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(backButton, gc);

        gc.gridwidth = GridBagConstraints.REMAINDER;
        gc.gridx = 0;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(nextButton, gc);

        // Setting up some basic frame parameters
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(titlePanel, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setSize(800, 800);

    }

    // Action event methods
    @Override
    public void actionPerformed(ActionEvent e) {
        Object selected = e.getSource();
        if (selected.equals(nextButton)){
            if (usernameTextField.getText().equals("")){
                JOptionPane.showMessageDialog(this, "PLEASE ENTER A VALID UNIQUE USERNAME");
            }
            else {
                dispose();
                ThemeScreen themeScreen = new ThemeScreen();
            }
        }
        if (selected.equals(backButton)){
            dispose();
            Opponent opponent = new Opponent();
        }
    }
}
