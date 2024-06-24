/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.ParametrageCentral.service;

import com.MangmentRessources.MangRess.ParametrageCentral.domaine.Banque;
import com.MangmentRessources.MangRess.ParametrageCentral.dto.BanqueDTO;
import com.MangmentRessources.MangRess.ParametrageCentral.factory.BanqueFactory;
import com.MangmentRessources.MangRess.ParametrageCentral.repository.BanqueRepo;
import com.MangmentRessources.MangRess.ParametrageCentral.repository.BanqueRepo;
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
public class BanqueService {

    private final BanqueRepo banqueRepo;

    public BanqueService(BanqueRepo banqueRepo) {
        this.banqueRepo = banqueRepo;
    }

    @Transactional(readOnly = true)
    public List<BanqueDTO> findAllBanque() {
        return BanqueFactory.listBanqueToBanqueDTOs(banqueRepo.findAll());

    }

    @Transactional(readOnly = true)
    public BanqueDTO findOne(Integer code) {
        Banque domaine = banqueRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.BanqueNotFound");
        return BanqueFactory.banqueToBanqueDTO(domaine);
    }

//
    public BanqueDTO save(BanqueDTO dTO) {
        Banque domaine = BanqueFactory.banqueDTOToBanque(dTO, new Banque());
        domaine = banqueRepo.save(domaine);
        return BanqueFactory.banqueToBanqueDTO(domaine);
    }

    public Banque update(BanqueDTO dTO) {
        Preconditions.checkArgument((dTO.getCode() != null), "error.BanqueNotFound");
        Banque domaine = banqueRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.BanqueNotFound");
        dTO.setCode(domaine.getCode());
        BanqueFactory.banqueDTOToBanque(dTO, domaine);
        return banqueRepo.save(domaine);
    }

    public void deleteBanque(Integer code) {
        Preconditions.checkArgument(banqueRepo.existsById(code), "error.BanqueNotFound");
        banqueRepo.deleteById(code);
    }
}
