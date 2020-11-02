package design_add_and_search_words_data_structure_211;

public class Main {
    
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        
        wordDictionary.addWord("a");
        System.out.println(wordDictionary.search(".a")); // false
        System.out.println(wordDictionary.search("a.")); // false
        
        wordDictionary.addWord("ran");
        wordDictionary.addWord("rune");
        wordDictionary.addWord("runner");
        wordDictionary.addWord("runs");
        System.out.println(wordDictionary.search("r.n")); // true
        
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // false
        System.out.println(wordDictionary.search("bad")); // true
        System.out.println(wordDictionary.search(".ad")); // true
        System.out.println(wordDictionary.search("b..")); // true
    }
    
}
