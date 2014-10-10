package wordchains.solver;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({WordChainBuilder.class, WordChain.class})
public class WordChainBuilderTest
{
	@InjectMocks
	private WordChainBuilder underTest;
	
	@Mock
	private StepFinder stepFinder;

	@Mock
	private WordChain expectedWordChain;
	
	private String stepOne = "step1";
	private String stepTwo = "step2";
	private String stepThree = "step3";
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldAddStepsUntilChainIsSolved() throws Exception
	{
		when(stepFinder.getNextStep(stepOne, stepThree)).thenReturn(stepTwo);
		when(stepFinder.getNextStep(stepTwo, stepThree)).thenReturn(stepThree);
		whenNew(WordChain.class).withArguments(stepOne).thenReturn(expectedWordChain);
		
		WordChain wordChain = underTest.build(stepOne, stepThree);
		
		verify(wordChain).add(stepTwo);
		verify(wordChain).add(stepThree);
	}
}
