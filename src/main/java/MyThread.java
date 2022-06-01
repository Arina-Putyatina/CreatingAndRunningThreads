public class MyThread implements Runnable{

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
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
