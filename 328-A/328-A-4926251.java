import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int[] data = new int[4];
    for(int i = 0; i<4; i++) data[i] = input.nextInt();
    if(data[1] - data[0] == data[2] - data[1] && data[1] - data[0] == data[3] - data[2])
    {
        System.out.println(2*data[3] - data[2]);
    }
    else
    {
        int a = data[0], b = data[1], c = data[2], d = data[3];
        if(a!= 0 && b*b == a*c && c*c == b*d && c!= 0 && d*d%c == 0) System.out.println(d*d/c);
        else System.out.println(42);
    }
}
}