package com.puffer.java.design.command.audioplayer;

/**
 * 宏命令接口
 * 
 * @author buyi
 * @since 1.0.0
 * @date 2018上午11:44:26
 */
public interface MacroCommand extends Command {

	public void add(Command command);

	public void remove(Command command);
}
