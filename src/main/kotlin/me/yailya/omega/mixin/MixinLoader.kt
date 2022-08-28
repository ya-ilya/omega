package me.yailya.omega.mixin

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin
import org.spongepowered.asm.launch.MixinBootstrap
import org.spongepowered.asm.mixin.MixinEnvironment
import org.spongepowered.asm.mixin.Mixins

class MixinLoader : IFMLLoadingPlugin {
    init {
        MixinBootstrap.init()
        Mixins.addConfiguration("mixins.omega.json")
        MixinEnvironment.getDefaultEnvironment().obfuscationContext = "searge"
    }

    override fun getModContainerClass() = null
    override fun getSetupClass() = null
    override fun getAccessTransformerClass() = null
    override fun getASMTransformerClass() = null
    override fun injectData(data: MutableMap<String, Any>?) {}
}