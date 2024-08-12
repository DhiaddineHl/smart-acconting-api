package com.wind.windrecruitmentapi.services;


import com.wind.windrecruitmentapi.utils.PageResponse;
import com.wind.windrecruitmentapi.utils.employees.HRResponse;
import com.wind.windrecruitmentapi.utils.employees.TechnicalResponse;
import org.springframework.stereotype.Service;

@Service("managerService")
public interface ManagerService {

    PageResponse<HRResponse> getAllHR(
            int size, int number
    );

    PageResponse<TechnicalResponse> getAllTechnicals(
            int size, int number
    );

    void blockEmployeeById(Integer employeeId);

    void enableEmployeeById(Integer employeeId);
}
