package me.yailya.omega.api.module

import me.yailya.omega.api.setting.Setting
import me.yailya.omega.api.setting.SettingsContainer
import net.minecraft.client.Minecraft
import net.minecraftforge.common.MinecraftForge
import org.lwjgl.input.Keyboard

abstract class Module(
    val name: String,
    val description: String,
    val category: Category
) : SettingsContainer {
    companion object {
        val mc: Minecraft = Minecraft.getMinecraft()
    }

    override val settings = mutableListOf<Setting<*>>()

    var enabled = false
        set(value) {
            field = value

            if (value) {
                MinecraftForge.EVENT_BUS.register(this)
                onEnable()
            } else {
                MinecraftForge.EVENT_BUS.unregister(this)
                onDisable()
            }
        }

    val bind = setting("Bind", Keyboard.KEY_NONE)

    constructor(name: String, category: Category) : this(name, "", category)

    open fun onEnable() { }
    open fun onDisable() { }

    fun toggle() {
        enabled = !enabled
    }
}