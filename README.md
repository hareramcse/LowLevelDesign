# Low Level Design

## Projects (priority order)

| # | Project | Why it matters | Patterns / focus |
|---|---------|----------------|------------------|
| 1 | [CarParking](./CarParking/) | Asked almost everywhere | Multi-floor, spot types, ticket, pricing |
| 2 | [VendingMachine](./VendingMachine/) | Classic state-machine question | State, change maker, cancel |
| 3 | [ElevatorDesign](./ElevatorDesign/) | Scheduling & request handling | Direction, floor queue |
| 4 | [RateLimiter](./RateLimiter/) | Very common at big tech | Token bucket, sliding window |
| 5 | [BookMyShow](./BookMyShow/) | Seat booking, double-booking risk | Singleton, Observer |
| 6 | [Splitwise](./Splitwise/) | Expense split & settle balances | Strategy (equal/exact) |
| 7 | [FoodDelivery](./FoodDelivery/) | Swiggy/Zomato-style flow | Observer, order status |
| 8 | [LoggingFramework](./LoggingFramework/) | “Design a logger” classic | Strategy (appenders), levels |
| 9 | [PubSubSystem](./PubSubSystem/) | Messaging backbone | Broker, topics, subscribers |
| 10 | [HotelBooking](./HotelBooking/) | OYO/booking variant | Date overlap, room types |
| 11 | [MeetingScheduler](./MeetingScheduler/) | Calendar & conflicts | Room + attendee overlap |
| 12 | [ATM](./ATM/) | State pair with VendingMachine | State, note dispensing |
| 13 | [LibraryManagement](./LibraryManagement/) | Clean OOP & business rules | Catalog, borrow limits |
| 14 | [StackOverflow](./StackOverflow/) | Q&A, voting, search | Tags, reputation |
| 15 | [TaskManagementSystem](./TaskManagementSystem/) | Jira/Todo-style | CRUD, filter, status |
| 16 | [UrlShortener](./UrlShortener/) | Sometimes LLD, often HLD intro | Singleton, Base62 |
| 17 | [CarRentalSystem](./CarRentalSystem/) | Fleet rental / Zoomcar-style | Reservation, overlap, pricing |
| 18 | [ChessGame](./ChessGame/) | Game design (senior roles) | Board, PieceType enum |
| 19 | [TicTacToe](./TicTacToe/) | Simpler game warmup | 2-player, win check |
| 20 | [CricBuzz](./CricBuzz/) | Observer practice | Match, score updates |
| 21 | [SnakeLadder](./SnakeLadder/) | Board simulation | Dice, snakes, ladders |
