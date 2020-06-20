package threadpool.first;

import threadpool.first.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkerThread {

    public static void main(String[] args) {
        /**
         * only execute one thread at a time
         */
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Task("Task 1"));
        executorService.execute(new Thread(new Task("Task 2")));
        /**
         * we need to shutdown otherwise it will continue executing
         */
        for (int i = 301; i <= 399; i++)
            System.out.print(i + " ");

        System.out.println("Main done!");
        executorService.shutdown();
    }

}
