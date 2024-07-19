package com.MangmentRessources.MangRess.Access.factory;
 
import com.MangmentRessources.MangRess.Access.domaine.AccessMenuUser;
import com.MangmentRessources.MangRess.Access.dto.AccessMenuUserDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccessMenuUserFactory {
  public static AccessMenuUserDTO vaccessmenuuserToVAccessMenuUserDTO(AccessMenuUser vaccessmenuuser) {
    AccessMenuUserDTO vaccessmenuuserDTO=new AccessMenuUserDTO();
    vaccessmenuuserDTO.setAccessMenuUserPK(vaccessmenuuser.getAccessMenuUserPK());
    vaccessmenuuserDTO.setVisible(vaccessmenuuser.getVisible());
    vaccessmenuuserDTO.setDes(vaccessmenuuser.getDesigMenu());   
    vaccessmenuuserDTO.setMenuPere(vaccessmenuuser.getMenuPere());

    return vaccessmenuuserDTO;
  }

  public static AccessMenuUser vaccessmenuuserDTOToVAccessMenuUser(AccessMenuUserDTO vaccessmenuuserDTO) {
    AccessMenuUser vaccessmenuuser=new AccessMenuUser();
    vaccessmenuuser.setAccessMenuUserPK(vaccessmenuuserDTO.getAccessMenuUserPK());
    vaccessmenuuser.setVisible(vaccessmenuuserDTO.getVisible());
    vaccessmenuuser.setDesigMenu(vaccessmenuuserDTO.getDes());   
    vaccessmenuuser.setMenuPere(vaccessmenuuserDTO.getMenuPere());

    return vaccessmenuuser;
  }

  public static Collection<AccessMenuUserDTO> vaccessmenuuserToVAccessMenuUserDTOs(Collection<AccessMenuUser> vaccessmenuusers) {
    List<AccessMenuUserDTO> vaccessmenuusersDTO=new ArrayList<>();
    vaccessmenuusers.forEach(x -> {
      vaccessmenuusersDTO.add(vaccessmenuuserToVAccessMenuUserDTO(x));
    } );
    return vaccessmenuusersDTO;
  }
}

