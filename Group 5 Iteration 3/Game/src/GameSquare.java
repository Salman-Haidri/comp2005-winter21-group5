import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameSquare extends JButton {
    private int xCoord, yCoord, lineCounter;
    //Replace with piece and barricade classes when they are created
    private String piece, barricade;

    public ArrayList<int[]> barricadeCoordinates;

    public GameSquare(int yCoord, int xCoord) {
        super();
        this.xCoord = xCoord;
        this.yCoord = yCoord;

        barricadeCoordinates = new ArrayList<int[]>();
        barricadeCoordinates.add(new int[]{1, 8});
        barricadeCoordinates.add(new int[]{11, 0});
        barricadeCoordinates.add(new int[]{11, 4});
        barricadeCoordinates.add(new int[]{11, 8});
        barricadeCoordinates.add(new int[]{11, 12});
        barricadeCoordinates.add(new int[]{11, 16});


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
        if (isBarricade(yCoord, xCoord)){
            this.setIcon(new ImageIcon("barricadepiece.jpg"));
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

    public boolean isBarricade(int yCoord, int xCoord) {
        boolean squareBarriacade = false;
        for (int[]x : barricadeCoordinates){
            if (x[0] == yCoord && x[1] == xCoord){
                return true;
            }
        }
        return squareBarriacade;
    }

    private boolean isLandingSquare(int yCoord, int xCoord) {
        boolean landingSquare = false;
        if (yCoord == 13) {
            if ((xCoord == 2) || (xCoord == 6) || (xCoord == 10) || (xCoord == 14)) {
                landingSquare = true;
            }
        }
        return landingSquare;
    }

    private boolean isRedStartSquare(int yCoord, int xCoord) {
        boolean redStart = false;
        if (yCoord == 14) {
            if ((xCoord == 1) || (xCoord == 2) || (xCoord == 3)) {
                redStart = true;
            }
        }
        if (yCoord == 15) {
            if ((xCoord == 1) || (xCoord == 3)) {
                redStart = true;
            }
        }
            return redStart;
    }

    private boolean isGreenStartSquare(int yCoord, int xCoord) {
        boolean Start = false;
        if (yCoord == 14) {
            if ((xCoord == 5) || (xCoord == 6) || (xCoord == 7)) {
                Start = true;
            }
        }
        if (yCoord == 15) {
            if ((xCoord == 5) || (xCoord == 7)) {
                Start = true;
            }
        }
        return Start;
    }


    private boolean isBlueStartSquare(int yCoord, int xCoord) {
        boolean Start = false;
        if (yCoord == 14) {
            if ((xCoord == 9) || (xCoord == 10) || (xCoord == 11)) {
                Start = true;
            }
        }
        if (yCoord == 15) {
            if ((xCoord == 9) || (xCoord == 11)) {
                Start = true;
            }
        }
        return Start;
    }

    private boolean isYellowStartSquare(int yCoord, int xCoord) {
        boolean Start = false;
        if (yCoord == 14) {
            if ((xCoord == 13) || (xCoord == 14) || (xCoord == 15)) {
                Start = true;
            }
        }
        if (yCoord == 15) {
            if ((xCoord == 13) || (xCoord == 15)) {
                Start = true;
            }
        }
        return Start;
    }
}
