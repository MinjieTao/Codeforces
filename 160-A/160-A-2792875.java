import java.util.Scanner;
public class CoinCounting {
   public static void main(String[] args){
       Scanner input= new Scanner(System.in);
       int n=input.nextInt();
       int[] a=new int[n];
       int swap;
       int sum=0;
       int remaining=0;
       int num=0;
       for (int counter=0;counter<=n-1;counter++){
           a[counter]=input.nextInt();
       }
       for (int c=0; c<=n-1;c++){
           remaining=remaining+a[c];
       }
       for(int j=1;j<=n;j++){
           for (int i=0;i<=n-2;i++){
               if(a[i]>a[i+1]){
                   swap=a[i+1];
                   a[i+1]=a[i];
                   a[i]=swap;
               }
           }
       }
       //for (int element: a){
           //System.out.println(" "+element);}
       
       for (int k=n-1; k>=0; k--){
           sum=a[k]+sum;
           remaining=remaining-a[k];
           if(sum>remaining){
               num=n-k;
               break;
           }
           
       }
       System.out.println(num);
   }
}