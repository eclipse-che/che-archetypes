# Eclipse Che & Codenvy Assembly Generator
[Eclipse Che](www.eclipse.org/che) is a next-generation Eclipse IDE, developer workspace server and cloud IDE. Che is customizable with extensions, plugins, agents, branding, stacks, and templates. These modifications can be repackaged into new assemblies that are distributed to users. 

You can use Maven Archetypes to generate sample custom assemblies. These custom assemblies demonstrate the modifications needed to make simple changes to Che, designed to be a quick start and learning tool for assembly developers.

Codenvy is a version of Eclipse Che that adds multi-tenancy, user authentication, and multi-node workspace scaling. Codenvy can also be customed with custom assemblies based upon Eclipse Che archetypes.

## Build
To compile the archetype generator, run:

`mvn clean install`

## Use
There are three phases:
1. Generate a new custom assembly repository
2. Build it with maven
3. Run it with the Che CLI

#### Generate
A custom assembly is a complete Eclipse Che binary.
```
mvn archetype:generate                                \
  -DarchetypeGroupId=org.eclipse.che.archetype        \
  -DarchetypeArtifactId=<ARCHETYPE-NAME>              \
  -DarchetypeVersion=1.0-SNAPSHOT                     \
  -DgroupId=<VALUE>                                   \
  -DartifactId=<VALUE>                                \
  -Dche=<CHE-VERSION                                  \
  -Dversion=<VALUE>
```
#### Build
#### Run

## Create Menu Sample, including custom menu entry with 'Say Hello' action :

### Create sample
```
mvn archetype:generate                                \
  -DarchetypeGroupId=org.eclipse.che.archetype        \
  -DarchetypeArtifactId=che-plugin-ide-menu-archetype \
  -DarchetypeVersion=1.0-SNAPSHOT                     \
  -DgroupId=my.plugin                                 \
  -DartifactId=menu-sample                            \
  -Dche=5.2.0-SNAPSHOT                                \
  -Dversion=0.1-SNAPSHOT
```

### Build
Go to menu-sample and run ``` mvn clean install```

### Run
```
docker run -it --rm  \
 -v /var/run/docker.sock:/var/run/docker.sock \
 -v /tmp/.menu-sample/data:/data \
 -v {path to menu-sample}/assembly/assembly-main/target/eclipse-che-0.1-SNAPSHOT/eclipse-che-0.1-SNAPSHOT:/assembly \
 eclipse/che-cli:nightly start

```

## Create Wizard Sample, including custom project type and custom file creation action:

### Create sample
```
mvn archetype:generate                               \
  -DarchetypeGroupId=org.eclipse.che.archetype       \
  -DarchetypeArtifactId=archetype-plugin-wizard      \
  -DarchetypeVersion=1.0-SNAPSHOT                    \
  -DgroupId=my.plugin                                \
  -DartifactId=wizard-sample                         \
  -Dche=5.2.0-SNAPSHOT                               \
  -Dversion=0.1-SNAPSHOT                             
```

### Build
Go to wizard-sample and run ``` mvn clean install```

### Run
```
docker run -it --rm  \
 -v /var/run/docker.sock:/var/run/docker.sock \
 -v /tmp/.wizard-sample/data:/data \
 -v {path to wizard-sample}/assembly/assembly-main/target/eclipse-che-0.1-SNAPSHOT/eclipse-che-0.1-SNAPSHOT:/assembly \
 eclipse/che-cli:nightly start

```



