# SOFTENG 281 - Assignment 2: Mind Game

## Overview

This project implements a command-line interface (CLI) system for a human vs AI mind game where players compete by selecting colours and guessing their opponent's choices. The game features three difficulty levels with different AI strategies, power colours for bonus points, and game statistics tracking.

## Project Structure

```
src/
├── main/java/nz/ac/auckland/se281/
│   ├── Main.java                    # CLI interface and command processing (provided)
│   ├── cli/
│   │   ├── MessageCli.java          # Message constants and formatting (provided)
│   │   └── Utils.java               # Utility functions and random generators (provided)
│   ├── engine/
│   │   ├── Game.java                # Main game logic and state management
│   │   ├── Player.java              # Abstract player base class
│   │   ├── Human.java               # Human player implementation
│   │   ├── Ai.java                  # Abstract AI base class
│   │   ├── EasyAi.java              # Easy AI with random strategy
│   │   ├── MediumAi.java            # Medium AI with strategy switching
│   │   ├── HardAi.java              # Hard AI with adaptive strategy selection
│   │   ├── AiFactory.java           # Factory for creating AI instances
│   │   ├── Strategy.java            # Strategy interface
│   │   ├── RandomStrategy.java      # Random colour selection strategy
│   │   ├── AvoidLastStrategy.java   # Avoid last played colour strategy
│   │   └── LeastUsedStrategy.java   # Select least used colour strategy
│   └── model/
│       └── Colour.java              # Colour enum and utility methods (provided)
└── test/java/nz/ac/auckland/se281/
    ├── MainTest.java                # Comprehensive test suite (provided)
    └── SysCliTest.java              # Test framework (provided)
```

## My Implementation

I was responsible for implementing the following classes, using key Object-Oriented Programming concepts and Design Patterns:

### Core Game Classes
- **`Game.java`** - Main game logic, round management, and scoring system
- **`Player.java`** - Abstract base class for all players
- **`Human.java`** - Human player implementation with input validation

### AI System Classes (Inheritance & Polymorphism)
- **`Ai.java`** - Abstract AI base class with strategy pattern
- **`EasyAi.java`** - Simple AI using random strategy
- **`MediumAi.java`** - AI that switches between random and avoid-last strategies
- **`HardAi.java`** - Advanced AI with adaptive strategy selection based on performance
- **`AiFactory.java`** - Factory pattern for creating AI instances

### Strategy Pattern Implementation
- **`Strategy.java`** - Interface defining strategy contract
- **`RandomStrategy.java`** - Random colour and guess selection
- **`AvoidLastStrategy.java`** - Avoids the last colour played by opponent
- **`LeastUsedStrategy.java`** - Selects the least frequently used colour

## OOP Concepts Demonstrated

### Inheritance
- **Player hierarchy**: `Player` (abstract) → `Human`, `Ai` (abstract) → `EasyAi`, `MediumAi`, `HardAi`
- **Strategy hierarchy**: `Strategy` (interface) → `RandomStrategy`, `AvoidLastStrategy`, `LeastUsedStrategy`

### Polymorphism
- **Strategy pattern**: Different AI behaviours through interchangeable strategies
- **Method overriding**: Each AI type implements `play()` differently
- **Interface implementation**: All strategies implement the same interface

### Encapsulation
- **Private fields**: All classes use private fields with public getter methods
- **Information hiding**: Internal game state and AI logic are hidden from external classes

### Design Patterns
- **Strategy Pattern**: AI behaviours are encapsulated in separate strategy classes
- **Factory Pattern**: `AiFactory` creates appropriate AI instances based on difficulty

## Key Features

### Task 1: Basic Game Mechanics
- Start new games with difficulty level and number of rounds
- Human player input validation with colour parsing
- Round progression and power colour announcements (every 3rd round)
- Basic scoring system (1 point for correct guess, 3 points for power colour guess)

### Task 2: Easy AI Implementation
- Random AI strategy for colour selection and guessing
- Consistent AI behaviour using seeded random generators
- Proper opponent setup and game flow

### Task 3: Medium AI Implementation
- First round uses random strategy
- Subsequent rounds use avoid-last strategy (never plays opponent's last colour)
- Strategy switching based on round progression

### Task 4: Hard AI Implementation
- First two rounds use random strategy
- Third round switches to least-used strategy
- Adaptive strategy selection: switches to avoid-last if AI loses, keeps current strategy if AI wins
- Tracks colour usage history for least-used strategy

### Task 5: Game Statistics and State Management
- Comprehensive statistics display (player points, round outcomes)
- Game state validation (prevent actions when game not started/ended)
- Game termination with winner determination
- State reset when starting new games

## Game Rules

### Scoring System
- **1 point**: Correctly guessing opponent's colour choice
- **3 points**: Correctly guessing opponent's colour when it's the power colour
- **0 points**: Incorrect guess

### Power Colours
- Announced every 3rd round (rounds 3, 6, 9, etc.)
- Randomly selected at the start of each power round
- Provide bonus points for correct guesses

### AI Difficulty Levels
- **Easy**: Always uses random strategy
- **Medium**: Random for first round, then avoid-last strategy
- **Hard**: Random for first two rounds, then adaptive strategy selection

## Testing

The project includes comprehensive test suites for all five tasks:
- **Task 1 Tests**: Basic game mechanics, input validation, and power colour announcements
- **Task 2 Tests**: Easy AI random behaviour and scoring
- **Task 3 Tests**: Medium AI strategy switching and avoid-last behaviour
- **Task 4 Tests**: Hard AI adaptive strategy selection and performance tracking
- **Task 5 Tests**: Statistics display, game state management, and winner determination

## Provided Components

The following classes were provided by the course:
- `Main.java` - CLI interface and command processing
- `MessageCli.java` - Message constants and formatting
- `Utils.java` - Utility functions and random generators
- `MainTest.java` - Comprehensive test cases
- `SysCliTest.java` - Test framework
- `Colour.java` - Colour enum and utility methods
