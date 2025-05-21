public class Mark {
    private int studentId;
    private int courseId;
    private int mark;

    public Mark(int studentId, int courseId, int mark) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.mark = mark;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "studentId=" + studentId +
                ", courseId=" + courseId +
                ", mark=" + mark +
                '}';
    }
}
