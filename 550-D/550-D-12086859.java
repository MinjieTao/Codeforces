import java.util.*;
public class d {
public static void main(String[] args)
{
  Scanner input = new Scanner(System.in);
  int n = input.nextInt();
  if(n%2 == 0)
  {
    System.out.println("NO");
  }
  else if(n == 1)
  {
    System.out.println("YES");
    System.out.println("2 1");
    System.out.println("1 2");
  }
  else
  {
    System.out.println("YES");
    System.out.println(4*(n-1)+2+" "+(1+2*(n-1 + (n-1)*(n-1) + n/2)));
    for(int i = 2; i<= n; i++)
    {
      System.out.println("1 "+i);
      System.out.println(2*(n-1)+2+" "+(2*(n-1)+2+i-1));
    }
    for(int i = 2; i<=n; i++)
      for(int j = n+1; j<= 2*n-1; j++)
      {
        System.out.println(i+" "+j);
        System.out.println((i+2*(n-1)+1)+" "+(j+2*(n-1)+1));
      }
    for(int i = n+1; i<2*n; i+=2)
    {
      System.out.println(i+" "+(i+1));
      System.out.println((i+2*(n-1)+1)+" "+(i+1+2*(n-1)+1));
    }
    System.out.println(1+" "+(2*(n-1)+2));
  }
}
}