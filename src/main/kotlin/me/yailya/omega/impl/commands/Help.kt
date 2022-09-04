package me.yailya.omega.impl.commands

import me.yailya.omega.api.command.Command
import me.yailya.omega.api.managers.CommandManager

class Help : Command("help", "Sends info about of all commands in the client") {
    override fun execute(args: List<String>) {
        send("Commands:")

        for (command in CommandManager.commands) {
            send("${CommandManager.PREFIX}${command.name} - ${command.description}")
        }
    }
}