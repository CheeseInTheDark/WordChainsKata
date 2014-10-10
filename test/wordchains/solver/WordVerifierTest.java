package wordchains.solver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class WordVerifierTest
{
	private WordVerifier underTest;
	
	@Before
	public void setup()
	{
		underTest = new WordVerifier();
	}
	
	@Test
	public void shouldRejectNonWord()
	{
		assertFalse(underTest.wordExists("falaflj"));
	}
	
	@Test
	public void shouldVerifyCat()
	{
		assertTrue(underTest.wordExists("cat"));
	}
	
	@Test
	public void shouldVerifyCot()
	{
		assertTrue(underTest.wordExists("cot"));
	}
	
	@Test
	public void shouldVerifyCod()
	{
		assertTrue(underTest.wordExists("cod"));
	}
	
	@Test
	public void shouldVerifyDog()
	{
		assertTrue(underTest.wordExists("dog"));
	}
}
