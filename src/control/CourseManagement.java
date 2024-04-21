package control;

import ADT.CircularListInterface;
import Entities.Course;
import UI.*;
import dao.Initializer;

public class CourseManagement {

    Initializer init = new Initializer();
    CircularListInterface<Course> courseProgramlist = init.courseProgramListInit();
    CircularListInterface<String> facultyList = init.facultyListInit();
    CircularListInterface<String> facultyListSort = init.facultyListInit2();
    CircularListInterface<String> allCourseList = init.allCourseOfOneProgramListInit();
    CircularListInterface<String> courseSemesterList = init.courseSemesterListInit();
    CircularListInterface<String> courseDetailList = init.courseDetailListInit();
    CircularListInterface<String> feesLists = init.feesListInit();
    UI ui = new UI();

    public CourseManagement(CircularListInterface<Course> CP){
        courseProgramlist = CP;

    }

    public CircularListInterface<Course> runCourse(){
        int choice = 0;
        String errorMsg = null;

        do {
            ui.courseMenuDisplay(errorMsg);
            choice = ui.getChoice(20);
            // Process the user's choice
            switch (choice) {
                case 1:
                    errorMsg = addProgram();
                    break;
                case 2:
                    errorMsg = addCourse();
                    break;
                case 3:
                    errorMsg = listCourseDetails();
                    break;
                case 4:
                    errorMsg = removeProgram();
                    break;
                case 5:
                    errorMsg = removeCourses();
                    break;
                case 6:
                    errorMsg = findCourseInSemester();
                    break;
                case 7:
                    errorMsg = amendCourseDetails();
                    break;
                case 8:
                    errorMsg = listCourseByFaculty();
                    break;
                case 9:
                    errorMsg = listCourseOfProgramme();
                    break;
                case 10:
                    errorMsg = report1();
                    break;
                case 11:
                    errorMsg = report2();
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 0);

        return courseProgramlist;
    }

    public String addProgram() {
        System.out.println("Selected Choice: Add Program To Course(s)");

        int numberOfInputs = ui.getNumberCourseInputs();
        System.out.println(" ");
        if (numberOfInputs == 1) {

            String courseName = ui.getCourseName();
            Course selectedCourse = findCourseByName(courseName);

            if (selectedCourse != null) {
                Course newCourse = ui.addProgramToCourse(courseName);
                courseProgramlist.addSame(newCourse);
                System.out.println("Successfully Added.");

            } else {
                System.out.println("Course not found.");
                System.out.println("Unable to add new Program.");
                System.out.println(" ");
            }

        }else{
            String programmeName = ui.getProgramName();

            for (int i = 1; i <=numberOfInputs ; i++){
                System.out.println("Course " + i + ": ");
                System.out.println("Eg: RSW, RSD");
                String courseName = ui.getMultipleCourseName();
                Course newCourse = ui.addProgramToMultiplteCourse(courseName, programmeName);

                Course selectedCourse = findCourseByName(courseName);

                if (selectedCourse != null) {
                    courseProgramlist.addSame(newCourse);
                    System.out.println("Successfully Added.");
                } else {
                    System.out.println("Course not found.");
                    System.out.println("Unable to add new Program.");
                    System.out.println(" ");
                    break;
                }
            }


        }

        return " ";
    }

    public String addCourse() {
        System.out.println("Selected Choice: Add Course To Program(s)");

        int numberOfInputs = ui.getNumberProgramInputs();
        System.out.println(" ");
        if (numberOfInputs == 1) {

            String programName = ui.getProgramName();
            Course selectedProgram = findProgramByName(programName);

            if (selectedProgram != null) {
                Course newProgram = ui.addCourseToProgram(programName);
                courseProgramlist.addSame(newProgram);
                System.out.println("Successfully Added.");

            } else {
                System.out.println("Program not found.");
                System.out.println("Unable to add new Course.");
                System.out.println(" ");
            }

        }else{
            String courseName = ui.getCourseName();

            for (int i = 1; i <=numberOfInputs ; i++){
                System.out.println("Program " + i + ": ");
                System.out.println("Eg: G1, G2");
                String programName = ui.getMultipleProgramName();
                Course newProgram = ui.addCourseToMultiplteProgram(courseName, programName);

                Course selectedProgram = findProgramByName(programName);

                if (selectedProgram != null) {
                    courseProgramlist.addSame(newProgram);
                    System.out.println("Successfully Added.");

                } else {
                    System.out.println("Program not found.");
                    System.out.println("Unable to add new Course.");
                    System.out.println(" ");
                    break;
                }
            }

        }


        return " ";
    }



    public String removeProgram() {
        System.out.println("Selected Choice: Remove Program From Course");
        String courseName = ui.getCourseName();
        Course selectedCourse = findCourseByName(courseName);

        if (selectedCourse != null) {
            Course newCourse = ui.removeProgramFromCourse(courseName);
            String programName = newCourse.getProgramName();
            String semesterName = newCourse.getSemesterName();
            String facultyName = newCourse.getFacultyName();

            boolean absent = false;
            //Validate
            for (Course course : courseProgramlist) {
                if (course.getProgramName().equals(programName) &&
                        course.getCourseName().equals(courseName) &&
                        course.getFacultyName().equals(facultyName) &&
                        course.getSemesterName().equals(semesterName)) {
                    absent = true;
                    courseProgramlist.remove(course);
                    System.out.println("Successfully Removed.");
                    System.out.println(" ");

                }
            }

            if(!absent){
                System.out.println("Course not found.");
                System.out.println("Unable to remove Program.");
                System.out.println(" ");
            }


            } else {
            System.out.println("Course not found.");
            System.out.println("Unable to remove Program.");
            System.out.println(" ");
        }
        return " ";
    }

    public String removeCourses() {
        System.out.println("Selected Choice: Remove Course From Program");
        String programName = ui.getProgramName();
        Course selectedCourse = findProgramByName(programName);

        if (selectedCourse != null) {
            Course newCourse = ui.removeCourseFromProgram(programName);
            String courseName = newCourse.getCourseName();
            String semesterName = newCourse.getSemesterName();
            String facultyName = newCourse.getFacultyName();

            boolean absent = false;
            //Validate
            for (Course course : courseProgramlist) {

                if (course.getProgramName().equals(programName) &&
                        course.getCourseName().equals(courseName) &&
                        course.getFacultyName().equals(facultyName) &&
                        course.getSemesterName().equals(semesterName)) {
                    courseProgramlist.remove(course);
                    absent = true;
                    System.out.println("Successfully Removed.");

                    System.out.println(" ");

                }
            }

            if(!absent){
                System.out.println("Program not found.");
                System.out.println("Unable to remove Program.");
                System.out.println(" ");
            }


        } else {

            System.out.println("Program not found.");
            System.out.println("Unable to remove Course.");
            System.out.println(" ");
        }
        return " ";
    }


    //Search Courses offered in a semester
    public String findCourseInSemester(){
        System.out.println("Selected Choice: Search Course Offered In Semester");
        String semesterName = ui.getSemesterName();

        boolean foundCourses = false;

        Course selectedSemester = findSemesterByName(semesterName);
        if (courseProgramlist.contains(selectedSemester)) {
            System.out.println("These are the Courses in " + semesterName);


            int numbering = 1;
            String previousCourses = null;

            for (Course course : courseProgramlist) {
                if (course.getSemesterName().equals(semesterName)) {
                    foundCourses = true;
                    //Add to courseSemesterList
                    courseSemesterList.addSame(
                            "Course: " + course.getCourseName() +
                                    ", Program: " + course.getProgramName() +
                                    ", Faculty: " + course.getFacultyName());


                }
            }

            //List out all Courses
            System.out.println(" ");
            System.out.println("The list consists of: ");
            courseSemesterList.sort();
            for (String facultyName : courseSemesterList) {
                String course = extractCourse1(facultyName);
                String program = extractProgram1(facultyName);
                String faculty = extractFaculty2(facultyName);


                    if (previousCourses == null) {
                        System.out.println(" ");
                        System.out.println("= = = = = = = = = = = = = = =");
                        System.out.println("Course: " + course);
                        System.out.println("= = = = = = = = = = = = = = =");
                        System.out.println(numbering + ") " + "Program: " + program
                        + ", Faculty: " + faculty);
                        numbering++;

                    } else if ((previousCourses != null) && (previousCourses.equals(course))) {
                        System.out.println(numbering + ") " + "Program: " + program
                                + ", Faculty: " + faculty);
                        numbering++;


                    } else {
                        numbering = 1;
                        System.out.println(" ");
                        System.out.println("= = = = = = = = = = = = = = =");
                        System.out.println("Course: " + course);
                        System.out.println("= = = = = = = = = = = = = = =");
                        System.out.println(numbering + ") " + "Program: " + program
                                + ", Faculty: " + faculty);
                        numbering++;

                    }

                    previousCourses = course;

                }
                System.out.println(" ");
                System.out.println("= = = = = = = = = = = = = = =");


            //Search Functionalities
            if (!foundCourses) {
                System.out.println(" ");
                System.out.println("No courses found in " + semesterName);
            }
            System.out.println(" ");

            if (foundCourses) {
                System.out.println(" ");
                System.out.println("Enter a course name to search if it's offered in this semester:");
                String inputCourseName = ui.getCourseName();

                boolean courseFound = false;

                for (Course semester : courseProgramlist) {
                    if (semester.getSemesterName().contains(semesterName) &&
                            semester.getCourseName().contains(inputCourseName)) {
                        courseFound = true;
                    }
                }

                if (courseFound) {
                    System.out.println("Yes, the " + inputCourseName +
                            " is found in " + semesterName);

                    //Design the output
                    courseSemesterList.sort();
                    previousCourses = null;
                    numbering = 1;

                    for (String outputCourse : courseSemesterList){
                        String course = extractCourse1(outputCourse);
                        String program = extractProgram1(outputCourse);
                        String faculty = extractFaculty2(outputCourse);

                        if ((previousCourses == null) && (course.equals(inputCourseName))){
                            System.out.println(" ");
                            System.out.println("= = = = = = = = = = = = = = =");
                            System.out.println("Course: " + course);
                            System.out.println("= = = = = = = = = = = = = = =");
                            System.out.println(numbering + ") " + "Program: " + program
                                    + ", Faculty: " + faculty);
                            numbering++;
                        }
                         else if (course.equals(inputCourseName) && (!previousCourses.equals(course))
                         && (previousCourses != null)) {
                            numbering = 1;
                            System.out.println(" ");
                            System.out.println("= = = = = = = = = = = = = = =");
                            System.out.println("Course: " + course);
                            System.out.println("= = = = = = = = = = = = = = =");
                            System.out.println(numbering + ") " + "Program: " + program
                                    + ", Faculty: " + faculty);
                            numbering++;

                        }
                        else if (course.equals(inputCourseName) && (previousCourses.equals(course))
                          && (previousCourses != null)){
                            System.out.println(numbering + ") " + "Program: " + program
                                    + ", Faculty: " + faculty);
                            numbering++;
                        }
                        previousCourses = course;

                    }
                    System.out.println("= = = = = = = = = = = = = = =");
                    System.out.println(" ");

                    courseSemesterList.clear();

                } else {
                    System.out.println("No, this course is not offered in " + semesterName);
                    System.out.println(" ");
                    courseSemesterList.clear();
                }}

        } else {
            System.out.println("Semester not found.");
        }
        return " ";
    }


    //Amend course details for a programme
    public String amendCourseDetails() {
        System.out.println("Enter the name of the Program to update Course details:");
        String programName = ui.getProgramName();

        Course selectedProgram = findProgramByName(programName);

        if (selectedProgram != null) {

            //Get CourseName
            //List out ALL CourseNames in that Program
            for (Course faculty : courseProgramlist) {
                String programNames = faculty.getProgramName();
                String courseNames = faculty.getCourseName();
                String courseDetails = faculty.getCourseDetails();
                String facultys = faculty.getFacultyName();

                if (programName.equals(programNames)){
                    courseDetailList.addSame(programNames + " - "
                            + courseNames + " - " + courseDetails + " - "
                    + facultys);

                }
            }

            //Display
            System.out.println(" ");
            System.out.println("The program consists of courses: ");
            courseDetailList.sort();
            for(String facultyName : courseDetailList) {
                System.out.println(facultyName);

            }

            //Now select the course
            String courseName = ui.getCourseName();
            Course selectedCourse = findCourseByName(courseName);


                //Update all details related to this course
            for (Course course : courseProgramlist) {
                String faculties = course.getFacultyName();

                if (course.getCourseName().equals(courseName) &&
                        course.getProgramName().equals(programName) ) {
                    System.out.println("-------------------------------");
                    System.out.println("Enter New Course Detail (" + faculties + ") : ");

                    String newCourseDetails = ui.getCourseDetail();

                    if(course.getProgramName().equals(programName) &&
                    course.getCourseName().equals(courseName)){
                        assert selectedCourse != null;
                        course.setCourseDetails(newCourseDetails);
                    }

                }
            }
                courseDetailList.clear();
            System.out.println("Succcessfully updated");


        } else {
            System.out.println("Course not found.");
        }
        return " ";
    }


    //List courses taken by different faculties
    public String listCourseByFaculty() {
        facultyList.clear();
        System.out.println("Selected Choice: List Course Taken By Different Faculties");

        for (Course faculty : courseProgramlist) {
            String currentFacultyName = faculty.getFacultyName();
            String courseNames = faculty.getCourseName();
            facultyList.add(
                    "Faculty: " + currentFacultyName + ", Course: " + courseNames);

        }

        System.out.println(" ");
        System.out.println("The faculty list consists of: ");
        facultyList.sort();

        int numbering = 1;
        String previousFaculty = null;


        for(String facultyName : facultyList) {
            facultyListSort.addSame(facultyName);
            String faculty = extractFaculty(facultyName);
            String course = extractCourse(facultyName);

            //print out first faculty
            if (previousFaculty == null){
                System.out.println(" ");
                System.out.println("= = = = = = = = = = = = = = =");
                System.out.println("Faculty: " + faculty);
                System.out.println("= = = = = = = = = = = = = = =");
                System.out.println(numbering + ") " + course);
                numbering++;

            }
            else if (previousFaculty.equals(faculty)) {
                System.out.println(numbering + ") " + course);
                numbering++;


            }else {
                numbering = 1;
                System.out.println(" ");
                System.out.println("= = = = = = = = = = = = = = =");
                System.out.println("Faculty: " + faculty);
                System.out.println("= = = = = = = = = = = = = = =");
                System.out.println(numbering + ") " + course);
                numbering++;



            }

            previousFaculty = faculty;

        }
        System.out.println(" ");
        System.out.println("= = = = = = = = = = = = = = =");


        return " ";
    }



    //List all courses for a programme
    public String listCourseOfProgramme() {
        allCourseList.clear();

        System.out.println("Selected Choice: List ALL Course(s) of 1 Program");

        String programName = ui.getProgramName();
        Course selectedProgram = findProgramByName(programName);

        if (selectedProgram != null) {

            for (Course program : courseProgramlist) {

                String currentProgramName = program.getProgramName();
                String courseNames = program.getCourseName();
                String facultyNames = program.getFacultyName();

                if (currentProgramName.equals(programName)) {
                    allCourseList.addSame("Course: " + courseNames + " -  Faculty: " + facultyNames);
                }
            }

            System.out.println(" ");
            System.out.println("Program: " + programName);
            for(String coursesName : allCourseList) {
                System.out.println(coursesName);


            }

        } else {
            System.out.println("Program not found.");
            System.out.println(" ");
        }

        return " ";
    }



    private Course findCourseByName(String courseName) {
        for (Course course : courseProgramlist) {
            if (course.getCourseName().equals(courseName)) {
                return course;
            }
        }
        return null;
    }
    private Course findProgramByName(String programName) {
        for (Course program : courseProgramlist) {
            if (program.getProgramName().equals(programName)) {
                return program;
            }
        }
        return null;
    }
    private Course findSemesterByName(String semesterName) {
        for (Course semester : courseProgramlist) {
            if (semester.getSemesterName().equals(semesterName)) {
                return semester;
            }
        }
        return null;
    }



    public String listCourseDetails() {
        System.out.println("List of Courses Details:");
        int index = 1;
        for (Course course : courseProgramlist) {
            System.out.println(index + ". " + course);
            index++;
        }
        return " ";
    }

    private String extractProgramName(String courseSemester) {
        return courseSemester.split(",")[0].split(":")[1].trim();
    }

    private String extractCourse1(String courseSemester) {
        return courseSemester.split(",")[0].split(":")[1].trim();
    }

    private String extractProgram1(String courseSemester) {
        return courseSemester.split(",")[1].split(":")[1].trim();
    }

    private String extractFaculty2(String courseSemester) {
        return courseSemester.split(",")[2].split(":")[1].trim();
    }

    private String extractPrice1(String courseSemester) {
        return courseSemester.split(",")[2].split(":")[1].trim();
    }

    private String extractFaculty1(String courseSemester) {
        return courseSemester.split(",")[3].split(":")[1].trim();
    }

    private String extractProgram2(String courseSemester) {
        return courseSemester.split(",")[1].split(":")[1].trim();
    }

    private String extractPrice2(String courseSemester) {
        return courseSemester.split(",")[3].split(":")[1].trim();
    }

    private String extractCourse2(String courseSemester) {
        return courseSemester.split(",")[2].split(":")[1].trim();
    }

    private static String extractFaculty(String facultyCourse) {
        String prefix = "Faculty: ";
        int startIndex = facultyCourse.indexOf(prefix);
        if (startIndex != -1) {
            int endIndex = facultyCourse.indexOf(',', startIndex + prefix.length());
            if (endIndex == -1) { // If comma not found, take the substring till the end
                return facultyCourse.substring(startIndex + prefix.length()).trim();
            } else {
                return facultyCourse.substring(startIndex + prefix.length(), endIndex).trim();
            }
        }
        return "";
    }

    private static String extractCourse(String courseFaculty) {
        String prefix = "Course: ";
        int startIndex = courseFaculty.indexOf(prefix);
        if (startIndex != -1) {
            return courseFaculty.substring(startIndex + prefix.length()).trim();
        }
        return "";
    }

    private String extractPriceName(String courseSemester) {
        String[] sections = courseSemester.split(",");

        for (String section : sections) {
            if (section.trim().startsWith("Fees:")) {
                String[] parts = section.split(":");

                if (parts.length > 1) {
                    return parts[1].trim();
                }
            }
        }
        return null;
    }



//    Report1
//    Semester Offer what Program which Offers what Course + Price (Total)
    public String report1(){
        //Select Semester
        System.out.println("Selected Choice: Course Management - Report1");
        String semesterName = ui.getSemesterName();

        Course selectedSemester = findSemesterByName(semesterName);
        if (courseProgramlist.contains(selectedSemester)) {
            System.out.println(" ");
            System.out.println(semesterName + " consists of: ");

            for (Course program : courseProgramlist) {
                if (program.getSemesterName().equals(semesterName)) {

                    if (courseSemesterList.contains(program.getProgramName())) {
                        courseSemesterList.addSame(
                                "Program: " + program.getProgramName()
                                + ", Course: " + program.getCourseName() +
                                        ", Fees: " + program.getCoursePrice() +
                                        ", Faculty: " + program.getFacultyName());

                    } else {
                        courseSemesterList.addSame(
                                "Program: " + program.getProgramName()
                             + ", Course: " + program.getCourseName() +
                                ", Fees: " + program.getCoursePrice() +
                                ", Faculty: " + program.getFacultyName());

                    }
                }
            }



            courseSemesterList.sort();
            System.out.println(" ");

            int course1 = 0;
            int totalPrograms1 = 1;
            String previousCourse = null;
            int numbering = 1;

            courseSemesterList.sort();
            //Output List

            String format = "|| %1$-24s ||";
            System.out.println(" ");
            System.out.println("= = = = = = = = = = = = = = =");
            System.out.println("||**************************||");
            System.out.println("||                          ||");
            System.out.println("||         Report 1         ||");
            System.out.println("||                          ||");
            System.out.println("||**************************||");
            System.out.println("= = = = = = = = = = = = = = =");

            for (String courseSemester: courseSemesterList){
                String courseNow = extractProgram1(courseSemester);
                String programNow = extractCourse1(courseSemester);
                String priceNow = extractPrice1(courseSemester);
                String facultyNow = extractFaculty1(courseSemester);

                if (previousCourse == null) {
                    System.out.println(" ");
                    System.out.println("= = = = = = = = = = = = = = =");
                    System.out.println("||                          ||");
                    System.out.printf(format + "%n", "   Program: " + programNow );
                    System.out.println("||                          ||");
                    System.out.println("= = = = = = = = = = = = = = =");

                    System.out.println(numbering + ") " + "Course: " + courseNow
                    + ", Price: " + priceNow + ", Faculty: " + facultyNow);
                    numbering++;
                    course1++;

                }
                else if(programNow.contains(previousCourse)){
                    System.out.println(numbering + ") " + "Course: " + courseNow
                            + ", Price: " + priceNow + ", Faculty: " + facultyNow);
                    numbering++;
                    course1++;


                }else {
                    numbering = 1;
                    System.out.println(" ");
                    System.out.println("= = = = = = = = = = = = = = =");
                    System.out.println("||                          ||");
                    System.out.printf(format + "%n", "   Program: " + programNow );
                    System.out.println("||                          ||");
                    System.out.println("= = = = = = = = = = = = = = =");
                    System.out.println(numbering + ") " + "Course: " + courseNow
                            + ", Price: " + priceNow + ", Faculty: " + facultyNow);
                    course1++;

                }

                previousCourse = programNow;
            }
            System.out.println(" ");
            System.out.println("= = = = = = = = = = = = = = =");



            //Output Specifics
            String previousCourse2 = null;
            String PName = " ";
            int course = 0;
            int price = 0;
            int totalPrograms = 1;

            int grandCourses = 0;
            int grandFees = 0;


            System.out.println(" ");
            System.out.println("This Semester (" + semesterName + ") contains: ");
            //For Pricing
            for (String courseSemester2: courseSemesterList){
                String currentProgramName2 = extractProgramName(courseSemester2);
                String currentPrice2 = extractPriceName(courseSemester2);

                if (previousCourse2 == null || currentProgramName2.contains(previousCourse2)) {
                    course++;

                    assert currentPrice2 != null;
                    int priceInt = Integer.parseInt(currentPrice2);
                    PName = currentProgramName2;
                    price += priceInt;
                    grandCourses++;
                    grandFees += priceInt;



                }else {
                    System.out.println(" || = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ||");
                    String programDetails = String.format(" || %d) Program %-8s - Total Courses: %-2d - Total Fees: RM %-4d.00  ||",
                            totalPrograms, PName, course, price);
                    System.out.println(programDetails);


                    previousCourse2 = null;
                    PName = currentProgramName2;
                    course = 0;
                    price = 0;
                    totalPrograms++;
                    course++;

                    assert currentPrice2 != null;
                    int priceInt = Integer.parseInt(currentPrice2);
                    PName = currentProgramName2;
                    price += priceInt;
                    grandCourses++;
                    grandFees += priceInt;


                }

                previousCourse2 = currentProgramName2;
            }

            System.out.println(" || = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ||");
            String programDetails = String.format(" || %d) Program %-8s - Total Courses: %-2d - Total Fees: RM %-4d.00  ||",
                    totalPrograms, PName, course, price);
            System.out.println(programDetails);

            if ((totalPrograms < 10) && (grandCourses <10) ){
                System.out.println(" || = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ||");
                System.out.println(" || ***************************************************************** ||");
                System.out.printf(" || %-62s %d  ||%n", "Grand Program(s):", totalPrograms);
                System.out.printf(" || %-62s %d  ||%n", "Grand Course(s):", grandCourses);
                System.out.printf(" || %-54s RM %d.00 ||%n", "Grand Fees:", grandFees);
                System.out.println(" || ***************************************************************** ||");
                System.out.println(" || = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ||");
            }
            else if ((totalPrograms < 10) && (grandCourses >=10) ){
                System.out.println(" || = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ||");
                System.out.println(" || ***************************************************************** ||");
                System.out.printf(" || %-62s %d  ||%n", "Grand Program(s):", totalPrograms);
                System.out.printf(" || %-61s %d  ||%n", "Grand Course(s):", grandCourses);
                System.out.printf(" || %-54s RM %d.00 ||%n", "Grand Fees:", grandFees);
                System.out.println(" || ***************************************************************** ||");
                System.out.println(" || = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ||");
            }
            else if ((totalPrograms >= 10) && (grandCourses < 10) ){
                System.out.println(" || = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ||");
                System.out.println(" || ***************************************************************** ||");
                System.out.printf(" || %-61s %d  ||%n", "Grand Program(s):", totalPrograms);
                System.out.printf(" || %-62s %d  ||%n", "Grand Course(s):", grandCourses);
                System.out.printf(" || %-54s RM %d.00 ||%n", "Grand Fees:", grandFees);
                System.out.println(" || ***************************************************************** ||");
                System.out.println(" || = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ||");
            }

            else {
                System.out.println(" || = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ||");
                System.out.println(" || ***************************************************************** ||");
                System.out.printf(" || %-61s %d  ||%n", "Grand Program(s):", totalPrograms);
                System.out.printf(" || %-61s %d  ||%n", "Grand Course(s):", grandCourses);
                System.out.printf(" || %-54s RM %d.00 ||%n", "Grand Fees:", grandFees);
                System.out.println(" || ***************************************************************** ||");
                System.out.println(" || = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ||");
            }




            courseSemesterList.clear();

        } else {
            System.out.println("Semester not found.");
        }


        return " ";
    }

    //Report 2 Faculty
    public String report2(){
        System.out.println("Selected Choice: Course Management - Report2");
        facultyList.clear();

        for (Course faculty : courseProgramlist) {
            String currentFacultyName = faculty.getFacultyName();
            String courseNames = faculty.getCourseName();
            String programNames = faculty.getProgramName();
            int priceInt = faculty.getCoursePrice();

            facultyList.add(
                    "Faculty: " + currentFacultyName + ", Program: " + programNames +
                    ", Course: " + courseNames + ", Price: " + priceInt
            );

        }

        System.out.println(" ");
        System.out.println("The faculty list consists of: ");
        facultyList.sort();

        int numbering = 1;
        int grandCoursess = 0;
        int grandFaculty = 0;
        int grandProgrammes = 0;
        int pricePerFaculty = 0;
        int grandPrice = 0;

        int numberOfCoursess = 0;
        int numberOfPrograms = 0;
        int numberOfFaculties = 0;

        int totalCourses = 0;
        int totalProgram= 0;

        String previousFaculty = null;
        String previousProgram = null;


        System.out.println(" ");
        System.out.println("= = = = = = = = = = = = = = =");
        System.out.println("||**************************||");
        System.out.println("||                          ||");
        System.out.println("||         Report 2         ||");
        System.out.println("||                          ||");
        System.out.println("||**************************||");
        System.out.println("= = = = = = = = = = = = = = =");


        for(String facultyName : facultyList) {
            facultyListSort.addSame(facultyName);
            String faculty = extractFaculty(facultyName);
            String course = extractCourse2(facultyName);
            String program = extractProgram2(facultyName);
            String price = extractPrice2(facultyName);



            String format = "|| %1$-29s ||";
            //print out first faculty
            if (previousFaculty == null){
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("***********************************");
                System.out.println("|| = = = = = = = = = = = = = = = ||");
                System.out.println("||                               ||");
                System.out.printf(format + "%n", "      Faculty: " + faculty);
                System.out.println("||                               ||");
                System.out.println("|| = = = = = = = = = = = = = = = ||");
                System.out.println("***********************************");
                System.out.println("Program: " + program);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~ ");
                System.out.println(numbering + ") " + "Course: " + course
                        + ", Fees: RM " + price +".00 ");

                numbering++;
                numberOfFaculties++;
                numberOfPrograms++;
                numberOfCoursess++;

                int priceInt = Integer.parseInt(price);
                pricePerFaculty += priceInt;

                grandFaculty += numberOfFaculties;
                grandCoursess += numberOfCoursess;
                grandProgrammes += numberOfPrograms;


            }
            else if ((previousFaculty.equals(faculty)) && (previousProgram.equals(program))) {
                System.out.println(numbering + ") " + "Course: " + course
                        + ", Fees: RM " + price +".00 ");
                numberOfCoursess = 0;
                numberOfPrograms = 0;

                numbering++;
                numberOfCoursess++;
                int priceInt = Integer.parseInt(price);
                pricePerFaculty += priceInt;

                grandCoursess += numberOfCoursess;

            }

            else if ((previousFaculty.equals(faculty)) && (!previousProgram.equals(program))) {
                numbering = 1;
                numberOfCoursess = 0;
                numberOfPrograms = 0;


                System.out.println();
                System.out.println(" ");
                System.out.println("Program: " + program);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~ ");
                System.out.println(numbering + ") " + "Course: " + course
                            + ", Fees: RM " + price +".00 ");
                numbering++;
                int priceInt = Integer.parseInt(price);
                pricePerFaculty += priceInt;

                numberOfCoursess++;
                numberOfPrograms++;

                grandCoursess += numberOfCoursess;
                grandProgrammes += numberOfPrograms;


            }else {
                System.out.println(" ");
                System.out.println("####################################");
                System.out.println("====================================");
                System.out.println("Faculty: " + previousFaculty +
                        "\nTotal Program(s): " + grandProgrammes +
                        "\nTotal Course(s): " + grandCoursess +
                        "\nTotal Fee(s): RM " + pricePerFaculty + ".00");
                System.out.println("====================================");
                System.out.println("####################################");

                totalCourses += grandCoursess;
                totalProgram += grandProgrammes;
                grandPrice += pricePerFaculty;


                grandCoursess = 0;
                grandProgrammes = 0;
                grandFaculty = 0;

                numberOfCoursess = 0;
                numberOfPrograms = 0;
                pricePerFaculty = 0;
                numbering = 1;
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("***********************************");
                System.out.println("|| = = = = = = = = = = = = = = = ||");
                System.out.println("||                               ||");
                System.out.printf(format + "%n", "      Faculty: " + faculty);
                System.out.println("||                               ||");
                System.out.println("|| = = = = = = = = = = = = = = = ||");
                System.out.println("***********************************");
                System.out.println("Program: " + program);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~ ");
                System.out.println(numbering + ") " + "Course: " + course
                        + ", Fees: RM " + price +".00 ");

                numbering++;
                numberOfCoursess++;
                numberOfPrograms++;
                numberOfFaculties++;


                int priceInt = Integer.parseInt(price);
                pricePerFaculty += priceInt;

                grandFaculty += numberOfFaculties;
                grandCoursess += numberOfCoursess;
                grandProgrammes += numberOfPrograms;



            }


            previousFaculty = faculty;
            previousProgram = program;

        }
        grandPrice += pricePerFaculty;
        totalCourses += grandCoursess;
        totalProgram += grandProgrammes;

        System.out.println(" ");
        System.out.println("####################################");
        System.out.println("====================================");
        System.out.println("Faculty: " + previousFaculty +
                "\nTotal Program(s): " + grandProgrammes +
                "\nTotal Course(s): " + grandCoursess +
                "\nTotal Fee(s): RM " + pricePerFaculty + ".00");
        System.out.println("====================================");
        System.out.println("####################################");
        System.out.println(" ");

            //Now Summarise Table
            if ((totalProgram < 10) && (totalCourses < 10)) {
                System.out.println(" || = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ||");
                System.out.println(" || ***************************************************************** ||");
                System.out.printf(" || %-62s %d  ||%n", "Grand Number of Faculty(s):", grandFaculty);
                System.out.printf(" || %-62s %d  ||%n", "Grand Numberr of Program(s):", totalProgram);
                System.out.printf(" || %-62s %d  ||%n", "Grand Number of Course(s):", totalCourses);
                System.out.printf(" || %-53s RM %d.00 ||%n", "Total Fees:", grandPrice);
                System.out.println(" || ***************************************************************** ||");
                System.out.println(" || = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ||");
            } else if ((totalProgram < 10) && (totalCourses >= 10)) {
                System.out.println(" || = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ||");
                System.out.println(" || ***************************************************************** ||");
                System.out.printf(" || %-62s %d  ||%n", "Grand Number of Faculty(s):", grandFaculty);
                System.out.printf(" || %-62s %d  ||%n", "Grand Number of Program(s):", totalProgram);
                System.out.printf(" || %-61s %d  ||%n", "Grand Number of Course(s):", totalCourses);
                System.out.printf(" || %-53s RM %d.00 ||%n", "Total Fees:", grandPrice);
                System.out.println(" || ***************************************************************** ||");
                System.out.println(" || = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ||");
            } else if ((totalProgram >= 10) && (totalCourses < 10)) {
                System.out.println(" || = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ||");
                System.out.println(" || ***************************************************************** ||");
                System.out.printf(" || %-62s %d  ||%n", "Grand Number of Faculty(s):", grandFaculty);
                System.out.printf(" || %-61s %d  ||%n", "Grand Number of Program(s):", totalProgram);
                System.out.printf(" || %-62s %d  ||%n", "Grand Number of Course(s):", totalCourses);
                System.out.printf(" || %-53s RM %d.00 ||%n", "Total Fees:", grandPrice);
                System.out.println(" || ***************************************************************** ||");
                System.out.println(" || = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ||");
            } else {
                System.out.println(" || = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ||");
                System.out.println(" || ***************************************************************** ||");
                System.out.printf(" || %-62s %d  ||%n", "Grand Number of Faculty(s):", grandFaculty);
                System.out.printf(" || %-61s %d  ||%n", "Grand Number of Program(s):", totalProgram);
                System.out.printf(" || %-61s %d  ||%n", "Grand Number of Course(s):", totalCourses);
                System.out.printf(" || %-53s RM %d.00 ||%n", "Total Fees:", grandPrice);
                System.out.println(" || ***************************************************************** ||");
                System.out.println(" || = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ||");
            }


        facultyList.clear();
        feesLists.clear();
        return " ";
    }


}
