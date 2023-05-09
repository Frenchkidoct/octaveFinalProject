import java.awt.*;
import javax.swing.*;
public class snakeAnimal {
    private Image snakeFace;
    private Image snakeBody;

    private Image backgnd;

    private Image apple;

    private int x, y;
    private int dx, dy;

    public snakeAnimal(int xIn, int yIn, int dxIn, int dyIn)
    {
        snakeFace = new ImageIcon("Resources/snakeFace.png").getImage();
        snakeBody = new ImageIcon("Resources/snakeBody.png").getImage();
        backgnd = new ImageIcon("Resources/backgnd.png").getImage();
        apple = new ImageIcon("Resources/appleFinal.png").getImage();
        x = xIn;
        y = yIn;
        dx = dxIn;
        dy = dyIn;

    }
    public void move() {
        x = x + dx;
        y = y + dy;
    }
    public void draw(Graphics g, SnakeViewer window)
    {
        g.drawImage(backgnd, 0, 0, 800, 800, window);
        g.drawImage(snakeFace,400, 143, 130,100, window);
        g.drawImage(snakeBody,350, 150, 70,70, window);
        int randomX = (int)(Math.random() * 600) + 120;
        int randomY = (int)(Math.random() * 600) + 120;
        g.drawImage(apple, randomX, randomY, 130,100, window);
    }
}
