import java.util.*;
public class a
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++)
      data[i] = input.nextInt();
    boolean good = false;
    for(int i = 30; i>=0; i--)
    {
      int and = (1<<31)-1;
      boolean found = false;
      int count = 0;
      for(int j = 0; j<n; j++)
      {
        if(((1<<i) & data[j]) > 0)
        {
        found = true;
        and &= data[j];
        count++;
        }
       }
      if(!found) continue;
      if(and%(1<<i) != 0) continue;
      good = true;
      System.out.println(count);
      for(int j = 0; j<n; j++)
      {
         if(((1<<i) & data[j]) > 0)
           System.out.print(data[j]+" ");      
      }
      break;
    }
    if(!good)
    {
      System.out.println(n);
      for(int x: data) System.out.print(x+" ");
    }
  }
}