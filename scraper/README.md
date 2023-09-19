# Purpose

This module represents an HTTP Client (scraper, crawler) which tries to collect
initial content with all the relations, references saved by requesting domain
entities hierarchically (from parent to children, then their children and so on).

## About `mapper` package

Data Crossing Boundaries

Typically data crossing the boundaries consist of simple data structures.
DO NOT PASS ENTITY OBJECTS OR DATA ROWS!
This would violate the dependency rules.
Data is passed in the format that is most convenient to the inner circle / layer
These are isolated, simple data structures.
Meaning our DTOs needed to cross the boundaries should belong in the inner circle,
or at least their definition (interface, abstract class).