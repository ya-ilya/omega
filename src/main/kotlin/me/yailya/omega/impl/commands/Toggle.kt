package me.yailya.omega.impl.commands

import com.mojang.realmsclient.gui.ChatFormatting
import me.yailya.omega.api.command.Command
import me.yailya.omega.api.managers.ModuleManager

class Toggle : Command("toggle", "Toggles module by name") {
    override fun execute(args: List<String>) {
        if (args.isEmpty()) {
            return send("${ChatFormatting.RED}Please specify module name")
        }

        (ModuleManager[args[0]] ?: return send("${ChatFormatting.RED}Module not found")).toggle()
    }
}