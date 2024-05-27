/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.service;

import com.MangmentRessources.MangRess.domaine.DemandeAchat;
import com.MangmentRessources.MangRess.dto.DemandeAchatDTO;
import com.MangmentRessources.MangRess.factory.DemandeAchatFactory;
import com.MangmentRessources.MangRess.repository.DemandeAchatRepo;
import com.MangmentRessources.MangRess.repository.NomenclatureRepo;
import com.google.common.base.Preconditions;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Service
@Transactional
public class DemandeAchatService {

    private final DemandeAchatRepo demandeAchatRepo;

    public DemandeAchatService(DemandeAchatRepo demandeAchatRepo) {
        this.demandeAchatRepo = demandeAchatRepo;
    }

    @Transactional(readOnly = true)
    public List<DemandeAchatDTO> findAllDemandeAchat() {
        return DemandeAchatFactory.listDemandeAchatToDemandeAchatDTOs(demandeAchatRepo.findAll());

    }

    @Transactional(readOnly = true)
    public DemandeAchatDTO findOne(Integer code) {
        DemandeAchat domaine = demandeAchatRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.DemandeAchatNotFound");
        return DemandeAchatFactory.demandeAchatToDemandeAchatDTO(domaine);
    }

    @Transactional(readOnly = true)
    public DemandeAchatDTO findOneWithDetilas(Integer code) {
        DemandeAchat domaine = demandeAchatRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.DemandeAchatNotFound");
        return DemandeAchatFactory.demandeAchatToDemandeAchatDTOCollection(domaine);
    }

//
    public DemandeAchatDTO save(DemandeAchatDTO dTO) {
        DemandeAchat domaine = DemandeAchatFactory.nomenclatureArticleDTOToDemandeAchatCollection(dTO, new DemandeAchat());
        domaine = demandeAchatRepo.save(domaine);
        return DemandeAchatFactory.demandeAchatToDemandeAchatDTOCollection(domaine);
    }

    /// Update List
    public DemandeAchat update(DemandeAchatDTO dTO) {
        Preconditions.checkArgument((dTO.getCode() != null), "error.DemandeAchatNotFound");
        DemandeAchat domaine = demandeAchatRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.DemandeAchatNotFound");
        dTO.setCode(domaine.getCode());
        DemandeAchatFactory.nomenclatureArticleDTOToDemandeAchatCollection(dTO, domaine);
        return demandeAchatRepo.save(domaine);
    }

    public void delete(Integer code) {
        Preconditions.checkArgument(demandeAchatRepo.existsById(code), "error.DemandeAchatNotFound");

        /// Control Order Achat + Demande Devis 
//        Preconditions.checkArgument(nomenclatureRepo.existsById(code), "error.DemandeAchatNotFound");
        demandeAchatRepo.deleteById(code);
    }

}
