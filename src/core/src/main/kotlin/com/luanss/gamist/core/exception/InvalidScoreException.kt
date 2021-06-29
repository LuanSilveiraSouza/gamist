package com.luanss.gamist.core.exception

import java.lang.RuntimeException

class InvalidScoreException(): RuntimeException("Game score needs to be between 0 and 100") {
}