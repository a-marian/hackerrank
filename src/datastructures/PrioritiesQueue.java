package datastructures;

import java.util.*;

/*
     * Create the Student and Priorities classes here.
     */
    class Student {
        String name;
        double cgpa;
        int id;

    public Student(String name, double cgpa, int id) {
        this.name = name;
        this.cgpa = cgpa;
        this.id = id;
    }

    public double getCgpa() {
            return cgpa;
        }

        public int getId(){
            return  id;
        }

        public String getName(){
            return name;
        }

    }

    class Priorities{

        List<Student> getStudents(List<String> events){

            PriorityQueue<Student> studentsQueue =
                    new PriorityQueue<>(Comparator.comparing(Student::getCgpa).reversed()
                    .thenComparing(Student::getName).thenComparing(Student::getId));

            for (String event: events){
                String [] studentEv = event.split(" ");
                if(studentEv.length > 1){
                    Student student = new Student(studentEv[1], Double.valueOf(studentEv[2]), Integer.valueOf(studentEv[3]));
                    studentsQueue.add(student);
                }
                else {
                   studentsQueue.poll();
                }
            }
            while(studentsQueue.size()>1){
                System.out.println(studentsQueue.poll().name);
            }
            return new ArrayList<Student>(studentsQueue);
        }
    }


    public class PrioritiesQueue {
        private final static Scanner scan = new Scanner(System.in);
        private final static Priorities priorities = new Priorities();

        public static void main(String[] args) {
            int totalEvents = Integer.parseInt(scan.nextLine());
            List<String> events = new ArrayList<>();

            while (totalEvents-- != 0) {
                String event = scan.nextLine();
                events.add(event);
            }

            List<Student> students = priorities.getStudents(events);

            if (students.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                for (Student st: students) {
                    System.out.println(st.getName());
                }
            }
        }
    }

