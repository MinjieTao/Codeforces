import java.util.*;
public class b {
public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i = 0; i<n; i++)
    {
        data[i] = input.nextInt();
        map.put(data[i], i);
    }
    int m = input.nextInt();
    long a = 0, b = 0;
    for(int i = 0; i<m; i++)
    {
        int q = input.nextInt();
        int index = map.get(q);
        a += index+1;
        b += n - index;
    }
    System.out.println(a + " " + b);
}
}