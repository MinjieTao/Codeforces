import java.util.*;

public class f {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    n = input.nextInt();
    m = input.nextInt();
    needCol = new int[m];
    needRow = new int[n];
    ans = new int[m];
    for(int i = 0; i<n; i++) needRow[i] = input.nextInt();
    for(int j = 0; j<m; j++) needCol[j] = input.nextInt();
    mlist = new ArrayList[4];
    for(int i = 0; i<4; i++) mlist[i] = new ArrayList<Integer>();
    for(int i = 0; i<(1<<n); i++) mlist[countSegs(i)].add(i);
    trace(new int[n], 0, 0);
    //System.out.println(okay);
    int[][] res = new int[n][m];
    for(int j = 0; j<m; j++)
        for(int i = 0; i<n; i++)
        {
            res[i][j] = (ans[j] & (1<<i)) > 0 ? 1 : 0;
        }
    for(int i = 0; i<n; i++)
    {
        for(int j = 0; j<m; j++) System.out.print(res[i][j] == 1 ? '*' : '.');
        System.out.println();
    }
}
static ArrayList<Integer>[] mlist;
static int n, m;
static int[] needCol;
static int[] needRow;
static int[] ans;
static HashMap<Integer, Boolean> memo = new HashMap<Integer, Boolean>();
static void trace(int[] rowCount, int mask, int col)
{
    if(col == m) return;
    for(int i : mlist[needCol[col]])
    {
        int[] nrc = new int[n];
        for(int j = 0; j<n; j++)
        {
            nrc[j] = rowCount[j];
            if((i & (1<<j)) > 0 && (mask & (1<<j)) == 0) nrc[j]++;
        }
        if(go(nrc, i, col+1))
        {
            ans[col] = i;
            trace(nrc, i, col+1);
            return;
        }
    }
}
static boolean go(int[] rowCount, int mask, int col)
{
    int key = encode(rowCount, mask, col);
    if(memo.containsKey(key)) return memo.get(key);
    if(col == m)
    {
        for(int i = 0; i<n; i++) if(rowCount[i] != needRow[i]) return false;
        return true;
    }
    for(int i = 0; i<n; i++)
    {
        if((m - col + 1)/2 + rowCount[i] < needRow[i])
        {
            memo.put(key, false);
            return false;
        }
    }
    for(int i : mlist[needCol[col]])
    {
        int[] nrc = new int[n];
        for(int j = 0; j<n; j++)
        {
            nrc[j] = rowCount[j];
            if((i & (1<<j)) > 0 && (mask & (1<<j)) == 0) nrc[j]++;
        }
        if(go(nrc, i, col+1))
        {
            //ans[col] = i;
            memo.put(key, true);
            return true;
        }
    }
    memo.put(key, false);
    return false;
}
static int encode(int[] rowCounts, int mask, int col)
{
    int key = 0;
    for(int i = 0; i<rowCounts.length; i++)
    {
        key *= 11;
        key += rowCounts[i];
    }
    return col + m * (mask + (1<<n) *key);
}
static int countSegs(int mask)
{
    int res = 0;
    for(int i = 0; i<5; i++)
    {
        if((mask & (1<<i)) == 0) continue;
        if(i == 0 || ((mask & (1<<(i-1))) == 0)) res++;
    }
    return res;
}
}