import java.util.*;

class TrieNode{
    char content; 
    boolean isEnd; 
    int count;  

    LinkedList<TrieNode> childList; 
    public TrieNode(char c){
        childList = new LinkedList<TrieNode>();
        isEnd = false;
        content = c;
        count = 0;
    }  
    public TrieNode subNode(char c){
    	
    	if (childList != null)
            for (TrieNode eachChild : childList)
                if (eachChild.content == c)
                    return eachChild;
        return null;
    }
}

class Trie{
	public static TrieNode root;
	static int char_count ;
    public Trie()
    {
        root = new TrieNode(' '); 
    }
    public int checkChild(TrieNode R,String s,int ind){
    	
     if(!(ind < s.length())){ char_count--; return 0 ;}
     TrieNode child = R.subNode(s.charAt(ind));
     if(child.count > 1) { char_count++;} 	
     else { return 0;}
     if (child != null){
           	//R = child;
           	checkChild(child,s,ind+1);
     }
     return 1; 
   }
    public void insert(String word)
    {
        if (search(word) == true) 
            return;        
        TrieNode current = root; 
        for (char ch : word.toCharArray() )
        {
            TrieNode child = current.subNode(ch);
            if (child != null)
                current = child;
            else 
            {
                 current.childList.add(new TrieNode(ch));
                 current = current.subNode(ch);
            }
            current.count++;
       }
        current.isEnd = true;
    }
    public boolean search(String word)
    {
        TrieNode current = root;  
        for (char ch : word.toCharArray() )
        {
            if (current.subNode(ch) == null)
                return false;
            else
                current = current.subNode(ch);
        }      
       if (current.isEnd == true) 
            return true;
        return false;
    }
   
}    

public class Tries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		int no_inp = in.nextInt();
		
		int index = 0 ;
		int index1= 0;
		int no_of_words = 0;
		String s = null;
		while(index < no_inp){
			//in.nextLine();
			Trie T = new Trie();
			int sum = 0;
			no_of_words = in.nextInt();
			in.nextLine();
			sum = 0 ;
			index1 = 0;
			while(index1 < no_of_words){
				s = in.nextLine();
				T.insert(s);
				T.char_count = 1;
				T.checkChild(T.root, s, 0);
				sum += T.char_count;
				index1++;
			}
			index++;
			System.out.println("Case #"+index+": "+sum);	
		}
	}

}
