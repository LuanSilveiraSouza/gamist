package com.luanss.gamist.core.exception

class InvalidReleaseYearException(): BusinessException("Release Year cannot be a value below 1970") {
}