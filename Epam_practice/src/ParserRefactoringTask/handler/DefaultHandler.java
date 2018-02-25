package ParserRefactoringTask.handler;

import ParserRefactoringTask.Context;

public class DefaultHandler implements Handler {

	@Override
	public void process(Context context, String line) {
		context.add(line);
	}

}
