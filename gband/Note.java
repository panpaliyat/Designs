package gband;

public class Note {
	
	private double frequency;
	private double amplitude;
	private double duration;
	
	public Note(double frequency, double amplitude, double duration) {
		this.frequency = frequency;
		this.amplitude = amplitude;
		this.duration = duration;
	}
	
	public double getFrequency() {
		return frequency;
	}
	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}
	public double getAmplitude() {
		return amplitude;
	}
	public void setAmplitude(double amplitude) {
		this.amplitude = amplitude;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
}
