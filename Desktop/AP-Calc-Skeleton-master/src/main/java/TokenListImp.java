/**
 * Created by rik on 7-9-17.
 */
public class TokenListImp implements TokenList {
	
	static final int MAX_NUMBER_OF_TOKENS = 1024;

	Token[] tokenList;
	int numberOfTokens;
	
	Token currentToken;


    public TokenListImp() {
    	tokenList = new Token[MAX_NUMBER_OF_TOKENS];
    	numberOfTokens = 0;
    }

    public void add(Token token) {
        tokenList[numberOfTokens] = token;
        numberOfTokens ++;
    }

    public void remove(int index) {
        if (index >= 0) {
            tokenList[index] = null;
        } else {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    public void set(int index, Token token) {
        tokenList[index] = token;
    }

    public Token get(int index) {

        return tokenList[index];
    }

    public int size() {
        return numberOfTokens;
    }

}
