package com.wind.windrecruitmentapi.controllers;


import com.wind.windrecruitmentapi.services.ManagerService;
import com.wind.windrecruitmentapi.utils.PageResponse;
import com.wind.windrecruitmentapi.utils.employees.HRResponse;
import com.wind.windrecruitmentapi.utils.employees.TechnicalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/manager")
@PreAuthorize("hasRole('MANAGER')")
public class ManagerController {

    //todo: statistics and dashboard information

    private final ManagerService managerService;

    @GetMapping("/employees/hr")
    @PreAuthorize("hasAuthority('manager:read')")
    public ResponseEntity<PageResponse<HRResponse>>getAllHR(
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            @RequestParam(name = "number", defaultValue = "0", required = false) int number
    ){
        return ResponseEntity.ok(managerService.getAllHR(size, number));
    }

    @GetMapping("/employees/technical")
    @PreAuthorize("hasAuthority('manager:read')")
    public ResponseEntity<PageResponse<TechnicalResponse>>getAllTechnicals(
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            @RequestParam(name = "number", defaultValue = "0", required = false) int number
    ){
        return ResponseEntity.ok(managerService.getAllTechnicals(size, number));
    }

    @PutMapping("/block-employee/{id}")
    @PreAuthorize("hasAuthority('manager:update')")
    public void blockEmployee(
            @PathVariable("id") Integer employee_id
    ){
        managerService.blockEmployeeById(employee_id);
    }

    @PutMapping("/enable-employee/{id}")
    @PreAuthorize("hasAuthority('manager:update')")
    public void enableEmployee(
            @PathVariable("id") Integer employee_id
    ){
        managerService.enableEmployeeById(employee_id);
    }

}
