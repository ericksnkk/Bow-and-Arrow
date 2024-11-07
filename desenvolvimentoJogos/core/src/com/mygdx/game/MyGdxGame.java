package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import java.util.ArrayList;
import java.util.List;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture background;
	private Player player;

	private List<List<orange_baloon>>baloonsP;
	private int maxBaloons = 3;
	private int nPosition = 4;

	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("Background.png");
		player = new Player();

		baloonsP = new ArrayList<>();
		for(int i = 0; i < nPosition; i++) {
			List<orange_baloon> pool = new ArrayList<>();
			float xini = (i+1) * (Gdx.graphics.getWidth()/ (nPosition+1));
			for (int j = 0; j < maxBaloons; j++) {
				pool.add(new orange_baloon(xini));
			}
			baloonsP.add(pool);
		}
	}

	@Override
	public void render() {
		ScreenUtils.clear(0, 0, 0, 1);

		batch.begin();
		batch.draw(background, 0, 0);

		for(List<orange_baloon> pool: baloonsP){
			for(orange_baloon baloon: pool){
				baloon.update();
				if(baloon.isNaTela()){
					baloon.render(batch);
				}else{
					baloon.reset();
				}
			}
		}

		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
			player.atirar();
		}

		player.update();
		player.render(batch);

		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
		player.dispose();
		for(List<orange_baloon> pool : baloonsP){
			for(orange_baloon baloon: pool){
				baloon.dispose();
			}
		}
	}
}