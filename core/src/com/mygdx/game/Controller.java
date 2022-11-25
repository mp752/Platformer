// Controller.java is used to setup the controls for our game

// Name of the folder where all the class files are

package com.mygdx.game;

// Importing needed classes

import java.util.HashMap;
import java.util.Map;

// We create our Controller.java class
public class Controller {

    // We create a list of constants to define the controls that our game has. More can be added on, such as JUMP
    enum Keys {

        LEFT, RIGHT

    }

    // Create an instance of Level.java class
    private Level  level;

    // Create an instance of Character.java class

    private Character  character;

    // Create a hashmap that contains all of our controls defined above, tied to a boolean to define if the key is pressed down or not
    static Map<Keys, Boolean> keys = new HashMap<Keys, Boolean>();
    // The hashmap is defined below, a hashmap joins two values together into one. In this case we defined two keys
    // Each key has the associated button, and a boolean (true or false) on weather or not the button is pressed
    static {

        keys.put(Keys.LEFT, false);

        keys.put(Keys.RIGHT, false);


    };


    // Creating the Controller.java class, taking in the level we want to control as an argument
    public Controller(Level level) {

        // Defining this instance of the Level class

        this.level = level;

        // Defining this instance of a character for the level (our hero)

        this.character = level.getCharacter();

    }




    // Function for when the left button is pressed
    public void leftPressed() {

        // Set the key in the hashmap to true
        keys.get(keys.put(Keys.LEFT, true));

    }


    // Function for when the right button is pressed

    public void rightPressed() {
        // Set the key in the hashmap to true

        keys.get(keys.put(Keys.RIGHT, true));

    }

    // Function for when the left button is released

    public void leftReleased() {
        // Set the key in the hashmap to false

        keys.get(keys.put(Keys.LEFT, false));

    }

    // Function for when the right button is released

    public void rightReleased() {
        // Set the key in the hashmap to false

        keys.get(keys.put(Keys.RIGHT, false));

    }





    // A function to update the game screen every frame with new information (like if our character moves)
    public void update(float delta) {
        // Run processInput() to handle any incoming button presses. We define it down below
        processInput();
        // update information about the character as needed (like his position)
        character.update(delta);

    }



    // A function to handle incoming button presses
    private void processInput() {

        // If the left key is currently being pressed down

        if (keys.get(Keys.LEFT)) {

            // We set the character to be facing left
            character.setFacingLeft(true);
            // We set the state of the character to be walking
            character.setState(Character.State.WALKING);
            // We set the characters current velocity to the negative value of the characters speed
            // The value is negative because they are moving to the left along the x-axis
            character.getVelocity().x = -character.SPEED;

        }

        // If the right key is currently being pressed down
        if (keys.get(Keys.RIGHT)) {

            // We set the character to NOT be facing left since they are moving right
            character.setFacingLeft(false);
            // We set the state of the character to be walking
            character.setState(Character.State.WALKING);
            // We set the characters current velocity to the positive value of the characters speed
            // The value is positive because they are moving to the right along the x-axis
            character.getVelocity().x = character.SPEED;

        }

        // If both the left and right key are being pressed at the same time
        if ((keys.get(Keys.LEFT) && keys.get(Keys.RIGHT)) ||
                // Or if neither key is pressed down at all
                (!keys.get(Keys.LEFT) && !(keys.get(Keys.RIGHT)))) {

            // Then the character is currently IDLE, not moving
            character.setState(Character.State.IDLE);

            // There is no acceleration
            character.getAcceleration().x = 0;


            // There is no velocity
            character.getVelocity().x = 0;

        }

    }

}

