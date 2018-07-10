package com.example.titi.musicmatcher

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.InputStream

data class Band(val name: String, val genres: List<String>) {
}

class App() {
    val bands = loadBands()
    val favorites = mutableListOf<Band>()

    fun addFavorite(band: Band) {
        if(band in favorites) {
            favorites.remove(band)
        }
        else favorites.add(band)
    }

    fun getFavoriteGenres() :List<String> {
        val genresLiked = HashMap<String, Int>()
        favorites.forEach {
            it.genres.forEach {
                if(it in genresLiked) {
                    val liked = genresLiked[it]
                    genresLiked[it] = liked!!+1
                }
                else genresLiked[it] = 1
            }
        }

        return genresLiked.toList().sortedByDescending { (_, value) -> value }.map { it.first }
    }

    fun getBestGenres(number: Int) :List<String> {
        if(number == 0) throw IllegalArgumentException("Coucou, tu veux voir ma ...?")
        return getFavoriteGenres().slice(IntRange(0, number - 1))
    }

    fun getSuggestions(max :Int) :List<String> {
        val bestGenres = getBestGenres(2)
        var numberSuggested = 0
        val suggestions = mutableListOf<String>()
        for(band in bands) {
            if (band !in favorites) {
                for (genre in bestGenres) {
                    if (genre in band.genres && numberSuggested < max) {
                        numberSuggested++
                        suggestions.add(band.name)
                        continue
                    }
                }
            }
        }

        return suggestions
    }

    fun loadBands() :List<Band> {
        val stream: InputStream = File("src/main/assets/bands.json").inputStream()
        val bandsJson :String = stream.bufferedReader().use { it.readText() }
        val listType = object : TypeToken<List<Band>>() { }.type
        return Gson().fromJson(bandsJson, listType)
    }
}