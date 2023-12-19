package execise1;

import java.text.MessageFormat;

public class Student extends Person {
    private String program;
    private int year;
    private double fee;


    public Student(String name, String address, String program, int year, double fee) {
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return MessageFormat.format("execise1.Student{0}, program={1}, year={2}, fee={3}", super.toString(), this.program, this.year, this.fee);
    }
}
