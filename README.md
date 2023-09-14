
Crud API Endpoints
-----------------------

Method  POST
http://localhost:9091/api/book/create
{
    "author": "Kishore",
    "description":"Story of village Boy",
    "title":"Farmer",
    "publisher":"Navneet Publication",
    "price":333,
    "pages": 4000

}
----------

Method : PUT
http://localhost:9091/api/book/update
{
    "author": "Kishore Kumar",
    "description":"Story of village Boy",
    "title":"Farmer",
    "publisher":"Navneet Publication",
    "price":333,
    "pages": 4000,
    "id":4

}
----------
Method : GET
http://localhost:9091/api/book/getAll

----------

Method : GET
http://localhost:9091/api/book/3

----------
Method : DELETE
http://localhost:9091/api/book/4