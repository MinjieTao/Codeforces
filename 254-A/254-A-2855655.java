import java.util.*;
import java.io.*;
public class a
{
    public static void main(String[] args) throws IOException
    {
        FileReader fin = new FileReader(new File("input.txt"));
        BufferedReader input = new BufferedReader(fin);
        FileWriter fout = new FileWriter(new File("output.txt"));
        BufferedWriter out = new BufferedWriter(fout);
        StringTokenizer str = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(str.nextToken());
        str = new StringTokenizer(input.readLine());
        ArrayList<Integer>[] data = new ArrayList[5000];
        for(int i = 0; i<5000; i++) data[i] = new ArrayList<Integer>();
        for(int i = 0; i<2*n; i++)
        {
            int x = Integer.parseInt(str.nextToken());
            data[x-1].add(i+1);
        }
        boolean okay = true;
        for(int i = 0; i<5000; i++) if(data[i].size()%2 == 1) okay = false;
        if(okay)
        {
        for(int i =0; i<5000; i++)
        {
            for(int j = 0; j<data[i].size()/2; j++)
            {
                out.write(data[i].get(2*j) + " " + data[i].get(2*j+1)+"\n");
            }
        }
        }
        else
        {
            out.write("-1");
        }
        out.close();
    }
    
}