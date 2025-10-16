package Trie;

class Node{
    Node[] node;
    boolean flag;
    Node(){
        node = new Node[26];
        flag = false;
    }
    boolean containsKey(char c){
        return node[c-'a']!=null;
    }
    Node getNode(char c){
        return node[c-'a'];
    }
    void put(char c, Node n){
        node[c-'a'] = n;
    }
    void setEnd(){
        flag =true;
    }
    boolean isEnd(){
        return flag;
    }

}
class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node temp = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!temp.containsKey(c)){
                temp.put(c,new Node());
            }
            temp = temp.getNode(c); //move to referenced node
        }
        temp.setEnd();
    }

    public boolean search(String word) {
        Node temp = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!temp.containsKey(c)){
                return false;
            }
            temp = temp.getNode(c);
        }
        if(temp.isEnd()){
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        Node temp = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(!temp.containsKey(c)){
                return false;
            }
            temp = temp.getNode(c);
        }
        return true;
    }
}
