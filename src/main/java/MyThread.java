import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Random rand = new Random();
        int max = 7;
        int min = 3;
        int messagesCount = rand.nextInt((max - min) + 1) + min;
        Thread thread = Thread.currentThread();
        try {
            for (int i = 0; i <messagesCount; i++) {
                if (thread.isInterrupted()) break;
                Thread.sleep(2500);
                System.out.printf("Я поток %s. Сообщение №%s\n", thread.getName(), i);
            }
        } catch (InterruptedException err) {
            err.printStackTrace();
        } finally {
            System.out.printf("%s завершен\n", thread.getName());
        }
        return messagesCount;
    }
}
