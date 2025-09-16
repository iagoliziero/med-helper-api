package med.helper.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.helper.api.dto.DataDoctorDetails;
import med.helper.api.dto.ListDataDoctor;
import med.helper.api.dto.UpdateDataDoctor;
import med.helper.api.models.doctor.Doctor;
import med.helper.api.dto.RegisterDataDoctor;
import med.helper.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registerDoctor(@RequestBody @Valid RegisterDataDoctor data, UriComponentsBuilder uriBuilder) {
       var doctor = new Doctor(data);
       repository.save(doctor);

        var uri = uriBuilder.path("/doctor/{id}").buildAndExpand(doctor.getId());

        return ResponseEntity.created(uri.toUri()).body(new DataDoctorDetails(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<ListDataDoctor>> listDoctor(@PageableDefault(size = 10, sort = {"name"}) Pageable  pagination) {
        var page = repository.findAllByActiveTrue(pagination).map(ListDataDoctor::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateDoctor(@RequestBody @Valid UpdateDataDoctor data) {
        var doctor = repository.getReferenceById(data.id());
        doctor.infosUpdate(data);

        return ResponseEntity.ok(new DataDoctorDetails(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity inactiveDoctor(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        doctor.inactive();
        return ResponseEntity.noContent().build();
    }
}