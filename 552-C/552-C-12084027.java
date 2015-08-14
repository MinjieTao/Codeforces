import java.util.*;
public class c {
public static void main(String[] args)
{
  Scanner input = new Scanner(System.in);
  int  w= input.nextInt(), m = input.nextInt();
  boolean good =true;
  ArrayList<Integer> digits = new ArrayList<Integer>();
  while(m > 0 && w != 2)
  {
    int x = m%w;
    if(x == w - 1) m++;
    else if(x == 1) m--;
    else if(x == 0) ;
    else good = false;
    //System.out.println(x);
    //digits.add(x);
    m /= w;
  }
  System.out.println(good ? "YES" : "NO");
}
}