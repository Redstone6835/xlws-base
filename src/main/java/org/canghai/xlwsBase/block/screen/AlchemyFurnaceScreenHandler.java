package org.canghai.xlwsBase.block.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import org.canghai.xlwsBase.XlwsBase;
import org.canghai.xlwsBase.api.Registries;
import org.canghai.xlwsBase.block.entity.AlchemyFurnaceBlockEntity;

public class AlchemyFurnaceScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    // 服务器想要客户端开启 screenHandler 时，客户端调用这个构造器。
    // 如有空的物品栏，客户端会调用其他构造器，screenHandler 将会自动
    // 在客户端将空白物品栏同步给物品栏。
    public AlchemyFurnaceScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(9));
    }

    // 这个构造器是在服务器的 BlockEntity 中被调用的，无需先调用其他构造器，服务器知道容器的物品栏
    // 并直接将其作为参数传入。然后物品栏在客户端完成同步。
    public AlchemyFurnaceScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ScreenHandlerType.CRAFTER_3X3, syncId);
        checkSize(inventory, 9);
        this.inventory = inventory;
        // 玩家开启时，一些物品栏有自定义的逻辑。
        inventory.onOpen(playerInventory.player);

        // 这会将槽位放置在 3×3 网格的正确位置中。这些槽位在客户端和服务器中都存在！
        // 但是这不会渲染槽位的背景，这是 Screens 类的工作
        int m;
        int l;
        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 3; ++l) {
                this.addSlot(new Slot(inventory, l + m * 3, 62 + l * 18, 17 + m * 18));
            }
        }
        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + m * 9 + 9, 8 + l * 18, 84 + m * 18));
            }
        }
        for (m = 0; m < 9; ++m) {
            this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 142));
        }

    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

}