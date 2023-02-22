package prod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MapStudy {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Map<String, Integer> candidato = new LinkedHashMap<>();

		System.out.println("Enter file path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				Integer votes = Integer.parseInt(fields[1]);

				if (candidato.containsKey(name)) {
					int votesTot = candidato.get(name);
					candidato.put(name, votes);

				} else {
					candidato.put(name, votes);
				}
				line = br.readLine();

			}
			for (String key : candidato.keySet()) {
				System.out.println(key + ": " + candidato.get(key));
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
