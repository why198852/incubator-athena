layout: api
title: Golbal Security
---

This document mainly shows that we use remote API services to obtain authorization tokens.

#### User Authorized

---

URL: `/auth/login`

Method: `POST`

##### Request Param

None

##### Request Body

|Field Name|Value|Description|Type|Length|Require|
|---|---|---|---|---|---|
|**username**|-|user name|string|-|Yes|
|**password**|-|current login user password|string|-|Yes|

##### Request Example

```java
curl --location --request POST 'http://127.0.0.1:8080/auth/login' \
--header 'Content-Type: application/json' \
--data-raw '{
        "username": "admin",
        "password": "admin"
}'
```

##### Response Status

|Code|Description|Schema|
|---|---|---|
|2000|OK|Result|
|401|Unauthorized|-|

##### Response Params

|Field Name|Value|Description|Type|Length|Require|
|---|---|---|---|---|---|
|**code**|-|response status code|integer|-|Yes|
|**message**|-|response message(Errors will be displayed if there are any)|string|-|Yes|
|**detail**|-|response detail|Object|-|Yes|

##### Response Example

- Success

```java
{
    "code": 2000,
    "message": "Successful run. See details for the results",
    "detail": {
        "token": "eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyTmFtZSI6ImFkbWluIiwiZXhwIjoxNTc1Nzc2MTk5LCJ1c2VySWQiOiIxIn0.1_VRdYjFzf4458ZuPphRL5h_TMRQh__FoQ_kQkL2cqjWUpmVLMT1PP9Y2zfteRpkL-6whrMGKCMFOhqTx-a1_g",
        "username": "admin"
    }
}
```

- Has Error

```java
{
    "code": 5000,
    "message": "There is an exception on the server, please check the details",
    "detail": {
        "errorTime": "2019-12-03T11:37:08.444",
        "errorUrl": "http://127.0.0.1:8080/auth/login",
        "errorType": "Unauthorized",
        "errorStackTrace": null,
        "errorStatusCode": 401,
        "errorReasonPhrase": "Bad credentials",
        "remoteClient": "127.0.0.1"
    }
}
```
