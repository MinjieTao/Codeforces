import java.util.*;
public class e {
  static int MAX = 13000000;
public static void main(String[] args)
{
  Scanner input = new Scanner(System.in);
  Random r = new Random();
  //s = new char[5000];
  //for(int i = 0; i<s.length; i++) s[i] = (char)('a' + r.nextInt(2)); 
  s = input.next().toCharArray();
  int n = s.length;
  int k = input.nextInt();
  pal = new boolean[n][n];
  for(int i = 0; i<n; i++)
  {
    pal[i][i] = true;
    if(i < n - 1 && s[i+1] == s[i]) pal[i][i+1] = true;
    if(i < n - 2 && s[i+2] == s[i]) pal[i][i+2] = true;
    if(i < n - 3 && s[i+3] == s[i]) pal[i][i+3] = true;
  }
  for(int len = 5; len <= n; len++)
    for(int i = 0; i+len <= n; i++)
      pal[i][i+len-1] = pal[i+2][i+len-3] && s[i] == s[i+len-1];
  //Node trie = new Node();
  left = new int[MAX];
  right = new int[MAX];
  count =new int[MAX];
  sum = new int[MAX];
  Arrays.fill(left, -1);
  Arrays.fill(right, -1);
  //System.out.println("START");
  for(int i = 0; i<n; i++) add(0, i, i);
  //System.out.println("ADDED");
  //System.out.println(cnt);
  String res = "";
  int at = 0;
  //for(int i = 0; i<n; i++) System.out.println(Arrays.toString(pal[i]));
  int togo = k;
  //System.out.println(count[3]+" "+sum[3]);
  while(true)
  {
    //System.out.println(at+" "+count[at]+" "+sum[at]+" "+left[at]+" "+right[at]);
    //System.out.println(at.sum+" "+at.count+" "+at.children[0].sum+" "+left);
    if(count[at] >= togo)
    {
      break;
    }
    togo -= count[at];
    int leftSide = left[at] == -1 ? 0 : sum[left[at]];
    if(leftSide >= togo)
    {
      res += 'a';
      at = left[at];
      continue;
    }
    res += 'b';
    togo -= left[at] == -1 ? 0 : sum[left[at]];
    at = right[at];
  }
  System.out.println(res);
}
static char[] s;
static boolean[][] pal;
static int cnt = 0;
static int[] count;
static int[] left, right;
static int[] sum;
static void add(int at, int i, int j)
{
  //System.out.println(at+" "+i+" "+j);
  if(j >= s.length) return;
  int idx = s[j] - 'a';
  boolean good = pal[i][j];
  if(idx == 0 && left[at] == -1)
  {
    left[at] = ++cnt;
  }
  else if(idx == 1 && right[at] == -1)
  {
    right[at] = ++cnt;
  }
  if(good)
  {
    sum[(s[j] == 'a' ? left[at] : right[at])]++;
    count[(s[j] == 'a' ? left[at] : right[at])]++;
  }
  add(s[j] == 'a' ? left[at] : right[at], i, j+1);
  sum[at] = count[at] + (left[at] == -1 ? 0 : sum[left[at]]) + (right[at] == -1 ? 0 : sum[right[at]]);
}
//static class Node
//{
//  Node[] children;
//  int count = 0;
//  int sum;
//  //int idx;
//  public Node()
//  {
//    //idx = cnt++;
//    children = new Node[2];
//  }
//  void add(int i, int j)
//  {
//    if(j >= s.length) return;
//    int idx = s[j] - 'a';
//    if(children[idx] == null)
//    {
//      children[idx] = new Node();
//    }
//    if(pal[i][j])
//    {
//      children[idx].count++;
//      children[idx].sum++;
//    }
//    children[idx].add(i, j+1);
//    sum = count + (children[0] == null ? 0 : children[0].sum) + (children[1] == null ? 0 : children[1].sum);
//  }
//}
}