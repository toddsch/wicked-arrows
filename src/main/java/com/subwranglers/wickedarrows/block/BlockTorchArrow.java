package com.subwranglers.wickedarrows.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

import static com.subwranglers.wickedarrows.info.Names.*;

public class BlockTorchArrow extends Block {

    public static final String KEY_HIT_FACE = "hit_face";
    public static final PropertyDirection HIT_FACE = PropertyDirection.create(KEY_HIT_FACE);

    public static final BlockTorchArrow INSTANCE = new BlockTorchArrow();
    public static final ItemBlock INSTANCE_ITEM = new ItemBlock(INSTANCE);

    public BlockTorchArrow() {
        super(Material.CIRCUITS);
        setDefaultState(blockState.getBaseState()
                .withProperty(HIT_FACE, EnumFacing.UP));
        setCreativeTab(CreativeTabs.DECORATIONS);

        String name = name(TORCH_ARROW, BLOCK);
        setUnlocalizedName(name);
        setRegistryName(name);

        setLightOpacity(-2);
        setLightLevel(2.f);

        setTickRandomly(true);
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        // TODO: 11/12/18 spawn flame particles
    }

    @SuppressWarnings("deprecation")
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return NULL_AABB;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, HIT_FACE);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        EnumFacing dir = state.getValue(HIT_FACE);
        return dir.getIndex();
    }

    @SuppressWarnings("deprecation")
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(HIT_FACE, EnumFacing.VALUES[meta]);
    }
}
