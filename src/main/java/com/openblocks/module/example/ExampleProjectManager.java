package com.openblocks.module.example;

import android.content.Context;
import com.openblocks.moduleinterface.OpenBlocksModule;
import com.openblocks.moduleinterface.callbacks.Logger;
import com.openblocks.moduleinterface.exceptions.NotSupportedException;
import com.openblocks.moduleinterface.models.OpenBlocksFile;
import com.openblocks.moduleinterface.models.OpenBlocksRawProject;
import com.openblocks.moduleinterface.models.config.OpenBlocksConfig;

import java.util.ArrayList;

public class ExampleProjectManager implements OpenBlocksModule.ProjectManager {

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
    public void saveProject(OpenBlocksRawProject raw_project) {

    }

    @Override
    public OpenBlocksRawProject getProject(String project_id) {
        return null;
    }

    @Override
    public ArrayList<OpenBlocksRawProject> listProjects() {
        return new ArrayList<>();
    }

    @Override
    public boolean projectExists(String project_id) {
        return false;
    }

    @Override
    public OpenBlocksFile exportProject(OpenBlocksRawProject raw_project) throws NotSupportedException {
        return null;
    }

    @Override
    public OpenBlocksRawProject importProject(OpenBlocksFile file) throws NotSupportedException {
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
