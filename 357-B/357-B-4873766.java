import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    int[] data = new int[n];
    for(int i =0; i<m; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1, c = input.nextInt()-1;
        if(data[a] == 0 && data[b] == 0 && data[c] == 0)
        {
            data[a] = 1;
            data[b] = 2;
            data[c] = 3;
        }
        else if(data[a] != 0)
        {
            data[b] = data[a]%3 + 1;
            data[c] = data[b]%3 + 1;
        }
        else if(data[b] != 0)
        {
            data[c] = data[b]%3 + 1;
            data[a] = data[c]%3 + 1;
        }
        else if(data[c] != 0)
        {
            data[a] = data[c]%3 + 1;
            data[b] = data[a]%3 + 1;
        }
    }
    for(int i = 0; i<n; i++) System.out.print(data[i]+" ");
}
}