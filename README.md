# Low Level Design — Interview Prep

Java 21 Eclipse projects for common LLD interview problems. Each folder is standalone with a `*Test.java` or `main()` demo.

**Study in order below** — most frequently asked at product companies first.

## Projects (priority order)

| # | Project | Why it matters | Patterns / focus |
|---|---------|----------------|------------------|
| 1 | [CarParking](./CarParking/) | Asked almost everywhere | Slots, tickets, allocation |
| 2 | [VendingMachine](./VendingMachine/) | Classic state-machine question | State, Singleton |
| 3 | [ATM](./ATM/) | Same family as vending machine | State, note dispensing |
| 4 | [ElevatorDesign](./ElevatorDesign/) | Scheduling & request handling | Direction, floor queue |
| 5 | [RateLimiter](./RateLimiter/) | Very common at big tech | Token bucket, sliding window |
| 6 | [BookMyShow](./BookMyShow/) | Seat booking, double-booking risk | Singleton, Observer |
| 7 | [Splitwise](./Splitwise/) | Expense split & settle balances | Strategy (equal/exact) |
| 8 | [FoodDelivery](./FoodDelivery/) | Swiggy/Zomato-style flow | Observer, order status |
| 9 | [LoggingFramework](./LoggingFramework/) | “Design a logger” classic | Strategy (appenders), levels |
| 10 | [PubSubSystem](./PubSubSystem/) | Messaging backbone | Broker, topics, subscribers |
| 11 | [HotelBooking](./HotelBooking/) | OYO/booking variant | Date overlap, room types |
| 12 | [MeetingScheduler](./MeetingScheduler/) | Calendar & conflicts | Room + attendee overlap |
| 13 | [LibraryManagement](./LibraryManagement/) | Clean OOP & business rules | Catalog, borrow limits |
| 14 | [StackOverflow](./StackOverflow/) | Q&A, voting, search | Tags, reputation |
| 15 | [TaskManagementSystem](./TaskManagementSystem/) | Jira/Todo-style | CRUD, filter, status |
| 16 | [UrlShortener](./UrlShortener/) | Sometimes LLD, often HLD intro | Singleton, Base62 |
| 17 | [CarRentalSystem](./CarRentalSystem/) | Rental/inventory variant | Strategy (pricing) |
| 18 | [ChessGame](./ChessGame/) | Game design (senior roles) | Board, PieceType enum |
| 19 | [TicTacToe](./TicTacToe/) | Simpler game warmup | 2-player, win check |
| 20 | [CricBuzz](./CricBuzz/) | Niche; good Observer practice | Match, score updates |
| 21 | [TrafficSignal](./TrafficSignal/) | Occasional scheduling question | Signal controller |
| 22 | [SnakeLadder](./SnakeLadder/) | Rare at product companies | Board simulation |
| 23 | [ConsistentHashing](./ConsistentHashing/) | More system design than LLD | Hash ring |
| 24 | [GossipProtocol](./GossipProtocol/) | Distributed systems topic | Gossip propagation |

### Quick tiers

| Tier | # | Projects |
|------|---|----------|
| **Must know (1–10)** | Top 10 | CarParking → PubSub |
| **Strong second (11–17)** | Next 7 | HotelBooking → CarRental |
| **If time permits (18–24)** | Last 7 | Chess → Gossip |

> **LRU Cache** — covered in your Data Structures repo, not duplicated here.

## Design principles (interview-friendly)

- **One pattern per concern** — no extra factories/interfaces unless they teach something
- **Records & enums** where they cut boilerplate
- **Shared helpers** in state base classes (`returnToIdle`, `reject`) to avoid copy-paste

## Run a demo

```bash
cd <Project>/src
javac com/hs/*.java   # add subpackages if needed
java com.hs.<Project>Test
```

Example — CarParking:

```bash
cd CarParking/src
javac com/hs/*.java
java com.hs.VehicalParkingTest
```

Example — ATM:

```bash
cd ATM/src
javac com/hs/*.java com/hs/states/*.java com/hs/amountwithdrawal/*.java
java com.hs.ATMTest
```
