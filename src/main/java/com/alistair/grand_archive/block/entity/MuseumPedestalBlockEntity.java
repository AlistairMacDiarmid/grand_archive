package com.alistair.grand_archive.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class MuseumPedestalBlockEntity extends BlockEntity {
    private boolean isUnlocked = false;
    private Identifier targetItemId = Identifier.fromNamespaceAndPath("minecraft", "diamond");

    public MuseumPedestalBlockEntity(BlockPos pos, BlockState state) {
        this(ModBlockEntities.MUSEUM_PEDESTAL_BLOCK_ENTITY, pos, state);
    }

    public MuseumPedestalBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public boolean isUnlocked() {
        return this.isUnlocked;
    }

    public void setUnlocked(boolean unlocked) {
        this.isUnlocked = unlocked;
        setChanged();
    }

    public Identifier getTargetItemId() {
        return this.targetItemId;
    }

    public void setTargetItemId(Identifier targetItemId) {
        this.targetItemId = targetItemId;
        setChanged();
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.isUnlocked = input.getBooleanOr("isUnlocked", false);
        this.targetItemId = Identifier.parse(input.getStringOr("targetItemId", "minecraft:diamond"));
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putBoolean("isUnlocked", this.isUnlocked);
        output.putString("targetItemId", this.targetItemId.toString());
    }

    public boolean tryUnlock(ItemStack stack) {
        if (!this.isUnlocked && !stack.isEmpty()) {
            Identifier stackItemId = BuiltInRegistries.ITEM.getKey(stack.getItem());
            if (this.targetItemId.equals(stackItemId)) {
                this.isUnlocked = true;
                setChanged();
                return true;
            }
        }
        return false;
    }
}
