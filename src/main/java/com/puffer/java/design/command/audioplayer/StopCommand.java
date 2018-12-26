package com.puffer.java.design.command.audioplayer;

/**
 * 停止（具体命令）
 * 
 * @author buyi
 * @since 1.0.0
 * @date 2018上午11:40:48
 */
public class StopCommand implements Command {
	private AudioPlayer audioPlayer;

	public StopCommand(AudioPlayer audioPlayer) {
		super();
		this.audioPlayer = audioPlayer;
	}

	@Override
	public void execute() {
		audioPlayer.stop();
	}

}
