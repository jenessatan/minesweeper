# minesweeper

## To Do
- [x] initialize game - prompt player to choose difficulty level
- [x] build board of dimension based on difficulty level
- [x] populate board with number of bombs based on difficulty level
- [ ] set cell value with number of surrounding bombs
- [ ] play game - print board then prompt user to choose a cell
- [ ] chosen cell either:
    - [ ] bomb --> immediately end game and print the entire board
    - [ ] cell with bomb(s) in vicinity --> reveal cell containing count of bombs around it
    - [ ] cell without any nearby bombs --> recursively reveal cells until group has bombs around it
- [ ] repeat play game until player either dies or reveals all non-bomb cells