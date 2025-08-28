package med.helper.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.helper.api.dto.ListDataDoctor;
import med.helper.api.models.doctor.Doctor;
import med.helper.api.dto.RegisterDataDoctor;
import med.helper.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void registerDoctor(@RequestBody @Valid RegisterDataDoctor data) {
        repository.save(new Doctor(data));
    }

    @GetMapping
    public List<ListDataDoctor> listDoctor() {
        return repository.findAll().stream().map(ListDataDoctor::new).toList();
    }
}
