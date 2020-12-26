import object.GameObject;

import javax.swing.*;
import java.awt.*;

public class Tank extends GameObject {


    private Direction direction;
    private int speed = 5;
    private boolean[] dirs = new boolean[4];
    private boolean enemy;

    public Tank(int x, int y, Direction direction,Image[] images) {
        this(x, y, direction,false ,images);
    }

    public Tank(int x, int y, Direction direction, boolean enemy,Image[] images) {
        super(x,y,images);

        this.direction = direction;
        this.enemy = enemy;
    }


    public boolean[] getDirs() {
        return dirs;
    }


    public void draw(Graphics g) {
        if (!isStop()) {
            determineDirection();
            move();
        }
        g.drawImage(image[direction.ordinal()], x, y, null);
    }

    public boolean isStop() {
        for (int i = 0; i < dirs.length; i++) {
            if (dirs[i]) {
                return false;
            }
        }
        return true;
    }

    private void determineDirection() {
        if (dirs[0] && !dirs[1] && !dirs[2] && !dirs[3]) direction = Direction.UP;
        else if (!dirs[0] && dirs[1] && !dirs[2] && !dirs[3]) direction = Direction.DOWN;
        else if (!dirs[0] && !dirs[1] && dirs[2] && !dirs[3]) direction = Direction.LEFT;
        else if (!dirs[0] && !dirs[1] && !dirs[2] && dirs[3]) direction = Direction.RIGHT;

        else if (dirs[0] && !dirs[1] && dirs[2] && !dirs[3]) direction = Direction.UP_LEFT;
        else if (dirs[0] && !dirs[1] && !dirs[2] && dirs[3]) direction = Direction.UP_RIGHT;
        else if (!dirs[0] && dirs[1] && dirs[2] && !dirs[3]) direction = Direction.DOWN_LEFT;
        else if (!dirs[0] && dirs[1] && !dirs[2] && dirs[3]) direction = Direction.DOWN_RIGHT;
    }

    public void move() {
        switch (direction) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case UP_LEFT:
                y -= speed;
                x -= speed;
                break;
            case UP_RIGHT:
                y -= speed;
                x += speed;
                break;
            case DOWN_LEFT:
                y += speed;
                x -= speed;
                break;
            case DOWN_RIGHT:
                y += speed;
                x += speed;
                break;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
/*
    public Image getImage() {

        String name = enemy ? "etank" : "itank";

        if (direction == Direction.UP) {
            return new ImageIcon("assets/images/"+name+"U.png").getImage();
        }
        if (direction == Direction.DOWN) {
            return new ImageIcon("assets/images/"+name+"D.png").getImage();
        }
        if (direction == Direction.RIGHT) {
            return new ImageIcon("assets/images/"+name+"R.png").getImage();
        }
        if (direction == Direction.LEFT) {
            return new ImageIcon("assets/images/"+name+"L.png").getImage();
        }
        if (direction == Direction.UP_LEFT) {
            return new ImageIcon("assets/images/"+name+"LU.png").getImage();
        }
        if (direction == Direction.UP_RIGHT) {
            return new ImageIcon("assets/images/"+name+"RU.png").getImage();
        }
        if (direction == Direction.DOWN_LEFT) {
            return new ImageIcon("assets/images/"+name+"LD.png").getImage();
        }
        if (direction == Direction.DOWN_RIGHT) {
            return new ImageIcon("assets/images/"+name+"RD.png").getImage();
        }

        return null;
    }
*/
}
