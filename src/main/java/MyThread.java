public class MyThread implements Runnable{

    protected Thread thread;

    public MyThread(String name) {
        thread = new Thread(name);
    }

    @Override
    public void run() {
        try {
            while(!thread.isInterrupted()) {
                thread.sleep(2500);
                System.out.printf("Я поток %s. Всем привет!\n", thread.getName());
            }
        } catch (InterruptedException err) {
            err.printStackTrace();
        } finally{
            System.out.printf("%s завершен\n", thread.getName());
        }
    }
}
