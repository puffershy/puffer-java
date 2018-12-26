package com.puffer.java.design.command;

public class Invoker {
	private Command command;

	public Invoker(Command command) {
		super();
		this.command = command;
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public void call() {
		command.execute();
	}
}
