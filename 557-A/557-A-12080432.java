import java.util.*;
public class a {
public static void main(String[] args)
{
  Scanner input = new Scanner(System.in);
  int n = input.nextInt();
  int[] mins = new int[3], maxs = new int[3];
  for(int  i= 0; i<3; i++)
  {
    mins[i] = input.nextInt();
    maxs[i] = input.nextInt();
  }
  int[] res = new int[3];
  res[0] = Math.min(n - mins[1] - mins[2], maxs[0]);
  n -= res[0];
  res[1] = Math.min(n - mins[2], maxs[1]);
  n -= res[1];
  res[2] = n;
  System.out.println(res[0]+" "+res[1]+" "+res[2]);
}
}