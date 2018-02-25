package ParserRefactoringTask;

public class StringBuilderContext implements Context {

	private StringBuilder scope;

	public StringBuilderContext() {
	}

	public StringBuilderContext(StringBuilder scope) {
		this.scope = scope;
	}

	@Override
	public void add(String line) {
		scope.append(line);

	}

	@Override
	public StringBuilder getScope() {
		return scope;
	}

}
