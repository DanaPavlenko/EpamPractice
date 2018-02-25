package ParserRefactoringTask;

public interface Context {

	void add(String line);

	StringBuilder getScope();

}
