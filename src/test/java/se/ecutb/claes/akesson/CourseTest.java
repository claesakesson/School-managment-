package se.ecutb.claes.akesson;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.ecutb.claes.akesson.data_access.CourseDao;
import se.ecutb.claes.akesson.data_access.CourseDaoList;
import se.ecutb.claes.akesson.model.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseTest {

    private Course course;
    private CourseDaoList courseDaoList;
    @Before
    public void start(){
        List list = new ArrayList();
        course = new Course(1, "test", LocalDate.parse("2020-03-21"),10,list );
    }



    @Test
public void test_save(){
        courseDaoList.saveCourse(course);
        Course expected = course;
        Course actual = course;
        Assert.assertEquals(expected, actual);
    }
@Test

    public void test_remove(){
        courseDaoList.saveCourse(course);
        Assert.assertEquals(true,courseDaoList.removeCourse(course));
}

@Test
    public void test_findname(){
        List<Course> expected = new ArrayList<>();
        expected.add(course);

        List<Course> actual = courseDaoList.findByName("test");

        Assert.assertEquals(expected, actual);

}

}
