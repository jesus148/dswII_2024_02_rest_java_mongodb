package com.example.examen.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.examen.entity.Medicamentos;
import com.example.examen.service.MedicamentosService;
import com.example.examen.util.AppSettings;


@RestController
@RequestMapping("/url/medicaments") //ID DEL CONTROLLER 
public class MedicamentosController {
    


    // llama al service 
    @Autowired
     private MedicamentosService service;
    





    //  lista all medicaments
    @GetMapping("/listAllMedicaments")
    public List<Medicamentos> listAll(){
         return service.findAll();
    }




    // metodo registra medicamentos 
    @PostMapping("/saveMedicament")
	@ResponseBody
	public ResponseEntity<?> addMedicaments(@RequestBody Medicamentos obj) {
		
        Map<String, Object> salida = new HashMap<>();
		try {
			Medicamentos objSalida = service.saveMedicaments(obj);
			if (objSalida == null) {
				salida.put("mensaje", "Error al registrar");
			} else {
				salida.put("mensaje", "Registro exitoso");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error al registrar");
		}
		return ResponseEntity.ok(salida);
	}







    // metodo update medicaments
    @PutMapping("/updateMedicaments")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> updateMedicaments(@RequestBody Medicamentos obj) {
		Map<String, Object> salida = new HashMap<>();
        try {
            Medicamentos objSalida = service.saveMedicaments(obj);
            if (objSalida == null) {
                salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
            } else {
                salida.put("mensaje", AppSettings.MENSAJE_ACT_EXITOSO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
        }
        return ResponseEntity.ok(salida);
	}







    

    // metodo delete for id medicaments
    @DeleteMapping("/deleteMedicament/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> deleteMedicament(@PathVariable("id") int medicamento_id) {
		Map<String, Object> salida = new HashMap<>();
		try {
			service.deleteMedicamentos(medicamento_id);
			salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}






        // Obtener un historial médico por ID
        @GetMapping("/{id}")
        public ResponseEntity<?> getHistorialMedicoById(@PathVariable int id) {
            Optional<Medicamentos> medicamentos = service.getMedicamentForId(id);
            // .map : crea un nuevo array entidad y el objeto solo si lo encuentra 
            // orElseGet : encaso el .map este  vacio responde con el response no encontrado 
            return medicamentos.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }





















}
