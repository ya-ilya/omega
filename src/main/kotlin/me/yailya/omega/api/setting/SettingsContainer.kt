package me.yailya.omega.api.setting

import me.yailya.omega.api.setting.settings.*

interface SettingsContainer {
    val settings: MutableList<Setting<*>>

    fun setting(
        name: String,
        initialValue: Boolean,
        visibility: () -> Boolean = { true }
    ) = setting(BooleanSetting(name, initialValue, visibility))

    fun setting(
        name: String,
        initialValue: Double,
        range: ClosedFloatingPointRange<Double>,
        visibility: () -> Boolean = { true }
    ) = setting(DoubleSetting(name, initialValue, range, visibility))

    fun <T : Enum<T>> setting(
        name: String,
        initialValue: T,
        visibility: () -> Boolean = { true }
    ) = setting(EnumSetting(name, initialValue, visibility))

    fun setting(
        name: String,
        initialValue: Int,
        range: IntRange,
        visibility: () -> Boolean = { true }
    ) = setting(IntegerSetting(name, initialValue, range, visibility))

    fun setting(
        name: String,
        visibility: () -> Boolean = { true }
    ) = setting(GroupSetting(name, mutableListOf(), visibility))

    fun setting(
        name: String,
        initialValue: Int,
        visibility: () -> Boolean = { true }
    ) = setting(BindSetting(name, initialValue, visibility))

    private fun <T : Any> setting(setting: Setting<T>): Setting<T> =
        setting.also { settings.add(it) }
}