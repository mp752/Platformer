// This class file is used to setup the gamescreen

// Name of the folder where all the class files are

package com.mygdx.game;

// Importing needed classes
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

// Defining the game screen class. This class 'implements' two other classes
// Implementing a class means you are using that class almost as a blueprint
public class GameScreen implements Screen, InputProcessor {
    // New instance of the level we defined in Level.java
    private Level level;
    // new instance created from the LevelRenderer.java file, used to draw level objects to the screen
    private LevelRenderer renderer;
    // New instance created from the Controller.java file, used to define the controls for the game.
    private Controller controller;



    @Override
    // The show method part of the Screen class we are implementing, this runs when this screen is set
    public void show() {
        // Define the new instance of our level
        level = new Level();
        // define a new instance of our level renderer, passing in the level that we want to render
        renderer = new LevelRenderer(level);
        // define the new instance of our controller, passing in the level that we want to control
        controller = new Controller(level);
        // setting the input processor so our game can get our button presses
        Gdx.input.setInputProcessor(this);

    }

    @Override
    // The render method runs after the show method
    public void render(float delta) {
        // The new two lines clear the screen so there are no leftovers when drawing objects to the screen
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // We run the 'update' function from our controller class so the game keeps an eye out for our button presses
        controller.update(delta);
        // We use the 'render' function from our LevelRenderer class to draw objects to the screen
        renderer.render();

    }

    @Override
    // function that runs when our window is resized
    public void resize(int width, int height) {

    }

    @Override
    // function that runs when the screen is paused
    public void pause() {

    }

    @Override
    // function that runs when the screen is unpaused
    public void resume() {

    }

    @Override
    // function that runs when this screen is no longer the current screen
    public void hide() {
        // disable input processor to stop getting button inputs
        Gdx.input.setInputProcessor(null);

    }

    @Override
    // function that runs when the screen is closed
    public void dispose() {
        // disable input processor to stop getting button inputs

        Gdx.input.setInputProcessor(null);

    }

    @Override
    // This function runs when a button is pressed down
    public boolean keyDown(int keycode) {
        // If the 'left' key is pressed down
        if (keycode == Input.Keys.LEFT)
            // then tell our controller class that it's pressed
            controller.leftPressed();
        // if the 'right' key is pressed down
        if (keycode == Input.Keys.RIGHT)
            // then tell our controller class that it's pressed
            controller.rightPressed();
        return true;
    }

    @Override
    // This function runs when a button is released
    public boolean keyUp(int keycode) {
        // If we let go of the left button
        if (keycode == Input.Keys.LEFT)
            // we tell our controller class
            controller.leftReleased();
        // ditto if we let go of the right button
        if (keycode == Input.Keys.RIGHT)
            controller.rightReleased();
        return true;
    }

    // Everything below this is for android touch screens and can be ignored. It's simply here as we are using "InputProcessor" as a blueprint

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
