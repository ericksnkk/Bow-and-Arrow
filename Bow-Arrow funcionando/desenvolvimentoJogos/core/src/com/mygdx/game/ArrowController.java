package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class ArrowController {
    private List<Arrow> arrows;
    private static ArrowController instance;

    private ArrowController() {
        arrows = new ArrayList<>();
        for (int i = 0; i < 7; i++) {  // Número de flechas no pool
            arrows.add(new Arrow());
        }
    }

    public static ArrowController getInstance() {
        if (instance == null) {
            instance = new ArrowController();
        }
        return instance;
    }

    public List<Arrow> getArrows() {
        return arrows;
    }

    public void update() {
        for (Arrow arrow : arrows) {
            arrow.update();
        }
    }

    public void checkCollisions() {
        for (Arrow arrow : arrows) {
            if (arrow.isNaTela()) {
                for (orange_baloon baloon : BalloonController.getInstance().getBalloons()) {
                    if (baloon.isNaTela() && arrow.getBoundingRectangle().overlaps(baloon.getBoundingRectangle())) {
                        arrow.setNaTela(false);
                        baloon.reset();
                        break;
                    }
                }
            }
        }
    }



    public void render(SpriteBatch batch) {
        for (Arrow arrow : arrows) {
            if (arrow.isNaTela()) {
                arrow.render(batch);
            }
        }
    }

    public void dispose() {
        for (Arrow arrow : arrows) {
            arrow.dispose();
        }
    }
}
