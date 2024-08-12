/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Stock.service;

import com.MangmentRessources.MangRess.ParametrageCentral.domaine.Compteur;
import com.MangmentRessources.MangRess.ParametrageCentral.service.CompteurService;
import com.MangmentRessources.MangRess.Stock.domaine.DemandeTransfertMatiere;
import com.MangmentRessources.MangRess.Stock.domaine.DetailsDemandeTransfertMatiere;
import com.MangmentRessources.MangRess.Stock.dto.DemandeTransfertMatiereDTO;
import com.MangmentRessources.MangRess.Stock.dto.DetailsDemandeTransfertMatiereDTO;
import com.MangmentRessources.MangRess.Stock.factory.DemandeTransfertMatiereFactory;
import com.MangmentRessources.MangRess.Stock.factory.DetailsDemandeTransfertMatiereFactory;
import com.MangmentRessources.MangRess.Stock.repository.DemandeTransfertMatiereRepo;
import com.MangmentRessources.MangRess.Stock.repository.DetailsDemandeTransfertMatiereRepo;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Service
@Transactional
public class DemandeTransfertMatiereService {

    private final DemandeTransfertMatiereRepo demandeTransfertMatiereRepo;
    private final DetailsDemandeTransfertMatiereRepo detailsDemandeTransfertMatiereRepo;
    private final CompteurService compteurService;
    private final DetailsDemandeTransfertMatiereService detailsDemandeTransfertMatiereService;

    public DemandeTransfertMatiereService(DemandeTransfertMatiereRepo demandeTransfertMatiereRepo, DetailsDemandeTransfertMatiereRepo detailsDemandeTransfertMatiereRepo, CompteurService compteurService, DetailsDemandeTransfertMatiereService detailsDemandeTransfertMatiereService) {
        this.demandeTransfertMatiereRepo = demandeTransfertMatiereRepo;
        this.detailsDemandeTransfertMatiereRepo = detailsDemandeTransfertMatiereRepo;
        this.compteurService = compteurService;
        this.detailsDemandeTransfertMatiereService = detailsDemandeTransfertMatiereService;
    }

    @Transactional(readOnly = true)
    public List<DemandeTransfertMatiereDTO> findAllDemandeTransfertMatiere() {
        return DemandeTransfertMatiereFactory.listDemandeTransfertMatiereToDemandeTransfertMatiereDTOs(demandeTransfertMatiereRepo.findAll());
    }

    @Transactional(readOnly = true)
    public DemandeTransfertMatiereDTO findOne(Integer code) {
        DemandeTransfertMatiere domaine = demandeTransfertMatiereRepo.getReferenceById(code);
        return DemandeTransfertMatiereFactory.demandeTransfertMatiereToDemandeTransfertMatiereDTO(domaine);
    }

    @Transactional(readOnly = true)
    public Collection<DetailsDemandeTransfertMatiereDTO> findOneWithDetilas(Integer code) {
        Collection<DetailsDemandeTransfertMatiere> collection = detailsDemandeTransfertMatiereRepo.findByDetailsDemandeTransfertMatierePK_codeDemandeTransfertMatiere(code);
        return DetailsDemandeTransfertMatiereFactory.detailsDemandeTransfertTodetailsDemandeTransfertDTOCollection(collection);
    }

    public DemandeTransfertMatiereDTO updateNewWithFlush(DemandeTransfertMatiereDTO appelOffreDTO) {
        DemandeTransfertMatiere inBase = demandeTransfertMatiereRepo.getReferenceById(appelOffreDTO.getCode());
        inBase.getDetailsDemandeTransfertMatieresCollections().clear();
        demandeTransfertMatiereRepo.flush();
        inBase = DemandeTransfertMatiereFactory.demandeTransfertMatiereDTOToDemandeTransfertMatiereWithDetails(inBase, appelOffreDTO);
        inBase = demandeTransfertMatiereRepo.save(inBase);
        DemandeTransfertMatiereDTO resultDTO = DemandeTransfertMatiereFactory.UpdatedemandeTransfertMatiereWithDetailsTodemandeTransfertMatiereDTOWithDetails(inBase);
        return resultDTO;
    }
 
    public void deleteDemandeTransfertMatiere(Integer code) {
        Preconditions.checkArgument(demandeTransfertMatiereRepo.existsById(code), "error.DemandeTransfertMatiereNotFound");
        DemandeTransfertMatiere demandeTransfertMatiere = demandeTransfertMatiereRepo.getReferenceById(code);
        Preconditions.checkArgument(demandeTransfertMatiere == null, "error.DemandeTransfertMatiereInOrdreAchat");
        detailsDemandeTransfertMatiereService.deleteByCodeDemandeTransfertMatiere(code);
        demandeTransfertMatiereRepo.deleteById(code);
    }

    public DemandeTransfertMatiereDTO saveDTR(DemandeTransfertMatiereDTO Dto) {
        DemandeTransfertMatiere domaine = DemandeTransfertMatiereFactory.demandeTransfertMatiereDTOToDemandeTransfertMatiereWithDetails(new DemandeTransfertMatiere(), Dto);
        Compteur CompteurCodeSaisie = compteurService.findOne("CodeSaisieDemandeTransfert");
        String codeSaisieAO = CompteurCodeSaisie.getPrefixe() + CompteurCodeSaisie.getSuffixe();
        domaine.setCode(null);
        domaine.setUserCreate(domaine.getUserCreate());
        domaine.setDateCreate(new Date());
        domaine.setCodeSaisie(codeSaisieAO);
        compteurService.incrementeSuffixe(CompteurCodeSaisie);
        domaine = demandeTransfertMatiereRepo.save(domaine);
        DemandeTransfertMatiereDTO resultDTO = DemandeTransfertMatiereFactory.demandeTransfertMatiereToDemandeTransfertMatiereDTO(domaine);
        return resultDTO;
    }

}
