package interface_comparable.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import interface_comparable.entities.Employee;

public class Program {
	
	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<>();
		String path = "file_folders_example/names_csv_format.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			String employeeCsv = br.readLine();
			while(employeeCsv != null) {
				String[] fields = employeeCsv.split(",");
				list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
				employeeCsv = br.readLine();
			}
			Collections.sort(list);
			for (Employee s : list) {
				System.out.println(s.getName() + " - " + s.getSalary());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage() + e);
		}
	}
}