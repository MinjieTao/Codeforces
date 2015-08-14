import java.util.Scanner;

public class bb {
public static void main(String[] args)
{
  Scanner input = new Scanner(System.in);
  int n = input.nextInt();
  int[] data = new int[n];
  for(int i = 0; i<n; i++) data[i] = input.nextInt();
  boolean b = false;
  for(int i = 0; i<n; i++)
  {
    boolean cur = true;
    for(int j = 0; j<n; j++)
    {
      int p = data[j];
      if(j%2 == 0) p = (p+i)%n;
      else p = (p + n - i)%n;
      if(p != j) cur = false;
    }
    b |= cur;
  }
  System.out.println(b ? "Yes" :"No");
}
}