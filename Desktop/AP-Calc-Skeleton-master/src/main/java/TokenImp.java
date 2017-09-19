
public class TokenImp implements Token {

	String value;
	int type;
	int precedence;
	
	public TokenImp() {
		value = null;
		type = 0;
		precedence = 0;
	}
    
    public TokenImp(String value, int type, int precedence) {
		this.value = value;
		this.type = type;
		this.precedence = precedence;
	}

    public String getValue() {
        return value;
    }

    public int getType() { 
    	return type; 
    }

    public int getPrecedence() {
        return precedence;
    }
}
