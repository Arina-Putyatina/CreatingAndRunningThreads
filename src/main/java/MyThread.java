public class MyThread extends Thread implements Runnable{

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            while(!isInterrupted()) {
                Thread.sleep(2500);
                System.out.printf("Я поток %s. Всем привет!\n", getName());
            }
        } catch (InterruptedException err) {
            err.printStackTrace();
        } finally{
            System.out.printf("%s завершен\n", getName());
        }
    }
}
