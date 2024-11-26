package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {
    private Texture asset;
    private float y, x = 50;
    private int largura = 132, altura = 124;
    private float SPEED = 5.0f;

    // Flechas
    private ArrowController arrowController;

    public Player() {
        asset = new Texture("Player.png");
        y = 0;
        arrowController = ArrowController.getInstance(); // Instancia o controlador de flechas
    }

    public void update() {
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.W)) {
            y += SPEED;
        }
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.S)) {
            y -= SPEED;
        }

        y = Math.max(0, Math.min(Gdx.graphics.getHeight() + 45 - altura, y));
    }

    public void render(SpriteBatch batch) {
        batch.draw(asset, x, y, largura, altura);
        arrowController.render(batch);
    }

    public void atirar() {
        for (Arrow arrow : arrowController.getArrows()) {
            if (!arrow.isNaTela()) {
                arrow.reset(x + 60, y + altura / 2 - 16);
                break;
            }
        }
    }

    public void dispose() {
        asset.dispose();
        arrowController.dispose();
    }
}
