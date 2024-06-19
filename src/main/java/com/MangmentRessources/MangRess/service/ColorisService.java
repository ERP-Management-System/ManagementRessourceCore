/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.service;

import com.MangmentRessources.MangRess.domaine.Coloris;
import com.MangmentRessources.MangRess.dto.ColorisDTO;
import com.MangmentRessources.MangRess.factory.ColorisFactory;
import com.MangmentRessources.MangRess.repository.ColorisRepo;
import com.MangmentRessources.MangRess.web.error.MyResourceNotFoundException;
import com.google.common.base.Preconditions;
//import com.MangmentRessources.MangRess.web.Util.Preconditions;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Administrator
 */
@Service
@Transactional
public class ColorisService {

    private final Logger log = LoggerFactory.getLogger(ColorisService.class);

    private final ColorisRepo colorisRepo;

    public ColorisService(ColorisRepo colorisRepo) {
        this.colorisRepo = colorisRepo;
    }

    @Transactional(readOnly = true)
    public List<ColorisDTO> findAllColoris() {
        return ColorisFactory.listColorisToColorisDTOs(colorisRepo.findAll());

    }

    @Transactional(readOnly = true)
    public ColorisDTO findOne(Integer code) {
        log.debug("Request to get fournisseur: {}", code);
        Coloris coloris = colorisRepo.getReferenceById(code);
//        Preconditions.checkArgument(!true, "error.Coloris Inexistant with Code :" + code);
        if (coloris == null) {
            throw new MyResourceNotFoundException("User not found with ID: " + code);
        }
        return ColorisFactory.colorisToColorisDTO(coloris);

    }

//
    public ColorisDTO save(ColorisDTO dTO) {
        Coloris matiere = ColorisFactory.colorisDTOToColoris(dTO, new Coloris());
        matiere = colorisRepo.save(matiere);
        return ColorisFactory.colorisToColorisDTO(matiere);
    }

    public Coloris update(ColorisDTO dTO) {
        Preconditions.checkArgument((dTO.getCode() != null), "error.ColorisNotFound");
        Coloris matiere = colorisRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.ColorisNotFound");

        dTO.setCode(matiere.getCode());
        ColorisFactory.colorisDTOToColoris(dTO, matiere);
        return colorisRepo.save(matiere);
    }

    public void deleteColoris(Integer code) {
        Preconditions.checkArgument(colorisRepo.existsById(code), "error.ColorisNotFound");
        colorisRepo.deleteColorisByCode(code);
    }

}
