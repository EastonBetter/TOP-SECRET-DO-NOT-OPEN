import java.awt.Font;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.Random;
import java.awt.event.*;

public class Horde implements Runnable {
    public int amount;
    public int screenLength;
    public int screenWidth;
    public Random randddd;
    public FrameMaker frim;

    public void run() {
        try {
                        JLabel hackingNotice = new JLabel();
            int timeRemaining = 10;
            hackingNotice.setText("<html>You are about to be hacked!!!1!v \n Time remaining: " + timeRemaining+"</html>");
            hackingNotice.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
            frim = new FrameMaker(
                    JFrame.DO_NOTHING_ON_CLOSE, true,
                    randddd.nextInt(50, 1000),
                    randddd.nextInt(50, 1000),
                    "Incredibly Deadly Virus",
                    false,
                    randddd.nextInt(50, 200),
                    randddd.nextInt(50, 200),
                    hackingNotice);
        } catch (InterruptedException e) {
            System.out.println("It does not work 😭");
        }
    }

    public Horde() throws InterruptedException {
        randddd = new Random();
    }
}
