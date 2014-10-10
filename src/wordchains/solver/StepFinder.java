package wordchains.solver;

import java.util.List;

public class StepFinder
{
	private LetterSubstituter substituter = new LetterSubstituter();
	
	private WordVerifier verifier = new WordVerifier();
	
	public String getNextStep(String word, String goal)
    {
		List<String> permutations = substituter.getPermutations(word, goal);
		for (String possibility : permutations)
		{
			if (verifier.wordExists(possibility))
			{
				return possibility;
			}
		}
		
		return null;
    }

}
