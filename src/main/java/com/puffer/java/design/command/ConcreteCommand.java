package com.puffer.java.design.command;

/**
 * 具体命令角色类
 * 
 * @author buyi
 * @since 1.0.0
 * @date 2018下午4:02:31
 */
public class ConcreteCommand implements Command {
	private Receiver receiver;

	public ConcreteCommand(Receiver receiver) {
		super();
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.action();
	}

}
