package ParserRefactoringTask.handler;

import java.util.HashMap;
import java.util.Map;

import ParserRefactoringTask.Context;
import ParserRefactoringTask.StringBuilderContext;
import ParserRefactoringTask.handler.commands.CommandHandler;

public class ExclamationMarkHandler implements Handler {

	private Map<String, CommandHandler> commands = new HashMap<>();
	private CommandHandler handler = null;

	public void addCommand(String commandName, CommandHandler handler) {
		commands.put(commandName, handler);
	}

	@Override
	public void process(Context context, String line) {

		context = new StringBuilderContext();

		String arguments[] = line.split(" ", 2);

		String command = arguments[0];

		String args[] = arguments[1].split(" ");

		handler = commands.get(arguments[0]);
		handler.handle(context, command, args);

	}

}
