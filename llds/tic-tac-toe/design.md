
Start Time : 6:30 PM
End Time : 7.15 PM

1. Requirements
2. Entities & Relationship
3. Identify Design Patterns
4. Identify Concurrency Requirements
5. Implementation

# Requirements

1. Board can be of N x N cells
2. We will have 2 players
   1. There might be CPU player
3. Each player will have a symbol
4. Winning Conditions:
   1. Diagonal
   2. Vertical
   3. Horizontal


# Entities

- Board
- Cell
- Player
  - Human Player
  - CPU Player
- Symbol
- Move


# Relationship 

- Board:Cell (1:M)
- Cell:Player (1:1)
- Player:Symbol (1:1)


# Patterns

- Strategy Pattern for Winning Conditions
- 