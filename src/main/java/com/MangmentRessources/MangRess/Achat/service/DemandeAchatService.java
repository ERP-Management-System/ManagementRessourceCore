/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.service;

import com.MangmentRessources.MangRess.Achat.domaine.DemandeAchat;
import com.MangmentRessources.MangRess.Achat.domaine.DemandeAchat;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsDemandeAchat;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsDemandeAchat;
import com.MangmentRessources.MangRess.Achat.dto.DemandeAchatDTO;
import com.MangmentRessources.MangRess.Achat.dto.DemandeAchatDTO;
import com.MangmentRessources.MangRess.Achat.dto.DetailsDemandeAchatDTO;
import com.MangmentRessources.MangRess.Achat.dto.DetailsDemandeAchatDTO;
import com.MangmentRessources.MangRess.Achat.factory.DemandeAchatFactory;
import com.MangmentRessources.MangRess.Achat.factory.DemandeAchatFactory;
import com.MangmentRessources.MangRess.Achat.factory.DetailsDemandeAchatFactory;
import com.MangmentRessources.MangRess.Achat.factory.DetailsDemandeAchatFactory;
import com.MangmentRessources.MangRess.Achat.repository.DemandeAchatRepo;
import com.MangmentRessources.MangRess.Achat.repository.DemandeAchatRepo;
import com.MangmentRessources.MangRess.Achat.repository.DetailsDemandeAchatRepo;
import com.MangmentRessources.MangRess.Achat.repository.DetailsDemandeAchatRepo;
import com.MangmentRessources.MangRess.Achat.repository.NomenclatureRepo;
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
public class DemandeAchatService {

    private final DemandeAchatRepo demandeAchatRepo;
    
    private final DetailsDemandeAchatRepo detailsDemandeAchatRepo;

    public DemandeAchatService(DemandeAchatRepo demandeAchatRepo, DetailsDemandeAchatRepo detailsDemandeAchatRepo) {
        this.demandeAchatRepo = demandeAchatRepo;
        this.detailsDemandeAchatRepo = detailsDemandeAchatRepo;
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
    
 
//    @Transactional(readOnly = true)
//    public DemandeAchatDTO findOneDetails(Integer code) {
//        DemandeAchat domaine = demandeAchatRepo.getReferenceById(code);
//        Preconditions.checkArgument(domaine.getCode() != null, "error.DemandeAchatNotFound");
//        return DemandeAchatFactory.DetailsdemandeAchatToDetailsDemandeAchatDTO(domaine);
//    }

//
 
    public DemandeAchat update(DemandeAchatDTO dTO) { 
        DemandeAchat domaine = demandeAchatRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.DemandeAchatNotFound");
        dTO.setCode(domaine.getCode());
        DemandeAchatFactory.demandeAchatDTOToDemandeAchatWithDetails(domaine, dTO);
        return demandeAchatRepo.save(domaine);
    }

    public DemandeAchatDTO updateNewWithFlush(DemandeAchatDTO dTO) { 
        DemandeAchat inBase = demandeAchatRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(inBase != null, "error.ModelePanierInexistant");

//        if ((inBase.getActif() != modelepanierDTO.getActif()) && (modelepanierDTO.getActif() == false)) {
//            boolean testopr = operationService.existsBycodeModeleCodeAndActif(modelepanierDTO.getCode());
//            Preconditions.checkArgument(testopr == false, "error.controleActif");
//
//            boolean testprest = prestationService.existsBycodeModeleCodeAndActif(modelepanierDTO.getCode());
//            Preconditions.checkArgument(testprest == false, "error.controleActif");
//        }
        inBase.getDetailsDemandeAchats().clear();
        demandeAchatRepo.flush();
        inBase = DemandeAchatFactory.demandeAchatDTOToDemandeAchatWithDetails(inBase, dTO);
        inBase = demandeAchatRepo.save(inBase);
        DemandeAchatDTO resultDTO = DemandeAchatFactory.UpdatedemandeAchatWithDetailsTodemandeAchatDTOWithDetails(inBase);
        return resultDTO;
    }

    public void deleteDemandeAchat(Integer code) {
        Preconditions.checkArgument(demandeAchatRepo.existsById(code), "error.DemandeAchatNotFound");
        demandeAchatRepo.deleteById(code);
    }

    public DemandeAchatDTO saveDdeAchat(DemandeAchatDTO Dto) { 
         
        DemandeAchat domaine = DemandeAchatFactory.demandeAchatDTOToDemandeAchatWithDetails(new DemandeAchat(), Dto);

        domaine.setCode(null);
        domaine.setUserCreate(domaine.getUserCreate());
        domaine.setDateCreate(new Date());
        domaine.setCodeSaisie(Dto.getCodeSaisie()); 
        
        domaine = demandeAchatRepo.save(domaine);
        DemandeAchatDTO resultDTO = DemandeAchatFactory.UpdatedemandeAchatWithDetailsTodemandeAchatDTOWithDetails(domaine);
        return resultDTO;
    }


    @Transactional(readOnly = true)
    public Collection<DetailsDemandeAchatDTO> findOneWithDetilas(Integer code) {
 
        Collection<DetailsDemandeAchat> collection = detailsDemandeAchatRepo.findByDetailsDemandeAchatPK_codeDemandeAchat(code);
        return DetailsDemandeAchatFactory.UpdatedetailsDemandeAchatTodetailsDemandeAchatDTOCollection(collection);
    }

}
