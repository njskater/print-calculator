# A demo print cost calculator program for Papercut

-------------
Design Notes:
-------------
Reading requirements, basically we need to find:  
* An approach to read data
* An way to calculate price
* An way to output data

Following above logic, steps that I solve these requirements are roughly as follows:
1. Design Models
2. Design Interfaces
3. Implement and test input components
4. Implement and test output components
5. Implement and test service components
6. Implement and test main class

Some general rules I normally follows during design and implementation:
1. Use loosely coupled components
2. Classes with single responsibility
3. User Immutable Object whenever possible
4. Use code as document and only write necessary java docs and comments
5. Unit test meaningful components

---------------------
System Requirements
---------------------
Application tested on Mac OSX 10.10 and 10.11  
Requires:  
JDK 1.8+  
MAVEN 3.0+

------------------------------------
To run this application:
------------------------------------
```
./run.sh
```