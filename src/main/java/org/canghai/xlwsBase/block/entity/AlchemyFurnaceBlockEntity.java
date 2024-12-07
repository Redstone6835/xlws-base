package org.canghai.xlwsBase.block.entity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import org.canghai.xlwsBase.block.BlockEntityTypes;
import org.canghai.xlwsBase.block.screen.AlchemyFurnaceScreenHandler;

public class AlchemyFurnaceBlockEntity  extends BlockEntity implements NamedScreenHandlerFactory,ImplementedInventory {
    private DefaultedList<ItemStack> inputStacks;

    public AlchemyFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityTypes.ALCHEMY_FURNACE, pos, state);
        this.inputStacks = DefaultedList.ofSize(9, ItemStack.EMPTY);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inputStacks;
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inputStacks, registryLookup);
    }

    @Override
    public void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.writeNbt(nbt, inputStacks, registryLookup);
        super.writeNbt(nbt, registryLookup);
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new AlchemyFurnaceScreenHandler(syncId, playerInventory, this);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public int size() {
        return 3 * 3;
    }

    @Override
    public void markDirty() {
        super.markDirty();
    }
}
