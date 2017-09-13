/**
 * Created by rik on 7-9-17.
 */
public class TokenListImp implements TokenList {

    Token previousToken;
    Token currentToken;
    Token nextToken;



    TokenListImp(){



    }

    @Override
    public void add(Token token) {
        currentToken = token;
        

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void set(int index, Token token) {

    }

    @Override
    public Token get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    public void readTokens(){


    }
}
