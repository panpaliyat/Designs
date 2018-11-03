package gband;

import pipes.Transformer;

// Amplifier increases or decreases the volume of each note by the given amplification factor

public class Amplifier extends Transformer<Note> {
	
	private double amplificationFactor;
	
	public Amplifier(double amplificationFactor) {
		super();
		this.amplificationFactor = amplificationFactor;
	}
	
	public Amplifier() {
		this(1.5);
	}
	
	@Override
	public Note transform(Note content) {
		content.setAmplitude(content.getAmplitude()*amplificationFactor);
		return content;
	}
}
