package med.helper.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.helper.api.dto.ListDataDoctor;
import med.helper.api.dto.UpdateDataDoctor;
import med.helper.api.models.doctor.Doctor;
import med.helper.api.dto.RegisterDataDoctor;
import med.helper.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void registerDoctor(@RequestBody @Valid RegisterDataDoctor data) {
        System.out.println(data);
        repository.save(new Doctor(data));
    }

    @GetMapping
    public Page<ListDataDoctor> listDoctor(@PageableDefault(size = 10, sort = {"name"}) Pageable  pagination) {
        return repository.findAllByActiveTrue(pagination).map(ListDataDoctor::new);
    }

    @PutMapping
    @Transactional
    public void updateDoctor(@RequestBody @Valid UpdateDataDoctor data) {
        var doctor = repository.getReferenceById(data.id());
        doctor.infosUpdate(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void inactiveDoctor(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        doctor.inactive();
    }
}