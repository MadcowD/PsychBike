package com.madcowd.psychbike;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.punchline.javalib.utils.LogManager;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.useGL20 = false;
		cfg.resizable = false;
		
		LwjglApplication a = new LwjglApplication(new PsychBike(), cfg); 
		LogManager.init(a);
	}
}
