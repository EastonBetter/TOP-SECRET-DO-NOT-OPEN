import java.awt.Font;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Toolkit;
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

    public FrameMaker(int closre, boolean visibel, int withd, int lenthg, String titel, boolean resizable, int ex,
            int wy) throws InterruptedException{
        looloo = new JFrame();
        closer = closre;
        visible = visibel;
        width = withd;
        length = lenthg;
        title = titel;
        rezisability = resizable;
        x = ex;
        y = wy;
        ImageIcon idiot = new ImageIcon("VirusLogo.png");
        looloo.setIconImage(idiot.getImage());
        looloo.setDefaultCloseOperation(closer);
        looloo.setResizable(rezisability);
        looloo.setSize(width, length);
        looloo.setTitle(title);
        looloo.setVisible(visible);
        looloo.setLocation(x, y);
        Random aaf = new Random();
        int screenLength = Toolkit.getDefaultToolkit().getScreenSize().height;
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        boolean goingLeft = aaf.nextBoolean();
        boolean goingUp = aaf.nextBoolean();
        while (true) {
            if (goingLeft) {
                x--;
            } else {
                x++;
            }
            if (goingUp) {
                y--;

            } else {
                y++;

            }
            looloo.setLocation(x, y);
            Thread.sleep(2);
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
}
