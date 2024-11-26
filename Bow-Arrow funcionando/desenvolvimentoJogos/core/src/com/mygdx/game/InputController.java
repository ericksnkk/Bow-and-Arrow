package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class InputController {
    private static InputController instance;
    private InputController() {}

    public static InputController getInstance() {
        if (instance == null) {
            instance = new InputController();
        }
        return instance;
    }

    public boolean isUpPressed() {
        return Gdx.input.isKeyPressed(Input.Keys.W);
    }

    public boolean isDownPressed() {
        return Gdx.input.isKeyPressed(Input.Keys.S);
    }

    public boolean isSpaceJustPressed() {
        return Gdx.input.isKeyJustPressed(Input.Keys.SPACE);
    }
}
