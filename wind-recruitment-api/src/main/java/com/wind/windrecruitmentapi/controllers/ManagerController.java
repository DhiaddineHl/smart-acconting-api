package com.wind.windrecruitmentapi.controllers;


import com.wind.windrecruitmentapi.services.ManagerService;
import com.wind.windrecruitmentapi.utils.PageResponse;
import com.wind.windrecruitmentapi.utils.authentication.EmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/manager")
public class ManagerController {

    private final ManagerService managerService;

    @GetMapping("/employees")
    public ResponseEntity<PageResponse<EmployeeResponse>>getAllEmployees(

    ){
        return ResponseEntity.ok(managerService.getAllEmployees());
    }

}
