import java.util.*;
import java.io.*;
public class a
{
    public static void main(String[] args) throws IOException
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int gooda = 0, bada = 0, goodb = 0, badb = 0;
        for(int i = 0; i<n; i++)
        {
            int t =input.nextInt();
            if(t==1)
            {
                gooda += input.nextInt();
                bada += input.nextInt();
            }
            else
            {
                goodb += input.nextInt();
                badb += input.nextInt();
            }
        }
        System.out.println(gooda >= bada ? "LIVE" : "DEAD");
        System.out.println(goodb >= badb ? "LIVE" : "DEAD");

    }
}