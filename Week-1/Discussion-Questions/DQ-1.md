## Topic 1 DQ 1

Your textbook discusses a relationship between classes called “association.” 
Think about the class project you are currently designing. 
- What associations exist between the Product and the Dispenser class? 
- What is the multiplicity of these associations?
---
> Association is a general binary relationship that describes an activity between two classes (Liang, 2019, p. 472). 

So, for example, my class project currently has two classes: a StoreFront and a Product class. The StoreFront class can exist without a Product class; however, the Product class cannot exist without the StoreFront class.

My project so far has designed the StoreFront class to be the parent class of the Product class and the driver for the program when the user accesses the store. The Product class is the child of the StoreFront class and, therefore, cannot exist without it. Multiplicity becomes essential when developing the UML because the programmer can illustrate "how many of the class's objects are involved in the relationship" (Liang, 2019, p. 472). For example, the storefront can have an infinite number of products, whereas each product can only have one storefront.

Reference:

Liang, Y. (2019). Introduction to Java Programming and Data Structures, Comprehensive Version (12th ed.). Pearson.
