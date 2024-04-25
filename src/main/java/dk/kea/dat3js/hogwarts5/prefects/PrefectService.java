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
        Optional<Student> studentOptional = studentRepository.findById(id);

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setPrefect(!student.isPrefect());
            return Optional.of(studentService.toDTO(studentRepository.save(student)));
        } else {
            return Optional.empty();
        }
    }

    public Optional<StudentResponseDTO> findByIdIfExists(int id) {
        return studentRepository.findById(id)
                .filter(Student::isPrefect)
                .map(studentService::toDTO);
    }


    public List<StudentResponseDTO> findPrefects() {
        return studentRepository.findAllByPrefectIsTrue().stream().map(studentService::toDTO).toList();
    }

    public List<StudentResponseDTO> findPrefectsByHouse(String house) {
        String formattedHouse = Character.toUpperCase(house.charAt(0)) + house.substring(1).toLowerCase();
        List<StudentResponseDTO> prefects = findPrefects();
        return prefects.stream()
                .filter(student -> student.house().equals(formattedHouse))
                .toList();
    }
}
