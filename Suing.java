class Suing {
    public static void main(String[] args) throws InterruptedException {
        for (int a = 0; a < 25; a++){
            Thread t = new  Thread(new Horde());
            t.start();
            Thread.sleep(100);
        }
    }
}
