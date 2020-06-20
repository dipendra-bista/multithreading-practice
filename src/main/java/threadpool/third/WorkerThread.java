package threadpool.third;

import threadpool.second.Task;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class WorkerThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Callable<String>> tasks = List.of(new Task("Task 1"), new Task("TAsk 2"), new Task("TAsk 3"));
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        /**
         * future is like promise untill and unless it gets the value from the thread
         * it worn execute further
         */
        List<Future<String>> futures = executorService.invokeAll(tasks);

        futures.forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        /**
         * we need to shutdown otherwise it will continue executing
         */
        for (int i = 301; i <= 399; i++)
            System.out.print(i + " ");

        System.out.println("Main done!");
        executorService.shutdown();
    }

}
