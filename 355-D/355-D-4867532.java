import java.util.*;
public class b {
    static int n;
    static char[][] data;
    static int[][] masks;
    static int[][] memo;
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    n = input.nextInt();
    data = new char[n][n];
    for(int i = 0; i<n; i++) data[i] = input.next().toCharArray();
    if(n==1)
    {
        if(data[0][0] == 'a') System.out.println("FIRST");
        else if(data[0][0] == 'b') System.out.println("SECOND");
        else System.out.println("DRAW");
        return;
    }
    memo = new int[2*n+2][1<<n];
    for(int[] A: memo) Arrays.fill(A, -1);
    
    masks = new int[2*n+2][26];
    for(int i = 0; i<2*n; i++) //diag - sum of x and y
        for(int j = 0; j<26; j++) //letter
            for(int k = 0; k<n; k++) //x coord
            {
                int r = k, c = i-k;
                if(c>=0 && c<n && data[r][c] == 'a'+j) masks[i][j] |= (1<<k);
            }
    int res = go(0, 1, data[0][0]-'a', false);
    if(res==0) System.out.println("DRAW");
    else System.out.println(res < 0 ? "FIRST" : "SECOND");
}
static int go(int diag, int mask, int ch, boolean first)
{
    if(diag == 2*(n-1))
    {
        if(first)
        {
            if(ch == 0) return 1;
            else if(ch == 1) return -1;
            return 0;
        }
        else
        {
            if(ch==0) return -1;
            else if(ch==1) return 1;
            return 0;
        }
    }
    if(memo[diag][mask] != -1) return memo[diag][mask];
    int res = -987654321;
    for(int i =0; i<26; i++)
    {
        int nmask = (mask | (mask << 1)) & (masks[diag+1][i]);
        if(nmask > 0) res = Math.max(res, -go(diag+1, nmask, i, !first));
    }
    if(first)
    {
        if(ch == 0) return memo[diag][mask] = 1+res;
        else if(ch == 1) return memo[diag][mask] = res-1;
        return memo[diag][mask] = res;
    }
    else
    {
        if(ch==0) return memo[diag][mask] = res-1;
        else if(ch==1) return memo[diag][mask] = res+1;
        return memo[diag][mask]=res;
    }
}
}