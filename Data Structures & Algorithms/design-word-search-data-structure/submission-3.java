class WordDictionary {
    public class TrieNode{
        TrieNode[] children;
        boolean isWordEnd;
        public TrieNode(){
            children=new TrieNode[26];
            isWordEnd=false;
        }
    }
    public TrieNode Trie;
    public WordDictionary() {
        Trie=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr=Trie;
        for(char c:word.toCharArray())
        {
            if(curr.children[c-'a']==null) curr.children[c-'a']=new TrieNode();
            curr=curr.children[c-'a'];
        }
        curr.isWordEnd=true;
    }

    public boolean search(String word) {
        TrieNode curr=Trie;
        return searchHelper(word,0,curr);
    }
    public boolean searchHelper(String word,int index,TrieNode curr)
    {
        if(index==word.length()) return curr.isWordEnd;
        char c=word.charAt(index);
        if(c=='.')
        {
            for(int i=0;i<26;i++)
            {
                if(curr.children[i] != null) if(searchHelper(word,index+1,curr.children[i])==true) return true;
            }
            return false;
        }
        else{
            if(curr.children[c-'a']==null) return false;
            return searchHelper(word,index+1,curr.children[c-'a']);
        }
    }
}
