package poi.student.mapper.sql;

import org.apache.ibatis.jdbc.SQL;
import poi.student.domain.Student;

/**
 * Created with IDEA
 * author:bigStone
 * Date:2019/5/6
 **/
public class StudentSqlProvider {

    public String findAll(Student student) {

        return new SQL(){{
            SELECT("*");
            FROM("t_student");
            if(student.getSclass() != null){
                WHERE("sclass like '%' || #{sclass} || '%'");
            }
            if(student.getUsername() != null){
                WHERE("username like '%' || #{username} || '%' ");
            }
        }}.toString();
    }




}
