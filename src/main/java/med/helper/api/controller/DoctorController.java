package med.helper.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.helper.api.models.doctor.Doctor;
import med.helper.api.models.doctor.RegisterDataDoctor;
import med.helper.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void registerDoctor(@RequestBody @Valid RegisterDataDoctor data) {
        try {
            repository.save(new Doctor(data));
        } catch (Exception e) {
            System.out.println("Error create doctor: " + e.getMessage());
        }
    }
}
