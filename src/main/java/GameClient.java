import object.Direction;
import object.Tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GameClient extends JComponent {
        private int width;
        private int height;
        Tank Play ;



        GameClient(){
            this(800,600);
        }
        public GameClient(int width,int height){
            this.width = width;
            this.height = height;
            this.setPreferredSize(new Dimension(width,height));
            init();

            new Thread(()->{
                while (true){
                    repaint();
                    try{
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        public void init(){
            Play = new Tank(100,100, Direction.DOWN);
    }

    public void keyPressed(KeyEvent e){
            switch (e.getKeyCode()){
                case KeyEvent.VK_UP:
                    Play.setDirection(Direction.UP);
                    Play.setY(Play.getY()-5);
                    break;
                case KeyEvent.VK_DOWN:
                    Play.setDirection(Direction.DOWN);
                    Play.setY(Play.getY()+5);
                    break;
                case KeyEvent.VK_RIGHT:
                    Play.setDirection(Direction.RIGHT);
                    Play.setX(Play.getX()+5);
                    break;
                case KeyEvent.VK_LEFT:
                    Play.setDirection(Direction.LEFT);
                    Play.setX(Play.getX()-5);
                    break;
                default:
            }
            //repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(Play.getImage(),Play.getX(),Play.getY(),null);
    }
}
