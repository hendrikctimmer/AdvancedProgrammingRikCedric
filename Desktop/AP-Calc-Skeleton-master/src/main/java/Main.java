import java.io.IOException;
import java.util.Scanner;
import java.io.PrintStream;

public class Main implements CalculatorInterface {

    Scanner in;
    PrintStream out;
    static final String OPERATOR_TOKENS = "+-*/^";
    static final String PARENTHESES = "()";

    Main() {

        in = new Scanner(System.in);
        out = new PrintStream(System.out);

    }

    boolean tokenIsDouble(String token){
        Scanner tokenScanner = new Scanner(token);
        if (tokenScanner.hasNextDouble()){
            return true;
        } else {
            return false;
        }
    }

    boolean tokenIsOperator(String token){
        Scanner tokenScanner = new Scanner(token);
        if (OPERATOR_TOKENS.contains(tokenScanner.next())){
            return true;
        } else {
            return false;
        }
    }

    boolean tokenIsParenthesis(String token){
        Scanner tokenScanner = new Scanner(token);
        if (PARENTHESES.contains(tokenScanner.next())){
            return true;
        } else {
            return false;
        }
    }

    public TokenList readTokens(String input) {

        Scanner inputScanner = new Scanner(input);
        TokenListImp result = new TokenListImp();


        while (inputScanner.hasNext()){

            TokenImp token = new TokenImp();
            String tokenString = inputScanner.next();
            token.tokenValue = tokenString;
            result.add(token);
            if( tokenIsDouble(tokenString)){
                token.tokenType = 1;
                out.printf("%s ", token.tokenValue);
            } else if (tokenIsOperator(tokenString)){
                token.tokenType = 2;
                out.printf("%s ", token.tokenValue);
            }else if (tokenIsParenthesis(tokenString)){
                token.tokenType = 3;
                out.printf("%s ", token.tokenValue);
            } else {
                out.printf("Error: Invalid Input");
            }
        }
        for (int i = 0; i < result.numberOfTokens; i++)
                {out.printf("%s ", result.tokenList[i].getType());}

        return result;
    }

    public Double rpn(TokenList tokens) {
        // TODO: Implement this
        return null;
    }

    public TokenList shuntingYard(TokenList tokens) {
        // TODO: Implement this
        return null;
    }

    private void start() {
        // Create a scanner on System.in
        while (in.hasNextLine()) {
            readTokens(in.nextLine());
        }

        // While there is input, read line and parse it.
    }

    public static void main(String[] argv) {
        new Main().start();
    }
}
