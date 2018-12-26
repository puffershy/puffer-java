package com.puffer.java.design.command.audioplayer;

/**
 * 播放（具体命令）
 * 
 * @author buyi
 * @since 1.0.0
 * @date 2018上午11:40:19
 */
public class PlayCommand implements Command {
	private AudioPlayer audioPlayer;

	public PlayCommand(AudioPlayer audioPlayer) {
		super();
		this.audioPlayer = audioPlayer;
	}

	@Override
	public void execute() {
		audioPlayer.play();
	}

}
