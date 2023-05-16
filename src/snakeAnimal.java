import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.KeyListener;

public class snakeAnimal implements ActionListener{

    public static final int SIZE = 30;
    //coordinates for apple
    public int appleX;
    public int appleY;
    public boolean run = false;
    private boolean initialRun = true;
    Timer timer;
    public static final int GAME_UNITS = (500*500)/SIZE;
    public static final int TIMER_DELAY = 75;
    //Arrays hold all coordinates for all parts of snake
    public static final int x[] = new int[GAME_UNITS];
    public static final int y[] = new int[GAME_UNITS];
    //initial amount of snake pieces
    public int snakePieces = 6;

    //how many apples the snake has eaten
    public int applesCollected;

    private SnakeViewer painter;
    //direction. R means right. L means Left. U means up. D means Down
    public char direction = 'R';

    public void setViewer(SnakeViewer v){
        painter = v;
    }
    public snakeAnimal()
    {

    }
    public void startGame()
    {
        System.out.println("Start");
        newApple();
        run = true;
        timer = new Timer(TIMER_DELAY, this);
        painter.addKeyListener(new MyKeyAdapter());
        painter.repaint();
    }

    public int[] newApple()
    {
        //create newApple when method called. At startGame for example
        //500 represents the window height and width created in snakeViewer
        appleX = (int)(Math.random() * 500) ;
        appleY = (int)(Math.random() * 500) ;
        int[] ret = {appleX, appleY};
        return ret;
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.red);
        g.drawOval(appleX, appleY,SIZE, SIZE);
        g.fillOval(appleX, appleY, SIZE, SIZE);

        //iterate through pieces
        for(int i = 0; i < snakePieces; i++)
        {
          //if i = 0, we only have head
          if(i==0)
          {
           g.setColor(Color.green);
           g.fillRect(x[i], y[i], SIZE, SIZE);
          }
          //if i isnt 0 we have snake body
          else
          {
            g.setColor(new Color(100, 235, 52));
            g.fillRect(x[i], y[i], SIZE, SIZE);
          }

        }
    }

    public void move()
    {
       // for loop to go through all body parts of snake


        for(int i = snakePieces; i > 0; i--)
        {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        //refers to the char. R means right. L means Left. U means up. D means Down
        switch(direction)
        {
            case 'U':
                y[0] = y[0] - SIZE;
                break;
            case 'D':
                y[0] = y[0] + SIZE;
                break;
            case 'L':
                x[0] = x[0] - SIZE;
                break;
            case'R':
                x[0] = x[0] + SIZE;
                break;
        }
    }

    public void checkApple()
    {
        if((x[0] == appleX) && (y[0] == appleY)  )
        {
            snakePieces++;
            applesCollected++;
            newApple();
        }
    }
    public void collisions()
    {

    }
    public void gameOver(Graphics g)
    {

    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println("action listener working");
        if(run == true)
        {
            move();
            checkApple();
            collisions();
        }
        painter.repaint();
    }
    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e)
        {
            if(run == true)
            {
                move();
                checkApple();
                collisions();
            }
            painter.repaint();

            switch ((e.getKeyCode()))
            {
                case KeyEvent.VK_LEFT:
                    if(direction != 'R')
                    {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L')
                    {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 'D')
                    {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U')
                    {
                        direction = 'D';
                    }
                    break;
            }
        }
    }
}
