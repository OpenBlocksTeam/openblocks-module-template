# Check if openblocks-module-manifest exists
if ! test -f "openblocks-module-manifest.json"; then
  echo "openblocks-module-manifest.json not found"
  exit 1
fi

echo "Building jar ==================================="

# Build the module into a jar
./gradlew jar

# Check if the gradle jar build succeed
if [ $? != 0 ]; then
  echo "Gradle build failed"
  exit 1
fi

echo "Checking if the necessary commands exists ======"

# Check if wget, java, and zip exists
commands=(wget java zip)

for command in "${commands[@]}"
do
  :
  # Check if $command exists
  if ! command -v "$command" &> /dev/null
  then
    # Perform cnf to tell the user where to install this command
    cnf "$command"
    echo "$command command not found"
    exit 1
  fi
done

echo "Checking if d8 exists =========================="

# Check if d8.jar has already downloaded
if ! test -f "d8.jar"; then
  # Nop, download it
  echo "Downloading d8 using wget"
  wget https://openblocks.tk/tools/d8.jar
fi

echo "Dex-ing the jar ================================"

# Dex the jar
java -jar d8.jar --release --classpath libs/openblocks-module-interface.jar libs/android-30.jar --min-api 21 --output out.jar build/libs/*.jar

echo "Zipping the files =============================="

# Zip em to release.zip
zip release.zip openblocks-module-manifest.json out.jar

# then rename it to obm, OpenBlocks Module, where it can be loaded into the app
mv release.zip release.obm

echo "Removing out.jar ==============================="

# Delete out.jar
rm out.jar

echo "===================== Done ====================="
echo "Saved as release.obm"
