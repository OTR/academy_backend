# Purpose

This module represents core business logic, just POJO objects, independent of any third-party
library, framework, dependency:

 * domain entities (models)
 * use cases
 * repository interfaces

`model` package represents domain entities (just data classes) -
building blocks of application's business logic.
An object that contains critical business rules and critical business data.
These should be separated from every other concern in the application.
No dependencies on databases, 3rd party dependencies, user interfaces, etc.
These objects are pure business.

`use_case` package represents business demands on the application. Some actions
 need to be performed in human-readable form.
Use cases are application specific business rules.
Changes should not impact the Entities.
Changes should not be impacted by infrastructure such as a database.
The use cases orchestrate the flow of data in/out of the Entities 
and direct the Entities to use their Critical Business Rules to achieve the use case.


`repository` package represents (API) interfaces need to implemented by
any backing data source to the application.

`response` package contains utility data structures that are just containers to
make transferring domain entities easier.

## Dependency Inversion Principle

Use case needs to call a presenter – doing so would violate the dependency rule:
inner circles cannot call (or know about) outer circles.
The use case would need to call an interface.
The implementation of that interface would be provided by the interface adapter layer
– this is how the dependency is inverted.
This same type of inversion of control is used all throughout the architecture to invert the flow of control.
