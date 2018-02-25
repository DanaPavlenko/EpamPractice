package ParserRefactoringTask.handler.commands;

import ParserRefactoringTask.Context;

public class ExecuteHandler implements CommandHandler {

	@Override
	public void handle(Context context, String commandName, String[] arguments) {

		System.out.println("ExecuteScope " + context.getScope());

	}

}
