package fr.humanbooster.harrypotter.service.interfaces;

import java.util.Optional;

public interface ServiceInterface<T, L, C, U> {

    T create(C object);

    T update(U object, L id);

    void delete(L id);

    T findById(L id);
}