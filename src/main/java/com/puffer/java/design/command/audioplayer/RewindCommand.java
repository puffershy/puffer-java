package com.puffer.java.design.command.audioplayer;

/**
 * 倒带（具体命令）
 * 
 * @author buyi
 * @since 1.0.0
 * @date 2018上午11:40:38
 */
public class RewindCommand implements Command {
	private AudioPlayer audioPlayer;

	public RewindCommand(AudioPlayer audioPlayer) {
		super();
		this.audioPlayer = audioPlayer;
	}

	@Override
	public void execute() {
		audioPlayer.rewind();
	}

}
