import java.io.File;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;


class Suing {
    public static int windowNumber;
    public static void main(String[] args) throws InterruptedException {
        playSound("buddyHolly.wav");
        JFrame winfographic = new JFrame();
        winfographic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        winfographic.setLayout(null);
        winfographic.setSize(500, 1000);
        winfographic.setVisible(true);
        
        JPanel weetle = new JPanel();
        Color wblue = new Color(0x00ACE6 );
        weetle.setBackground(wblue);
        weetle.setBounds(0, 0, 500, 100);

        JLabel titleee = new JLabel();
        titleee.setText("A Brief History of Weezer");
        titleee.setFont(new Font("Yu Gothic", Font.BOLD, 20));
        weetle.add(titleee);
        winfographic.add(weetle);
        Thread.sleep(10000);
        windowNumber = 1;
        for (int a = 0; a > -(windowNumber); a--) {
            Horde h = new Horde();
            Thread t = new Thread(h);
            t.start();
            Thread.sleep(100);
        }
    }
    public static void playSound(String filePath){
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(filePath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(-1);
        } catch (Exception e) {
        }
    }
}