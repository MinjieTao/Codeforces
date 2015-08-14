import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int zs = 0, fs = 0;
    for(int i = 0; i<n; i++)
    {
        if(input.nextInt() == 0) zs++;
        else fs++;
    }
    int x = fs-fs%9;
    if(zs == 0)
        System.out.print(-1);
    else
    {
        for(int i = 0; i<x; i++) System.out.print(5);
        for(int i = 0; i<(x == 0 ? 1 : zs); i++) System.out.print(0);
    }
}
}