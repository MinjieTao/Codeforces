import java.util.*;
public class b298 {
public static void main(String[] args)
{
  Scanner input = new Scanner(System.in);
  int v1 = input.nextInt(), v2 = input.nextInt(), t = input.nextInt(), d = input.nextInt();
  int res = 0, v = v1;
  for(int i = 0; i<t; i++)
  {
    res += v;
    v = Math.min(v+d, v2 + d * (t-2-i));
  }
  System.out.println(res);
}
}