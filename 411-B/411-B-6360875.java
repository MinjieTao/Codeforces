import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt(), K = input.nextInt();
    int[][] data = new int[m][n];
    for(int j = 0; j<n; j++)
        for(int  i= 0; i<m; i++)
            data[i][j] = input.nextInt();
    boolean[] bad = new boolean[n];
    int[] gen = new int[n];
    boolean[] locked = new boolean[K+1];
    for(int i = 0; i<m; i++)
    {
        HashSet<Integer> lock = new HashSet<Integer>();
        for(int j = 0; j<n; j++)
        {
            if(data[i][j] == 0) continue;
            for(int k = j+1; k<n; k++)
                if(!bad[j] && !bad[k] && data[i][j] == data[i][k])
                {
                    lock.add(j);
                    lock.add(k);
                }
        }
        for(int j = 0; j<n; j++) if(locked[data[i][j]] && !bad[j]) lock.add(j);
        for(int x: lock)
        {
            gen[x] = i+1;
            locked[data[i][x]] = true;
            bad[x] = true;
        }
    }
    for(int i = 0; i<n; i++) System.out.println(gen[i]);
}
}