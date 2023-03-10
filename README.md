# NoobUi

[![build](https://github.com/door-bell/noob-ui/actions/workflows/build.yml/badge.svg)](https://github.com/door-bell/noob-ui/actions/workflows/build.yml)
[![release](https://github.com/door-bell/noob-ui/actions/workflows/release.yml/badge.svg)](https://github.com/door-bell/noob-ui/actions/workflows/release.yml)

A minecraft fabric mod that adds some basic UI enhancements to help new players with basic minecraft concepts which are otherwise bespoke (hidden in debug menus, etc).

## Feature List
1. Coordinates, compass and ping in the top left corner of the screen at all times.
2. Holding M highlights visible player and horse names to make it easier to find them when they are nearby (i.e. when you lose track of your friend in a cave).

## Dev Setup
For setup instructions please see the [fabric wiki page](https://fabricmc.net/wiki/tutorial:setup) that relates to the IDE that you are using.

## License
This mod is available under the CC0 license. Feel free to learn from it and incorporate it in your own projects.

## Acknowledgements
The following are acknowledgements of other projects from where I drew inspirations and examples for how to implement this mod.
* Used as sample for mixing for name tag rendering: [DevPieter's Better-name-tags](https://github.com/DevPieter/Better-Name-Tags/blob/master/src/main/java/nl/devpieter/betternametags/mixin/EntityRendererMixin.java#L43)
* Used as sample for drawing text from the HUD: [johnvictorfs's simple-utilities-mod](https://github.com/johnvictorfs/simple-utilities-mod)
