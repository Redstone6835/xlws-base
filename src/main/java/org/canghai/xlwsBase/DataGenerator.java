package org.canghai.xlwsBase;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.JsonKeySortOrderCallback;
import net.minecraft.data.DataProvider;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import org.canghai.xlwsBase.world.TestDimension;
import org.jetbrains.annotations.Nullable;

public class DataGenerator implements DataGeneratorEntrypoint {

    /**
     * 在此入口点，向 {@link FabricDataGenerator} 注册 {@link DataProvider}。
     *
     * @param fabricDataGenerator {@link FabricDataGenerator} 实例。
     */
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(WorldGenerator::new);

    }

    /**
     * 返回为其生成数据的 Mod 的 Mod ID。
     *
     * @return {@link String} 或 {@code null}
     * @throws RuntimeException 如果 mod ID 不存在。
     */
    @Override
    public @Nullable String getEffectiveModId() {
        return DataGeneratorEntrypoint.super.getEffectiveModId();
    }

    /**
     * 构建包含要生成的动态注册表项的注册表。
     * 用户应调用 {@link RegistryBuilder#addRegistry(RegistryKey, RegistryBuilder.BootstrapFunction)}
     * 注册引导函数，该函数将添加要生成的注册表项。
     *
     * <p>这是异步调用的。
     *
     * @param registryBuilder 一个 {@link RegistryBuilder} 实例。
     */
    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.DIMENSION_TYPE, TestDimension::initialize);
        DataGeneratorEntrypoint.super.buildRegistry(registryBuilder);
    }

    /**
     * 提供设置生成的 JSON 文件中对象键排序优先级的回调。
     *
     * @param callback 设置给定 key 排序优先级的回调。
     */
    @Override
    public void addJsonKeySortOrders(JsonKeySortOrderCallback callback) {
        DataGeneratorEntrypoint.super.addJsonKeySortOrders(callback);
    }
}
