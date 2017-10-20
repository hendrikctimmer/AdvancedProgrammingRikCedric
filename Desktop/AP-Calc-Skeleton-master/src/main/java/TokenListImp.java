
public class TokenListImp implements TokenList {

	Token[] tokenList;
	int numberOfTokens;
	private int listSize = 1;
	
    public TokenListImp() {
    	tokenList = new Token[listSize];
    	numberOfTokens = 0;
    }

    public void add(Token token) {
        tokenList[numberOfTokens] = token;
        numberOfTokens ++;
        checkListSize();
    }
    
    private void checkListSize() {
    	if (listSize <= numberOfTokens) {
        	listSize *= 2;
        	Token[] tempList = new Token[listSize];
        	for (int i = 0; i < tokenList.length; i++) {
        		tempList[i] = tokenList[i];
        	}
        	tokenList = tempList;
        }
    	else {
    		return;
    	}
    }

    public void remove(int index) {
        if (index < size() && index >= 0) {
        	numberOfTokens --;
        	for (int i = index; i < numberOfTokens; i++) {
        		tokenList[i] = tokenList[i + 1];
        	}
            tokenList[index] = null;
        } else {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    public void set(int index, Token token) {
    	if (index < size())
    		tokenList[index] = token;
    	else
            throw new ArrayIndexOutOfBoundsException(index);      
    }

    public Token get(int index) {
        return tokenList[index];
    }

    public int size() {
        return numberOfTokens;
    }

}
