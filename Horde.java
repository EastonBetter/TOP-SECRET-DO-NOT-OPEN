import java.awt.Font;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.util.Random;
import java.awt.Toolkit;

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
            hackingNotice
                    .setText("<html>You are about to be hacked!!!1!v \n Time remaining: " + timeRemaining + "</html>");
                                int wid = randddd.nextInt(50, 500)/1*1;
            hackingNotice.setFont(new Font("Comic Sans MS", Font.BOLD, wid/10));
            hackingNotice.setForeground(new Color(0xFFFFFF));
            frim = new FrameMaker(
                    JFrame.DO_NOTHING_ON_CLOSE, true,
                    wid,
                    randddd.nextInt(50, 500)/1*1,
                    "Incredibly Deadly Virus",
                    false,
                    randddd.nextInt(50, screenWidth - 500)/1*1,
                    randddd.nextInt(50, screenLength - 500)/1*1,
                    hackingNotice);
        } catch (InterruptedException e) {
            System.out.println("It does not work 😭");
        }
    }

    public Horde() throws InterruptedException {
        screenLength = Toolkit.getDefaultToolkit().getScreenSize().height;
        screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        randddd = new Random();
    }
}
