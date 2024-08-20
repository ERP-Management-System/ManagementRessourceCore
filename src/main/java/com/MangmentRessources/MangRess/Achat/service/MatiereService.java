/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.service;

import com.MangmentRessources.MangRess.Achat.domaine.Depot;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsDemandeAchat;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsNomenclatureArticle;
import com.MangmentRessources.MangRess.Achat.domaine.Matiere;
import com.MangmentRessources.MangRess.Achat.dto.DepotDTO;
import com.MangmentRessources.MangRess.Achat.dto.DetailsDemandeAchatDTO;
import com.MangmentRessources.MangRess.Achat.dto.MatiereDTO;
import com.MangmentRessources.MangRess.Achat.factory.DepotFactory;
import com.MangmentRessources.MangRess.Achat.factory.MatiereFactory;
import com.MangmentRessources.MangRess.Achat.repository.DemandeAchatRepo;
import com.MangmentRessources.MangRess.Achat.repository.DetailsDemandeAchatRepo;
import com.MangmentRessources.MangRess.Achat.repository.DetailsNomenclatureRepo;
import com.MangmentRessources.MangRess.Achat.repository.MatiereRepo;
import com.MangmentRessources.MangRess.web.Util.Helper;
import com.google.common.base.Preconditions;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

/**
 *
 * @author Administrator
 */
@Service
@Transactional
public class MatiereService {

    private final MatiereRepo matiereRepo;
    private final DetailsDemandeAchatRepo detailsDemandeAchatRepo;
    private final DetailsNomenclatureRepo detailsNomenclatureRepo;

    public MatiereService(MatiereRepo matiereRepo, DetailsDemandeAchatRepo detailsDemandeAchatRepo, DetailsNomenclatureRepo detailsNomenclatureRepo) {
        this.matiereRepo = matiereRepo;
        this.detailsDemandeAchatRepo = detailsDemandeAchatRepo;
        this.detailsNomenclatureRepo = detailsNomenclatureRepo;
    }

    @Transactional(readOnly = true)
    public List<MatiereDTO> findAllMatiere() {
        return MatiereFactory.listMatiereToMatiereDTOs(matiereRepo.findAll());

    }

    @Transactional(readOnly = true)
    public MatiereDTO findOne(Integer code) {
        Matiere domaine = matiereRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.MatiereNotFound");
        return MatiereFactory.matiereToMatiereDTO(domaine);
    }

    public MatiereDTO save(MatiereDTO dTO) {
        Matiere domaine = MatiereFactory.matiereDTOToMatiere(dTO, new Matiere());
        domaine = matiereRepo.save(domaine);
        return MatiereFactory.matiereToMatiereDTO(domaine);
    }

    public Matiere update(MatiereDTO dTO) {
        Preconditions.checkArgument((dTO.getCode() != null), "error.MatiereNotFound");
        Matiere domaine = matiereRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.MatiereNotFound");
        dTO.setCode(domaine.getCode());
        MatiereFactory.matiereDTOToMatiere(dTO, domaine);
        return matiereRepo.save(domaine);
    }

    public void delete(Integer code) {
        Preconditions.checkArgument(matiereRepo.existsById(code), "error.MatiereNotFound");
        Collection<DetailsDemandeAchat> detailsDemandeAchat = detailsDemandeAchatRepo.findByDetailsDemandeAchatPK_codeMatiere(code);
        Preconditions.checkArgument(detailsDemandeAchat.isEmpty(), "Item.Used.In.Demande.Achat");
        Collection<DetailsNomenclatureArticle> detailsNomenclatureArticles = detailsNomenclatureRepo.findByDetailsNomenclaturePK_codeMatiere(code);
        Preconditions.checkArgument(detailsNomenclatureArticles.isEmpty() , "Item.Used.In.Nomencalture");

        matiereRepo.deleteMatiereByCode(code);
    }

    public String exportJasper(String reportFormat) throws FileNotFoundException, JRException {

        /////////////////////////////////////// V3 ////////////////////////////////////////
        try {

            List<Matiere> employees = matiereRepo.findAll();

//            InputStream in = new FileInputStream(new File("classpath:static/Reports/List_matiere.jrxml"));
            File file = ResourceUtils.getFile("classpath:static/Reports/List_matiere.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

            // Get your data source
            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(employees);

            // Add parameters
            Map<String, Object> parameters = new HashMap<>();

            parameters.put("CollectionBeanParam", jrBeanCollectionDataSource);

            // Fill the report
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

            String path = "C:\\";
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\Emp-Rpt-Database.pdf");

            System.out.println("Done");

            return "Report successfully generated @path= " + path;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error--> check the console log";
        }

    }

    @Transactional(readOnly = true)
    public Collection<MatiereDTO> findMatiereActive(Collection<Integer> codeStatuMatiere) {
        Collection<Matiere> result = matiereRepo.findMatiereByCodeStatuMatiereIn(Helper.removeNullValueFromCollection(codeStatuMatiere));
        return MatiereFactory.MatiereToMatiereDTOsCollection(result);
    }

}
