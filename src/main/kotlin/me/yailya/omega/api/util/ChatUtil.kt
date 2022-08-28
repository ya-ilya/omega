package me.yailya.omega.api.util

import com.mojang.realmsclient.gui.ChatFormatting
import net.minecraft.client.Minecraft
import net.minecraft.util.text.TextComponentString

object ChatUtil {
    private val mc = Minecraft.getMinecraft()

    fun send(message: String) {
        mc.player?.sendMessage(TextComponentString("$message${ChatFormatting.RESET}"))
    }

    fun addToSentMessages(message: String) {
        mc.ingameGUI?.chatGUI?.addToSentMessages(message)
    }
}