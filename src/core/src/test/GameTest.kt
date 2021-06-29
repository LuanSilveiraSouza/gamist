package com.luanss.gamist.core.domain

import exception.InvalidScoreException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class GameTest {
    @Test
    fun testInvalidScoreException() {
        var game1 = Game("Super Mario Bros", 1885, "Nintendo", 97)

        Assertions.assertEquals(game1.getScore(), 97)

        val exception = assertThrows<InvalidScoreException>
        {
            val game2 = Game("ET", 1882, "Atari", -6)
        }

        Assertions.assertEquals(exception.message, "Game score needs to be between 0 and 100")
    }
}