package com.luanss.gamist.core

import com.luanss.gamist.core.domain.Game
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
    }

    @Test
    fun shouldValidateSecondaryConstructor() {
        var game = Game("Super Mario Bros", 1985, 94, 1.4F, "The game responsible to bring back the glory of the game industry")

        var gameSpy = Mockito.spy(game)

        gameSpy.validate()

        assertEquals(game.getId().toString().length, 36)
        assertEquals(game.getScore(), 94)
        Mockito.verify(gameSpy).validate()
    }
}