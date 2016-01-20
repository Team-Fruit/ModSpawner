package com.kamesuta.mc.modspawner.asm;

import java.util.Map;

import cpw.mods.fml.relauncher.IFMLCallHook;

public class MdspSettingUp implements IFMLCallHook
{
	@Override
	public Void call() throws Exception {
/*		System.out.println("ModSpawner has just setting up mods.");

		File inDir = new File(MdspCorePlugin.minecraftDir, "mod/");
		File outDir = new File(MdspCorePlugin.minecraftDir, "mods/");
		File[] inFiles = inDir.listFiles();
		for( File inFile : inFiles ) {
			File outFile = new File(outDir, inFile.getName());

			inFile.renameTo(outFile);
		}
*/
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
