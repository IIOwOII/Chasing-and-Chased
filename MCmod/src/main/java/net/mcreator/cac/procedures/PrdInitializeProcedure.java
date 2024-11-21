package net.mcreator.cac.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

import net.mcreator.cac.network.CacModVariables;

public class PrdInitializeProcedure {
	public static void execute(LevelAccessor world) {
		CacModVariables.MapVariables.get(world).Pmt_far = 16;
		CacModVariables.MapVariables.get(world).syncData(world);
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Pmt_far = " + new java.text.DecimalFormat("##.##").format(CacModVariables.MapVariables.get(world).Pmt_far))), false);
		CacModVariables.MapVariables.get(world).Pmt_distance_scale = 1;
		CacModVariables.MapVariables.get(world).syncData(world);
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Pmt_distance_scale = " + new java.text.DecimalFormat("##.##").format(CacModVariables.MapVariables.get(world).Pmt_distance_scale))), false);
	}
}
