package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	TextureAtlas textureAtlas;
	TextureRegion textureRegion;
	Sprite sprite;
	Animation<TextureRegion> stillAnimation;
	Animation movingAnimation;
	int frame = 1;
	float timeForStill = 0.0f;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas(Gdx.files.internal("megSprites/megAtlas.atlas"));
		textureRegion = textureAtlas.findRegion("tile000");
		stillAnimation = new Animation(1/10f,textureAtlas.getRegions());
		sprite = new Sprite(textureRegion);
		sprite.setPosition(Gdx.graphics.getWidth()/2-sprite.getWidth(),Gdx.graphics.getHeight()/2-sprite.getHeight());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, Color.BLACK.a);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		timeForStill += Gdx.graphics.getDeltaTime();
		batch.draw(stillAnimation.getKeyFrame(timeForStill,true),0,0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
