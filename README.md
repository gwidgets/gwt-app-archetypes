## Description

This project provides a set of archetypes for starting your GWT application. All archetypes make use of [Maven GWT Plugin](https://github.com/gwt-maven-plugin/gwt-maven-plugin) as a build tool.  


##Available archetypes

The available archetypes are:

  - gwt-polymer-starter: A polymer based UI inspired from the [Polymer Starter Kit](https://developers.google.com/web/tools/polymer-starter-kit/). This archetype uses Vaadin's [gwt-polymer-elements](https://github.com/vaadin/gwt-polymer-elements). It also uses GWT Activities and Places to handle routing and section change.This archetype generates the client side only.   

##Usage

On Windows:

    mvn archetype:generate -DarchetypeGroupId=com.gwidgets.maven                ^
      -DarchetypeArtifactId={artifactName}          ^
      -DarchetypeVersion=0.1-SNAPSHOT                ^
      -DgroupId={yourGroupId}                               ^
      -DartifactId={yourArtifactID}                            ^
      -Dmodule={moduleName}                                  ^
      -Dversion={yourVersion}

On Linux/Mac Os: 

        mvn archetype:generate -DarchetypeGroupId=com.gwidgets.maven                \
      -DarchetypeArtifactId={artifactName}          \
      -DarchetypeVersion=0.1-SNAPSHOT                \
      -DgroupId={yourGroupId}                                \
      -DartifactId={yourArtifactID}                             \
      -Dmodule={moduleName}                                   \
      -Dversion={yourVersion}

