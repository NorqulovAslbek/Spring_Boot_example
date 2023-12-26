package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentController {
    private List<StudentDTO> lists = new LinkedList<>();

    public StudentController() {
        StudentDTO studentDTO1 = new StudentDTO();
        studentDTO1.setId(UUID.randomUUID().toString());
        studentDTO1.setSurname("Norqulov");
        studentDTO1.setName("Aslbek");
        lists.add(studentDTO1);
        StudentDTO studentDTO2 = new StudentDTO();
        studentDTO2.setId(UUID.randomUUID().toString());
        studentDTO2.setSurname("Ali");
        studentDTO2.setName("Aliyev");
        lists.add(studentDTO2);
        StudentDTO studentDTO3 = new StudentDTO();
        studentDTO3.setId(UUID.randomUUID().toString());
        studentDTO3.setSurname("Ali");
        studentDTO3.setName("Aliyev");
        lists.add(studentDTO3);

    }

    @GetMapping()
    public StudentDTO getStudentDTO() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(UUID.randomUUID().toString());
        studentDTO.setSurname("Norqulov");
        studentDTO.setName("Aslbek");
        return studentDTO;
    }

    @GetMapping("/all")

    public List<StudentDTO> getAll() {
        return lists;
    }

    @GetMapping("/{id}")
    public StudentDTO getByIdStudentDTO(@PathVariable("id") String id) {
        for (StudentDTO list : lists) {
            if (list.getId().equals(id)) {
                return list;
            }
        }
        return null;
    }


    @PostMapping("/create")
    public boolean creatStudentDTO(@RequestBody StudentDTO studentDTO) {
        studentDTO.setId(UUID.randomUUID().toString());
        lists.add(studentDTO);
        return true;
    }

    @PutMapping("/update/{id}")
    public boolean update(@RequestBody StudentDTO studentDTO, @PathVariable("id") String id) {
        for (StudentDTO list : lists) {
            if (list.getId().equals(id)) {
                list.setName(studentDTO.getName());
                list.setSurname(studentDTO.getSurname());
                return true;
            }
        }
        return false;
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") String id) {
        return lists.removeIf(studentDTO -> studentDTO.getId().equals(id));
    }


}
