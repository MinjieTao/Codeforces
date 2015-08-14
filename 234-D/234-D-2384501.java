import java.util.*;
import java.io.*;
public class d {
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(System.in);
    Scanner input = new Scanner(new File("input.txt"));
    PrintWriter out = new PrintWriter(new File("output.txt"));
    //insert code here
    int n = input.nextInt(), k = input.nextInt();
    boolean[] favs = new boolean[n+1];
    for(int i = 0; i<k; i++)
        favs[input.nextInt()] = true;
    int num = input.nextInt();
    int[] yes = new int[num], maybe = new int[num];
    int[] actnum = new int[num];
    int[] maxes = new int[num];
    ArrayList<Integer> possible = new ArrayList<Integer>();
    int max = 0, max2 = 0, max3 = 0;
    for(int i = 0; i<num; i++)
    {
        input.next();
        int actors = input.nextInt();
        actnum[i] = actors;
        for(int j = 0; j<actors; j++)
        {
            int at = input.nextInt();
            if(at == 0)
                maybe[i]++;
            else if(favs[at])
                yes[i]++;
        }
        max = Math.max(max, yes[i]);
        max = Math.max(max, actors-n+k);
        maxes[i] = Math.min(k,yes[i]+maybe[i]);
    }
    //System.out.println(max + " " + max2);
    for(int i = 0; i<num; i++)
    {
        if(yes[i] + maybe[i] >= max)
            possible.add(i);
    }
    int[] res = new int[num];
    Arrays.fill(res, 1);
    if(possible.size() == 1)
        res[possible.get(0)] = 0;
    else
    {
        for(int d: possible)
        {
            //System.out.println(d);
            res[d] = 2;
            boolean okay = true;
            for(int i = 0; i<num; i++)
            {
                if(Math.max(yes[d], actnum[d] - n + k) < maxes[i] && i!= d)
                    okay = false;
            }
            if(okay)
                res[d] = 0;
        }
    }
    for(int i = 0; i<num; i++)
        out.println(res[i]);
    out.close();
}
}