package com.example.examen.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examen.entity.Producto;
import com.example.examen.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository repository;







    // CRUD PRODUCTO 


    @Override
	public List<Producto> listaProductos() {
		return repository.findAll();
	}	



    @Override
    public Producto agregarActualizarProducto(Producto objProducto) {
        return repository.save(objProducto);
    }


    @Override
    public void eliminaProducto(ObjectId id) {
        repository.deleteById(id);  
    }


    @Override
    public Producto buscaProductoPorPk(ObjectId idProducto) {
        return repository.findById(idProducto).orElse(null);
    }








    


    // METODOS PERSONALIZADAS CON REGEX OR IN 

    @Override
    public List<Producto> listaProductoPorName(String name) {
        return repository.listaProductoPorName(name);
    }

    @Override
    public List<Producto> listaProductoPorNameFinal(String name) {
        return repository.listaProductoPorNameFinal(name);
    }

    @Override
    public List<Producto> listaProductoRegular(List<Double> regular) {
        return repository.listaProductoRegular(regular);
    }

    @Override
    public List<Producto> listaProductoSale(Double sale) {
          return repository.listaProductoSale(sale);
    }

    @Override
	public List<Producto> listaProductoPorDosName(String name1, String name2) {
		return repository.listaCursoPorDosCampos(name1, name2);
	}
    




}
