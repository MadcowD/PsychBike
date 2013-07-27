package com.punchline.microspace;

import com.punchline.javalib.entities.GameOverInfo;

public class MicroGameOverInfo extends GameOverInfo {

	public String winningGroup;
	
	public MicroGameOverInfo(String winningGroup) {
		this.winningGroup = winningGroup;
	}
	
}
