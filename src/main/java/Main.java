public class Main {

    public static void main(String[] args) {

        ThreadGroup mainGroup = new ThreadGroup("main");
        final Thread thread1 = new Thread(mainGroup, new MyThread());
        thread1.setName("1");
        final Thread thread2 = new Thread(mainGroup, new MyThread());
        thread2.setName("2");
        final Thread thread3 = new Thread(mainGroup, new MyThread());
        thread3.setName("3");
        final Thread thread4 = new Thread(mainGroup, new MyThread());
        thread4.setName("4");

        long start = System.currentTimeMillis();
        long end = start + 15 * 1000;

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        while (System.currentTimeMillis() < end) {
        }

        mainGroup.interrupt();

    }
}
