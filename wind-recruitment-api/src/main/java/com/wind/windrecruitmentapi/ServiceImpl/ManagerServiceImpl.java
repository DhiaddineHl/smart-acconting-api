package com.wind.windrecruitmentapi.ServiceImpl;


import com.wind.windrecruitmentapi.entities.HRRecruiter;
import com.wind.windrecruitmentapi.entities.TechnicalRecruiter;
import com.wind.windrecruitmentapi.mappers.HRMapper;
import com.wind.windrecruitmentapi.mappers.TechMapper;
import com.wind.windrecruitmentapi.repositories.HRRecruiterRepository;
import com.wind.windrecruitmentapi.repositories.TechnicalRecruiterRepository;
import com.wind.windrecruitmentapi.services.ManagerService;
import com.wind.windrecruitmentapi.utils.PageResponse;
import com.wind.windrecruitmentapi.utils.employees.HRResponse;
import com.wind.windrecruitmentapi.utils.employees.TechnicalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final HRRecruiterRepository hrRecruiterRepository;
    private final TechnicalRecruiterRepository technicalRecruiterRepository;
    private final HRMapper hrMapper;
    private final TechMapper techMapper;
    @Override
    public PageResponse<HRResponse> getAllHR(int size, int number) {

        PageRequest pageRequest = PageRequest.of(number, size);

        Page<HRRecruiter> hrResponses = hrRecruiterRepository.findAll(pageRequest);

        return new PageResponse<HRResponse>(
                hrResponses.stream().map(hrMapper).toList(),
                number,
                size,
                hrResponses.getTotalElements(),
                hrResponses.getTotalPages(),
                hrResponses.isFirst(),
                hrResponses.isLast()

        );
    }

    @Override
    public PageResponse<TechnicalResponse> getAllTechnicals(int size, int number) {

        PageRequest pageRequest = PageRequest.of(number, size);
        Page<TechnicalRecruiter> technicalRecruiters = technicalRecruiterRepository.findAll(pageRequest);

        return new PageResponse<TechnicalResponse>(
                technicalRecruiters.stream().map(techMapper).toList(),
                technicalRecruiters.getNumber(),
                technicalRecruiters.getSize(),
                technicalRecruiters.getTotalElements(),
                technicalRecruiters.getTotalPages(),
                technicalRecruiters.isFirst(),
                technicalRecruiters.isLast()

        );

    }

    @Override
    public void blockEmployeeById(Integer employeeId) {
        if (hrRecruiterRepository.existsById(employeeId)){
            HRRecruiter recruiter = hrRecruiterRepository.findById(employeeId)
                    .orElseThrow();
            recruiter.setAccountActivated(false);
            hrRecruiterRepository.save(recruiter);
        } else if (technicalRecruiterRepository.existsById(employeeId)) {
            TechnicalRecruiter recruiter = technicalRecruiterRepository.findById(employeeId)
                    .orElseThrow();
            recruiter.setAccountActivated(false);
            technicalRecruiterRepository.save(recruiter);
        }
    }

    @Override
    public void enableEmployeeById(Integer employeeId) {
        if (hrRecruiterRepository.existsById(employeeId)){
            HRRecruiter recruiter = hrRecruiterRepository.findById(employeeId)
                    .orElseThrow();
            recruiter.setAccountActivated(true);
            hrRecruiterRepository.save(recruiter);
        } else if (technicalRecruiterRepository.existsById(employeeId)) {
            TechnicalRecruiter recruiter = technicalRecruiterRepository.findById(employeeId)
                    .orElseThrow();
            recruiter.setAccountActivated(true);
            technicalRecruiterRepository.save(recruiter);
        }
    }
}
