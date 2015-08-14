import java.util.*;
public class j {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
//  while(input.hasNext())
//  {
//      String s = input.nextLine();
//      StringTokenizer str = new StringTokenizer(s);
//      Stack<String> st = new Stack<String>();
//      while(str.hasMoreTokens())
//      {
//          String at = str.nextToken();
//          if(at.charAt(0)=='(')
//              System.out.println(",\""+st.pop()+"\"");
//          else st.push(at);
//      }
//  }
    String[] data = {"Washington"
            ,"Adams"
            ,"Jefferson"
            ,"Madison"
            ,"Monroe"
            ,"Adams"
            ,"Jackson"
            ,"Van Buren"
            ,"Harrison"
            ,"Tyler"
            ,"Polk"
            ,"Taylor"
            ,"Fillmore"
            ,"Pierce"
            ,"Buchanan"
            ,"Lincoln"
            ,"Johnson"
            ,"Grant"
            ,"Hayes"
            ,"Garfield"
            ,"Arthur"
            ,"Cleveland"
            ,"Harrison"
            ,"Cleveland"
            ,"McKinley"
            ,"Roosevelt"
            ,"Taft"
            ,"Wilson"
            ,"Harding"
            ,"Coolidge"
            ,"Hoover"
            ,"Roosevelt"
            ,"Truman"
            ,"Eisenhower"
            ,"Kennedy"
            ,"Johnson"
            ,"Nixon"
            ,"Ford"
            ,"Carter"
            ,"Reagan"
            ,"Bush"
            ,"Clinton"
            ,"Bush"};
    System.out.println(data[input.nextInt()-1]);
}
}