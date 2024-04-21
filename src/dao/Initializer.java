package dao;

import ADT.CLinkedList;
import ADT.CircularListInterface;
import Entities.Course;
import Entities.Student;
import Entities.TutorialGroup;

public class Initializer {


    public CircularListInterface<Student> studentInitialize1(){
        CircularListInterface<Student> studentlist = new CLinkedList<>();
        studentlist.add(new Student("Alice", "RSD", "G1", "FOCS","Semester1", "Alice@tarc.edu.my" ));
        studentlist.add(new Student("Bob", "RSD", "G1", "FOCS","Semester1", "Bob@tarc.edu.my" ));
        studentlist.add(new Student("Charlie","RSD", "G1", "FOCS","Semester1", "Charlie@tarc.edu.my" ));
        studentlist.add(new Student("Charlie","RSW", "G1", "FOCS","Semester1", "Charlie@tarc.edu.my" ));
        studentlist.add(new Student("Carl","RSD", "G1", "FOCS","Semester1", "Carl@tarc.edu.my" ));
        studentlist.add(new Student("Molly","RSD", "G1", "FOCS","Semester1", "Molly@tarc.edu.my" ));

        return studentlist;
    }
    public CircularListInterface<Student> studentInitialize2(){
        CircularListInterface<Student> studentlist2 = new CLinkedList<>();
        studentlist2.add(new Student("Bobby","RSD", "G1", "FOCS","Semester1", "Bobby@tarc.edu.my" ));
        studentlist2.add(new Student("Conny","RSD", "G1", "FOCS","Semester1", "Conny@tarc.edu.my" ));
        studentlist2.add(new Student("Polly","RSD", "G1", "FOCS","Semester1", "Polly@tarc.edu.my" ));
        studentlist2.add(new Student("Ken","RSD", "G1", "FOCS","Semester1", "Ken@tarc.edu.my" ));
        studentlist2.add(new Student("Sacy","RSD", "G1", "FOCS","Semester1", "Sacy@tarc.edu.my" ));
        studentlist2.add(new Student("Paul","RSD", "G1", "FOCS","Semester1", "Paul@tarc.edu.my" ));
        studentlist2.add(new Student("Darren","RSD", "G1", "FOCS","Semester1", "Darren@tarc.edu.my" ));
        return studentlist2;
    }


    // TODO: change to student class
    public CircularListInterface<String> studentInitString(){
        CircularListInterface<String> studentList = new CLinkedList<>();
        studentList.add("Charlie");
        studentList.add("Bob");
        studentList.add("Carl");
        studentList.add("Sally");
        studentList.add("Dave");
        studentList.add("Chum");
        studentList.add("Chummy");
        studentList.add("John");
        studentList.add("Mike");
        studentList.add("Emily");
        studentList.add("Sarah");
        studentList.add("Alex");
        studentList.add("Jessica");
        studentList.add("Tyler");
        studentList.add("Liam");
        studentList.add("Olivia");
        studentList.add("Ethan");
        studentList.add("Ava");
        studentList.add("Noah");
        studentList.add("Isabella");
        studentList.add("Mason");
        return studentList;
    }

    // TODO: change to tutor class
    public CircularListInterface<String> tutorlistinit(){
        CircularListInterface<String> tutorList = new CLinkedList<>();
        tutorList.add("Tutor1");
        tutorList.add("Tutor2");
        tutorList.add("Tutor3");
        tutorList.add("Tutor4");
        tutorList.add("Tutor5");
        tutorList.add("Tutor6");
        tutorList.add("Tutor7");
        return tutorList;
    }

    // TODO: change to course class
    public CircularListInterface<String> courseListInit(){
        CircularListInterface<String> courseList = new CLinkedList<>();
        courseList.add("Course1");
        courseList.add("Course2");
        courseList.add("Course3");
        courseList.add("Course4");
        courseList.add("Course5");
        courseList.add("Course6");
        courseList.add("Course7");
        courseList.add("Course8");
        return courseList;
    }



    public CircularListInterface<String> programListInit(){
        CircularListInterface<String> programList = new CLinkedList<>();
        programList.add("Program1");
        programList.add("Program2");
        programList.add("Program3");
        programList.add("Program4");
        programList.add("Program5");
        programList.add("Program6");
        programList.add("Program7");
        programList.add("Program8");
        return programList;
    }

    public CircularListInterface<String> selectedStudentListInit(){
        CircularListInterface<String> selectedStudentList = new CLinkedList<>();
        return selectedStudentList;
    }

    public CircularListInterface<String> courseSemesterListInit(){
        CircularListInterface<String> courseSemesterList = new CLinkedList<>();
        return courseSemesterList;
    }

    public CircularListInterface<String> courseDetailListInit(){
        CircularListInterface<String> courseDetailList = new CLinkedList<>();
        return courseDetailList;
    }

    public CircularListInterface<String> facultyListInit(){
        CircularListInterface<String> facultyList = new CLinkedList<>();
        return facultyList;
    }

    public CircularListInterface<String> facultyListInit2(){
        CircularListInterface<String> facultyList2 = new CLinkedList<>();
        return facultyList2;
    }

    public CircularListInterface<String> allCourseOfOneProgramListInit(){
        CircularListInterface<String> allCourseOneProgramList = new CLinkedList<>();
        return allCourseOneProgramList;
    }

    public CircularListInterface<String> feesListInit(){
        CircularListInterface<String> feesList = new CLinkedList<>();
        return feesList;
    }


    public CircularListInterface<String> studentCriteriaInit(){
        CircularListInterface<String> studentCriteriaList = new CLinkedList<>();
        return studentCriteriaList;
    }

    public CircularListInterface<Course> courseProgramListInit(){
        CircularListInterface<Course> courseProgramList = new CLinkedList<>();
        courseProgramList.add(new Course("RSW","G1", "RSWdetails","Semester1","Faculty1",100));
        courseProgramList.add(new Course("RSW","G1", "RSWdetails","Semester1","Faculty2",100));
        courseProgramList.add(new Course("RSW","G1", "RSWdetails","Semester1","Faculty3",100));
        courseProgramList.add(new Course("RSF","G1", "RSFdetails","Semester1","Faculty1",200));
        courseProgramList.add(new Course("RSF","G1", "RSFdetails","Semester2","Faculty2",200));
        courseProgramList.add(new Course("RSF","G1", "RSFdetails","Semester3","Faculty3",200));
        courseProgramList.add(new Course("RSG","G3", "RSGdetails","Semester1","Faculty4",1000));
        courseProgramList.add(new Course("RSG","G2", "RSGdetails","Semester2","Faculty5",300));
        courseProgramList.add(new Course("RSG","G2", "RSGdetails","Semester3","Faculty6",300));
        courseProgramList.add(new Course("RSJ","G2", "RSJdetails","Semester1","Faculty4",400));
        courseProgramList.add(new Course("RSH","G4", "RSHdetails","Semester2","Faculty5",500));
        courseProgramList.add(new Course("RSK","G5", "RSKdetails","Semester3","Faculty6",700));
        courseProgramList.add(new Course("RSH","G9", "RSHdetails","Semester2","Faculty1",400));
        courseProgramList.add(new Course("RSH","G8", "RSHdetails","Semester3","Faculty2",500));
        courseProgramList.add(new Course("RSH","G7", "RSHdetails","Semester1","Faculty3",600));
        courseProgramList.add(new Course("RSR","G6", "RSRdetails","Semester3","Faculty4",400));
        courseProgramList.add(new Course("RSA","G5", "RSAdetails","Semester2","Faculty6",600));
        courseProgramList.add(new Course("RS10","G10", "RS10","Semester10","Faculty10", 1000));
        courseProgramList.add(new Course("RSC","G3", "RSCdetails","Semester1","Faculty10", 1000));
        courseProgramList.add(new Course("RSL","G1", "RSLdetails","Semester1","Faculty2", 350));
        courseProgramList.add(new Course("RSM","G1", "RSMdetails","Semester1","Faculty2", 210));
        courseProgramList.add(new Course("RSN","G1", "RSNdetails","Semester2","Faculty2", 999));

        return courseProgramList;
    }




    public CircularListInterface<TutorialGroup> tutorialGroupListInit(){
        CircularListInterface<TutorialGroup> tutorialGrouplist = new CLinkedList<>();
        tutorialGrouplist.add(new TutorialGroup("GRP1", "Tutor1", "Course1"));
        tutorialGrouplist.add(new TutorialGroup("GRP2", "Tutor2", "Course2"));
        tutorialGrouplist.add(new TutorialGroup("GRP3", "Tutor3", "Course3"));
        tutorialGrouplist.add(new TutorialGroup("GRP4", "Tutor4", "Course4"));
        tutorialGrouplist.add(new TutorialGroup("GRP5", "Tutor5", "Course5"));
        tutorialGrouplist.add(new TutorialGroup("GRP6", "Tutor6", "Course6"));
        tutorialGrouplist.add(new TutorialGroup("GRP7", "Tutor7", "Course7"));
        tutorialGrouplist.add(new TutorialGroup("GRP8", "Tutor8", "Course8"));
        return tutorialGrouplist;
    }


    //Student
    public CircularListInterface<String> studentClassInitString(){
        CircularListInterface<String> studentClassList = new CLinkedList<>();
        studentClassList.add("FOCS");
        return studentClassList;
    }

    public CircularListInterface<String> emailInitString(){
        CircularListInterface<String> emailList = new CLinkedList<>();
        emailList.add("wong@gmail.com");
        return emailList;
    }

    public CircularListInterface<Student> studentDetailListInit(){
        CircularListInterface<Student> studentlist = new CLinkedList<>();
        studentlist.add(new Student( "Alice", "RSD", "G1", "FOCS","Semester1", "Alice@tarc.edu.my" ));
        studentlist.add(new Student( "Bob", "RSD", "G1", "FOCS","Semester1", "Bob@tarc.edu.my" ));
        studentlist.add(new Student( "Charlie","RSD", "G1", "FOCS","Semester1", "Charlie@tarc.edu.my" ));
        studentlist.add(new Student( "Charlie","RSW", "G1", "FOCS","Semester1", "Charlie@tarc.edu.my" ));
        studentlist.add(new Student( "Charlie","RSJ", "G1", "FOCS","Semester2", "Charlie@tarc.edu.my" ));
        studentlist.add(new Student( "Carl","RSD", "G1", "FOCS","Semester2", "Carl@tarc.edu.my" ));
        studentlist.add(new Student( "Molly","RSD", "G1", "FOCS","Semester3", "Molly@tarc.edu.my" ));
        studentlist.add(new Student( "Jill", "RSD", "G1", "FORK","Semester1", "Alice@tarc.edu.my" ));
        studentlist.add(new Student( "Joe", "RSD", "G1", "FORK","Semester1", "Bob@tarc.edu.my" ));
        studentlist.add(new Student( "Jamie","RSD", "G1", "FABC","Semester1", "Charlie@tarc.edu.my" ));
        studentlist.add(new Student( "Jamie","RSW", "G1", "FJJJ","Semester1", "Charlie@tarc.edu.my" ));
        studentlist.add(new Student( "Charlie","RSJ", "G1", "FOGG","Semester2", "Charlie@tarc.edu.my" ));
        studentlist.add(new Student( "Carl","RSD", "G1", "FOGG","Semester2", "Carl@tarc.edu.my" ));
        studentlist.add(new Student( "Molly","RSD", "G1", "FABC","Semester3", "Molly@tarc.edu.my" ));

        return studentlist;
    }




}
