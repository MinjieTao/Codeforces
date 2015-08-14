import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    ArrayList<Integer>[] data = new ArrayList[3];
    for(int i = 0; i<3;i++) data[i] = new ArrayList<Integer>();
    for(int i = 0; i<n; i++) data[input.nextInt()-1].add(i+1);
    int res = Math.min(data[0].size(), Math.min(data[1].size(), data[2].size()));
    System.out.println(res);
    for(int i = 0; i<res; i++)
    {
        for(int j =0; j<3; j++) System.out.print(data[j].get(i) + (j==2 ? "\n" : " "));
    }
}
}