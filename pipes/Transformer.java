package pipes;

import java.util.Observable;

public abstract class Transformer<T> extends Filter<T> {
	
	public abstract T transform(T content);

	@Override
	public void update(Observable o, Object arg) {
		Message<T> msg = input.read();
		
		if(!msg.isFail() && !msg.isQuit()) {
			msg.setContent(transform(msg.getContent()));
		}
		output.write(msg);
	}
}
