//Platformer.java is the initial class to be run. All that it does right now is simply act as a gateway to the rest of our code.

// Name of the folder where all the class files are
package com.mygdx.game;

// Importing needed classes
import com.badlogic.gdx.Game;



// Defining the Platformer class which is the main class for the game.
// As you can see, it says 'extends game' which means it takes the game class provided by libgdx is adds onto it.
public class Platformer extends Game {


	@Override
	// The "create" function is what runs when the game is first started up
	// Create is used to set up resources
	public void create () {
		// When the game starts up, go to our game screen
		// The "this." part refers to this instance of the game
		this.setScreen(new GameScreen());
	}

	@Override
	// Render is what runs after create. Usually used to render objects to the screen
	public void render () {
		// This makes use of the game class' render function to render objects to the screen.
		// The "super" part of this statement is referring to the "game" class that we are extending
		super.render();
	}


	@Override
	// Runs after the game is closed, usually used to dispose of objects that were in use
	public void dispose () {
	}
}
