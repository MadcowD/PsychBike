package com.punchline.microspace;

import java.util.ArrayList;

import com.punchline.javalib.entities.EntityWorld;

/**
 * TODO THIS IS A HORRIBLE SOLUTION TO A MEMORY LEAK. I KNOW. For some reason this will avoid a crash, though. 
 * Will fix after game jam
 * 
 * @author Nathaniel
 * @created Jul 24, 2013
 */
public class Worlds {

	public static ArrayList<EntityWorld> worlds = new ArrayList<EntityWorld>();
	
	public static void dispose() {
		for (EntityWorld world : worlds) {
			world.dispose();
		}
	}
	
}
