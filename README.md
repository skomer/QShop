### Android app allowing a shop to order in new stock, and have discounts applied to the stock items.

## Development

I began this task by considering what the models in the app would look like, and and what state might change as a user interacted with the app. I then began to build up a simple shop, that could have products in its stock. Then, I moved on to implementing discounts applied to the products, and the shop being able to order in more stock (with discounts applied) when it wanted to. I tried to practise test-driven development throughout, which certainly helped to keep my classes functioning as expected.


## The Challenge

The way I approached the task left me wanting to build a complex, tested and interactive app which would allow both the shop and a customer to make purchases, with appropriate discounts applied. However, it's clear that I underestimated the complexity of such a task and as a result the current app only shows the shop, without the customer or shop stock features.


## Features
The shop can:
- view its balance (the shop loads with a balance of 1000.00)
- view a product catalogue, of available products to order
- select a product to order
- order either one or a multiple of the selected product
- see that its balance changes when the shop orders
- not complete the order if the balance is too low.

## Diagram

![alt text](https://raw.githubusercontent.com/skomer/QShop/master/qshop.png)