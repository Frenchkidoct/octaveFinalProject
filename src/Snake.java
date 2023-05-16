import javax.swing.*;
import java.awt.event.*;
public class Snake
{

    public static void main(String args[])
    {
        snakeAnimal s = new snakeAnimal();
        SnakeViewer sv = new SnakeViewer(s);
        s.setViewer(sv);
        s.startGame();
    }
    public Snake()
    {
        snakeAnimal s = new snakeAnimal();
        s.startGame();

    }

    public void actionPerformed(ActionEvent e) {        // NEW #5 !!!!!!!!!!

        // TODO: modify this to call move() and bounce() on all 100 Balls.
    }
}
