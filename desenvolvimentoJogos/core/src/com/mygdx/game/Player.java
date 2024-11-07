package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private Texture asset;
    private float y, x = 50;
    private int largura = 132, altura = 124;
    private float SPEED = 5.0f;

    //flechas
    private List<Arrow> arrows;
    private int maxArrows = 7;

    public Player() {
        asset = new Texture("Player.png");
        y = 0;

        arrows = new ArrayList<>();
        for(int i = 0; i < maxArrows; i++) {
            arrows.add(new Arrow());
        }
    }

    public void update() {
        if(Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.W)) {
            y += SPEED;
        }
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.S)) {
            y -= SPEED;
        }

        y = Math.max(0, Math.min(Gdx.graphics.getHeight() + 45 - altura, y));

        for (Arrow arrow : arrows) {
            arrow.update();
        }

    }

    public void render(SpriteBatch batch) {
        batch.draw(asset, x, y, largura, altura);

        for (Arrow arrow : arrows) {
            arrow.render(batch);
        }
    }

    public void atirar(){
        for (Arrow arrow : arrows) {
            if(!arrow.isNaTela()){
                arrow.reset(x + 60, y+altura/2 -16);
                break;
            }
        }

        //arrows.add(new  Arrow(x+60, y+altura/2 - 16));
    }

    public void dispose() {
        asset.dispose();
        for (Arrow arrow : arrows) {
            arrow.dispose();
        }
    }
}
