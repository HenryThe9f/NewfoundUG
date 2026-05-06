package net.HenryThe9f.foundground.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.HenryThe9f.foundground.Newfound_Underground;
import net.HenryThe9f.foundground.block.ModBlocks;
import net.HenryThe9f.foundground.item.Moditems;
import net.HenryThe9f.foundground.util.ModTags;
import net.HenryThe9f.foundground.util.ModTranslations;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.List;

@JeiPlugin
public class JEIFoundgroundPlugin implements IModPlugin {


    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Newfound_Underground.MODID, "jei_plugin");
    }


    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addIngredientInfo(new ItemStack(Moditems.BLINDING_STEW.get()), VanillaTypes.ITEM_STACK, ModTranslations.getTranslation("jei.info.stew"));
        registration.addIngredientInfo(new ItemStack(Moditems.GOLD_SPORES.get()), VanillaTypes.ITEM_STACK, ModTranslations.getTranslation("jei.info.spectral_charge"));
        registration.addIngredientInfo(new ItemStack(Moditems.WHELP_TORCH.get()), VanillaTypes.ITEM_STACK, ModTranslations.getTranslation("jei.info.whelp_torch"));
        registration.addIngredientInfo(new ItemStack(ModBlocks.LAPIS_LANTERN.get().asItem()), VanillaTypes.ITEM_STACK, ModTranslations.getTranslation("jei.info.lapis_lantern"));
        registration.addIngredientInfo(new ItemStack(ModBlocks.IRON_ROSE.get().asItem()), VanillaTypes.ITEM_STACK, ModTranslations.getTranslation("jei.info.iron_rose"));

        registration.addIngredientInfo(List.of(new ItemStack(ModBlocks.BEDROCK_FUNGUS_STEM.get().asItem()), new ItemStack(ModBlocks.BEDROCK_FUNGUS_CAP.get().asItem())), VanillaTypes.ITEM_STACK, ModTranslations.getTranslation("jei.info.bedrock_fungus"));
        registration.addIngredientInfo(List.of(new ItemStack(ModBlocks.CYAN_MUSHROOM.get().asItem()), new ItemStack(ModBlocks.CYANSTONE.get().asItem())), VanillaTypes.ITEM_STACK, ModTranslations.getTranslation("jei.info.cyan_mushroom"));
        registration.addIngredientInfo(List.of(new ItemStack(Moditems.WHELP_SPAWN_EGG.get()), new ItemStack(Moditems.RAW_WHELP.get()), new ItemStack(Moditems.WHELP_FUR.get().asItem())), VanillaTypes.ITEM_STACK, ModTranslations.getTranslation("jei.info.whelp"));
        registration.addIngredientInfo(List.of(new ItemStack(ModBlocks.PETRIFIED_ROOT.get().asItem())), VanillaTypes.ITEM_STACK, ModTranslations.getTranslation("jei.info.petrified"));
    }



}
