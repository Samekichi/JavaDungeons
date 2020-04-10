package j0sh.javadungeons;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.text.TranslatableText;
import net.minecraft.client.MinecraftClient;

import j0sh.javadungeons.blocks.DimensionalRectifier;
import j0sh.javadungeons.container.DimensionalRectifierContainer;
import j0sh.javadungeons.gui.DimensionalRectifierScreen;
import j0sh.javadungeons.content.*;

public class JavaDungeonsClient implements ClientModInitializer {

    private static final RenderLayer CUTOUT_BLOCK_LAYER = RenderLayer.getCutout();

    private static final BlockColorProvider GRASS_BLOCK_COLORS = (state, view, pos, tintIndex) -> {
        return view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : GrassColors.getColor(0.5D, 1.0D);
    };

    private static final ItemColorProvider GRASS_ITEM_COLORS = (item, layer) -> GrassColors.getColor(0.5D, 1.0D);

    @Override
    public void onInitializeClient() {

        // register dimensional rectifier container and GUI
        ScreenProviderRegistry.INSTANCE.<DimensionalRectifierContainer>registerFactory(DimensionalRectifier.ID, (container) -> new DimensionalRectifierScreen(
            container, 
            MinecraftClient.getInstance().player.inventory, 
            DimensionalRectifier.CONTAINER_NAME
        ));

        // register color providers for grass blocks
        ColorProviderRegistry.BLOCK.register(
            GRASS_BLOCK_COLORS, 
            GenericBlocks.SHORT_GRASS, 
            GenericBlocks.GRASS_CLUMP
        );

        // register color providers for grass items
        ColorProviderRegistry.ITEM.register(
            GRASS_ITEM_COLORS,
            GenericBlocks.SHORT_GRASS.blockItem,
            GenericBlocks.GRASS_CLUMP.blockItem
        );

        // register render layers
        BlockRenderLayerMap.INSTANCE.putBlocks(
            CUTOUT_BLOCK_LAYER,
            GenericBlocks.SHORT_GRASS,
            GenericBlocks.GRASS_CLUMP,
            GenericBlocks.WATER_PLANT,
            GenericBlocks.DIMENSIONAL_RECTIFIER
        );
    }
}