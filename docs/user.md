#User API Spec

## Register User

- Endpoint: POST `/api/auth/register`
- Request Body: 
```json
{
    "username": "username",
    "password": "password",
    "name": "name",
}
```
- Response Body Success:
```json
{
    "data": "OK"
}
```
- Response Body Error:
```json
{
    "errors": "error message"
}
```

## Login User

- Endpoint: POST `/api/auth/login`
- Request Body: 
```json
{
    "username": "username",
    "password": "password",
}
```
- Response Body Success:
```json
{
    "data": {
      "token": "token",
      "expiredAt": 22123215231
    }
}
```
- Response Body Error:
```json
{
    "errors": "error message"
}
```

## Logout User

## Get User

## Update User