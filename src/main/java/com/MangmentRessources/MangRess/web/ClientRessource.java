/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.web;

import com.MangmentRessources.MangRess.domaine.Client;
import com.MangmentRessources.MangRess.dto.ClientDTO;
import com.MangmentRessources.MangRess.service.ClientService;
import jakarta.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/api/parametrage_achat/")
public class ClientRessource {
     private final ClientService clientService;

    public ClientRessource(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("client/{code}")
    public ResponseEntity<ClientDTO> getClientByCode(@PathVariable Integer code) {
        ClientDTO dTO = clientService.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }

    @GetMapping("client/all")
    public ResponseEntity<List<ClientDTO>> getAllClient() {
//        List<DdeAchat> ddeAchatList = ddeAchatService.findAllDdeAchat();
        return ResponseEntity.ok().body(clientService.findAllClient());
    }

    @PostMapping("client")
    public ResponseEntity<ClientDTO> postClient(@Valid @RequestBody ClientDTO ddeTransfertDTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        ClientDTO result = clientService.save(ddeTransfertDTO);
        return ResponseEntity.created(new URI("/api/parametrage_achat/" + result.getCode())).body(result);
    }

    @PutMapping("client/update")
    public ResponseEntity<Client> updateClient(@RequestBody @Valid ClientDTO dTO) throws URISyntaxException {
        Client result = clientService.update(dTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("client/delete/{code}")
    public ResponseEntity<Client> deleteClient(@PathVariable("code") Integer code) {
        clientService.deleteClient(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
