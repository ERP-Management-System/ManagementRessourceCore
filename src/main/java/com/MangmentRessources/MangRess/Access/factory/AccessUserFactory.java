/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Access.factory;

import com.MangmentRessources.MangRess.Access.domaine.AccessUser;
import com.MangmentRessources.MangRess.Access.dto.AccessUserDTO;
import jakarta.xml.bind.DatatypeConverter;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class AccessUserFactory {

    public static AccessUser accessUserDTOToAccessUser(AccessUserDTO dTO, AccessUser domaine) {
//        AccessUser domaine = new AccessUser();
        domaine.setCode(dTO.getCode());
        domaine.setUserName(dTO.getUserName());
        domaine.setNomCompletUser(dTO.getNomCompletUser());
        domaine.setSignature(dTO.getSignature());

//        if (dTO.getSignature() != null) {
//            String base64Image = dTO.getSignature().split(",")[1];
//            byte[] imgBytes = Base64.getMimeDecoder().decode(base64Image);
//            domaine.setSignature(imgBytes);
//        } else {
//            domaine.setSignature(null);
//        }
        domaine.setPassword(dTO.getPassword());

        return domaine;
    }

    public static AccessUser accessUserDTOToAccessUserx(AccessUserDTO Dto, AccessUser domaine) {
        if (Dto != null) {

            domaine.setCode(Dto.getCode());
            domaine.setUserName(Dto.getUserName());

            domaine.setActif(Dto.getActif());
            domaine.setNomCompletUser(Dto.getNomCompletUser());
            domaine.setPassword(Dto.getPassword());
            System.out.println("byte getPassword   " + Dto.getPassword());
            if (Dto.getSig() != null) {
                System.out.println("byte image is v1  " + Dto.getSig());

 
                String[] strings = Dto.getSig().split(",");
                String extension;
                switch (strings[0]) {//check image's extension
                    case "data:image/jpeg;base64":
                        extension = "jpeg";
                        break;
                    case "data:image/png;base64":
                        extension = "png";
                        break;
                    case "data:application/pdf;base64":
                        extension = "pdf";
                        break;
                    case "data:application/vnd.openxmlformats-officedocument.wordprocessingml.document;base64":
                        extension = "docx";
                        break;
                    default://should write cases for more images types
                        extension = "jpg";
                        break;
                }
                //convert base64 string to binary data
                byte[] data = DatatypeConverter.parseBase64Binary(strings[1]);
 
                domaine.setSignature(data);
            } else {
                domaine.setSignature(null);
            }

//            domaine.setUserCreate(Dto.getUserCreate());
//            domaine.setRib(Dto.getRib());
            return domaine;
        } else {
            return null;
        }
    }

    public static AccessUserDTO accessUserToAccessUserDTOFull(AccessUser domaine) {
        if (domaine != null) {
            AccessUserDTO dTO = new AccessUserDTO();
            dTO.setCode(domaine.getCode());
            dTO.setActif(domaine.getActif());
            dTO.setPassword(domaine.getPassword());
            dTO.setNomCompletUser(domaine.getNomCompletUser());
            dTO.setUserName(domaine.getUserName());
            dTO.setSignature(domaine.getSignature());
            return dTO;
        } else {
            return null;
        }
    }

    public static AccessUserDTO accessUserToAccessUserDTO(AccessUser domaine, Boolean withoutLogo) {
        AccessUserDTO dTO = new AccessUserDTO();
        dTO.setUserName(domaine.getUserName());
//        if (!Boolean.TRUE.equals(withoutLogo)) {
        dTO.setSignature(domaine.getSignature());
//        }

        dTO.setCode(domaine.getCode());
        dTO.setNomCompletUser(domaine.getNomCompletUser());
        dTO.setPassword(domaine.getPassword());
        dTO.setActif(domaine.getActif());

        return dTO;
    }

    public static List<AccessUserDTO> societeToSocieteDTOs(List<AccessUser> societes) {
        List<AccessUserDTO> dTOs = new ArrayList<>();
        societes.forEach(x -> {
            dTOs.add(accessUserToAccessUserDTO(x, false));
        });
        return dTOs;
    }

    public static AccessUserDTO accessUserToAccessUserDTOx(AccessUser domaine) {

        if (domaine != null) {
            AccessUserDTO dTO = new AccessUserDTO();
            dTO.setUserName(domaine.getUserName());
//        if (!Boolean.TRUE.equals(withoutLogo)) {
            dTO.setSignature(domaine.getSignature());
//        }

            dTO.setCode(domaine.getCode());
            dTO.setNomCompletUser(domaine.getNomCompletUser());
            dTO.setPassword(domaine.getPassword());
            dTO.setActif(domaine.getActif());

            return dTO;
        } else {
            return null;
        }
    }
}
