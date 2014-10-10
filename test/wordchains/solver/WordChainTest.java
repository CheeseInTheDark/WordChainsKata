package wordchains.solver;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static wordchains.hijacker.NewLine.newLine;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import wordchains.hijacker.ConsoleHijacker;
import wordchains.hijacker.NewLine;

public class WordChainTest
{
	private WordChain underTest;
	
	private String firstStep = "First Step";
	private String secondStep = "Second Step";
	
	private ConsoleHijacker console;
	
	@Before
	public void setup()
	{
		console = new ConsoleHijacker();
		underTest = new WordChain(firstStep);
	}
	
	@After
	public void teardown()
	{
		console.resetStream();
	}
	
	@Test
	public void shouldAddFirstStep()
	{
		underTest.print();
		
		assertThat(console.getOutput(), is(firstStep + newLine));
	}
	
	@Test
	public void shouldAddSteps()
	{
		underTest.add(secondStep);
		
		underTest.print();
		
		assertThat(console.getOutput(), is(firstStep + newLine + secondStep + newLine));
	}
}
