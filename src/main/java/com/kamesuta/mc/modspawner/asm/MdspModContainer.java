package com.kamesuta.mc.modspawner.asm;

import java.util.Arrays;

import com.google.common.eventbus.EventBus;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;

public class MdspModContainer extends DummyModContainer
{
    public MdspModContainer()
    {
        super(new ModMetadata());

        // 他のModと区別するための一意なIDやmodの名前など、MODのメタデータを設定します。
        ModMetadata meta = getMetadata();

        meta.modId       = "modspawner";
        meta.name        = "ModSpawner";
        meta.version     = "1.0.0";
        meta.authorList  = Arrays.asList("Kamesuta");
        meta.description = "Download Mods Automatically";
        meta.url         = "http://mc.kamesuta.com/";
        meta.credits     = "©2015 Kamesuta";
        this.setEnabledState(true);
    }

    @Override
    public boolean registerBus(EventBus bus, LoadController controller)
    {
		bus.register(this);
		return true;
    }
}