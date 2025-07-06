import java.awt.Font;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

class Suing {
    public static void main(String[] args) throws InterruptedException{
        JFrame jayF = new JFrame();
        ImageIcon idiot = new ImageIcon("VirusLogo.png");
        jayF.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jayF.setVisible(true);
        jayF.setSize(1600, 900);
        jayF.setResizable(false);
        jayF.setIconImage(idiot.getImage());
        jayF.setTitle("Incredibly Deadly Virus");
        JLabel hackingNotice = new JLabel();
        int timeRemaining = 10;
        hackingNotice.setText("You are about to be hacked!!!1!v \n Time remaining: "+timeRemaining);
        jayF.add(hackingNotice);
        hackingNotice.setFont(new Font("Comic Sans MS", Font.BOLD, 100));
        while (true) {
            hackingNotice.setText("<html>You are about to be hacked!!!1!v <br> Time remaining: <html>"+timeRemaining);
            for (int lala = 0; lala < 255; lala++){
                jayF.getContentPane().setBackground(new Color(255-lala, lala, 0));
                hackingNotice.setForeground(new Color(lala, 255-lala, 0));
                Thread.sleep(1);
            }
            for (int lala = 0; lala < 255; lala++){
                jayF.getContentPane().setBackground(new Color(0, 255-lala, lala));
                hackingNotice.setForeground(new Color(0, lala, 255-lala));
                Thread.sleep(1);
            }
            for (int lala = 0; lala < 255; lala++){
                jayF.getContentPane().setBackground(new Color(lala, 0, 255-lala));
                hackingNotice.setForeground(new Color(255-lala, 0, lala));
                Thread.sleep(1);
            }
            timeRemaining--;
        }
    }
}