package me.yailya.omega.api.setting.settings

import me.yailya.omega.api.setting.Setting
import me.yailya.omega.api.setting.SettingsContainer

class GroupSetting(
    name: String,
    initialValue: MutableList<Setting<*>>,
    visibility: () -> Boolean = { true }
) : Setting<MutableList<Setting<*>>>(name, initialValue, visibility), SettingsContainer {
    override val settings = mutableListOf<Setting<*>>()
}