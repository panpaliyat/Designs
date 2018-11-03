package pipes;

public class Message<T> {
	private T content;
	private boolean quit;
	private boolean fail;	
	
	public Message(T content) {
		super();
		this.content = content;
	}
	
	public T getContent() {
		return content;
	}
	
	public void setContent(T content) {
		this.content = content;
	}
	
	public boolean isQuit() {
		return quit;
	}
	
	public void setQuit(boolean quit) {
		this.quit = quit;
	}
	
	public boolean isFail() {
		return fail;
	}
	
	public void setFail(boolean fail) {
		this.fail = fail;
	}
}
