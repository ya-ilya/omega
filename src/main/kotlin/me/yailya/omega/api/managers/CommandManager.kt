package me.yailya.omega.api.managers

import com.mojang.realmsclient.gui.ChatFormatting
import me.yailya.omega.api.command.Command
import me.yailya.omega.api.util.ChatUtil
import me.yailya.omega.impl.commands.Toggle
import net.minecraftforge.client.event.ClientChatEvent
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

object CommandManager {
    private val commands = mutableListOf<Command>()
    private const val PREFIX = "."

    init {
        MinecraftForge.EVENT_BUS.register(this)
    }

    fun load() {
        commands.clear()
        commands.add(
            Toggle()
        )
    }

    @SubscribeEvent
    fun onChat(event: ClientChatEvent) {
        val args = event.message.split(" ")

        if (args[0].startsWith(PREFIX)) {
            commands.firstOrNull { it.name == args[0].removePrefix(PREFIX) }?.execute(args.drop(1))
                ?: ChatUtil.send("${ChatFormatting.RED}Command not found.")

            ChatUtil.addToSentMessages(event.message)
            event.isCanceled = true
        }
    }
}