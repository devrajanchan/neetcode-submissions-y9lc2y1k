class TrieNode{
    TrieNode[] children;
    boolean isWordEnd;
    public TrieNode(){
        children=new TrieNode[26];
        isWordEnd=false;
    }
    public void addWord(String word){
        TrieNode curr=this;
        for(char c : word.toCharArray())
        {
            if(curr.children[c-'a']==null) curr.children[c-'a']= new TrieNode();
            curr=curr.children[c-'a'];
        }
        curr.isWordEnd=true;
    }
}
class Solution {
    private Set<String> res = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String word:words)
        {
            root.addWord(word);
        }
        int rows= board.length;
        int cols=board[0].length;

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++)
            {
                dfs(board,r,c,root,"");
            }
        }
        return new ArrayList<>(res);
    }
    private void dfs(char[][] board,int r,int c,TrieNode node ,String word)
    {
        int rows = board.length;
        int cols = board[0].length;
        if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] == '*') return;
        char ch = board[r][c];
        int idx = ch - 'a';
        if (node.children[idx] == null) return;
        node = node.children[idx];
        word += ch;
        if(node.isWordEnd) res.add(word);
        board[r][c] = '*';
        dfs(board, r + 1, c, node, word); // Down
        dfs(board, r - 1, c, node, word); // Up
        dfs(board, r, c + 1, node, word); // Right
        dfs(board, r, c - 1, node, word); // Left
        board[r][c] = ch;
    }
}
