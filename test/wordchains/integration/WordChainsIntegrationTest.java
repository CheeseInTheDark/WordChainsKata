package wordchains.integration;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static wordchains.hijacker.NewLine.newLine;
import junit.framework.Assert;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import wordchains.hijacker.ConsoleHijacker;
import wordchains.hijacker.NewLine;
import wordchains.main.WordChains;

public class WordChainsIntegrationTest
{
	private ConsoleHijacker console;
	
	@Before
	public void setup()
	{
		console = new ConsoleHijacker();
	}
	
	@After
	public void teardown()
	{
		console.resetStream();
	}
	
	@Test
	public void shouldSolveDogToDog()
	{
		String[] arguments = {"dog", "dog"};
		
		WordChains.main(arguments);
		
		assertSolutionIs("dog");
	}
	
	@Test
	public void shouldSolveCatToCat()
	{
		String[] arguments = {"cat", "cat"};
		
		WordChains.main(arguments);
		
		assertSolutionIs("cat");
	}
	
	@Test
	public void shouldSolveCatToCot()
	{
		String[] arguments = {"cat", "cot"};
		
		WordChains.main(arguments);
		
		assertSolutionIs("cat", "cot");
	}
	
	@Test
	public void shouldSolveCatToCod()
	{
		String[] arguments = {"cat", "cod"};
		
		WordChains.main(arguments);
		
		assertSolutionIs("cat", "cot", "cod");
	}
	
	@Test
	public void shouldSolveCatToDot()
	{
		String[] arguments = {"cat", "rod"};
		
		WordChains.main(arguments);
		
		assertSolutionIs("cat", "cot", "rot", "rod");
	}
	
	private void assertSolutionIs(String... steps)
	{
		String expectedSolution = asSolution(steps);
		assertThat(console.getOutput(), is(expectedSolution));
	}
	
	private String asSolution(String... steps)
	{
		String solution = new String();
		
		for (String step : steps)
		{
			solution += step + newLine;
		}
		
		return solution;
	}
}
