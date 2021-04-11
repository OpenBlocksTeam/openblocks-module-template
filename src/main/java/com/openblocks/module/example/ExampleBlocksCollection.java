package com.openblocks.module.example;

import android.content.Context;
import com.openblocks.moduleinterface.OpenBlocksModule;
import com.openblocks.moduleinterface.callbacks.Logger;
import com.openblocks.moduleinterface.models.code.BlockCode;
import com.openblocks.moduleinterface.models.code.ParseBlockTask;
import com.openblocks.moduleinterface.models.config.OpenBlocksConfig;
import com.openblocks.moduleinterface.projectfiles.OpenBlocksCode;

import java.util.ArrayList;

public class ExampleBlocksCollection implements OpenBlocksModule.BlocksCollection {

    // The block collection name
    final String name = "ExampleBlocksCollection";

    @Override
    public OpenBlocksCode initializeNewCode() {
        // Initialize a new code here
        ArrayList<BlockCode> codes = new ArrayList<>();
        // codes.add()
        return new OpenBlocksCode(name, codes);
    }

    @Override
    public Object[] getBlocks() {
        return new Object[] {
                // Blocks here
                new Object[] {
                        /* type       */ BlockCode.class,
                        /* color      */ 0x000000,
                        /* opcode     */ "example",
                        /* format     */ "Example Block %s",
                        /* parse code */ (ParseBlockTask) (code, params, childs_code_nest) -> {
                            code.append("// Hi ");
                            code.append(params.get(0));
                        }
                }
        };
    }

    // These functions are ignored
    @Override public Type getType() { return null; }
    @Override public void initialize(Context context, Logger logger) { }
    @Override public OpenBlocksConfig setupConfig() { return null; }
    @Override public void applyConfig(OpenBlocksConfig openBlocksConfig) { }
}
