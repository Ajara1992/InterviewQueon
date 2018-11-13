package hackerRank;

public class Anagram {
public static void main(String[] args) {
	boolean check=isAnagram("s-s----der","s-----ders");
	System.out.println(check);
}
//without Arrays.Sort way
public static boolean isAnagram(String word, String anagram) {

    word=word.toLowerCase();
    anagram=anagram.toLowerCase();
    if (word.length() != anagram.length())
        return false;

    for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        int index = anagram.indexOf(c);
        // If index of any character is -1, then two strings are not anagrams
        // If index of character is not equal to -1, then remove the chacter from the String
        
        if (index != -1) {
            anagram = anagram.substring(0, index) + anagram.substring(index + 1, anagram.length());
        } else
            return false;
    }
    // if it empty return true
    return anagram.isEmpty();
}
}
