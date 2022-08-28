package me.yailya.omega.api.setting.settings

import me.yailya.omega.api.setting.Setting

class EnumSetting<T : Enum<T>>(
    name: String,
    initialValue: T,
    visibility: () -> Boolean
) : Setting<T>(name, initialValue, visibility) {
    private val values = value.javaClass.enumConstants

    fun next() {
        value = values[values.indexOf(value) + 1] ?: values[0]
    }

    fun prev() {
        value = values[values.indexOf(value) - 1] ?: values.last()
    }
}