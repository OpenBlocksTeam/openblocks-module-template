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

# Check if there are multiple jars, and if it is, make the user choose which jar they want to include

jar=

# Get every jars in build/libs/
jars=(build/libs/*.jar)

# Check if there are more than 1 jar in jars
if [ ${#jars[@]} -gt 1 ]; then
  echo "There are more than one jar in the build directory, choose one"

  count=0

  for ljar in $jars
  do
    echo "[$count] $ljar"
    count=$(($count + 1))
  done

  selected=0
  read selected

  jar=${jars[selected]}

  echo "Selected jar: ${jars[selected]}"
else
  # There is just one jar, use that
  jar=${jars[0]}
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

out_filename=$(basename -- $jar)

# Dex the jar
java -jar d8.jar --release --min-api 21 --output $out_filename libs/openblocks-module-interface.jar libs/android-30.jar $jar

echo "Zipping the files =============================="

# Zip em to release.zip
zip release.zip openblocks-module-manifest.json $out_filename

# then rename it to obm, OpenBlocks Module, where it can be loaded into the app
mv release.zip release.obm

echo "Removing unused jar ============================"

# Delete the dex-ed jar
rm $out_filename

echo "===================== Done ====================="
echo "Saved as release.obm"
