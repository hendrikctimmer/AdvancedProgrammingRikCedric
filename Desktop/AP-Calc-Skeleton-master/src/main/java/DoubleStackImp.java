/**
 * Created by rik on 7-9-17.
 */
public class DoubleStackImp implements DoubleStack {
	
	static final int MAX_NUMBER_OF_ELEMENTS = 1000;
	Double[] stack;
	int numberOfElements;
	
	DoubleStackImp() {
		stack = new Double[MAX_NUMBER_OF_ELEMENTS];
		numberOfElements = 0;
	}

	public void push(Double element) {
		if (numberOfElements >= 1) {			
			for (int i = numberOfElements - 1; i >= 0; i--) {
				stack[i+1] = stack[i];
			}
		}
		stack[0] = element;
		numberOfElements++;
	}

	public Double pop() {
		Double popElement = stack[0];
		numberOfElements -= 1;
		for (int i = 0; i < numberOfElements; i++) {
			stack[i] = stack[i + 1];
		}
		return popElement;
	}

	public Double top() {
		return stack[0];
	}

	public int size() {
		return numberOfElements;
	}
}
