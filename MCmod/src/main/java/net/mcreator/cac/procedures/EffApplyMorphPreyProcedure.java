package net.mcreator.cac.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.cac.init.CacModMobEffects;

public class EffApplyMorphPreyProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(CacModMobEffects.EFF_MORPH_PREY.get()))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(CacModMobEffects.EFF_MORPH_PREY.get(), 72000, 0, false, false));
		}
	}
}
