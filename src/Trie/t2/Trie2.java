package Trie.t2;

class Node {
    Node[] node;
    int prefixCount;
    int wordCount;
    Node(){
        node = new Node[26];
    }

    boolean containsKey(char c){
        return node[c-'a']!=null;
    }
    Node getNode(char c){
        return node[c-'a'];
    }
    void put(char c, Node n){
        node[c-'a']=n;
    }
    void setPrefixCount(){
        prefixCount++;
    }
    void setWordCount(){
        wordCount++;
    }
    int getWordCount(){
        return wordCount;
    }
    int getPrefixCount(){
        return prefixCount;
    }
    void eraseChar(){
        prefixCount--;
    }
    void eraseWord(){
        wordCount--;
    }

}
public class Trie2 {
    Node root;
    public Trie2() {
        root = new Node();
    }

    public void insert(String word) {
        Node temp = root;
        for(int i=0;i<word.length();i++){
            char c= word.charAt(i);
            if(!temp.containsKey(c)){
                temp.put(c,new Node());
            }
            temp = temp.getNode(c);
            temp.setPrefixCount();
        }
        temp.setWordCount();
    }

    public int countWordsEqualTo(String word) {
        Node temp = root;
        for(int i=0;i<word.length();i++){
            char c= word.charAt(i);
            if(temp.containsKey(c)){
                temp = temp.getNode(c);
            } else{
                return 0;
            }
        }
        return temp.getWordCount();
    }

    public int countWordsStartingWith(String word) {
        Node temp = root;
        for(int i=0;i<word.length();i++){
            char c= word.charAt(i);
            if(temp.containsKey(c)){
                temp = temp.getNode(c);
            } else{
                return 0;
            }

        }
        return temp.getPrefixCount();
    }

    public void erase(String word) {
        Node temp = root;
        for(int i=0;i<word.length();i++){
            char c= word.charAt(i);
            if(temp.containsKey(c)){
                temp = temp.getNode(c);
                temp.eraseChar();
            } else{
                return;
            }
        }
        temp.eraseWord();
    }

}

