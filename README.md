# 📦API-store
Um back-end desenvolvido em SpringBoot para gerenciamento de um e-commerce simples, com endpoints REST para produtos, categorias, compras e etc.

## 🔧Tecnologias

- Java
- SpringBoot
- Gradle

**Dependências:**

- spring-boot-starter
- spring-boot-starter-web:3.5.3
- spring-boot-starter-data-jpa
- spring-boot-starter-test
- org.junit.platform:junit-platform-launcher
- com.h2database:h2:2.3.232
- org.postgresql:postgresql:42.7.7

## Diagrama de classe

![img.png](diagram_class.png)

## Requisições

**Get Order**

```
    GET http://localhost:8080/orders/1
```

**Output:**

```
    {
    "id": 1,
    "moment": "2019-06-20T19:53:07Z",
    "orderStatus": "PAID",
    "client": {
        "id": 1,
        "name": "Maria Brown",
        "email": "maria@gmail.com",
        "phone": "988888888",
        "password": "123456"
    },
    "orderItems": [
        {
            "quantity": 2,
            "price": 90.5,
            "subTotal": 181.0,
            "product": {
                "id": 1,
                "name": "The Lord of the Rings",
                "description": "Lorem ipsum dolor sit amet, consectetur.",
                "price": 90.5,
                "imgUrl": "",
                "categories": [
                    {
                        "id": 2,
                        "name": "Books"
                    }
                ]
            }
        },
        {
            "quantity": 1,
            "price": 1250.0,
            "subTotal": 1250.0,
            "product": {
                "id": 3,
                "name": "Macbook Pro",
                "description": "Nam eleifend maximus tortor, at mollis.",
                "price": 1250.0,
                "imgUrl": "",
                "categories": [
                    {
                        "id": 3,
                        "name": "Computers"
                    }
                ]
            }
        }
    ],
    "payment": {
        "id": 1,
        "date": "2019-06-20T21:53:07Z"
    },
    "total": 1431.0
}
```