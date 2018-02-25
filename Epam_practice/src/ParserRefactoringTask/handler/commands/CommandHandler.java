package ParserRefactoringTask.handler.commands;

import ParserRefactoringTask.Context;

public interface CommandHandler {

	void handle(Context context, String commandName, String[] arguments);

}
