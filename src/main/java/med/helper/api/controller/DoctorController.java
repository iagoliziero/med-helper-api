package med.helper.api.controller;

import jakarta.transaction.Transactional;
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
    public void registerDoctor(@RequestBody RegisterDataDoctor data) {
        repository.save(new Doctor(data));
    }
}
