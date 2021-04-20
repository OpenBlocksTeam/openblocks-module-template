# OpenBlocks Module Template
An Intellij IDEA template project used to create OpenBlocks modules

## Building
> Warning: Building on windows is NOT supported yet

To build your openblocks module, make sure to have all of these installed in your UNIX/UNIX-Like system:
 - java (8 is recommended)
 - zip
 - wget
 - bash

Then run
```
./build-obm.sh
```

The compiled module will be named `release.obm`, have fun!

## How does this works?
It's just a simple IntelliJ IDEA project with android-30's and openblocks-module-interface jar compiled with it, then it gets dexed by d8, after that, pack the dexed jar and the manifest into a zip, and rename the zip to be `.obm`.
