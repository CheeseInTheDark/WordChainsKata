package wordchains.solver;

public class WordChainBuilder
{
	private StepFinder stepFinder;
	
	public WordChain build(String start, String end)
    {
		String currentStep = start;
		WordChain solution = new WordChain(start);
		
		while(currentStep != end)
		{
			currentStep = stepFinder.getNextStep(currentStep, end);
			solution.add(currentStep);
		}
		
		return solution;
    }

}
