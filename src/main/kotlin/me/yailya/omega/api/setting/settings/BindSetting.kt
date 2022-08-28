package me.yailya.omega.api.setting.settings

import me.yailya.omega.api.setting.Setting

class BindSetting(
    name: String,
    initialValue: Int,
    visibility: () -> Boolean = { true }
) : Setting<Int>(name, initialValue, visibility)