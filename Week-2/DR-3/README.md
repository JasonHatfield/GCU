### Week 3: Discussion Response 3
---
One of the essential SQL keywords is the "UPDATE" keyword. It allows you to modify existing data in a database table. This keyword can be handy in various situations, such as when you need to correct mistakes in data that has already been entered or when you need to change the values of specific columns for a group of rows.

For example, let us say you have a customer database, and you notice that you have incorrectly entered the phone number for one of your customers. You can use the "UPDATE" keyword to quickly fix this mistake by issuing a query like this:
``` SQL
UPDATE customers
SET phone_number = '555-555-5555'
WHERE customer_id = 1;
This query will update the phone_number column for the row with a customer_id of 1 to the new value of '555-555-5555'.
```
The "UPDATE" keyword can also modify multiple rows at once. For example, if you need to update the phone_number for all customers in a particular city, you can use a query like this:

``` SQL
UPDATE customers
SET phone_number = '555-555-5555'
WHERE city = 'New York';
```
This query will update the phone_number column for all rows where the city column has a value of 'New York'.

Being able to update data in a database easily can be extremely useful in various situations, whether correcting mistakes, updating customer information, or simply keeping your data current. Therefore, it is an essential skill to have when working with databases.
