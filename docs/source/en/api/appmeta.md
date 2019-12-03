layout: api
title: Appmeta
---

This document mainly explains that we use remote API service to operate Appmeta.

> Note: for all relevant Appmeta operations, the system will automatically obtain the ID of the current logged-in user as the unique token for data association storage, which does not require the user to set autonomously.

#### Create Appmeta

---

URL: `/appmeta/create`

Method: `POST`

##### Request Param

None

##### Request Body

|Field Name|Value|Description|Type|Length|Require|
|---|---|---|---|---|---|
|**name**|-|name|string|-|Yes|
|**displayName**|-|display name|string|-|Yes|

##### Response Status

|Code|Description|Schema|
|---|---|---|
|2000|OK|Result|
|401|Unauthorized|-|

##### Response Params

|Field Name|Value|Description|Type|Length|Require|
|---|---|---|---|---|---|
|**code**|-|status code|integer|-|Yes|
|**message**|-|message(Errors will be displayed if there are any)|string|-|Yes|
|**detail**|-|detail|Object|-|Yes|
