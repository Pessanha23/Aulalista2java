import java.util.*;


public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int cont = 1;

        List<Employee> list = new ArrayList<>();

        System.out.print("How to many employees will be registered ?");
        Integer n = Integer.valueOf(sc.nextLine());
        while (n == 0) {
            System.out.println("Id already taken!! TRY AGAIN BABY");
            n = Integer.valueOf(sc.nextLine());
        }

        for (int i = 1; i <= n; i++) {

            // usado metódo valueof para desbugar o recebimento das respostas do inteiro e do double
            System.out.println("NAME:");
            String name = sc.nextLine();
            while (hasID(list, name)) {
                System.out.println("Id already taken!! TRY AGAIN BABY");
                name = sc.nextLine();
            }

            System.out.println("SALARY:");
            Double salary = Double.valueOf(sc.nextLine());
            /**
             * 1° - usar o tamanho da list.size para contar;
             * 2° - usar o cont++ (contador padrão);
             * 3° - usar o i que já faz a função de contagem;
              */
            Integer size = list.size();
            Integer id = size+1;

            Employee emp = new Employee(name, id, salary);

            list.add(emp);
        }

        System.out.println();
        System.out.println("Enter the employee name that will have salary down increase ?");
        String dbname = sc.nextLine();

        Employee emp = list.stream().filter(x -> (x.getName().equalsIgnoreCase(dbname))).findFirst().orElse(null);

        if (emp == null) {
            System.out.println("This name is not exist");
        } else {
            System.out.println("Enter the percentage downgrade in salary");
            double percent = sc.nextDouble();

            emp.increaseSalary(percent);
        }

        System.out.println();
        System.out.println("List of employee");
        for (Employee employee : list) {
            System.out.println(employee);
        }

        sc.close();
    }

    public static boolean hasID(List<Employee> list, String name) {
        Employee emp = list.stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
        return emp != null;
    }

}
