/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Access.service;

import com.MangmentRessources.MangRess.Access.domaine.AccessUser;
import com.MangmentRessources.MangRess.Access.dto.AccessUserDTO;
import com.MangmentRessources.MangRess.Access.factory.AccessUserFactory;
import com.MangmentRessources.MangRess.Access.repository.AccessUserRepo;
import com.MangmentRessources.MangRess.ParametrageCentral.domaine.Banque;
import com.MangmentRessources.MangRess.ParametrageCentral.dto.BanqueDTO;
import com.MangmentRessources.MangRess.ParametrageCentral.factory.BanqueFactory;
import com.MangmentRessources.MangRess.web.Util.Helper;
import com.MangmentRessources.MangRess.web.Util.RestPreconditions;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import net.sf.jasperreports.engine.util.ImageUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Administrator
 */
@Service
@Transactional
public class AccessUserService {

    private final AccessUserRepo accessUserRepo;

    public AccessUserService(AccessUserRepo accessUserRepo) {
        this.accessUserRepo = accessUserRepo;
    }

    @Transactional(readOnly = true)
    public List<AccessUserDTO> findAllAcessUser() {
        return AccessUserFactory.societeToSocieteDTOs(accessUserRepo.findAll());

    }
    @Transactional(readOnly = true)
    public List<AccessUserDTO> findAllAcessUserWithOutPassword() {
        return AccessUserFactory.societeToSocieteDTOsWithOutPassword(accessUserRepo.findAll());

    }
//

    @Transactional(readOnly = true)
    public AccessUserDTO findOne(Integer id) {
        AccessUser domaine = accessUserRepo.getReferenceById(id);
        RestPreconditions.checkFound(domaine, "societe.NotFound");
        AccessUserDTO dto = AccessUserFactory.accessUserToAccessUserDTO(domaine, false);
        return dto;
    }

    @Transactional(readOnly = true)
    public AccessUserDTO findOneWithOutLogo(Integer id, Boolean withoutLogo) {
        AccessUser societe = accessUserRepo.getReferenceById(id);
        RestPreconditions.checkFound(societe, "UserName.NotFound");
        AccessUserDTO dto = AccessUserFactory.accessUserToAccessUserDTO(societe, withoutLogo);
        return dto;
    }

    public void deleteUSerName(Integer UserName) {
//        AccessUser domaine = accessUserRepo.findAccessUserByUserNameIn(dTO.getUserName());
//        Preconditions.checkArgument(true, "error.DepotNotFound");
        accessUserRepo.deleteById(UserName);
    }

//    public AccessUserDTO save(AccessUserDTO dTO) throws IOException {
//        AccessUser domaine = AccessUserFactory.accessUserDTOToAccessUser(dTO, new AccessUser());
////        if (!dTO.getImagePath().isEmpty()) {
////            domaine.setSignature(Helper.extractBytes(dTO.getImagePath(), "png"));
////        }
//        domaine = accessUserRepo.save(domaine);
//        AccessUserDTO resultDTO = AccessUserFactory.accessUserToAccessUserDTOFull(domaine);
//        return resultDTO;
//    }

    public AccessUserDTO saves(AccessUserDTO dTO) {
        AccessUser domaine = AccessUserFactory.accessUserDTOToAccessUserx(dTO, new AccessUser());
        domaine = accessUserRepo.save(domaine);
        return AccessUserFactory.accessUserToAccessUserDTOx(domaine);
    }

    public AccessUserDTO update(AccessUserDTO dTO) throws IOException {
        AccessUser inBase = accessUserRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(inBase != null, "UserName does not exist");
        AccessUserDTO result = saves(dTO);
        return result;
    }

}
