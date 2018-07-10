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
        app.addFavorite(app.bands[2])
        app.addFavorite(app.bands[6])

        val expected = listOf("metal", "rock", "blues")
        Assert.assertEquals(expected, app.getFavoriteGenres())

    }

    @Test
    fun can_get_best_favorite_genres() {
        val app = App()
        app.addFavorite(app.bands[0])
        app.addFavorite(app.bands[2])
        app.addFavorite(app.bands[6])
        app.addFavorite(app.bands[12])
        app.addFavorite(app.bands[15])
        app.addFavorite(app.bands[18])

        val expected = listOf("metal", "rock", "blues", "folk", "funk")
        Assert.assertEquals(expected, app.getBestGenres(5))
    }

    @Test
    fun can_get_suggestions() {
        val app = App()
        app.addFavorite(app.bands[1])
        app.addFavorite(app.bands[3])
        app.addFavorite(app.bands[7])
        app.addFavorite(app.bands[11])
        app.addFavorite(app.bands[5])
        app.addFavorite(app.bands[16])
        app.addFavorite(app.bands[14])

        val expected = listOf("Sleep", "Electric Wizard", "Alkpote")
        Assert.assertEquals(expected, app.getSuggestions(3))
    }
}
