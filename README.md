# Java-Project-Games
This directory included the implementation of 2 games, Wizard & Magician and TicTacToe. 

## Wizard&Magician
This project is meant to be a part of a video game in which various entities will battle against one another by casting spells. Entities are represented by an abstract class, Entity. There are two kinds of entity: magicians and transport units, represented by classes Magician and TransportUnit respectively. 
 <br /> 
Every entity has a name and a non-negative number of life points. The life points of an entity decrease as the entity is hit by enemy spells. While an entity has a positive number of life points, the entity is considered alive. When an entity’s life points becomes zero the entity is considered dead.
 <br /> 
A transport unit is a composite entity which consists of various other entities: magicians and other transport units. 
 <br /> 
Entities are hit by spells which are cast by spell casters. This is achieved via an instance method of Entity, applySpell, which takes a parameter of type SpellCaster. SpellCaster is an interface that specifies a method getStrength, which returns an integer. When applySpell is invoked on an entity that has n life points, the entity’s life points are reduced by the strength of the spell caster, or by n, whichever is less. If the entity is a transport unit t, life points are deducted from entities contained (directly or indirectly) in a recurrsive effect -- It is reduced by half in every recurrsion.
- An entity with n life points contained directly in t has its life points reduced by 50% of the strength of the spell caster, up to a maximum of n
- An entity with n life points contained in a transport unit contained in t has its life points reduced by 25% of the strength of the spell caster, up to a maximum of n
- An entity with n life points contained in a transport unit contained in a transport unit contained in t has its life points reduced by 12.5% of the strength of the spell caster, up to a maximum of n

## TicTacToe
This project is the implementation of an AI version of the classic TicTacToe game where a user plays against the computer. ***The best move algorithms is NOT implemented by me.*** The program uses a game tree. This is implemented by the Abstract Data Type which is constructed using a generic linked list of GameTreeNode. A GameTreeNode includes a GameTreeItem containing the current state of play and a reference to a linked list of GameTreeNode, for example it could contain the boards of all possible next moves of the other player (and so on). 
<br />
The program computes a best move from the current board (method computerOptimalMove in the TicTacToe class) in the following way: a game tree is constructed with the current board as the root. This is then expanded so that it contains all possible future boards of the game, given the root board. Each board in the expanded game tree is then given a score and a next move is chosen randomly among the highest scoring immediate children of the root node.
<br />
The expand step is applied to a game tree containing only a root board, and uses the following algorithm:
- It checks that the current board is not finished (using the isFinished method in the Board class) and gets the mark of the next player (using the given getTurn method in the Board class)
- for each empty position in the board creates a GameTreeNode object, with the mark placed on that position, records in the board object this position as the last marked position, adds this GameTreeNode object to the list of children of the current board, and then (recursively) call the expand step on this (child) GameTreeNode object.
