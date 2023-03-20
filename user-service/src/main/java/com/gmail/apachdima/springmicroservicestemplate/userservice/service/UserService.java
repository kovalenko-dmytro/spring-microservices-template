package com.gmail.apachdima.springmicroservicestemplate.userservice.service;

import com.gmail.apachdima.springmicroservicestemplate.userservice.dto.user.UserRequestDTO;
import com.gmail.apachdima.springmicroservicestemplate.userservice.dto.user.UserResponseDTO;
import com.gmail.apachdima.springmicroservicestemplate.userservice.dto.user.UserSearchRequestDTO;
import com.gmail.apachdima.springmicroservicestemplate.userservice.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Locale;

public interface UserService {

    UserResponseDTO create(UserRequestDTO userRequestDTO);
    Page<UserResponseDTO> search(Pageable pageable, UserSearchRequestDTO userSearchRequestDTO, Locale locale);
    User getUserByUserName(String name, Locale locale);
}
