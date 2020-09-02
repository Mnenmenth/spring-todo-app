## spring-todo-app
RESTful web app for managing TODO items

## Setting up
#### Requirements
* [A MySQL server](https://dev.mysql.com/downloads/)
* Java JDK 1.8 (Either Oracle JDK or OpenJDK)
    * [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
    * [OpenJDK](https://openjdk.java.net/install/)

#### Setup Database
1) Connect to your MySQL server as a user who can create new users  
2) Run the following commands:
```sql
mysql> create database tododb;
mysql> create user 'todo'@'%' identified by 'insecurepassword';
mysql> grant create, select, insert, delete, update on tododb.* to 'todo'@'%';
```

## Usage
### Running
In the project directory, run
```shell
./gradlew bootRun
```

### Available [CURL](https://curl.haxx.se/) commands
#### Create a TodoItem
```shell
curl -X POST localhost:8080/todoapp/new -d name='{name}' -d description='{description}'
```
* This will respond with `200 OK` and the newly created TodoItem on success  
* Example:
    ```shell
    $ curl -X POST localhost:8080/todoapp/new -d name='name' -d description='description'
    {"id":1,"name":"name","description":"description","complete":false}
    ```

#### Delete a TodoItem
```shell
curl -X DELETE localhost:8080/todoapp/delete/{id}
```
* This will respond with `204 No Content` on success and `422 Unprocessable Entity` with an error message if the id doesn't exist
* Example
    ```shell
    $ curl -X DELETE localhost:8080/todoapp/delete/1
    ```

#### Updating a TodoItem
```shell
curl -X PATCH localhost:8080/todoapp/{id} -d name='{name}' -d description='{description}' -d complete='{complete}'
```
* This will respond with `200 OK` and the updated TodoItem on success and `422 Unprocessable Entity` with an error message if the id doesn't exist
* Example:
    ```shell
    $ curl -X PATCH localhost:8080/todoapp/update/1 -d complete='true'
    {"id":1,"name":"name","description":"description","complete":true}
    ```
* Notes:
    * All `-d <param>='{}'` parameters are optional
    * `{complete}` must be `true` or `false`

#### Finding a TodoItem by ID
```shell
curl -X GET localhost:8080/todoapp/find/id/{id}
```
* This will respond with `200 OK` and the found TodoItem on success and `422 Unprocessable Entity` with an error message if the id doesn't exist
* Example:
    ```shell
    $ curl -X GET localhost:8080/todoapp/find/id/1
    {"id":1,"name":"name","description":"description","complete":false}
    ```

#### Finding a TodoItem by name
```shell
curl -X GET localhost:8080/todoapp/find/name/{name}
```
* This will respond with `200 OK` and a list of found TodoItem(s) on success and `422 Unprocessable Entity` with an error message if `{name}` has no matches
* Example:
    ```shell
    $ curl -X GET localhost:8080/todoapp/find/name/name
    [{"id":1,"name":"name","description":"description","complete":false},{"id":2,"name":"name","description":"another description","complete":false}]
    ```
* Notes:
    * A name containing spaces must have the spaces replaced with `%20` in the url  
    i.e. `localhost:8080/todoapp/find/name/name%20with%20spaces`
  
#### Finding all TodoItems
```shell
$ curl -X GET localhost:8080/todoapp/find/all
```
* This will respond with `200 OK` and a list of found TodoItem(s) on success and an empty list (`[]`) if none there are no TodoItems
* Example:
    ```
    $ curl -X GET localhost:8080/todoapp/find/all
    [{"id":1,"name":"name","description":"description","complete":false},{"id":2,"name":"name","description":"another description","complete":false}]
    ```

#### Some additional notes
* Replace any brackets `{}` in the commands with your actual input  
  i.e. Replace `'{name}'` with `'my todoitem name'`  
  
* You may optionally add `-w "\n"` to any CURL command to print a new line after the servers response

* An item's id can be found in the response from creating an item or in the response from searching for item(s)