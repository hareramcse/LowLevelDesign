# Low Level Design — Interview Prep

Java 21 Eclipse projects for common LLD interview problems. Each folder is standalone with a `*Test.java` or `main()` demo.

## Projects

| # | Project | Patterns / focus |
|---|---------|------------------|
| 1 | [ATM](./ATM/) | State, Singleton, Chain of Responsibility |
| 2 | [BookMyShow](./BookMyShow/) | Singleton, Observer, booking flow |
| 3 | [CarParking](./CarParking/) | Parking lot, slots, tickets |
| 4 | [CarRentalSystem](./CarRentalSystem/) | Strategy (pricing), VehicleType enum |
| 5 | [ChessGame](./ChessGame/) | Board, PieceType enum, simple moves |
| 6 | [ConsistentHashing](./ConsistentHashing/) | Hash ring |
| 7 | [CricBuzz](./CricBuzz/) | Cricket match, Observer score updates |
| 8 | [ElevatorDesign](./ElevatorDesign/) | Elevator scheduling |
| 9 | [GossipProtocol](./GossipProtocol/) | Gossip propagation |
| 10 | [LibraryManagement](./LibraryManagement/) | Book checkout/return |
| 11 | [LoggingFramework](./LoggingFramework/) | Log levels, appender strategy |
| 12 | [PubSubSystem](./PubSubSystem/) | Broker, topics, subscribers |
| 13 | [RateLimiter](./RateLimiter/) | Token bucket, sliding window, etc. |
| 14 | [SnakeLadder](./SnakeLadder/) | Board game simulation |
| 15 | [TaskManagementSystem](./TaskManagementSystem/) | Tasks, users, status |
| 16 | [TicTacToe](./TicTacToe/) | 2-player game |
| 17 | [TrafficSignal](./TrafficSignal/) | Signal controller |
| 18 | [VendingMachine](./VendingMachine/) | State pattern |

## Design principles (interview-friendly)

- **One pattern per concern** — no extra factories/interfaces unless they teach something
- **Records & enums** where they cut boilerplate
- **Public fields** on small domain objects when it aids whiteboard recall
- **Shared helpers** in state base classes (`returnToIdle`, `reject`) to avoid copy-paste

## Run a demo

```bash
cd <Project>/src
javac com/hs/*.java   # add subpackages if needed
java com.hs.<Project>Test
```

Example — ATM:

```bash
cd ATM/src
javac com/hs/*.java com/hs/states/*.java com/hs/amountwithdrawal/*.java
java com.hs.ATMTest
```
