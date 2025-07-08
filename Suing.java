class Suing {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Horde();
        Thread t = new Thread(r);
        t.start();
        System.out.println("Comple te");
    }
}
