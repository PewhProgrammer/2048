package ttfe.publictests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import org.junit.Test;

import ttfe.SimulatorInterface;
import ttfe.TTFEFactory;
import ttfe.UserInterface;

public class ConsoleTests {

	private final SimulatorInterface si = TTFEFactory.createSimulator(4, 4,
			new Random(0));

	private ByteArrayOutputStream setUpOutput() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);

		return baos;
	}

	private UserInterface setUpUserInterfaceAndInput(String input) {
		System.setIn(new ByteArrayInputStream(input.getBytes()));

		UserInterface ui = TTFEFactory.createUserInterface(si, false);
		assertNotNull("Console user interface was null", ui);

		return ui;
	}

	@Test(timeout = 100)
	public void testShowGameOver() {
		ByteArrayOutputStream baos = setUpOutput();

		String input = "NONE";
		UserInterface ui = setUpUserInterfaceAndInput(input);

		ui.showGameOverScreen(si);
		String gameOverScreen = baos.toString().trim();

		assertTrue("Console interface has shown the wrong game over screen", gameOverScreen.matches("(?sm).*GAME OVER.*Moves:.*0.*Points:.*0.*"));
	}

	@Test(timeout = 100)
	public void testShowMessage() {
		ByteArrayOutputStream baos = setUpOutput();

		String input = "NONE";
		UserInterface ui = setUpUserInterfaceAndInput(input);

		String message = "This is a sample message";
		ui.showMessage(message);

		String shownMessage = baos.toString().trim();
		assertEquals("Console interface has shown the wrong message", message,
				shownMessage);
	}

	@Test(timeout = 100)
	public void testGetUserInputSimple() {
		String input = "c";
		String expected = "c";
		UserInterface ui = setUpUserInterfaceAndInput(input);

		String[] possibleAnswers = { "a", "b", "c" };
		String answer = ui.getUserInput("Sample question?", possibleAnswers);
		assertNotNull("User answer was null", answer);

		assertEquals("User answer was not the given input", expected, answer);
	}

}
