import java.util.*;
public class bbb {
public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    
    int n=in.nextInt();
    int a=in.nextInt();
    int b=in.nextInt();
    
    int[] tokens=new int[n];
    long[] ans=new long[n];
    
    for(int i=0;i<n;i++)tokens[i]=in.nextInt();
    
    for(int i=0;i<n;i++){
        long num=(long)a*tokens[i];
        long rem=(num%b)/a;
        ans[i]=rem;
    }
    
    for(long e: ans)System.out.print(e+" ");
}
}