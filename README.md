## Project Description

This is an educational project aimed at learning Spring Framework and Clean Architecture.
This project is an unofficial client for a popular educational platform.
The learning method consists of reading a small amount of theory 
 and completing practical projects that implement this theory.
The primary way of delivering the material is through text and diagrams, including flowcharts.
The portal also includes elements of spaced repetition for better retention 
 of previously covered material.

## Architecture decisions

The project has a hexagonal structure, where the core business logic (the `domain` module)
 is at the center, and on the periphery are the `details` input and output ports.
The business logic is not tied to any specific dependency, web framework, or database.
The backend of the web application, written in Spring, is located in the `spring_backend` module.
One of the input ports that collects data is located in the `scraper` module.
The data source for the web application is not tightly coupled to the web application itself
 and is located in the `spring_details` module.

## TODO

Make H2 database work in server mode

https://stackoverflow.com/questions/55830010/how-to-enable-h2-database-server-mode-in-spring-boot
