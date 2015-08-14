# Command line arguments are the following: round number, problem letter (lowercase)
# Creates a directory with the name {number}-{uppercase} and a file called {letter}.java
# The file will follow my codeforces java template and have a symlink from the working directory.
uppercase=${2^^}
dirname="$1-$uppercase"
mkdir $dirname
cp template.java $dirname/$2.java
sed -i "s/CLASS_NAME/$2/g" $dirname/$2.java
ln -s $dirname/$2.java $2.java
