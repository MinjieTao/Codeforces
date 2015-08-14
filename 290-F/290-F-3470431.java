import java.util.*;
public class j {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    boolean[][] adj = new boolean[n][n];
    for(int i = 0; i<m; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1;
        if(a!=b)
        adj[a][b] = adj[b][a] = true;
    }
    ArrayList<Integer>[] graph = new ArrayList[n];
    int[] degrees = new int[n];
    for(int i = 0; i<n; i++)
    {
        graph[i] = new ArrayList<Integer>();
        for(int j =0; j<n; j++) if(adj[i][j]) 
        {
            graph[i].add(j);
            degrees[i]++;
        }
    }
    int[] sorted = new int[n];
    int index = 0;
    for(int i = 0; i<=n;i++)
        for(int j = 0; j<n; j++)
            if(degrees[j] == i)
                sorted[j] = index++;
    boolean good = false;
    for(int i = 0; i<n; i++)
    {
        boolean[] visited = new boolean[n];
        int at = i;
        int count = 1;
        visited[i] = true;
        while(true)
        {
            int togo = -1;
            for(int j = 0; j<graph[at].size(); j++)
                if(!visited[graph[at].get(j)] && (togo==-1 || sorted[graph[at].get(j)] < sorted[togo]))
                    togo = graph[at].get(j);
            if(togo != -1)
            {
                count++;
                at = togo;
                visited[togo] = true;
            }
            else
                break;
        }
        if(count==n) good = true;
    }
    System.out.println(good?"Yes":"No");
}
}