package me.yailya.omega.impl.commands

import com.mojang.realmsclient.gui.ChatFormatting
import me.yailya.omega.api.command.Command
import me.yailya.omega.api.managers.ModuleManager

class Modules : Command("modules", "Sends all modules in the client") {
    override fun execute(args: List<String>) {
        val modules = mutableListOf<String>()

        for (module in ModuleManager.modules) {
            modules.add("${if (module.enabled) ChatFormatting.GREEN else ChatFormatting.RED}" +
                    module.name +
                    "${ChatFormatting.RESET}")
        }

        send("Modules: ${modules.joinToString()}")
    }
}