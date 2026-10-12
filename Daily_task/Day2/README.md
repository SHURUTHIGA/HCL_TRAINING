# Monthly Usage Analyser

A beginner-friendly Java console project that analyses monthly usage data and demonstrates arrays, loops, casting, ternary operators, constants, slab calculations, and `long` arithmetic.

## Features

- Stores 12 months of usage in an `int[]`.
- Calculates total, average, maximum, and minimum usage.
- Uses explicit casting to calculate a fractional average.
- Assigns a grade (`A` to `D`) with a nested ternary operator.
- Uses `long` for totals and charge calculations to reduce integer-overflow risk.
- Calculates an illustrative usage charge using configurable slabs.
- Uses a 2-D array to compare usage across three houses.
- Includes seven days of sample usage data.

## Project structure

```text
monthly-usage-analyser/
├── src/
│   ├── Constants.java
│   ├── MonthlyUsageAnalyser.java
│   └── SampleData.java
├── .gitignore
└── README.md
```

## Requirements

- Java JDK 8 or newer
- Git

## Compile and run

From the project root:

```bash
javac src/*.java
java -cp src MonthlyUsageAnalyser
```

## Business rules

The slab limits, slab rates, and grade thresholds are in `src/Constants.java`. The rates are illustrative examples, not official tariffs. Change them if your assignment provides specific values.

## Sample data

`SampleData.java` contains:
- 12 monthly values for House 1
- 12 monthly values for each of three houses
- Seven daily values for a sample week

## Concepts demonstrated

- One-dimensional and two-dimensional arrays
- Loops and conditionals
- `long` arithmetic for totals and charges
- Explicit type casting for average calculations
- Ternary operator for grade selection
- Constants for maintainable business rules
