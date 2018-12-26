package com.puffer.java.design.command.audioplayer;

/**
 * 录音机(接收者Receiver)
 * 
 * @author buyi
 * @since 1.0.0
 * @date 2018下午5:23:59
 */
public class AudioPlayer {
	public void play() {
		System.out.println("播放……");
	}

	public void rewind() {
		System.out.println("倒带……");
	}

	public void stop() {
		System.out.println("停止……");
	}
}
