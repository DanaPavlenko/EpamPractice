package ParserRefactoringTask.handler.commands;

import ParserRefactoringTask.Context;

public class ProcessDirectiveHandler implements CommandHandler {

	@Override
	public void handle(Context context, String commandName, String[] arguments) {

		System.out.println("ProcessDirective " + commandName);

	}

}
