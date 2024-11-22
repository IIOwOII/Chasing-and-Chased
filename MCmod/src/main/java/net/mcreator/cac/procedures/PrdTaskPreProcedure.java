package net.mcreator.cac.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.cac.network.CacModVariables;

public class PrdTaskPreProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		CacModVariables.MapVariables.get(world).Switch_Task = true;
		CacModVariables.MapVariables.get(world).syncData(world);
		EffApplyMorphPredatorProcedure.execute(entity);
	}
}
