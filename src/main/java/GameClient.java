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
            boolean[] dirs = Play.getDirs();

            switch (e.getKeyCode()){
                case KeyEvent.VK_UP:
                    dirs[0]=true;
//                    Play.setDirection(Direction.UP);
//                    Play.setY(Play.getY()-5);
                    break;
                case KeyEvent.VK_DOWN:
                    dirs[1]=true;
//                    Play.setDirection(Direction.DOWN);
//                    Play.setY(Play.getY()+5);
                    break;
                case KeyEvent.VK_LEFT:
                    dirs[2]=true;
//                    Play.setDirection(Direction.RIGHT);
//                    Play.setX(Play.getX()+5);
                    break;
                case KeyEvent.VK_RIGHT:
                    dirs[3]=true;
//                    Play.setDirection(Direction.LEFT);
//                    Play.setX(Play.getX()-5);
                    break;

            }
            //repaint();
        Play.move();
    }
    public void keyReleased(KeyEvent e){
        boolean[] dirs = Play.getDirs();

        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                dirs[0]=false;
//                    Play.setDirection(Direction.UP);
//                    Play.setY(Play.getY()-5);
                break;
            case KeyEvent.VK_DOWN:
                dirs[1]=false;
//                    Play.setDirection(Direction.DOWN);
//                    Play.setY(Play.getY()+5);
                break;
            case KeyEvent.VK_LEFT:
                dirs[2]=false;
//                    Play.setDirection(Direction.RIGHT);
//                    Play.setX(Play.getX()+5);
                break;
            case KeyEvent.VK_RIGHT:
                dirs[3]=false;
//                    Play.setDirection(Direction.LEFT);
//                    Play.setX(Play.getX()-5);
                break;

        }
        Play.move();
        //repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0,0,width,height);

        Play.draw(g);

//        g.drawImage(Play.getImage(),Play.getX(),Play.getY(),null);
    }
}
