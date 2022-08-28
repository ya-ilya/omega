package me.yailya.omega.api.setting.settings

import me.yailya.omega.api.setting.Setting

class BooleanSetting(
    name: String,
    initialValue: Boolean,
    visibility: () -> Boolean = { true }
) : Setting<Boolean>(name, initialValue, visibility)