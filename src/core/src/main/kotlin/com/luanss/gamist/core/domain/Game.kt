package com.luanss.gamist.core.domain

import com.luanss.gamist.core.exception.InvalidPlayTimeException
import com.luanss.gamist.core.exception.InvalidReleaseYearException
import com.luanss.gamist.core.exception.InvalidScoreException
import java.text.SimpleDateFormat
import java.util.UUID
import java.util.Date

open class Game(
        private val id: UUID,
        private var name: String,
        private var releaseYear: Int,
        private var score: Int,
        private var playTime: Float,
        private var description: String,
) {
    constructor(
            name: String,
            releaseYear: Int,
            score: Int,
            playTime: Float,
            description: String,
    ) : this(UUID.randomUUID(), name, releaseYear, score, playTime, description) {}

    init {
        validate()
    }

    fun getId(): UUID {
        return this.id
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getName(): String {
        return this.name
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

    fun setScore(score: Int) {
        this.score = score
    }

    fun setPlayTime(playTime: Float) {
        this.playTime = playTime
    }

    fun getPlayTime(): Float {
        return this.playTime
    }

    fun setDescription(description: String) {
        this.description = description
    }

    fun getDescription(): String {
        return this.description
    }

    open fun validate() {
        checkScore()
        checkPlayTime()
        checkReleaseYear()
    }

    open fun checkScore() {
        if (this.score < 0 || this.score > 100) {
            throw InvalidScoreException()
        }
    }

    open fun checkReleaseYear() {
        if (this.releaseYear < 1970) {
            throw InvalidReleaseYearException()
        }
    }

    open fun checkPlayTime() {
        val currentDate = Date()
        val formatter = SimpleDateFormat("yyyy")

        if (this.playTime > 0 && this.releaseYear > Integer.parseInt(formatter.format(currentDate))) {
            throw InvalidPlayTimeException()
        }
    }
}