package j0sh.javadungeons.content;

import j0sh.javadungeons.JavaDungeons;
import j0sh.javadungeons.blocks.*;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class SoggySwampBlocks {

    // ground related
    public static DungeonsBlock SS_GRASS_BLOCK;
    public static DungeonsPath SS_DIRT_PATH;
    public static DungeonsPathable SS_DIRT;

    // stone related
    public static DungeonsBlock SS_MOSSY_STONE;
    public static DungeonsBlock SS_MOSSY_COBBLESTONE;
    public static DungeonsBlock SS_MOSSY_STONE_BRICKS;
    public static DungeonsBlock SS_MOSSY_CHISELED_STONE_BRICKS;

    // swamp tree
    public static DungeonsPillar SS_SWAMP_LOG;
    public static DungeonsLeaves SS_SWAMP_LEAVES;
    public static DungeonsSlabStairBlock SS_SWAMP_PLANKS;

    // bridge related
    public static DungeonsTopSlab SS_BRIDGE_PLANKS;
    public static DungeonsFence SS_ROPE_FENCE;

    public static void init() {
        // ground related
        SS_GRASS_BLOCK = new DungeonsBlock(Material.ORGANIC, 0.6F, 0.6F, BlockSoundGroup.GRASS, JavaDungeons.SOGGY_SWAMP, "ss_grass_block");
        SS_DIRT_PATH = new DungeonsPath(Material.EARTH, 0.5F, 0.5F, BlockSoundGroup.GRAVEL, JavaDungeons.SOGGY_SWAMP, "ss_dirt_path");
        SS_DIRT = new DungeonsPathable(Material.EARTH, 0.5F, 0.5F, BlockSoundGroup.GRAVEL, SS_DIRT_PATH, JavaDungeons.SOGGY_SWAMP, "ss_dirt");

        // stone related
        SS_MOSSY_STONE = new DungeonsBlock(Material.STONE, 1.5F, 6.0F, BlockSoundGroup.STONE, JavaDungeons.SOGGY_SWAMP, "ss_mossy_stone");
        SS_MOSSY_COBBLESTONE = new DungeonsBlock(Material.STONE, 1.5F, 6.0F, BlockSoundGroup.STONE, JavaDungeons.SOGGY_SWAMP, "ss_mossy_cobblestone");
        SS_MOSSY_STONE_BRICKS = new DungeonsBlock(Material.STONE, 1.5F, 6.0F, BlockSoundGroup.STONE, JavaDungeons.SOGGY_SWAMP, "ss_mossy_stone_bricks");
        SS_MOSSY_CHISELED_STONE_BRICKS = new DungeonsBlock(Material.STONE, 1.5F, 6.0F, BlockSoundGroup.STONE, JavaDungeons.SOGGY_SWAMP, "ss_mossy_chiseled_stone_bricks");

        // swamp tree
        SS_SWAMP_LOG = new DungeonsPillar(Material.WOOD, 2.0F, 3.0F, BlockSoundGroup.WOOD, JavaDungeons.SOGGY_SWAMP, "ss_swamp_log");
        SS_SWAMP_LEAVES = new DungeonsLeaves(Material.LEAVES, 0.2F, 0.2F, BlockSoundGroup.GRASS, JavaDungeons.SOGGY_SWAMP, "ss_swamp_leaves");
        SS_SWAMP_PLANKS = new DungeonsSlabStairBlock(Material.WOOD, 2.0F, 3.0F, BlockSoundGroup.WOOD, JavaDungeons.SOGGY_SWAMP, "ss_swamp_planks", "ss_swamp_planks_slab", "ss_swamp_planks_stairs");

        // bridge related
        SS_BRIDGE_PLANKS = new DungeonsTopSlab(Material.WOOD, 2.0F, 3.0F, BlockSoundGroup.WOOD, JavaDungeons.SOGGY_SWAMP, "ss_bridge_planks");
        SS_ROPE_FENCE = new DungeonsFence(Material.WOOD, 2.0F, 3.0F, BlockSoundGroup.WOOD, JavaDungeons.SOGGY_SWAMP, "ss_rope_fence");
    }
}
