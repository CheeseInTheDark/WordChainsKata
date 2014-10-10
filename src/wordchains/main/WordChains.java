package wordchains.main;

import wordchains.solver.WordChainSolver;

public class WordChains
{
	public static void main(String[] arguments)
    {
		WordChainSolver solver = new WordChainSolver();
		
		solver.solve(arguments[0], arguments[1]);
		
		System.out.println(arguments[0]);
		if (arguments[0] != arguments[1])
		{
			System.out.println(arguments[1]);
		}
    }
}
