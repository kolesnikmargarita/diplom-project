# Graduation project

## The essence of the project:

This project allows you to store product information by category and view it. Authorized users can add and remove products from their cart, and view information about the products they've added to their cart.
The project includes administrator and user roles. Administrators can add, edit, and delete products and categories.

## Launching the application

You can deploy and launch the application using IntelliJ IDEA Ultimate or Docker, Docker Compose.

To launch via IntelliJ IDEA Ultimate, you need to add the following environment variables and assign them the appropriate values:
1) SHOP_DB_HOST - host for connecting to the database
2) SHOP_DB_NAME - database name
3) SHOP_DB_USER - username for connecting to the database
4) SHOP_DB_PASSWORD - password for connecting to the database
After adding the environment variables you can launch the application.

For launching via Docker Compose you need to rename the .evn.example file to .evn oк create a .evn file  in the same folder as .evn.example. In the .evn file, you need to initialize the variables from the .evn.example file with the appropriate values. Next, you need to build the image using Maven->Lifecycle->package, upload it, and run the project using the commands below.

## Upload image:

```shell
docker build -t diplom-project .
```

## Deploy with Docker Compose:
```shell
docker compose up backend -d
```

## Stop the project:

```shell
docker compose down
```

##Endpoints:

Requests that do not require authorization:
POST-requests:
http://localhost:8080/auth/registration - user registration
http://localhost:8080/auth/login - user authorization
GET-requests:
http://localhost:8080/shop - product list
http://localhost:8080/shop/categories - product categories
http://localhost:8080/shop/{categoryName} - product list of category named {categoryName}

Requests available to an authorized user:
POST-request:
http://localhost:8080/cart/{article} - add product with article number {article} to the current user's cart
DELETE-request:
http://localhost:8080/cart/{article} - Remove item with article number {article} from the current user's cart
GET-request:
http://localhost:8080/cart - display a list of products added to the cart by the current user

Requests available to authorized users with administrator rights
POST-requests:
http://localhost:8080/edit/{categoryName} - add a new product to the database
http://localhost:8080/edit - add a new category to the database
PUT-request:
http://localhost:8080/edit/{categoryName} - edit information about the category named {categoryName}
PATCH-request:
http://localhost:8080/edit/{article} - edit product information with article number {article}
DELETE-request:
http://localhost:8080/edit/{article} - delete product with article number {article}

More detailed information can be found in the swagger documentation at this link (the page is available while project is run):
http://localhost:8080/swagger-ui/index.html

You can send instructions using the postman