package Game.DotsAndBoxes.Model;

import org.testng.annotations.Test;

import java.util.Timer;
import java.util.TimerTask;

class Helper extends TimerTask
{
    //fucking timer
    public static int i = 0;
    public void run()
    {
        System.out.println("Timer ran " + ++i);
        if(i == 4)
        {
            synchronized(ScoreBoard.obj)
            {
                ScoreBoard.obj.notify();
            }
        }
    }

}


public class ScoreBoard{
    protected static Test obj;
    private int score;
    private Player player1;
    private Player player2;
    Timer timer = new Timer();
    TimerTask task = new Helper();
}
