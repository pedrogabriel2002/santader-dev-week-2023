# santader-dev-week-2023
Java RESTful API criada para a Santander Dev Week.

## Métodos
Para testar os metódos da API visite: [Railways](https://santader-dev-week-2023-production.up.railway.app/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config)
- ### Cadastrar(create user)

| Method     | URI                               | File                         |
|------------|-----------------------------------|------------------------------|
| `POST`     | `/users`                          |  [UserController.java](https://github.com/pedrogabriel2002/santader-dev-week-2023/blob/main/src/main/java/pedrogabriel/controller/UserController.java)   | 

- ### Ler(read users)

| Method     | URI                               | File                         | 
|------------|-----------------------------------|------------------------------|
| `GET`      | `/users`                          |  [UserController.java](https://github.com/pedrogabriel2002/santader-dev-week-2023/blob/main/src/main/java/pedrogabriel/controller/UserController.java) | 
| `GET`      | `/users/{id}`                     |  [UserController.java](https://github.com/pedrogabriel2002/santader-dev-week-2023/blob/main/src/main/java/pedrogabriel/controller/UserController.java) | 

- ### Editar Usuário(update user)

| Method     | URI                               | File                         |
|------------|-----------------------------------|------------------------------|
| `PUT` | `/users/{id}`               | [UserController.java](https://github.com/pedrogabriel2002/santader-dev-week-2023/blob/main/src/main/java/pedrogabriel/controller/UserController.java)|

- ### Delete Usuário(delete user)

| Method     | URI                               | File                         |
|------------|-----------------------------------|------------------------------|
| `DELETE`   | `/user/{id}`                      | [UserController.java](https://github.com/pedrogabriel2002/santader-dev-week-2023/blob/main/src/main/java/pedrogabriel/controller/UserController.java)|
