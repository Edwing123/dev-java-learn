# Create a shell script to compile a serie of Java files
# and executes a provided class passed as an argument to
# the script.

# Compile all the Java files.
javac *.java

# Execute the provided class plus the remaining arguments.
java "$@"

# Remove all the class files.
rm *.class
