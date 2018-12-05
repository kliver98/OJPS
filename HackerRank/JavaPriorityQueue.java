/**
 * @author Kliver Daniel
 */
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
/*
 * Create the Student and Priorities classes here.
 */
class Student implements Comparable<Student> {
    Integer id;
    String name;
    Double cgpa;
    public Student(Integer i, String n, Double c) {
        id = i;
        name = n;
        cgpa = c;
    }
    @Override
    public int compareTo(Student o) {
        int k = o.cgpa.compareTo(cgpa);
        if (k==0) {
            k = name.compareTo(o.name);
            if (k==0)
                k = id.compareTo(o.id);
        }
        return k;
    }
    public String getName() {
        return name;
    }
}

class Priorities {
    public Priorities(){}
    public List<Student> getStudents(List<String> events) {
        List<Student> rst = new ArrayList<Student>();
        PriorityQueue<Student> pq = new PriorityQueue<Student>();
        for (String str: events) {
            if (!str.equalsIgnoreCase("SERVED")) {
                String[] d = str.split(" ");
                Student tmp = new Student(Integer.parseInt(d[3]),d[1],Double.parseDouble(d[2]));
                pq.offer(tmp);
            } else
               pq.poll(); 
        }
        while (!pq.isEmpty()) {
            rst.add(pq.poll());
        }
        return rst;
    }
}