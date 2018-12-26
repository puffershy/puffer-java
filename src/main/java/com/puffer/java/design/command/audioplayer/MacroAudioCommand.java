package com.puffer.java.design.command.audioplayer;

import java.util.LinkedList;
import java.util.List;

public class MacroAudioCommand implements MacroCommand {
	public List<Command> conmands = new LinkedList<>();

	@Override
	public void execute() {
		for (Command command : conmands) {
			command.execute();
		}
	}

	@Override
	public void add(Command command) {
		conmands.add(command);
	}

	@Override
	public void remove(Command command) {
		conmands.remove(command);
	}

}
