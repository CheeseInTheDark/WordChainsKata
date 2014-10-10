package wordchains.solver;

import java.util.ArrayList;
import java.util.List;

public class LetterSubstituter
{
	public List<String> getPermutations(String currentStep, String goal)
    {
		List<String> permutations = new ArrayList<String>();
		
		for (int position = 0; position < goal.length(); position++)
		{
			String permutation = substituteOneLetter(currentStep, goal, position);
			if (!permutation.equals(currentStep))
			{
				permutations.add(permutation);
			}
		}
		
	    return permutations;
    }
	
	private String substituteOneLetter(String currentStep, String goal, int position)
	{
		return currentStep.substring(0, position) + goal.charAt(position) +
				currentStep.substring(position + 1, goal.length());
	}
}
