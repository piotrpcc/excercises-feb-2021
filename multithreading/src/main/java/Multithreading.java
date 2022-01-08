public class Multithreading
{
    static int counter = 0;
    public static void main( String[] args )
    {
        Runnable runnable = () -> counter++;

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println(counter);
        System.out.println(counter);
        System.out.println(counter);
        System.out.println(counter);
        System.out.println(counter);
        System.out.println(counter);
        System.out.println(counter);
        System.out.println(counter);
        System.out.println(counter);
        System.out.println(counter);
    }
}