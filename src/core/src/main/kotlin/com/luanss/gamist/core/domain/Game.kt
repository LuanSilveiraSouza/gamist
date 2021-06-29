package com.luanss.gamist.core.domain

import com.luanss.gamist.core.exception.InvalidScoreException

data class Game(
        private var name: String,
        private var releaseYear: Int,
        private var developer: String,
        private val score: Int
) {
    init {
        if (score < 0 || score > 100) {
            throw InvalidScoreException()
        }
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getName(): String {
        return this.name
    }

    fun setDeveloper(developer: String) {
        this.developer = developer
    }

    fun getDeveloper(): String {
        return this.developer
    }

    fun setReleaseYear(releaseYear: Int) {
        this.releaseYear = releaseYear
    }

    fun getReleaseYear(): Int {
        return this.releaseYear
    }

    fun getScore(): Int {
        return this.score
    }
}