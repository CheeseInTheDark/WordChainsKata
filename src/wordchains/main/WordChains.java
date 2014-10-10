package wordchains.main;

import wordchains.solver.WordChainSolver;

public class WordChains
{
	public static void main(String[] arguments)
    {
		WordChainSolver solver = new WordChainSolver();
		
		solver.solve(arguments[0], arguments[1]);
    }
}
