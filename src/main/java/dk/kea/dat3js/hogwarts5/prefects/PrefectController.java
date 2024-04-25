package dk.kea.dat3js.hogwarts5.prefects;

import dk.kea.dat3js.hogwarts5.students.StudentResponseDTO;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prefects")
public class PrefectController {
    private final PrefectService prefectService;

    public PrefectController(PrefectService prefectService) {
        this.prefectService = prefectService;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> togglePrefectStatus(@PathVariable int id) {
        return ResponseEntity.of(prefectService.togglePrefectStatus(id));
    }

    @GetMapping
    public List<StudentResponseDTO> findPrefects() {
        return prefectService.findPrefects();
    }


}
