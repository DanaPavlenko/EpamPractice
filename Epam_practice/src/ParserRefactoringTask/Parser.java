package ParserRefactoringTask;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import ParserRefactoringTask.handler.Handler;

public class Parser {
	private Map<Character, Handler> _handlers = new HashMap<>();
	private Handler _defaultHandler;

	public void Add(char controlCharacter, Handler handler) {
		_handlers.put(controlCharacter, handler);
	}

	private void parse(Scanner reader) {
		StringBuilder scope = new StringBuilder();
		Context context = new StringBuilderContext(scope); // create your
															// context here.

		String line = reader.nextLine();
		while (line != null) {
			Handler handler = null;
			if (_handlers.get(line) == null)
				handler = _defaultHandler;

			handler.process(context, line);

			line = reader.nextLine();
		}
	}
}
