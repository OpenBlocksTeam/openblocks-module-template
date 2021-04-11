package com.openblocks.module.example;

import android.content.Context;
import android.view.ViewGroup;
import com.openblocks.moduleinterface.OpenBlocksModule;
import com.openblocks.moduleinterface.callbacks.Logger;
import com.openblocks.moduleinterface.callbacks.SaveCallback;
import com.openblocks.moduleinterface.models.OpenBlocksProjectMetadata;
import com.openblocks.moduleinterface.models.config.OpenBlocksConfig;
import com.openblocks.moduleinterface.models.layout.LayoutViewXMLAttribute;
import com.openblocks.moduleinterface.projectfiles.OpenBlocksCode;
import com.openblocks.moduleinterface.projectfiles.OpenBlocksLayout;

import java.util.ArrayList;
import java.util.Arrays;

public class ExampleProjectLayoutGUI implements OpenBlocksModule.ProjectLayoutGUI {

    Logger l;

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public void initialize(Context context, Logger logger) {
        l = logger;
    }

    @Override
    public void show(Context context, ViewGroup root, OpenBlocksCode code, OpenBlocksLayout layout, OpenBlocksProjectMetadata metadata, SaveCallback<OpenBlocksLayout> saveCallback) {

    }

    @Override
    public OpenBlocksLayout initializeNewLayout() {
        return new OpenBlocksLayout("andriod.widget.LinearLayout", new ArrayList<>(Arrays.asList(
                new LayoutViewXMLAttribute("android", "layout_height", "match_parent"),
                new LayoutViewXMLAttribute("android", "layout_width", "match_parent"),
                new LayoutViewXMLAttribute("android", "background", "#000000")
        )));
    }

    @Override
    public OpenBlocksConfig setupConfig() {
        return new OpenBlocksConfig();
    }

    @Override
    public void applyConfig(OpenBlocksConfig openBlocksConfig) {

    }
}
