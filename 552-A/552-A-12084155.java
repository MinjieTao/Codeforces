import java.util.*;
public class a {
public static void main(String[] args)
{
  Scanner input = new Scanner(System.in);
  int n = input.nextInt(), res = 0;
  for(int i = 0; i<n; i++)
  {
    int[] data = new int[4];
    for(int j = 0; j<4; j++) data[j] = input.nextInt();
    res += (1+data[2] - data[0]) * (1+data[3] - data[1]);
  }
  System.out.println(res);
}
}