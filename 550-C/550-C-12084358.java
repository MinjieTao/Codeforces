import java.util.*;
public class c {
public static void main(String[] args)
{
  Scanner input = new Scanner(System.in);
  char[] s = input.next().toCharArray();
  int n = s.length;
  boolean good = false;
  for(int i = 0; i<n; i++) if(s[i] == '8' || s[i] == '0')
  {
    System.out.println("YES\n"+s[i]);
    return;
  }
  for(int i = 0; i<n; i++)
    for(int j = i+1; j<n; j++)
    {
      int cur = 10* (s[i] - '0') + (s[j] - '0');
      if(cur%8 == 0)
      {
        System.out.println("YES\n"+cur);
        return;
      }
    }
  for(int i = 0; i<n; i++)
    for(int j = i+1; j<n; j++)
    {
      for(int k = j+1; k<n; k++)
      {
      int cur = 10*(10* (s[i] - '0') + (s[j] - '0'))+(s[k] - '0');
      if(cur%8 == 0)
      {
        System.out.println("YES\n"+cur);
        return;
      }
      }
    }
  System.out.println("NO");
}
}