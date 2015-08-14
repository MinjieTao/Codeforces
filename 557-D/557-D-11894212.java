import java.util.*;
import java.io.*;
public class d {
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  int n =input.nextInt(), m = input.nextInt();
  
  // Initialize the adjacency list to no edges
  ArrayList<Integer>[] g = new ArrayList[n];
  for(int i = 0; i<n; i++) g[i] = new ArrayList<Integer>();
  
  // Take in edges from input
  for(int i = 0; i<m; i++)
  {
    // Subtract 1 because in the problem nodes are 1-indexed
    int a = input.nextInt()-1;
    int b = input.nextInt()-1;
    // Add the edge going in both directions because it is undirected.
    g[a].add(b);
    g[b].add(a);
  }
  
  // Check if g has no odd cycles.  This is the same as checking if it is 2-colorable
  // http://math.stackexchange.com/questions/1143649/graph-with-cycle-and-two-colorable
  // We will use a breadth-first search technique to see if it is 2-colorable.
  // Info on it here: http://www.cs.cmu.edu/afs/cs/academic/class/15451-s10/www/recitations/rec0318.txt
  int[] color = new int[n];
  Arrays.fill(color, -1); // -1 means unassigned
  
  // In addition, we want to count the number of ways (if any) to add an odd cycle by adding a single edge.
  // This is done by putting an edge between any 2 nodes in the same connected component of the same color.
  // So for each component, we will keep track of how many of each color there are.
  // Then it's the number of zeroes choose 2 + the number of ones choose 2.
  long ways = 0;
  boolean twocolor = true;
  for(int i = 0; i<n; i++)
  {
    // If this node is already colored, we have already checked this component so skip it.
    if(color[i] != -1) continue;
    color[i] = 0; // The color of the first node is arbitrary - we can change it and maintain 2-coloring by switching all colors.
    Queue<Integer> q = new LinkedList<Integer>(); // Nodes to process.
    q.add(i);
    // The algorithm works as follows - start at node i and give it color 0.
    // Then, color all its neighbors color 1 and add them to a queue.
    // When anything gets removed from the queue, color all of its uncolored neighbors the opposite color.
    // Then add all the neighbors to the queue.
    // If we ever try to color the same node both colors, that means there was a contradiction and it was impossible.
    // If we finish processing everything, then this connected component is fine.
    // We then proceed to process all connected components independently.
    long zeroes = 0, ones = 0;
    while(!q.isEmpty())
    {
      int at = q.poll();
      if(color[at] == 0) zeroes++;
      else ones++;
      for(int e : g[at])
      {
        // Looping over all the neighbors of the node we are at.
        if(color[e] == -1)
        {
          color[e] = 1 - color[at];
          q.add(e);
        }
        else if(color[e] == color[at])
        {
          // Contradiction
          twocolor = false;
          break;
        }
      }
    }
    ways += zeroes * (zeroes - 1) / 2;
    ways += ones * (ones - 1) / 2;
  }
  if(!twocolor)
  {
    // There is an odd cycle already - don't add anything.
    out.println("0 1");
  }
  else if(m == 0)
  {
    // There are no edges - so pick any three nodes and connect them in a triangle.
    // There are n choose 3 ways to pick them.
    out.println("3 " + (long)n * (n-1) * (n-2) / 6);
  }
  else
  {
    if(ways > 0) out.println(1+" "+ways);
    else
    {
      // We need two edge.  We can take any of the m existing edges and 
      // connect both nodes on that edge to any of the n-2 other nodes to form a triangle.
      out.println("2 " + (long)(n-2) * m);
    }
  }
  out.close();
}
public static class input {
  static BufferedReader reader;
  static StringTokenizer tokenizer;
  static void init(InputStream input) {
      reader = new BufferedReader(
                   new InputStreamReader(input) );
      tokenizer = new StringTokenizer("");
  }
  static String next() throws IOException {
      while ( ! tokenizer.hasMoreTokens() ) {
          tokenizer = new StringTokenizer(
                 reader.readLine() );
      }
      return tokenizer.nextToken();
  }
  static int nextInt() throws IOException {
      return Integer.parseInt( next() );
  }
}
}