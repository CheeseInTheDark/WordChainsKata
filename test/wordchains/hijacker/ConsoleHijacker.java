package wordchains.hijacker;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ConsoleHijacker
{
	private ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
	private PrintStream outStream = new PrintStream(consoleOutput);
	
	private static final PrintStream originalStream = System.out;
	
	public ConsoleHijacker()
	{
		System.setOut(outStream);
	}

	public String getOutput()
	{
		return consoleOutput.toString();
	}
	
	public void resetStream()
	{
		System.setOut(originalStream);
	}
}
