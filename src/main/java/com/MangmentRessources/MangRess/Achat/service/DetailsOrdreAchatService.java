/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.service;

import com.MangmentRessources.MangRess.Achat.domaine.BonReception;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsOrdreAchat;
import com.MangmentRessources.MangRess.Achat.dto.DetailsBonReceptionDTO;
import com.MangmentRessources.MangRess.Achat.dto.DetailsOrdreAchatDTO;
import com.MangmentRessources.MangRess.Achat.factory.DetailsOrdreAchatFactory;
import com.MangmentRessources.MangRess.Achat.repository.DetailsOrdreAchatRepo;
import com.google.common.base.Preconditions;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Service
@Transactional
public class DetailsOrdreAchatService {

    private final DetailsOrdreAchatRepo detailsOrdreAchatRepo;

    public DetailsOrdreAchatService(DetailsOrdreAchatRepo detailsOrdreAchatRepo) {
        this.detailsOrdreAchatRepo = detailsOrdreAchatRepo;
    }

    @Transactional(readOnly = true)
    public Collection<DetailsOrdreAchatDTO> findOne(Integer code) {
        Collection<DetailsOrdreAchat> domaine = detailsOrdreAchatRepo.findByDetailsOrdreAchatPK_codeOrdreAchat(code);

        return DetailsOrdreAchatFactory.UpdatedetailsOrdreAchatTodetailsOrdreAchatDTOCollection(domaine);
    }

    @Transactional(readOnly = true)
    public DetailsOrdreAchatDTO findByCodeOrdreAchatAndMatiere(Integer codeOrdreAchat, Integer CodeMatiere) {
        DetailsOrdreAchat domaine = detailsOrdreAchatRepo.findByDetailsOrdreAchatPK_codeOrdreAchatAndCodematiere(codeOrdreAchat, CodeMatiere);
        return DetailsOrdreAchatFactory.UpdatedetailsOrdreAchatTodetailsOrdreAchatDTO(domaine);
    }

    public Collection<DetailsOrdreAchat> update(List<DetailsOrdreAchatDTO> dTO) {    
        
        System.out.println("dTO.get(0).getCodeOrdreAchat()" + dTO);
        Collection<DetailsOrdreAchat> domaine = detailsOrdreAchatRepo.findByDetailsOrdreAchatPK_codeOrdreAchat(dTO.get(0).getCodeOrdreAchat());
        
            
        Preconditions.checkArgument(true, "error.OrdreAchatNotFound");
        for (DetailsOrdreAchatDTO detail : dTO) { 
            Optional<DetailsOrdreAchat> details = domaine.stream().filter(x -> (x.getCodematiere().equals(detail.getCodeMatieres())) && (x.getDetailsOrdreAchatPK().getCodeOrdreAchat().equals(detail.getCodeOrdreAchat()))).findFirst();
            if (details.isPresent()) {
                
                BigDecimal qteOldReviced = details.get().getQteLivrer();   
                BigDecimal qteLivree = detail.getQteLivrer();
                BigDecimal sumQteLivred = qteOldReviced.add(qteLivree);

                
                details.get().setQteLivrer( sumQteLivred); 
                details.get().setTotalementLivred(detail.getTotalementLivred());

                detailsOrdreAchatRepo.save(details.get());
            }
        }

        return domaine;
    }

}
