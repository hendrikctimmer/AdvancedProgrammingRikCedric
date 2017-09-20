import java.io.IOException;
import java.util.Scanner;
import java.io.PrintStream;

public class Main implements CalculatorInterface {

    Scanner in;
    PrintStream out;
    
    static final String OPERATOR_TOKENS = "+-*/^";

    Main() {

        in = new Scanner(System.in);
        out = new PrintStream(System.out);

    }

    boolean tokenIsDouble(String token) {
        return new Scanner(token).hasNextDouble();       
    }

    boolean tokenIsOperator(String token) {
        return OPERATOR_TOKENS.contains(token);
    }

    boolean tokenIsParenthesis(String token) {
    	return token.equals("(") || token.equals(")");
    }

    public TokenList readTokens(String input) {

        Scanner in = new Scanner(input);
        TokenList result = new TokenListImp();

        while (in.hasNext()){

        	String token = in.next();
    		
    		if (tokenIsDouble(token)) {
    			result.add(parseNumber(token));
    		} else if (tokenIsOperator(token)) {
    			result.add(parseOperator(token));
    		} else if (tokenIsParenthesis(token)) {
    			result.add(parseParenthesis(token));
    		} else {
    			out.println("Error in identifying token.");
    		}
        }
        for (int i = 0; i < result.size(); i++)
                out.printf("%s ", result.get(i).getValue());
        out.println();
        
        return result;
    }
    
    public Token parseNumber(String token) {
    	return  new TokenImp(token, 1, -1);
    }
    
    public Token parseOperator(String token) {
    	int precedence = 0;
    	
    	if (token.charAt(0) == OPERATOR_TOKENS.charAt(0) || token.charAt(0) == OPERATOR_TOKENS.charAt(1)) {
    		precedence = 1;
    	}
    	else if (token.charAt(0) == OPERATOR_TOKENS.charAt(2) || token.charAt(0) == OPERATOR_TOKENS.charAt(3)) {
    		precedence = 2;
    	}
    	else if (token.charAt(0) == OPERATOR_TOKENS.charAt(4)) {
    		precedence = 3;
    	}
    	return  new TokenImp(token, 2, precedence);   		
    }
    
    public Token parseParenthesis(String token) {
    	return  new TokenImp(token, 3, 4);
    } 

    public Double rpn(TokenList tokens) {
    	DoubleStack stack = new DoubleStackImp();
    	Double result = null;
    	
        for (int i = 0; i < tokens.size(); i++) {
        	if (tokens.get(i).getType() == 1) {
        		stack.push(Double.parseDouble(tokens.get(i).getValue()));
        	}
        	else if (tokens.get(i).getType() == 2) {
        		performOperation(tokens.get(i), stack);
        	}
        }
        if (stack.size() == 1) {
        	result = stack.pop();
        }
        else {
        	out.print(stack.top());
        	out.println("Error in rpn.");
        }
        
        out.printf("%s ", result);
        
        return result;
    }
    
    private void performOperation(Token operator, DoubleStack stack) {
    	double a = stack.pop();
    	double b = stack.pop();
    	
    	if (operator.getValue().equals("+")) {
    		stack.push(b + a);
    	}
    	else if (operator.getValue().equals("-")) {
    		stack.push(b - a);
    	}
    	else if (operator.getValue().equals("*")) {
    		stack.push(b * a);
    	}
    	else if (operator.getValue().equals("/")) {
    		stack.push(b / a);
    	}
    	else if (operator.getValue().equals("^")) {
    		stack.push(power(a,b));
    	}
    }
    
    private double power(double a, double b) {
    	double result = 1;
    	
    	for (int i = 0; i < a; i++){
    		result *= b;
    	}
    	return result;
    }

    public TokenList shuntingYard(TokenList tokens) {
    	TokenStack stack = new TokenStackImp();
    	TokenList result = new TokenListImp();
    	for (int i = 0; i < tokens.size(); i++) {
    		if (tokens.get(i).getType() == 1) {
    			result.add(tokens.get(i));
    		}
    		else if(tokens.get(i).getType() == 2) {
    			while (stack.size() != 0 && stack.top().getPrecedence() >= tokens.get(i).getPrecedence()) {
    				result.add(stack.pop());
    			}
    			stack.push(tokens.get(i));
    		}
    		if (tokens.get(i).getType() == 3 && tokens.get(i).getValue().equals("(")) {
    			stack.push(tokens.get(i));
    		}
    		if (tokens.get(i).getType() == 3 && tokens.get(i).getValue().equals(")")) {
    			while (stack.top().getValue() != "(") {
    				result.add(stack.pop());
    			}
    			stack.pop();
    		}
    	}
    	while (stack.size() != 0) {
    		result.add(stack.pop());
    	}
        return result;
    }

    private void start() {
        /*while (in.hasNextLine()) {
            readTokens(in.nextLine());
        }*/
    	String test = "15 7 1 1 + - / 3 * 2 1 1 + + -";
    	rpn(readTokens(test));
    }

    public static void main(String[] argv) {
        new Main().start();
    }
}
