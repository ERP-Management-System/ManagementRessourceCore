package com.MangmentRessources.MangRess.Access.factory;
 
import com.MangmentRessources.MangRess.Access.domaine.AccessFormUser;
import com.MangmentRessources.MangRess.Access.dto.AccessFormUserDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccessFormUserFactory {
  public static AccessFormUserDTO vaccessformuserToVAccessFormUserDTO(AccessFormUser accessFormUser) {
    AccessFormUserDTO accessFormUserDTO=new AccessFormUserDTO();
    accessFormUserDTO.setAccessFormUserPK(accessFormUser.getAccessFormUserPK());
    accessFormUserDTO.setVisible(accessFormUser.getVisible());
    accessFormUserDTO.setForm(accessFormUser.getForm());
    return accessFormUserDTO;
  }

  public static AccessFormUser vaccessformuserDTOToVAccessFormUser(AccessFormUserDTO accessFormUserDTO) {
    AccessFormUser accessFormUser=new AccessFormUser();
    accessFormUser.setAccessFormUserPK(accessFormUserDTO.getAccessFormUserPK());
    accessFormUser.setVisible(accessFormUserDTO.getVisible());
    accessFormUser.setForm(accessFormUserDTO.getForm());
    return accessFormUser;
  }

  public static Collection<AccessFormUserDTO> vaccessformuserToVAccessFormUserDTOs(Collection<AccessFormUser> vaccessformusers) {
    List<AccessFormUserDTO> vaccessformusersDTO=new ArrayList<>();
    vaccessformusers.forEach(x -> {
      vaccessformusersDTO.add(vaccessformuserToVAccessFormUserDTO(x));
    } );
    return vaccessformusersDTO;
  }
}

