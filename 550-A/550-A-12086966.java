import java.util.*;
public class a {
public static void main(String[] args)
{
  Scanner input = new Scanner(System.in);
  String s = input.next();
  ArrayList<Integer> ab = new ArrayList<Integer>(), ba = new ArrayList<Integer>();
  for(int i = 0; i<s.length()-1; i++)
  {
    char c1 = s.charAt(i), c2 = s.charAt(i+1);
    if(c1 == 'A' && c2 == 'B') ab.add(i);
    else if(c1 == 'B' && c2 == 'A') ba.add(i);
  }
  boolean good = false;
  for(int a : ab)
  {
    for(int b : ba)
    {
      if(Math.abs(a - b) > 1)
      {
        good = true;
        break;
      }
    }
    if(good) break;
  }
  System.out.println(good ? "YES":"NO");
}
}