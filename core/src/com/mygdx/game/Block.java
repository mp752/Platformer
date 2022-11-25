// The Block.Java file is used to define the 'blocks' that make up the levels of our game

// Name of the folder where all the class files are

package com.mygdx.game;

// Importing needed classes
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

// Defining the Block.Java class
public class Block {
    // Define the size of each block
    static final float SIZE = 1f;

    // Define the position using Vector2 which allows use to X and Y coordinates
    Vector2 position = new Vector2();
    // Define the boundaries of the blocks as a rectangle, needed for physics
    Rectangle bounds = new Rectangle();

    // The constructor used to crate a new instance of a block, takes a position as an argument
    public Block(Vector2 pos){
        // set this instance of the block to the position that was passed in as an argument
        this.position = pos;
        // set the width and height to the size we defined above
        this.bounds.width = SIZE;
        this.bounds.height = SIZE;
    }

    // Getter for the position of this instance of a block
    public Vector2 getPosition(){
        return position;
    }

    // Getter for the boundaries of this instance of a block
    public Rectangle getBounds(){
        return bounds;
    }

}