# Eclipse Che & Codenvy Assembly Generator
[Eclipse Che](www.eclipse.org/che) is a next-generation Eclipse IDE, developer workspace server and cloud IDE. Che is customizable with extensions, plugins, agents, branding, stacks, and templates. These modifications can be repackaged into new assemblies that are distributed to users. 

You can use Maven Archetypes to generate sample custom assemblies. These custom assemblies demonstrate the modifications needed to make simple changes to Che, designed to be a quick start and learning tool for assembly developers.

Codenvy is a version of Eclipse Che that adds multi-tenancy, user authentication, and multi-node workspace scaling. Codenvy can also be customed with custom assemblies based upon Eclipse Che archetypes.


## Use Generator
There are three phases:

1. Generate a new custom assembly repository
2. Build it with maven
3. Run it with the Che CLI

#### Generate Assembly
A custom assembly is a complete Eclipse Che binary. You can configure the following as part of the generation:

1. The archetype name chooses what customizations will be included.
2. The archetypeVersion will generate a Che assembly that inherits from a matching Che version.
3. Set the `groupId` and `artifactId` to unique values to create a UUID identifier of your new assembly.

```
mvn org.apache.maven.plugins:maven-archetype-plugin:2.4:generate                                                      \
  -DarchetypeRepository=http://maven.codenvycorp.com/content/groups/public/ \
  -DarchetypeGroupId=org.eclipse.che.archetype                              \
  -DarchetypeArtifactId=<ARCHETYPE-NAME>                                    \
  -DarchetypeVersion=5.5.0-SNAPSHOT                                         \
  -DgroupId=<VALUE>                                                         \
  -DartifactId=<VALUE>                                                      \
  -Dversion=<VALUE>                                                         \
  -DskipITs                                                                 \
  -DinteractiveMode=false
```

This generates a custom assembly in XXX. This assembly is git-repo check-in ready and includes a `.gitignore`, `build.sh`, `run.sh` and `stop.sh` scripts to simplfy compiling and running the new install.

#### Build Assemblies
```
# Go into your new assembly
cd <ARTIFACTID>

# Build project
mvn clean install
```
```
# Alternatively, run script to build it in container
./build.sh
```
#### Run Assembly
```
# Run this Che assembly
./run.sh --che

# Run this Codenvy assembly
./run.sh --codenvy
```
#### Stop Assembly
```
# Stop Che
./stop.sh --che

# Stop Codenvy
./stop.sh --codenvy
```

#### Archetype List
| archetypeArtifactId   | Descriptions                              |
|-----------------------|-------------------------------------------|
| `agent-archetype` |  contains sample Agent, that outputs 'Hello, Agent!' on workspace startup (Note: currently not working on Windows)  |
| `plugin-menu-archetype` |  contains sample menu entry with 'Say hello' action that pops up a notification  |
| `plugin-wizard-archetype` |  contains sample project type, based on C language, as well as action to create new .c files  |
| `plugin-embedjs-archetype` |  contains custom context menu entry that displays 'Hello World' in IDE via embedded JavaScript function  |
| `plugin-serverservice-archetype` |  contains custom context menu entry that displays message, received from the sample server service  |


## Samples:

#### Create Menu Sample, including custom menu entry with 'Say Hello' action :
```
mvn org.apache.maven.plugins:maven-archetype-plugin:2.4:generate                                                      \
  -DarchetypeRepository=http://maven.codenvycorp.com/content/groups/public/ \
  -DarchetypeGroupId=org.eclipse.che.archetype                              \
  -DarchetypeArtifactId=plugin-menu-archetype                               \
  -DarchetypeVersion=5.5.0-SNAPSHOT                                         \
  -DgroupId=my.plugin                                                       \
  -DartifactId=menu-sample                                                  \
  -Dversion=0.1-SNAPSHOT                                                    \
  -DskipITs                                                                 \
  -DinteractiveMode=false
```

#### Create Wizard Sample, including custom project type and custom file creation action:
```
mvn org.apache.maven.plugins:maven-archetype-plugin:2.4:generate                                                      \
  -DarchetypeRepository=http://maven.codenvycorp.com/content/groups/public/ \
  -DarchetypeGroupId=org.eclipse.che.archetype                              \
  -DarchetypeArtifactId=plugin-wizard-archetype                             \
  -DarchetypeVersion=5.5.0-SNAPSHOT                                         \
  -DgroupId=my.plugin                                                       \
  -DartifactId=wizard-sample                                                \
  -Dversion=0.1-SNAPSHOT                                                    \
  -DskipITs                                                                 \
  -DinteractiveMode=false
```

#### Create Agent Sample, inlcuding simple agent that outputs 'Hello Agent' on workspace startup:

```
mvn org.apache.maven.plugins:maven-archetype-plugin:2.4:generate                                                      \
  -DarchetypeRepository=http://maven.codenvycorp.com/content/groups/public/ \
  -DarchetypeGroupId=org.eclipse.che.archetype                              \
  -DarchetypeArtifactId=agent-archetype                                     \
  -DarchetypeVersion=5.5.0-SNAPSHOT                                         \
  -DgroupId=my.plugin                                                       \
  -DartifactId=agent-sample                                                 \
  -Dversion=0.1-SNAPSHOT                                                    \
  -DskipITs                                                                 \
  -DinteractiveMode=false
```


#### Create Embed JavaScript Sample, including custom context menu entry that displays 'Hello World' in IDE via embedded JavaScript function :
```
mvn org.apache.maven.plugins:maven-archetype-plugin:2.4:generate                                                      \
  -DarchetypeRepository=http://maven.codenvycorp.com/content/groups/public/ \
  -DarchetypeGroupId=org.eclipse.che.archetype                              \
  -DarchetypeArtifactId=plugin-embedjs-archetype                            \
  -DarchetypeVersion=5.5.0-SNAPSHOT                                         \
  -DgroupId=my.plugin                                                       \
  -DartifactId=embedjs-sample                                               \
  -Dversion=0.1-SNAPSHOT                                                    \
  -DskipITs                                                                 \
  -DinteractiveMode=false
```

#### Create ServerService Sample, including custom context menu entry that displays message, received from the sample server service :
```
mvn org.apache.maven.plugins:maven-archetype-plugin:2.4:generate                                                      \
  -DarchetypeRepository=http://maven.codenvycorp.com/content/groups/public/ \
  -DarchetypeGroupId=org.eclipse.che.archetype                              \
  -DarchetypeArtifactId=plugin-serverservice-archetype                      \
  -DarchetypeVersion=5.5.0-SNAPSHOT                                         \
  -DgroupId=my.plugin                                                       \
  -DartifactId=serverservice-sample                                         \
  -Dversion=0.1-SNAPSHOT                                                    \
  -DskipITs                                                                 \
  -DinteractiveMode=false
```

#### Create JSON Sample, including custom project type, codeassistant, actions and sample workspace services :
```
mvn org.apache.maven.plugins:maven-archetype-plugin:2.4:generate                                                      \
  -DarchetypeRepository=http://maven.codenvycorp.com/content/groups/public/ \
  -DarchetypeGroupId=org.eclipse.che.archetype                              \
  -DarchetypeArtifactId=plugin-json-archetype                               \
  -DarchetypeVersion=5.5.0-SNAPSHOT                                         \
  -DgroupId=my.plugin                                                       \
  -DartifactId=json-sample                                                  \
  -Dversion=0.1-SNAPSHOT                                                    \
  -DskipITs                                                                 \
  -DinteractiveMode=false
```

## Update Assembly to new versions of Che/Codenvy
In order to update Che to a newer version, you must change following values:

- version of the parent POM
- property `che.version`
- property `codenvy.version` (for Codenvy archetypes)
