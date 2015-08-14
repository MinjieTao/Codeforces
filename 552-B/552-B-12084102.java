import java.util.*;
public class b {
public static void main(String[] args)
{
  Scanner input = new Scanner(System.in);
  int  n= input.nextInt();
  long res = 0;
  long pow = 1, dig = 1;
  while(true)
  {
    res += dig * (Math.max(0, Math.min(10l*pow-1, n) - pow + 1));
    dig++;
    pow *= 10;
    if(pow > 1e9) break;
  }
  System.out.println(res);
}
}