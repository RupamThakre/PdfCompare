package com.pdfCompare.compare;

import de.redsix.pdfcompare.PdfComparator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class CompareApplication {

	public static void main(String[] args) throws IOException {
		boolean isEquals = false;
		try
		{
			File file1 = new File("src/main/resources/actual.pdf");
			File file2 = new File("src/main/resources/expected.pdf");
			try {
				isEquals = new PdfComparator(file1, file2).compare()
						.writeTo("src/main/resources/Result/"+"CompareResult");

			} catch (IOException e) {
				e.printStackTrace();
			}
			if (!isEquals) {
				System.out.println("Differences found!");
			}
			if (isEquals) {
				System.out.println("Differences not found!");
			}
		}
		catch(Exception e){
		}
	}
}
