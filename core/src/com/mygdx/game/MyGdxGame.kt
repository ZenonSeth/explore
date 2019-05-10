package com.mygdx.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch

/**
 * Written by Milcho on 5/10/2019.
 */

class MyGdxGame : ApplicationAdapter() {
    private lateinit var batch: SpriteBatch
    private lateinit var img: Texture
    private lateinit var camera: Camera

    override fun create() {
        batch = SpriteBatch()
        img = Texture("badlogic.jpg")
        camera = OrthographicCamera(100f, 100f)
    }

    override fun resize(width: Int, height: Int) {
        super.resize(width, height)
        camera.viewportWidth = 400.0f
        camera.viewportHeight = 400.0f * height / width
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0f)
        camera.update()

    }


    override fun render() {
        camera.update()
        Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch.projectionMatrix = camera.combined
        batch.begin()
        batch.draw(img, 0f, 0f)
        batch.end()
    }

    override fun dispose() {
        batch.dispose()
        img.dispose()
    }
}