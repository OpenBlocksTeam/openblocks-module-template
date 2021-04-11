package com.openblocks.module.example;

import android.content.Context;
import com.openblocks.moduleinterface.OpenBlocksModule;
import com.openblocks.moduleinterface.callbacks.Logger;
import com.openblocks.moduleinterface.exceptions.ParseException;
import com.openblocks.moduleinterface.models.OpenBlocksProjectMetadata;
import com.openblocks.moduleinterface.models.OpenBlocksRawProject;
import com.openblocks.moduleinterface.models.config.OpenBlocksConfig;
import com.openblocks.moduleinterface.projectfiles.OpenBlocksCode;
import com.openblocks.moduleinterface.projectfiles.OpenBlocksLayout;

import java.util.ArrayList;

public class ExampleProjectParser implements OpenBlocksModule.ProjectParser {

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
    public String generateFreeId(ArrayList<String> existing_ids) {
        return null;
    }

    @Override
    public OpenBlocksLayout parseLayout(OpenBlocksRawProject raw_project) throws ParseException {
        return null;
    }

    @Override
    public OpenBlocksCode parseCode(OpenBlocksRawProject raw_project) throws ParseException {
        return null;
    }

    @Override
    public OpenBlocksProjectMetadata parseMetadata(OpenBlocksRawProject raw_project) throws ParseException {
        return null;
    }

    @Override
    public OpenBlocksRawProject saveProject(OpenBlocksProjectMetadata metadata, OpenBlocksCode code, OpenBlocksLayout layout) {
        return null;
    }

    @Override
    public OpenBlocksConfig setupConfig() {
        return new OpenBlocksConfig();
    }

    @Override
    public void applyConfig(OpenBlocksConfig openBlocksConfig) {

    }
}
