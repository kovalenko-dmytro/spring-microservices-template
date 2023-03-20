package com.gmail.apachdima.springmicroservicestemplate.userservice.dto.user;

import com.gmail.apachdima.springmicroservicestemplate.userservice.util.search.SearchCriteria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserSearchRequestDTO {

    private List<SearchCriteria> searchCriteria;
}
