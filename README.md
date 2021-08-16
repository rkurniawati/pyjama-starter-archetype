# Installing the CDER's pyjama-starter archetype

After cloning, run the command below to install the archetype in the local Maven catalog.

```
mvn clean install
```

After installation, use `mvn archetype:generate` to generate the project, specifying the archetype groupid, id, and version. For example:

```
mvn archetype:generate -DarchetypeCatalog=local -DarchetypeGroupId=edu.cder -DarchetypeArtifactId=pyjama-starter -DarchetypeVersion=1.0.0-SNAPSHOT -DgroupId=edu.wsu -DartifactId=myPyjamaApp
```

Note that since Pyjama doesn't support Java packages, all of the Java files are in the default namespace. You can open and run the project using any IDEs that can open a Maven project. To execute the main method from the command line:
```
mvn compile exec:java -Dexec.mainClass=App
```

