import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
public class SnakeViewer extends JFrame{
    private int width;
    private int height;

    private Snake backend;


    public SnakeViewer(int MAX_WIDTH, int MAX_HEIGHT, Snake backend)
    {
        width = MAX_WIDTH;
        height = MAX_HEIGHT;
        this.backend = backend;

        this.setTitle("SNAKE GAME!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setVisible(true);
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
        backend.getBackgnd().draw(g, this);
        backend.getApple().draw(g, this);
        backend.getSnakeBody().draw(g, this);
        backend.getSnakeFace().draw(g, this);


    }
    //public void keyPressed(KeyEvent e)              // #7 Required for KeyListener
    //{
        // The keyCode lets you know which key was pressed
        //int keyCode = e.getKeyCode();

        //if(keyCode == KeyEvent.VK_LEFT)
        //{
            //backend.shiftX(-stepSize, 0, width);
        //}
        //else if(keyCode == KeyEvent.VK_RIGHT)
        //{
        //    backend.shiftX(stepSize, 0, width);
        //}
        //else if(keyCode == KeyEvent.VK_UP)
        //{
            //int topOfPane = getInsets().top;    // This just identifies where the title bar ends and the usable area starts
            //backend.shiftY(-stepSize, topOfPane, height);
        //}
        //else if(keyCode == KeyEvent.VK_DOWN)
        //{
            //backend.shiftY(stepSize, 0, height);
        //}
    }
