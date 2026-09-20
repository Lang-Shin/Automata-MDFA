# Automata-MDFA

Automata activity — **Minimal DFA** (MDFA) examples written in Java.

This repository contains four standalone Java programs that implement
deterministic finite automata (DFA) over the binary alphabet `{0, 1}`. The
programs solve a classic automata exercise: building a **minimal DFA** (the
smallest number of states that still describes a given language). State names
like `AC`, `BC`, `CDE`, `EF` hint at the merging of equivalent states used when
minimizing the automata.

## Programs

| File        | Accepted language                                   | Input            |
| ----------- | --------------------------------------------------- | ---------------- |
| `MDFA1.java`   | Binary strings **ending in `011`**                  | stdin            |
| `MDFA2.java`   | Binary strings with **exactly one `1`**             | stdin            |
| `MyMDFA1.java` | Binary strings containing a `0` at an index `i ≡ 2 (mod 3)` (0-indexed) | hardcoded test cases |
| `MyMDFA2.java` | Strings of length ≥ 3, or length-2 strings whose second symbol is `1`   | hardcoded test cases |

Each program prints `ACCEPTED` or `REJECTED` for every input string it checks.

### Program details

- **MDFA1.java** — reads one binary string and reports whether it ends with
  `011`. Four states: `AC` (start), `B`, `D`, and `E` (accepting). The result
  is the trailing-run-of-ones reasoning: the string must contain a `0` and end
  with exactly two `1`s.

- **MDFA2.java** — reads one binary string and reports whether it contains
  exactly one `1`. Three states: `AB` (zero `1`s seen), `CDE` (one `1` seen,
  accepting), and `F` (two or more `1`s — dead). Moving the second `1` moves the
  automaton into the dead state `F` forever.

- **MyMDFA1.java** — runs a fixed set of test cases (`000`, `110`, `111`, `00`)
  with 2 accepted and 2 rejected. The automaton accepts when a `0` is read
  while in state `D` (a `1` in state `D` resets to state `A`), which happens
  whenever a `0` occurs at a 0-indexed position `2, 5, 8, ...`.

- **MyMDFA2.java** — runs a fixed set of test cases (`01`, `11`, `00`, `0`)
  with 2 accepted and 2 rejected. State `A` funnels into `BC`; a `1` in `BC`
  moves to the accepting sink `EF`, while `0` and any later symbol also reach
  `EF`, so only very short strings can be rejected.

## Requirements

- Java (JDK) installed and available on the `PATH` (`javac`, `java`).

## Running

Compile and run any program. For programs that read from stdin, the input is
typed when prompted:

```sh
javac MDFA1.java
java MDFA1

Enter binary string: 011
ACCEPTED
```

```sh
javac MyMDFA1.java
java MyMDFA1

Input: 000 -> ACCEPTED
Input: 110 -> ACCEPTED
Input: 111 -> REJECTED
Input: 00  -> REJECTED
```