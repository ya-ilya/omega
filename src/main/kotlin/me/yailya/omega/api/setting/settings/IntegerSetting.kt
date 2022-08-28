package me.yailya.omega.api.setting.settings

class IntegerSetting(
    name: String,
    initialValue: Int,
    range: IntRange,
    visibility: () -> Boolean = { true }
) : NumberSetting<Int>(name, initialValue, range, visibility)