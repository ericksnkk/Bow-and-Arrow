package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class orange_baloon {
    Texture asset;
    private float x, y;
    private float speed;
    private boolean naTela;
    private Random random;

    public orange_baloon(float xini) {
        asset = new Texture("orange_baloon.png");
        this.x = xini;
        this.y = -asset.getHeight();
        this.random = new Random();
        reset();
    }

    public void update() {
        if (naTela) {
            y += speed;
            if (y >= Gdx.graphics.getHeight() + 72) {
                naTela = false;
            }
        }
    }

    public void render(SpriteBatch batch) {
        if (naTela) {
            batch.draw(asset, x, y - 72, 54, 72);
        }
    }

    public void reset() {
        this.y = -asset.getHeight();
        this.naTela = true;
        this.speed = 1f + random.nextFloat() * 3f;
    }

    public boolean isNaTela() {
        return naTela;
    }

    public void dispose() {
        asset.dispose();
    }
}
