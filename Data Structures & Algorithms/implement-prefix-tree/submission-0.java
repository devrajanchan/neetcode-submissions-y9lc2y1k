class PrefixTree {
    public class TreeNode{
        TreeNode[] children;
        boolean isWordEnd;
        public TreeNode(){
            children = new TreeNode[26];
            isWordEnd=false;
        }
    }
    TreeNode Trie;
    public PrefixTree() {
        Trie=new TreeNode();
    }

    public void insert(String word) {
        TreeNode curr= Trie;
        for(char c:word.toCharArray())
        {
            int index=c-'a';
            if(curr.children[index]==null)
            {
                curr.children[index]=new TreeNode();
            }
            curr=curr.children[index];
        }
        curr.isWordEnd = true;
    }

    public boolean search(String word) {
        TreeNode curr= Trie;
        for(char c:word.toCharArray())
        {
            if(curr.children[c-'a']==null) return false;
            curr=curr.children[c-'a'];
        }
        return curr.isWordEnd;
    }

    public boolean startsWith(String prefix) {
        TreeNode curr= Trie;
        for(char c:prefix.toCharArray())
        {
            if(curr.children[c-'a']==null) return false;
            curr=curr.children[c-'a'];
        }
        return true;
    }
}
