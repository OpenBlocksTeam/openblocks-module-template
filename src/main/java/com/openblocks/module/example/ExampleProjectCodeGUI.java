package com.openblocks.module.example;

import android.content.Context;
import android.view.ViewGroup;
import com.openblocks.moduleinterface.OpenBlocksModule;
import com.openblocks.moduleinterface.callbacks.Logger;
import com.openblocks.moduleinterface.callbacks.SaveCallback;
import com.openblocks.moduleinterface.models.OpenBlocksProjectMetadata;
import com.openblocks.moduleinterface.models.config.OpenBlocksConfig;
import com.openblocks.moduleinterface.projectfiles.OpenBlocksCode;
import com.openblocks.moduleinterface.projectfiles.OpenBlocksLayout;

public class ExampleProjectCodeGUI implements OpenBlocksModule.ProjectCodeGUI {

    Logger l;

    @Override
    public Type getType() {
        return Type.PROJECT_CODE_GUI;
    }

    @Override
    public void initialize(Context context, Logger logger) {
        l = logger;
    }

    @Override
    public void show(Context context, ViewGroup root, OpenBlocksCode code, OpenBlocksLayout layout, OpenBlocksProjectMetadata metadata, SaveCallback<OpenBlocksCode> saveCallback) {

    }

    @Override
    public OpenBlocksConfig setupConfig() {
        return new OpenBlocksConfig();
    }

    @Override
    public void applyConfig(OpenBlocksConfig openBlocksConfig) {

    }
}
