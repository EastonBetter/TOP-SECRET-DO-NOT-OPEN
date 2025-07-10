import javax.swing.JFrame;
import java.awt.Color;
import javax.sound.sampled.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.File;
import java.util.Random;

public class FrameMaker extends Thread {
    public int closer;
    public boolean visible;
    public int width;
    public int length;
    public String title;
    public JFrame looloo;
    public int x;
    public int y;
    public boolean rezisability;
    public JLabel hackingNotice;

    public FrameMaker(int closre, boolean visibel, int withd, int lenthg, String titel, boolean resizable, int ex,
            int wy, JLabel hackingNoticee) throws InterruptedException {
        looloo = new JFrame();
        closer = closre;
        visible = visibel;
        width = withd;
        length = lenthg;
        title = titel;
        rezisability = resizable;
        x = ex;
        y = wy;
        hackingNotice = hackingNoticee;
        looloo.add(hackingNotice);
        looloo.getContentPane().setBackground(new Color(255, 0, 0));
        ImageIcon idiot = new ImageIcon("VirusLogo.png");
        looloo.setIconImage(idiot.getImage());
        looloo.setDefaultCloseOperation(closer);
        looloo.setResizable(rezisability);
        looloo.setSize(width, length);
        looloo.setTitle(title);
        looloo.setVisible(visible);
        looloo.setLocation(x, y);
        looloo.setAlwaysOnTop(true);

        Random aaf = new Random();
        int screenLength = Toolkit.getDefaultToolkit().getScreenSize().height;
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        boolean goingLeft = aaf.nextBoolean();
        boolean goingUp = aaf.nextBoolean();
        int stage = 0;
        int iteration = 0;
        int timeRemaining = 10;
        looloo.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    for (int qpweo = 0; qpweo < Suing.windowNumber; qpweo++) {
                        Horde h = new Horde();
                        Thread t = new Thread(h);
                        t.start();
                        playSound("NoNoo.wav");
                        Thread.sleep(10);
                    }
                    Suing.windowNumber *= 2;
                } catch (InterruptedException ex) {
                }
            }
        });
        while (true) {
            iteration++;
            if (goingLeft) {
                x = x - 1;
            } else {
                x = x + 1;
            }
            if (goingUp) {
                y = y - 1;
            } else {
                y = y + 1;
            }
            if (iteration % 500 == 0) {
                timeRemaining--;
                hackingNotice.setText(
                "<html>You are about to be hacked!!!1!v \n Time remaining: " + timeRemaining + "</html>");

            }
            if (timeRemaining == 0){
                playSound("weezer.wav");
                timeRemaining = 10;
                hackingNotice.setText(
                "<html>You are about to be hacked!!!1!v \n Time remaining: " + timeRemaining + "</html>");
                Horde h = new Horde();
                Thread t = new Thread(h);
                t.start();
                Suing.windowNumber++;
            }
            looloo.setLocation(x, y);
            Thread.sleep(2);
            if (stage == 0) {
                looloo.getContentPane().setBackground(new Color(looloo.getContentPane().getBackground().getRed() - 1,
                        looloo.getContentPane().getBackground().getGreen() + 1, 0));
                if (looloo.getContentPane().getBackground().getRed() == 0) {
                    stage = 1;
                }
            } else if (stage == 1) {
                looloo.getContentPane()
                        .setBackground(new Color(0, looloo.getContentPane().getBackground().getGreen() - 1,
                                looloo.getContentPane().getBackground().getBlue() + 1));
                if (looloo.getContentPane().getBackground().getGreen() == 0) {
                    stage = 2;
                }
            } else if (stage == 2) {
                looloo.getContentPane().setBackground(new Color(looloo.getContentPane().getBackground().getRed() + 1, 0,
                        looloo.getContentPane().getBackground().getBlue() - 1));
                if (looloo.getContentPane().getBackground().getBlue() == 0) {
                    stage = 0;
                }
            }
            if (x == 0 && goingLeft == true) {
                goingLeft = false;
            } else if (x == screenWidth - width && goingLeft == false) {
                goingLeft = true;
            }
            if (y <= 0 && goingUp == true) {
                goingUp = false;
            } else if (y >= screenLength - length && goingUp == false) {
                goingUp = true;
            }
        }
    }

    public void setCloser(int closer) {
        looloo.setDefaultCloseOperation(closer);
    }

    public void setVisibler(boolean visibility) {
        looloo.setVisible(visibility);
    }

    public void setResizablee(boolean res) {
        looloo.setVisible(res);
    }

    public void setWidth(int widthe) {
        looloo.setSize(widthe, length);
    }

    public void setLength(int kengthe) {
        looloo.setSize(width, kengthe);
    }

    public void setTitlee(String tilttee) {
        looloo.setTitle(tilttee);
    }

    public void setPlace(int horz, int vert) {
        looloo.setLocation(horz, vert);
    }

    public JFrame getFrayJame() {
        return looloo;
    }
    public void playSound(String filePath){
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