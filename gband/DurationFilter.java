package gband;

import pipes.Tester;

// Duration filter removes the notes that are too long or too quiet

public class DurationFilter extends Tester<Note>{

	private double minDuration;
	private double maxDuration;
	
	public DurationFilter(double minDuration, double maxDuration){
		this.minDuration = minDuration;
		this.maxDuration = maxDuration;
	}
	
	public DurationFilter() {
		this(100, 200);
	}
	
	@Override
	public boolean test(Note content) {
		if(content.getDuration() < minDuration || content.getDuration() > maxDuration) { return false; }
		return true;
	}

}
