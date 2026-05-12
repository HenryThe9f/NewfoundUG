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
        registration.addIngredientInfo(List.of(new ItemStack(ModBlocks.PETRIFIED_ROOT.get().asItem()), new ItemStack(ModBlocks.ROOT_IRON_ORE.get().asItem())), VanillaTypes.ITEM_STACK, ModTranslations.getTranslation("jei.info.petrified"));
        registration.addIngredientInfo(List.of(new ItemStack(ModBlocks.FORBIDDEN_FRUIT_ORE.get().asItem()), new ItemStack(Moditems.FORBIDDEN_FRUIT.get())), VanillaTypes.ITEM_STACK, ModTranslations.getTranslation("jei.info.forbidden"));
        registration.addIngredientInfo(List.of(new ItemStack(ModBlocks.DENSE_COAL_ORE.get().asItem()), new ItemStack(Moditems.COAL_DUST_BOTTLE.get()), new ItemStack(ModBlocks.DEEPSLATE_DENSE_COAL_ORE.get().asItem()) ), VanillaTypes.ITEM_STACK, ModTranslations.getTranslation("jei.info.coal"));
        registration.addIngredientInfo(List.of(new ItemStack(Moditems.GNOME_ITEM.get())), VanillaTypes.ITEM_STACK, ModTranslations.getTranslation("jei.info.gnome"));
        registration.addIngredientInfo(List.of(new ItemStack(ModBlocks.BEDROCK_MYCELIUM.get().asItem()), new ItemStack(ModBlocks.BEDROCK_MYCELIUM_ALTAR.get().asItem())), VanillaTypes.ITEM_STACK, ModTranslations.getTranslation("jei.info.mycelium"));
        registration.addIngredientInfo(List.of(new ItemStack(Moditems.SULPHUR.get())), VanillaTypes.ITEM_STACK, ModTranslations.getTranslation("jei.info.sulphur"));
        registration.addIngredientInfo(List.of(new ItemStack(Moditems.SULPHUR_DUST_BOTTLE.get())), VanillaTypes.ITEM_STACK, ModTranslations.getTranslation("jei.info.sulphur_dust"));
        registration.addIngredientInfo(List.of(new ItemStack(Moditems.LAPIS_STAMP.get())), VanillaTypes.ITEM_STACK, ModTranslations.getTranslation("jei.info.stamp"));
        registration.addIngredientInfo(List.of(new ItemStack(ModBlocks.PUNCHER.get().asItem())), VanillaTypes.ITEM_STACK, ModTranslations.getTranslation("jei.info.puncher"));
        registration.addIngredientInfo(List.of(new ItemStack(ModBlocks.BONY_FARMLAND_HEAD.get().asItem()), new ItemStack(ModBlocks.BONY_FARMLAND.get().asItem())), VanillaTypes.ITEM_STACK, ModTranslations.getTranslation("jei.info.bone_trough"));
        registration.addIngredientInfo(List.of(new ItemStack(Moditems.ROGERFISH_BUCKET.get()),  new ItemStack(Moditems.ROGERFISH_SKULL.get()), new ItemStack(Moditems.ROGERFISH_SPAWN_EGG.get())),VanillaTypes.ITEM_STACK, ModTranslations.getTranslation("jei.info.rogerfish"));
        registration.addIngredientInfo(List.of(new ItemStack(Moditems.CLIMBING_CLAWS.get()),  new ItemStack(Moditems.BROKEN_CLIMBING_CLAWS.get())), VanillaTypes.ITEM_STACK, ModTranslations.getTranslation("jei.info.climbing_claws"));

    }



}
