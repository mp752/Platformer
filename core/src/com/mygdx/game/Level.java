// The level.java class file is used to define a level for our game

// Name of the folder where all the class files are

package com.mygdx.game;

// Importing needed classes

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

// Defining the Level.java class
public class Level {


    // An array (think of it almost as a list) that holds all the blocks that make up our level
    Array<Block> blocks = new Array<Block>();

    // The character that we are going to be using in this level, defined in Character.Java
    Character character;

    // A getter for the blocks in the level
    public Array<Block> getBlocks() {
        return blocks;
    }
    // A getter for the character in the level
    public Character getCharacter(){
        return character;
    }

    // This constructor simply calls the createLevelOne() function to define a level
    public Level() {
        createLevelOne();
    }

    // This function creates our level using the Block.java class, these blocks make up our level
    private void createLevelOne() {
        // First we set a starting position for our character at x=0 and y=1
        character = new Character(new Vector2(0,1));
        // Run a loop 10 times
        for (int i  = 0; i < 10; i++){
            // This loop is going to add blocks across the screen along the x-axis at y=0, meaning we'll get a floor at the bottom of the screen
            // When i is equal to five (the sixth time this loop runs) we WON'T draw a black to the screen, so we can make a simple gap
            if(i != 5) {
                // Add a block at position (i,0), where i is how many times the loop has run so far, meaning it'll keep going up
                blocks.add(new Block(new Vector2(i, 0)));
            }
        }
    }
}
