package dk.kea.dat3js.hogwarts5.ghost;

import dk.kea.dat3js.hogwarts5.house.HouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ghosts")
public class GhostController {

    private final HouseService houseService;

    private List<Ghost> ghosts = new ArrayList<>();

    public GhostController(HouseService houseService) {
        this.houseService = houseService;
    }

    private void initGhosts() {
        houseService.findById("Gryffindor").ifPresent(house ->
                ghosts.add(new Ghost(1, "Nearly Headless Nick", "Sir Nicholas de Mimsy-Porpington", house))
        );
        houseService.findById("Slytherin").ifPresent(house ->
                ghosts.add(new Ghost(2, "The Bloody Baron", "Baron", house))
        );
        houseService.findById("Hufflepuff").ifPresent(house ->
                ghosts.add(new Ghost(3, "The Fat Friar", "Friar", house))
        );
        houseService.findById("Ravenclaw").ifPresent(house ->
                ghosts.add(new Ghost(4, "The Grey Lady", "Helena Ravenclaw", house))
        );
    }

    @GetMapping
    public List<Ghost> getAllGhosts() {
        if (ghosts.isEmpty()) {
            initGhosts();
        }
        return ghosts;
    }

    @GetMapping("/{name}")
    public ResponseEntity<Ghost> getGhost(@PathVariable String name) {
        if (ghosts.isEmpty()) {
            initGhosts();
        }
        return ResponseEntity.of(ghosts.stream().filter(ghost -> ghost.getName().contains(name)).findFirst());
    }
}

