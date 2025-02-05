import java.util.*;

class TrieNode{
	Map<Character, TrieNode> children;
	boolean endOfString;
	public TrieNode(){
		children = new HashMap<>();
		endOfString = false;
	}
}
