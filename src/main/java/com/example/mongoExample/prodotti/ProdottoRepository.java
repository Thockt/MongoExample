package com.example.mongoExample.prodotti;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdottoRepository extends MongoRepository<Prodotto, String> {
}
