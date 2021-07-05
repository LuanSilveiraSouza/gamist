package com.luanss.gamist.core.exception

class InvalidPlayTimeException(): BusinessException("Games with release year in the future cannot have Play Time") {
}