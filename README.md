
# Crud API Endpoints

## Creat Book

**Method:** POST

**Enpoints:** `http://localhost:9091/api/book/create`

**Request Body** 

```json
{
    "author": "Kishore",
    "description":"Story of village Boy",
    "title":"Farmer",
    "publisher":"Navneet Publication",
    "price":333,
    "pages": 4000

}
```
-----
## Update Book

**Method:** PUT

**Enpoints:** `http://localhost:9091/api/book/update`

**Request Body**

```json
{
    "author": "Kishore Kumar",
    "description":"Story of village Boy",
    "title":"Farmer",
    "publisher":"Navneet Publication",
    "price":333,
    "pages": 4000,
    "id":4

}
``````
----------
## Gel All Books

**Method:** GET

**Enpoints:**  `http://localhost:9091/api/book/getAll`

----------

## Get Book By Id

**Method:** GET

**Enpoints:**  `http://localhost:9091/api/book/3`

----------
## Delete Book By Id

**Method:** DELETE

**Enpoints:**  `http://localhost:9091/api/book/4`

These are the REST API endpoints and operations available for managing books.

