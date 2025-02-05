class Trie{
	private TrieNode root;

	public Trie(){
		root = new TrieNode();
		System.err.println("DEBUG : Created Trie");
	}
	public void insertString(String st){
		TrieNode trav = this.root;
		char c = ' ' ;
		for(int i =0; i<st.length(); i++){
			c = st.charAt(i);
			if(trav.children.containsKey(c)){
				trav = trav.children.get(c);
				continue; 
			}
			else{
				trav.children.put(c, new TrieNode());
				trav = trav.children.get(c);
			}
		}
		if(trav.endOfString){
			System.out.println("DEBUG : already contains the string -> "+st);
		}
		else{
			trav.endOfString = true;
			System.out.println("DEBUG : Successfully inserted -> "+st);
		}
	}
}
class MainClass{
	public static void main(String ...args){
		Trie trie = new Trie(); 
		trie.insertString("preetam");
		trie.insertString("preetam");
		trie.insertString("preetam singh");
	}
}