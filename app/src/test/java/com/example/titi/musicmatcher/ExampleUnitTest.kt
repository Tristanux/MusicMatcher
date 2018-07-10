package com.example.titi.musicmatcher

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun can_add_a_favorite() {
        val app = App()
        app.addFavorite(app.bands[0])
        Assert.assertEquals(app.favorites.count(), 1)
    }

    @Test
    fun can_remove_a_favorite() {
        val app = App()
        app.addFavorite(app.bands[0])
        app.addFavorite(app.bands[0])
        Assert.assertEquals(app.favorites.count(), 0)
    }

    @Test
    fun can_get_favorite_genres() {
        val app = App()
        app.addFavorite(app.bands[0])
        app.addFavorite(app.bands[1])
        println(app.getFavoriteGenres())
    }
}
