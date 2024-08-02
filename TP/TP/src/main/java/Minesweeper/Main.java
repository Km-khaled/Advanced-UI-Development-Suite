package Minesweeper;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Random;


public class Main extends JPanel implements ActionListener{
    private static JFrame frame;
    private static Main main;
    private static int width = 30;
    private static int height = 16;
    private static int windowWidth = 750;
    private static int windowHeight = 600;
    private static int frameWidth = 690;
    private static int frameHeight = 370;
    private static int[][] board = new int[height][width];
    private static int[][] onOffBoard = new int[height][width];
    private static int [] template = {-1, 0, 1};
    private Timer timer;
    private static Timer secondsTimer;
    private static int startX = 20;
    private static int startY = 110;
    private static boolean firstClick = true;
    private static boolean gameOver = false;
    private static Color buttonColorChange = Color.LIGHT_GRAY;
    private static String buttonFace = ":)";
    private static int numBombsLeft = 99;
    private static int secondsCounter = 0;

    public Main(){
        for (int i=0; i<height; i++){
            Arrays.fill(onOffBoard[i], 1);
        }
        timer = new Timer(1000/30, this);
        timer.start();
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                secondsCounter++;
            }
        };
        secondsTimer = new Timer(1000, taskPerformer);

    }

    public static void makeBoard(int y, int x){
        for (int i=0; i<height; i++){
            Arrays.fill(board[i], 0);
        }
        int K = 99; // number of mines
        Random rand = new Random();
        int templateIndex1 = 0;
        int templateIndex2 = 0;

        while (--K > 0){
            if (K == 0){
                break;
            }

            int rand1 = rand.nextInt(16);
            int rand2 = rand.nextInt(30);

            if (board[rand1][rand2] == 9){ // if mine is already there extend loop
                K++;
                continue;
            }
            if (rand1 == y && rand2 == x){ // if mine is chosen on first click
                K++;
                continue;
            }

            board[rand1][rand2] = 9; // plant mine
            for (int index1=0; index1<3; index1++){ // set the numbers around mine
                for (int index2=0; index2<3; index2++){
                    templateIndex1 = template[index1];
                    templateIndex2 = template[index2];

                    try{
                        int pos = board[rand1+templateIndex1][rand2+templateIndex2];
                        if (pos != 9){

                            board[rand1+templateIndex1][rand2+templateIndex2] = pos+1;
                        }
                    }catch(java.lang.ArrayIndexOutOfBoundsException e){

                    }
                }
            }
            System.out.println(board[y][x]);
        }
    }
    public static void main(String args[]){
        frame = new JFrame("Minesweeper");
        frame.setLayout(new BorderLayout());


        Main game = new Main();
        frame.add(game, BorderLayout.CENTER);

        frame.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){

                if (!gameOver){
                    if (e.getX() >= startX+10 && e.getX() <= (startX+10)+frameWidth){
                        if (e.getY() >= startY+35 && e.getY() <= startY+35+frameHeight){
                            int x = (e.getX()-startX-11)/23;
                            int y = (e.getY()-startY-36)/23;
                            if (e.getButton() == MouseEvent.BUTTON3){
                                if (onOffBoard[y][x] == 2){
                                    onOffBoard[y][x] = 1;
                                    numBombsLeft += 1;
                                }else{
                                    if (onOffBoard[y][x] != 0){
                                        onOffBoard[y][x] = 2;
                                        numBombsLeft -= 1;
                                    }
                                }
                            }else{
                                if (onOffBoard[y][x] != 2){
                                    if (firstClick){
                                        secondsTimer.start();
                                        board[y][x] = 0;
                                        while (true){
                                            makeBoard(y, x);
                                            if (board[y][x] == 0){
                                                break;
                                            }
                                        }
                                        firstClick = false;
                                    }
                                    if (board[y][x] != 9){
                                        expand(y, x);
                                    }else{
                                        secondsTimer.stop();
                                        buttonFace = "X(";
                                        gameOver();
                                    }
                                }
                            }
                        }
                    }
                }
                hasWon();
            }
        });
        frame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                if (e.getX() >= 350 && e.getX() <= 400){ // over the game button
                    if (e.getY() >= 70 && e.getY() <= 120){
                        buttonColorChange = Color.GRAY;
                        gameOver = false;
                        firstClick = true;
                        secondsCounter = 0;
                        secondsTimer.start();
                        for (int i=0; i<height; i++){
                            Arrays.fill(onOffBoard[i], 1);
                        }
                    }
                }
                if (!gameOver){
                    if (e.getX() >= startX+10 && e.getX() <= (startX+10)+frameWidth){
                        if (e.getY() >= startY+35 && e.getY() <= startY+35+frameHeight){
                            buttonFace = ":o";
                        }
                    }
                }
            }
            public void mouseReleased(MouseEvent e){
                if (!gameOver){
                    buttonColorChange = Color.LIGHT_GRAY;
                    buttonFace = ":)";
                }

            }

        });
        frame.setVisible(true);
        frame.setSize(windowWidth, windowHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void gameOver(){
        gameOver = true;
        for (int i=0; i<height; i++){
            for (int j=0; j<width; j++){
                if (board[i][j] == 9){
                    onOffBoard[i][j] = 0;
                }
            }
        }
    }
    public static void hasWon(){
        int blankCounter = 0;
        for (int i=0; i<height; i++){
            for (int j=0; j<width; j++){
                if (onOffBoard[i][j] == 0){
                    blankCounter++;
                }
            }
        }
        if (blankCounter == 382){
            buttonFace = "B)";
            gameOver();
        }
    }
    public static void expand(int cellY, int cellX){
        try{
            if (board[cellY][cellX] == 0 && onOffBoard[cellY][cellX] == 1){
                onOffBoard[cellY][cellX] = 0;
                expand(cellY+1, cellX);
                expand(cellY-1, cellX);
                expand(cellY, cellX+1);
                expand(cellY, cellX-1);
                expand(cellY+1, cellX+1);
                expand(cellY-1, cellX-1);
                expand(cellY-1, cellX+1);
                expand(cellY+1, cellX-1);
            }
            else{
                if (onOffBoard[cellY][cellX] == 1){
                    onOffBoard[cellY][cellX] = 0;
                }
            }
        }
        catch(java.lang.ArrayIndexOutOfBoundsException e){

        }

    }
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(startX, startY, frameWidth, frameHeight);
        for (int i=0; i<height; i++){
            for (int j=0; j<width; j++){
                if (onOffBoard[i][j] == 1){
                    g.setColor(Color.BLACK);
                    g.fillRect(startX+j*23, startY+i*23, 22, 22);
                }else if (onOffBoard[i][j] == 0){
                    if (board[i][j] == 9){
                        if (buttonFace != "B)"){
                            g.setColor(Color.RED);
                        }
                    }else{
                        g.setColor(Color.LIGHT_GRAY);
                    }
                    g.fillRect(startX+j*23, startY+i*23, 22, 22);
                    g.setColor(Color.BLACK);
                    g.setFont(new Font("Courier", Font.PLAIN, 14));
                    if (board[i][j] != 9)
                        g.drawString(Integer.toString(board[i][j]), startX+8+j*23, startY+15+i*23);
                    else
                        g.drawString("B", startX+8+j*23, startY+15+i*23);
                }else{
                    g.setColor(Color.GREEN);
                    g.fillRect(startX+j*23, startY+i*23, 22, 22);
                }
                g.setColor(buttonColorChange);
                g.fillRect(350, 30, 50, 50);
                g.setColor(Color.BLACK);
                g.drawString(buttonFace, 365, 55);
                g.fillRect(150, 30, 70, 50);
                g.fillRect(530, 30, 70, 50);
                g.setColor(Color.WHITE);
                g.setFont(new Font("Courier", Font.PLAIN, 24));
                g.drawString(Integer.toString(numBombsLeft), 175, 55);
                g.drawString(Integer.toString(secondsCounter), 555, 55);
            }

        }


    }
    public void printBoard(){ // for test
        for (int i=0; i<height; i++){
            for (int j=0; j<width; j++){
                System.out.print(board[i][j]);
            }
            System.out.println("\n");
        }
    }



    public void actionPerformed(ActionEvent e) {
        repaint();

    }


}