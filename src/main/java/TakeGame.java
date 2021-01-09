import object.GameObject;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TakeGame {
    static GameClient gameClient;
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        gameClient = new GameClient();
        frame.add(gameClient);
        frame.setTitle("坦克大戰");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();



        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) { super.keyPressed(e);
                gameClient.keyPressed(e);
                System.out.println((char)e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                gameClient.keyReleased(e);
            }
        });


    }
}
