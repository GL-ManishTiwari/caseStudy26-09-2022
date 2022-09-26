package com.casestudies;

import java.util.*;

public class StaffMain {
    public static Double totalCalculation(Applicant applicant) throws MarksException {
        double tot = 0.0;
        double m1 = applicant.getSubject1Mark();
        double m2 = applicant.getSubject2Mark();
        double m3 = applicant.getSubject3Mark();

        if (m1 < 0 || m2 < 0 || m3 < 0 || m1 > 100 || m2 > 100 || m3 > 100) {
            throw new MarksException("Invalid Marks");
        } else if (m1 < 50 || m2 < 50 || m3 < 50) {
            tot = 0.0;
            return tot;
        } else {
            tot = m1 + m2 + m3;
            return tot;
        }

    }

    public static Double percentageCalculation(Double total) {
        double perc = (total / 300) * 100;
        return perc;
    }

    public static void main(String[] args) {
        System.out.println("Enter number of Applicant details you want to enter:");
        Scanner sc = new Scanner(System.in);
        int appNo = Integer.parseInt(sc.nextLine());
        if (appNo <= 0) {
            System.out.println("Invalid output");
            System.exit(-1);
        } else {
            Applicant[] app = new Applicant[appNo];
            for (int i = 0; i < appNo; i++) {
                System.out.println("Enter details of Applicant " + (i + 1) + ": ");
                String appDetails = sc.nextLine();
                String appInfo[] = appDetails.split(",");
                String appName = appInfo[0];
                double m1 = Double.parseDouble(appInfo[1]);
                double m2 = Double.parseDouble(appInfo[2]);
                double m3 = Double.parseDouble(appInfo[3]);

                Applicant appTemp = new Applicant();
                appTemp.setSubject1Mark(m1);
                appTemp.setSubject2Mark(m2);
                appTemp.setSubject3Mark(m3);
                Double total = totalCalculation(appTemp);
                Double perc = percentageCalculation(total);
                app[i] = new Applicant(appName, m1, m2, m3, total, perc);
            }
            System.out.println("\nApplicant Score\n");
            System.out.println(String.format("%-5s %-10s %-5s %-5s %-5s %-10s %-10s", "id", "name", "Mark 1", "Mark 2",
                    "Mark 3", "total", "percentage"));
            for (int i = 0; i < appNo; i++) {
                System.out.println(app[i]);
            }

        }
        sc.close();
    }
}
