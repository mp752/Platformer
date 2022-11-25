// The LevelRenderer.Java class file is used to draw the level objects to the screen

// Name of the folder where all the class files are

package com.mygdx.game;

// Importing needed classes

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;


// Defining the LevelRenderer.java class
public class LevelRenderer {

    // Create instance of Level.Java
    private Level level;

    // Create a new instance of an OrthographicCamera, a camera is used to show things to the screen like a real camera

    private OrthographicCamera cam;

    // Defining a new shape renderer which is used to draw shapes to the screen
    ShapeRenderer shapeRenderer = new ShapeRenderer();


    // Constructor for the level renderer, which takes a level an argument
    public LevelRenderer(Level level) {
        // Define the instance of the level with the level passed in as an argument
        this.level = level;
        // Defining the camera, giving a width and height of 10 by 7
        this.cam = new OrthographicCamera(10, 7);
        // Setting the current position of the camera. It's set to the middle of the screen so it can capture everything
        this.cam.position.set(5, 3.5f, 0);
        // Update the camera with the settings set above
        this.cam.update();

    }


    // Function to start rendering objects to the screen
    public void render() {

        // Tell the shape renderer to use the camera we defined above
        shapeRenderer.setProjectionMatrix(cam.combined);

        // Start up the shape renderer, telling it to fill in the shapes
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Start getting the blocks from our level

        for (Block block : level.getBlocks()) {

            // Get the boundaries of each block

            Rectangle rect = block.getBounds();

            // Set the position of each block using the blocks position and boundaries

            float x1 = block.getPosition().x + rect.x;

            float y1 = block.getPosition().y + rect.y;

            // set the color of the blocks to green

            shapeRenderer.setColor(Color.GREEN);

            // Draw the blocks to the screen as a rectangle using position and size

            shapeRenderer.rect(x1, y1, rect.width, rect.height);

        }

        // Define and get our character from the level
        Character character = level.getCharacter();
        //  Get the boundary for the character
        Rectangle bound = character.getBounds();
        // Get the current character position by using position and boundaries
        float x1 = character.getPosition().x + bound.x;
        float y1 = character.getPosition().y + bound.y;
        // Set the color of the character to red
        shapeRenderer.setColor(Color.RED);
        // Draw the character to the screen as a rectangle
        shapeRenderer.rect(x1, y1, bound.width, bound.height);
        // Close the shape renderer
        shapeRenderer.end();


    }
}
