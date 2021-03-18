import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class GameWindow extends JFrame implements ActionListener {
    private JPanel topPanel, bottomPanel;
    private JButton saveButton, quitButton;

    public GameWindow(){
        // Setting up the panels and other gui elements
        topPanel = new JPanel(new FlowLayout());
        bottomPanel = new JPanel(new BorderLayout());

        // Generating other gui elements
        saveButton = new JButton("SAVE!");
        saveButton.setPreferredSize(new Dimension(300, 50));

        quitButton = new JButton("QUIT!");
        quitButton.addActionListener(this);
        quitButton.setPreferredSize(new Dimension(300, 50));

        // adding elements to the gui

        topPanel = new GameScreen(17, 16);
        topPanel.setBackground(Color.orange);
        bottomPanel.add(saveButton, BorderLayout.WEST);
        bottomPanel.add(quitButton, BorderLayout.EAST);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);

        // basic settings for the frame
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setSize(800, 800);
    }

    // Action events
    @Override
    public void actionPerformed(ActionEvent e) {
        Object selected = e.getSource();
        // quit button used to quit the game, a message is asked to confirm this
        if (selected==quitButton) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int n = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to quit? All unsaved progress will be deleted",
                    "Warning",
                    dialogButton);
            if (n == JOptionPane.YES_OPTION) {
                this.dispose();
            }
        }
    }
}
