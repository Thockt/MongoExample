package com.example.mongoExample.prodotti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prodotti")
public class ProdottoController {

    @Autowired
    private ProdottoService prodottoService;

    @PostMapping("/create")
    public ResponseEntity<Prodotto> createProdotto(@RequestBody Prodotto prodotto) {
        return new ResponseEntity<>(prodottoService.saveProdotto(prodotto), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Prodotto> getProdottoById (@PathVariable String id) {
        return new ResponseEntity<>(prodottoService.getProdottoById(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Prodotto>> getAllProdotti() {
        return new ResponseEntity<>(prodottoService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Prodotto> updateProdotto(@PathVariable String id, @RequestBody Prodotto newProdotto) {
        return new ResponseEntity<>(prodottoService.update(id, newProdotto), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProdottoById(@PathVariable String id) {
        prodottoService.deleteById(id);
        return new ResponseEntity<>("Prodotto eliminato con successo", HttpStatus.OK);
    }

}
