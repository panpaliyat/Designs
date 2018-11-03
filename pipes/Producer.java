package pipes;

import java.util.Observable;

public abstract class Producer<T> extends Filter<T> {
	
	public abstract T produce();
	
	@Override
	public void update(Observable o, Object arg) {
		T content = produce();
		Message<T> msg = new Message<T>(content);
		if(content == null) {
			msg.setQuit(true);
		}
		output.write(msg);
	}
	
	public void start() {
		while(true) {
			T item = produce();
			Message<T> msg = new Message<T>(item);

			if( item == null )
				msg.setQuit(true);

			output.write(msg);
			
			if( item == null )
				break;
		}
	}
}
