A Java-based simulation of an ecosystem with animals and plants evolving over time.

Features
 • Grid-based island (configurable size)
 • Animals: predators and herbivores (extensible hierarchy)
 • Plants growth system
 • Movement, eating, reproduction, and starvation mechanics
 • Configurable behavior (speed, energy, limits, probabilities)
 • Food chain via probability matrix (EatMatrix)
 • Thread-safe simulation with: ScheduledExecutorService, Worker thread pool (parallel processing per cell)

Tech Stack
 • Java 17
 • Concurrency: ScheduledExecutorService, ExecutorService
 • OOP design with extensible class hierarchy
 
⸻

Run

javac Main.java
java Main

⸻

License

MIT
