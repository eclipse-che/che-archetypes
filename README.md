# Eclipse Che & Codenvy Assembly Generator
[Eclipse Che](www.eclipse.org/che) is a next-generation Eclipse IDE, developer workspace server and cloud IDE. Che is customizable with extensions, plugins, agents, branding, stacks, and templates. These modifications can be repackaged into new assemblies that are distributed to users. 

You can use Maven Archetypes to generate sample custom assemblies. These custom assemblies demonstrate the modifications needed to make simple changes to Che, designed to be a quick start and learning tool for assembly developers.

Codenvy is a version of Eclipse Che that adds multi-tenancy, user authentication, and multi-node workspace scaling. Codenvy can also be customed with custom assemblies based upon Eclipse Che archetypes.

For more information on how to work with archetypes, visit official Che documentation https://eclipse.org/che/docs/assemblies/archetype/index.html


#### Archetype List
| archetypeArtifactId   | Descriptions                              |
|-----------------------|-------------------------------------------|
|================================= | |
| `agent-archetype` |  contains sample Agent, that outputs 'Hello, Agent!' on workspace startup (Note: currently not working on Windows)  |
| `plugin-menu-archetype` |  contains sample menu entry with 'Say hello' action that pops up a notification  |
| `plugin-wizard-archetype` |  contains sample project type, based on C language, as well as action to create new .c files  |
| `plugin-embedjs-archetype` |  contains custom context menu entry that displays 'Hello World' in IDE via embedded JavaScript function  |
| `plugin-serverservice-archetype` |  contains custom context menu entry that displays message, received from the sample server service  |
| `plugin-json-archetype` |  contains custom JSON file editor codeassistant, sample agent service and actions  |


## Update Assembly to New Version of Che/Codenvy
In the custom assembly that was generated, modify two properties to have the custom assembly inherit from a newer version of Che or Codenvy:

- version of the parent POM
- property `che.version`
- property `codenvy.version` (for Codenvy archetypes)
