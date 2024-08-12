Project should fill main functionalities:

1. Creating new game with

- 2 teams
- initial score 0 - 0
- differentiation home/away team

2. Update game as pair home team score - away team score.
3. Finishing game results removing game from scoreboard.
4. Summary games ordered by total score, if same score - order by recently started.

Since there was no need to create a command line API or anything like that, the methods return strings or ints instead
of printing something,
I assumed it should be easier if I wanted to use the data during a theoretically possible extension.
For storing the data I initially thought about a Set or Map that could automatically remove duplicates,
but that would add unnecessary complexity to the sorting and structure of the Match class.
I wasn't sure if the numbering in the summary was important or if it was just a hint to me about what the list should
look like after sorting. I assumed I got correct value types, i.e. team name is a string.
As I need only one scoreboard, the implementation is based on a static ArrayList.