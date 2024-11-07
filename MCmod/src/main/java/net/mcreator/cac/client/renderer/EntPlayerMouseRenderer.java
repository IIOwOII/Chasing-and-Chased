
package net.mcreator.cac.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SilverfishModel;

import net.mcreator.cac.entity.EntPlayerMouseEntity;

public class EntPlayerMouseRenderer extends MobRenderer<EntPlayerMouseEntity, SilverfishModel<EntPlayerMouseEntity>> {
	public EntPlayerMouseRenderer(EntityRendererProvider.Context context) {
		super(context, new SilverfishModel(context.bakeLayer(ModelLayers.SILVERFISH)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(EntPlayerMouseEntity entity) {
		return new ResourceLocation("cac:textures/entities/silverfish.png");
	}
}
