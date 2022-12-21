Design Justification:

We alternatively wanted to create a class called Character with an aggregate relationship to another class called Location. Location would construct and trigger the mini games if you were at the right place on the map. However, since each of the mini games require a character to play in order to adjust the users physical status, we could not pass a Character through Location as Location is an attribute of Character. Although we could have used return statements to store the value we wanted to change the characters physical status too, so that method would have been inefficient. We tried to extend Wonderland so that certain methods could be used in all of the other classes, but we found that it was easier to make all those methods availible through character, and since almost every class must have a character to work this strategy was effective.

Instead we opted for an architecture where Wonderland has an aggregate relationship to each place and character. The Character class stores character specific methods while the Wonderland class contains map specific functions. By having the Character and Wonderland classes as seperate allowed us to not only organize our code more efficiently but also let us use the specific attributes we needed for the different elements of the game. 