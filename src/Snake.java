import java.awt.event.*;
public class Snake implements ActionListener{

    private static final int MAX_WIDTH = 800;		// Window size
    private static final int MAX_HEIGHT = 800;
    private SnakeViewer window;

    private snakeAnimal snakeFace;
    private snakeAnimal snakeBody;

    private snakeAnimal apple;

    private snakeAnimal backgnd;

    public static void main(String args[])
    {
        Snake s = new Snake();
    }
    public Snake()
    {
        snakeFace = new snakeAnimal(xIn, yIn,dxIn,dyIn);
        snakeBody = new snakeAnimal(xIn, yIn,dxIn,dyIn);
        backgnd = new snakeAnimal(xIn, yIn,dxIn,dyIn);
        apple = new snakeAnimal(xIn, yIn,dxIn,dyIn);
        this.window = new SnakeViewer(MAX_WIDTH, MAX_HEIGHT, this);
    }

    public snakeAnimal getSnakeFace()
    {
        return  snakeFace;
    }
    public snakeAnimal getSnakeBody()
    {
        return  snakeBody;
    }
    public snakeAnimal getBackgnd()
    {
        return backgnd;
    }
    public snakeAnimal getApple()
    {
        return apple;
    }
    public void actionPerformed(ActionEvent e) {		// NEW #5 !!!!!!!!!!

        // TODO: modify this to call move() and bounce() on all 100 Balls.
        // Move the ball.
        for(int i = 0; i < .length; i++)
        {
            s.move();
        }
}
