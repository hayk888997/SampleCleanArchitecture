# SampleCleanArchitecture

Goal is to build an Android app that allows a user to request arbitrary numbers in the Fibonacci sequence. Additionally, this app should allow users to see what numbers were previously requested and at what time. Of course this history should be persistent between sessions.


Provided solution might seem to be overkill for the goal, but if you want to keep SOLID principles and have fully scalable app, then this is what you need to have.

Used tech stack (and reason I choose this) is the following

1. Kotlin (no reason to tell why :) )
2. Clean arch + MVVM (Best architecture that provides quite good scalability)
3. Koin for DI (Is much cleaner then Dagger or Hilt, no dummy annotations)
4. Coroutines for multithreading (best option for Kotlin these days because of easiness to use and amazing performance)
5. Room for storing data in DB (Latest best solution for local DB. I chose DB having in mind future perspectives and need of extending local storage)

Related to architecture, there is supposed to be 3 main layers for each features: data, domain and presentation.
* Presentation layer contains view and viewModel related information.
* Domain layer contains business logic, like repository, use cases and fully depends on abstractions rather than concrete implementations. The goal is keep dependency inversion principle and have domain layer fully unit testable.
* Data layer contains concrete implementations, in this case repository implementation using room database.

I created just one screen (activity) and placed history and generator UI inside. In that scenario I consider that there is only one feature which contains history logic as well. 
