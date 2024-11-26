package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class BalloonController {
    private List<orange_baloon> baloons;
    private static BalloonController instance;

    private int nPosition = 4;
    private int maxBaloons = 3;

    private BalloonController() {
        baloons = new ArrayList<>();
        for (int i = 0; i < nPosition; i++) {
            float xini = (i + 1) * (Gdx.graphics.getWidth() / (nPosition + 1));
            for (int j = 0; j < maxBaloons; j++) {
                baloons.add(new orange_baloon(xini));
            }
        }
    }

    public static BalloonController getInstance() {
        if (instance == null) {
            instance = new BalloonController();
        }
        return instance;
    }

    public List<orange_baloon> getBalloons() {
        return baloons;
    }

    public void createBalloons(int nPosition) {
    }

    public void update() {
        for (orange_baloon baloon : baloons) {
            baloon.update();
        }
    }

    public void render(SpriteBatch batch) {
        for (orange_baloon baloon : baloons) {
            baloon.render(batch);
        }
    }

    public void dispose() {
        for (orange_baloon baloon : baloons) {
            baloon.dispose();
        }
    }
}
