package com.luanss.gamist.core

import com.luanss.gamist.core.domain.Game
import com.luanss.gamist.core.exception.InvalidPlayTimeException
import com.luanss.gamist.core.exception.InvalidReleaseYearException
import com.luanss.gamist.core.exception.InvalidScoreException
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.util.UUID

internal class GameTest {
    @Test
    fun shouldValidatePrimaryConstructor() {
        val generatedUuid = UUID.randomUUID()
        var game = Game(generatedUuid, "Super Mario Bros", 1985, 94, 1.4F, "The game responsible to bring back the glory of the game industry")

        var gameSpy = Mockito.spy(game)

        gameSpy.validate()

        assertEquals(generatedUuid.compareTo(game.getId()), 0)
        assertEquals(game.getScore(), 94)
        Mockito.verify(gameSpy).validate()
        Mockito.verify(gameSpy).checkScore()
        Mockito.verify(gameSpy).checkReleaseYear()
        Mockito.verify(gameSpy).checkPlayTime()
    }

    @Test
    fun shouldValidateSecondaryConstructor() {
        var game = Game("Super Mario Bros", 1985, 94, 1.4F, "The game responsible to bring back the glory of the game industry")

        var gameSpy = Mockito.spy(game)

        gameSpy.validate()

        assertEquals(game.getId().toString().length, 36)
        assertEquals(game.getScore(), 94)
        Mockito.verify(gameSpy).validate()
        Mockito.verify(gameSpy).checkScore()
        Mockito.verify(gameSpy).checkReleaseYear()
        Mockito.verify(gameSpy).checkPlayTime()
    }

    @Test
    fun shouldThrowInvalidScoreException() {
        var exception = assertThrows<InvalidScoreException> {
            var game = Game("Et", 1982, -5, 0.3F, "The worst game made ever")
        }

        assertEquals(exception.message, "Score needs to be between 0 and 100")
    }

    @Test
    fun shouldThrowInvalidReleaseYearException() {
        var exception = assertThrows<InvalidReleaseYearException> {
            var game = Game("Et", 1958, 1, 0.3F, "The worst game made ever")
        }

        assertEquals(exception.message, "Release Year cannot be a value below 1970")
    }

    @Test
    fun shouldThrowInvalidPlayTimeException() {
        var exception = assertThrows<InvalidPlayTimeException> {
            var game = Game("The Elder Scrolls 6", 2023, 99, 0.5F, "The sucessor of Skyrin that expands to a new level the concept of a RPG game")
        }

        assertEquals(exception.message, "Games with release year in the future cannot have Play Time")
    }
}