package com.example.examen.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "producto")
public class Producto {
    
    // tabla producto los campos = en la bd todo los campos deben ir fijate en los tipos de datos
    // debes relacionarlos lo mas proximo
    private ObjectId _id;
    private Long sku; //se usa long pq en el mongo es int64(varios numeros) long = a largo
    private String name;
    private String type;
    private Double regularPrice;
    private Double salePrice;

}
