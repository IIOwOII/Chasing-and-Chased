package net.mcreator.cac.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;

import net.mcreator.cac.network.CacModVariables;
import net.mcreator.cac.init.CacModMobEffects;

public class PrdTestChasedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		CacModVariables.MapVariables.get(world).Switch_Task = true;
		CacModVariables.MapVariables.get(world).syncData(world);
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(CacModMobEffects.EFF_MORPH_PREY.get()))) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(CacModMobEffects.EFF_MORPH_PREY.get(), 65535, 0, false, false));
		}
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal("Chased Task Test"), false);
	}
}
