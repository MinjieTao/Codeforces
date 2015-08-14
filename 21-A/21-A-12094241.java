import java.util.*;
public class a21 {
public static void main(String[] args)
{
  Scanner input = new Scanner(System.in);
  String s = input.next();
  System.out.println(good(s) ? "YES" : "NO");
}
static boolean good(String s)
{
  int at = s.indexOf('@');
  if(at == -1) return false;
  String a = s.substring(0, at);
  String b = s.substring(at+1);
  if(!username(a)) return false;
  int slash = b.indexOf('/');
  if(slash != -1)
  {
    String c = b.substring(slash+1);
    b = b.substring(0, slash);
    return hostname(b) && resource(c);
  }
  return hostname(b);
}
static boolean goodChars(String s)
{
  for(char c : s.toCharArray())
  {
    if(c >= 'a' && c <= 'z') continue;
    if(c >= 'A' && c <= 'Z') continue;
    if(c >= '0' && c <= '9') continue;
    if(c == '_') continue;
    return false;
  }
  return true;
}
static boolean username(String s)
{
  if(!goodChars(s)) return false;
  return s.length() >= 1 && s.length() <= 16;
}
static boolean hostname(String s)
{
  if(s.length() < 1 || s.length() > 32) return false;
  StringTokenizer str = new StringTokenizer(s, ".");
  if(s.charAt(0) == '.' || s.charAt(s.length()-1) == '.') return false;
  for(int i = 0; i<s.length()-1; i++)
    if(s.charAt(i) == '.' && s.charAt(i+1) == '.') return false;
  while(str.hasMoreTokens())
  {
    String cur = str.nextToken();
    if(!goodChars(cur)) return false;
    if(cur.length() < 1 || cur.length() > 16) return false;
  }
  return true;
}
static boolean resource(String s)
{
  return username(s);
}
}