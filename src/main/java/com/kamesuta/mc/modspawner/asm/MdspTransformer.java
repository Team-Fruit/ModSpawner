package com.kamesuta.mc.modspawner.asm;

import org.objectweb.asm.Opcodes;

import net.minecraft.launchwrapper.IClassTransformer;

// Opcodes : インプリメントすると、ASMによるバイトコード定数にアクセスするのに便利です。
// 必須ではありません。不用な場合は implements から削除してください。

public class MdspTransformer implements IClassTransformer, Opcodes
{
    // 改変対象のクラスの完全修飾名です。
    // 後述でMinecraft.jar内の難読化されるファイルを対象とする場合の簡易な取得方法を紹介します。
    //private static final String TARGET_CLASS_NAME = "net.minecraft.src.TargetClass";

    // クラスがロードされる際に呼び出されるメソッドです。
    @Override
    public byte[] transform(String name, String tname, byte[] bytes)
    {
        // FMLRelauncher.side() : Client/Server どちらか一方のを対象とする場合や、
        // 一つのMODで Client/Sever 両方に対応したMODで、この値を判定して処理を変える事ができます。
        // 今回は"CLIENT"と比較し、Client側のファイルを対象としている例です。
        // Client側専用のMODとして公開するのであれば、判定は必須ではありません。

        // name : 現在ロードされようとしているクラス名が格納されています。
/*        if (!FMLRelauncher.side().equals("CLIENT") || !name.equals(TARGET_CLASS_NAME))
        {
            // 処理対象外なので何もしない
            return bytes;
        }
*/
        try
        {
        	//System.out.println("ModSpawner!!");
            // --------------------------------------------------------------
            // クラスファイル丸ごと差し替える場合
            // --------------------------------------------------------------
            // return replaceClass(bytes);

            // --------------------------------------------------------------
            // ASMを使用し、既存のクラスファイルに改変を施す場合。
            // --------------------------------------------------------------
            // return hookDoRenderLivingMethod(bytes);
        	return bytes;

        }
        catch (Exception e)
        {
            throw new RuntimeException("failed : TutorialTransformer loading", e);
        }
    }

/*    // 下記の想定で実装されています。
    // 対象クラスの bytes を ModifiedTargetClass.class ファイルに置き換える
    private byte[] replaceClass(byte[] bytes) throws IOException
    {
        ZipFile zf = null;
        InputStream zi = null;

        try
        {
            zf = new ZipFile(TutorialCorePlugin.location);

            // 差し替え後のファイルです。coremodのjar内のパスを指定します。
            ZipEntry ze = zf.getEntry("ModifiedTargetClass.class");

            if (ze != null)
            {
                zi = zf.getInputStream(ze);
                int len = (int) ze.getSize();
                bytes = new byte[len];

                // ヒープサイズを超えないように、ストリームからファイルを1024ずつ読み込んで bytes に格納する
                int MAX_READ = 1024;
                int readed = 0, readsize, ret;
                while(readed < len) {
                    readsize = MAX_READ;
                    if (len - readed < MAX_READ ) {
                        readsize = len - readed;
                    }
                    ret = zi.read(bytes, readed, readsize);
                    if (ret == -1) break;
                    readed += ret;
                }
            }

            return bytes;
        }
        finally
        {
            if (zi != null)
            {
                zi.close();
            }

            if (zf != null)
            {
                zf.close();
            }
        }
    }

    // 下記の想定で実装されています。
    // EntityLiving.class の doRenderLiving の先頭に
    // tutorial/test.class の passTestRender(EntityLiving, double, double, double)メソッドの呼び出しを追加する。
    private byte[] hookDoRenderLivingMethod(byte[] bytes)
    {
        // ASMで、bytesに格納されたクラスファイルを解析します。
        ClassNode cnode = new ClassNode();
        ClassReader reader = new ClassReader(bytes);
        reader.accept(cnode, 0);

        // 改変対象のメソッド名です
        String targetMethodName = "doRenderLiving";

        // 改変対象メソッドの戻り値型および、引数型をあらわします　※１
        String targetMethoddesc = "(Lnet/minecraft/entity/EntityLiving;DDDFF)V";

        // 対象のメソッドを検索取得します。
        MethodNode mnode = null;
        for (MethodNode curMnode : (List<MethodNode>) cnode.methods)
        {
            if (targetMethodName.equals(curMnode.name) && targetMethoddesc.equals(curMnode.desc))
            {
                mnode = curMnode;
                break;
            }
        }

        if (mnode != null)
        {
            InsnList overrideList = new InsnList();

            // メソッドコールを、バイトコードであらわした例です。
            overrideList.add(new VarInsnNode(ALOAD, 1));
            overrideList.add(new VarInsnNode(DLOAD, 2));
            overrideList.add(new VarInsnNode(DLOAD, 4));
            overrideList.add(new VarInsnNode(DLOAD, 6));
            overrideList
                    .add(new MethodInsnNode(INVOKESTATIC, "tutorial/test", "passTestRender", "(LEntityLiving;DDD)V"));

            // mnode.instructions.get(1)で、対象のメソッドの先頭を取得
            // mnode.instructions.insertで、指定した位置にバイトコードを挿入します。
            mnode.instructions.insert(mnode.instructions.get(1), overrideList);

            // 改変したクラスファイルをバイト列に書き出します
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
            cnode.accept(cw);
            bytes = cw.toByteArray();
        }

        return bytes;
    }
*/}