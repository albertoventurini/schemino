# Schemino

*Schemino* (pr. skĕ′mə-nō′, skeh-me-no) is a
small programming language inspired by *Scheme*.

It is being developed with the sole purpose of learning
Truffle and GraalVM.

The name *schemino* is an Italian word meaning "small schema".

## Build

```
export PATH=/path/to/graalvm/bin/:$PATH
export JAVA_HOME=/path/to/graalvm
mvn install
```

## Run

```
mvn exec:java \
  -Dtruffle.class.path.append=target/schemino-0.1.0-SNAPSHOT.jar \
  -Dexec.mainClass="com.albertoventurini.schemino.naive.Main"
```