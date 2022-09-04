package me.yailya.omega.impl.modules.movement

import me.yailya.omega.api.module.Category
import me.yailya.omega.api.module.Module
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.TickEvent

class Sprint : Module("Sprint", Category.Movement) {
    @SubscribeEvent
    fun onTick(event: TickEvent.ClientTickEvent) {
        if (mc.gameSettings.keyBindForward.isKeyDown) {
            mc.player.isSprinting = true
        }
    }
}