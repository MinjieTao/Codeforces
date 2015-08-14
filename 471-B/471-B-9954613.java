import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    int[] order = new int[n];
    for(int i = 0; i<n; i++) order[i] = i;
    for(int i = 0; i<n; i++)
        for(int j = 0; j<n-1; j++)
            if(data[order[j]] > data[order[j+1]])
            {
                int temp = order[j];
                order[j] = order[j+1];
                order[j+1] = temp;
            }
    int[][] res = new int[3][n];
    for(int i = 0; i<n; i++)
        for(int j = 0; j<3; j++)
            res[j][i] = order[i]+1;
    boolean found = false;
    HashMap<Integer, Integer> dupes = new HashMap<Integer, Integer>();
    for(int i = 0; i<n && !found; i++)
    {
        ArrayList<Integer> same = new ArrayList<Integer>();
        for(int j = 0; j<i; j++)
        {
            if(data[order[i]] == data[order[j]]) same.add(j);
        }
        if(same.size() >= 2)
        {
            found = true;
            int j = same.get(0);
            int k = same.get(1);
            int temp = res[1][i];
            res[1][i] = res[1][j];
            res[1][j] = temp;
            temp = res[2][i];
            res[2][i] = res[2][k];
            res[2][k] = temp;
            System.out.println("YES");
            for(j = 0; j<3; j++)
            {
                for(int x : res[j]) System.out.print(x+" ");
                System.out.println();
            }
            
        }
        else if(same.size() > 0)
        {
            dupes.put(i, same.get(0));
        }
    }
    if(!found)
    {
        if(dupes.size() > 1)
        {
            int at = 1;
            for(int x : dupes.keySet())
            {
                int y = dupes.get(x);
                int temp = res[at][x];
                res[at][x] = res[at][y];
                res[at][y] = temp;
                at++;
                if(at == 3) break;

            }
            System.out.println("YES");
            for(int j = 0; j<3; j++)
            {
                for(int x : res[j]) System.out.print(x+" ");
                System.out.println();
            }
        }
        else
        {
            System.out.println("NO");
        }
    }
}
}