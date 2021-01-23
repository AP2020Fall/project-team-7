package DotsAndBoxes;

import Plato.Model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Dots extends JFrame implements MouseMotionListener, MouseListener {
    public static final int DOT_GAP = 40;
    public static final int DOT_SIZE = 10;
    public static final int PLAYER_ONE = 1;
    public static final int PLAYER_TWO = 2;
    public static final Color PLAYER_ONE_COLOR = Color.CYAN;
    public static final Color PLAYER_TWO_COLOR = Color.PINK;
    public int DOT_NUMBER = 8;
    private ConnectionSprite[] horizontalConnections;
    private ConnectionSprite[] verticalConnections;
    private BoxSprite[] boxes;
    private Sprite[] dots;
    private Dimension dim;
    private int clickX;
    private int clickY;
    private int mouseX;
    private int mouseY;
    private int centerX;
    private int centerY;
    private int side;
    private int space;
    private int activePlayer;
    private Player currentPlayer;

    public Dots(Player player) {
        super("playing dots and boxes");

        setSize(600, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);
        addMouseMotionListener(this);
        loadProperties();
        loadDots();
        startNewGame();
        setVisible(true);
        currentPlayer = player;
    }

    private void loadProperties() {
        clickX = 0;
        clickY = 0;
        mouseX = 0;
        mouseY = 0;
        dim = getSize();
        centerX = dim.width / 2;
        centerY = (dim.height - 100) / 2;
        side = DOT_NUMBER * DOT_SIZE + (DOT_NUMBER - 1) * DOT_GAP;    //	There is one less connection than dot per side
        space = DOT_SIZE + DOT_GAP;
    }

    private void loadConnections() {
        horizontalConnections = new ConnectionSprite[(DOT_NUMBER - 1) * DOT_NUMBER];
        verticalConnections = new ConnectionSprite[(DOT_NUMBER - 1) * DOT_NUMBER];
        for (int i = 0; i < horizontalConnections.length; i++) {
            int colsX = i % (DOT_NUMBER - 1);
            int rowsX = i / (DOT_NUMBER - 1);
            int horX = centerX - side / 2 + DOT_SIZE + colsX * space;
            int horY = centerY - side / 2 + rowsX * space;
            horizontalConnections[i] = ConnectionSprite.createConnection(ConnectionSprite.HORZ_CONN, horX, horY);
            int colsY = i % DOT_NUMBER;
            int rowsY = i / DOT_NUMBER;
            int vertX = centerX - side / 2 + colsY * space;
            int vertY = centerY - side / 2 + DOT_SIZE + rowsY * space;
            verticalConnections[i] = ConnectionSprite.createConnection(ConnectionSprite.VERT_CONN, vertX, vertY);
        }
    }

    private void loadBoxes() {
        boxes = new BoxSprite[(DOT_NUMBER - 1) * (DOT_NUMBER - 1)];
        for (int i = 0; i < boxes.length; i++) {
            int cols = i % (DOT_NUMBER - 1);
            int rows = i / (DOT_NUMBER - 1);
            int boxX = centerX - side / 2 + DOT_SIZE + cols * space;
            int boxY = centerY - side / 2 + DOT_SIZE + rows * space;
            ConnectionSprite[] horConn = new ConnectionSprite[2];
            horConn[0] = horizontalConnections[i];
            horConn[1] = horizontalConnections[i + (DOT_NUMBER - 1)];
            ConnectionSprite[] verConn = new ConnectionSprite[2];
            verConn[0] = verticalConnections[i + rows];
            verConn[1] = verticalConnections[i + rows + 1];
            boxes[i] = BoxSprite.createBox(boxX, boxY, horConn, verConn);
        }
    }

    private void loadDots() {
        dots = new Sprite[DOT_NUMBER * DOT_NUMBER];
        for (int rows = 0; rows < DOT_NUMBER; rows++) {
            for (int cols = 0; cols < DOT_NUMBER; cols++) {
                Sprite dot = new Sprite();
                dot.width = DOT_SIZE;
                dot.height = DOT_SIZE;
                dot.x = centerX - side / 2 + cols * space;
                dot.y = centerY - side / 2 + rows * space;
                dot.shape.addPoint(-DOT_SIZE / 2, -DOT_SIZE / 2);
                dot.shape.addPoint(-DOT_SIZE / 2, DOT_SIZE / 2);
                dot.shape.addPoint(DOT_SIZE / 2, DOT_SIZE / 2);
                dot.shape.addPoint(DOT_SIZE / 2, -DOT_SIZE / 2);
                int index = rows * DOT_NUMBER + cols;
                dots[index] = dot;
            }
        }
    }

    private void startNewGame() {
        activePlayer = PLAYER_ONE;
        loadConnections();
        loadBoxes();
    }

    private ConnectionSprite getConnection(int x, int y) {
        for (int i = 0; i < horizontalConnections.length; i++) {
            if (horizontalConnections[i].containsPoint(x, y)) {
                return horizontalConnections[i];
            }
        }

        for (int i = 0; i < verticalConnections.length; i++) {
            if (verticalConnections[i].containsPoint(x, y)) {
                return verticalConnections[i];
            }
        }
        return null;
    }

    private boolean[] getBoxStatus() {
        boolean[] status = new boolean[boxes.length];
        for (int i = 0; i < status.length; i++) {
            status[i] = boxes[i].isBoxed();
        }
        return status;
    }

    private int[] calculateScores() {
        int[] scores = {0, 0};
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i].isBoxed() && boxes[i].player != 0) {
                scores[boxes[i].player - 1]++;
            }
        }
        return scores;
    }

    private boolean makeConnection(ConnectionSprite connection) {
        boolean newBox = false;
        boolean[] boxStatusBeforeConnection = getBoxStatus();
        connection.connectionMade = true;
        boolean[] boxStatusAfterConnection = getBoxStatus();
        for (int i = 0; i < boxes.length; i++) {
            if (boxStatusAfterConnection[i] != boxStatusBeforeConnection[i]) {
                newBox = true;
                boxes[i].player = activePlayer;
            }
        }
        if (!newBox) {
            if (activePlayer == PLAYER_ONE)
                activePlayer = PLAYER_TWO;
            else
                activePlayer = PLAYER_ONE;
        }
        checkForGameOver();
        return newBox;
    }

    private void checkForGameOver() {
        int[] scores = calculateScores();
        if ((scores[0] + scores[1]) == ((DOT_NUMBER - 1) * (DOT_NUMBER - 1))) {
            JOptionPane.showMessageDialog(this, currentPlayer +": " + scores[0] + "\nPlayer2: " + scores[1], "Game Over", JOptionPane.PLAIN_MESSAGE);
            startNewGame();
            repaint();
        }
    }

    private void handleClick() {
        ConnectionSprite connection = getConnection(clickX, clickY);
        if (connection == null)
            return;
        if (!connection.connectionMade) {
            makeConnection(connection);
        }
        repaint();
    }

    public void mouseMoved(MouseEvent event) {
        mouseX = event.getX();
        mouseY = event.getY();
        repaint();
    }

    public void mouseDragged(MouseEvent event) {
        mouseMoved(event);
    }

    public void mouseClicked(MouseEvent event) {
        clickX = event.getX();
        clickY = event.getY();
        handleClick();
    }

    public void mouseEntered(MouseEvent event) {
    }

    public void mouseExited(MouseEvent event) {
    }

    public void mousePressed(MouseEvent event) {
    }

    public void mouseReleased(MouseEvent event) {
    }

    private void paintBackground(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, dim.width, dim.height);
    }

    private void paintDots(Graphics g) {
        for (int i = 0; i < dots.length; i++) {
            dots[i].render(g);
        }
    }

    private void paintConnections(Graphics g) {
        for (int i = 0; i < horizontalConnections.length; i++) {
            if (!horizontalConnections[i].connectionMade && activePlayer == PLAYER_ONE) {
                if (horizontalConnections[i].containsPoint(mouseX, mouseY)) {
                    horizontalConnections[i].color = Color.CYAN;
                } else {
                    horizontalConnections[i].color = Color.WHITE;
                }

            } else if (!horizontalConnections[i].connectionMade && activePlayer == PLAYER_TWO) {
                if (horizontalConnections[i].containsPoint(mouseX, mouseY)) {
                    horizontalConnections[i].color = Color.PINK;
                } else {
                    horizontalConnections[i].color = Color.WHITE;
                }
            }
            horizontalConnections[i].render(g);
        }

        for (int i = 0; i < verticalConnections.length; i++) {

            if (!verticalConnections[i].connectionMade && activePlayer == PLAYER_ONE) {
                if (verticalConnections[i].containsPoint(mouseX, mouseY)) {
                    if (activePlayer == PLAYER_ONE) {
                        verticalConnections[i].color = Color.CYAN;
                    }

                } else {
                    verticalConnections[i].color = Color.WHITE;
                }
            } else if (!verticalConnections[i].connectionMade && activePlayer == PLAYER_TWO) {
                if (verticalConnections[i].containsPoint(mouseX, mouseY)) {
                    verticalConnections[i].color = Color.PINK;
                } else {
                    verticalConnections[i].color = Color.WHITE;
                }
            }

            verticalConnections[i].render(g);

        }
    }

    public void paintBoxes(Graphics g) {
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i].isBoxed()) {
                if (boxes[i].player == PLAYER_ONE) {
                    boxes[i].color = PLAYER_ONE_COLOR;
                } else if (boxes[i].player == PLAYER_TWO) {
                    boxes[i].color = PLAYER_TWO_COLOR;
                }
            } else {
                boxes[i].color = Color.WHITE;
            }

            boxes[i].render(g);
        }
    }

    public void paintStatus(Graphics g) {
        int[] scores = calculateScores();
        String status = "It is player" + activePlayer + "'s turn";
        String status2 = currentPlayer + ": " + scores[0];
        String status3 = "Player 2: " + scores[1];
        g.setColor(Color.BLACK);
        g.setFont(new Font("", Font.BOLD,13));
        g.drawString(status, 10, dim.height - 50);

        g.setColor(PLAYER_ONE_COLOR);
        g.drawString(status2, 10, dim.height - 35);
        g.setFont(new Font("", Font.BOLD,13));

        g.setColor(PLAYER_TWO_COLOR);
        g.drawString(status3, 10, dim.height - 20);
        g.setFont(new Font("", Font.BOLD,13));
    }
    public void update(Graphics g) {
        paint(g);
    }

    public void paint(Graphics g) {
        Image bufferImage = createImage(dim.width, dim.height);
        Graphics bufferGraphics = bufferImage.getGraphics();

        paintBackground(bufferGraphics);
        paintDots(bufferGraphics);
        paintConnections(bufferGraphics);
        paintBoxes(bufferGraphics);
        paintStatus(bufferGraphics);

        g.drawImage(bufferImage, 0, 0, null);
    }


}
