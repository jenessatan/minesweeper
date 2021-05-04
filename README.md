# minesweeper

## To Do
- [x] initialize game - prompt player to choose difficulty level
- [x] build board of dimension based on difficulty level
- [x] populate board with number of bombs based on difficulty level
- [x] set cell value with number of surrounding bombs
- [x] play game - print board then prompt user to choose a cell
- [x] chosen cell either:
    - [x] bomb --> immediately end game and print the entire board
    - [x] cell with bomb(s) in vicinity --> reveal cell containing count of bombs around it
    - [x] cell without any nearby bombs --> recursively reveal cells until group has bombs around it
- [x] repeat play game until player either dies or reveals all non-bomb cells

## Game In Action
Users first select and confirm their difficulty level

![](./images/Difficulty%20Selection.jpg)

They are then prompted to select a row and column to reveal

![](./images/Start%20Game.jpg)

Selected cells are revealed. If the cell does not have any bombs in its vicinity, it will recursively reveal all adjacent non-mine cells.

![](./images/Empty%20Space.jpg)

If the selected cell is a mine, they lose the game

![](./images/Found%20the%20Mine.jpg)