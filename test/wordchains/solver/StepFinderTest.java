package wordchains.solver;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class StepFinderTest
{
	@InjectMocks
	private StepFinder underTest;
	
	@Mock
	private LetterSubstituter substituter;
	
	@Mock
	private WordVerifier verifier;
	
	private List<String> permutations;
	private String word = "word";
	private String anotherWord = "anotherWord";
	
	private String currentStep = "start";
	private String goal = "goal";
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		permutations = new ArrayList<String>();
		permutations.add(word);
		permutations.add(anotherWord);

		when(substituter.getPermutations(currentStep, goal)).thenReturn(permutations);
	}
	
	@Test
	public void shouldFindNearestStep()
	{
		when(verifier.wordExists(word)).thenReturn(true);
		
		String nextStep = underTest.getNextStep(currentStep, goal);
		
		assertThat(nextStep, is(word));
	}
	
	@Test
	public void shouldOnlyReturnValidWords()
	{
		when(verifier.wordExists(word)).thenReturn(false);
		when(verifier.wordExists(anotherWord)).thenReturn(true);
		
		String nextStep = underTest.getNextStep(currentStep, goal);
		
		assertThat(nextStep, is(anotherWord));
	}
}
