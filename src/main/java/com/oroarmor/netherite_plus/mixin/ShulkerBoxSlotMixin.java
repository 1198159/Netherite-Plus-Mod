package com.oroarmor.netherite_plus.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.oroarmor.netherite_plus.block.NetheriteShulkerBoxBlock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.ShulkerBoxSlot;

@Mixin(ShulkerBoxSlot.class)
public class ShulkerBoxSlotMixin {

	@Inject(method = "canInsert", at = @At("HEAD"), cancellable = true)
	public void canInsert(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
		if (Block.getBlockFromItem(stack.getItem()) instanceof NetheriteShulkerBoxBlock) {
			cir.setReturnValue(false);
		}
	}
}
