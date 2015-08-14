import java.util.*;
public class AlmostPrime {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int a = input.nextInt();
    int count = 0;
    for(int i = 1; i<=a; i++)
    {
        if(ap(i))
        {
            //System.out.println(i);
            count++;
        }
    }
    System.out.println(count);
}
public static boolean ap(int n)
{
    int primes = 0;
    for(int i = 2; i< n; i++)
    {
        if(primes >2)
            return false;
        if(n%i==0 && isPrime(i))
        {
            primes++;
        }
    }
    return primes == 2;
}
public static boolean isPrime(int n)
{
    for(int i = 2; i<= Math.sqrt(n); i++)
        if(n%i==0)
            return false;
    return true;
}
}