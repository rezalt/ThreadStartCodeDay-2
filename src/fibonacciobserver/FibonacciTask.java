package fibonacciobserver;

import java.util.ArrayList;
import java.util.List;

public class FibonacciTask extends Thread
{

    private long tal;
    List<FibonacciObserver> observers = new ArrayList();

    public void registerFibonacciObserver(FibonacciObserver o)
    {
        observers.add(o);
    }

    public FibonacciTask(long n)
    {
        this.tal = n;
    }

    @Override
    public void run()
    {
        // Call the fib from here
         long newTal = fib(tal);
         for(FibonacciObserver observer : observers){
          observer.dataReady(newTal);
         
        }
    }

    
    private long fib(long n)
    {
        if ((n == 0) || (n == 1))
        {
           
            return n;
        }
        else
        {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public void setTal(long tal)
    {
        tal = this.tal;
    }

    public long getTal()
    {
        return tal;
    }
    
    
    
    
    
}
