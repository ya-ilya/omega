package me.yailya.omega.api.setting.settings

import me.yailya.omega.api.setting.Setting

open class NumberSetting<T>(
    name: String,
    initialValue: T,
    private val range: ClosedRange<T>,
    visibility: () -> Boolean = { true }
) : Setting<T>(name, initialValue, visibility) where T : Number, T : Comparable<T> {
    val min: T get() = range.start
    val max: T get() = range.endInclusive
}