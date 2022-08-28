package me.yailya.omega.api.setting

@Suppress("MemberVisibilityCanBePrivate", "CanBeParameter")
abstract class Setting<T : Any>(
    val name: String,
    val initialValue: T,
    val visibility: () -> Boolean = { true }
) {
    var value: T = initialValue
}