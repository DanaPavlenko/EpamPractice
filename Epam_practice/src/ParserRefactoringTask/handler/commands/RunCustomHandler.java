package ParserRefactoringTask.handler.commands;

import ParserRefactoringTask.Context;

public class RunCustomHandler implements CommandHandler {

	@Override
	public void handle(Context context, String commandName, String[] arguments) {

		System.out.println("RunCustomCommand " + commandName + " " + context.getScope());

	}

}
