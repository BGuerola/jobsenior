package com.bkjobsenior.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bkjobsenior.model.Inscrito;
import com.bkjobsenior.service.InscritoService;
import java.util.HashMap;
import java.util.Map;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/inscritos")
public class InscritoController {

	 @Autowired
	 	private InscritoService inscritoService;

	    @PostMapping("/register")
	    public ResponseEntity<Map<String, ?>> register(@RequestBody Inscrito inscrito) {
	        boolean success = inscritoService.registrar(inscrito);

	        if (success) {
	        	Inscrito user = inscritoService.login(inscrito.getNombre(), inscrito.getContrasena());
	            Map<String, Object> response = new HashMap<>();
	            response.put("id", user.getIdInscrito());
	            response.put("tipo", user.getTipo().name());
	            return ResponseEntity.ok(response);
	            
	        } else {
	            Map<String, String> error = new HashMap<>();
	            error.put("error", "El usuario ya existe");
	            return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	        }
	    }

	    @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody Inscrito inscrito) {
	    //public ResponseEntity<String> login(@RequestBody Inscrito inscrito) {
	        Inscrito user = inscritoService.login(inscrito.getNombre(), inscrito.getContrasena());
	        //return user != null ? user.getTipo().name() : "Credenciales incorrectas";
	        if (user != null) {
	            Map<String, Object> response = new HashMap<>();
	            response.put("id", user.getIdInscrito());
	            response.put("tipo", user.getTipo().name());
	            return ResponseEntity.ok(response);
	        } else {
	            Map<String, String> errorResponse = new HashMap<>();
	            errorResponse.put("error", "Credenciales incorrectas");
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
	        } 
	    }
}