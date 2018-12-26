package com.puffer.java.design.command.audioplayer;

/**
 * 按键(请求者Invoker)
 * 
 * @author buyi
 * @since 1.0.0
 * @date 2018上午11:39:52
 */
public class Keypad {
	private Command playCommand;
	private Command rewindCommand;
	private Command stopCommand;

	public void setPlayCommand(Command playCommand) {
		this.playCommand = playCommand;
	}

	public void setRewindCommand(Command rewindCommand) {
		this.rewindCommand = rewindCommand;
	}

	public void setStopCommand(Command stopCommand) {
		this.stopCommand = stopCommand;
	}

	/**
	 * 执行播放方法
	 */
	public void play() {
		playCommand.execute();
	}

	/**
	 * 执行倒带方法
	 */
	public void rewind() {
		rewindCommand.execute();
	}

	/**
	 * 执行播放方法
	 */
	public void stop() {
		stopCommand.execute();
	}
}
