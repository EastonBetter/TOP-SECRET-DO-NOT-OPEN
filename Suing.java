import java.io.File;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;

class Suing {
    public static int windowNumber;
    public static boolean loopedyet;
    public static void main(String[] args) throws InterruptedException {
        windowNumber = 0;
        loopedyet = false;

        int screenLength = Toolkit.getDefaultToolkit().getScreenSize().height;
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;

        Color wblue = new Color(0x00ACE6);

        ImageIcon weezerTitle = new ImageIcon("werzer.png");
        ImageIcon omgItsWeezer = new ImageIcon("TheGang.png");
        omgItsWeezer.setImage(omgItsWeezer.getImage().getScaledInstance(700,450,Image.SCALE_SMOOTH));

        JFrame winfographic = new JFrame();
        winfographic.setSize(800, 1000);
        
        JLabel titleee = new JLabel();
        titleee.setIcon(weezerTitle);
        titleee.setLocation(35, 0);

        JPanel weetle = new JPanel();
        weetle.setBackground(wblue);
        weetle.setBounds(0, 0, 800, 200);
        weetle.add(titleee);

        JLabel histext = new JLabel();
        histext.setLocation(500, 300);
        histext.setText("<html>Weezer<br> used to be so good back in 1894 with the Blue album.<br> Then they releesed this trash album<br> called Pinkerton and theyve been in a downword<br> spiral ever sinse.</html>");
        histext.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        histext.setForeground(new Color(0xFF00FF));

        JPanel history = new JPanel();
        history.setBackground(wblue);
        history.setBounds(0, 200, 800, 150);
        history.add(histext);

        JLabel labelForW = new JLabel();
        labelForW.setIcon(omgItsWeezer);
        
        JPanel weezerStage = new JPanel();
        weezerStage.add(labelForW);
        weezerStage.setBackground(wblue);
        weezerStage.setBounds(0, 350, 800, 450);
        //weezerStage.setLayout(new BoxLayout(weezerStage, BoxLayout.Y_AXIS));

        JLabel aaaa = new JLabel();
        aaaa.setText("<html>Click the button below to play Buddy Holly, <br>Weezers only good song</html>");
        aaaa.setFont(new Font("Comic Sans MS", Font.ITALIC, 30));
        aaaa.setForeground(new Color(0xFFFF00));
        aaaa.setLocation(0, 0);

        JPanel weezerNotifier = new JPanel();
        weezerNotifier.add(aaaa);
        weezerNotifier.setOpaque(false);
        weezerNotifier.setBounds(0, 700, 800, 200);

        JButton virusTrigger = new JButton();
        virusTrigger.setText("<html>Button that definitely won't give your computer a virus</html>");
        virusTrigger.setFont(new Font("Arial", Font.PLAIN, 20));
        virusTrigger.setForeground(new Color(0x000000));
        virusTrigger.setBorder(null);
        virusTrigger.setBounds(100, 825, 600, 100);
        virusTrigger.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    Horde h = new Horde();
                    Thread t = new Thread(h);
                    t.start();
                    Thread.sleep(100);
                    windowNumber++;
                    if (loopedyet == false){
                        loopedyet = true;
                        loopSound("buddyHolly.wav");
                    } else {
                        playSound("hipHip.wav");
                    }
                } catch(InterruptedException ex) {
                }
                            
            }
        });
        
        JPanel buttonHolder = new JPanel();
        //buttonHolder.add(virusTrigger);
        buttonHolder.setBackground(wblue);
        buttonHolder.setBounds(0, 800, 800,200);
                
        winfographic.add(weetle);
        winfographic.add(virusTrigger);
        winfographic.add(history);
        winfographic.add(weezerNotifier);
        winfographic.add(weezerStage);
        winfographic.add(buttonHolder);
        winfographic.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        winfographic.setLayout(null);
        winfographic.setResizable(false);
        winfographic.setVisible(true);
        winfographic.setLocation(screenWidth/2-400, screenLength/2-500);
    }
    public static void loopSound(String filePath){
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(filePath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(-1);
        } catch (Exception e) {
        }
    }
    public static void playSound(String filePath){
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(filePath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event){
                    if (event.getType() == LineEvent.Type.STOP) {
                        clip.close();
                    }
                }
            });
        } catch (Exception e) {
        }
    }
}