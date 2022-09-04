package me.yailya.omega.api.command

import me.yailya.omega.api.util.ChatUtil

abstract class Command(
    val name: String,
    val description: String = "None"
) {
    abstract fun execute(args: List<String>)

    fun send(message: String) = ChatUtil.send(message)
}