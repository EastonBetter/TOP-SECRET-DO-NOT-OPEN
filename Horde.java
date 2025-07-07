import java.awt.Font;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.Random;
import java.awt.event.*;

public class Horde extends Thread {
    public int amount;
    public int screenLength;
    public int screenWidth;
    public Random randddd;
    public FrameMaker frim;

    public void run() throws InterruptedException {
        frim = new FrameMaker(JFrame.DO_NOTHING_ON_CLOSE, true, randddd.nextInt(50, 1000),
                randddd.nextInt(50, 1000), "Incredibly Deadly Virus", false, randddd.nextInt(50, 200),
                randddd.nextInt(50, 200));
    }

    public Horde(int amoeunt) throws InterruptedException {
        amount = amoeunt;
        randddd = new Random();
        run();
        JLabel hackingNotice = new JLabel();
        int timeRemaining = 10;
        hackingNotice.setText("You are about to be hacked!!!1!v \n Time remaining: " + timeRemaining);
        frim.getFrayJame().add(hackingNotice);
        frim.getFrayJame().getContentPane().setBackground(new Color(0, 255, 255));
        hackingNotice.setFont(new Font("Comic Sans MS", Font.BOLD, 100));

    }
}
