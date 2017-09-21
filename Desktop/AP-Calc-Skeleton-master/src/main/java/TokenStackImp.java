/**
 * Created by rik on 7-9-17.
 */
public class TokenStackImp implements TokenStack {
    
	static final int MAX_NUMBER_OF_ELEMENTS = 1024;
	private Token[] stack;
	int numberOfElements;

	public TokenStackImp() {
		stack = new Token[MAX_NUMBER_OF_ELEMENTS];
		numberOfElements = 0;
	}
	
	public void push(Token token) {
		if (numberOfElements >= 1) {			
			for (int i = numberOfElements - 1; i >= 0; i--) {
				stack[i+1] = stack[i];
			}
		}
		stack[0] = token;
		numberOfElements++;
	}

	public Token pop() {
		Token popElement = stack[0];
		numberOfElements -= 1;
		for (int i = 0; i < numberOfElements; i++) {
			stack[i] = stack[i + 1];
		}
		return popElement;
	}

	public Token top() {
		return stack[0];
	}

	public int size() {
		return numberOfElements;
	}
}
