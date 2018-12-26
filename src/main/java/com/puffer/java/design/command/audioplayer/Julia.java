package com.puffer.java.design.command.audioplayer;

public class Julia {
	public static void main(String[] args) {

		Keypad keypad = init();
		
		// 测试
		keypad.play();
		keypad.rewind();
		keypad.stop();
		keypad.play();
		keypad.stop();
	}

	public static Keypad init() {
		// 创建接收者对象
		AudioPlayer audioPlayer = new AudioPlayer();
		// 创建命令对象
		Command playCommand = new PlayCommand(audioPlayer);
		Command rewindCommand = new RewindCommand(audioPlayer);
		Command stopCommand = new StopCommand(audioPlayer);
		// 创建请求者对象
		Keypad keypad = new Keypad();
		keypad.setPlayCommand(playCommand);
		keypad.setRewindCommand(rewindCommand);
		keypad.setStopCommand(stopCommand);

		return keypad;
	}
}
