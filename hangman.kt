fun main(){
    //max amount of guesses
    val maxGuess = 5;
    //word that is being guessed
    val word = "hangman";
    val n = word.length;
    //amount of current guesses
    var guessCount = 0;
    //current output
    var curOut = "-".repeat(n).toCharArray();
    //fill in with '-'
    //keeps track of letters already guessed
    val lettersGuessed = ArrayList<Char>();
    //loop for the game
    println("Welcome to hangman!");
    while(guessCount < maxGuess){
        println("Enter your guess");
        //read user input
        val guess = readln();
        var char = 'a';
        //making sure the guess is valid
        if(guess.isNotEmpty() && !lettersGuessed.contains(guess[0])){
            char = guess[0];
            lettersGuessed.add(char);
        } else {
            //skip iteration if the guess is not valid
            println("Enter a valid guess");
            continue;
        }

        var goodGuess = false;
        //see if the guess is in the word
        for(i in 0..n-1){
            if(word[i] == char){
                curOut[i] = char;
                goodGuess = true;
            }
        }
        //output is good or bad guess
        if(goodGuess){
            println("Correct Guess!");
            //check if the game was won
            if(curOut.joinToString("") == word){
                println("Congrats! You have won the game");
                break;
            } else {
                println(curOut.joinToString(""));
            }
        } else {
            guessCount++;
            println("Incorrect guess. You have ${maxGuess - guessCount} guesses left")
        }

    }

}
