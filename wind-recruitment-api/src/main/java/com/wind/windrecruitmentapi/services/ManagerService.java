package com.wind.windrecruitmentapi.services;


import com.wind.windrecruitmentapi.utils.PageResponse;
import com.wind.windrecruitmentapi.utils.authentication.EmployeeResponse;
import org.springframework.stereotype.Service;

@Service
public interface ManagerService {

    PageResponse<EmployeeResponse> getAllEmployees();
}
