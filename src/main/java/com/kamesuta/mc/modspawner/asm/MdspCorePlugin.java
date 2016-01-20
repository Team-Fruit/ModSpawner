package com.kamesuta.mc.modspawner.asm;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarFile;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.asm.transformers.ModAccessTransformer;
import cpw.mods.fml.relauncher.FMLInjectionData;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;

@IFMLLoadingPlugin.Name(value = "ModSpawner") // The readable mod name
@IFMLLoadingPlugin.MCVersion(value = "1.7.10") // The MC version it is designed for (Remember? Upwards/Downwards compatibility lost!)
@TransformerExclusions({"com.kamesuta.mc.modspawner.asm"})
@IFMLLoadingPlugin.SortingIndex(value = 1001) // How early your core mod is called - Use > 1000 to work with srg names
public class MdspCorePlugin implements IFMLLoadingPlugin
{
	public static File minecraftDir;

	public MdspCorePlugin()
	{
		minecraftDir = (File) FMLInjectionData.data()[6];

		LogManager.getLogger("ModSpawner").log(Level.INFO, "ModSpawner has just setting up mods.");

		//throw new RuntimeException("TestException");

		File inDir = new File(MdspCorePlugin.minecraftDir, "mod/");

//		File outDir = new File(MdspCorePlugin.minecraftDir, "mods/");
		File[] inFiles = inDir.listFiles();
		for( File inFile : inFiles ) {
//			File outFile = new File(outDir, inFile.getName());

//			inFile.renameTo(outFile);

			LogManager.getLogger("ModSpawner").log(Level.INFO, isCoreMod(inFile));
		}

	}

    /**
     * Check FMLCorePlugin attributes
     */
    public boolean isCoreMod(File coreMod)
    {
        JarFile jar = null;
        Attributes mfAttributes;
        try {
            jar = new JarFile(coreMod);
            if (jar.getManifest() == null)
                return false;

            ModAccessTransformer.addJar(jar);
            mfAttributes = jar.getManifest().getMainAttributes();
        } catch (IOException ioe) {
            return false;
        } finally {
            try {
                if (jar != null) jar.close();
            } catch (IOException ignored) {}
        }

        String fmlCorePlugin = mfAttributes.getValue("FMLCorePlugin");
        return (fmlCorePlugin != null);
    }

	// coremod の jar ファイルのパス抽象表現を保持します。
	public static File location;

	// このプラグインが動作するために必要となるライブラリセットのクラス名の配列です。
	// 本チュートリアルでは使用しないため説明は割愛します。
	// インターフェイスの javadocや、FMLCorePlugin クラスの実装を参照してみてください。

	@Override
	public String getAccessTransformerClass()
	{
		return null;
	}

	// Class の改変機能を実装したクラスの完全修飾名の配列を返します。
	// 本チュートリアルの変換処理クラスは TutorialTransformer のみなので、一つだけを配列に詰め返却しています。

	@Override
	public String[] getASMTransformerClass()
	{
		return null;
	}

	// coremod の名前やバージョン情報を格納しているクラスの完全修飾名を返します。

	@Override
	public String getModContainerClass()
	{
		return "com.kamesuta.mc.modspawner.asm.MdspModContainer";
	}

	// IFMLCallHook を実装しているクラス名を返す必要があります。
	// 本チュートリアルでは、コールフックを用いないため、こちらの説明も割愛します。

	@Override
	public String getSetupClass()
	{
		return "com.kamesuta.mc.modspawner.asm.MdspSettingUp";
	}

	// IFMLLoadingPlugin のメソッドです。(IFMLCallHook にも同じシグネチャーのメソッドがありますが、違います)
	// 今回は coremod 自身の jar ファイルパスを取得しています。これは後述のトランスフォーマークラスで、
	// jarから置換用クラスを取得しているためで、そのような処理を行わないのであれば何も実装しなくても構いません。
	//
	// なお、IFMLLoadingPlugin のメソッドとして呼ばれた際は、"mcLocation"、"coremodList"、"coremodLocation" の3つ、
	// IFMLCallHook のメソッドとして呼ばれた際は、"classLoader" がマップに設定されています。(FML#511現在)
	//
	// 渡されるマップの中身は、cpw.mods.fml.relauncher.RelaunchLibraryManager の実装からも確認する事が出来ます。

	@Override
	public void injectData(Map<String, Object> data)
	{
		if (data.containsKey("coremodLocation"))
		{
			location = (File) data.get("coremodLocation");
		}
	}
	
	public static void exit(int exitCode)
	{
		FMLCommonHandler handle = null;
		try {
			// If the FMLCommonHandler class is not loaded, do ignore!
			handle = FMLCommonHandler.instance();
		} catch (ExceptionInInitializerError e) {
		}
		
		if (handle != null)
		{
			handle.exitJava(exitCode, false);
		}
		else
		{
			System.exit(exitCode);
		}
	}
}