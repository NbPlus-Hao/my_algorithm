package com.example.class02;

import com.example.class02.entity.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * 任何比较器：
 * compare方法遵循以下规范：
 * 返回负数的时候认为第一个参数应该排到前面
 * 返回正数的时候认为第二个参数应该排在前面
 * 返回0的时候无所谓
 */
public class Code01_Comparator {

    public static void main(String[] args) {
        Student student1 = new Student("张三", 1, 23);
        Student student2 = new Student("李四", 2, 26);
        Student student3 = new Student("王五", 2, 24);

        Student[] students = {student1, student2, student3};
        Arrays.sort(students, new IdAgeComparator());
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("=====================================");
//        TreeMap<Student,String> treeMap = new TreeMap<>(new IdAgeComparator());
//        TreeMap<Student,String> treeMap = new TreeMap<>((a,b) -> a.getAge() - b.getAge());
        TreeMap<Student,String> treeMap = new TreeMap<>(Comparator.comparingInt(Student::getAge));
        treeMap.put(student1,"我是学生1--张三");
        treeMap.put(student2,"我是学生2--李四");
        treeMap.put(student3,"我是学生1--王五");

        System.out.println(treeMap);
    }

    static class AgeComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
//        return o1.getAge() - o2.getAge();
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }

    static class IdComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return Integer.compare(o1.getId(), o2.getId());
        }
    }

    static class IdAgeComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getId() != o2.getId() ? o1.getId() - o2.getId() : o1.getAge() - o2.getAge();
        }
    }

}
