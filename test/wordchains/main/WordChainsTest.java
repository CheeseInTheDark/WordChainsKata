package wordchains.main;

import static org.powermock.api.mockito.PowerMockito.whenNew;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import wordchains.solver.WordChainSolver;

@RunWith(PowerMockRunner.class)
@PrepareForTest({WordChains.class, WordChainSolver.class})
public class WordChainsTest
{
	@Mock
	private WordChainSolver solver;
	
	private String start = "start";
	private String end = "end";
	private String[] arguments = {start, end};
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldSolveWordChain() throws Exception
	{
		whenNew(WordChainSolver.class).withNoArguments().thenReturn(solver);
		
		WordChains.main(arguments);
		
		Mockito.verify(solver).solve(start, end);
	}
}
