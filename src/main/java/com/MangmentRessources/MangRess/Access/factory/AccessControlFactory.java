/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MangmentRessources.MangRess.Access.factory;
 
import com.MangmentRessources.MangRess.Access.domaine.AccessControl;
import com.MangmentRessources.MangRess.Access.dto.AccessControlDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class AccessControlFactory {
    public static AccessControl  AccessControlDTOTOacess (AccessControlDTO  accessDTO){
             AccessControl accesscontrol = new AccessControl()  ; 
             accesscontrol.setDescription(accessDTO.getDescription());
             accesscontrol.setGrp(accessDTO.getGrp());
             accesscontrol.setPassWord(accessDTO.getPassWord());
             accesscontrol.setUserName(accessDTO.getUserName());
             return accesscontrol ; 
    }
    
    public static AccessControlDTO accesscontrolTOAccessControlDTO(AccessControl access){
            if (access != null) {  
                 AccessControlDTO accesscontrolDTO =new AccessControlDTO() ;
                 accesscontrolDTO.setDescription(access.getDescription());
                 accesscontrolDTO.setGrp(access.getGrp());
                 accesscontrolDTO.setPassWord(access.getPassWord());
                 accesscontrolDTO.setUserName(access.getUserName());
                 
                 return accesscontrolDTO ;
            
            }
            else {
                return null ; 
            }
        }
      public static List <AccessControlDTO> accesscontrolsToAccessControlDTOs(List<AccessControl> accesscontrols) {
    List<AccessControlDTO> bacDTOs = new ArrayList<> () ; 
       for (AccessControl access:accesscontrols) {
           AccessControlDTO accessDTO =accesscontrolTOAccessControlDTO(access); 
           bacDTOs.add(accessDTO) ; 
 
    } 
       return bacDTOs ; 

}
     
}
