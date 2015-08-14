import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    Node head = new Node("", null);
    Node cur = head;
    for(int i = 0; i<n; i++)
    {
        String s = input.next();
        if(s.equals("cd"))
        {
            String loc = input.next();
            if(loc.indexOf('/') == -1)
            {
                if(loc.equals(".."))
                {
                    cur = cur.parent;
                }
                else
                {
                    find(loc, cur);
                    if(found != null)
                        cur = found;
                    else
                    {
                        Node newNode = new Node(loc, cur);
                        cur.children.add(newNode);
                        cur = newNode;
                    }
                }
                continue;
            }
            if(loc.indexOf('/') == 0)
            {
                cur = head;
                loc = loc.substring(1);
            }
            StringTokenizer st = new StringTokenizer(loc, "/");
            while(st.hasMoreTokens())
            {
                String at = st.nextToken();
                if(at.equals(".."))
                    cur = cur.parent;
                else
                {
                    find(at, cur);
                    if(found != null)
                        cur = found;
                    else
                    {
                        Node newNode = new Node(at, cur);
                        cur.children.add(newNode);
                        cur = newNode;
                    }
                }
            }
        }
        else
        {
            System.out.println(pwd(cur) + '/');
        }
    }
}
public static Node found;
public static void find(String s, Node at)
{
    if(at == null)
        return;
    found = null;
    for(Node n: at.children)
    {
        if(n.name.equals(s))
        {
            found = n;
            return;
        }
    }
    
}
public static String pwd(Node n)
{
    if(n.parent == null)
        return "";
    if(n.parent.parent == null)
        return "/" + n.name;
    return pwd(n.parent) + "/" + n.name;
}
public static class Node
{
    String name;
    Node parent;
    ArrayList<Node> children;
    public Node(String s, Node p)
    {
        name = s;
        parent = p;
        children = new ArrayList<Node>();
    }
}
}