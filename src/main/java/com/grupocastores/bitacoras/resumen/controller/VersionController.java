package com.grupocastores.bitacoras.resumen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

	@GetMapping("/version")
	public String version() {
		return "Versión 1.2.3.0";
	}
	
}
