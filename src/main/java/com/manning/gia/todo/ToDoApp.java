package com.manning.gia.todo;

import com.manning.gia.todo.utils.CommandLineInput;
import com.manning.gia.todo.utils.CommandLineInputHandler;

public class ToDoApp {
	private static final char DEFAULT_INPUT = 'a';

	public static void main(String[] args) {
		CommandLineInputHandler commandLineInputHandler = new CommandLineInputHandler();
		char command = DEFAULT_INPUT;
		
		while(true) {
			commandLineInputHandler.printOptions();
			String input = commandLineInputHandler.readInput();
			char[] inputChars = input.length()==1 ? input.toCharArray():new char[] {DEFAULT_INPUT};
			command = inputChars[0];
			CommandLineInput commandLineInput = CommandLineInput.getCommandLineInputForInput(command);
			commandLineInputHandler.processInput(commandLineInput);
			System.out.println("---------------------------------");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}