package whisker.message;


/**
 * Message builder for ResponseEntity<Message>. Returns formatted message converted to json via @ResponseBody.
 *
 */
public class Message {
	public static enum Type {
        ERROR, WARNING, INFO, SUCCESS;
	}
	
	private String text;
	private final Type type;
	private final Object result;
	
	/**
	 * Construct message without result object;
	 * @param type Type
	 * @param text String
	 * @return Message 
	 */
	public Message(Type type, String text){
		this.type = type;
		this.text = text;
		this.result = null;
	}
	
	/**
     * Construct message with result object;
     * @param type Type
     * @param text String
     * @param result Object
     * @return Message 
     */
	public Message(Type type, String text, Object result){
		this.type = type;
		this.text = text;
		this.result = result;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Type getType() {
		return type;
	}

	public Object getResult() {
		return result;
	}
	
}
