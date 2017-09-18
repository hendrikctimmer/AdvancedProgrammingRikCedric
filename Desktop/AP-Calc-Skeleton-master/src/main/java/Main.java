import java.util.Scanner;
import java.io.PrintStream;

public class Main implements CalculatorInterface {

    Scanner in;
    PrintStream out;
    static final String OPERATOR_TOKENS = "+-*/^";
    
    // Do you work motherfucker? yes! Aight cool

    Main(){

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
        if (tokenScanner.next().equals('(' | ')')){
            return true;
        } else {
            return false;
        }
    }

    public TokenList readTokens(String input) {

        TokenListImp result = new TokenListImp();

        while (in.hasNext()){

            TokenImp token = new TokenImp();
            String tokenString = in.next();
            token.tokenValue = tokenString;
            result.add(token);
            if( tokenIsDouble(tokenString)){
                token.tokenType = 1;
            } else if (tokenIsOperator(tokenString)){
                token.tokenType = 2;
            }else if (tokenIsParenthesis(tokenString)){
                token.tokenType = 3;
            } else {
                out.printf("Error: invalid input");
            }
        }

        return null;
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
        
        // While there is input, read line and parse it.
    }

    public static void main(String[] argv) {
        new Main().start();
    }
}
