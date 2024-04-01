package ru.netology.yunevgeni.service;

import org.springframework.stereotype.Service;
import ru.netology.yunevgeni.model.Identifiable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StorageService<T> {


    private final List<T> data = new ArrayList<>();

    public void save(T item) {
        data.add(item);
    }

    public List<T> getAll() {
        return new ArrayList<>(data);
    }

    public Optional<T> findById(int id, Class<T> clazz) {
        for (T item : data) {
            if (item instanceof Identifiable) {
                Identifiable identifiable = (Identifiable) item;
                if (identifiable.getId() == id && clazz.isInstance(item)) {
                    return Optional.of(item);
                }
            }
        }
        return Optional.empty();
    }
    public void add(T item) {
        data.add(item);
    }

    public void initStorage(List<T> initialData) {
        data.addAll(initialData);
    }
    public void delete(T item) {
        data.remove(item);
    }

}
