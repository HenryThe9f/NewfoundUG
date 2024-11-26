package net.HenryThe9f.foundground.datagen.loot;

import net.HenryThe9f.foundground.block.ModBlocks;
import net.HenryThe9f.foundground.item.Moditems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.MUSHROOM_PLANKS.get());
        this.dropSelf(ModBlocks.MUSHROOM_SLAB.get());
        this.dropSelf(ModBlocks.MUSHROOM_STAIRS.get());
        this.dropSelf(ModBlocks.MUSHROOM_BUTTON.get());
        this.dropSelf(ModBlocks.MUSHROOM_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.MUSHROOM_TRAPDOOR.get());
        this.dropSelf(ModBlocks.MUSHROOM_DOOR.get());
        this.dropSelf(ModBlocks.MUSHROOM_FENCE.get());
        this.dropSelf(ModBlocks.MUSHROOM_FENCE_GATE.get());
        this.dropSelf(ModBlocks.SMORGASBOARDS.get());
        this.dropSelf(ModBlocks.SMORGLASS.get());
        this.dropSelf(ModBlocks.SMORGLASS_PANE.get());
        this.dropSelf(ModBlocks.SMORG_STAIRS.get());
        this.dropSelf(ModBlocks.SMORG_SLAB.get());
        this.dropSelf(ModBlocks.SMORG_WALL.get());
        this.dropSelf(ModBlocks.SMORG_BUTTON.get());
        this.dropSelf(ModBlocks.SMORG_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.CAVE_HYPHAE.get());
        this.dropSelf(ModBlocks.STRIPPED_CAVE_HYPHAE.get());
        this.dropSelf(ModBlocks.CAVE_STEM.get());
        this.dropSelf(ModBlocks.STRIPPED_CAVE_STEM.get());
        this.dropSelf(ModBlocks.CAVE_MUSHROOM.get());
        this.dropSelf(ModBlocks.DEEP_MUSHROOM.get());
        this.dropSelf(ModBlocks.PALE_MUSHROOM.get());
        this.dropSelf(ModBlocks.CYAN_MUSHROOM.get());
        this.dropSelf(ModBlocks.SHROOMITE_LAUNCHER.get());
        this.dropSelf(ModBlocks.GOLD_LAUNCHER.get());
        this.dropSelf(ModBlocks.GOLD_MUSHROOM.get());
        this.dropSelf(ModBlocks.LEAD_MUSHROOM.get());
        this.dropSelf(ModBlocks.TALL_CAVE_MUSHROOM.get());
        this.dropSelf(ModBlocks.TALL_PALE_MUSHROOM.get());
        this.dropSelf(ModBlocks.TALL_CYAN_MUSHROOM.get());
        this.dropSelf(ModBlocks.TALL_DEEP_MUSHROOM.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
