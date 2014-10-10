package wordchains.solver;

import java.util.ArrayList;
import java.util.List;

public class WordVerifier
{
	List<String> words = new ArrayList<String>();
	
	public WordVerifier()
	{
		words.add("cat");
		words.add("cot");
		words.add("cod");
		words.add("dog");
		words.add("rod");
		words.add("rot");
	}
	
	public boolean wordExists(String word)
    {
	    return words.contains(word);
    }
}
