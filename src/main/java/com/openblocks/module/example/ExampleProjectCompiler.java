package com.openblocks.module.example;

import android.content.Context;
import com.openblocks.moduleinterface.OpenBlocksModule;
import com.openblocks.moduleinterface.callbacks.Logger;
import com.openblocks.moduleinterface.exceptions.CompileException;
import com.openblocks.moduleinterface.models.OpenBlocksProjectMetadata;
import com.openblocks.moduleinterface.models.code.ParseBlockTask;
import com.openblocks.moduleinterface.models.compiler.IncludedBinary;
import com.openblocks.moduleinterface.models.config.OpenBlocksConfig;
import com.openblocks.moduleinterface.projectfiles.OpenBlocksCode;
import com.openblocks.moduleinterface.projectfiles.OpenBlocksLayout;

import java.util.ArrayList;
import java.util.HashMap;

public class ExampleProjectCompiler implements OpenBlocksModule.ProjectCompiler {

    Logger l;

    @Override
    public Type getType() {
        return Type.PROJECT_COMPILER;
    }

    @Override
    public void initialize(Context context, Logger logger) {
        l = logger;
    }

    @Override
    public void initializeCompiler(ArrayList<IncludedBinary> includedBinaries, HashMap<String, ParseBlockTask> blocks) {

    }

    @Override
    public void compile(OpenBlocksProjectMetadata metadata, OpenBlocksCode code, OpenBlocksLayout layout, String apk_location) throws CompileException {

    }

    @Override
    public OpenBlocksConfig setupConfig() {
        return new OpenBlocksConfig();
    }

    @Override
    public void applyConfig(OpenBlocksConfig openBlocksConfig) {

    }
}
