package object;

import java.awt.*;

public abstract class  GameObject {
    protected int x;
    protected int y;
    protected int oldX;
    protected int oldY;
    protected int width;
    protected int height;

    protected Image[] image;

    public GameObject(int x, int y, Image[] image) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.width = image[0].getWidth(null);
        this.height = image[0].getHeight(null);
    }

    public abstract void draw(Graphics g);

    public Rectangle getRectangle() {
        return new Rectangle(x, y, width, height);
    }
}
