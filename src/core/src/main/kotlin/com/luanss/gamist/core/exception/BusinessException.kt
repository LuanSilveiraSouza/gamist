package com.luanss.gamist.core.exception

import java.lang.RuntimeException

open class BusinessException(private val msg: String): RuntimeException(msg) {
}