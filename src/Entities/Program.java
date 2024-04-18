package Entities;

import ADT.CLinkedList;
import ADT.CircularListInterface;

public class Program implements Comparable<Program>, DataClass {

    private String programName;
    private CircularListInterface<String> programList = new CLinkedList<>();

    public String toString() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");
        jsonBuilder.append("\"programName\": \"").append(programName).append("\", ");
        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }


    @Override
    public int compareTo(Program other) {
        int result = this.programName.compareTo(other.getProgramName());
        if (result == 0) {
            System.out.println("Course names are equal");
            return 0;
        } else if (result < 0) {
            System.out.println("This course name is less than the other course name");
            return -1;
        } else {
            System.out.println("This course name is greater than the other course name");
            return 1;
        }
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Program program = (Program) obj;
        return programName.equals(program.programName) ;
    }

    public Program(String programName) {
        this.programName = programName;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public CircularListInterface<String> getProgramList() {
        return programList;
    }

    public void setProgramList(CircularListInterface<String> programList) {
        this.programList = programList;
    }


}
