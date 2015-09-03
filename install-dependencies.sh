# Clone the SCS git repository
git clone https://github.com/cvxgrp/scs.git

# Copy modified files
cp project/scs.mk scs
cp project/Makefile scs/java 

# Compile the binaries
cd scs
make
cd java
make

cd ..
cd ..

# copy the jar and the shared libraries into the lib folder
cp scs/java/bin/libjscsdir.so lib
cp scs/java/bin/libjscsindir.so lib
cp scs/java/scs.jar lib

# Clean the downloaded files
rm -r -f scs
