package com.example.mongoExample.prodotti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdottoService {

    @Autowired
    private ProdottoRepository prodottoRepository;

    public Prodotto saveProdotto(Prodotto prodotto) {
       return prodottoRepository.save(prodotto);
    }

    public Prodotto getProdottoById (String id) {
        Optional<Prodotto> prodottoOptional = prodottoRepository.findById(id);
        if (prodottoOptional.isEmpty()) throw new NullPointerException("Questo prodotto non esiste");
        return prodottoOptional.get();
    }

    public List<Prodotto> getAll() {
        return prodottoRepository.findAll();
    }

    public Prodotto update (String id, Prodotto newProdotto) {
        getProdottoById(id);
        Prodotto prodotto = Prodotto.builder()
                .id(id)
                .nome(newProdotto.getNome())
                .descrizione(newProdotto.getDescrizione())
                .tags(newProdotto.getTags())
                .quantita(newProdotto.getQuantita())
                .build();
        return saveProdotto(prodotto);
    }

    public void deleteById (String id) {
        getProdottoById(id);
        prodottoRepository.deleteById(id);
    }

}
