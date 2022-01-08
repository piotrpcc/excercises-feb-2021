public class Multithreading
{
    static int counter = 0;
    public static void main( String[] args ) throws InterruptedException {
        Runnable runnable = () ->{
                for (int i=0;i < 10000000; i++) {
                    counter++;
                }
    };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(counter);
        System.out.println(counter);
        System.out.println(counter);

    }
}