[![Build Status](https://travis-ci.org/gwidgets/gwt-ui-archetypes.svg?branch=master)](https://travis-ci.org/gwidgets/gwt-ui-archetypes)
## Description

This project provides a set of archetypes for starting your GWT application. 


## Available archetypes

The available archetypes are:

  - gwt-polymer-starter: A polymer based UI inspired from the [Polymer Starter Kit](https://developers.google.com/web/tools/polymer-starter-kit/). This archetype uses Vaadin's [gwt-polymer-elements](https://github.com/vaadin/gwt-polymer-elements). It also uses GWT Activities and Places to handle routing and section change.This archetype generates the client side only.
  
  - gwt-polymer-starter-dagger-di: The same archetype as the gwt-polymer-starter. The difference between the two is that this archetype introduces dependency injection using [Dagger](https://github.com/google/dagger).  
  
  - gwt-polymer-nav-list-detail: This archetype defines a navigation layout with a main side paper menu and sub menus. The layout is responsive, so both the main menu and the sub menu adapt to screen size. This archetype is inspired from Polymer layouts: [http://polymerelements.github.io/app-layout-templates/index.html](http://polymerelements.github.io/app-layout-templates/index.html)
  
  - progressive-web-app: This archetype defines a progressive web application structure with: an app shell for fast painting, service workers for offline usage, and a manifest file for installation to home screen. It uses some Polymer elements like [paper-toolbar](https://elements.polymer-project.org/elements/paper-toolbar), and [iron-pages](https://elements.polymer-project.org/elements/iron-pages). Because the names of the xxx.cache.js files are not known prior to compilation, they need to be added to the [sw.js](https://github.com/gwidgets/gwt-ui-archetypes/blob/master/progressive-web-app/src/main/resources/archetype-resources/src/main/webapp/sw.js) after compiling to allow full availability of the application offline.  
  
  - spring-security-gwt: This archetype is based on the example provided in our blog post on how to [secure a GWT application using Spring Security](http://www.g-widgets.com/2016/12/09/securing-a-gwt-app-using-spring-security/). It is a multi module application with a client module, which the GWT application, and a server module which provides authorization and authentication for accessing the application. The project makes use of the Jetty maven plugin as well as the new [GWT maven plugin](https://tbroyer.github.io/gwt-maven-plugin/).  
  
  - spring-boot-gwt: This archetype is an integration of GWT into a spring boot application. There are two predefined profiles for running GWT dev mode and for running the application in production. To run the spring boot app with GWT in devmode you need to run the following commands: `mvn spring-boot:run` and in a different window `mvn gwt:devmode -Pgwt-dev`. If you don't need to you use GWT devmode and you need to run or package the application you can use the gwt-prod profile. For example: `mvn package -Pgwt:prod`. Spring Boot version: 1.5.2.RELEASE, GWT version: 2.8.0. This archetypes uses the net.ltgt.gwt.maven GWT plugin.      

## Usage

On Windows:

    mvn archetype:generate -DarchetypeGroupId=com.gwidgets.maven                ^
      -DarchetypeCatalog=https://oss.sonatype.org/content/repositories/snapshots/ ^
      -DarchetypeArtifactId={artifactName}          ^
      -DarchetypeVersion=0.3-SNAPSHOT                ^
      -DgroupId={yourGroupId}                               ^
      -DartifactId={yourArtifactID}                            ^
      -Dmodule={moduleName}                                  ^
      -Dversion={yourVersion}

On Linux/Mac Os: 

        mvn archetype:generate -DarchetypeGroupId=com.gwidgets.maven                \
      -DarchetypeCatalog=https://oss.sonatype.org/content/repositories/snapshots/ \
      -DarchetypeArtifactId={artifactName}          \
      -DarchetypeVersion=0.3-SNAPSHOT                \
      -DgroupId={yourGroupId}                                \
      -DartifactId={yourArtifactID}                             \
      -Dmodule={moduleName}                                   \
      -Dversion={yourVersion}


## Demos:

- gwt-polymer-starter: [https://gwt-polymer-starter.herokuapp.com/](https://gwt-polymer-starter.herokuapp.com/)
- gwt-polymer-nav-list-detail: [https://gwt-polymer-nav-list.herokuapp.com](https://gwt-polymer-nav-list.herokuapp.com)
- progressive-web-app: [https://pwa-template.herokuapp.com/](https://pwa-template.herokuapp.com/)
- spring-security-gwt: [https://gwt-spring-security.herokuapp.com/GwtSpringSecurity.html](https://gwt-spring-security.herokuapp.com/GwtSpringSecurity.html)
  * username: gwidgets, password: gwidgets