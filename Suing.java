class Suing {
    public static int windowNumber;
    public static void main(String[] args) throws InterruptedException {
        windowNumber = 1;
        for (int a = 0; a > -(windowNumber); a--) {
            Horde h = new Horde();
            Thread t = new Thread(h);
            t.start();
            Thread.sleep(100);
        }
    };
}