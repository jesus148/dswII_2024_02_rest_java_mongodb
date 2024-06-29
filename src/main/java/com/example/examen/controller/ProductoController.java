package com.example.examen.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.examen.entity.Producto;
import com.example.examen.service.ProductoService;

@RestController
@RequestMapping("/rest/producto")
public class ProductoController {
    


    @Autowired
    private ProductoService service;






	// METODOS CRUD PRODUCTO===============

	// metodo registrar
	@PostMapping("/registraProducto")
	@ResponseBody
	public ResponseEntity<?> inserta(@RequestBody Producto obj) {
		Map<String, Object> salida = new HashMap<String, Object>();
		try {
            Producto objSalida = service.agregarActualizarProducto(obj);
			if (objSalida == null) {
				salida.put("mensaje", "Error al registrar");
			} else {
				// una vez registrado el mongodb te devuelve el objeto registrao y obtenemos su id eso lo mostraremos en el front o en postman  o al momento de usar este endpoint
				salida.put("mensaje", "Registro exitoso de ID >> " + objSalida.get_id() ); ;
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error al registrar");
		}
		return ResponseEntity.ok(salida);
	}






	// metodo actualiza
	@PutMapping("/actualizaProducto/{id}")
	@ResponseBody
	public ResponseEntity<?> actualiza(@PathVariable("id") String id, @RequestBody Producto objProducto) {
		Map<String, Object> salida = new HashMap<String, Object>();
        try {

			// primero obtendremos el id q exista en el campo _id de la tabla libro
            ObjectId objId = new ObjectId(id);

			// objeto libro a enviar le agregas el id 
			// de tal forma este obejto remplazara al objeto encontrado en la tabla libro
            objProducto.set_id(objId);

			Producto objSalida = service.agregarActualizarProducto(objProducto);
			if (objSalida == null) {
				salida.put("mensaje", "Error al actualizar");
			} else {
				salida.put("mensaje", "Actualización exitosa de ID >> " + objSalida.get_id() ); ;
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error al actualizar");
		}
		return ResponseEntity.ok(salida);
	}





	

	// metodo elimina por la pk
	@DeleteMapping("/eliminaProducto/{id}")
	@ResponseBody
    public ResponseEntity<Map<String, Object>> eliminaEjemplo(@PathVariable("id") String id) {
        Map<String, Object> salida = new HashMap<>();
        try {
			// agregas el id debe existir en la tabla libro
            ObjectId objId = new ObjectId(id);
			// si encuentra se almacena ahi 
            Producto objBusqueda = service.buscaProductoPorPk(objId);

			// verifica si encontro 
            if (objBusqueda == null) {
                salida.put("mensaje", "ID no encontrado");
                return ResponseEntity.ok(salida);

				// encontro y lo elimina por el campo _id 
            } else {
                service.eliminaProducto(objId);
                salida.put("mensaje", "Eliminación exitosa . Producto de ID ==> " + id + ".");
            }
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", "Error al eliminar");
        }
        return ResponseEntity.ok(salida);
    }



	
    // metodo por el campo _id 
    @GetMapping("/buscaPorPk/{id}")
    @ResponseBody
    public Producto listaPorPK(@PathVariable("id") String id) {
        ObjectId objId = new ObjectId(id);
        return service.buscaProductoPorPk(objId);
    }


	
	// metodo lista todo 
	@GetMapping("/listaTodoProducto")
	@ResponseBody
	public List<Producto> listaTodo() {
		return service.listaProductos();
	}















	// CONSULTAS PERSONALIZADAS CON REGEX AND IN



	// in > incrustado en el campo o incluido
    @GetMapping("/listaProductoRegular")
	@ResponseBody
	public List<Producto> listaProductoRegular(@RequestParam("regular") List<Double> regular) {
		return service.listaProductoRegular(regular);
	}
	

    // in > incrustado en el campo o incluido
    @GetMapping("/listaProductoSale")
	@ResponseBody
	public List<Producto> listaProductoSale(@RequestParam("sale") Double sale) {
		return service.listaProductoSale(sale);
	}

	


	
	// regex > parecido al like
	@GetMapping("/listaProductoPorNombre/{var}")
	@ResponseBody
	public List<Producto> listaProductoPorName(@PathVariable("var") String nombre) {
				return service.listaProductoPorName(nombre);
	}



	// regex > parecido al like
	@GetMapping("/listaProductoPorDosCampos")
	@ResponseBody
	public List<Producto> listaCursoPorDosCampos(
					@RequestParam("name1") String name1, 
					@RequestParam("name2") String name2) {
		return service.listaProductoPorDosName(name1, name2);
	}





}
