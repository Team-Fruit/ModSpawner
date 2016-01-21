package com.kamesuta.mc.modspawner.content;

import java.io.File;

import com.kamesuta.mc.modspawner.launch.DepLoader.Dependency;
import com.kamesuta.mc.modspawner.launch.DepLoader.VersionedFile;

public class Content {
    /**
     * Zip file to extract packed dependencies from
     */
    public File source;
    public String repo;
    public String packed;
    public VersionedFile file;
    public String testClass;
    public boolean coreLib;

    public String existing;
    /**
     * Flag set to add this dep to the classpath immediately because it is required for a coremod.
     */

    public Content(File source, String repo, String packed, VersionedFile file, String testClass, boolean coreLib) {
        this.source = source;
        this.repo = repo;
        this.packed = packed;
        this.file = file;
        this.coreLib = coreLib;
        this.testClass = testClass;
    }

    public void set(Dependency dep) {
        this.source = dep.source;
        this.repo = dep.repo;
        this.packed = dep.packed;
        this.file = dep.file;
    }
}
