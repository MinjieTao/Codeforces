import java.util.*;
import java.io.*;
public class j {
public static void main(String[] args) throws Exception
{
    Scanner input = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    out.println(input.nextInt()+2*input.nextInt()+4*input.nextInt()-7+input.nextInt()+2*input.nextInt()+4*input.nextInt()==0 ? "NO":"YES");
        
    out.close();
}
}