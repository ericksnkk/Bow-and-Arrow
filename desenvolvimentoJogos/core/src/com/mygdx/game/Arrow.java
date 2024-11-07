package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Arrow {
    private Texture asset;
    private float x, y;
    private float SPEED = 10.0f;
    private boolean naTela;

    public Arrow() {
        asset = new Texture("arrow.png");
        this.naTela = false;

    }

    public void reset(float xini, float yini){
        this.x = xini;
        this.y = yini;
        this.naTela = true;
    }

    public void update() {
        x += SPEED;
        if(x > Gdx.graphics.getWidth()) {
            naTela = false;
        }
    }

    public void render(SpriteBatch batch) {
        if(naTela) {
            batch.draw(asset, x, y, 110, 52);
        }
    }

    public boolean isNaTela() {
        return naTela;
    }

    public void dispose() {
        asset.dispose();
    }
}
