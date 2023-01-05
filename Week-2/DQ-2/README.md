### Week 2: Discussion Question 2
---
#### Explain the following concepts in the e-commerce database of Milestone 1: Describe a single table that could be used in your e-commerce database. Give the table a useful name, primary key, and rows and columns. 
---
The `create`, `insert`, `delete`, and `update` SQL keywords are used to modify the data in a database.

The `create` keyword creates a new database or table. 

For example, you can use the following SQL statement to create a new table called *products*:
```sql
CREATE TABLE products ( 
  product_id INT PRIMARY KEY AUTO_INCREMENT, 
  product_name VARCHAR(255) NOT NULL, 
  product_price DECIMAL(10,2) NOT NULL 
);
```
The `insert` keyword is used to insert new rows into a table. 

For example, you can use the following SQL statement to insert a new row into the *products* table:
```sql
INSERT INTO products (product_name, product_price) 
VALUES 
("Product 1", 49.99);
```
The `delete` keyword is used to delete rows from a table. 

For example, you can use the following SQL statement to delete a row from the *products* table where the *product_id* is 1:
```sql
DELETE FROM products WHERE product_id = 1;
```
The `update` keyword is used to update the data in a table. 
For example, you can use the following SQL statement to update the *product_price* for all products in the *products* table to 49.99:
```sql
UPDATE products SET product_price = 49.99;
```
These SQL keywords can be beneficial when building queries in the future, as they allow you to easily modify the data in your database.

Retrieving or updating data about your customers and products can be particularly useful, as it allows you to understand better and serve your customers and manage your inventory and pricing. For example, you could use the `select` keyword to retrieve data about your customers' purchasing habits or the `update` keyword to change the price of a product based on its sales performance.

Overall, the `create`, `insert`, `delete`, and `update` SQL keywords are essential tools for managing and modifying data in a database. By learning to use these keywords, you can build powerful queries that allow you to retrieve, update, delete, and create data as needed. This can be especially useful when working with customer and product data, as it allows you to understand better and serve your customers and manage your inventory and pricing. By using these keywords effectively, you can gain valuable insights into your business and make informed decisions that drive growth and success.
