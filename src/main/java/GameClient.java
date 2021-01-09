import object.GameObject;
import object.Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameClient extends JComponent {
    private int width;
    private int height;
    Tank Play;
//    private ArrayList<Tank> enemyTanks = new ArrayList<>();
//    private ArrayList<Wall> walls = new ArrayList<>();
    private ArrayList<GameObject> gameObjects = new ArrayList<>();


    GameClient() {
        this(800, 600);
    }

    public GameClient(int width, int height) {
        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(width, height));
        init();

        new Thread(() -> {
            while (true) {
                repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void init() {
        Image[] itankImg = new Image[8];
        Image[] etankImg = new Image[8];
        String[] sub = {"U", "D", "L", "R", "LU", "RU", "LD", "RD"};
        for (int i = 0; i < itankImg.length; i++) {
            itankImg[i] = Tools.getImage("itank" + sub[i] + ".png");
            etankImg[i] = Tools.getImage("etank" + sub[i] + ".png");
        }


        Play = new Tank(375, 100, Direction.DOWN, itankImg);
        gameObjects.add(Play);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                gameObjects.add(new Tank(250 + j * 80, 300 + 80 * i, Direction.UP, true,etankImg));
              //  enemyTanks.add(new Tank(250 + j * 80, 300 + 80 * i, Direction.UP, true,etankImg));
            }
        }

        Image[] image = {Tools.getImage("brick.png")};
        gameObjects.add(new Wall(100, 200, false, 10, image));
        gameObjects.add(new Wall(200, 200, true, 13, image));
        gameObjects.add(new Wall(650, 200, false, 10, image));
    }


    public void keyPressed(KeyEvent e) {
        boolean[] dirs = Play.getDirs();

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                dirs[0] = true;
//                    Play.setDirection(Direction.UP);
//                    Play.setY(Play.getY()-5);
                break;
            case KeyEvent.VK_DOWN:
                dirs[1] = true;
//                    Play.setDirection(Direction.DOWN);
//                    Play.setY(Play.getY()+5);
                break;
            case KeyEvent.VK_LEFT:
                dirs[2] = true;
//                    Play.setDirection(Direction.RIGHT);
//                    Play.setX(Play.getX()+5);
                break;
            case KeyEvent.VK_RIGHT:
                dirs[3] = true;
//                    Play.setDirection(Direction.LEFT);
//                    Play.setX(Play.getX()-5);
                break;

        }
        //repaint();

    }

    public void keyReleased(KeyEvent e) {
        boolean[] dirs = Play.getDirs();

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                dirs[0] = false;
//                    Play.setDirection(Direction.UP);
//                    Play.setY(Play.getY()-5);
                break;
            case KeyEvent.VK_DOWN:
                dirs[1] = false;
//                    Play.setDirection(Direction.DOWN);
//                    Play.setY(Play.getY()+5);
                break;
            case KeyEvent.VK_LEFT:
                dirs[2] = false;
//                    Play.setDirection(Direction.RIGHT);
//                    Play.setX(Play.getX()+5);
                break;
            case KeyEvent.VK_RIGHT:
                dirs[3] = false;
//                    Play.setDirection(Direction.LEFT);
//                    Play.setX(Play.getX()-5);
                break;

        }

        //repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        for (GameObject o:gameObjects) {
            o.draw(g);
        }
/*
        Play.draw(g);
        for (Tank tank : gameObjects) {
            tank.draw(g);
        }
        for (Wall wall : walls) {
            wall.draw(g);
        }
*/
//        g.drawImage(Play.getImage(),Play.getX(),Play.getY(),null);
    }
    public ArrayList<GameObject> getGameObjects(){
        return gameObjects;
    }
}
