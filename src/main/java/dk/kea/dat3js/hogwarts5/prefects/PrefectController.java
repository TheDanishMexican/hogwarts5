package dk.kea.dat3js.hogwarts5.prefects;

import dk.kea.dat3js.hogwarts5.students.StudentResponseDTO;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prefects")
public class PrefectController {
    private final PrefectService prefectService;

    public PrefectController(PrefectService prefectService) {
        this.prefectService = prefectService;
    }

//    @PatchMapping("/{id}")
//    public ResponseEntity<StudentResponseDTO> togglePrefectStatus(@PathVariable int id) {
//        prefectService.togglePrefectStatus(id);
//    }
}
