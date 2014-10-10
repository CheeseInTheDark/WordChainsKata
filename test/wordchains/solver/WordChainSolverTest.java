package wordchains.solver;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class WordChainSolverTest
{
	
	@InjectMocks
	private WordChainSolver underTest = new WordChainSolver();

	@Mock
	private WordChainBuilder wordChainBuilder;
	
	@Mock
	private WordChain wordChain;
	
	private String start = "start";
	private String end = "end";
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldSolveWordChain()
	{
		when(wordChainBuilder.build(start, end)).thenReturn(wordChain);
		
		underTest.solve(start, end);
		
		verify(wordChain).print();
	}
}
