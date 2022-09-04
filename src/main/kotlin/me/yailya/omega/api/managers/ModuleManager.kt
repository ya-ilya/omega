package me.yailya.omega.api.managers

import me.yailya.omega.api.module.Module
import me.yailya.omega.impl.modules.movement.Sprint
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.InputEvent
import org.lwjgl.input.Keyboard

object ModuleManager {
    val modules = mutableListOf<Module>()

    init {
        MinecraftForge.EVENT_BUS.register(this)
    }

    fun load() {
        modules.forEach { it.enabled = false }
        modules.clear()
        modules.addAll(listOf(
            Sprint()
        ))
    }

    @SubscribeEvent
    fun onKey(event: InputEvent.KeyInputEvent) {
        if (Keyboard.getEventKeyState()) {
            val key = Keyboard.getEventKey()

            modules
                .filter { it.bind.value == key }
                .forEach { it.toggle() }
        }
    }

    @JvmName("getByName")
    operator fun get(name: String) =
        modules.firstOrNull { it.name.lowercase() == name.lowercase() }
}