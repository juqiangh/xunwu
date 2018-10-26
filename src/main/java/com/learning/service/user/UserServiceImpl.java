package com.learning.service.user;

import com.learning.entity.Role;
import com.learning.entity.User;
import com.learning.repository.RoleRepository;
import com.learning.repository.UserRepository;
import com.learning.service.IUserService;
import com.learning.service.ServiceResult;
import com.learning.web.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    private final Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();

    @Override
    public User findUserByName(String userName) {
        User user = userRepository.findByName(userName);
        if(user == null ) {
            return null;
        }
        List<Role> roles = roleRepository.findRolesByUserId(user.getId());
        if(CollectionUtils.isEmpty(roles)) {
            throw new DisabledException("权限非法");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName())));
        user.setAuthorityList(authorities);
        return user;
    }

    @Override
    public ServiceResult<UserDTO> findById(Long userId) {
        User user = userRepository.findOne(userId);
        if (user == null) {
            return ServiceResult.notFound();
        }
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return ServiceResult.of(userDTO);
    }

    @Override
    public User findUserByTelephone(String telephone) {
        return null;
    }

    @Override
    public User addUserByPhone(String telehone) {
        return null;
    }

    @Override
    public ServiceResult modifyUserProfile(String profile, String value) {
        return null;
    }
}
