package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Arrow {
    private Texture asset;
    private float x, y;
    private float SPEED = 15.0f;
    private boolean naTela;
    private Rectangle bounds;

    public Arrow() {
        asset = new Texture("arrow.png");
        this.naTela = false;
        this.bounds = new Rectangle();
    }

    public void reset(float xini, float yini) {
        this.x = xini;
        this.y = yini;
        this.naTela = true;
        this.bounds.set(x, y, 110, 52);
    }

    public void update() {
        if (naTela) {
            x += SPEED;
            bounds.setPosition(x, y);
            if (x > Gdx.graphics.getWidth()) {
                naTela = false;
            }
        }
    }

    public void render(SpriteBatch batch) {
        if (naTela) {
            batch.draw(asset, x, y, 110, 52);
        }
    }

    public boolean isNaTela() {
        return naTela;
    }

    public void setNaTela(boolean naTela) {
        this.naTela = naTela;
    }

    public Rectangle getBoundingRectangle() {
        return bounds;
    }

    public void dispose() {
        asset.dispose();
    }
}
