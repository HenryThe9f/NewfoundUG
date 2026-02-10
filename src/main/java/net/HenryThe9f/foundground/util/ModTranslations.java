package net.HenryThe9f.foundground.util;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class ModTranslations {
    public ModTranslations() {}
    public static MutableComponent getTranslation(String key, Object... args) {
        return Component.translatable("foundground." + key, args);
    }
}