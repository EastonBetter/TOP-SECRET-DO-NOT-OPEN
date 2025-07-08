import java.awt.event.*;

class Suing {
    public static void main(String[] args) throws InterruptedException {
        for (int a = 0; a > -2000; a--){
            Horde h = new Horde();
            Thread t = new  Thread(h);
            t.start();
            Thread.sleep(100);
            }
        };
    }
