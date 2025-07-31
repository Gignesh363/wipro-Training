package wiprotraining;

import java.util.*;

class MyEmployee {
    int id;
    String name;
    double salary;

    public MyEmployee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

class Repository<T, ID> {
    private Map<ID, T> store = new HashMap<>();

    public void save(ID id, T entity) {
        store.put(id, entity);
    }

    public T findById(ID id) {
        return store.get(id);
    }

    public List<T> findAll() {
        return new ArrayList<>(store.values());
    }

    public void deleteById(ID id) {
        store.remove(id);
    }
}

public class Fourtysix {
    public static void main(String[] args) {
        Repository<MyEmployee, Integer> employeeRepo = new Repository<>();

        employeeRepo.save(1, new MyEmployee(1, "Ravi", 50000));
        employeeRepo.save(2, new MyEmployee(2, "Anjali", 60000));
        employeeRepo.save(3, new MyEmployee(3, "Kiran", 55000));

        System.out.println("All Employees:");
        for (MyEmployee e : employeeRepo.findAll()) {
            System.out.println(e);
        }

        System.out.println("\nFind Employee with ID 2:");
        System.out.println(employeeRepo.findById(2));

        employeeRepo.deleteById(1);
        System.out.println("\nAfter deleting employee with ID 1:");
        for (MyEmployee e : employeeRepo.findAll()) {
            System.out.println(e);
        }
    }
}
//output:-
//All Employees:
//ID: 1, Name: Ravi, Salary: 50000.0
//ID: 2, Name: Anjali, Salary: 60000.0
//ID: 3, Name: Kiran, Salary: 55000.0
//
//Find Employee with ID 2:
//ID: 2, Name: Anjali, Salary: 60000.0
//
//After deleting employee with ID 1:
//ID: 2, Name: Anjali, Salary: 60000.0
//ID: 3, Name: Kiran, Salary: 55000.0
