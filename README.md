# minesweeper

## To Do
- [ ] initialize game - prompt player to choose difficulty level
- [ ] build board of dimension based on difficulty level
- [ ] populate board with number of bombs based on difficulty level
- [ ] play game - print board then prompt user to choose a cell
- [ ] chosen cell either:
    - [ ] bomb --> immediately end game and print the entire board
    - [ ] cell with bomb(s) in vicinity --> reveal cell containing count of bombs around it
    - [ ] cell without any nearby bombs --> recursively reveal cells until group has bombs around it
- [ ] repeat play game until player either dies or reveals all non-bomb cells