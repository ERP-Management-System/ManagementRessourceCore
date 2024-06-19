/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.service;

import com.MangmentRessources.MangRess.Achat.domaine.Article;
import com.MangmentRessources.MangRess.domaine.Client;
import com.MangmentRessources.MangRess.domaine.Client;
import com.MangmentRessources.MangRess.Achat.dto.ArticleDTO;
import com.MangmentRessources.MangRess.Achat.dto.ClientDTO;
import com.MangmentRessources.MangRess.Achat.factory.ArticleFactory;
import com.MangmentRessources.MangRess.Achat.factory.ClientFactory;
import com.MangmentRessources.MangRess.Achat.repository.ClientRepo;
import com.MangmentRessources.MangRess.Achat.repository.ClientRepo;
import com.google.common.base.Preconditions;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Transactional
@Service
public class ClientService {

    private final ClientRepo clientRepo;

    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Transactional(readOnly = true)
    public List<ClientDTO> findAllClient() {
        return ClientFactory.listClientToClientDTOs(clientRepo.findAll());

    }

    @Transactional(readOnly = true)
    public List<ClientDTO> findByCodeRegion(Integer codeRegion) { 
        List<Client> list = clientRepo.findByCodeRegion(codeRegion);
        return ClientFactory.listClientToClientDTOs(list);
    }

    @Transactional(readOnly = true)
    public ClientDTO findOne(Integer code) {
        Client domaine = clientRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.ClientNotFound");
        return ClientFactory.clientToClientDTO(domaine);
    }

//
    public ClientDTO save(ClientDTO dTO) {
        Client domaine = ClientFactory.clientDTOToClient(dTO, new Client());
        domaine = clientRepo.save(domaine);
        return ClientFactory.clientToClientDTO(domaine);
    }

    public Client update(ClientDTO dTO) {
//        Preconditions.checkArgument((dTO.getCode() != null), "error.ClientNotFound");
        Client domaine = clientRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.ClientNotFound");
        dTO.setCode(domaine.getCode());
        ClientFactory.clientDTOToClient(dTO, domaine);
        return clientRepo.save(domaine);
    }

    public void deleteClient(Integer code) {
        Preconditions.checkArgument(clientRepo.existsById(code), "error.ClientNotFound");

//        control is used
//        List<Client> domaine = clientRepo.findByCodeClient(code);
//        Preconditions.checkArgument(true, "error.ClientUsed");
        clientRepo.deleteById(code);
    }

}
