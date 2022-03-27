# text-crud
incubyte assesment

## TECHNOLOGIES USED

* Back End: Spring
* Front End:
* Angular CLI: 13.3.0
* Node: 16.13.2
* Package Manager: npm 8.1.2
* Database: H2 (in memory)
---------------------------------------

## How to run

### Back End
* currently it is set to run in local machine, I haven't configure it for dev.
* port is 8080
* run spring application (text-crud-back)

### Front End 
* go to text-crud-front
* run npm install
* run command npm start
* go to localhost:4200

## Apis which are working
* GET localhost:5000/api/delete/{id} -- For Deletion
* POST localhost:5000/api/add-word  -- For insertion (require a data body )
```
{
    "word":"shesho"
}
```
* GET localhost:5000/api/get-words -- show all
