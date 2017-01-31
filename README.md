## How to use
### Build and install Che Archetype Plugin (Needed only for testing before release) 
Run  ```mvn clean install```
### Create plugin-wizard sample
Run
```
mvn archetype:generate                               \
  -DarchetypeGroupId=org.eclipse.che.archetype       \
  -DarchetypeArtifactId=archetype-plugin-wizard      \
  -DarchetypeVersion=1.0-SNAPSHOT                    \
  -DgroupId=my.plugin                                \
  -DartifactId=my-wizard                             \
  -Dche=5.2.0-SNAPSHOT                               \
  -Dversion=0.1-SNAPSHOT                             
```
Go to my-wizard and run ``` mvn clean install```
### Run my-wizard sample
```
docker run -it --rm  \
 -v /var/run/docker.sock:/var/run/docker.sock \
 -v /tmp/.plugin-mywizard/data:/data \
 -v {pathto plugin-mywizard}/plugin-mywizard/assembly/assembly-main/target/eclipse-che-0.1-SNAPSHOT/eclipse-che-0.1-SNAPSHOT:/assembly \
 eclipse/che-cli:nightly start

```




