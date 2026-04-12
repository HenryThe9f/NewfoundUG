package net.HenryThe9f.foundground.util;

import net.HenryThe9f.foundground.Newfound_Underground;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static net.minecraft.tags.TagEntry.tag;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> STONE_ROOTABLE = tag("stone_rootable");
        public static final TagKey<Block> DEEPSLATE_ROOTABLE = tag("deepslate_rootable");
        public static final TagKey<Block> NETHER_ROOTABLE = tag("nether_rootable");
        public static final TagKey<Block> END_ROOTABLE = tag("end_rootable");
        public static final TagKey<Block> IGNITES_GAS = tag("ignites_gas");
        public static final TagKey<Block> SULPHUR_CRYSTALIZER = tag("sulphur_crystalizer");
        public static final TagKey<Block> SULPHUR_GASSY = tag("sulphur_gassy");
        public static final TagKey<Block> COAL_GASSY = tag("coal_gassy");

        public static final TagKey<Block> PUNCHER_ADDITIONAL_WHITELIST = tag("puncher_additional_whitelist");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Newfound_Underground.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> WHELP_FOOD = tag("whelp_food");

        public static final TagKey<Item> IGNITES_GAS_ITEM = tag("ignites_gas_item");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Newfound_Underground.MODID, name));
        }
    }

    public static class Entities {

        public static final TagKey<EntityType<?>> AMBER_EGG_MOBS = tag("amber_egg_mobs");

        private static TagKey<EntityType<?>> tag(String name) {
            return EntityTypeTags.create(new ResourceLocation(Newfound_Underground.MODID, name).toString());
        }
    }
}
//'create(java.lang.String)' has private access in 'net.minecraft.tags.EntityTypeTags'