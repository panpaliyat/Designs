package pipes;

import java.util.Observer;

public abstract class Filter<T> implements Observer {
	
	protected Pipe<T> input,output;
	
	public void setInput(Pipe<T> input) {
		this.input = input;
		if(!Pipe.demandDriven) {
			input.addObserver(this);
		}
	}

	public void setOutput(Pipe<T> output) {
		this.output = output;
		if(Pipe.demandDriven) {
			output.addObserver(this);
		}
	}
}
