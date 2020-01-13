package ru.kuper.springlearn.repo;

import ru.kuper.springlearn.model.Buyer;

public interface BuyerRepo {

    Iterable<Buyer> findAll();

    Buyer findById(String id);

    Buyer save(Buyer buyer);

}
