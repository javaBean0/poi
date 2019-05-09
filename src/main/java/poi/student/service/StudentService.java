package poi.student.service;

import poi.student.domain.Student;

import java.util.List;

/**
 * Created with IDEA
 * author:bigStone
 * Date:2019/5/6
 **/

public interface StudentService {

    List<Student> findAll(Student student);

    int insertList(List<Student> students);
}
