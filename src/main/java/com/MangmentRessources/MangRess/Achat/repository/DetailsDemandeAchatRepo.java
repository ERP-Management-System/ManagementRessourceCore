/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.repository;
 
import com.MangmentRessources.MangRess.Achat.domaine.DetailsDemandeAchat;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsDemandeAchatPK;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository
public interface DetailsDemandeAchatRepo extends JpaRepository<DetailsDemandeAchat, DetailsDemandeAchatPK>{
        Collection<DetailsDemandeAchat> findByDetailsDemandeAchatPK_codeDemandeAchat(Integer codeDemandeAchat);  
        
        Collection<DetailsDemandeAchat> findByDetailsDemandeAchatPK_codeMatiere(Integer codeMatiere);


}
