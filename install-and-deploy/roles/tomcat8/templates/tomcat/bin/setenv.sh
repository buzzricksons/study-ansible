# logging
JAVA_OPTS="$JAVA_OPTS -Djava.security.egd=file:/dev/./urandom"

# memory settings
#JAVA_OPTS="$JAVA_OPTS -Xms{{tomcat_min_heap_size}} -Xmx{{tomcat_max_heap_size}} -Xss800k"
#JAVA_OPTS="$JAVA_OPTS -XX:NewSize={{tomcat_new_size}} -XX:MaxNewSize={{tomcat_max_new_size}}"
#JAVA_OPTS="$JAVA_OPTS -XX:MetaspaceSize={{tomcat_metaspace_size}} -XX:MaxMetaspaceSize={{tomcat_max_metaspace_size}}"
#JAVA_OPTS="$JAVA_OPTS -XX:TargetSurvivorRatio=90 -XX:MaxTenuringThreshold=15"

# dump settings
JAVA_OPTS="$JAVA_OPTS -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath={{tomcat_home}}/logs"

# gc settings
JAVA_OPTS="$JAVA_OPTS -XX:+UseConcMarkSweepGC -XX:+CMSClassUnloadingEnabled"
JAVA_OPTS="$JAVA_OPTS -XX:+PrintGCDetails -XX:+PrintGCDateStamps -verbose:gc -Xloggc:{{tomcat_home}}/logs/gc.log"
JAVA_OPTS="$JAVA_OPTS -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=7 -XX:GCLogFileSize=10M"

# ipv6 disabled
JAVA_OPTS="$JAVA_OPTS -Djava.net.preferIPv4Stack=true"

#export CATALINA_OUT="/dev/null"
