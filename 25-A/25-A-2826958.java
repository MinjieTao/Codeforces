import java.util.*;
import java.io.*;
public class a
{
    public static void main(String[] args) throws IOException
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] data = new int[n];
        for(int i = 0; i<n; i++) data[i] = input.nextInt();
        for(int i = 0; i<n; i++) if(data[i]%2 != data[(i+1)%n]%2 && data[i]%2 != data[(i+2)%n]%2) System.out.println(i+1);
    }
}