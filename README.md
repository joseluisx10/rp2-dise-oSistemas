ORDEN DE USO


1).Se debe crear primero producto
 {
     "nombre": "zapato nike",
      "descripcion": "zapato nike",
      "precio": 212.2,   
  }

  2) Crear categoria
    //http://localhost:8080/categorias?productoIds=1,....   
   
      {
          "nombre" : "botines",
          "productos": []
      }

   3) Crear pedido
   //http://localhost:8080/pedidos?productoIds=1,....
     {
      "fecha": "2024-07-10",
      "estado": "PENDIENTE"
      }

   4) Crear usuario
      //http://localhost:8080/usuarios?pedidoIds=1,......
      {
         "id": 1,
         "username": "jose",
         "password": "123",
         "email": "jose@gmail.com",
         "rol": "admin"
       }
