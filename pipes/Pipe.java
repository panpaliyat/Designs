package pipes;

import java.util.Observable;

public class Pipe<T> extends Observable {

	public static boolean demandDriven;
	private Message<T> data;
	
	public Message<T> getData() {
		return data;
	}

	public void setData(Message<T> data) {
		this.data = data;
	}

	public void write(Message<T> msg) {
		setData(msg);
		if(!Pipe.demandDriven) {
			setChanged();
			notifyObservers();
			clearChanged();
		}
	}
	
	public Message<T> read() {
		if(Pipe.demandDriven) {
			setChanged();
			notifyObservers();
			clearChanged();
		}
		
		return getData();
	}
}
