package ch02.third.begin;

/**
 * Two threads cooking soup
 */

class ChefOlivia extends Thread {
    public void run() {
        System.out.println("Olivia started & waiting for sausage to thaw...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Olivia is done cutting sausage.");
    }
}

public class ThreadLifecycleDemo {
    public static void main(String args[]) throws InterruptedException {
        System.out.println("Barron started & requesting Olivia's help.");
        Thread olivia = new ChefOlivia();

        System.out.println("Barron tells Olivia to start.");
        olivia.start();

        System.out.println("Barron continues cooking soup.");
        Thread.sleep(500);
        /**
         *Oliva le 3 sec lekoxe ra Barron le 5 sec so tara hami guarentee garna sakdainau
         * kun thread le chado sakuxa so oliva le sakepaxi matra baroon le start gar vanalai
         * join use garne
         */
        System.out.println("Barron patiently waits for Olivia to finish and join...");
        olivia.join();

        System.out.println("Barron and Olivia are both done!");
    }
}