/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.service;
 
import com.MangmentRessources.MangRess.Achat.domaine.Matiere;
import com.MangmentRessources.MangRess.Achat.dto.MatiereDTO;
import com.MangmentRessources.MangRess.Achat.factory.MatiereFactory;
import com.MangmentRessources.MangRess.Achat.repository.MatiereRepo;
import com.MangmentRessources.MangRess.dto.AoDTO;
import com.google.common.base.Preconditions;
import java.io.File;
import java.io.FileNotFoundException;
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

    public MatiereService(MatiereRepo matiereRepo) {
        this.matiereRepo = matiereRepo;
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

    @Transactional(readOnly = true)
    public AoDTO findOneAO(Integer code) {
        Matiere domaine = matiereRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.MatiereNotFound");
        return MatiereFactory.matiereToMatiereDTOAO(domaine);
    }

//
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
        matiereRepo.deleteMatiereByCode(code);
    }

    public String exportJasper(String reportFormat) throws FileNotFoundException, JRException {
//        List<Matiere> matieres = matiereRepo.findAll();
//        String path = "C:\\";
//        File file = ResourceUtils.getFile("classpath:static/Reports/V1.jrxml");
//        
//        JasperReport  jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(matieres);
//        Map<String , Object> parameters = new HashMap<>();
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,dataSource);
//        if(reportFormat.equalsIgnoreCase("pdf")){
//            JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\test.pdf");
//        }
//        
//        return "File Exported";
//        

///////////////////////////////////// V2 ///////////////////////////////////
//        try {
//
//            List<Matiere> employees = matiereRepo.findAll();
//
//            File file = ResourceUtils.getFile("classpath:static/Reports/List_matiere.jrxml");
//
//            // Get your data source
//            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(employees);
//
//            // Add parameters
//            Map<String, Object> parameters = new HashMap<>();
//            
//
//            parameters.put("CollectionBeanParam", jrBeanCollectionDataSource);
//
//            // Fill the report
//            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrBeanCollectionDataSource);
// 
//            String path = "C:\\"; 
//            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\Emp-Rpt-Database.pdf");
//
//            System.out.println("Done");
//
//            return "Report successfully generated @path= " + path;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Error--> check the console log";
//        }
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

}
