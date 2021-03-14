import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GameSquare extends JButton {
    private int xCoord, yCoord, lineCounter;
    //Replace with piece and barricade classes when they are created
    private String piece, barricade;

    public GameSquare(int yCoord, int xCoord) {
        super();
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        Icon icon_regular = new ImageIcon("RegularSquare.jpg");
        Icon icon_landing = new ImageIcon("landingsquare.jpg");
        Icon red_piece = new ImageIcon("redpiece.jpg");
        this.setPreferredSize(new Dimension(40, 40));
        if (isRealBox(yCoord, xCoord)) {
            this.setIcon(icon_regular);
            this.setOpaque(false);
            this.setContentAreaFilled(false);
            this.setBorderPainted(false);
            this.setFocusPainted(false);
        } else {
            this.setEnabled(false);
            this.setOpaque(false);
            this.setVisible(false);
        }
        if (isLandingSquare(yCoord, xCoord)) {
            this.setIcon(icon_landing);
        }
        if (isRedStartSquare(yCoord, xCoord)){
            this.setIcon(new ImageIcon("redpiece.jpg"));
        }
        if (isGreenStartSquare(yCoord, xCoord)){
            this.setIcon(new ImageIcon("greenpiece.jpg"));
        }
        if (isBlueStartSquare(yCoord, xCoord)){
            this.setIcon(new ImageIcon("bluepiece.jpg"));
        }
        if (isYellowStartSquare(yCoord, xCoord)){
            this.setIcon(new ImageIcon("yellowpiece.jpg"));
        }
    }

    public void squareSelected(String piece) {
        this.setForeground(Color.BLACK);
        this.setEnabled(false);
        if (piece.equals("X1")) {
            System.out.println("X1 has clicked");
        } else {
            System.out.println("X2 has clicked");
        }
    }

    private boolean isRealBox(int yCoord, int xCoord) {
        ArrayList<String[]> lines = new ArrayList<String[]>();
        try {
            File myObj = new File("Layout.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines.add(data.split(" "));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return lines.get(yCoord)[xCoord].equals("1");
    }

    private boolean isInitialBarricade(int yCoord, int xCoord) {
        boolean initialBarriacade = false;
        if (yCoord == 1) {
            if (xCoord == 8) {
                initialBarriacade = true;
            }
        } else if (yCoord == 12) {
            if ((xCoord == 0) || (xCoord == 4) || (xCoord == 8) || (xCoord == 12) || (xCoord == 16)) {
                initialBarriacade = true;
            }
        }
        return initialBarriacade;
    }

    private boolean isLandingSquare(int yCoord, int xCoord) {
        boolean landingSquare = false;
        if (yCoord == 14) {
            if ((xCoord == 2) || (xCoord == 6) || (xCoord == 10) || (xCoord == 14)) {
                landingSquare = true;
            }
        }
        return landingSquare;
    }

    private boolean isRedStartSquare(int yCoord, int xCoord) {
        boolean redStart = false;
        if (yCoord == 15) {
            if ((xCoord == 1) || (xCoord == 2) || (xCoord == 3)) {
                redStart = true;
            }
        }
        if (yCoord == 16) {
            if ((xCoord == 1) || (xCoord == 3)) {
                redStart = true;
            }
        }
            return redStart;
    }

    private boolean isGreenStartSquare(int yCoord, int xCoord) {
        boolean Start = false;
        if (yCoord == 15) {
            if ((xCoord == 5) || (xCoord == 6) || (xCoord == 7)) {
                Start = true;
            }
        }
        if (yCoord == 16) {
            if ((xCoord == 5) || (xCoord == 7)) {
                Start = true;
            }
        }
        return Start;
    }


    private boolean isBlueStartSquare(int yCoord, int xCoord) {
        boolean Start = false;
        if (yCoord == 15) {
            if ((xCoord == 9) || (xCoord == 10) || (xCoord == 11)) {
                Start = true;
            }
        }
        if (yCoord == 16) {
            if ((xCoord == 9) || (xCoord == 11)) {
                Start = true;
            }
        }
        return Start;
    }

    private boolean isYellowStartSquare(int yCoord, int xCoord) {
        boolean Start = false;
        if (yCoord == 15) {
            if ((xCoord == 13) || (xCoord == 14) || (xCoord == 15)) {
                Start = true;
            }
        }
        if (yCoord == 16) {
            if ((xCoord == 13) || (xCoord == 15)) {
                Start = true;
            }
        }
        return Start;
    }
}
