package ru.netology.yunevgeni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.yunevgeni.model.Operation;
import ru.netology.yunevgeni.OperationService;
import ru.netology.yunevgeni.service.OperationStorageService;

import java.util.List;

@RestController
@RequestMapping("/operations")
public class OperationController {
    private final OperationStorageService operationStorageService;

    @Autowired
    public OperationController(OperationStorageService operationStorageService) {
        this.operationStorageService = operationStorageService;
    }

    @GetMapping
    public List<Operation> getAllOperations() {
        return operationStorageService.getAllOperations();
    }

    @PostMapping
    public ResponseEntity<Void> createOperation(@RequestBody Operation operation) {
        operationStorageService.save(operation);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{operationId}")
    public ResponseEntity<Void> deleteOperation(@PathVariable("operationId") int operationId) {
        boolean deleted = operationStorageService.deleteById(operationId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}