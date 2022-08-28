package me.yailya.omega

import me.yailya.omega.api.managers.CommandManager
import me.yailya.omega.api.managers.ModuleManager
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

@Mod(modid = Client.MOD_ID, name = Client.MOD_NAME)
class Client {
    companion object {
        const val MOD_ID = "omega"
        const val MOD_NAME = "Omega Client"

        val logger: Logger = LogManager.getLogger("omega")
    }

    @Mod.EventHandler
    fun onInit(event: FMLInitializationEvent) {
        logger.info("Loading managers...")
        ModuleManager.load()
        CommandManager.load()
        logger.info("Managers loaded!")
    }
}