import java.util.*;
public class b {
public static void main(String[] args)
{
  Scanner input = new Scanner(System.in);
  int n = input.nextInt(), a = input.nextInt(), b = input.nextInt(), x = input.nextInt();
  int[] data = new int[n];
  for(int i = 0; i<n; i++) data[i] = input.nextInt();
  int res = 0;
  for(int i = 1; i<(1<<n); i++)
  {
    ArrayList<Integer> cur = new ArrayList<Integer>();
    int sum = 0;
    for(int j = 0; j<n; j++)
    {
      if((i & (1<<j)) > 0)
      {
        sum += data[j];
        cur.add(data[j]);
      }
    }
    Collections.sort(cur);
    int diff = cur.get(cur.size() - 1) - cur.get(0);
    if(sum >= a && sum <= b && diff >= x) res++;
  }
  System.out.println(res);
}
}