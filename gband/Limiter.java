package gband;

import pipes.Transformer;

// Limiter decrease the amplitude of notes above a given amplitude threshold.

public class Limiter extends Transformer<Note> {

	private double maxAmplitude;
	
	public Limiter(double amplitude) {
		this.maxAmplitude = amplitude;
	}
	
	public Limiter() {
		this(100);
	}
	
	@Override
	public Note transform(Note content) {
		if(content.getAmplitude() > maxAmplitude) {
			content.setAmplitude(maxAmplitude);
		}
		return content;
	}
}
