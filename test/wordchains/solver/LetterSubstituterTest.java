package wordchains.solver;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LetterSubstituterTest
{
	private LetterSubstituter underTest;
	
	@Before
	public void setup()
	{
		underTest = new LetterSubstituter();
	}
	
	@Test
	public void shouldSwitchOutAForB()
	{
		List<String> permutations = underTest.getPermutations("a", "b");
		
		assertThat(permutations, contains("b"));
	}
	
	@Test
	public void shouldSwitchOutAForC()
	{
		List<String> permutations = underTest.getPermutations("a", "c");
		
		assertThat(permutations, contains("c"));
	}
	
	@Test
	public void shouldReturnBaAndAb()
	{
		List<String> permutations = underTest.getPermutations("aa", "bb");
		
		assertThat(permutations, contains("ba", "ab"));
	}
	
	@Test
	public void shouldNotReturnCurrentStep()
	{
		List<String> permutations = underTest.getPermutations("aa", "ab");
		
		assertThat(permutations, contains("ab"));
	}
}
