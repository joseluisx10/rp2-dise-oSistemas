-- Crear tabla de Categorías
CREATE TABLE IF NOT EXISTS categoria (
                                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                         nombre VARCHAR(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS producto (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(255) NOT NULL,
                          descripcion VARCHAR(255),
                          precio DOUBLE NOT NULL,
                          categoria_id BIGINT,
                          FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);


-- Crear tabla de Usuarios
CREATE TABLE IF NOT EXISTS usuario (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         username VARCHAR(255) NOT NULL,
                         password VARCHAR(255) NOT NULL,
                         email VARCHAR(255) UNIQUE NOT NULL,
                         rol VARCHAR(50) NOT NULL
);

-- Crear tabla de Pedidos
CREATE TABLE IF NOT EXISTS pedido (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        fecha TIMESTAMP NOT NULL,
                        estado VARCHAR(50) NOT NULL,
                        usuario_id BIGINT,
                        FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);


CREATE TABLE IF NOT EXISTS Pedido_Producto (
                                 pedido_id BIGINT,
                                 producto_id BIGINT,
                                 cantidad INT,
                                 PRIMARY KEY (pedido_id, producto_id),
                                 FOREIGN KEY (pedido_id) REFERENCES pedido(id),
                                 FOREIGN KEY (producto_id) REFERENCES producto(id)
);




