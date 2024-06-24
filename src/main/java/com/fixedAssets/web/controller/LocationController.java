package com.fixedAssets.web.controller;

import com.fixedAssets.domain.LocationDo;
import com.fixedAssets.domain.service.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    LocationService locationService;

    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Obtener todas las ubicaciones", description = "Retorna una lista de todas las ubicaciones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa",
                content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = LocationDo.class))),

    })
    @GetMapping("/all")
    public ResponseEntity<List<LocationDo>> getAll() {
        return ResponseEntity.ok(locationService.getAll());
    }

    @Operation(summary = "Encontrar ubicaciones por ciudad", description = "Retorna una lista de ubicaciones que coinciden con la ciudad proporcionada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa",
                content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = LocationDo.class))),
            @ApiResponse(responseCode = "404", description = "Ubicación no encontrada",
                content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                content = @Content)
    })
    @GetMapping("/{locationCityD}")
    public ResponseEntity<List<LocationDo>> getByLocationCityD(
            @Parameter(description = "Ciudad de la ubicación", required = true)
            @PathVariable String locationCityD) {
        return locationService.getByLocationCityD(locationCityD).map(locationDo -> new ResponseEntity<>(locationDo, HttpStatus.OK))
                .orElseGet(() ->ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Encontrar ubicaciones por ID", description = "Retorna una lista de ubicaciones que coinciden con el ID proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa",
                content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = LocationDo.class))),
            @ApiResponse(responseCode = "404", description = "Ubicación no encontrada",
                content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                content = @Content)
    })
    @GetMapping("/id/{locationIdDo}")
    public ResponseEntity<List<LocationDo>> findByLocationIdDo(
            @Parameter(description = "ID de la ubicación", required = true)
            @PathVariable Integer locationIdDo) {
        return locationService.findByLocationIdDo(locationIdDo).map(locationDo -> new ResponseEntity<>(locationDo, HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Eliminar ubicación por ID", description = "Elimina una ubicación de la base de datos por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ubicación eliminada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Ubicación no encontrada")
    })
    @DeleteMapping("/delete/{locationIdD}")
    public ResponseEntity deleteLocation(
            @Parameter(description = "ID de la ubicación", required = true)
            @PathVariable Integer locationIdD) {
        if (locationService.deleteLocation(locationIdD)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Guardar una nueva ubicación", description = "Guarda una nueva ubicación en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ubicación creada exitosamente",
                content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = LocationDo.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                content = @Content)
    })
    @PostMapping("/save")
    public ResponseEntity<LocationDo> saveLocation(@RequestBody LocationDo locationDo) {
        return new ResponseEntity<>(locationService.saveLocation(locationDo), HttpStatus.CREATED);
    }

}
