package j0sh.javadungeons.biome;

import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MineshaftFeature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.MineshaftFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.SeaPickleFeatureConfig;
import net.minecraft.world.gen.feature.SingleStateFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import net.minecraft.block.Blocks;

import j0sh.javadungeons.content.*;

public class CreeperWoodsBiome extends Biome {
    public CreeperWoodsBiome() {
        super(new Biome.Settings().configureSurfaceBuilder(SurfaceBuilder.DEFAULT, 
            new TernarySurfaceConfig(
                CreeperWoodsBlocks.CW_GRASS_BLOCK.getDefaultState(), 
                CreeperWoodsBlocks.CW_DIRT.getDefaultState(), 
                CreeperWoodsBlocks.CW_DIRT.getDefaultState()
            ))
            .precipitation(Biome.Precipitation.RAIN).category(Biome.Category.FOREST)
            .depth(0.1F).scale(0.2F).temperature(0.7F).downfall(0.8F)
            .waterColor(4159204).waterFogColor(329011)
            .parent((String)null
        ));


        this.addStructureFeature(Feature.MINESHAFT.configure(new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL)));
        this.addStructureFeature(Feature.STRONGHOLD.configure(FeatureConfig.DEFAULT));
        this.addStructureFeature(Feature.STRONGHOLD.configure(FeatureConfig.DEFAULT));
        
        DefaultBiomeFeatures.addLandCarvers(this);
        DefaultBiomeFeatures.addDefaultStructures(this);

        this.addFeature(GenerationStep.Feature.LOCAL_MODIFICATIONS,
		    Features.DUNGEONS_WATER_LAKE.configure(new SingleStateFeatureConfig(Fluids.DUNGEONS_WATER.getDefaultState()))
            .createDecoratedFeature(Decorator.WATER_LAKE.configure(new ChanceDecoratorConfig(10))));
            
        DefaultBiomeFeatures.addDungeons(this);
        DefaultBiomeFeatures.addForestFlowers(this);

        //DefaultBiomeFeatures.addMineables(this);
        this.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, CreeperWoodsBlocks.CW_DIRT.getDefaultState(), 33)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 256))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Blocks.GRAVEL.getDefaultState(), 33)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(8, 0, 0, 256))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Blocks.GRANITE.getDefaultState(), 33)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 80))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Blocks.DIORITE.getDefaultState(), 33)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 80))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Blocks.ANDESITE.getDefaultState(), 33)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 80))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, 
            Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, CreeperWoodsBlocks.CW_MOSSY_STONE.getDefaultState(), 33))
            .createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 128))));

        DefaultBiomeFeatures.addDefaultOres(this);
        DefaultBiomeFeatures.addDefaultDisks(this);
        DefaultBiomeFeatures.addForestTrees(this);
        DefaultBiomeFeatures.addDefaultFlowers(this);

        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION,
            Features.GLOW_PLANTS.configure(new SeaPickleFeatureConfig(4))
            .createDecoratedFeature(Decorator.CHANCE_HEIGHTMAP.configure(new ChanceDecoratorConfig(3))));

        DefaultBiomeFeatures.addForestGrass(this);
        DefaultBiomeFeatures.addDefaultMushrooms(this);
        DefaultBiomeFeatures.addDefaultVegetation(this);
        DefaultBiomeFeatures.addSprings(this);
        DefaultBiomeFeatures.addFrozenTopLayer(this);

        this.addSpawn(EntityCategory.CREATURE, new Biome.SpawnEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(EntityCategory.CREATURE, new Biome.SpawnEntry(EntityType.PIG, 10, 4, 4));
        this.addSpawn(EntityCategory.CREATURE, new Biome.SpawnEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityCategory.CREATURE, new Biome.SpawnEntry(EntityType.COW, 8, 4, 4));
        this.addSpawn(EntityCategory.CREATURE, new Biome.SpawnEntry(EntityType.WOLF, 5, 4, 4));
        this.addSpawn(EntityCategory.AMBIENT, new Biome.SpawnEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.CREEPER, 100, 4, 16));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.WITCH, 5, 1, 1));
    }
    
    @Override
    public int getGrassColorAt(double x, double z) {
        return 0x408572;
    }
  
    @Override
    public int getFoliageColor() {
        return 0x408572;
    }
}