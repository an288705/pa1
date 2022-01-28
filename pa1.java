import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class pa1{
    public static AtomicInteger count= new AtomicInteger(0);
    public static AtomicLong primeSum= new AtomicLong(0);
    public static ArrayList<Integer> maxPrimes = new ArrayList<Integer>();
    public static int loop=12500000;

    static boolean isPrime(int n) {
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        
        for(int i = 6; i <= (int) (Math.sqrt(n)+1); i += 6) {
            if(n%(i-1) == 0 || n%(i+1) == 0)
            {
                return false;
            } 
        }

        return true;
    }

    public static void main(String[] args) {
        Runnable runnable1 = ()->{

            for(int i=0;i<loop*1;i++)
            {
                if(isPrime(i))
                {
                    count.incrementAndGet();
                    primeSum.addAndGet(i);

                    if(count.get()>5761445)
                    {
                        maxPrimes.add(i);
                    }
                }
            }
            
        };

        Runnable runnable2 = ()->{

            for(int i=loop*1;i<loop*2;i++)
            {
                if(isPrime(i))
                {
                    count.incrementAndGet();
                    primeSum.addAndGet(i);

                    if(count.get()>5761445)
                    {
                        maxPrimes.add(i);
                    }
                }
            }
            
        };

        Runnable runnable3 = ()->{

            for(int i=loop*2;i<loop*3;i++)
            {
                if(isPrime(i))
                {
                    count.incrementAndGet();
                    primeSum.addAndGet(i);

                    if(count.get()>5761445)
                    {
                        maxPrimes.add(i);
                    }
                }
            }
            
        };

        Runnable runnable4 = ()->{
 
            for(int i=loop*3;i<loop*4;i++)
            {
                if(isPrime(i))
                {
                    count.incrementAndGet();
                    primeSum.addAndGet(i);

                    if(count.get()>5761445)
                    {
                        maxPrimes.add(i);
                    }
                }
            }
            
        };

        Runnable runnable5 = ()->{

            for(int i=loop*4;i<loop*5;i++)
            {
                if(isPrime(i))
                {
                    count.incrementAndGet();
                    primeSum.addAndGet(i);

                    if(count.get()>5761445)
                    {
                        maxPrimes.add(i);
                    }
                }
            }
            
        };

        Runnable runnable6 = ()->{

            for(int i=loop*5;i<loop*6;i++)
            {
                if(isPrime(i))
                {
                    count.incrementAndGet();
                    primeSum.addAndGet(i);

                    if(count.get()>5761445)
                    {
                        maxPrimes.add(i);
                    }
                }
            }
            
        };

        Runnable runnable7 = ()->{

            for(int i=loop*6;i<loop*7;i++)
            {
                if(isPrime(i))
                {
                    count.incrementAndGet();
                    primeSum.addAndGet(i);

                    if(count.get()>5761445)
                    {
                        maxPrimes.add(i);
                    }
                }
            }
            
        };

        Runnable runnable8 = ()->{

            for(int i=loop*7;i<loop*8;i++)
            {
                if(isPrime(i))
                {
                    count.incrementAndGet();
                    primeSum.addAndGet(i);

                    if(count.get()>5761445)
                    {
                        maxPrimes.add(i);
                    }
                }
            }
            
        };

        long start = System.nanoTime();
        ArrayList<Thread> threadList = new ArrayList<Thread>();
        Thread thread1 = new Thread(runnable1);
        thread1.start();
        threadList.add(thread1);
        Thread thread2 = new Thread(runnable2);
        thread2.start();
        threadList.add(thread2);
        Thread thread3 = new Thread(runnable3);
        thread3.start();
        threadList.add(thread3);
        Thread thread4 = new Thread(runnable4);
        thread4.start();
        threadList.add(thread4);
        Thread thread5 = new Thread(runnable5);
        thread5.start();
        threadList.add(thread5);
        Thread thread6 = new Thread(runnable6);
        thread6.start();
        threadList.add(thread6);
        Thread thread7 = new Thread(runnable7);
        thread7.start();
        threadList.add(thread7);
        Thread thread8 = new Thread(runnable8);
        thread8.start();
        threadList.add(thread8);

        for(Thread t : threadList)
        {
            try
            {
                t.join();
            }
            catch(InterruptedException e)
            {
                return;
            }
        }

        long end = System.nanoTime();

        try {
            File primes = new File("primes.txt");
            FileWriter writer = new FileWriter(primes);
            writer.write(String.valueOf(end-start)+" "+String.valueOf(count)+" "+String.valueOf(primeSum)+"\n");

            for(int x : maxPrimes)
            {
                writer.write(String.valueOf(x)+" ");
            }

            writer.close();
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
}