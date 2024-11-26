package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Input;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture background;
	private Player player;

	@Override
	public void create() {
		batch = new SpriteBatch();
		background = new Texture("Background.png");
		player = new Player();
	}

	@Override
	public void render() {
		ScreenUtils.clear(0, 0, 0, 1);

		batch.begin();
		batch.draw(background, 0, 0);

		BalloonController.getInstance().update();
		BalloonController.getInstance().render(batch);

		ArrowController.getInstance().update();
		ArrowController.getInstance().checkCollisions();
		ArrowController.getInstance().render(batch);

		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			player.atirar();
		}

		player.update();
		player.render(batch);

		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		background.dispose();
		player.dispose();
		ArrowController.getInstance().dispose();
		BalloonController.getInstance().dispose();
	}
}
