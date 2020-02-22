# Langton ant.Ant
## About this Kata
The purpose is to build a cellular automaton : Langton ant.Ant

## Rules
Squares on a plane are colored variously either black or white. We arbitrarily identify one square as the “ant”. The ant can travel in any of the four cardinal directions at each step it takes. The “ant” moves according to the rules below:

* At a white square, turn 90° right, flip the color of the square, move forward one unit
* At a black square, turn 90° left, flip the color of the square, move forward one unit

taken from [codingdojo.org](http://codingdojo.org/kata/LangtonAnt/)

# Implementation
1. Ants are generated in an "infinite" world, where coordinate wrapping occurs  when the coordinate values are greater or smaller that the the integer's maximum positive and negative values
2. Every time a new ant is generated the default colour is random (BLACK or WHITE) 
