## Test task. Launch and API
1. To run the project, you need to fork the repository, build the jar, build image with docker, and run container. 
2. Available endpoints
### User
- POST api/users - user creation, required fields for the request body 
```js
{
    "name": "", 
    "email": "",
    "password": ""
}
```
### Quote
- GET api/quotes - return top 10 quotes, sorted by score
- GET api/quotes/{id} - return quote by id with statistic (the list of votes includes the user's ID, his vote true/false (like/dislike) and the time when the user voted)
- POST api/quotes - quoter creation, required fields for the request body. For an authorized user, a quote will be created attached to him (not implemented now, because it is written in the test that it is not necessary to implement authentication). By default, the quote is created by an anonymous user.
```js
{
     "content": "",
     "author": ""
}
```
- PATCH api/quotes/{id}/vote/{like} - {like}(true/false) for a quote with {id} (since authentication is not implemented, the post with the {id} will be randomly like or dislike by the random user with the id (1-9))
- PATCH api/quotes/{id} - update quote with {id}, required fields for the request body.
```js
{
     "content": "",
     "author": ""
}
```
