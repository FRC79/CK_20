FROM alisonalonso/ant
RUN mkdir /root/wpilib/java/ -p
WORKDIR /root/wpilib/java/
ADD install.xml ./
ADD build.properties ./

RUN ant -f install.xml install
WORKDIR /src
ENTRYPOINT "ant"
