package com.example.examen.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.example.examen.entity.Producto;

public interface ProductoService {
    





    // CRUD
    public abstract Producto agregarActualizarProducto(Producto producto); 
    public abstract void eliminaProducto(ObjectId id);
    public abstract List<Producto> listaProductos();
    public abstract Producto buscaProductoPorPk(ObjectId id);




    

    // CONSULTAS ADICIONALES REGEX Y EL IN
    public abstract List<Producto> listaProductoPorName(String name);
    public abstract List<Producto> listaProductoPorNameFinal(String name);
    public abstract List<Producto> listaProductoRegular(List<Double> regular);
    public abstract List<Producto> listaProductoSale(Double regular);

    public abstract List<Producto> listaProductoPorDosName(String name1, String name2); 

}
