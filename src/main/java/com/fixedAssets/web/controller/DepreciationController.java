package com.fixedAssets.web.controller;

import com.fixedAssets.domain.DepreciationDo;
import com.fixedAssets.domain.FixedAssetDo;
import com.fixedAssets.domain.service.DepreciationService;
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
@RequestMapping("/depreciation")
public class DepreciationController {

    @Autowired
    private DepreciationService depreciationService;

    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Obtener todas las depreciaciones", description = "Retorna una lista de todas las depreciaciones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = DepreciationDo.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)
    })
    @GetMapping("/all")
    public ResponseEntity<List<DepreciationDo>> getAll(){
        return new ResponseEntity<>(depreciationService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Encontrar depreciaciones por ID de depreciación", description = "Retorna una lista de depreciaciones que coinciden con el ID proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = DepreciationDo.class))),
            @ApiResponse(responseCode = "404", description = "Depreciación no encontrada",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)
    })
    @GetMapping("/DepreciationId/{DepreciationId}")
    public ResponseEntity<List<DepreciationDo>> findByDepreciationIdD(
            @Parameter(description = "ID de la depreciación", required = true)
            @PathVariable("DepreciationId") int depreciationIdD){
        return depreciationService.findByDepreciationIdD(depreciationIdD).map(depreciationDo -> new ResponseEntity<>(depreciationDo, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Encontrar depreciaciones por ID de activo", description = "Retorna una lista de depreciaciones que coinciden con el ID de activo proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = DepreciationDo.class))),
            @ApiResponse(responseCode = "404", description = "Depreciación no encontrada",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)
    })
    @GetMapping("/byAssetId/{assetIdD}")
    public ResponseEntity<List<DepreciationDo>> findByAssetIdD (
            @Parameter(description = "ID del activo", required = true)
            @PathVariable("assetIdD") int assetIdD){
        return depreciationService.findByAssetIdD(assetIdD).map(depreciationDo -> new ResponseEntity<>(depreciationDo, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Guardar una nueva depreciación", description = "Guarda una nueva depreciación en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Depreciación creada exitosamente",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = DepreciationDo.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)
    })
    @PostMapping("/save")
    public ResponseEntity<DepreciationDo> save(@RequestBody DepreciationDo depreciationDo){
        return new ResponseEntity<>(depreciationService.save(depreciationDo), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Eliminar depreciación por ID de depreciacion", description = "Elimina una depreciación de la base de datos por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Depreciación eliminada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Depreciación no encontrada")
    })
    @DeleteMapping("/delete/{depreciationIdD}")
    public ResponseEntity delete(
            @Parameter(description = "ID de la depreciación", required = true)
            @PathVariable("depreciationIdD") int depreciationIdD) {
        if (depreciationService.delete(depreciationIdD)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Actualizar depreciacion por ID", description = "Actualiza un registro de depreciación de la base de datos por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Depreciación actualizada exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FixedAssetDo.class))),
            @ApiResponse(responseCode = "404", description = "Depreciación no encontrada",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)
    })
    @PutMapping("/update/{depreciationIdD}")
    public ResponseEntity<DepreciationDo> update(
            @Parameter(description = "ID de la depreciación", required = true)
            @PathVariable("depreciationIdD") int depreciationIdD,
            @RequestBody DepreciationDo depreciationDo){
        return new ResponseEntity<>(depreciationService.update(depreciationIdD, depreciationDo), HttpStatus.OK);
    }

}
