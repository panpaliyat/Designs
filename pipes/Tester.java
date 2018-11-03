package pipes;

import java.util.Observable;

public abstract class Tester<T> extends Filter<T> {
	
	public abstract boolean test(T content);

	@Override
	public void update(Observable arg0, Object arg1) {
		
		Message<T> msg = input.read();
		if(!msg.isFail() && !msg.isQuit()) {
			if(!test(msg.getContent())) {
				msg.setFail(true);
			}
		}
		output.write(msg);
	}
}
