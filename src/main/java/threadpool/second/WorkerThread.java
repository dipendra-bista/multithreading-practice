package threadpool.second;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WorkerThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService executorService = Executors.newFixedThreadPool(5);
        /**
         * future is like promise untill and unless it gets the value from the thread
         * it worn execute further
         */
        Future<String> future = executorService.submit(new Task("task 1"));

        System.out.println("Welcome Message :" + future.get());

        /**
         * we need to shutdown otherwise it will continue executing
         */
        for (int i = 301; i <= 399; i++)
            System.out.print(i + " ");

        System.out.println("Main done!");
        executorService.shutdown();
    }

}
