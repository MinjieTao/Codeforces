import java.util.*;
public class e {
    static int n, m;
    static int countOnes;
    static int firsti, firstj;
    static int[][] data;
    static int[] di = new int[]{1, 0, -1, 0};
    static int[] dj = new int[]{0, 1, 0, -1};
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    n = input.nextInt();
    m = input.nextInt();
    data = new int[n][m];
    boolean found = false;
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
        {
            data[i][j] = input.nextInt();
            if(data[i][j] == 1 && !found)
            {
                firsti = i;
                firstj = j;
                found = true;
            }
            if(data[i][j] == 1) countOnes++;
        }
    int size = getLongest() - 1;
    ArrayList<Integer> candidates = new ArrayList<Integer>();
    for(int i = 2; i<= size; i++)
        if(size % i == 0)
            candidates.add(i);
    ArrayList<Integer> answers = new ArrayList<Integer>();
    for(int c: candidates)
        if(possible(c))
            answers.add(c);
    for(int a: answers) System.out.print(a+" ");
    if(answers.size() == 0) System.out.println(-1);
}
static boolean possible(int len)
{
    int nodes = 0;
    int edgeCount = 0;
    int oddDegree = 0;
    for(int i = firsti; i<n; i+=len)
        for(int j = firstj - len*(firstj/len); j<m; j+=len)
        {
            if(data[i][j] == 0) continue; //No node here
            nodes++;
            int degree = 0;
            for(int k = 0; k<4; k++)
            {
                int ni = i + len*di[k];
                int nj = j + len*dj[k];
                if(ni >= n || ni < 0 || nj >= m || nj < 0 || data[ni][nj] == 0) continue;
                int ati = i, atj = j;
                boolean good = true;
                for(int l = 0; l<len; l++)
                {
                    ati += di[k];
                    atj += dj[k];
                    good &= data[ati][atj] == 1;
                }
                if(good) degree++;
            }
            edgeCount += degree;
            if(degree == 0) return false;
            if((degree & 1) == 1) oddDegree++;
        }
    if(oddDegree > 2) return false;
    if(countOnes != nodes + edgeCount/2 * (len - 1)) return false;
    if(!connected(len, nodes)) return false;
    return true;
}
static boolean connected(int len, int nodes)
{
    boolean[][] visited = new boolean[n][m];
    Queue<Integer> qi = new LinkedList<Integer>();
    Queue<Integer> qj = new LinkedList<Integer>();
    qi.add(firsti);
    qj.add(firstj);
    visited[firsti][firstj] = true;
    int count = 0;
    while(!qi.isEmpty())
    {
        int i = qi.poll(), j = qj.poll();
        count++;
        for(int k = 0; k<4; k++)
        {
            int ni = i + len*di[k];
            int nj = j + len*dj[k];
            if(ni >= n || ni < 0 || nj >= m || nj < 0 || data[ni][nj] == 0 || visited[ni][nj]) continue;
            int ati = i, atj = j;
            boolean good = true;
            for(int l = 0; l<len; l++)
            {
                ati += di[k];
                atj += dj[k];
                good &= data[ati][atj] == 1;
            }
            if(good)
            {
                visited[ni][nj] = true;
                qi.add(ni);
                qj.add(nj);
            }
        }
    }
    return count == nodes;
}
static int getLongest()
{
    int res = 1;
    int[][] horiz = new int[n][m];
    for(int i = 0; i<n; i++)
    {
        horiz[i][0] = data[i][0];
        for(int j = 1; j<m; j++)
        {
            horiz[i][j] = data[i][j] == 1 ? 1 + horiz[i][j-1] : 0;
            res = Math.max(res, horiz[i][j]);
        }
    }
    int[][] vert = new int[n][m];
    for(int j = 0; j<m; j++)
    {
        vert[0][j] = data[0][j];
        for(int i = 1; i<n; i++)
        {
            vert[i][j] = data[i][j] == 1 ? 1 + vert[i-1][j] : 0;
            res = Math.max(res, vert[i][j]);
        }
    }
    return res;
}
}