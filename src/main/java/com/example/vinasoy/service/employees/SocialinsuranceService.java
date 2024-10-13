package com.example.vinasoy.service.employees;

import com.example.vinasoy.dto.employee.socialinsuranceDTO.SocialinsuranceDTO;

import java.util.List;

public interface SocialinsuranceService {
    SocialinsuranceDTO createSocialinsurance(SocialinsuranceDTO socialinsuranceDTO);

    List<SocialinsuranceDTO> getAllSocialinsurances();

    SocialinsuranceDTO getSocialinsuranceById(String id);

    SocialinsuranceDTO updateSocialinsurance(SocialinsuranceDTO socialinsuranceDTO);

    void deleteSocialinsurance(String id);
}
