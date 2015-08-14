import java.util.*;
import java.io.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), k = input.nextInt();
    if(k*3 > n)
        out.println(-1);
    else
    {
        int[] data = new int[n];
        Arrays.fill(data, 1);
        if(k%2 == 1)
        {
            data[0] = data[1] = data[3] = 1;
            data[2] = data[5] = data[6] = 2;
            data[4] = data[7] = data[8] = 3;
            for(int i = 0; i<k-3; i+=2)
            {
                data[9+i*3] = data[11+i*3] = data[12+i*3] = i+4;
                data[10+i*3] = data[13+i*3] = data[14+i*3] = i+5;
            }
        }
        else
            for(int i =0; i<k; i+=2)
            {
                data[i*3] = data[2+i*3] = data[3+i*3] = i+1;
                data[i*3+1] = data[4+i*3] = data[5+i*3] = i+2;
            }
        for(int i: data) out.print(i+" ");
    }
    out.close();
}
}