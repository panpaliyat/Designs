package gband;

import javax.sound.midi.*;

import pipes.Consumer;

public class Player extends Consumer<Note> {

	private Synthesizer synth;
	private MidiChannel channel;
	
	public Player() {
		try {
			synth = MidiSystem.getSynthesizer();
			synth.open();
			channel = synth.getChannels()[1];	
		} catch (MidiUnavailableException e) {
			System.out.println("MIDI device is not available");
			e.printStackTrace();
		}
	}
	
	@Override
	public void consume(Note content) {
		channel.noteOn((int)content.getFrequency(), (int)content.getAmplitude());
		try {
			Thread.sleep((long)content.getDuration());
		} catch (InterruptedException e) {
			System.out.println("");
			e.printStackTrace();
		}
		channel.noteOff((int)content.getFrequency());
	}
}
