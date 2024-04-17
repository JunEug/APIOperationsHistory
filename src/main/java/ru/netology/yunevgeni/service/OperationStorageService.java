package ru.netology.yunevgeni.service;

import org.springframework.stereotype.Service;
import ru.netology.yunevgeni.model.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OperationStorageService {
    private final List<Operation> operations = new ArrayList<>();
    private int nextId = 1;

    public List<Operation> getAllOperations() {
        return operations;
    }

    public Optional<Operation> findById(int id) {
        return operations.stream()
                .filter(operation -> operation.getId() == id)
                .findFirst();
    }

    public void save(Operation operation) {
        operation.setId(nextId++);
        operations.add(operation);
    }

    public boolean deleteById(int id) {
        return operations.removeIf(operation -> operation.getId() == id);
    }
}
