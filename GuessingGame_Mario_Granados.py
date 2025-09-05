import random
##validate if user has entered a string or an int
#also make sure we return an int
def validate_user_input():
    while True:
        user_input = input("Enter your guess: ")
        if user_input.isdigit():
            return int(user_input)
        else:
            print(user_input, 'is not a number, you need to enter a number')

#logic of the game
#random number is compared with user input
def start_game(random_number):
    #counts how many attempts the user made to guess the input
    count = 0
    #repeat until we guess the number
    while True:
        #call function to make sure we get an int
        user_input = validate_user_input()
        count += 1
        #tell the user how high/low they are from the random number
        if user_input > random_number:
            print('You are too high, try again')
        elif user_input < random_number:
            print('You are too low, try again')
        else:
            print(f'You guessed the number {random_number}! It took you {count} tries.')
            #once the number is guessed we break loop
            break
#game loop
while True:
    #prompt user if they want to play a game
    print('Do you want to play the game?')
    #ask user if for response and we uppercase it for simplicity
    play_again = input('Type "yes" or "no": ').strip().upper()
    #check if user wants to play
    if play_again not in {'YES', 'NO'}:
        print('You need to type "yes" or "no".')
    elif play_again == 'NO':
        print('Have a nice day!')
        break
    elif play_again == 'YES':
        #generate random number between 1 - 100
        random_number = random.randint(1, 100)
        print('I’m thinking of a number between 1 and 100.')
        #starts the game with new random number everytime
        start_game(random_number)
