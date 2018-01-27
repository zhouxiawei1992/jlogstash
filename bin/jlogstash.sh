#!/bin/sh

HO_HEAP_SIZE="${HO_HEAP_SIZE:=300m}"

unset CDPATH
export basedir=$(cd `dirname $0`/..; pwd)

JAVA_OPTS="$JAVA_OPTS -Xmx${HO_HEAP_SIZE}"

JAVA_OPTS="$JAVA_OPTS -Xms${HO_HEAP_SIZE}"

JAVA_OPTS="$JAVA_OPTS -server"

JAVA_OPTS="$JAVA_OPTS -Xloggc:../logs/jlogstash.gc"

JAVA_OPTS="$JAVA_OPTS -XX:HeapDumpPath=../logs/heapdump.hprof"


#-XX:MaxDirectMemorySize=16M According to owner memory
JAVA_OPTS="$JAVA_OPTS -XX:+UseG1GC -XX:MaxGCPauseMillis=20 -XX:InitiatingHeapOccupancyPercent=35 -XX:+HeapDumpOnOutOfMemoryError -XX:+DisableExplicitGC -Dfile.encoding=UTF-8 -Djna.nosys=true -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps"

#Comment to speed up starting time 
#JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false"

exec java $JAVA_OPTS -cp $basedir/lib/* com.dtstack.jlogstash.Main "$@"
