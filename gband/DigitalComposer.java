package gband;

import java.util.Random;
import pipes.Producer;

// Digital Composer generates a random sequence of <= 100 notes.

public class DigitalComposer extends Producer<Note> {

	private int totalNotes;
	
	public DigitalComposer() {
		this.totalNotes = 1 + new Random().nextInt(100);
	}
	
	@Override
	public Note produce() {
		
		if(totalNotes!=0) {
			
			Random rand = new Random();
			
			double frequency = 1 + rand.nextDouble() * 150;
			double amplitude = 1 + rand.nextDouble() * 150;
			double duration = 1 + rand.nextDouble() * 1000;
			
			totalNotes--;

			return new Note(frequency, amplitude, duration);
		} else
			return null;
	}
}
