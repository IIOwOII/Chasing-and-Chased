
package net.mcreator.cac.command;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.Commands;

import net.mcreator.cac.procedures.PrdIntroductionProcedure;

import com.mojang.brigadier.arguments.StringArgumentType;

@Mod.EventBusSubscriber
public class CmdIntroductionCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("cac_introduction")

				.then(Commands.argument("task_name", StringArgumentType.word()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					PrdIntroductionProcedure.execute();
					return 0;
				})));
	}
}
