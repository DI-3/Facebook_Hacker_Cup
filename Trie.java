import java.util.*;

class Node{
    char dt_char; 
    boolean isEnd; 
    int count;  
    LinkedList<Node> children; 
    
    public Node(char ch){
    	children = new LinkedList<Node>();
        isEnd = false;
        dt_char = ch;
        count = 0;
    }  
    public Node subNode(char ch){
    	
    	if (children != null)
            for (Node eachChild : children)
                if (eachChild.dt_char == ch)
                    return eachChild;
        return null;
    }
}

class Trie{
	
	public static Node rootNode;
	static int char_count ;
    public Trie()
    {
        rootNode = new Node(' '); 
    }
    public int checkChild(Node R,String s,int ind){
    	
     if(!(ind < s.length())){ char_count--; return 0 ;}
     
     Node child = R.subNode(s.charAt(ind));
     if(child.count > 1) { char_count++;} 	
     else { return 0;}
     
     if (child != null)
           	checkChild(child,s,ind+1);
     return 1; 
   }
    public void insert(String word){
        if (search(word) == true) 
            return;        
        Node curr = rootNode; 
        for (char ch : word.toCharArray() )
        {
            Node child = curr.subNode(ch);
            if (child != null)
            	curr = child;
            else 
            {
            	curr.children.add(new Node(ch));
            	curr = curr.subNode(ch);
            }
            curr.count++;
       }
        curr.isEnd = true;
    }
    public boolean search(String s){
        Node current = rootNode;  
        for (char ch : s.toCharArray())
            if (current.subNode(ch) == null) return false;
            else
                current = current.subNode(ch);
       if (current.isEnd == true) return true;
       
       return false;
    }
    
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int no_inp = in.nextInt();
		int index = 0 ,index1= 0,no_of_words = 0,sum = 0;
		String s = null;
		while(index < no_inp){
			Trie T = new Trie();
			no_of_words = in.nextInt();
			in.nextLine();
			sum = 0 ;
			index1 = 0;
			while(index1 < no_of_words){
				s = in.nextLine();
				T.insert(s);
				T.char_count = 1;
				T.checkChild(T.rootNode, s, 0);
				sum += T.char_count;
				index1++;
			}
			index++;
			System.out.println("Case #"+index+": "+sum);	
		}
	}
  }    

