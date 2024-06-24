package com.fixedAssets.web.controller;

import com.fixedAssets.domain.AssetTypeDo;
import com.fixedAssets.domain.service.AssetTypeService;
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
@RequestMapping("/assetType")
public class AssetTypeController {

    @Autowired
    private AssetTypeService assetTypeService;

    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Obtener todos los tipos de activos", description = "Retorna una lista de todos los tipos de activos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AssetTypeDo.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)
    })
    @GetMapping("/all")
    public ResponseEntity<List<AssetTypeDo>> getAll() {
        return new ResponseEntity<>(assetTypeService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Encontrar tipos de activos por ID", description = "Retorna una lista de tipos de activos que coinciden con el ID proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AssetTypeDo.class))),
            @ApiResponse(responseCode = "404", description = "Tipo de activo no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)
    })
    @GetMapping("/findById/{typeIdD}")
    public ResponseEntity<List<AssetTypeDo>> findByTypeIdD(
            @Parameter(description = "ID del tipo de activo", required = true)
            @PathVariable("typeIdD") int typeIdD) {
        return assetTypeService.findByTypeIdD(typeIdD).map(assetTypeDo -> new ResponseEntity<>(assetTypeDo, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Guardar un nuevo tipo de activo", description = "Guarda un nuevo tipo de activo en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tipo de activo creado exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AssetTypeDo.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)
    })
    @PostMapping("/save")
    public ResponseEntity<AssetTypeDo> save(@RequestBody AssetTypeDo assetTypeDo) {
        return new ResponseEntity<>(assetTypeService.save(assetTypeDo), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Eliminar tipo de activo por ID", description = "Elimina un tipo de activo de la base de datos por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipo de activo eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Tipo de activo no encontrado")
    })
    @DeleteMapping("/delete/{typeIdD}")
    public ResponseEntity delete(
            @Parameter(description = "ID del tipo de activo", required = true)
            @PathVariable("typeIdD") int typeIdD) {
        if (assetTypeService.delete(typeIdD)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
