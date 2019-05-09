package poi.student.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import poi.student.domain.Student;
import poi.student.mapper.StudentMapper;
import poi.student.service.StudentService;

import java.util.List;

/**
 * Created with IDEA
 * author:bigStone
 * Date:2019/5/6
 **/

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAll(Student student) {

        return studentMapper.findAll(student);
    }

    @Override
    public int insertList(List<Student> students) {
        return studentMapper.insertList(students);
    }

    public static void main(String[] args) {
        double a = 2;
        int b = (int)a;
        System.out.println(b);
    }


}
