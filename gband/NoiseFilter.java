package gband;

import pipes.Tester;

// Noise filter removes the note if it is suspiciously different from its predecessor.

public class NoiseFilter extends Tester<Note>{

	private double maxFreqDifference;
	private double maxAmpDifference;
	private double maxDurationDifference;
	
	private static Note lastNote = null;
	
	public NoiseFilter(double maxFreqDifference, double maxAmpDifference, double maxDurationDifference) {
		super();
		this.maxFreqDifference = maxFreqDifference;
		this.maxAmpDifference = maxAmpDifference;
		this.maxDurationDifference = maxDurationDifference;
	}

	public NoiseFilter() {
		this(40, 50, 800);
	}

	@Override
	public boolean test(Note n) {
		if(lastNote == null) {
			lastNote = n;
			return true;
		} else if(similar(lastNote, n)) {
			lastNote = n;
			return true;
		}		
		return false;
	}

	private boolean similar(Note n1, Note n2) {
		if( difference(n1.getAmplitude(),n2.getAmplitude()) > maxAmpDifference ||
			difference(n1.getFrequency(),n2.getFrequency()) > maxFreqDifference ||
			difference(n1.getDuration(),n2.getDuration()) > maxDurationDifference)
			return false;
		return true;
	}
	
	private double difference(double a, double b) {
		return Math.abs(a - b);
	}
}
