# Purpose

This module represents `Interface Adapters` layer (Transport?).

Converts data from data layers to use case or entity layers.
Presenters, views and controllers all belong here.
No code further in (use cases, entities) should have any knowledge of the db.


[https://netflixtechblog.com/ready-for-changes-with-hexagonal-architecture-b315ec967749]()

[https://ru.scribd.com/document/459783185/Clean-Architecture#]()

## About `controller` package

Crossing Boundaries.

Flow of control went from the controller, through the application use case, then to the presenter.
Source code dependencies point in towards the use cases.


