package com.example.examen.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.examen.entity.Producto;

public interface ProductoRepository extends MongoRepository<Producto, ObjectId>  {





    // CONSULTAS PERSONALIZADAS DE SPRING A MONGO 
    // no te olvides de eliminar los espacios a veces la consulta no se ejecuat por eso
    // todos estos querys spring los ejecuta en el mongo

    // usando regex
    @Query("{name: { $regex:  '^?0'  , '$options' : 'i'} }")
    public abstract List<Producto> listaProductoPorName(String name);


    @Query("{name: { $regex:  '?0$'  , '$options' : 'i'} }")
    public abstract List<Producto> listaProductoPorNameFinal(String name);


    
    @Query("{name: { $regex:  '^?0|?1'  , '$options' : 'i'} }")
    public abstract List<Producto> listaCursoPorDosCampos(String name1, String name2);




    @Query("{ 'regularPrice' : { $in: ?0 } }")
    public abstract List<Producto> listaProductoRegular(List<Double> regular);



    @Query("{ 'salePrice' : { $in: [ ?0 ] }}")
    public abstract List<Producto> listaProductoSale(Double sale);




    
}
