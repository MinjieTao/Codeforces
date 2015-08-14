import java.util.*;
public class e {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    ArrayList<Integer>[] lo = new ArrayList[n+1], hi = new ArrayList[n+1];
    for(int i = 0; i<=n; i++)
    {
        lo[i] = new ArrayList<Integer>();
        hi[i] = new ArrayList<Integer>();
    }
    for(int i = 1; i<=n; i++)
    {
        int twopow = 2;
        for(int j = 0; j<20; j++)
        {
            if(i%twopow != 0)
            {
                break;
            }
            twopow *= 2;
        }
        for(int jj = 1; jj<=Math.sqrt(n); jj++)
        {
            int j = jj;
            if(i%j != 0) continue;
            int other = i/j;
            for(int k = 0; k<2; k++)
            {
                if(k==1)
                {
                    if(j==other) break;
                    int temp = j;
                    j = other;
                    other = temp;
                }
                if((j&1) > 0)
                {
                    int center = other;
                    int a = center - j/2, b = center + j/2;
                    if(a>0 && j > 1)
                    {
                        lo[i].add(a);
                        hi[i].add(b);
                    }
                    int j2 = twopow*j;
                    int a2 = i/j2 - (j2/2) + 1;
                    int b2 = i/j2 + j2/2;
                    if(a2 > 0)
                    {
                        lo[i].add(a2);
                        hi[i].add(b2);
                    }
                }
            }
        }
    }
    int[] ans = new int[n+1];
    int[] cxor = new int[n+1];
    int res = -1;
    for(int i = 1;i<=n;i++){
        TreeSet<Integer> xors = new TreeSet<Integer>();
        for(int j = 0;j<lo[i].size();j++){
            int cur = cxor[hi[i].get(j)]^cxor[lo[i].get(j)-1];
            xors.add(cur);
            if(i == n && cur == 0){
                int len = hi[i].get(j)-lo[i].get(j)+1;
                res = (res == -1 ? len : Math.min(len, res));
            }
        }
        int pos = 0;
        for(int j : xors){
            if(j != pos){
                break;
            }
            pos++;
        }
        ans[i] = pos;
        cxor[i] = cxor[i-1]^pos;
    }
    System.out.println(res);
}
}