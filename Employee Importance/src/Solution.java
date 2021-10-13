import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

class Solution {

    HashMap<Integer, Employee> employeeHashMap;

    public int getImportance(List<Employee> employees, int id) {
        employeeHashMap = new HashMap<>();
        for (Employee employee: employees) {
            employeeHashMap.put(employee.id, employee);
        }
        return getImportanceHelper(id);
    }

    public int getImportanceHelper(int id) {
        List<Integer> list = new ArrayList<>();
        list.add(id);
        int importance = 0;
        while (!list.isEmpty()) {
            importance += employeeHashMap.get(list.get(0)).importance;
            for (int tmp : employeeHashMap.get(list.get(0)).subordinates) {
                list.add(tmp);
            }
            list.remove(0);
        }
        return importance;
    }

//    public int getImportanceHelper(int id) {
//        int importance = 0;
//        importance += employeeHashMap.get(id).importance;
//        for (int sub: employeeHashMap.get(id).subordinates) {
//            importance += getImportanceHelper(sub);
//        }
//        return importance;
//    }
}
