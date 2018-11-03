package gband;

import pipes.Pipe;

public class GBand {
	
	public static void main(String[] args) {
		
		Pipe<Note> p1 = new Pipe<Note>();
		Pipe<Note> p2 = new Pipe<Note>();
		Pipe<Note> p3 = new Pipe<Note>();
		Pipe<Note> p4 = new Pipe<Note>();
		Pipe<Note> p5 = new Pipe<Note>();
		Pipe<Note> p6 = new Pipe<Note>();
		
		Pipe.demandDriven = true;
		
		DigitalComposer c = new DigitalComposer(); // Generates sequence of less than or equal to 100 notes
		c.setOutput(p1);
		
		DurationFilter df = new DurationFilter(150, 1000); // Removes notes which are shorter than 150 milliseconds or greater than 1000 milliseconds 
		df.setInput(p1);
		df.setOutput(p2);
		
		EQFilter eq = new EQFilter(30, 120, 90); // Set amplitude = 120 for notes having frequency in range (120) 
		eq.setInput(p2);
		eq.setOutput(p3);
		
		Amplifier a = new Amplifier(1.5); // Amplify notes to 1.5 times
		a.setInput(p3);
		a.setOutput(p4);
		
		NoiseFilter nf = new NoiseFilter(); // Removes the noise with default setting
		nf.setInput(p4);
		nf.setOutput(p5);
		
		Limiter l = new Limiter(120); // Reduces amplitude for given note to 120
		l.setInput(p5);
		l.setOutput(p6);
		
		Player p = new Player(); // Consumes the notes and plays them through channel
		p.setInput(p6);
		
		if(Pipe.demandDriven)
			p.start();
		else
			c.start();
	}
}