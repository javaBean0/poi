package poi.student.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import poi.student.domain.Student;
import poi.student.mapper.sql.StudentSqlProvider;

import java.util.List;

/**
 * Created with IDEA
 * author:bigStone
 * Date:2019/5/6
 **/
@Mapper
public interface StudentMapper {

    @SelectProvider(type = StudentSqlProvider.class, method = "findAll")
    List<Student> findAll(Student student);

    @Insert({
            "<script>",
            "insert into t_student(sid, username, password, sclass, score) values ",
            "<foreach collection='students' item='item' index='index' separator=','>",
            "(#{item.sid}, #{item.username}, #{item.password}, #{item.sclass},  #{item.score})",
            "</foreach>",
            "</script>"
    })
    int insertList(@Param(value = "students") List<Student> students);
}
