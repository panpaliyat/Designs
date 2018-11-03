package gband;

import pipes.Transformer;

// EQ filter changes the amplitude of notes in a given frequency band.

public class EQFilter extends Transformer<Note> {

	private double minFrequency;
	private double maxFrequency;
	private double amplitude;
	
	public EQFilter(double minFrequency, double maxFrequency, double amplitude) {
		this.minFrequency = minFrequency;
		this.minFrequency =	maxFrequency;	
		this.amplitude = amplitude;
	}
	
	public EQFilter() {
		this(50, 100, 100);
	}
	
	@Override
	public Note transform(Note content) {
		if(content.getFrequency()>= minFrequency && content.getFrequency()<=maxFrequency) {
			content.setAmplitude(amplitude);
		}
		return content;
	}

}
