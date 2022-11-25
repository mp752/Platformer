// The Character.Java file defines information and functions about our main controllable character

// Name of the folder where all the class files are

package com.mygdx.game;

// Importing needed classes
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

// Defining the character class
public class Character {

    // This defines some states our characters could be in. Right now only IDLE (not moving) and walking are implemented
    // Jump could be implemented
    public enum State{
        IDLE, WALKING, JUMPING
    }

    // The speed of our character
    static final float SPEED = 2f;
    // The jump speed of cour character
    static final float JUMP_SPEED = 1f;
    // How big our character is
    static final float SIZE = 0.5f;
    // A float to keep track of time in the game
    float		stateTime = 0;

    // The position of our character. Vector2 means we have both an X and a Y
    Vector2 position = new Vector2();
    // Upward acceleration of our character
    Vector2 acceleration = new Vector2();
    // Speed or Velocity of our character
    Vector2 velocity = new Vector2();
    // The boundary that makes up our character
    Rectangle bounds = new Rectangle();
    // The current state of our character, be default he's IDLE (not moving)
    State state = State.IDLE;

    // Used to keep track of what position our character is facing
    boolean		facingLeft = true;

    // The function used to create a new instance of our character, takes a position as an argument
    public Character(Vector2 position){
        // Set the position that was passed in
        this.position = position;
        // Set the boundary height to the size of the character
        this.bounds.height = SIZE;
        // Set the boundary width to the size of our character
        this.bounds.width = SIZE;


    }

    // A getter to return if the character is facing left or not
    public boolean isFacingLeft() {
        return facingLeft;
    }

    // A setter to set if the character is facing left or not
    public void setFacingLeft(boolean facingLeft) {
        this.facingLeft = facingLeft;
    }

    // A getter to get the current position of the character
    public Vector2 getPosition(){
        return position;
    }

    // A getter to get the boundaries of our character
    public Rectangle getBounds(){
        return bounds;
    }

    // A getter for getting the state of our character

    public State getState() {
        return state;
    }

    // A getter for getting the current acceleration
    public Vector2 getAcceleration() {
        return acceleration;
    }
    // A getter for velocity
    public Vector2 getVelocity() {
        return velocity;
    }
    // A setter for the state of the character
    public void setState(State newState) {
        this.state = newState;
    }
    // The getter for amount of time passed
    public float getStateTime() {
        return stateTime;
    }

    // This update function keeps track of where our character currently is every frame

    public void update(float delta) {
        // We store the current velocity in a temporary variable
        Vector2 tmp = velocity;
        // We increase stateTime by the amount of time passed
        stateTime += delta;
        // We adjust position of the character every frame based on what the current velocity of our character is
        position.add(tmp.scl(delta));
    }


}