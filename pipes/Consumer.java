package pipes;

import java.util.Observable;

public abstract class Consumer<T> extends Filter<T> {

	public abstract void consume(T content);

	@Override
	public void update(Observable o, Object arg) {
		Message<T> msg = input.read();
		if(!msg.isFail() && !msg.isQuit())
			consume(msg.getContent());
	}
	
	public void start() {
		while(true) {
			Message<T> msg = input.read();
			if(msg.isQuit()) {
				//System.out.println("Bye !!");
				break;
			} else if(!msg.isFail())
				consume(msg.getContent());
		}
	}
}
