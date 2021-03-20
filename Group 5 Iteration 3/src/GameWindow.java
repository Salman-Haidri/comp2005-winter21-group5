import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GameWindow extends JPanel implements ActionListener{
	
	
//	private static JFrame frame;
	private final JLabel player1Label;
	private final JLabel player2Label;
	private final JLabel player3Label;
	private final JLabel player4Label;
	
	private final JLayeredPane boardPane;
	
	private JPanel topPanel;
	private JButton saveButton, quitButton;
	
	public GameWindow() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		final ImageIcon dieImg = createImageIcon("die_1.png");
		
		boardPane = new JLayeredPane();
		boardPane.setPreferredSize(new Dimension(700, 700));
		
        // Setting up the panels and other gui elements
        topPanel = new JPanel(new FlowLayout());
        
        topPanel = new GameScreen(17, 16);
        topPanel.setBackground(new Color(176, 189, 184));
        
        JPanel rightPane = new JPanel();
		rightPane.setLayout(new GridBagLayout());
		
		JPanel saveP = new JPanel();
		saveP.setPreferredSize(new Dimension(75, 75));
		saveP.setLayout(new GridBagLayout());
		
		saveButton = new JButton("Save");
		saveButton.addActionListener(this);
		saveP.add(saveButton, new GridBagConstraints());
		saveP.setBackground(new Color(176, 189, 184));
		
		JPanel quitP = new JPanel();
		quitP.setPreferredSize(new Dimension(75, 75));
		quitP.setLayout(new GridBagLayout());
		
		quitButton = new JButton("Quit");
		quitButton.addActionListener(this);
		quitP.add(quitButton, new GridBagConstraints());
		quitP.setBackground(new Color(176, 189, 184));
		
		JPanel dieLayer = new JPanel();
		dieLayer.setPreferredSize(new Dimension(200, 200));
		dieLayer.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.black), "Die Roll"));
		dieLayer.setLayout(new GridBagLayout());
		
		JLabel die = new JLabel(dieImg);
		dieLayer.add(die, new GridBagConstraints());
		dieLayer.setBackground(new Color(176, 189, 184));
		
		JPanel playersLayer = new JPanel();
		playersLayer.setPreferredSize(new Dimension(200, 200));
		playersLayer.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.black), "Players"));
		player1Label = new JLabel("Player 1");
		player2Label = new JLabel("Player 2");
		player3Label = new JLabel("Player 3");
		player4Label = new JLabel("Player 4");
		playersLayer.setLayout(new GridBagLayout());
		playersLayer.setBackground(new Color(176, 189, 184));
		
		GridBagConstraints playGrid = new GridBagConstraints();
		playGrid.gridy = 0;
		playersLayer.add(player1Label, playGrid);
		playGrid.gridy = 1;
		playersLayer.add(player2Label, playGrid);
		playGrid.gridy = 2;
		playersLayer.add(player3Label, playGrid);
		playGrid.gridy = 3;
		playersLayer.add(player4Label, playGrid);
		
		GridBagConstraints theGrid = new GridBagConstraints();
		theGrid.gridy = 0;
		rightPane.add(dieLayer, theGrid);
		theGrid.gridy = 1;
		rightPane.add(playersLayer, theGrid);
		theGrid.gridy = 2;
		rightPane.add(saveP, theGrid);
		theGrid.gridy = 3;
		rightPane.add(quitP, theGrid);
		rightPane.setBackground(new Color(176, 189, 184));
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(topPanel);
		add(rightPane);
	}
	
	
	
	private ImageIcon createImageIcon(final String src) {
		try {
			BufferedImage bluePawn = ImageIO.read(new File(src));
			ImageIcon icon = new ImageIcon(bluePawn);
			return icon;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return null;
		}
		
	}
	
	// Action events
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
            	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            	frame.dispose();

            }
        }
    }
	

	
}


