package ParserRefactoringTask.handler;

import ParserRefactoringTask.Context;

public class DollarHandler implements Handler {

	@Override
	public void process(Context context, String line) {
		System.out.println("Line " + line + " is added to variables");

	}

}
