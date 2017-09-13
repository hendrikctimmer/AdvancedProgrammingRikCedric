

public class TokenImp implements Token {

    final int   NUMBER_TYPE = 1,
                OPERATOR_TYPE = 2,
                PARENTHESIS_TYPE = 3;

    String tokenValue;
    int tokenType;
    int tokenPrecedence;

    TokenImp(){}

    public String getValue() {
        return tokenValue;
    }

    public int getType() { return tokenType; }

    public int getPrecedence() {
        return tokenPrecedence;
    }
}
