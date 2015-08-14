import java.util.*;

public class aa {
public static void main(String[] args)
{
  Scanner input = new Scanner(System.in);
  int n = input.nextInt();
  String s = input.next();
  int a = 0;
  for(int i = 0; i<n; i++) if(s.charAt(i) == '0') a++;
  System.out.println(Math.abs(a - (n-a)));
}
}