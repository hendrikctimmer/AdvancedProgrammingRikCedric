/**
 * Created by rik on 7-9-17.
 */
public class TokenListImp implements TokenList {

   Token[] tokenList;
   int numberOfTokens;
   Token currentToken;


    TokenListImp(){

    numberOfTokens = 0;
    tokenList = new Token[1024];

    }

    @Override
    public void add(Token token) {


        tokenList[numberOfTokens] = token;
        numberOfTokens ++;
        

    }

    @Override
    public void remove(int index) {

        if (index >= 0) {
            tokenList[index] = null;
        } else {
            throw new ArrayIndexOutOfBoundsException(index);
        }

    }

    @Override
    public void set(int index, Token token) {

        tokenList[index] = token;

    }

    @Override
    public Token get(int index) {

        return tokenList[index];
    }

    @Override
    public int size() {
        return numberOfTokens;
    }

}
