package me.yailya.omega.api.setting.settings

class DoubleSetting(
    name: String,
    initialValue: Double,
    range: ClosedFloatingPointRange<Double>,
    visibility: () -> Boolean
) : NumberSetting<Double>(name, initialValue, range, visibility)