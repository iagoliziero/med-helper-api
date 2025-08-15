package med.helper.api.controller;

import med.helper.api.doctor.RegisterDataDoctor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @PostMapping
    public void registerDoctor(@RequestBody RegisterDataDoctor data) {
        System.out.println(data);
    }
}
