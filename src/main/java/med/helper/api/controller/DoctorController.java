package med.helper.api.controller;

import med.helper.api.models.doctor.Doctor;
import med.helper.api.repository.DoctorRepository;
import med.helper.api.models.doctor.RegisterDataDoctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    public void registerDoctor(@RequestBody RegisterDataDoctor data) {
        repository.save(new Doctor(data));
    }
}
