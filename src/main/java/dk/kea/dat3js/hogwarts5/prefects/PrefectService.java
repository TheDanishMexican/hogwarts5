package dk.kea.dat3js.hogwarts5.prefects;

import dk.kea.dat3js.hogwarts5.students.Student;
import dk.kea.dat3js.hogwarts5.students.StudentRepository;
import dk.kea.dat3js.hogwarts5.students.StudentResponseDTO;
import dk.kea.dat3js.hogwarts5.students.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrefectService {
    private final StudentRepository studentRepository;
    private final StudentService studentService;

    public PrefectService(StudentRepository studentRepository, StudentService studentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }

    public Optional<StudentResponseDTO> togglePrefectStatus(int id) {
        if (studentRepository.existsById(id)) {
            Student student = studentRepository.findById(id).orElseThrow();
            student.setPrefect(!student.isPrefect());
            return Optional.of(studentService.toDTO(studentRepository.save(student)));
        } else {
            return Optional.empty();
        }
    }

    public List<StudentResponseDTO> findPrefects() {
        return studentRepository.findAllByPrefectIsTrue().stream().map(studentService::toDTO).toList();
    }

}
