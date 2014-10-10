package wordchains.solver;

import java.util.ArrayList;
import java.util.List;

public class WordChain
{
	private List<String> steps = new ArrayList<String>();
	
	public WordChain(String start)
    {
		steps.add(start);
    }

	public void print()
    {
		for (String step : steps)
		{
			System.out.println(step);
		}
    }

	public void add(String currentStep)
    {
	    steps.add(currentStep);
    }

}
