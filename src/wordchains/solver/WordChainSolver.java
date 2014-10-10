package wordchains.solver;

public class WordChainSolver
{
	private WordChainBuilder wordChainBuilder;

	public void solve(String start, String end)
    {
	    WordChain solution = wordChainBuilder.build(start, end);
	    
	    solution.print();
    }
}
