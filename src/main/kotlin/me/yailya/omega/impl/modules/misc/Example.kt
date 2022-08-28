package me.yailya.omega.impl.modules.misc

import me.yailya.omega.Client
import me.yailya.omega.api.module.Category
import me.yailya.omega.api.module.Module

class Example : Module("Example", Category.Misc) {
    override fun onEnable() {
        Client.logger.info("Example module enabled")
    }

    override fun onDisable() {
        Client.logger.info("Example module disabled")
    }
}