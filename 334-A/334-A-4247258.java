import java.util.*;
public class a
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int at = 1;
    for(int i = 0; i<n; i++)
    {
      for(int j = 0; j<n/2; j++)
      {
        System.out.print(at+" "+(n*n+1-at)+" ");
        ++at;
      }
      System.out.println();
    }
  }
}