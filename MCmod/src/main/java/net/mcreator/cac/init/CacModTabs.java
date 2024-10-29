
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cac.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.CreativeModeTabEvent;

import net.minecraft.world.item.CreativeModeTabs;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CacModTabs {
	@SubscribeEvent
	public static void buildTabContentsVanilla(CreativeModeTabEvent.BuildContents tabData) {

		if (tabData.getTab() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
			tabData.accept(CacModItems.CAC_TEST_ITEM.get());
		}

		if (tabData.getTab() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(CacModItems.ENT_CAT_SPAWN_EGG.get());
		}
	}
}
