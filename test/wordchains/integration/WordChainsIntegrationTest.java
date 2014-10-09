package wordchains.integration;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import wordchains.main.WordChains;

public class WordChainsIntegrationTest
{
	private final String newLine = System.getProperty("line.separator");
	
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
		
		assertEquals("dog" + newLine, console.getOutput());
	}
	
	@Test
	public void shouldSolveCatToCat()
	{
		String[] arguments = {"cat", "cat"};
		
		WordChains.main(arguments);
		
		assertEquals("cat" + newLine, console.getOutput());
	}
	
	@Test
	public void shouldSolveCatToCot()
	{
		String[] arguments = {"cat", "cot"};
		
		WordChains.main(arguments);
		
		assertEquals("cat" + newLine + "cot" + newLine, console.getOutput());
	}
	
	@Test
	public void shouldSolveCatToCod()
	{
		String[] arguments = {"cat", "cod"};
		
		WordChains.main(arguments);
		
		assertEquals("cat" + newLine + "cot" + newLine + "cod" + newLine, console.getOutput());
	}
}
