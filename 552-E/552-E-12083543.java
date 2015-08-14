import java.util.*;
public class e {
public static void main(String[] args)
{
  Scanner input = new Scanner(System.in);
  String s = input.next();
  int n = s.length();
  long res = eval(s, 0, n-1, 0);
  ArrayList<Integer> pos = new ArrayList<Integer>();
  pos.add(-1);
  for(int i = 0; i<n; i++) if(s.charAt(i) == '*') pos.add(i);
  pos.add(n);
  for(int ii = 0; ii<pos.size(); ii++)
    for(int jj = ii+1; jj<pos.size(); jj++)
    {
      int i = pos.get(ii), j = pos.get(jj);
      if(ii == 0 && jj == pos.size() - 1) continue;
      StringBuilder sb = new StringBuilder("");
      for(int k = 0; k<=i; k++) sb.append(s.charAt(k));
      sb.append('?');
      long v = eval(s, i+1, j - 1, 0);
      for(int k = j; k<n; k++) sb.append(s.charAt(k));
      String ss = sb.toString();
      //System.out.println(ss+" "+v);
      long cur = eval(ss, 0, ss.length()-1, v);
      res = Math.max(res, cur);
    }
  System.out.println(res);
}
static long eval(String s, int a, int b, long v)
{
  Stack<Long> stk = new Stack<Long>();
  long cur = s.charAt(a) == '?' ? v : s.charAt(a) - '0';
  int i = a;
  while(i < s.length() - 1 && s.charAt(i+1) == '*' && i + 2 <= b)
  {
    cur *= s.charAt(i+2) == '?' ? v : s.charAt(i+2) - '0';
    i += 2;
  }
  stk.push(cur);
  i += 2;
  for(; i<=b; i+=2)
  {
    cur = s.charAt(i) - '0';
    while(i < s.length() - 1 && s.charAt(i+1) == '*' && i + 2 <= b)
    {
      cur *= s.charAt(i+2) == '?' ? v : s.charAt(i+2) - '0';
      i += 2;
    }
    stk.push(cur + stk.pop());
  }
  return stk.pop();
}
}