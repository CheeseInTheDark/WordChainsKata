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
	}
	
	public boolean wordExists(String word)
    {
	    return words.contains(word);
    }
}
