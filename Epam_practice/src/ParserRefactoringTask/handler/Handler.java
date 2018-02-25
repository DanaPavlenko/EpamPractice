package ParserRefactoringTask.handler;

import ParserRefactoringTask.Context;

public interface Handler {

	void process(Context context, String line);

}
